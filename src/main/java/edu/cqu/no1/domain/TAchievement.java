package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@javax.persistence.Table(name = "t_achievement", schema = "", catalog = "srtp")
public class TAchievement {
    private String achievementId;

    @Id
    @javax.persistence.Column(name = "achievement_id")
    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    private String projectId;

    @Basic
    @javax.persistence.Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    private String achievementypeId;

    @Basic
    @javax.persistence.Column(name = "achievementype_id")
    public String getAchievementypeId() {
        return achievementypeId;
    }

    public void setAchievementypeId(String achievementypeId) {
        this.achievementypeId = achievementypeId;
    }

    private String achievementIntroduction;

    @Basic
    @javax.persistence.Column(name = "achievement_introduction")
    public String getAchievementIntroduction() {
        return achievementIntroduction;
    }

    public void setAchievementIntroduction(String achievementIntroduction) {
        this.achievementIntroduction = achievementIntroduction;
    }

    private String achievementOwner;

    @Basic
    @javax.persistence.Column(name = "achievement_owner")
    public String getAchievementOwner() {
        return achievementOwner;
    }

    public void setAchievementOwner(String achievementOwner) {
        this.achievementOwner = achievementOwner;
    }

    private String achievementName;

    @Basic
    @javax.persistence.Column(name = "achievement_name")
    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    private String achievementJournal;

    @Basic
    @javax.persistence.Column(name = "achievement_journal")
    public String getAchievementJournal() {
        return achievementJournal;
    }

    public void setAchievementJournal(String achievementJournal) {
        this.achievementJournal = achievementJournal;
    }

    private Timestamp achievementDate;

    @Basic
    @javax.persistence.Column(name = "achievement_date")
    public Timestamp getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(Timestamp achievementDate) {
        this.achievementDate = achievementDate;
    }

    private String achievementVolume;

    @Basic
    @javax.persistence.Column(name = "achievement_volume")
    public String getAchievementVolume() {
        return achievementVolume;
    }

    public void setAchievementVolume(String achievementVolume) {
        this.achievementVolume = achievementVolume;
    }

    private String achievementType;

    @Basic
    @javax.persistence.Column(name = "achievement_type")
    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    private String achievementPatent;

    @Basic
    @javax.persistence.Column(name = "achievement_patent")
    public String getAchievementPatent() {
        return achievementPatent;
    }

    public void setAchievementPatent(String achievementPatent) {
        this.achievementPatent = achievementPatent;
    }

    private String isdeleted;

    @Basic
    @javax.persistence.Column(name = "isdeleted")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    private String userdefine50;

    @Basic
    @javax.persistence.Column(name = "userdefine50")
    public String getUserdefine50() {
        return userdefine50;
    }

    public void setUserdefine50(String userdefine50) {
        this.userdefine50 = userdefine50;
    }

    private String userdefine49;

    @Basic
    @javax.persistence.Column(name = "userdefine49")
    public String getUserdefine49() {
        return userdefine49;
    }

    public void setUserdefine49(String userdefine49) {
        this.userdefine49 = userdefine49;
    }

    private String userdefine48;

    @Basic
    @javax.persistence.Column(name = "userdefine48")
    public String getUserdefine48() {
        return userdefine48;
    }

    public void setUserdefine48(String userdefine48) {
        this.userdefine48 = userdefine48;
    }

    private String userdefine47;

    @Basic
    @javax.persistence.Column(name = "userdefine47")
    public String getUserdefine47() {
        return userdefine47;
    }

    public void setUserdefine47(String userdefine47) {
        this.userdefine47 = userdefine47;
    }

    private String userdefine46;

    @Basic
    @javax.persistence.Column(name = "userdefine46")
    public String getUserdefine46() {
        return userdefine46;
    }

    public void setUserdefine46(String userdefine46) {
        this.userdefine46 = userdefine46;
    }

    private String userdefine45;

    @Basic
    @javax.persistence.Column(name = "userdefine45")
    public String getUserdefine45() {
        return userdefine45;
    }

    public void setUserdefine45(String userdefine45) {
        this.userdefine45 = userdefine45;
    }

    private String userdefine44;

    @Basic
    @javax.persistence.Column(name = "userdefine44")
    public String getUserdefine44() {
        return userdefine44;
    }

    public void setUserdefine44(String userdefine44) {
        this.userdefine44 = userdefine44;
    }

    private String userdefine43;

    @Basic
    @javax.persistence.Column(name = "userdefine43")
    public String getUserdefine43() {
        return userdefine43;
    }

    public void setUserdefine43(String userdefine43) {
        this.userdefine43 = userdefine43;
    }

    private String userdefine42;

    @Basic
    @javax.persistence.Column(name = "userdefine42")
    public String getUserdefine42() {
        return userdefine42;
    }

    public void setUserdefine42(String userdefine42) {
        this.userdefine42 = userdefine42;
    }

    private String userdefine41;

    @Basic
    @javax.persistence.Column(name = "userdefine41")
    public String getUserdefine41() {
        return userdefine41;
    }

    public void setUserdefine41(String userdefine41) {
        this.userdefine41 = userdefine41;
    }

    private String userdefine40;

    @Basic
    @javax.persistence.Column(name = "userdefine40")
    public String getUserdefine40() {
        return userdefine40;
    }

    public void setUserdefine40(String userdefine40) {
        this.userdefine40 = userdefine40;
    }

    private String userdefine39;

    @Basic
    @javax.persistence.Column(name = "userdefine39")
    public String getUserdefine39() {
        return userdefine39;
    }

    public void setUserdefine39(String userdefine39) {
        this.userdefine39 = userdefine39;
    }

    private String userdefine38;

    @Basic
    @javax.persistence.Column(name = "userdefine38")
    public String getUserdefine38() {
        return userdefine38;
    }

    public void setUserdefine38(String userdefine38) {
        this.userdefine38 = userdefine38;
    }

    private String userdefine37;

    @Basic
    @javax.persistence.Column(name = "userdefine37")
    public String getUserdefine37() {
        return userdefine37;
    }

    public void setUserdefine37(String userdefine37) {
        this.userdefine37 = userdefine37;
    }

    private String userdefine36;

    @Basic
    @javax.persistence.Column(name = "userdefine36")
    public String getUserdefine36() {
        return userdefine36;
    }

    public void setUserdefine36(String userdefine36) {
        this.userdefine36 = userdefine36;
    }

    private String userdefine35;

    @Basic
    @javax.persistence.Column(name = "userdefine35")
    public String getUserdefine35() {
        return userdefine35;
    }

    public void setUserdefine35(String userdefine35) {
        this.userdefine35 = userdefine35;
    }

    private String userdefine34;

    @Basic
    @javax.persistence.Column(name = "userdefine34")
    public String getUserdefine34() {
        return userdefine34;
    }

    public void setUserdefine34(String userdefine34) {
        this.userdefine34 = userdefine34;
    }

    private String userdefine33;

    @Basic
    @javax.persistence.Column(name = "userdefine33")
    public String getUserdefine33() {
        return userdefine33;
    }

    public void setUserdefine33(String userdefine33) {
        this.userdefine33 = userdefine33;
    }

    private String userdefine32;

    @Basic
    @javax.persistence.Column(name = "userdefine32")
    public String getUserdefine32() {
        return userdefine32;
    }

    public void setUserdefine32(String userdefine32) {
        this.userdefine32 = userdefine32;
    }

    private String userdefine31;

    @Basic
    @javax.persistence.Column(name = "userdefine31")
    public String getUserdefine31() {
        return userdefine31;
    }

    public void setUserdefine31(String userdefine31) {
        this.userdefine31 = userdefine31;
    }

    private String userdefine30;

    @Basic
    @javax.persistence.Column(name = "userdefine30")
    public String getUserdefine30() {
        return userdefine30;
    }

    public void setUserdefine30(String userdefine30) {
        this.userdefine30 = userdefine30;
    }

    private String userdefine29;

    @Basic
    @javax.persistence.Column(name = "userdefine29")
    public String getUserdefine29() {
        return userdefine29;
    }

    public void setUserdefine29(String userdefine29) {
        this.userdefine29 = userdefine29;
    }

    private String userdefine28;

    @Basic
    @javax.persistence.Column(name = "userdefine28")
    public String getUserdefine28() {
        return userdefine28;
    }

    public void setUserdefine28(String userdefine28) {
        this.userdefine28 = userdefine28;
    }

    private String userdefine27;

    @Basic
    @javax.persistence.Column(name = "userdefine27")
    public String getUserdefine27() {
        return userdefine27;
    }

    public void setUserdefine27(String userdefine27) {
        this.userdefine27 = userdefine27;
    }

    private String userdefine26;

    @Basic
    @javax.persistence.Column(name = "userdefine26")
    public String getUserdefine26() {
        return userdefine26;
    }

    public void setUserdefine26(String userdefine26) {
        this.userdefine26 = userdefine26;
    }

    private String userdefine25;

    @Basic
    @javax.persistence.Column(name = "userdefine25")
    public String getUserdefine25() {
        return userdefine25;
    }

    public void setUserdefine25(String userdefine25) {
        this.userdefine25 = userdefine25;
    }

    private String userdefine24;

    @Basic
    @javax.persistence.Column(name = "userdefine24")
    public String getUserdefine24() {
        return userdefine24;
    }

    public void setUserdefine24(String userdefine24) {
        this.userdefine24 = userdefine24;
    }

    private String userdefine23;

    @Basic
    @javax.persistence.Column(name = "userdefine23")
    public String getUserdefine23() {
        return userdefine23;
    }

    public void setUserdefine23(String userdefine23) {
        this.userdefine23 = userdefine23;
    }

    private String userdefine22;

    @Basic
    @javax.persistence.Column(name = "userdefine22")
    public String getUserdefine22() {
        return userdefine22;
    }

    public void setUserdefine22(String userdefine22) {
        this.userdefine22 = userdefine22;
    }

    private String userdefine21;

    @Basic
    @javax.persistence.Column(name = "userdefine21")
    public String getUserdefine21() {
        return userdefine21;
    }

    public void setUserdefine21(String userdefine21) {
        this.userdefine21 = userdefine21;
    }

    private String userdefine20;

    @Basic
    @javax.persistence.Column(name = "userdefine20")
    public String getUserdefine20() {
        return userdefine20;
    }

    public void setUserdefine20(String userdefine20) {
        this.userdefine20 = userdefine20;
    }

    private String userdefine19;

    @Basic
    @javax.persistence.Column(name = "userdefine19")
    public String getUserdefine19() {
        return userdefine19;
    }

    public void setUserdefine19(String userdefine19) {
        this.userdefine19 = userdefine19;
    }

    private String userdefine18;

    @Basic
    @javax.persistence.Column(name = "userdefine18")
    public String getUserdefine18() {
        return userdefine18;
    }

    public void setUserdefine18(String userdefine18) {
        this.userdefine18 = userdefine18;
    }

    private String userdefine17;

    @Basic
    @javax.persistence.Column(name = "userdefine17")
    public String getUserdefine17() {
        return userdefine17;
    }

    public void setUserdefine17(String userdefine17) {
        this.userdefine17 = userdefine17;
    }

    private String userdefine16;

    @Basic
    @javax.persistence.Column(name = "userdefine16")
    public String getUserdefine16() {
        return userdefine16;
    }

    public void setUserdefine16(String userdefine16) {
        this.userdefine16 = userdefine16;
    }

    private String userdefine15;

    @Basic
    @javax.persistence.Column(name = "userdefine15")
    public String getUserdefine15() {
        return userdefine15;
    }

    public void setUserdefine15(String userdefine15) {
        this.userdefine15 = userdefine15;
    }

    private String userdefine14;

    @Basic
    @javax.persistence.Column(name = "userdefine14")
    public String getUserdefine14() {
        return userdefine14;
    }

    public void setUserdefine14(String userdefine14) {
        this.userdefine14 = userdefine14;
    }

    private String userdefine13;

    @Basic
    @javax.persistence.Column(name = "userdefine13")
    public String getUserdefine13() {
        return userdefine13;
    }

    public void setUserdefine13(String userdefine13) {
        this.userdefine13 = userdefine13;
    }

    private String userdefine12;

    @Basic
    @javax.persistence.Column(name = "userdefine12")
    public String getUserdefine12() {
        return userdefine12;
    }

    public void setUserdefine12(String userdefine12) {
        this.userdefine12 = userdefine12;
    }

    private String userdefine11;

    @Basic
    @javax.persistence.Column(name = "userdefine11")
    public String getUserdefine11() {
        return userdefine11;
    }

    public void setUserdefine11(String userdefine11) {
        this.userdefine11 = userdefine11;
    }

    private String userdefine10;

    @Basic
    @javax.persistence.Column(name = "userdefine10")
    public String getUserdefine10() {
        return userdefine10;
    }

    public void setUserdefine10(String userdefine10) {
        this.userdefine10 = userdefine10;
    }

    private String userdefine9;

    @Basic
    @javax.persistence.Column(name = "userdefine9")
    public String getUserdefine9() {
        return userdefine9;
    }

    public void setUserdefine9(String userdefine9) {
        this.userdefine9 = userdefine9;
    }

    private String userdefine8;

    @Basic
    @javax.persistence.Column(name = "userdefine8")
    public String getUserdefine8() {
        return userdefine8;
    }

    public void setUserdefine8(String userdefine8) {
        this.userdefine8 = userdefine8;
    }

    private String userdefine7;

    @Basic
    @javax.persistence.Column(name = "userdefine7")
    public String getUserdefine7() {
        return userdefine7;
    }

    public void setUserdefine7(String userdefine7) {
        this.userdefine7 = userdefine7;
    }

    private String userdefine6;

    @Basic
    @javax.persistence.Column(name = "userdefine6")
    public String getUserdefine6() {
        return userdefine6;
    }

    public void setUserdefine6(String userdefine6) {
        this.userdefine6 = userdefine6;
    }

    private String userdefine5;

    @Basic
    @javax.persistence.Column(name = "userdefine5")
    public String getUserdefine5() {
        return userdefine5;
    }

    public void setUserdefine5(String userdefine5) {
        this.userdefine5 = userdefine5;
    }

    private String userdefine4;

    @Basic
    @javax.persistence.Column(name = "userdefine4")
    public String getUserdefine4() {
        return userdefine4;
    }

    public void setUserdefine4(String userdefine4) {
        this.userdefine4 = userdefine4;
    }

    private String userdefine3;

    @Basic
    @javax.persistence.Column(name = "userdefine3")
    public String getUserdefine3() {
        return userdefine3;
    }

    public void setUserdefine3(String userdefine3) {
        this.userdefine3 = userdefine3;
    }

    private String userdefine1;

    @Basic
    @javax.persistence.Column(name = "userdefine1")
    public String getUserdefine1() {
        return userdefine1;
    }

    public void setUserdefine1(String userdefine1) {
        this.userdefine1 = userdefine1;
    }

    private String userdefine2;

    @Basic
    @javax.persistence.Column(name = "userdefine2")
    public String getUserdefine2() {
        return userdefine2;
    }

    public void setUserdefine2(String userdefine2) {
        this.userdefine2 = userdefine2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TAchievement that = (TAchievement) o;

        if (achievementId != null ? !achievementId.equals(that.achievementId) : that.achievementId != null)
            return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (achievementypeId != null ? !achievementypeId.equals(that.achievementypeId) : that.achievementypeId != null)
            return false;
        if (achievementIntroduction != null ? !achievementIntroduction.equals(that.achievementIntroduction) : that.achievementIntroduction != null)
            return false;
        if (achievementOwner != null ? !achievementOwner.equals(that.achievementOwner) : that.achievementOwner != null)
            return false;
        if (achievementName != null ? !achievementName.equals(that.achievementName) : that.achievementName != null)
            return false;
        if (achievementJournal != null ? !achievementJournal.equals(that.achievementJournal) : that.achievementJournal != null)
            return false;
        if (achievementDate != null ? !achievementDate.equals(that.achievementDate) : that.achievementDate != null)
            return false;
        if (achievementVolume != null ? !achievementVolume.equals(that.achievementVolume) : that.achievementVolume != null)
            return false;
        if (achievementType != null ? !achievementType.equals(that.achievementType) : that.achievementType != null)
            return false;
        if (achievementPatent != null ? !achievementPatent.equals(that.achievementPatent) : that.achievementPatent != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;
        if (userdefine50 != null ? !userdefine50.equals(that.userdefine50) : that.userdefine50 != null) return false;
        if (userdefine49 != null ? !userdefine49.equals(that.userdefine49) : that.userdefine49 != null) return false;
        if (userdefine48 != null ? !userdefine48.equals(that.userdefine48) : that.userdefine48 != null) return false;
        if (userdefine47 != null ? !userdefine47.equals(that.userdefine47) : that.userdefine47 != null) return false;
        if (userdefine46 != null ? !userdefine46.equals(that.userdefine46) : that.userdefine46 != null) return false;
        if (userdefine45 != null ? !userdefine45.equals(that.userdefine45) : that.userdefine45 != null) return false;
        if (userdefine44 != null ? !userdefine44.equals(that.userdefine44) : that.userdefine44 != null) return false;
        if (userdefine43 != null ? !userdefine43.equals(that.userdefine43) : that.userdefine43 != null) return false;
        if (userdefine42 != null ? !userdefine42.equals(that.userdefine42) : that.userdefine42 != null) return false;
        if (userdefine41 != null ? !userdefine41.equals(that.userdefine41) : that.userdefine41 != null) return false;
        if (userdefine40 != null ? !userdefine40.equals(that.userdefine40) : that.userdefine40 != null) return false;
        if (userdefine39 != null ? !userdefine39.equals(that.userdefine39) : that.userdefine39 != null) return false;
        if (userdefine38 != null ? !userdefine38.equals(that.userdefine38) : that.userdefine38 != null) return false;
        if (userdefine37 != null ? !userdefine37.equals(that.userdefine37) : that.userdefine37 != null) return false;
        if (userdefine36 != null ? !userdefine36.equals(that.userdefine36) : that.userdefine36 != null) return false;
        if (userdefine35 != null ? !userdefine35.equals(that.userdefine35) : that.userdefine35 != null) return false;
        if (userdefine34 != null ? !userdefine34.equals(that.userdefine34) : that.userdefine34 != null) return false;
        if (userdefine33 != null ? !userdefine33.equals(that.userdefine33) : that.userdefine33 != null) return false;
        if (userdefine32 != null ? !userdefine32.equals(that.userdefine32) : that.userdefine32 != null) return false;
        if (userdefine31 != null ? !userdefine31.equals(that.userdefine31) : that.userdefine31 != null) return false;
        if (userdefine30 != null ? !userdefine30.equals(that.userdefine30) : that.userdefine30 != null) return false;
        if (userdefine29 != null ? !userdefine29.equals(that.userdefine29) : that.userdefine29 != null) return false;
        if (userdefine28 != null ? !userdefine28.equals(that.userdefine28) : that.userdefine28 != null) return false;
        if (userdefine27 != null ? !userdefine27.equals(that.userdefine27) : that.userdefine27 != null) return false;
        if (userdefine26 != null ? !userdefine26.equals(that.userdefine26) : that.userdefine26 != null) return false;
        if (userdefine25 != null ? !userdefine25.equals(that.userdefine25) : that.userdefine25 != null) return false;
        if (userdefine24 != null ? !userdefine24.equals(that.userdefine24) : that.userdefine24 != null) return false;
        if (userdefine23 != null ? !userdefine23.equals(that.userdefine23) : that.userdefine23 != null) return false;
        if (userdefine22 != null ? !userdefine22.equals(that.userdefine22) : that.userdefine22 != null) return false;
        if (userdefine21 != null ? !userdefine21.equals(that.userdefine21) : that.userdefine21 != null) return false;
        if (userdefine20 != null ? !userdefine20.equals(that.userdefine20) : that.userdefine20 != null) return false;
        if (userdefine19 != null ? !userdefine19.equals(that.userdefine19) : that.userdefine19 != null) return false;
        if (userdefine18 != null ? !userdefine18.equals(that.userdefine18) : that.userdefine18 != null) return false;
        if (userdefine17 != null ? !userdefine17.equals(that.userdefine17) : that.userdefine17 != null) return false;
        if (userdefine16 != null ? !userdefine16.equals(that.userdefine16) : that.userdefine16 != null) return false;
        if (userdefine15 != null ? !userdefine15.equals(that.userdefine15) : that.userdefine15 != null) return false;
        if (userdefine14 != null ? !userdefine14.equals(that.userdefine14) : that.userdefine14 != null) return false;
        if (userdefine13 != null ? !userdefine13.equals(that.userdefine13) : that.userdefine13 != null) return false;
        if (userdefine12 != null ? !userdefine12.equals(that.userdefine12) : that.userdefine12 != null) return false;
        if (userdefine11 != null ? !userdefine11.equals(that.userdefine11) : that.userdefine11 != null) return false;
        if (userdefine10 != null ? !userdefine10.equals(that.userdefine10) : that.userdefine10 != null) return false;
        if (userdefine9 != null ? !userdefine9.equals(that.userdefine9) : that.userdefine9 != null) return false;
        if (userdefine8 != null ? !userdefine8.equals(that.userdefine8) : that.userdefine8 != null) return false;
        if (userdefine7 != null ? !userdefine7.equals(that.userdefine7) : that.userdefine7 != null) return false;
        if (userdefine6 != null ? !userdefine6.equals(that.userdefine6) : that.userdefine6 != null) return false;
        if (userdefine5 != null ? !userdefine5.equals(that.userdefine5) : that.userdefine5 != null) return false;
        if (userdefine4 != null ? !userdefine4.equals(that.userdefine4) : that.userdefine4 != null) return false;
        if (userdefine3 != null ? !userdefine3.equals(that.userdefine3) : that.userdefine3 != null) return false;
        if (userdefine1 != null ? !userdefine1.equals(that.userdefine1) : that.userdefine1 != null) return false;
        if (userdefine2 != null ? !userdefine2.equals(that.userdefine2) : that.userdefine2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = achievementId != null ? achievementId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (achievementypeId != null ? achievementypeId.hashCode() : 0);
        result = 31 * result + (achievementIntroduction != null ? achievementIntroduction.hashCode() : 0);
        result = 31 * result + (achievementOwner != null ? achievementOwner.hashCode() : 0);
        result = 31 * result + (achievementName != null ? achievementName.hashCode() : 0);
        result = 31 * result + (achievementJournal != null ? achievementJournal.hashCode() : 0);
        result = 31 * result + (achievementDate != null ? achievementDate.hashCode() : 0);
        result = 31 * result + (achievementVolume != null ? achievementVolume.hashCode() : 0);
        result = 31 * result + (achievementType != null ? achievementType.hashCode() : 0);
        result = 31 * result + (achievementPatent != null ? achievementPatent.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (userdefine50 != null ? userdefine50.hashCode() : 0);
        result = 31 * result + (userdefine49 != null ? userdefine49.hashCode() : 0);
        result = 31 * result + (userdefine48 != null ? userdefine48.hashCode() : 0);
        result = 31 * result + (userdefine47 != null ? userdefine47.hashCode() : 0);
        result = 31 * result + (userdefine46 != null ? userdefine46.hashCode() : 0);
        result = 31 * result + (userdefine45 != null ? userdefine45.hashCode() : 0);
        result = 31 * result + (userdefine44 != null ? userdefine44.hashCode() : 0);
        result = 31 * result + (userdefine43 != null ? userdefine43.hashCode() : 0);
        result = 31 * result + (userdefine42 != null ? userdefine42.hashCode() : 0);
        result = 31 * result + (userdefine41 != null ? userdefine41.hashCode() : 0);
        result = 31 * result + (userdefine40 != null ? userdefine40.hashCode() : 0);
        result = 31 * result + (userdefine39 != null ? userdefine39.hashCode() : 0);
        result = 31 * result + (userdefine38 != null ? userdefine38.hashCode() : 0);
        result = 31 * result + (userdefine37 != null ? userdefine37.hashCode() : 0);
        result = 31 * result + (userdefine36 != null ? userdefine36.hashCode() : 0);
        result = 31 * result + (userdefine35 != null ? userdefine35.hashCode() : 0);
        result = 31 * result + (userdefine34 != null ? userdefine34.hashCode() : 0);
        result = 31 * result + (userdefine33 != null ? userdefine33.hashCode() : 0);
        result = 31 * result + (userdefine32 != null ? userdefine32.hashCode() : 0);
        result = 31 * result + (userdefine31 != null ? userdefine31.hashCode() : 0);
        result = 31 * result + (userdefine30 != null ? userdefine30.hashCode() : 0);
        result = 31 * result + (userdefine29 != null ? userdefine29.hashCode() : 0);
        result = 31 * result + (userdefine28 != null ? userdefine28.hashCode() : 0);
        result = 31 * result + (userdefine27 != null ? userdefine27.hashCode() : 0);
        result = 31 * result + (userdefine26 != null ? userdefine26.hashCode() : 0);
        result = 31 * result + (userdefine25 != null ? userdefine25.hashCode() : 0);
        result = 31 * result + (userdefine24 != null ? userdefine24.hashCode() : 0);
        result = 31 * result + (userdefine23 != null ? userdefine23.hashCode() : 0);
        result = 31 * result + (userdefine22 != null ? userdefine22.hashCode() : 0);
        result = 31 * result + (userdefine21 != null ? userdefine21.hashCode() : 0);
        result = 31 * result + (userdefine20 != null ? userdefine20.hashCode() : 0);
        result = 31 * result + (userdefine19 != null ? userdefine19.hashCode() : 0);
        result = 31 * result + (userdefine18 != null ? userdefine18.hashCode() : 0);
        result = 31 * result + (userdefine17 != null ? userdefine17.hashCode() : 0);
        result = 31 * result + (userdefine16 != null ? userdefine16.hashCode() : 0);
        result = 31 * result + (userdefine15 != null ? userdefine15.hashCode() : 0);
        result = 31 * result + (userdefine14 != null ? userdefine14.hashCode() : 0);
        result = 31 * result + (userdefine13 != null ? userdefine13.hashCode() : 0);
        result = 31 * result + (userdefine12 != null ? userdefine12.hashCode() : 0);
        result = 31 * result + (userdefine11 != null ? userdefine11.hashCode() : 0);
        result = 31 * result + (userdefine10 != null ? userdefine10.hashCode() : 0);
        result = 31 * result + (userdefine9 != null ? userdefine9.hashCode() : 0);
        result = 31 * result + (userdefine8 != null ? userdefine8.hashCode() : 0);
        result = 31 * result + (userdefine7 != null ? userdefine7.hashCode() : 0);
        result = 31 * result + (userdefine6 != null ? userdefine6.hashCode() : 0);
        result = 31 * result + (userdefine5 != null ? userdefine5.hashCode() : 0);
        result = 31 * result + (userdefine4 != null ? userdefine4.hashCode() : 0);
        result = 31 * result + (userdefine3 != null ? userdefine3.hashCode() : 0);
        result = 31 * result + (userdefine1 != null ? userdefine1.hashCode() : 0);
        result = 31 * result + (userdefine2 != null ? userdefine2.hashCode() : 0);
        return result;
    }
}
