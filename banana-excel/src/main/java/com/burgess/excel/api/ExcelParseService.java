package com.burgess.excel.api;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.burgess.excel.config.ExcelField;
import com.burgess.excel.exception.ExcelCellException;
import com.burgess.excel.exception.ExcelDataTypeHandlerException;
import com.burgess.excel.exception.ExcelIoInputException;
import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.exception.ExcelValidateException;

/**
 * @project banana-excel
 * @package com.burgess.excel.api
 * @file ExcelParseService.java
 * @author burgess.zhang
 * @time 21:45:27/2018-08-28
 * @desc excele导入服务
 */
public interface ExcelParseService {

	/**
	 * @file ExcelParseService.java
	 * @author burgess.zhang
	 * @time 21:45:49/2018-08-28
	 * @desc 解释数据
	 * @param inputStream
	 * @param configs
	 * @return
	 * @throws ExcelIoInputException
	 * @throws ExcelDataTypeHandlerException
	 * @throws ExcelCellException
	 * @throws ExcelNotFoundHandlerException
	 * @throws ExcelValidateException
	 */
	Map<String, Object>[] parse(InputStream inputStream, List<ExcelField> configs) throws ExcelIoInputException,
			ExcelDataTypeHandlerException, ExcelCellException, ExcelNotFoundHandlerException, ExcelValidateException;

}
