package com.isse.model;



/**
 * TEndprojectJob entity. @author MyEclipse Persistence Tools
 */

public class TEndprojectJob  implements java.io.Serializable {


    // Fields    

     private String jobId;
     private TStudent TStudent;
     private TEndProject TEndProject;
     private String jobContent;
     private String finished;
     private String isdeleted;


    // Constructors

    /** default constructor */
    public TEndprojectJob() {
    }

    
    /** full constructor */
    public TEndprojectJob(TStudent TStudent, TEndProject TEndProject, String jobContent, String finished, String isdeleted) {
        this.TStudent = TStudent;
        this.TEndProject = TEndProject;
        this.jobContent = jobContent;
        this.finished = finished;
        this.isdeleted = isdeleted;
    }

   
    // Property accessors

    public String getJobId() {
        return this.jobId;
    }
    
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public TStudent getTStudent() {
        return this.TStudent;
    }
    
    public void setTStudent(TStudent TStudent) {
        this.TStudent = TStudent;
    }

    public TEndProject getTEndProject() {
        return this.TEndProject;
    }
    
    public void setTEndProject(TEndProject TEndProject) {
        this.TEndProject = TEndProject;
    }

    public String getJobContent() {
        return this.jobContent;
    }
    
    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getFinished() {
        return this.finished;
    }
    
    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }
   








}