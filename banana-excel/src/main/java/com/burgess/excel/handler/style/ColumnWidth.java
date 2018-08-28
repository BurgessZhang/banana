package com.burgess.excel.handler.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import com.burgess.excel.handler.StyleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.style
 * @file ColumnWidth.java
 * @author burgess.zhang
 * @time 22:31:59/2018-08-28
 * @desc
 */
public class ColumnWidth implements StyleHandler {

	private static final Logger logger = LoggerFactory.getLogger(ColumnWidth.class);

	@Override
	public CellStyle handler(Cell cell, String style, CellStyle cellStyle) {

		logger.info("StyleServiceImpl.fontBoldweight(cell={},col={},width={},cellStyle={})", cell,
				cell.getColumnIndex(), style, cellStyle);
		logger.info(String.format(" running columnWidth(cell[%d,%d],col[%d],width[%s])", cell.getRowIndex(),
				cell.getColumnIndex(), cell.getColumnIndex(), style));

		int width = Integer.valueOf(style);
		width = width * 2 * 256;
		cell.getSheet().setColumnWidth(cell.getColumnIndex(), width);
		return cellStyle;
	}

	@Override
	public String getStyleName() {
		// TODO Auto-generated method stub
		return Style.ColumnWidth.name;
	}

}
