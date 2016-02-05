package com.zp.jdb.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.zp.jdb.util.ConstantValue;

/**
 * 72小时内订单信息表
 * @author Administrator
 *
 */
public class Order_inHours {

	private Long id;
	private Long user_id;
	private String user_phoneNumber;
	private String order_number;
	private String user_identity;
	private String product;
	private String true_name;
	private String user_idCardNumber;
	private String tel_number;
	private String province;
	private String city;
	private Date add_time;
	private Integer status_cailiao;
	private Integer status;//订单状态     0:收集材料 3：成功放款，4：佣金到账，5：订单关闭
	private String auditer_name;
	private BigDecimal money;//订单金额
	private String remarks;
	private Integer is_del;
	private Integer jigou_id;
	

	public Integer getJigou_id() {
		return jigou_id;
	}
	public void setJigou_id(Integer jigou_id) {
		this.jigou_id = jigou_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_phoneNumber() {
		return user_phoneNumber;
	}
	public void setUser_phoneNumber(String user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}
	public String getOrder_number() {
		return order_number;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getStatus_cailiao() {
		return status_cailiao;
	}
	public void setStatus_cailiao(Integer status_cailiao) {
		this.status_cailiao = status_cailiao;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getUser_identity() {
		return user_identity;
	}
	public void setUser_identity(String user_identity) {
		this.user_identity = user_identity;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}
	public String getUser_idCardNumber() {
		return user_idCardNumber;
	}
	public void setUser_idCardNumber(String user_idCardNumber) {
		this.user_idCardNumber = user_idCardNumber;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public String getAuditer_name() {
		return auditer_name;
	}
	public void setAuditer_name(String auditer_name) {
		this.auditer_name = auditer_name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getIs_del() {
		return is_del;
	}
	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
	
	
	
	
	
	
	    //页码
		private Integer pagenum;
		
		//起始下标
		private Integer startIndex;
		
		//每页几条
		private Integer pagecount = ConstantValue.PAGE_COUNT;
		
		//总条数
		private Integer totalCount;
		
		//最大页码
		private Integer maxpage;

		private Integer pm;
		
		private String user_name;
		
		private Integer ord;

		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public Integer getPm() {
			return pm;
		}
		public void setPm(Integer pm) {
			this.pm = pm;
		}
		public Integer getOrd() {
			return ord;
		}
		public void setOrd(Integer ord) {
			this.ord = ord;
		}
		public Integer getPagenum() {
			return pagenum;
		}
		public void setPagenum(Integer pagenum) {
			this.pagenum = pagenum;
		}
		public Integer getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(Integer startIndex) {
			this.startIndex = startIndex;
		}
		public Integer getPagecount() {
			return pagecount;
		}
		public void setPagecount(Integer pagecount) {
			this.pagecount = pagecount;
		}
		public Integer getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(Integer totalCount) {
			this.totalCount = totalCount;
		}
		public Integer getMaxpage() {
			return maxpage;
		}
		public void setMaxpage(Integer maxpage) {
			this.maxpage = maxpage;
		}
	
	
		 
		
		
}
