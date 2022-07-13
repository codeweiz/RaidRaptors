package cn.microboat.config;

import cn.microboat.pojo.ReturnBase;
import cn.microboat.pojo.exception.BizCodeEnum;
import cn.microboat.pojo.exception.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获
 *
 * @author zhouwei
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.microboat.controller")
public class CustomExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ReturnBase<Map<String, String>> handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题：{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>(16);
        bindingResult.getFieldErrors().forEach((fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage())));
        return ReturnBase.error(errorMap, Error.builder()
                .errorCode(BizCodeEnum.VALID_EXCEPTION.getCode())
                .errorMsg(BizCodeEnum.VALID_EXCEPTION.getMsg())
                .build());
    }

    @ExceptionHandler(value = Throwable.class)
    public ReturnBase<Object> handleException(Throwable throwable) {
        log.error("异常信息：{}，异常类型：{}", throwable.getMessage(), throwable.getClass());
        return ReturnBase.error(Error.builder()
                .errorCode(BizCodeEnum.UNKNOWN_EXCEPTION.getCode())
                .errorMsg(BizCodeEnum.UNKNOWN_EXCEPTION.getMsg())
                .build()
        );
    }
}
