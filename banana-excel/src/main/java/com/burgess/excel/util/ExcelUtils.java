package com.burgess.excel.util;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.office.common.BeanUtil;
import org.office.common.DataUtil;
import org.office.excel.api.ExcelExportService;
import org.office.excel.api.ExcelParseService;
import org.office.excel.api.export.ExcelExportServiceImpl;
import org.office.excel.api.parse.ExcelParseServiceImpl;
import org.office.excel.bean.Student;
import org.office.excel.config.ExcelField;
import org.office.excel.config.ExcelSheet;
import org.office.excel.config.util.AnnotationUtil;
import org.office.excel.exception.ExcelCellException;
import org.office.excel.exception.ExcelDataHandlerException;
import org.office.excel.exception.ExcelDataTypeHandlerException;
import org.office.excel.exception.ExcelIoException;
import org.office.excel.exception.ExcelIoInputException;
import org.office.excel.exception.ExcelNotFoundHandlerException;
import org.office.excel.exception.ExcelStyleException;
import org.office.excel.exception.ExcelStyleHandlerException;
import org.office.excel.exception.ExcelValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @project banana-excel
 * @package com.burgess.excel.util
 * @file ExcelUtils.java
 * @author burgess.zhang
 * @time 21:35:54/2018-08-28
 * @desc excel 工具类
 */
public class ExcelUtils {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	private static ExcelParseService parse=new ExcelParseServiceImpl();
	private static ExcelExportService export = new ExcelExportServiceImpl();
	
	
	public  void export(OutputStream outputStream, List<ExcelField> configs,  Map<String,Object>[] maps,InputStream tempalteInputStream) throws ExcelStyleHandlerException, ExcelStyleException, ExcelDataTypeHandlerException, ExcelDataHandlerException, ExcelCellException, ExcelIoException , ExcelNotFoundHandlerException , ExcelValidateException {
		export.export(outputStream, configs, maps, tempalteInputStream);
	}
	
	@SuppressWarnings("unchecked")
	public <T>  void export(OutputStream outputStream,   List<T> list,InputStream tempalteInputStream) throws ExcelStyleHandlerException, ExcelStyleException, ExcelDataTypeHandlerException, ExcelDataHandlerException, ExcelCellException, ExcelIoException , ExcelNotFoundHandlerException , ExcelValidateException {
		if (list == null) {
			String msg="the param list of the method of ExcelUtil.export(OutputStream outputStream, ExcelSheet config,  Map<String,Object>[] maps,InputStream tempalteInputStream) is null ";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (list.size()<=0) {
			String msg="the param data of list of the method of ExcelUtil.export(OutputStream outputStream, ExcelSheet config,  Map<String,Object>[] maps,InputStream tempalteInputStream) is null ";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
		T t=list.get(0);
		List<ExcelField> configlist=AnnotationUtil.loadAnnotationConfig(t.getClass());
		Map<String,Object>[]datas=new Map[list.size()];
		
		for(int i=0;i<list.size();i++){
			T bean =list.get(i);
			Map<Object, Object> map1 = DataUtil.convertToMap(bean);
			Map<String, Object> map2 = DataUtil.convertMapToMap(map1);
			datas[i] = map2;
		}
		
		
		export(outputStream, configlist, datas, tempalteInputStream);
	}
	
	public  void export(OutputStream outputStream, ExcelSheet config,  Map<String,Object>[] maps,InputStream tempalteInputStream) throws ExcelStyleHandlerException, ExcelStyleException, ExcelDataTypeHandlerException, ExcelDataHandlerException, ExcelCellException, ExcelIoException , ExcelNotFoundHandlerException , ExcelValidateException {
		if (config == null) {
			String msg="the param configs of the method of ExcelUtil.export(OutputStream outputStream, ExcelSheet config,  Map<String,Object>[] maps,InputStream tempalteInputStream) is null ";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
		export(outputStream, config.toExcelField(), maps, tempalteInputStream);
	}
	
	public  Map<String,Object>[] parse(InputStream inputStream, List<ExcelField> configs) throws ExcelIoInputException, ExcelDataTypeHandlerException, ExcelCellException, ExcelNotFoundHandlerException , ExcelValidateException {
		return parse.parse(inputStream, configs);
	}
	public  Map<String,Object>[] parse(InputStream inputStream, ExcelSheet config) throws ExcelIoInputException, ExcelDataTypeHandlerException, ExcelCellException, ExcelNotFoundHandlerException , ExcelValidateException {
		return parse(inputStream, config.toExcelField());
	}
	
	public  <T> List<T> parse(InputStream inputStream, Class<T> t) throws ExcelIoInputException, ExcelDataTypeHandlerException, ExcelCellException, ExcelNotFoundHandlerException , ExcelValidateException {
		
		List<T>  resultList=new ArrayList<T>();
		List<ExcelField> list=AnnotationUtil.loadAnnotationConfig(t);
		System.out.println(list.size());
		Map<String,Object>[] beans=parse(inputStream, list);
		System.out.println(JSON.toJSON(beans));
		System.out.println("bs:"+String.valueOf(beans)+",len:"+beans.length);
		for(Map<String,Object> bean:beans){
			System.out.println("row:1");
			Map<Object,Object> map=DataUtil.convertMap(bean);
			T resultBean=DataUtil.convert(map, t);
			resultList.add(resultBean);
		}
		return resultList;
	}
	
}
