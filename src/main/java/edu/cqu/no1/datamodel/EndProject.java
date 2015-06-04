package edu.cqu.no1.datamodel;

import java.util.Date;


/**
 * Created by ZKQ on 2015/6/4.
 */


public class EndProject {
	private String endprojectId;
	private String projectNumber;
	private String projectName;
	private String studentNunber;
	private String studentName;
	private String unitName;
	private String professionName;
	private String year;
	private String qici;
	private String endprojectScore;
	private Date unitTypeinTime;
	private String lastScore;
	public EndProject(){
		
	}
	
	public EndProject(String endprojectId, String projectNumber,
			String projectName, String studentNunber, String studentName,
			String unitName, String professionName, String year, String qici,
			String endprojectScore, Date unitTypeinTime, String lastScore) {
		super();
		this.endprojectId = endprojectId;
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.studentNunber = studentNunber;
		this.studentName = studentName;
		this.unitName = unitName;
		this.professionName = professionName;
		this.year = year;
		this.qici = qici;
		this.endprojectScore = endprojectScore;
		this.unitTypeinTime = unitTypeinTime;
		this.lastScore = lastScore;
	}

	public String getEndprojectId() {
		return endprojectId;
	}
	public void setEndprojectId(String endprojectId) {
		this.endprojectId = endprojectId;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStudentNunber() {
		return studentNunber;
	}
	public void setStudentNunber(String studentNunber) {
		this.studentNunber = studentNunber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
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
	public String getEndprojectScore() {
		return endprojectScore;
	}
	public void setEndprojectScore(String endprojectScore) {
		this.endprojectScore = endprojectScore;
	}
	public Date getUnitTypeinTime() {
		return unitTypeinTime;
	}
	public void setUnitTypeinTime(Date unitTypeinTime) {
		this.unitTypeinTime = unitTypeinTime;
	}

	public String getLastScore() {
		return lastScore;
	}

	public void setLastScore(String lastScore) {
		this.lastScore = lastScore;
	}
	
}
