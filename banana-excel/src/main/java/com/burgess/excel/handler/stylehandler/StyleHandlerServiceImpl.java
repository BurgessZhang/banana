package com.burgess.excel.handler.stylehandler;

import com.burgess.excel.exception.ExcelException;
import com.burgess.excel.exception.ExcelNotFoundHandlerException;
import com.burgess.excel.exception.ExcelStyleHandlerException;
import com.burgess.excel.handler.StyleHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.stylehandler
 * @file StyleHandlerServiceImpl.java
 * @author burgess.zhang
 * @time 22:23:59/2018-08-28
 * @desc
 */
public class StyleHandlerServiceImpl implements StyleHandlerService {

	private static final Logger logger = LoggerFactory.getLogger(StyleHandlerServiceImpl.class);
	/**
	 * 样式处理器缓存区
	 */
	private Map<String, StyleHandler> handlers = new HashMap<String, StyleHandler>();

	public StyleHandler find(String styleName) throws ExcelStyleHandlerException, ExcelNotFoundHandlerException {
		logger.info("StyleServiceImpl.find(styleName={})", styleName);
		StyleHandler handler = null;
		logger.info(String.format(" running find haandler name is %s", styleName));
		if (handlers == null) {
			initHandler();
			logger.info(String.format("there is not init style handler[handlerHame=%s]", styleName));
		} else {

			handler = handlers.get(styleName);
		}
		if (StringUtils.isNotBlank(styleName) && handler == null) {
			handler = initStyleHandlerByName(styleName);
		}
		return handler;
	}

	public void initHandler() throws ExcelStyleHandlerException {
		logger.info("StyleServiceImpl.initHandler()");
		logger.info(String.format(" running  initHandler start"));
		handlers = new HashMap<String, StyleHandler>();
		ServiceLoader<StyleHandler> styleHandlerServiceLoader = ServiceLoader.load(StyleHandler.class);
		for (StyleHandler styleHandler : styleHandlerServiceLoader) {
			addHandler(styleHandler);
		}
		logger.info(String.format(" running  initHandler over "));
	}

	public StyleHandlerServiceImpl() throws ExcelException {
		initHandler();
	}

	public void addHandler(StyleHandler styleHandler) throws ExcelStyleHandlerException {

		logger.info("StyleServiceImpl.addHandler(styleHandler={})", styleHandler);
		logger.info(String.format(" running  addHandler "));
		if (handlers == null) {
			handlers = new HashMap<String, StyleHandler>();
		}
		logger.info(String.format("Handler name=%s", styleHandler.getStyleName()));
		if (styleHandler.getStyleName() == null || "".equals(styleHandler.getStyleName().trim())) {
			String msg = String.format(" handler[%s] loading error", styleHandler.getClass().getName());
			logger.error(msg);
			ExcelStyleHandlerException ex = new ExcelStyleHandlerException(styleHandler.getClass().getName(), msg);
			throw ex;
		}
		handlers.put(styleHandler.getStyleName(), styleHandler);
	}

	public StyleHandler initStyleHandlerByName(String fullName) throws ExcelNotFoundHandlerException {
		StyleHandler styleHandler = null;
		Class<?> styleHandlerClass = null;
		try {
			styleHandlerClass = Class.forName(fullName);
		} catch (ClassNotFoundException e1) {
			String msg = String.format("Instantiation of %s. ", fullName);
			logger.error(msg);
			throw new ExcelNotFoundHandlerException(fullName, msg, null);
		}

		if (styleHandlerClass != null) {
			try {
				styleHandler = (StyleHandler) styleHandlerClass.newInstance();
			} catch (InstantiationException e) {
				String msg = String.format("Instantiation of %s. ", fullName);
				logger.error(msg);
				throw new ExcelNotFoundHandlerException(fullName, msg, e);
			} catch (IllegalAccessException e) {
				String msg = String.format("Illegal Access of %s. ", fullName);
				logger.error(msg);
				throw new ExcelNotFoundHandlerException(fullName, msg, e);
			}
		}
		if (styleHandler != null) {
			handlers.put(fullName, styleHandler);
		} else {
			String msg = String.format("there is not a handler  of  %s. ", fullName);
			logger.error(msg);
			throw new ExcelNotFoundHandlerException(fullName, msg, null);
		}
		return styleHandler;
	}

}
