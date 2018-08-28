package com.burgess.excel.handler.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import com.burgess.excel.handler.StyleHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.style
 * @file FontHeightInPoints.java
 * @author burgess.zhang
 * @time 22:30:31/2018-08-28
 * @desc
 */
public class FontHeightInPoints implements StyleHandler {

	private static final String defaultSize = "12";
	private static final Logger logger = LoggerFactory.getLogger(FontHeightInPoints.class);

	@Override
	public CellStyle handler(Cell cell, String style, CellStyle cellStyle) {
		logger.info("StyleServiceImpl.fontHeightInPoints(cell={},point={},cellStyle={})", cell, style, cellStyle);
		logger.info(String.format(" running fontHeightInPoints(cell[%d,%d],point[%d])", cell.getRowIndex(),
				cell.getColumnIndex(), style));

		if (cellStyle == null) {
			cellStyle = cell.getSheet().getWorkbook().createCellStyle();
		}
		Font font = cell.getSheet().getWorkbook().createFont();
		font.setFontHeightInPoints(Short.valueOf(StringUtils.isNoneBlank(style) ? style : defaultSize));// 设置字体大小
		cellStyle.setFont(font);
		return cellStyle;
	}

	@Override
	public String getStyleName() {
		return Style.FontHeightInPoints.name;
	}

}
