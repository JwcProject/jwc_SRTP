package edu.cqu.no1.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Huxley on 5/29/15.
 */
@Entity
@Table(name = "t_announ_type", schema = "", catalog = "srtp")
public class TAnnounType {
    private String announTypeId;
    private String announTypeName;
    private String isdeleted;
    private Collection<TAnnouncement> tAnnouncementsByAnnounTypeId;
    private Collection<TAnnouncementModel> tannouncementmodelsByAnnounTypeId;

    @Id
    @Column(name = "announ_type_id")
    public String getAnnounTypeId() {
        return announTypeId;
    }

    public void setAnnounTypeId(String announTypeId) {
        this.announTypeId = announTypeId;
    }

    @Basic
    @Column(name = "announ_type_name")
    public String getAnnounTypeName() {
        return announTypeName;
    }

    public void setAnnounTypeName(String announTypeName) {
        this.announTypeName = announTypeName;
    }

    @Basic
    @Column(name = "isdeleted")
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

        TAnnounType that = (TAnnounType) o;

        if (announTypeId != null ? !announTypeId.equals(that.announTypeId) : that.announTypeId != null) return false;
        if (announTypeName != null ? !announTypeName.equals(that.announTypeName) : that.announTypeName != null)
            return false;
        if (isdeleted != null ? !isdeleted.equals(that.isdeleted) : that.isdeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = announTypeId != null ? announTypeId.hashCode() : 0;
        result = 31 * result + (announTypeName != null ? announTypeName.hashCode() : 0);
        result = 31 * result + (isdeleted != null ? isdeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tAnnounTypeByAnnounTypeId")
    public Collection<TAnnouncement> gettAnnouncementsByAnnounTypeId() {
        return tAnnouncementsByAnnounTypeId;
    }

    public void settAnnouncementsByAnnounTypeId(Collection<TAnnouncement> tAnnouncementsByAnnounTypeId) {
        this.tAnnouncementsByAnnounTypeId = tAnnouncementsByAnnounTypeId;
    }

    @OneToMany(mappedBy = "tAnnounTypeByAnnounTypeId")
    public Collection<TAnnouncementModel> getTannouncementmodelsByAnnounTypeId() {
        return tannouncementmodelsByAnnounTypeId;
    }

    public void setTannouncementmodelsByAnnounTypeId(Collection<TAnnouncementModel> tannouncementmodelsByAnnounTypeId) {
        this.tannouncementmodelsByAnnounTypeId = tannouncementmodelsByAnnounTypeId;
    }
}
