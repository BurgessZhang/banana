package com.burgess.excel.config;

import java.util.List;

/**
 * @project banana-excel
 * @package com.burgess.excel.config
 * @file ExcelWorkBook.java
 * @author burgess.zhang
 * @time 21:52:40/2018-08-28
 * @desc
 */
public class ExcelWorkBook {
	private List<ExcelSheet> sheets;
	private String name;

	public List<ExcelSheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<ExcelSheet> sheets) {
		this.sheets = sheets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
