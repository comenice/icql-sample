package work.icql.springboot.common.exception;

import work.icql.springboot.common.enums.ResultCode;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/29 15:33
 * @Title ParamInvalidException
 * @Description ParamInvalidException
 */
public class ParamInvalidException extends ServiceException {

    @Override
    public ResultCode getResultCode() {
        return ResultCode.PARAM_IS_INVALID;
    }

    public ParamInvalidException() {
    }

    public ParamInvalidException(String message) {
        super(message);
    }

    public ParamInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamInvalidException(Throwable cause) {
        super(cause);
    }

    public ParamInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}