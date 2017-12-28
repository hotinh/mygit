package cn.junety.alarm.web.controller;

import cn.junety.alarm.base.entity.User;
import cn.junety.alarm.web.service.UserLoginStatusService;
import cn.junety.alarm.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by caijt on 2017/4/2.
 * 用户信息处理
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;
    @Autowired
    UserLoginStatusService userLoginStatusService;

    User getUser(HttpServletRequest request) {
        Object user = request.getAttribute("user");
        if (user != null) {
            return (User) user;
        }
        String identification = userLoginStatusService.getIdentificationFromLoginStatus(request);
        return userService.getUserByIdentification(identification);
    }
    
    protected User initUser() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "id", 1);
            BeanUtils.setProperty(user, "type", 1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("error:{}", e);
        }
        return user;
    }
    
}
