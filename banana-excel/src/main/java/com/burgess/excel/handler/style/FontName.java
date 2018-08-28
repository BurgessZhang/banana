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
 * @file FontName.java
 * @author burgess.zhang
 * @time 22:29:51/2018-08-28
 * @desc
 */
public class FontName implements StyleHandler {

	private static final Logger logger = LoggerFactory.getLogger(FontName.class);

	public CellStyle handler(Cell cell, String style, CellStyle cellStyle) {

		logger.info("StyleServiceImpl.fontName(cell={},name={},setBorder={})", cell, style, cellStyle);
		logger.info(String.format(" running fontName(cell[%d,%d],name[%s])", cell.getRowIndex(), cell.getColumnIndex(),
				cellStyle));

		if (cellStyle == null) {
			cellStyle = cell.getSheet().getWorkbook().createCellStyle();
		}
		Font font = cell.getSheet().getWorkbook().createFont();
		font.setFontName(style);
		cellStyle.setFont(font);
		return cellStyle;
	}

	public String getStyleName() {
		return Style.FontName.name;
	}

}
