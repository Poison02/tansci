package cdu.zch.tansci.security;

import com.alibaba.fastjson.JSONObject;
import cdu.zch.tansci.common.WrapMapper;
import cdu.zch.tansci.common.constant.Enums;
import cdu.zch.tansci.common.exception.BusinessException;
import cdu.zch.tansci.domain.system.SysUser;
import cdu.zch.tansci.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * @author Zch
 * @data 2023/6/8
 **/
@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if (token == null || !token.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            onSuccessfulAuthentication(request, response, authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            onUnsuccessfulAuthentication(request, response, new AccountExpiredException(Enums.AUTH_NO_TOKEN.getValue()));
        }
    }

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        log.info("=============Token 验证成功=================");
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        log.error("================token校验失败=======================");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSONObject.toJSONString(WrapMapper.error(HttpServletResponse.SC_UNAUTHORIZED, failed.getMessage())));
    }



    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        boolean expiration = JwtTokenUtils.isExpiration(token);
        if (expiration) {
            throw new BusinessException(Enums.AUTH_NO_TOKEN.getValue());
        } else {
            String username = JwtTokenUtils.getUsername(token);
            String role = JwtTokenUtils.getUserRole(token);
            SysUser user = JwtTokenUtils.getUser(token);
            if (username != null) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, Collections.singleton(new SimpleGrantedAuthority(role)));
                authenticationToken.setDetails(user);
                return authenticationToken;
            }
        }
        return null;
    }

}
