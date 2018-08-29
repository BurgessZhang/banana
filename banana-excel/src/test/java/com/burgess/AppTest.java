package com.burgess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.burgess.excel.exception.*;
import org.junit.Test;

import com.burgess.excel.config.ExcelField;
import com.burgess.excel.config.util.AnnotationUtils;
import com.burgess.excel.util.ExcelUtils;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	/**
	 * Rigourous Test :-)
	 * @throws ExcelValidateException 
	 * @throws ExcelIoException 
	 * @throws ExcelCellException 
	 * @throws ExcelStyleException 
	 * @throws ExcelNotFoundHandlerException 
	 * @throws ExcelDataHandlerException 
	 * @throws ExcelDataTypeHandlerException 
	 * @throws ExcelStyleHandlerException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void export() throws ExcelStyleHandlerException, ExcelDataTypeHandlerException, ExcelDataHandlerException, ExcelNotFoundHandlerException, ExcelStyleException, ExcelCellException, ExcelIoException, ExcelValidateException, FileNotFoundException {
		ExcelUtils excelUtil = new ExcelUtils();
		String path = this.getClass().getResource("/").getPath();
		File file = new File(String.format("%s%s", path, "text.xlsx"));
		OutputStream os = new FileOutputStream(file);
		int size = 100;
		Student sd = null;
		Map[] maps = new Map[size];
		Map<String,Object> dataList = null;
		for (int i = 0; i < size; i++) {
			dataList=new HashMap<String,Object>();
			dataList.put("id", String.valueOf(i));
			dataList.put("name", String.format("NAME_%d", i));
			dataList.put("sex", String.valueOf(i%2==0?"男":"女"));
			dataList.put("age", i%100);
			dataList.put("borthDate", new Date());
			maps[i] = dataList;
		}
		List<ExcelField> list=AnnotationUtils.loadAnnotationConfig(Student.class);
		excelUtil.export(os, list, maps, null);
		
	}

	@Test
	public void parse() throws FileNotFoundException, ExcelValidateException, ExcelIoInputException, ExcelDataTypeHandlerException, ExcelCellException, ExcelNotFoundHandlerException {
		ExcelUtils excelUtil = new ExcelUtils();
		String path = this.getClass().getResource("/").getPath();
		InputStream inputStream=new FileInputStream(String.format("%s%s", path, "persionTempalte.xlsx"));
		List<UploadUser>	s=excelUtil.parse(inputStream, UploadUser.class);
		System.out.println(s.size());
	}

}
