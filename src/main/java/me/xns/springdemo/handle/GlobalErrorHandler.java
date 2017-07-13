package me.xns.springdemo.handle;

import me.xns.springdemo.domain.Result;
import me.xns.springdemo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xns on 2017/7/13.
 */
@ControllerAdvice
public class GlobalErrorHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception exception) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        logger.info("url=" + request);
        return ResultUtil.error(exception.getMessage(), -1);
    }
}
