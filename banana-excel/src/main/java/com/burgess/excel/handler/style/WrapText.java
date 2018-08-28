package com.burgess.excel.handler.style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import com.burgess.excel.handler.StyleHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.style
 * @file WrapText.java
 * @author burgess.zhang
 * @time 22:27:02/2018-08-28
 * @desc
 */
public class WrapText implements StyleHandler {

	private static final Logger logger = LoggerFactory.getLogger(WrapText.class);

	@Override
	public CellStyle handler(Cell cell, String style, CellStyle cellStyle) {
		logger.info("StyleServiceImpl.wrapText(cell={},styleValue={},cellStyle={})", cell, style, cellStyle);
		logger.info(String.format(" running columnWidth(cell[%d,%d],styleValue[%s]", cell.getRowIndex(),
				cell.getColumnIndex(), String.valueOf(style)));
		if (cellStyle == null) {
			cellStyle = cell.getSheet().getWorkbook().createCellStyle();
		}
		if (StringUtils.isBlank(style)) {
			throw new RuntimeException("");
		}
		Boolean booleanStyle = Boolean.valueOf(style);
		cellStyle.setWrapText(booleanStyle);// 设置自动换行
		return cellStyle;
	}

	@Override
	public String getStyleName() {
		return Style.WrapText.name;
	}

}
