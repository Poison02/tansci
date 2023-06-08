package cdu.zch.tansci.utils;

import com.alibaba.fastjson.JSONObject;
import cdu.zch.tansci.domain.system.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/8
 **/
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";

    private static final String ISS = "echisan";

    // 角色的key
    private static final String ROLE_CLAIMS = "rol";

    // 用户信息key
    private static final String USER_CLAIMS = "user";

    // 过期时间是3600*4秒，既4个小时
    private static final long EXPIRATION = 14400L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;


    public static String createToken(SysUser user, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        Map<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, user.getRole());
        map.put(USER_CLAIMS, user);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }


    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }


    public static String getUserRole(String token) {
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }


    public static SysUser getUser(String token) {
        Object obj = getTokenBody(token).get(USER_CLAIMS);
        return JSONObject.parseObject(JSONObject.toJSONBytes(obj), SysUser.class);
    }


    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }

    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
