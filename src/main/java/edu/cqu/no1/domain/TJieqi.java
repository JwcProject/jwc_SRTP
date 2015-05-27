package edu.cqu.no1.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
@Table(name = "t_jieqi", schema = "", catalog = "srtp")
public class TJieqi {
    private String jqId;
    private String jqName;
    private Integer jqYear;
    private String qici;
    private Timestamp startOn;
    private Timestamp endOn;
    private Timestamp zjStartOn;
    private Timestamp zjEndOn;
    private Timestamp jtStartOn;
    private Timestamp jtEndOn;
    private String secondaryAssessment;
    private String secondaryRespondent;
    private String isdeleted;
    private String declarationState;
    private String endprojectState;

    @Id
    @Column(name = "JQ_ID")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    @Basic
    @Column(name = "JQ_NAME")
    public String getJqName() {
        return jqName;
    }

    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    @Basic
    @Column(name = "JQ_YEAR")
    public Integer getJqYear() {
        return jqYear;
    }

    public void setJqYear(Integer jqYear) {
        this.jqYear = jqYear;
    }

    @Basic
    @Column(name = "QICI")
    public String getQici() {
        return qici;
    }

    public void setQici(String qici) {
        this.qici = qici;
    }

    @Basic
    @Column(name = "START_ON")
    public Timestamp getStartOn() {
        return startOn;
    }

    public void setStartOn(Timestamp startOn) {
        this.startOn = startOn;
    }

    @Basic
    @Column(name = "END_ON")
    public Timestamp getEndOn() {
        return endOn;
    }

    public void setEndOn(Timestamp endOn) {
        this.endOn = endOn;
    }

    @Basic
    @Column(name = "ZJ_START_ON")
    public Timestamp getZjStartOn() {
        return zjStartOn;
    }

    public void setZjStartOn(Timestamp zjStartOn) {
        this.zjStartOn = zjStartOn;
    }

    @Basic
    @Column(name = "ZJ_END_ON")
    public Timestamp getZjEndOn() {
        return zjEndOn;
    }

    public void setZjEndOn(Timestamp zjEndOn) {
        this.zjEndOn = zjEndOn;
    }

    @Basic
    @Column(name = "JT_START_ON")
    public Timestamp getJtStartOn() {
        return jtStartOn;
    }

    public void setJtStartOn(Timestamp jtStartOn) {
        this.jtStartOn = jtStartOn;
    }

    @Basic
    @Column(name = "JT_END_ON")
    public Timestamp getJtEndOn() {
        return jtEndOn;
    }

    public void setJtEndOn(Timestamp jtEndOn) {
        this.jtEndOn = jtEndOn;
    }

    @Basic
    @Column(name = "SECONDARY_ASSESSMENT")
    public String getSecondaryAssessment() {
        return secondaryAssessment;
    }

    public void setSecondaryAssessment(String secondaryAssessment) {
        this.secondaryAssessment = secondaryAssessment;
    }

    @Basic
    @Column(name = "SECONDARY_RESPONDENT")
    public String getSecondaryRespondent() {
        return secondaryRespondent;
    }

    public void setSecondaryRespondent(String secondaryRespondent) {
        this.secondaryRespondent = secondaryRespondent;
    }

    @Basic
    @Column(name = "ISDELETED")
    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "DECLARATION_STATE")
    public String getDeclarationState() {
        return declarationState;
    }

    public void setDeclarationState(String declarationState) {
        this.declarationState = declarationState;
    }

    @Basic
    @Column(name = "ENDPROJECT_STATE")
    public String getEndprojectState() {
        return endprojectState;
    }

    public void setEndprojectState(String endprojectState) {
        this.endprojectState = endprojectState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TJieqi tJieqi = (TJieqi) o;

        if (declarationState != null ? !declarationState.equals(tJieqi.declarationState) : tJieqi.declarationState != null)
            return false;
        if (endOn != null ? !endOn.equals(tJieqi.endOn) : tJieqi.endOn != null) return false;
        if (endprojectState != null ? !endprojectState.equals(tJieqi.endprojectState) : tJieqi.endprojectState != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(tJieqi.isdeleted) : tJieqi.isdeleted != null) return false;
        if (jqId != null ? !jqId.equals(tJieqi.jqId) : tJieqi.jqId != null) return false;
        if (jqName != null ? !jqName.equals(tJieqi.jqName) : tJieqi.jqName != null) return false;
        if (jqYear != null ? !jqYear.equals(tJieqi.jqYear) : tJieqi.jqYear != null) return false;
        if (jtEndOn != null ? !jtEndOn.equals(tJieqi.jtEndOn) : tJieqi.jtEndOn != null) return false;
        if (jtStartOn != null ? !jtStartOn.equals(tJieqi.jtStartOn) : tJieqi.jtStartOn != null) return false;
        if (qici != null ? !qici.equals(tJieqi.qici) : tJieqi.qici != null) return false;
        if (secondaryAssessment != null ? !secondaryAssessment.equals(tJieqi.secondaryAssessment) : tJieqi.secondaryAssessment != null)
            return false;
        if (secondaryRespondent != null ? !secondaryRespondent.equals(tJieqi.secondaryRespondent) : tJieqi.secondaryRespondent != null)
            return false;
        if (startOn != null ? !startOn.equals(tJieqi.startOn) : tJieqi.startOn != null) return false;
        if (zjEndOn != null ? !zjEndOn.equals(tJieqi.zjEndOn) : tJieqi.zjEndOn != null) return false;
        if (zjStartOn != null ? !zjStartOn.equals(tJieqi.zjStartOn) : tJieqi.zjStartOn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jqId != null ? jqId.hashCode() : 0;
        result = 31 * result + (jqName != null ? jqName.hashCode() : 0);
        result = 31 * result + (jqYear != null ? jqYear.hashCode() : 0);
        result = 31 * result + (qici != null ? qici.hashCode() : 0);
        result = 31 * result + (startOn != null ? startOn.hashCode() : 0);
        result = 31 * result + (endOn != null ? endOn.hashCode() : 0);
        result = 31 * result + (zjStartOn != null ? zjStartOn.hashCode() : 0);
        result = 31 * result + (zjEndOn != null ? zjEndOn.hashCode() : 0);
        result = 31 * result + (jtStartOn != null ? jtStartOn.hashCode() : 0);
        result = 31 * result + (jtEndOn != null ? jtEndOn.hashCode() : 0);
        result = 31 * result + (secondaryAssessment != null ? secondaryAssessment.hashCode() : 0);
        result = 31 * result + (secondaryRespondent != null ? secondaryRespondent.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        result = 31 * result + (declarationState != null ? declarationState.hashCode() : 0);
        result = 31 * result + (endprojectState != null ? endprojectState.hashCode() : 0);
        return result;
    }
}
