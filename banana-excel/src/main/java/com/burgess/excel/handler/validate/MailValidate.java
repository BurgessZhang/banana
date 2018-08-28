package com.burgess.excel.handler.validate;

import com.burgess.excel.handler.ValidateHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.validate
 * @file MailValidate.java
 * @author burgess.zhang
 * @time 22:21:33/2018-08-28
 * @desc 
 */
public class MailValidate implements ValidateHandler {

private static final Logger logger = LoggerFactory.getLogger( MailValidate.class );
	
	private String patternStr="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	@Override
	public String getfNandlerName() {
		// TODO Auto-generated method stub
		return "email";
	}

	@Override
	public Boolean parse(Object cellValue) {
		logger.info("MailValidate.parseValidate({})",cellValue);
		String value=String.valueOf(cellValue);
		boolean flag=false;
		Pattern p1 = null;
		Matcher m = null;
		p1 = Pattern.compile(patternStr);
		m = p1.matcher(value);
		flag = m.matches();
		return flag;
	}

	@Override
	public Boolean export(Object fieldValue) {
		logger.info("MailValidate.exportValidate({})",fieldValue);
		String value=String.valueOf(fieldValue);
		boolean flag=false;
		Pattern p1 = null;
		Matcher m = null;
		p1 = Pattern.compile(patternStr);
		m = p1.matcher(value);
		flag = m.matches();
		return flag;
	}


}
