package com.isse.datamodel;


public class ExpertTeacher {
	private String expertTeacherId;
	private String teaName;
	private String teaCode;
	private String unitName;
	private String teaTitle;
	private String year;
	private String qici;
	public ExpertTeacher(String expertTeacherId, String teaName,
			String teaCode, String unitName, String teaTitle, String year,
			String qici) {
		super();
		this.expertTeacherId = expertTeacherId;
		this.teaName = teaName;
		this.teaCode = teaCode;
		this.unitName = unitName;
		this.teaTitle = teaTitle;
		this.year = year;
		this.qici = qici;
	}
	public ExpertTeacher(){
		
	}
	public String getExpertTeacherId() {
		return expertTeacherId;
	}
	public void setExpertTeacherId(String expertTeacherId) {
		this.expertTeacherId = expertTeacherId;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaCode() {
		return teaCode;
	}
	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getTeaTitle() {
		return teaTitle;
	}
	public void setTeaTitle(String teaTitle) {
		this.teaTitle = teaTitle;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQici() {
		return qici;
	}
	public void setQici(String qici) {
		this.qici = qici;
	}
	
}
