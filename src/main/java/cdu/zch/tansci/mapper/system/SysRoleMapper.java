package cdu.zch.tansci.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cdu.zch.tansci.domain.system.SysMenuRole;
import cdu.zch.tansci.domain.system.SysRole;
import cdu.zch.tansci.domain.system.vo.SysMenuRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName： SysRoleMapper.java
 * @ClassPath： com.tansci.mapper.SysRoleMapper.java
 * @Description： 角色
 * @Author： tanyp
 * @Date： 2021/7/20 16:58
 **/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysMenuRoleVo> menuRoleList(SysMenuRole role);

}
