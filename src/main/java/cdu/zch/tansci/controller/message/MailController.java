package cdu.zch.tansci.controller.message;

import cdu.zch.tansci.common.WrapMapper;
import cdu.zch.tansci.common.Wrapper;
import cdu.zch.tansci.common.annotation.Log;
import cdu.zch.tansci.common.constant.Constants;
import cdu.zch.tansci.domain.message.dto.MessageDto;
import cdu.zch.tansci.domain.message.vo.MessageVo;
import cdu.zch.tansci.service.message.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： MailController.java
 * @ClassPath： com.tansci.controller.message.MailController.java
 * @Description： 邮件
 * @Author： tanyp
 * @Date： 2021/6/7 9:17
 **/
@Slf4j
@RestController
@RequestMapping("/mail")
@Api(value = "mail", tags = "邮件模板")
public class MailController {

    @Autowired
    private MailService mailService;

    @ApiOperation(value = "普通邮件发送", notes = "普通邮件发送")
    @Log(modul = "邮件-普通邮件发送", type = Constants.INSERT, desc = "普通邮件发送")
    @PostMapping("/sendSimple")
    public Wrapper<MessageVo> sendSimple(@RequestBody MessageDto dto) {
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, mailService.sendSimple(dto));
    }

    @ApiOperation(value = "带附件的邮件", notes = "带附件的邮件")
    @Log(modul = "邮件-带附件的邮件", type = Constants.INSERT, desc = "带附件的邮件")
    @PostMapping("/sendAttachFile")
    public Wrapper<MessageVo> sendAttachFile(@RequestBody MessageDto dto) {
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, mailService.sendAttachFile(dto));
    }

    @ApiOperation(value = "带图片资源的邮件", notes = "带图片资源的邮件")
    @Log(modul = "邮件-带图片资源的邮件", type = Constants.INSERT, desc = "带图片资源的邮件")
    @PostMapping("/sendImgRes")
    public Wrapper<MessageVo> sendImgRes(@RequestBody MessageDto dto) {
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, mailService.sendImgRes(dto));
    }

}
