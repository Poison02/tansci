package cdu.zch.tansci.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信配置
 * @author 20698
 */
@Data
@Component
public class SmsConfig {

    @Value("${sms.access-id}")
    private String accessId;

    @Value("${sms.access-key}")
    private String accessKey;

    @Value("${sms.sign-name}")
    private String signName;

    @Value("${sms.endpoint}")
    private String endpoint;

}
