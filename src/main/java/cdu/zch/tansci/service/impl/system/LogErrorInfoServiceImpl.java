package cdu.zch.tansci.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cdu.zch.tansci.domain.system.LogErrorInfo;
import cdu.zch.tansci.mapper.system.LogErrorInfoMapper;
import cdu.zch.tansci.service.system.LogErrorInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @path：com.tansci.service.impl.LogErrorInfoServiceImpl.java
 * @className：LogErrorInfoServiceImpl.java
 * @description：操作日志
 * @author：tanyp
 * @dateTime：2021/11/18 13:51
 * @editNote：
 */
@Slf4j
@Service
public class LogErrorInfoServiceImpl extends ServiceImpl<LogErrorInfoMapper, LogErrorInfo> implements LogErrorInfoService {
}
