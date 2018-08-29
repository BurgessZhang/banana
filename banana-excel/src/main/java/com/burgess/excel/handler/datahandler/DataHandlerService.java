package com.burgess.excel.handler.datahandler;

import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.handler.DataHandler;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.datahandler
 * @file DataHandlerService.java
 * @author burgess.zhang
 * @time 22:13:21/2018-08-28
 * @desc
 */
public interface DataHandlerService {

	DataHandler<?> findHandler(String fieldName) throws ExcelNotFoundHandlerException;

	void addHandler(DataHandler<?> handler);

	DataHandler<?> initDataHandlerBuFullName(String fullName) throws ExcelNotFoundHandlerException;
}
