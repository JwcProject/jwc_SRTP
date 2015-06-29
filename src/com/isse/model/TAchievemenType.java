package com.isse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TAchievemenType entity. @author MyEclipse Persistence Tools
 */

public class TAchievemenType implements java.io.Serializable {

	// Fields

	private String achievementypeId;
	private String achievementypeName;
	private String achievementypeIntroduction;
	private String isdeleted;
	private Set TAchievements = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAchievemenType() {
	}

	/** full constructor */
	public TAchievemenType(String achievementypeName,
			String achievementypeIntroduction, String isdeleted,
			Set TAchievements) {
		this.achievementypeName = achievementypeName;
		this.achievementypeIntroduction = achievementypeIntroduction;
		this.isdeleted = isdeleted;
		this.TAchievements = TAchievements;
	}

	// Property accessors

	public String getAchievementypeId() {
		return this.achievementypeId;
	}

	public void setAchievementypeId(String achievementypeId) {
		this.achievementypeId = achievementypeId;
	}

	public String getAchievementypeName() {
		return this.achievementypeName;
	}

	public void setAchievementypeName(String achievementypeName) {
		this.achievementypeName = achievementypeName;
	}

	public String getAchievementypeIntroduction() {
		return this.achievementypeIntroduction;
	}

	public void setAchievementypeIntroduction(String achievementypeIntroduction) {
		this.achievementypeIntroduction = achievementypeIntroduction;
	}

	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set getTAchievements() {
		return this.TAchievements;
	}

	public void setTAchievements(Set TAchievements) {
		this.TAchievements = TAchievements;
	}

}