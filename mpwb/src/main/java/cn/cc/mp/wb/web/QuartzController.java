package cn.cc.mp.wb.web;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cc.mp.wb.common.jobs.DemoJob;
import cn.cc.mp.wb.core.Result;
import cn.cc.mp.wb.core.ResultGenerator;

@RequestMapping("/quartz")
@RestController
public class QuartzController {
    Logger logger = LoggerFactory.getLogger(QuartzController.class);
    
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;
    
    Scheduler scheduler = null;
    
    @PostConstruct
    public void init() {
        scheduler = schedulerFactoryBean.getScheduler();
    }
    
    @GetMapping("/start")
    public Result start(@RequestParam String userId) throws SchedulerException {
        logger.info("----");
        
        Map<String, Object> m = new HashMap<>();
        m.put("userId", userId);
        
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobArg", "world");
        jobDataMap.putAll(m);
        
        JobDetail jobDetail = JobBuilder.newJob(DemoJob.class)
                .setJobData(jobDataMap)
//                .withDescription("demo")
                .withIdentity("demo-job"+"-"+userId)
//                .withIdentity("demo-job", "demo-group")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startNow()
//                .withSchedule(cronSchedule("0/5 * * * * ?"))
                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(5)
//                        .repeatForever()
                        )
                .build();
        
        scheduler.scheduleJob(jobDetail, trigger);
        
        return ResultGenerator.genSuccessResult();
    }
    
    @GetMapping("/stop")
    public Result stop() throws SchedulerException {
//        scheduler.pauseTrigger(TriggerKey.triggerKey("demo-job", "demo-group"));
//        scheduler.unscheduleJob(TriggerKey.triggerKey("demo-job", "demo-group"));
//        scheduler.deleteJob(JobKey.jobKey("demo-job", "demo-group"));
        
        scheduler.pauseTrigger(TriggerKey.triggerKey("demo-job"));
        scheduler.unscheduleJob(TriggerKey.triggerKey("demo-job"));
        scheduler.deleteJob(JobKey.jobKey("demo-job"));
        return ResultGenerator.genSuccessResult();
    }
    
    @GetMapping("/pause")
    public Result pause() throws SchedulerException {
//        scheduler.pauseJob(JobKey.jobKey("demo-job", "demo-group"));
        scheduler.pauseJob(JobKey.jobKey("demo-job"));
        return ResultGenerator.genSuccessResult();
    }
    
    @GetMapping("/resume")
    public Result resume(@RequestParam String userId) throws SchedulerException {
//        scheduler.resumeJob(JobKey.jobKey("demo-job", "demo-group"));
        
        Map<String, Object> m = new HashMap<>();
        m.put("userId", userId);
        
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobArg", "world");
        jobDataMap.putAll(m);
        
        JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey("demo-job"));
        jobDetail.getJobBuilder().setJobData(jobDataMap);
        
        scheduler.resumeJob(jobDetail.getKey());
        
//        scheduler.resumeJob(JobKey.jobKey("demo-job"));
        
        return ResultGenerator.genSuccessResult();
    }
    
    @GetMapping("/startAll")
    public Result startJobs() throws SchedulerException {
        scheduler.standby();
        return ResultGenerator.genSuccessResult();  
    }
    
    @GetMapping("/stopAll")
    public void shutdownJobs() {
        try {  
            if (!scheduler.isShutdown()) {  
                scheduler.shutdown();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }

}
