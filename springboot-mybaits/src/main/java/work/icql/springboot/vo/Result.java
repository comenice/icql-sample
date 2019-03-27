package work.icql.springboot.vo;

/**
 * @author icql
 * @version 1.0
 * @date 2018/11/24 10:14
 * @Title Result
 * @Description Result
 */
public class Result {
    private boolean success;//是否成功
    private Integer code;// 返回码
    private String msg;//返回信息
    private Object data;// 返回数据

    public static Result ok(Object data) {
        return ok("请求成功", data);
    }

    public static Result ok(String msg, Object data) {
        return build(true, ResultCode.CODE_200, msg, data);
    }

    public static Result serverError(String msg) {
        return error(ResultCode.CODE_500, msg);
    }

    public static Result error(ResultCode code, String msg) {
        return build(false, code, msg, null);
    }

    public static Result build(boolean success, ResultCode code, String msg) {
        return build(success, code, msg, null);
    }

    public static Result build(boolean success, ResultCode code, String msg, Object data) {
        return new Result(success, code, msg, data);
    }

    private Result(boolean success, ResultCode code, String msg, Object data) {
        this.success = success;
        this.code = Integer.valueOf(code.toString());
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
