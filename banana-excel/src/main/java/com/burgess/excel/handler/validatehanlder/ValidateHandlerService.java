package com.burgess.excel.handler.validatehanlder;

import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.handler.ValidateHandler;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.validatehanlder
 * @file ValidateHandlerService.java
 * @author burgess.zhang
 * @time 22:17:13/2018-08-28
 * @desc
 */
public interface ValidateHandlerService {

	ValidateHandler find(String name) throws ExcelNotFoundHandlerException;

	void init();

	void addHandler(ValidateHandler validateHandler);

	ValidateHandler initHandlerByName(String fullName) throws ExcelNotFoundHandlerException;
}
