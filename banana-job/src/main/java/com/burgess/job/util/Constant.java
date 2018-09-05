package com.burgess.job.util;

/**
 * @project banana-job
 * @package com.burgess.job.util
 * @file Constant.java
 * @author burgess.zhang
 * @time 13:37:06/2018-09-01
 * @desc 常量
 */
public class Constant {
	
	/**
	 * @project banana-job
	 * @package com.burgess.job.util
	 * @file Constant.java
	 * @author burgess.zhang
	 * @time 13:37:36/2018-09-01
	 * @desc 定时任务状态
	 */
	public enum ScheduleStatus {
	/**
	 * 正常
	 */
	NORMAL(0),
	/**
	 * 暂停
	 */
	PAUSE(1);

		private int value;

		ScheduleStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
