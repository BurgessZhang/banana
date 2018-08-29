package com.burgess;

import java.io.Serializable;

import com.burgess.excel.annotation.ExcelColumn;
import com.burgess.excel.annotation.ExcelSheet;

/**
 * @project banana-excel
 * @package com.burgess
 * @file UploadUser.java
 * @author burgess.zhang
 * @time 上午11:44:04/2018年8月29日
 * @desc
 */
@ExcelSheet(titleIndex = 1, dataIndex = 2)
public class UploadUser implements Serializable {
	private static final long serialVersionUID = 8965237466304032518L;
	@ExcelColumn(fieldTitle = "登录名称", columnIndex = 0)
	private String username;
	@ExcelColumn(fieldTitle = "角色", columnIndex = 1)
	// @ColumnDataHandler("io.tsing.admin.util.RoleTranslate")
	private String role;
	@ExcelColumn(fieldTitle = "昵称", columnIndex = 2)
	private String nickname;
	@ExcelColumn(fieldTitle = "姓名", columnIndex = 3)
	private String realname;
	@ExcelColumn(fieldTitle = "性别", columnIndex = 4)
	private String gender;
	@ExcelColumn(fieldTitle = "密码", columnIndex = 5)
	// @ColumnDataHandler("io.tsing.admin.util.PassWordTranslate")
	private String password;
	@ExcelColumn(fieldTitle = "邮件", columnIndex = 6)
	private String email;
	@ExcelColumn(fieldTitle = "手机号码", columnIndex = 7)
	private String mobile;
	@ExcelColumn(fieldTitle = "电话号码", columnIndex = 8)
	private String telephone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
