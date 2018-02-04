package cn.cc.mp.wb.common.jobs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.cc.mp.wb.model.User;
import cn.cc.mp.wb.service.UserService;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DemoJob implements Job {
    Logger logger = LoggerFactory.getLogger(DemoJob.class);
    
    static int  a = 0;
    
//    static String s = "";

    private String jobArg;

//    @Autowired
//    DemoService demoService;
    
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;
    
    @Resource
    UserService userService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        
        logger.info("---demo job---" + jobDetail.getKey());
        a += 1;
        if (a == 10) {
            logger.info("a-10:{}", a);
        }
        logger.info("a:{}", a);
        
//        s = s + "1";
//        logger.info("s:{}", s);
//      jm.put("jobArg", s);
        
        logger.info("jobArg:{}", jobDataMap.get("jobArg"));

        
        String userId = jobDataMap.getString("userId");
        logger.info("userId:{}", Integer.valueOf(userId));
        
        User user = userService.findBy("id", Integer.valueOf(userId));
        logger.info("user:{}", user);
        
        for(int i=1; i<=15; i++) {
            System.out.println(jobDetail.getKey() + "-" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
//        try {
//            TimeUnit.SECONDS.sleep(15);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        /*Class clazz = context.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            logger.info("---{}---", method.getName());
            
            try {
                if (method.getName().startsWith("get")) {
                    logger.info("-{}-", method.invoke(context));
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
            Class[] parameterTypes = method.getParameterTypes();
            Arrays.asList(parameterTypes).forEach(e -> {
//                logger.info(e.getName());
//                clazz.getMethod(name, parameterTypes)
            });
        }*/
    }

    public void setJobArg(String jobArg) {
        this.jobArg = jobArg;
    }
}
