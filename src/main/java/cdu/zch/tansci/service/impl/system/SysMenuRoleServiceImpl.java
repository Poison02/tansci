package cdu.zch.tansci.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cdu.zch.tansci.domain.system.SysMenuRole;
import cdu.zch.tansci.mapper.system.SysMenuRoleMapper;
import cdu.zch.tansci.service.system.SysMenuRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName： SysMenuRoleServiceImpl.java
 * @ClassPath： com.tansci.service.impl.SysMenuRoleServiceImpl.java
 * @Description： 菜单角色
 * @Author： tanyp
 * @Date： 2021/7/20 17:03
 **/
@Slf4j
@Service
public class SysMenuRoleServiceImpl extends ServiceImpl<SysMenuRoleMapper, SysMenuRole> implements SysMenuRoleService {
}
