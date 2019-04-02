package work.icql.springboot.common.enums;

import org.springframework.http.HttpStatus;

/**
 * @author icql
 * @version 1.0
 * @date 2018/11/29 11:15
 * @Title ResultCode
 * @Description API 统一返回状态码
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(200, "成功", HttpStatus.OK),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效", HttpStatus.BAD_REQUEST),
    PARAM_IS_BLANK(10002, "参数为空", HttpStatus.BAD_REQUEST),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误", HttpStatus.BAD_REQUEST),
    PARAM_NOT_COMPLETE(10004, "参数缺失", HttpStatus.BAD_REQUEST),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录", HttpStatus.UNAUTHORIZED),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误", HttpStatus.UNAUTHORIZED),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用", HttpStatus.UNAUTHORIZED),
    USER_NOT_EXIST(20004, "用户不存在", HttpStatus.UNAUTHORIZED),
    USER_HAS_EXISTED(20005, "用户已存在", HttpStatus.UNAUTHORIZED),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题", HttpStatus.BAD_REQUEST),

    /* 数据错误：40001-49999 */
    DATA_IS_NONE(40001, "数据未找到", HttpStatus.BAD_REQUEST),
    DATA_IS_WRONG(40002, "数据有误", HttpStatus.BAD_REQUEST),
    DATA_IS_EXISTED(40003, "数据已存在", HttpStatus.BAD_REQUEST),
    DATA_IS_UPDATED(40004, "数据已被更新", HttpStatus.BAD_REQUEST),

    /* 系统错误：50001-59999 */
    SYSTEM_INNER_ERROR(50001, "系统繁忙，请稍后重试", HttpStatus.BAD_REQUEST),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常", HttpStatus.BAD_REQUEST),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常", HttpStatus.BAD_REQUEST),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问", HttpStatus.BAD_REQUEST),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效", HttpStatus.BAD_REQUEST),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时", HttpStatus.BAD_REQUEST),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高", HttpStatus.BAD_REQUEST),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限", HttpStatus.BAD_REQUEST);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;

    ResultCode(Integer code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public HttpStatus httpStatus() {
        return this.httpStatus;
    }
}
