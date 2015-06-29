package com.isse.datamodel;

public class EndProjectProperty {
	private String year;
	private String jieqiId;
	private String unitId;
	private String professionId;
	private String studentNumber;
	private String endprojectState;
	private String endprojectScore;
	private String projectName;
	
	public EndProjectProperty() {
	}
	public EndProjectProperty(String year, String jieqiId, String unitId,
			String professionId, String studentNumber, String endprojectState,
			String endprojectScore, String projectName) {
		this.year = year;
		this.jieqiId = jieqiId;
		this.unitId = unitId;
		this.professionId = professionId;
		this.studentNumber = studentNumber;
		this.endprojectState = endprojectState;
		this.endprojectScore = endprojectScore;
		this.projectName = projectName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getJieqiId() {
		return jieqiId;
	}
	public void setJieqiId(String jieqiId) {
		this.jieqiId = jieqiId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getProfessionId() {
		return professionId;
	}
	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getEndprojectState() {
		return endprojectState;
	}
	public void setEndprojectState(String endprojectState) {
		this.endprojectState = endprojectState;
	}
	public String getEndprojectScore() {
		return endprojectScore;
	}
	public void setEndprojectScore(String endprojectScore) {
		this.endprojectScore = endprojectScore;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
