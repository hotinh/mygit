package cn.junety.alarm.web.syslog;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import cn.junety.alarm.base.entity.SysLog;
import cn.junety.alarm.base.entity.User;
import cn.junety.alarm.web.dao.SysLogDao;
import cn.junety.alarm.web.dao.UserDao;

@Aspect
@Component
public class AspectLog {
	
	@Autowired
	private SysLogDao sysLogDao;
	@Autowired
	private UserDao userDao;

	private final static Logger logger = LoggerFactory.getLogger(AspectLog.class);
	
	@Pointcut("@annotation(cn.junety.alarm.web.syslog.Log)")
	public void saveLog() {}
	
	@Pointcut("execution(** cn.junety.alarm.web.controller.UserController.*(..))")
	public void printLog() {}
	
	/*@Before("printLog()")
	public void test1(JoinPoint jp) {
		String targetClassName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		logger.info("{}.{}:begin...", targetClassName, methodName);
	}
	
	@AfterReturning(pointcut="printLog()")
	public void test2(JoinPoint jp) {
		String targetClassName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		logger.info("{}.{}:...end", targetClassName, methodName);
	}
	
	@AfterThrowing(pointcut="printLog()", throwing="e")
	public void test3(JoinPoint jp, Throwable e) {
		String targetClassName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		logger.error("{}.{}:error by {}", targetClassName, methodName, e.getClass().getName());
	}*/
	
	
	@Around("saveLog()")
	public void test4(ProceedingJoinPoint jp) throws ClassNotFoundException {
		
		try {
			
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			User currentUser = (User) request.getAttribute("user");
			String ip = request.getRemoteAddr();
			
			
			String targetClassName = jp.getTarget().getClass().getName();
			String methodName = jp.getSignature().getName();
			logger.info("@Around targetClassName:{}", targetClassName);
			logger.info("@Around methodName:{}", methodName);
			
			Object[] arguments = jp.getArgs();
			logger.info("@Around objs:{}",arguments);
			
			
			//日志字段
			ModelType modelType = null;
			LogType logType = null;
			
			
			//反射获取目标类
			Class targetClass = Class.forName(targetClassName);
			Model model = (Model) targetClass.getAnnotation(Model.class);
			modelType = model.type();
			
			modelType.getValue();
			
			
			//反射获取目标类的方法，以及方法上的注释
			Method[] methods = targetClass.getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						logType = method.getAnnotation(Log.class).type();
					}
				}
			}
			
			
//			if (logType.getValue() == LogType.DELETE.getValue()) {
//				int id = (int) arguments[0];
//				User user = userDao.getUserById(id);
//				logger.info("@Around DELETE id:{}, user:{}", id, user);
//			}
			
			//事件执行
			jp.proceed();
			
			//保存日志
			SysLog sysLog = new SysLog();
			sysLog.setCreateTime(System.currentTimeMillis());
			sysLog.setCreateUser(currentUser.getId());
			sysLog.setType(logType.getValue());
			sysLog.setTypeName(logType.getName());
//			sysLog.setModelType(modelType.getValue());
			sysLog.setModelName(modelType.getName());
			sysLog.setParams(JSON.toJSONString(arguments[0]));
			sysLog.setIp(ip);
			sysLogDao.save(sysLog);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
