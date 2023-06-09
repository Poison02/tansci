package cdu.zch.tansci.service.message;

import cdu.zch.tansci.domain.message.dto.MessageDto;
import cdu.zch.tansci.domain.message.vo.MessageVo;

/**
 * @ClassName： MailService.java
 * @ClassPath： com.tansci.service.message.MailService.java
 * @Description： 邮件
 * @Author： tanyp
 * @Date： 2021/6/7 9:18
 **/
public interface MailService {

    MessageVo sendSimple(MessageDto dto);

    MessageVo sendAttachFile(MessageDto dto);

    MessageVo sendImgRes(MessageDto dto);

}
