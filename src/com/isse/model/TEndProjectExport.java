package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TEndProjectExport entity. @author MyEclipse Persistence Tools
 */

public class TEndProjectExport implements java.io.Serializable {

	// Fields

	private String id;
	private TExpertTeacher TExpertTeacher;
	private TEndProject TEndProject;
	private String isdeleted;
	private Set TEndProjectComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public TEndProjectExport() {
	}

	/** full constructor */
	public TEndProjectExport(TExpertTeacher TExpertTeacher,
			TEndProject TEndProject, String isdeleted, Set TEndProjectComments) {
		this.TExpertTeacher = TExpertTeacher;
		this.TEndProject = TEndProject;
		this.isdeleted = isdeleted;
		this.TEndProjectComments = TEndProjectComments;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TExpertTeacher getTExpertTeacher() {
		return this.TExpertTeacher;
	}

	public void setTExpertTeacher(TExpertTeacher TExpertTeacher) {
		this.TExpertTeacher = TExpertTeacher;
	}

	public TEndProject getTEndProject() {
		return this.TEndProject;
	}

	public void setTEndProject(TEndProject TEndProject) {
		this.TEndProject = TEndProject;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTEndProjectComments() {
		return this.TEndProjectComments;
	}

	public void setTEndProjectComments(Set TEndProjectComments) {
		this.TEndProjectComments = TEndProjectComments;
	}

}