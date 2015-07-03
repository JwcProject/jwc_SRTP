package edu.cqu.no1.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TAchievemenType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_achievemen_type", catalog = "srtp")
public class TAchievemenType implements java.io.Serializable {

	// Fields

	private String achievementypeId;
	private String achievementypeIntroduction;
	private String achievementypeName;
	private String isdeleted;
	private Set<TAchievement> TAchievements = new HashSet<TAchievement>(0);

	// Constructors

	/** default constructor */
	public TAchievemenType() {
	}

	/** full constructor */
	public TAchievemenType(String achievementypeIntroduction,
			String achievementypeName, String isdeleted,
			Set<TAchievement> TAchievements) {
		this.achievementypeIntroduction = achievementypeIntroduction;
		this.achievementypeName = achievementypeName;
		this.isdeleted = isdeleted;
		this.TAchievements = TAchievements;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "achievementype_id", unique = true, nullable = false, length = 32)
	public String getAchievementypeId() {
		return this.achievementypeId;
	}

	public void setAchievementypeId(String achievementypeId) {
		this.achievementypeId = achievementypeId;
	}

	@Column(name = "achievementype_introduction", length = 200)
	public String getAchievementypeIntroduction() {
		return this.achievementypeIntroduction;
	}

	public void setAchievementypeIntroduction(String achievementypeIntroduction) {
		this.achievementypeIntroduction = achievementypeIntroduction;
	}

	@Column(name = "achievementype_name", length = 50)
	public String getAchievementypeName() {
		return this.achievementypeName;
	}

	public void setAchievementypeName(String achievementypeName) {
		this.achievementypeName = achievementypeName;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAchievemenType")
	public Set<TAchievement> getTAchievements() {
		return this.TAchievements;
	}

	public void setTAchievements(Set<TAchievement> TAchievements) {
		this.TAchievements = TAchievements;
	}

}