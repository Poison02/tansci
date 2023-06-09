package cdu.zch.tansci.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cdu.zch.tansci.domain.system.SysUserOrg;
import cdu.zch.tansci.mapper.system.SysUserOrgMapper;
import cdu.zch.tansci.service.system.SysUserOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName： SysUserOrgServiceImpl.java
 * @ClassPath： com.tansci.service.impl.SysUserOrgServiceImpl.java
 * @Description： 用户组织
 * @Author： tanyp
 * @Date： 2021/12/15 10:15
 **/
@Slf4j
@Service
public class SysUserOrgServiceImpl extends ServiceImpl<SysUserOrgMapper, SysUserOrg> implements SysUserOrgService {
}
