package edu.cqu.no1.domain;// default package

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
 * TAnnounType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_announ_type", catalog = "srtp")
public class TAnnounType implements java.io.Serializable {

	// Fields

	private String announTypeId;
	private String announTypeName;
	private String isdeleted;
	private Set<TAnnouncementModel> TAnnouncementModels = new HashSet<TAnnouncementModel>(
			0);
	private Set<TAnnouncement> TAnnouncements = new HashSet<TAnnouncement>(0);

	// Constructors

	/** default constructor */
	public TAnnounType() {
	}

	/** full constructor */
	public TAnnounType(String announTypeName, String isdeleted,
			Set<TAnnouncementModel> TAnnouncementModels,
			Set<TAnnouncement> TAnnouncements) {
		this.announTypeName = announTypeName;
		this.isdeleted = isdeleted;
		this.TAnnouncementModels = TAnnouncementModels;
		this.TAnnouncements = TAnnouncements;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "announ_type_id", unique = true, nullable = false, length = 32)
	public String getAnnounTypeId() {
		return this.announTypeId;
	}

	public void setAnnounTypeId(String announTypeId) {
		this.announTypeId = announTypeId;
	}

	@Column(name = "announ_type_name", length = 100)
	public String getAnnounTypeName() {
		return this.announTypeName;
	}

	public void setAnnounTypeName(String announTypeName) {
		this.announTypeName = announTypeName;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAnnounType")
	public Set<TAnnouncementModel> getTAnnouncementModels() {
		return this.TAnnouncementModels;
	}

	public void setTAnnouncementModels(
			Set<TAnnouncementModel> TAnnouncementModels) {
		this.TAnnouncementModels = TAnnouncementModels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAnnounType")
	public Set<TAnnouncement> getTAnnouncements() {
		return this.TAnnouncements;
	}

	public void setTAnnouncements(Set<TAnnouncement> TAnnouncements) {
		this.TAnnouncements = TAnnouncements;
	}

}