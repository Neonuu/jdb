package com.zp.jdb.entity;

import java.util.Date;

/**
 * 系统日志实体类
 * @author lenovo
 *
 */
public class System_Journal {
	
	private Long id;//id
	private String operation_content;//操作内容
	private String module;//所属模块
	private Date date;//操作时间
	private String operator;//操作人
	private String type;//动作类型
	private Integer is_del;
	
	
	private Integer page;//第几页
	private String strDate;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperation_content() {
		return operation_content;
	}
	public void setOperation_content(String operation_content) {
		this.operation_content = operation_content;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getIs_del() {
		return is_del;
	}
	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
	@Override
	public String toString() {
		return "System_Journal [id=" + id + ", operation_content=" + operation_content + ", module=" + module
				+ ", date=" + date + ", operator=" + operator + ", type=" + type + ", is_del=" + is_del + ", page="
				+ page + ", strDate=" + strDate + "]";
	}
	
	
	
	
	
	
}
