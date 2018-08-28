package com.burgess.excel.handler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler
 * @file StyleHandler.java
 * @author burgess.zhang
 * @time 22:09:05/2018-08-28
 * @desc 样式设置操作
 */
public interface StyleHandler {
	/**
	 * 样式设置出来
	 * @param cell 单元格
	 * @param style 样式值
	 * @param cellStyle
	 * @return
	 */
	public CellStyle handler(Cell cell,String style,CellStyle cellStyle);
	/**
	 * 样式设置器名称，唯一值
	 * @return
	 */
	public String getStyleName();
}
