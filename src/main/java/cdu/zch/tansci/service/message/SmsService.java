package cdu.zch.tansci.service.message;

import cdu.zch.tansci.domain.message.dto.MessageDto;
import cdu.zch.tansci.domain.message.dto.SmsTemplateDto;
import cdu.zch.tansci.domain.message.vo.MessageVo;

/**
 * @ClassName： SmsService.java
 * @ClassPath： com.tansci.service.message.SmsService.java
 * @Description： 短信
 * @Author： tanyp
 * @Date： 2021/6/7 10:56
 **/
public interface SmsService {

    MessageVo send(MessageDto dto);

    MessageVo addSmsTemplate(SmsTemplateDto template);

    MessageVo deleteSmsTemplate(SmsTemplateDto template);

    MessageVo modifySmsTemplate(SmsTemplateDto template);

    MessageVo querySmsTemplate(SmsTemplateDto template);

}
