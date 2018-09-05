package com.burgess.job.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.burgess.job.entity.ScheduleJobEntity;
import com.burgess.job.entity.ScheduleJobLogEntity;

/**
 * @project banana-job
 * @package com.burgess.job.util
 * @file ScheduleJob.java
 * @author burgess.zhang
 * @time 13:56:13/2018-09-01
 * @desc 定时任务
 */
public class ScheduleJob extends QuartzJobBean {

	private Logger logger = LoggerFactory.getLogger(ScheduleJob.class);

	private ExecutorService service = Executors.newSingleThreadExecutor();

	/**
	 * @file ScheduleJob.java
	 * @author burgess.zhang
	 * @time 13:56:13/2018-09-01
	 * @desc 定时任务执行
	 * @param context
	 * @throws JobExecutionException
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap()
				.get(ScheduleJobEntity.JOB_PARAM_KEY);
		// 获取spring bean
		// ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService)
		// SpringContextUtils.getBean("scheduleJobLogService");

		// 数据库保存执行记录
		ScheduleJobLogEntity log = new ScheduleJobLogEntity();
		log.setJobId(scheduleJob.getJobId());
		log.setBeanName(scheduleJob.getBeanName());
		log.setMethodName(scheduleJob.getMethodName());
		log.setParams(scheduleJob.getParams());
		log.setCreateTime(new Date());

		// 任务开始时间
		long startTime = System.currentTimeMillis();
		try {
			ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(),
					scheduleJob.getParams());
			Future<?> future = service.submit(task);

			future.get();

			// 任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int) times);
			// 任务状态 0：成功 1：失败
			log.setStatus(0);

			logger.info("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
		} catch (Exception e) {
			logger.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);

			// 任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int) times);

			// 任务状态 0：成功 1：失败
			log.setStatus(1);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
		} finally {
			// scheduleJobLogService.insert(log);
		}
	}

}
