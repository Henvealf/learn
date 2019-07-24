package com.henvealf.learn.quartz.chain;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 测试依赖链。
 * @author hongliang.yin/Henvealf
 * @date 2019-07-23
 */
public class TestJobChain {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        JobDetail rootJob = JobBuilder.newJob(HaveNextJob.class)
                .withIdentity("rootJob")
                .storeDurably()
                .usingJobData("nextJobName", "childJob").build();

        JobDetail childJob = JobBuilder.newJob(HaveNextJob.class)
                .storeDurably()
                .withIdentity("childJob").build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        scheduler.addJob(rootJob, false);
        scheduler.addJob(childJob, false);

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .forJob("rootJob")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        scheduler.scheduleJob( trigger );

        Thread.sleep(10000);

        scheduler.shutdown();
    }

}
