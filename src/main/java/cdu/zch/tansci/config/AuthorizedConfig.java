package cdu.zch.tansci.config;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 三方授权登录
 * @author 20698
 */
@Data
@Component
public class AuthorizedConfig implements InitializingBean {

    /**
     * 微信配置
     */

    // appid
    @Value("${authorized.wechat.app-id}")
    private String wxAppId;

    // appsecret
    @Value("${authorized.wechat.app-secret}")
    private String wxAppSecret;

    // 微信开放平台授权baseUrl
    @Value("${authorized.wechat.base-url}")
    private String wxBaseUrl;

    // 微信开放平台获取token
    @Value("${authorized.wechat.base-access-token-url}")
    private String wxBaseAccessTokenUrl;

    // 微信开放平台获取用户信息
    @Value("${authorized.wechat.base-user-info-url}")
    private String wxBaseUserInfoUrl;

    // 重定向ur
    @Value("${authorized.wechat.redirect-url}")
    private String wxRedirectUrl;

    public static String WX_APP_ID;
    public static String WX_APP_SECRET;
    public static String WX_BASE_URL;
    public static String WX_BASE_ACCESS_TOKEN_URL;
    public static String WX_BASE_USER_INFO_URL;
    public static String WX_REDIRECT_URL;

    @Override
    public void afterPropertiesSet() throws Exception {
        WX_APP_ID = wxAppId;
        WX_APP_SECRET = wxAppSecret;
        WX_BASE_URL = wxBaseUrl;
        WX_BASE_ACCESS_TOKEN_URL = wxBaseAccessTokenUrl;
        WX_BASE_USER_INFO_URL = wxBaseUserInfoUrl;
        WX_REDIRECT_URL = wxRedirectUrl;
    }

}
