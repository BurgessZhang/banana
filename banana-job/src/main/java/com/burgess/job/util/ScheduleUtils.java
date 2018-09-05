package com.burgess.job.util;

import org.quartz.*;
import com.burgess.job.entity.ScheduleJobEntity;
import com.burgess.job.exception.RRException;


/**
 * @project banana-job
 * @package com.burgess.job.util
 * @file ScheduleUtils.java
 * @author burgess.zhang
 * @time 13:01:54/2018-09-01
 * @desc 定时任务工具类
 */
public class ScheduleUtils {
	
	private static final String JOB_NAME = "TASK_";
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:03:30/2018-09-01
	 * @desc 获取触发器key
	 * @param jobId
	 * @return
	 */
	public static TriggerKey getTriggerKey(Long jobId) {
		return TriggerKey.triggerKey(JOB_NAME + jobId);
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:04:41/2018-09-01
	 * @desc 获取jobKey
	 * @param jobId
	 * @return
	 */
	public static JobKey getJobKey(Long jobId) {
		return JobKey.jobKey(JOB_NAME + jobId);
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:19:21/2018-09-01
	 * @desc 获取表达式触发器
	 * @param scheduler
	 * @param jobId
	 * @return
	 */
	public static CronTrigger getCronTrigger(Scheduler scheduler,Long jobId) {
		try {
			return (CronTrigger)scheduler.getTrigger(getTriggerKey(jobId));
		} catch (SchedulerException e) {
			throw new RRException("获取定时任务CronTrigger出现异常:",e);
		}
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:20:28/2018-09-01
	 * @desc 创建定时任务
	 * @param scheduler
	 * @param scheduleJob
	 */
	public static void createScheduleJob(Scheduler scheduler,ScheduleJobEntity scheduleJob) {
		try {
			//构建job信息
            JobDetail jobDetail = JobBuilder.newJob((ScheduleJob.class)).withIdentity(getJobKey(scheduleJob.getJobId())).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
            		.withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId())).withSchedule(scheduleBuilder).build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);

            scheduler.scheduleJob(jobDetail, trigger);
            
            //暂停任务
            if(scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()){
            	pauseJob(scheduler, scheduleJob.getJobId());
            }
		
		} catch (Exception e) {
			throw new RRException("创建定时任务失败",e);
		}
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:38:59/2018-09-01
	 * @desc 定时更新任务
	 * @param scheduler
	 * @param scheduleJob
	 */
	public static void updateScheduleJob(Scheduler scheduler,ScheduleJobEntity scheduleJob) {
		try {
			TriggerKey triggerKey = getTriggerKey(scheduleJob.getJobId());

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
            		.withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduler, scheduleJob.getJobId());
            
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            
            //参数
            trigger.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);
            
            scheduler.rescheduleJob(triggerKey, trigger);
            
            //暂停任务
            if(scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()){
            	pauseJob(scheduler, scheduleJob.getJobId());
            }
		} catch (Exception e) {
			throw new RRException("定时更新任务失败",e);
		}
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:45:28/2018-09-01
	 * @desc 立即执行任务
	 * @param scheduler
	 * @param scheduleJob
	 */
	public static void run(Scheduler scheduler,ScheduleJobEntity scheduleJob) {
		try {
			//参数
			JobDataMap dataMap = new JobDataMap();
			dataMap.put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);
			
			scheduler.triggerJob(getJobKey(scheduleJob.getJobId()),dataMap);
		} catch (Exception e) {
			throw new RRException("立即执行定时任务失败",e);
		}
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:47:42/2018-09-01
	 * @desc 暂停任务
	 * @param scheduler
	 * @param jobId
	 */
	public static void pauseJob(Scheduler scheduler,Long jobId) {
		try {
			scheduler.pauseJob(getJobKey(jobId));
		}catch (Exception e) {
			throw new RRException("暂停定时任务失败",e);
		}
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:49:29/2018-09-01
	 * @desc 恢复定时任务
	 * @param scheduler
	 * @param jobId
	 */
	public static void resumeJob(Scheduler scheduler,Long jobId) {
		try {
			scheduler.resumeJob(getJobKey(jobId));
		} catch (Exception e) {
			throw new RRException("恢复定时任务失败",e);
		}
		
	}
	
	/**
	 * @file ScheduleUtils.java
	 * @author burgess.zhang
	 * @time 13:50:53/2018-09-01
	 * @desc 删除定时任务
	 * @param scheduler
	 * @param jobId
	 */
	public static void removeScheduleJob(Scheduler scheduler,Long jobId) {
		try {
			scheduler.deleteJob(getJobKey(jobId));
		} catch (Exception e) {
			throw new RRException("删除定时任务失败",e);
		}
	}
	
	
}
