package com.jldata.pgsminiapp.core.exception;

import com.jldata.pgsminiapp.core.rest.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public RestResult handler(Exception e){
        logger.info("[系统异常] {}",e.getMessage());
        return new RestResult(500,e.getMessage());
    }
    @ExceptionHandler(BaseException.class)
    public RestResult baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
        return new RestResult(ex.getStatus(), ex.getMessage());
    }
    @ExceptionHandler(UserTokenException.class)
    public RestResult userTokenExceptionHandler(HttpServletResponse response, UserTokenException ex) {
        logger.error(ex.getMessage(),ex);
        return new RestResult(ex.getStatus(), ex.getMessage());
    }
}