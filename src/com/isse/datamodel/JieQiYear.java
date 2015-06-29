package com.isse.datamodel;

/**
 * @Create Date：2013-7-27上午10:44:25
 * @Update Date：
 * @Author：lzh
 * TODO
 */
public class JieQiYear{
	private String yearKey;
	private String yearValue;
	
	public String getYearKey() {
		return yearKey;
	}
	public void setYearKey(String yearKey) {
		this.yearKey = yearKey;
	}
	public String getYearValue() {
		return yearValue;
	}
	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}
	/**
	 * @param yearkey
	 * @param yearValue
	 */
	public JieQiYear(String yearKey, String yearValue) {
		this.yearKey = yearKey;
		this.yearValue = yearValue;
	}
	/**
	 * 
	 */
	public JieQiYear() {
	}
	
}