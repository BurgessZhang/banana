package com.burgess.excel.handler.datatypehandler;

import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.handler.DataTypeHandler;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.datatypehandler
 * @file DataTypeHandlerService.java
 * @author burgess.zhang
 * @time 22:15:17/2018-08-28
 * @desc
 */
public interface DataTypeHandlerService {
	
	DataTypeHandler<?> find(String handlerName) throws ExcelNotFoundHandlerException;

	void add(DataTypeHandler<?> dataTypeHandler);

	void initHandler();

	DataTypeHandler<?> initHnadlerByFullName(String fullName) throws ExcelNotFoundHandlerException;
}
