package com.burgess.excel.handler.validate;

import com.burgess.excel.handler.ValidateHandler;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.validate
 * @file NumberValidate.java
 * @author burgess.zhang
 * @time 22:20:19/2018-08-28
 * @desc
 */
public class NumberValidate implements ValidateHandler {

	private static final Logger logger = LoggerFactory.getLogger(NumberValidate.class);

	private String patternStr = "[0-9]*";

	@Override
	public String getfNandlerName() {
		return "number";
	}

	@Override
	public Boolean parse(Object cellValue) {
		logger.info("NumberValidate.parseValidate({})", cellValue);

		String str = String.valueOf(cellValue);
		Pattern pattern = Pattern.compile(patternStr);
		return pattern.matcher(str).matches();
	}

	@Override
	public Boolean export(Object fieldValue) {
		logger.info("NumberValidate.exportValidate({})", fieldValue);
		String str = String.valueOf(fieldValue);
		Pattern pattern = Pattern.compile(patternStr);
		return pattern.matcher(str).matches();
	}

}
