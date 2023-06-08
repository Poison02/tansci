package cdu.zch.tansci.common.constant;

/**
 * @author Zch
 * @data 2023/6/8
 **/
public class Constants {

    /*
    系统状态
     */
    public final static Integer SUCCESS = 200;

    public final static String SUCCESS_MESSAGE = "操作成功！";

    public final static Integer ERROR = 500;

    public final static String ERROR_MESSAGE = "操作失败！";

    public final static String PARAMETER_ERROR = "请求参数有误，请核查！";

    /*
    未删除状态
     */
    public final static Integer NOT_DEL_FLAG = 0;

    /*
    已删除状态
     */
    public final static Integer IS_DEL_FLAG = 1;

    /**
     * 接口类型
     */
    public final static String SELECT = "SELECT";

    public final static String INSERT = "INSERT";

    public final static String UPDATE = "INSERT";

    public final static String DELETE = "DELETE";

    /**
     * 消息发送状态码
     */
    public final static String NEWS_SUCCESS_CODE = "OK";

    public final static String NEWS_SUCCESS_MESSAGE = "发送成功";

    public final static String NEWS_FAIL_CODE = "FAIL";

    public final static String NEWS_FAIL_MESSAGE = "发送失败";

    /**
     * 任务调度默认启动10个线程
     */
    public final static Integer DEFAULT_THREAD_POOL = 10;

}
