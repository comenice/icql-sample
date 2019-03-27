package work.icql.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import work.icql.springboot.vo.Result;
import work.icql.springboot.vo.ResultCode;

import javax.validation.ValidationException;
import java.util.List;

/**
 * @author icql
 * @version 1.0
 * @date 2018/11/24
 * @Title ExceptionConfig
 * @Description ExceptionConfig
 */
@RestControllerAdvice
public class ExceptionConfig {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        String msg = "";
        ResultCode code = null;
        //controller：bean参数验证失败
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            if (fieldErrors != null && fieldErrors.size() > 0) {
                //由于开启了快速失败返回模式，只取第一个
                msg = fieldErrors.get(0).getDefaultMessage();
            }
            code = ResultCode.CODE_401;
        }
        //controller：基本类型或包装类型参数验证失败
        else if (e instanceof ValidationException) {
            msg = e.getMessage();
            int index = msg.indexOf(":");
            if (msg.length() > index)
                msg = msg.substring(index + 1).trim();
            code = ResultCode.CODE_401;
        }
        //其他错误
        else {
            msg = e.getMessage();
            code = ResultCode.CODE_500;
            logger.error(msg);
        }
        return Result.error(code, msg);
    }
}