package work.icql.springboot.common.exception;

import work.icql.springboot.common.enums.ResultCode;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/30 11:26
 * @Title IBindResultCode
 * @Description 异常需要绑定ResultCode
 */
public interface IBindResultCode {
    ResultCode getResultCode();
}
