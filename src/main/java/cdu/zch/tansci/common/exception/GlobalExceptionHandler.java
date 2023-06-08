package cdu.zch.tansci.common.exception;

import cdu.zch.tansci.common.WrapMapper;
import cdu.zch.tansci.common.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zch
 * @data 2023/6/8
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Wrapper handleException(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            log.error("系统自定义业务异常：{}", ex.getMessage());
            return WrapMapper.wrap(ex.getCode(), ex.getMessage(), null);
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            log.error("参数校验异常：{}", ex.getBindingResult().getFieldError().getDefaultMessage());
            return WrapMapper.wrap(Wrapper.ILLEGAL_ARGUMENT_CODE_, "参数有误：" + ex.getBindingResult().getFieldError().getDefaultMessage(), null);
        } else {
            log.error("统一系统异常：{}", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE, null);
        }
    }

}
