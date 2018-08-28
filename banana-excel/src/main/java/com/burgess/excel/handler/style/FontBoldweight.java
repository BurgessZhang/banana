package com.burgess.excel.handler.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import com.burgess.excel.handler.StyleHandler;
import org.apache.poi.ss.usermodel.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.style
 * @file FontBoldweight.java
 * @author burgess.zhang
 * @time 22:31:15/2018-08-28
 * @desc
 */
public class FontBoldweight implements StyleHandler {

	private static final Logger logger = LoggerFactory.getLogger(FontBoldweight.class);

	@Override
	public CellStyle handler(Cell cell, String style, CellStyle cellStyle) {

		logger.info("StyleServiceImpl.fontBoldweight(cell={},type={},cellStyle={})", cell, style, cellStyle);
		logger.info(String.format(" running fontBoldweight(cell[%d,%d],type[%s])", cell.getRowIndex(),
				cell.getColumnIndex(), style));

		if (cellStyle == null) {
			cellStyle = cell.getSheet().getWorkbook().createCellStyle();
		}
		Font font = cell.getSheet().getWorkbook().createFont();
		font.setBoldweight(Short.valueOf(style));// 粗体显示
		cellStyle.setFont(font);// 选择需要用到的字体格式
		return cellStyle;
	}

	@Override
	public String getStyleName() {
		return Style.FontBoldweight.name;
	}

}
