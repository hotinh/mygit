package cn.cc.mp.wb.common.quartz;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;  
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.cc.mp.wb.common.jobs.DemoJob;  
  
/** 
 * 定时任务管理类 
 *  
 */  
public class QuartzManager {
    
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;
    
    Scheduler scheduler = null;
    
    @PostConstruct
    public void init() {
        scheduler = schedulerFactoryBean.getScheduler();
    }
    
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";  
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";  
  
    /** 
     * 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名 
     *  
     * @param jobName 
     *            任务名 
     * @param jobClazz 
     *            任务 
     * @param intervalInSeconds
     *            间隔时间-秒
     */  
    public void addJob(String jobName, Class<? extends Job> jobClazz, int intervalInSeconds) {
        try {
            JobDataMap jobDataMap = new JobDataMap();
            JobDetail jobDetail = JobBuilder.newJob(jobClazz)
                    .setJobData(jobDataMap)
                    .withIdentity(jobName)
                    .build();
            
            // 触发器  
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(intervalInSeconds)
                            .repeatForever())
                    .build();
            
            scheduler.scheduleJob(jobDetail, trigger);
            
            if (!scheduler.isShutdown()) {  
                scheduler.start();  
            }  
        } catch (Exception e) {
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * 添加一个定时任务 
     *  
     * @param jobName 
     *            任务名 
     * @param jobGroupName 
     *            任务组名 
     * @param triggerName 
     *            触发器名 
     * @param triggerGroupName 
     *            触发器组名 
     * @param jobClazz 
     *            任务 
     * @param cronExpression
     *            cron表达式
     */  
    public void addJob(String jobName, String jobGroupName,
            String triggerName, String triggerGroupName, 
            Class<? extends Job> jobClazz, String cronExpression) {
        try {  
            JobDataMap jobDataMap = new JobDataMap();
            JobDetail jobDetail = JobBuilder.newJob(jobClazz)
                    .setJobData(jobDataMap)
                    .withDescription("")
                    .withIdentity(jobName, jobGroupName)
                    .build();
            
            // 触发器  
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withIdentity(triggerName, triggerGroupName)
                    .startNow()
                    .withSchedule(cronSchedule(cronExpression))
                    .build();
            
            scheduler.scheduleJob(jobDetail, trigger);
            
            if (!scheduler.isShutdown()) {  
                scheduler.start();  
            } 
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名) 
     *  
     * @param jobName 
     * @param time 
     *  
     */  
    public void modifyJobTime(String jobName, String time) {
//        try {  
//            CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName,TRIGGER_GROUP_NAME);
//            scheduler.getTriggerState(triggerKey)
//            
//            if (trigger == null) {  
//                return;  
//            }  
//            String oldTime = trigger.getCronExpression();  
//            if (!oldTime.equalsIgnoreCase(time)) {
//                JobDetail jobDetail = sched.getJobDetail(jobName,JOB_GROUP_NAME);  
//                Class objJobClass = jobDetail.getJobClass();  
//                removeJob(jobName);  
//                addJob(jobName, objJobClass, time);  
//            }  
//        } catch (Exception e) {  
//            throw new RuntimeException(e);  
//        }  
    }  
  
    /** 
     * @Description: 修改一个任务的触发时间 
     *  
     * @param triggerName 
     * @param triggerGroupName 
     * @param time 
     */  
    public static void modifyJobTime(String triggerName,  
            String triggerGroupName, String time) {  
//        try {  
//            Scheduler sched = gSchedulerFactory.getScheduler();  
//            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName,triggerGroupName);  
//            if (trigger == null) {  
//                return;  
//            }  
//            String oldTime = trigger.getCronExpression();  
//            if (!oldTime.equalsIgnoreCase(time)) {  
//                CronTrigger ct = (CronTrigger) trigger;  
//                // 修改时间  
//                ct.setCronExpression(time);  
//                // 重启触发器  
//                sched.resumeTrigger(triggerName, triggerGroupName);  
//            }  
//        } catch (Exception e) {  
//            throw new RuntimeException(e);  
//        }  
    }  
  
    /** 
     * 移除一个任务(使用默认的任务组名，触发器名，触发器组名) 
     *  
     * @param jobName
     * 
     */  
    public void removeJob(String jobName) {  
        try {  
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobName));// 停止触发器  
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobName));// 移除触发器  
            scheduler.deleteJob(JobKey.jobKey(jobName));// 删除任务  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }
    }  
  
    /** 
     * @Description: 移除一个任务 
     *  
     * @param jobName 
     * @param jobGroupName 
     * @param triggerName 
     * @param triggerGroupName 
     */  
    public void removeJob(String jobName, String jobGroupName,  
            String triggerName, String triggerGroupName) {
        try {  
            scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));// 停止触发器  
            scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName));// 移除触发器  
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description:启动所有定时任务
     */  
    public void startJobs() {  
        try {  
            scheduler.start();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description:关闭所有定时任务 
     *  
     */  
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
