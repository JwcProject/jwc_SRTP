package edu.cqu.no1.datamodel;

public class EndProjectProperty {
	private String year;
	private String jieqiId;
	private String unitId;
	private String professionId;
	private String studentNumber;
	private String endProjectState;
	private String endProjectScore;
	private String projectName;
	
	public EndProjectProperty() {
	}
	public EndProjectProperty(String year, String jieqiId, String unitId,
			String professionId, String studentNumber, String endProjectState,
			String endProjectScore, String projectName) {
		this.year = year;
		this.jieqiId = jieqiId;
		this.unitId = unitId;
		this.professionId = professionId;
		this.studentNumber = studentNumber;
		this.endProjectState = endProjectState;
		this.endProjectScore = endProjectScore;
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
	public String getEndProjectState() {
		return endProjectState;
	}
	public void setEndProjectState(String endProjectState) {
		this.endProjectState = endProjectState;
	}
	public String getEndProjectScore() {
		return endProjectScore;
	}
	public void setEndProjectScore(String endProjectScore) {
		this.endProjectScore = endProjectScore;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
