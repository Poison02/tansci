package cdu.zch.tansci.service.impl.message;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cdu.zch.tansci.common.constant.Enums;
import cdu.zch.tansci.domain.message.TemplateDetails;
import cdu.zch.tansci.mapper.message.TemplateDetailsMapper;
import cdu.zch.tansci.service.message.TemplateDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName： TemplateDetailsServiceImpl.java
 * @ClassPath： com.tansci.service.impl.message.TemplateDetailsServiceImpl.java
 * @Description： 模板详情
 * @Author： tanyp
 * @Date： 2021/6/7 18:08
 **/
@Slf4j
@Service
public class TemplateDetailsServiceImpl extends ServiceImpl<TemplateDetailsMapper, TemplateDetails> implements TemplateDetailsService {

    @Override
    public IPage<TemplateDetails> page(Page page, TemplateDetails details) {
        IPage<TemplateDetails> iPage = this.baseMapper.selectPage(page,
                Wrappers.lambdaQuery()
        );

        if (Objects.nonNull(iPage.getRecords()) && iPage.getRecords().size() > 0) {
            iPage.getRecords().forEach(item -> {
                item.setStateName(Objects.nonNull(item.getState()) ? Enums.getValueByGroup(item.getState(), "message_log_status") : null);
            });
        }
        return iPage;
    }

}
