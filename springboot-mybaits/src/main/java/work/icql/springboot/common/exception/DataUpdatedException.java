package work.icql.springboot.common.exception;

import work.icql.springboot.common.enums.ResultCode;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/31 16:58
 * @Title DataUpdatedException
 * @Description DataUpdatedException
 */
public class DataUpdatedException extends ServiceException {
    @Override
    public ResultCode getResultCode() {
        return ResultCode.DATA_IS_UPDATED;
    }

    public DataUpdatedException() {
    }

    public DataUpdatedException(String message) {
        super(message);
    }

    public DataUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataUpdatedException(Throwable cause) {
        super(cause);
    }

    public DataUpdatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
