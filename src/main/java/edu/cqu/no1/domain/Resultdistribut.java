package edu.cqu.no1.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ZKQ on 2015/5/27.
 */
@Entity
public class ResultDistribut {
    private String id;
    private String jqId;
    private String college;
    private String collegename;
    private String jqname;
    private Double decsum;
    private Double prosum;
    private Double bestsum;
    private Double badsum;
    private Double endsum;
    private Double delaysum;
    private Double prorate;
    private Double bestrate;
    private Double endrate;
    private Double delayrate;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "JQ_ID")
    public String getJqId() {
        return jqId;
    }

    public void setJqId(String jqId) {
        this.jqId = jqId;
    }

    @Basic
    @Column(name = "COLLEGE")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Basic
    @Column(name = "COLLEGENAME")
    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    @Basic
    @Column(name = "JQNAME")
    public String getJqname() {
        return jqname;
    }

    public void setJqname(String jqname) {
        this.jqname = jqname;
    }

    @Basic
    @Column(name = "DECSUM")
    public Double getDecsum() {
        return decsum;
    }

    public void setDecsum(Double decsum) {
        this.decsum = decsum;
    }

    @Basic
    @Column(name = "PROSUM")
    public Double getProsum() {
        return prosum;
    }

    public void setProsum(Double prosum) {
        this.prosum = prosum;
    }

    @Basic
    @Column(name = "BESTSUM")
    public Double getBestsum() {
        return bestsum;
    }

    public void setBestsum(Double bestsum) {
        this.bestsum = bestsum;
    }

    @Basic
    @Column(name = "BADSUM")
    public Double getBadsum() {
        return badsum;
    }

    public void setBadsum(Double badsum) {
        this.badsum = badsum;
    }

    @Basic
    @Column(name = "ENDSUM")
    public Double getEndsum() {
        return endsum;
    }

    public void setEndsum(Double endsum) {
        this.endsum = endsum;
    }

    @Basic
    @Column(name = "DELAYSUM")
    public Double getDelaysum() {
        return delaysum;
    }

    public void setDelaysum(Double delaysum) {
        this.delaysum = delaysum;
    }

    @Basic
    @Column(name = "PRORATE")
    public Double getProrate() {
        return prorate;
    }

    public void setProrate(Double prorate) {
        this.prorate = prorate;
    }

    @Basic
    @Column(name = "BESTRATE")
    public Double getBestrate() {
        return bestrate;
    }

    public void setBestrate(Double bestrate) {
        this.bestrate = bestrate;
    }

    @Basic
    @Column(name = "ENDRATE")
    public Double getEndrate() {
        return endrate;
    }

    public void setEndrate(Double endrate) {
        this.endrate = endrate;
    }

    @Basic
    @Column(name = "DELAYRATE")
    public Double getDelayrate() {
        return delayrate;
    }

    public void setDelayrate(Double delayrate) {
        this.delayrate = delayrate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultDistribut that = (ResultDistribut) o;

        if (badsum != null ? !badsum.equals(that.badsum) : that.badsum != null) return false;
        if (bestrate != null ? !bestrate.equals(that.bestrate) : that.bestrate != null) return false;
        if (bestsum != null ? !bestsum.equals(that.bestsum) : that.bestsum != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (collegename != null ? !collegename.equals(that.collegename) : that.collegename != null) return false;
        if (decsum != null ? !decsum.equals(that.decsum) : that.decsum != null) return false;
        if (delayrate != null ? !delayrate.equals(that.delayrate) : that.delayrate != null) return false;
        if (delaysum != null ? !delaysum.equals(that.delaysum) : that.delaysum != null) return false;
        if (endrate != null ? !endrate.equals(that.endrate) : that.endrate != null) return false;
        if (endsum != null ? !endsum.equals(that.endsum) : that.endsum != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (jqId != null ? !jqId.equals(that.jqId) : that.jqId != null) return false;
        if (jqname != null ? !jqname.equals(that.jqname) : that.jqname != null) return false;
        if (prorate != null ? !prorate.equals(that.prorate) : that.prorate != null) return false;
        if (prosum != null ? !prosum.equals(that.prosum) : that.prosum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jqId != null ? jqId.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (collegename != null ? collegename.hashCode() : 0);
        result = 31 * result + (jqname != null ? jqname.hashCode() : 0);
        result = 31 * result + (decsum != null ? decsum.hashCode() : 0);
        result = 31 * result + (prosum != null ? prosum.hashCode() : 0);
        result = 31 * result + (bestsum != null ? bestsum.hashCode() : 0);
        result = 31 * result + (badsum != null ? badsum.hashCode() : 0);
        result = 31 * result + (endsum != null ? endsum.hashCode() : 0);
        result = 31 * result + (delaysum != null ? delaysum.hashCode() : 0);
        result = 31 * result + (prorate != null ? prorate.hashCode() : 0);
        result = 31 * result + (bestrate != null ? bestrate.hashCode() : 0);
        result = 31 * result + (endrate != null ? endrate.hashCode() : 0);
        result = 31 * result + (delayrate != null ? delayrate.hashCode() : 0);
        return result;
    }
}
