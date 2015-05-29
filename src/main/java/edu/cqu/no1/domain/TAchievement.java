package edu.cqu.no1.domain;// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TAchievement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_achievement", catalog = "srtp")
public class TAchievement implements java.io.Serializable {

	// Fields

	private String achievementId;
	private TProject TProject;
	private TAchievemenType TAchievemenType;
	private String achievementIntroduction;
	private String achievementOwner;
	private String achievementName;
	private String achievementJournal;
	private Timestamp achievementDate;
	private String achievementVolume;
	private String achievementType;
	private String achievementPatent;
	private String isdeleted;
	private String userdefine50;
	private String userdefine49;
	private String userdefine48;
	private String userdefine47;
	private String userdefine46;
	private String userdefine45;
	private String userdefine44;
	private String userdefine43;
	private String userdefine42;
	private String userdefine41;
	private String userdefine40;
	private String userdefine39;
	private String userdefine38;
	private String userdefine37;
	private String userdefine36;
	private String userdefine35;
	private String userdefine34;
	private String userdefine33;
	private String userdefine32;
	private String userdefine31;
	private String userdefine30;
	private String userdefine29;
	private String userdefine28;
	private String userdefine27;
	private String userdefine26;
	private String userdefine25;
	private String userdefine24;
	private String userdefine23;
	private String userdefine22;
	private String userdefine21;
	private String userdefine20;
	private String userdefine19;
	private String userdefine18;
	private String userdefine17;
	private String userdefine16;
	private String userdefine15;
	private String userdefine14;
	private String userdefine13;
	private String userdefine12;
	private String userdefine11;
	private String userdefine10;
	private String userdefine9;
	private String userdefine8;
	private String userdefine7;
	private String userdefine6;
	private String userdefine5;
	private String userdefine4;
	private String userdefine3;
	private String userdefine1;
	private String userdefine2;

	// Constructors

	/** default constructor */
	public TAchievement() {
	}

	/** full constructor */
	public TAchievement(TProject TProject, TAchievemenType TAchievemenType,
			String achievementIntroduction, String achievementOwner,
			String achievementName, String achievementJournal,
			Timestamp achievementDate, String achievementVolume,
			String achievementType, String achievementPatent, String isdeleted,
			String userdefine50, String userdefine49, String userdefine48,
			String userdefine47, String userdefine46, String userdefine45,
			String userdefine44, String userdefine43, String userdefine42,
			String userdefine41, String userdefine40, String userdefine39,
			String userdefine38, String userdefine37, String userdefine36,
			String userdefine35, String userdefine34, String userdefine33,
			String userdefine32, String userdefine31, String userdefine30,
			String userdefine29, String userdefine28, String userdefine27,
			String userdefine26, String userdefine25, String userdefine24,
			String userdefine23, String userdefine22, String userdefine21,
			String userdefine20, String userdefine19, String userdefine18,
			String userdefine17, String userdefine16, String userdefine15,
			String userdefine14, String userdefine13, String userdefine12,
			String userdefine11, String userdefine10, String userdefine9,
			String userdefine8, String userdefine7, String userdefine6,
			String userdefine5, String userdefine4, String userdefine3,
			String userdefine1, String userdefine2) {
		this.TProject = TProject;
		this.TAchievemenType = TAchievemenType;
		this.achievementIntroduction = achievementIntroduction;
		this.achievementOwner = achievementOwner;
		this.achievementName = achievementName;
		this.achievementJournal = achievementJournal;
		this.achievementDate = achievementDate;
		this.achievementVolume = achievementVolume;
		this.achievementType = achievementType;
		this.achievementPatent = achievementPatent;
		this.isdeleted = isdeleted;
		this.userdefine50 = userdefine50;
		this.userdefine49 = userdefine49;
		this.userdefine48 = userdefine48;
		this.userdefine47 = userdefine47;
		this.userdefine46 = userdefine46;
		this.userdefine45 = userdefine45;
		this.userdefine44 = userdefine44;
		this.userdefine43 = userdefine43;
		this.userdefine42 = userdefine42;
		this.userdefine41 = userdefine41;
		this.userdefine40 = userdefine40;
		this.userdefine39 = userdefine39;
		this.userdefine38 = userdefine38;
		this.userdefine37 = userdefine37;
		this.userdefine36 = userdefine36;
		this.userdefine35 = userdefine35;
		this.userdefine34 = userdefine34;
		this.userdefine33 = userdefine33;
		this.userdefine32 = userdefine32;
		this.userdefine31 = userdefine31;
		this.userdefine30 = userdefine30;
		this.userdefine29 = userdefine29;
		this.userdefine28 = userdefine28;
		this.userdefine27 = userdefine27;
		this.userdefine26 = userdefine26;
		this.userdefine25 = userdefine25;
		this.userdefine24 = userdefine24;
		this.userdefine23 = userdefine23;
		this.userdefine22 = userdefine22;
		this.userdefine21 = userdefine21;
		this.userdefine20 = userdefine20;
		this.userdefine19 = userdefine19;
		this.userdefine18 = userdefine18;
		this.userdefine17 = userdefine17;
		this.userdefine16 = userdefine16;
		this.userdefine15 = userdefine15;
		this.userdefine14 = userdefine14;
		this.userdefine13 = userdefine13;
		this.userdefine12 = userdefine12;
		this.userdefine11 = userdefine11;
		this.userdefine10 = userdefine10;
		this.userdefine9 = userdefine9;
		this.userdefine8 = userdefine8;
		this.userdefine7 = userdefine7;
		this.userdefine6 = userdefine6;
		this.userdefine5 = userdefine5;
		this.userdefine4 = userdefine4;
		this.userdefine3 = userdefine3;
		this.userdefine1 = userdefine1;
		this.userdefine2 = userdefine2;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "achievement_id", unique = true, nullable = false, length = 32)
	public String getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(String achievementId) {
		this.achievementId = achievementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public TProject getTProject() {
		return this.TProject;
	}

	public void setTProject(TProject TProject) {
		this.TProject = TProject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "achievementype_id")
	public TAchievemenType getTAchievemenType() {
		return this.TAchievemenType;
	}

	public void setTAchievemenType(TAchievemenType TAchievemenType) {
		this.TAchievemenType = TAchievemenType;
	}

	@Column(name = "achievement_introduction", length = 200)
	public String getAchievementIntroduction() {
		return this.achievementIntroduction;
	}

	public void setAchievementIntroduction(String achievementIntroduction) {
		this.achievementIntroduction = achievementIntroduction;
	}

	@Column(name = "achievement_owner", length = 50)
	public String getAchievementOwner() {
		return this.achievementOwner;
	}

	public void setAchievementOwner(String achievementOwner) {
		this.achievementOwner = achievementOwner;
	}

	@Column(name = "achievement_name", length = 50)
	public String getAchievementName() {
		return this.achievementName;
	}

	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}

	@Column(name = "achievement_journal", length = 50)
	public String getAchievementJournal() {
		return this.achievementJournal;
	}

	public void setAchievementJournal(String achievementJournal) {
		this.achievementJournal = achievementJournal;
	}

	@Column(name = "achievement_date", length = 19)
	public Timestamp getAchievementDate() {
		return this.achievementDate;
	}

	public void setAchievementDate(Timestamp achievementDate) {
		this.achievementDate = achievementDate;
	}

	@Column(name = "achievement_volume", length = 50)
	public String getAchievementVolume() {
		return this.achievementVolume;
	}

	public void setAchievementVolume(String achievementVolume) {
		this.achievementVolume = achievementVolume;
	}

	@Column(name = "achievement_type", length = 50)
	public String getAchievementType() {
		return this.achievementType;
	}

	public void setAchievementType(String achievementType) {
		this.achievementType = achievementType;
	}

	@Column(name = "achievement_patent", length = 50)
	public String getAchievementPatent() {
		return this.achievementPatent;
	}

	public void setAchievementPatent(String achievementPatent) {
		this.achievementPatent = achievementPatent;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "userdefine50", length = 100)
	public String getUserdefine50() {
		return this.userdefine50;
	}

	public void setUserdefine50(String userdefine50) {
		this.userdefine50 = userdefine50;
	}

	@Column(name = "userdefine49", length = 100)
	public String getUserdefine49() {
		return this.userdefine49;
	}

	public void setUserdefine49(String userdefine49) {
		this.userdefine49 = userdefine49;
	}

	@Column(name = "userdefine48", length = 100)
	public String getUserdefine48() {
		return this.userdefine48;
	}

	public void setUserdefine48(String userdefine48) {
		this.userdefine48 = userdefine48;
	}

	@Column(name = "userdefine47", length = 100)
	public String getUserdefine47() {
		return this.userdefine47;
	}

	public void setUserdefine47(String userdefine47) {
		this.userdefine47 = userdefine47;
	}

	@Column(name = "userdefine46", length = 100)
	public String getUserdefine46() {
		return this.userdefine46;
	}

	public void setUserdefine46(String userdefine46) {
		this.userdefine46 = userdefine46;
	}

	@Column(name = "userdefine45", length = 100)
	public String getUserdefine45() {
		return this.userdefine45;
	}

	public void setUserdefine45(String userdefine45) {
		this.userdefine45 = userdefine45;
	}

	@Column(name = "userdefine44", length = 100)
	public String getUserdefine44() {
		return this.userdefine44;
	}

	public void setUserdefine44(String userdefine44) {
		this.userdefine44 = userdefine44;
	}

	@Column(name = "userdefine43", length = 100)
	public String getUserdefine43() {
		return this.userdefine43;
	}

	public void setUserdefine43(String userdefine43) {
		this.userdefine43 = userdefine43;
	}

	@Column(name = "userdefine42", length = 100)
	public String getUserdefine42() {
		return this.userdefine42;
	}

	public void setUserdefine42(String userdefine42) {
		this.userdefine42 = userdefine42;
	}

	@Column(name = "userdefine41", length = 100)
	public String getUserdefine41() {
		return this.userdefine41;
	}

	public void setUserdefine41(String userdefine41) {
		this.userdefine41 = userdefine41;
	}

	@Column(name = "userdefine40", length = 100)
	public String getUserdefine40() {
		return this.userdefine40;
	}

	public void setUserdefine40(String userdefine40) {
		this.userdefine40 = userdefine40;
	}

	@Column(name = "userdefine39", length = 100)
	public String getUserdefine39() {
		return this.userdefine39;
	}

	public void setUserdefine39(String userdefine39) {
		this.userdefine39 = userdefine39;
	}

	@Column(name = "userdefine38", length = 100)
	public String getUserdefine38() {
		return this.userdefine38;
	}

	public void setUserdefine38(String userdefine38) {
		this.userdefine38 = userdefine38;
	}

	@Column(name = "userdefine37", length = 100)
	public String getUserdefine37() {
		return this.userdefine37;
	}

	public void setUserdefine37(String userdefine37) {
		this.userdefine37 = userdefine37;
	}

	@Column(name = "userdefine36", length = 100)
	public String getUserdefine36() {
		return this.userdefine36;
	}

	public void setUserdefine36(String userdefine36) {
		this.userdefine36 = userdefine36;
	}

	@Column(name = "userdefine35", length = 100)
	public String getUserdefine35() {
		return this.userdefine35;
	}

	public void setUserdefine35(String userdefine35) {
		this.userdefine35 = userdefine35;
	}

	@Column(name = "userdefine34", length = 100)
	public String getUserdefine34() {
		return this.userdefine34;
	}

	public void setUserdefine34(String userdefine34) {
		this.userdefine34 = userdefine34;
	}

	@Column(name = "userdefine33", length = 100)
	public String getUserdefine33() {
		return this.userdefine33;
	}

	public void setUserdefine33(String userdefine33) {
		this.userdefine33 = userdefine33;
	}

	@Column(name = "userdefine32", length = 100)
	public String getUserdefine32() {
		return this.userdefine32;
	}

	public void setUserdefine32(String userdefine32) {
		this.userdefine32 = userdefine32;
	}

	@Column(name = "userdefine31", length = 100)
	public String getUserdefine31() {
		return this.userdefine31;
	}

	public void setUserdefine31(String userdefine31) {
		this.userdefine31 = userdefine31;
	}

	@Column(name = "userdefine30", length = 100)
	public String getUserdefine30() {
		return this.userdefine30;
	}

	public void setUserdefine30(String userdefine30) {
		this.userdefine30 = userdefine30;
	}

	@Column(name = "userdefine29", length = 100)
	public String getUserdefine29() {
		return this.userdefine29;
	}

	public void setUserdefine29(String userdefine29) {
		this.userdefine29 = userdefine29;
	}

	@Column(name = "userdefine28", length = 100)
	public String getUserdefine28() {
		return this.userdefine28;
	}

	public void setUserdefine28(String userdefine28) {
		this.userdefine28 = userdefine28;
	}

	@Column(name = "userdefine27", length = 100)
	public String getUserdefine27() {
		return this.userdefine27;
	}

	public void setUserdefine27(String userdefine27) {
		this.userdefine27 = userdefine27;
	}

	@Column(name = "userdefine26", length = 100)
	public String getUserdefine26() {
		return this.userdefine26;
	}

	public void setUserdefine26(String userdefine26) {
		this.userdefine26 = userdefine26;
	}

	@Column(name = "userdefine25", length = 100)
	public String getUserdefine25() {
		return this.userdefine25;
	}

	public void setUserdefine25(String userdefine25) {
		this.userdefine25 = userdefine25;
	}

	@Column(name = "userdefine24", length = 100)
	public String getUserdefine24() {
		return this.userdefine24;
	}

	public void setUserdefine24(String userdefine24) {
		this.userdefine24 = userdefine24;
	}

	@Column(name = "userdefine23", length = 100)
	public String getUserdefine23() {
		return this.userdefine23;
	}

	public void setUserdefine23(String userdefine23) {
		this.userdefine23 = userdefine23;
	}

	@Column(name = "userdefine22", length = 100)
	public String getUserdefine22() {
		return this.userdefine22;
	}

	public void setUserdefine22(String userdefine22) {
		this.userdefine22 = userdefine22;
	}

	@Column(name = "userdefine21", length = 100)
	public String getUserdefine21() {
		return this.userdefine21;
	}

	public void setUserdefine21(String userdefine21) {
		this.userdefine21 = userdefine21;
	}

	@Column(name = "userdefine20", length = 100)
	public String getUserdefine20() {
		return this.userdefine20;
	}

	public void setUserdefine20(String userdefine20) {
		this.userdefine20 = userdefine20;
	}

	@Column(name = "userdefine19", length = 100)
	public String getUserdefine19() {
		return this.userdefine19;
	}

	public void setUserdefine19(String userdefine19) {
		this.userdefine19 = userdefine19;
	}

	@Column(name = "userdefine18", length = 100)
	public String getUserdefine18() {
		return this.userdefine18;
	}

	public void setUserdefine18(String userdefine18) {
		this.userdefine18 = userdefine18;
	}

	@Column(name = "userdefine17", length = 100)
	public String getUserdefine17() {
		return this.userdefine17;
	}

	public void setUserdefine17(String userdefine17) {
		this.userdefine17 = userdefine17;
	}

	@Column(name = "userdefine16", length = 100)
	public String getUserdefine16() {
		return this.userdefine16;
	}

	public void setUserdefine16(String userdefine16) {
		this.userdefine16 = userdefine16;
	}

	@Column(name = "userdefine15", length = 100)
	public String getUserdefine15() {
		return this.userdefine15;
	}

	public void setUserdefine15(String userdefine15) {
		this.userdefine15 = userdefine15;
	}

	@Column(name = "userdefine14", length = 100)
	public String getUserdefine14() {
		return this.userdefine14;
	}

	public void setUserdefine14(String userdefine14) {
		this.userdefine14 = userdefine14;
	}

	@Column(name = "userdefine13", length = 100)
	public String getUserdefine13() {
		return this.userdefine13;
	}

	public void setUserdefine13(String userdefine13) {
		this.userdefine13 = userdefine13;
	}

	@Column(name = "userdefine12", length = 100)
	public String getUserdefine12() {
		return this.userdefine12;
	}

	public void setUserdefine12(String userdefine12) {
		this.userdefine12 = userdefine12;
	}

	@Column(name = "userdefine11", length = 100)
	public String getUserdefine11() {
		return this.userdefine11;
	}

	public void setUserdefine11(String userdefine11) {
		this.userdefine11 = userdefine11;
	}

	@Column(name = "userdefine10", length = 100)
	public String getUserdefine10() {
		return this.userdefine10;
	}

	public void setUserdefine10(String userdefine10) {
		this.userdefine10 = userdefine10;
	}

	@Column(name = "userdefine9", length = 100)
	public String getUserdefine9() {
		return this.userdefine9;
	}

	public void setUserdefine9(String userdefine9) {
		this.userdefine9 = userdefine9;
	}

	@Column(name = "userdefine8", length = 100)
	public String getUserdefine8() {
		return this.userdefine8;
	}

	public void setUserdefine8(String userdefine8) {
		this.userdefine8 = userdefine8;
	}

	@Column(name = "userdefine7", length = 100)
	public String getUserdefine7() {
		return this.userdefine7;
	}

	public void setUserdefine7(String userdefine7) {
		this.userdefine7 = userdefine7;
	}

	@Column(name = "userdefine6", length = 100)
	public String getUserdefine6() {
		return this.userdefine6;
	}

	public void setUserdefine6(String userdefine6) {
		this.userdefine6 = userdefine6;
	}

	@Column(name = "userdefine5", length = 100)
	public String getUserdefine5() {
		return this.userdefine5;
	}

	public void setUserdefine5(String userdefine5) {
		this.userdefine5 = userdefine5;
	}

	@Column(name = "userdefine4", length = 100)
	public String getUserdefine4() {
		return this.userdefine4;
	}

	public void setUserdefine4(String userdefine4) {
		this.userdefine4 = userdefine4;
	}

	@Column(name = "userdefine3", length = 100)
	public String getUserdefine3() {
		return this.userdefine3;
	}

	public void setUserdefine3(String userdefine3) {
		this.userdefine3 = userdefine3;
	}

	@Column(name = "userdefine1", length = 100)
	public String getUserdefine1() {
		return this.userdefine1;
	}

	public void setUserdefine1(String userdefine1) {
		this.userdefine1 = userdefine1;
	}

	@Column(name = "userdefine2", length = 100)
	public String getUserdefine2() {
		return this.userdefine2;
	}

	public void setUserdefine2(String userdefine2) {
		this.userdefine2 = userdefine2;
	}

}