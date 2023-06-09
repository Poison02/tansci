package cdu.zch.tansci.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import cdu.zch.tansci.domain.system.SysDic;
import cdu.zch.tansci.domain.system.dto.SysDicDto;

import java.util.List;

/**
 * @path：com.tansci.service.SysDicService.java
 * @className：SysDicService.java
 * @description：字典
 * @author：tanyp
 * @dateTime：2021/7/4 13:39
 * @editNote：
 */
public interface SysDicService extends IService<SysDic> {

    List<SysDic> dicList(SysDicDto dto);

    boolean del(Integer id);
}
