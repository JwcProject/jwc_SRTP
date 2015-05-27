package edu.cqu.no1.domain;

import javax.persistence.*;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_achievemen_type", schema = "", catalog = "srtp")
public class TAchievemenType {
    private String achievementypeId;
    private String achievementypeName;
    private String achievementypeIntroduction;
    private String isdeleted;

    @Id
    @Column(name = "ACHIEVEMENTYPE_ID")
    public String getAchievementypeId() {
        return achievementypeId;
    }

    public void setAchievementypeId(String achievementypeId) {
        this.achievementypeId = achievementypeId;
    }

    @Basic
    @Column(name = "ACHIEVEMENTYPE_NAME")
    public String getAchievementypeName() {
        return achievementypeName;
    }

    public void setAchievementypeName(String achievementypeName) {
        this.achievementypeName = achievementypeName;
    }

    @Basic
    @Column(name = "ACHIEVEMENTYPE_INTRODUCTION")
    public String getAchievementypeIntroduction() {
        return achievementypeIntroduction;
    }

    public void setAchievementypeIntroduction(String achievementypeIntroduction) {
        this.achievementypeIntroduction = achievementypeIntroduction;
    }

    @Basic
    @Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TAchievemenType that = (TAchievemenType) o;

        if (achievementypeId != null ? !achievementypeId.equals(that.achievementypeId) : that.achievementypeId != null)
            return false;
        if (achievementypeIntroduction != null ? !achievementypeIntroduction.equals(that.achievementypeIntroduction) : that.achievementypeIntroduction != null)
            return false;
        if (achievementypeName != null ? !achievementypeName.equals(that.achievementypeName) : that.achievementypeName != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = achievementypeId != null ? achievementypeId.hashCode() : 0;
        result = 31 * result + (achievementypeName != null ? achievementypeName.hashCode() : 0);
        result = 31 * result + (achievementypeIntroduction != null ? achievementypeIntroduction.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }
}
