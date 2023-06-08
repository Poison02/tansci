package cdu.zch.tansci.common.exception;

import lombok.Getter;

/**
 * @author Zch
 * @data 2023/6/8
 **/
@Getter
public class BusinessException extends RuntimeException{

    /*
    异常码
     */
    private Integer code = 500;

    /*
    异常描述
     */
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }
}
