package me.xns.springdemo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xns on 2017/7/10.
 */
public class TestInteceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String[] fucks = httpServletRequest.getParameterValues("fuck");
        if (fucks == null) {
            return true;
        }
        for (String f : fucks) {
            if ("fuck".equals(f)) {
                logger.info("method=" + o);
                httpServletResponse.setStatus(200);
                ServletOutputStream outputStream = httpServletResponse.getOutputStream();
                outputStream.print("can't has fuck");
                outputStream.flush();
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
