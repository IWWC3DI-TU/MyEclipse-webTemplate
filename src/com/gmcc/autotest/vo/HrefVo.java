package com.gmcc.autotest.vo;
/**
 * 
 * @author Michael
 *  Value Object of Href_Link
 */
public class HrefVo {
	private String hrefName = ""; // 连接名称

	private String hrefAdress = "";// 连接源地址

	private String delay = "";// 延时

	private String error_code = "";// 返回错误代码

	private String error_content = "";// 错误原因
	
	private String top_page = "";//页面从属
	
	private String pageLevel = "";//页面所属级别
	
	private String isValid = "";//是否有效

	public String getHrefName() {
		return hrefName;
	}

	public void setHrefName(String hrefName) {
		this.hrefName = hrefName;
	}

	public String getHrefAdress() {
		return hrefAdress;
	}

	public void setHrefAdress(String hrefAdress) {
		this.hrefAdress = hrefAdress;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_content() {
		return error_content;
	}

	public void setError_content(String error_content) {
		this.error_content = error_content;
	}

	/**
	 * @return the top_page
	 */
	public String getTop_page() {
		return top_page;
	}

	/**
	 * @param top_page the top_page to set
	 */
	public void setTop_page(String top_page) {
		this.top_page = top_page;
	}

	/**
	 * @return the pageLevel
	 */
	public String getPageLevel() {
		return pageLevel;
	}

	/**
	 * @param pageLevel the pageLevel to set
	 */
	public void setPageLevel(String pageLevel) {
		this.pageLevel = pageLevel;
	}

	/**
	 * @return the isValid
	 */
	public String getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}
