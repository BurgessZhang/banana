package com.burgess;

import java.io.Serializable;
import java.util.Date;

import com.burgess.excel.annotation.ColumnFormat;
import com.burgess.excel.annotation.ExcelColumn;
import com.burgess.excel.annotation.ExcelSheet;

/**
 * @project banana-excel
 * @package com.burgess
 * @file Student.java
 * @author burgess.zhang
 * @time 上午11:43:04/2018年8月29日
 * @desc 
 */
@ExcelSheet
public class Student implements Serializable{
	
	private static final long serialVersionUID = 8421236166028626113L;

	@ExcelColumn(fieldTitle = "编号", columnIndex = 0)
	private String id;
	
	@ExcelColumn(fieldTitle = "姓名", columnIndex = 1)
	private String name;
	
	@ExcelColumn(fieldTitle = "性别", columnIndex = 2)
	private String sex;
	
	@ExcelColumn(fieldTitle = "年龄", columnIndex = 3)
	private Integer age;
	
	@ExcelColumn(fieldTitle = "生日", columnIndex = 4)
	@ColumnFormat(value = "yyyy-MM-dd")
	private Date borthDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBorthDate() {
		return borthDate;
	}
	public void setBorthDate(Date borthDate) {
		this.borthDate = borthDate;
	}
}
