package work.icql.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import work.icql.springboot.common.enums.ResultCode;
import work.icql.springboot.common.exception.ServiceException;
import work.icql.springboot.common.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.Enumeration;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/29 11:51
 * @Title ExceptionConfig
 * @Description ExceptionConfig
 */
@Slf4j
@RestControllerAdvice
public class ExceptionConfig {

    /* 处理运行时异常：开发时必须要处理 */
    @Profile({"dev"})
    @ExceptionHandler(RuntimeException.class)
    public Object handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String message = "" + getExceptionMessage(e, request);
        log.error(message);
        return getResponse(ResultCode.SYSTEM_INNER_ERROR, message);
    }

    /* 处理自定义异常 */
    @ExceptionHandler(ServiceException.class)
    public Object handleServiceException(ServiceException e, HttpServletRequest request) {
        String message = getExceptionMessage(e, request);
        return getResponse(e.getResultCode(), message);
    }

    /* 处理参数校验异常 */
    @ExceptionHandler({MethodArgumentNotValidException.class, ValidationException.class, MethodArgumentTypeMismatchException.class})
    public Object handleParamInvalidException(Exception e, HttpServletRequest request) {
        String message = getExceptionMessage(e, request);
        return getResponse(ResultCode.PARAM_IS_INVALID, message);
    }

    /* 处理Servlet异常 */
    @ExceptionHandler(ServletException.class)
    public Object handleServletException(ServletException e, HttpServletRequest request) {
        String message = getExceptionMessage(e, request);
        return getResponse(ResultCode.INTERFACE_REQUEST_TIMEOUT, message);
    }

    /* 处理其他异常 */
    @ExceptionHandler(Exception.class)
    public Object handleDefaultException(Exception e, HttpServletRequest request) {
        String message = getExceptionMessage(e, request);
        log.error(message);

        //TODO mq通知管理员

        return getResponse(ResultCode.SYSTEM_INNER_ERROR, message);
    }


    private Object getResponse(ResultCode resultCode, String message) {
        Result result = Result.failure(resultCode, message);
        return ResponseEntity.status(resultCode.httpStatus()).body(result);
    }

    private String getExceptionMessage(Exception e, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("IP:%s | url:%s | 异常信息:%s |", request.getRemoteHost(), request.getRequestURL(), e.getMessage()));
        Enumeration<?> temp = request.getParameterNames();
        if (temp != null && temp.hasMoreElements()) {
            sb.append("参数：");
            while (temp.hasMoreElements()) {
                String key = (String) temp.nextElement();
                String value = request.getParameter(key);
                if (!StringUtils.isEmpty(value)) {
                    sb.append(String.format("key=%s&value=%s , ", key, value));
                }
            }
        }
        return sb.toString();
    }
}
