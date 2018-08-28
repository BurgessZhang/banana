package com.burgess.excel.exception;

import com.burgess.excel.config.ExcelField;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelConfigException.java
 * @author burgess.zhang
 * @time 22:04:38/2018-08-28
 * @desc 
 */
public class ExcelConfigException extends ExcelException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ExcelConfigException(String errorMsg, Exception exm) {
		this(null,null,errorMsg, exm);
	}
	public ExcelConfigException(ExcelField config,String errorMsg, Exception exm) {
		this(null,config,errorMsg, exm);
	}
	public ExcelConfigException(List<ExcelField> configsList,ExcelField config,String errorMsg, Exception exm) {
		super(errorMsg, exm);
        this.setCode(EXCEL_CONFIG_EXCEPTION_CODE);
        this.config=config;
        this.configsList=configsList;
	}
	/**
	 * 单列配置
	 */
	private ExcelField config;
	public ExcelField getConfig() {
		return config;
	}
	public void setConfig(ExcelField config) {
		this.config = config;
	}
	
	

	private List<ExcelField> configsList;
	public List<ExcelField> getConfigsList() {
		return configsList;
	}
	public void setConfigsList(List<ExcelField> configsList) {
		this.configsList = configsList;
	}
}
