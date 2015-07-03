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
 * TAttchmentType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_attchment_type", catalog = "srtp")
public class TAttchmentType implements java.io.Serializable {

	// Fields

	private String attaTypeId;
	private String attaTypeName;
	private String isdeleted;
	private Set<TAttachment> TAttachments = new HashSet<TAttachment>(0);

	// Constructors

	/** default constructor */
	public TAttchmentType() {
	}

	/** full constructor */
	public TAttchmentType(String attaTypeName, String isdeleted,
			Set<TAttachment> TAttachments) {
		this.attaTypeName = attaTypeName;
		this.isdeleted = isdeleted;
		this.TAttachments = TAttachments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "atta_type_id", unique = true, nullable = false, length = 32)
	public String getAttaTypeId() {
		return this.attaTypeId;
	}

	public void setAttaTypeId(String attaTypeId) {
		this.attaTypeId = attaTypeId;
	}

	@Column(name = "atta_type_name", length = 50)
	public String getAttaTypeName() {
		return this.attaTypeName;
	}

	public void setAttaTypeName(String attaTypeName) {
		this.attaTypeName = attaTypeName;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAttchmentType")
	public Set<TAttachment> getTAttachments() {
		return this.TAttachments;
	}

	public void setTAttachments(Set<TAttachment> TAttachments) {
		this.TAttachments = TAttachments;
	}

}