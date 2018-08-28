package com.burgess.excel.handler.stylehandler;

import com.burgess.excel.exception.ExcelException;
import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.exception.ExcelStyleHandlerException;
import com.burgess.excel.handler.StyleHandler;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.stylehandler
 * @file StyleHandlerService.java
 * @author burgess.zhang
 * @time 22:23:13/2018-08-28
 * @desc
 */
public interface StyleHandlerService {
	/**
	 * 查找样式处理器
	 * 
	 * @param styleName 样式名称
	 * @return
	 * @throws ExcelException
	 */
	StyleHandler find(String styleName) throws ExcelStyleHandlerException, ExcelNotFoundHandlerException;

	/**
	 * 加载所有样式处理器
	 * 
	 * @throws ExcelException
	 */
	void initHandler() throws ExcelException;

	/**
	 * 添加样式处理器到缓存
	 * 
	 * @param styleHandler 样式处理器
	 * @throws ExcelException
	 */
	void addHandler(StyleHandler styleHandler) throws ExcelException;

	/**
	 * 通过类全名来实现，未通spi配置的handler加载。
	 * 
	 * @param fullName 类全名称
	 * @return
	 */
	StyleHandler initStyleHandlerByName(String fullName) throws ExcelNotFoundHandlerException;
}
