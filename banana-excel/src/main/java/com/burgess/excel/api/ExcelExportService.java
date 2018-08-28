package com.burgess.excel.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.burgess.excel.config.ExcelField;
import com.burgess.excel.exception.ExcelCellException;
import com.burgess.excel.exception.ExcelDataHandlerException;
import com.burgess.excel.exception.ExcelDataTypeHandlerException;
import com.burgess.excel.exception.ExcelIoException;
import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.exception.ExcelStyleException;
import com.burgess.excel.exception.ExcelStyleHandlerException;
import com.burgess.excel.exception.ExcelValidateException;

/**
 * @project banana-excel
 * @package com.burgess.excel.api
 * @file ExcelExportService.java
 * @author burgess.zhang
 * @time 21:46:21/2018-08-28
 * @desc excele导出服务
 */
public interface ExcelExportService {
	/**
	 * 
	 * @param outputStream        导出的文件流
	 * @param configs             列表配置信息
	 * @param list                数据信息
	 * @param tempalteInputStream 模板文件的输入流
	 * @throws ExcelException
	 */
	/**
	 * @file ExcelExportService.java
	 * @author burgess.zhang
	 * @time 21:46:53/2018-08-28
	 * @desc 导出Excel
	 * @param outputStream        导出的文件流
	 * @param configs             列表配置信息
	 * @param maps
	 * @param tempalteInputStream 模板文件的输入流
	 * @throws ExcelStyleHandlerException
	 * @throws ExcelStyleException
	 * @throws ExcelDataTypeHandlerException
	 * @throws ExcelDataHandlerException
	 * @throws ExcelCellException
	 * @throws ExcelIoException
	 * @throws ExcelNotFoundHandlerException
	 * @throws ExcelValidateException
	 */
	void export(OutputStream outputStream, List<ExcelField> configs, Map<String, Object>[] maps,
			InputStream tempalteInputStream) throws ExcelStyleHandlerException, ExcelStyleException,
			ExcelDataTypeHandlerException, ExcelDataHandlerException, ExcelCellException, ExcelIoException,
			ExcelNotFoundHandlerException, ExcelValidateException;

}
