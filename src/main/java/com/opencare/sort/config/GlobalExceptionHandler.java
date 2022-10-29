package com.opencare.sort.config;

import com.opencare.sort.controller.dto.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse handleRuntimeException(HttpServletRequest request, Exception e) {
        log.error("un known exception", e);
        return BaseResponse.fail("un known exception");
    }

}
