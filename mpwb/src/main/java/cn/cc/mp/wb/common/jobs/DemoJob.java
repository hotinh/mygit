package cn.cc.mp.wb.common.jobs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DemoJob implements Job {
    Logger logger = LoggerFactory.getLogger(DemoJob.class);
    
    static int  a = 0;
    
    static String s = "";

    private String jobArg;

//    @Autowired
//    DemoService demoService;
    
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        demoService.hello(jobArg);
        logger.info("---quartz---");
        
        a += 1;
        
        s = s + "1";
        if (a == 10) {
            
        }
        logger.info("{} {} ", a, s);
        
        JobDataMap jm = context.getJobDetail().getJobDataMap();
        logger.info("{}", jm.get("jobArg"));
        
        jm.put("jobArg", s);
        
        logger.info("{}", jm.get("fd"));
        
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
