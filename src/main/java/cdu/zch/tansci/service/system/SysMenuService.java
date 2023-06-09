package cdu.zch.tansci.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import cdu.zch.tansci.domain.system.SysMenu;
import cdu.zch.tansci.domain.system.dto.SysMenuDto;

import java.util.List;

/**
 * @ClassName： SysMenuService.java
 * @ClassPath： com.tansci.service.SysMenuService.java
 * @Description： 菜单
 * @Author： tanyp
 * @Date： 2021/7/20 17:01
 **/
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> list(SysMenuDto dto);

    boolean save(SysMenu sysMenu);

    boolean del(Integer id);
}
