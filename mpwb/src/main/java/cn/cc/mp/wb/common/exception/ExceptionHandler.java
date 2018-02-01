package cn.cc.mp.wb.common.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.cc.mp.wb.core.Result;
import cn.cc.mp.wb.core.ResultCode;
import cn.cc.mp.wb.core.ResultHelper;
import cn.cc.mp.wb.core.ServiceException;

public class ExceptionHandler implements HandlerExceptionResolver {
    final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        Result result = new Result();
        
        if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
            logger.info(e.getMessage());
            
        } else if (e instanceof NoHandlerFoundException) {
            result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
            
        } else if (e instanceof ServletException) {
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
            
        } else {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            String message;
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        e.getMessage());
            } else {
                message = e.getMessage();
            }
            logger.error(message, e);
        }
        
        ResultHelper.responseResult(response, result);
        return new ModelAndView();
    }
    
}
