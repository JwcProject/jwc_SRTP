package edu.cqu.no1.domain;

import java.sql.Timestamp;
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
 * TJieqi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_jieqi", catalog = "srtp")
public class TJieqi implements java.io.Serializable {

	// Fields

	private String jqId;
	private String declarationState;
	private Timestamp endOn;
	private String endprojectState;
	private String isdeleted;
	private String jqName;
	private Integer jqYear;
	private Timestamp jtEndOn;
	private Timestamp jtStartOn;
	private String qici;
	private String secondaryAssessment;
	private String secondaryRespondent;
	private Timestamp startOn;
	private Timestamp zjEndOn;
	private Timestamp zjStartOn;
	private Set<TEndProject> TEndProjects = new HashSet<TEndProject>(0);
	private Set<TExpertLib> TExpertLibs = new HashSet<TExpertLib>(0);
	private Set<TEmail> TEmails = new HashSet<TEmail>(0);
	private Set<TDeclaration> TDeclarations = new HashSet<TDeclaration>(0);
	private Set<TProject> TProjects = new HashSet<TProject>(0);

	// Constructors

	/** default constructor */
	public TJieqi() {
	}

	/** full constructor */
	public TJieqi(String declarationState, Timestamp endOn,
			String endprojectState, String isdeleted, String jqName,
			Integer jqYear, Timestamp jtEndOn, Timestamp jtStartOn,
			String qici, String secondaryAssessment,
			String secondaryRespondent, Timestamp startOn, Timestamp zjEndOn,
			Timestamp zjStartOn, Set<TEndProject> TEndProjects,
			Set<TExpertLib> TExpertLibs, Set<TEmail> TEmails,
			Set<TDeclaration> TDeclarations, Set<TProject> TProjects) {
		this.declarationState = declarationState;
		this.endOn = endOn;
		this.endprojectState = endprojectState;
		this.isdeleted = isdeleted;
		this.jqName = jqName;
		this.jqYear = jqYear;
		this.jtEndOn = jtEndOn;
		this.jtStartOn = jtStartOn;
		this.qici = qici;
		this.secondaryAssessment = secondaryAssessment;
		this.secondaryRespondent = secondaryRespondent;
		this.startOn = startOn;
		this.zjEndOn = zjEndOn;
		this.zjStartOn = zjStartOn;
		this.TEndProjects = TEndProjects;
		this.TExpertLibs = TExpertLibs;
		this.TEmails = TEmails;
		this.TDeclarations = TDeclarations;
		this.TProjects = TProjects;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "jq_id", unique = true, nullable = false, length = 36)
	public String getJqId() {
		return this.jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	@Column(name = "DECLARATION_STATE", length = 2)
	public String getDeclarationState() {
		return this.declarationState;
	}

	public void setDeclarationState(String declarationState) {
		this.declarationState = declarationState;
	}

	@Column(name = "end_on", length = 19)
	public Timestamp getEndOn() {
		return this.endOn;
	}

	public void setEndOn(Timestamp endOn) {
		this.endOn = endOn;
	}

	@Column(name = "ENDPROJECT_STATE", length = 2)
	public String getEndprojectState() {
		return this.endprojectState;
	}

	public void setEndprojectState(String endprojectState) {
		this.endprojectState = endprojectState;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "jq_name", length = 50)
	public String getJqName() {
		return this.jqName;
	}

	public void setJqName(String jqName) {
		this.jqName = jqName;
	}

	@Column(name = "jq_year")
	public Integer getJqYear() {
		return this.jqYear;
	}

	public void setJqYear(Integer jqYear) {
		this.jqYear = jqYear;
	}

	@Column(name = "jt_end_on", length = 19)
	public Timestamp getJtEndOn() {
		return this.jtEndOn;
	}

	public void setJtEndOn(Timestamp jtEndOn) {
		this.jtEndOn = jtEndOn;
	}

	@Column(name = "jt_start_on", length = 19)
	public Timestamp getJtStartOn() {
		return this.jtStartOn;
	}

	public void setJtStartOn(Timestamp jtStartOn) {
		this.jtStartOn = jtStartOn;
	}

	@Column(name = "qici", length = 20)
	public String getQici() {
		return this.qici;
	}

	public void setQici(String qici) {
		this.qici = qici;
	}

	@Column(name = "secondary_Assessment", length = 1)
	public String getSecondaryAssessment() {
		return this.secondaryAssessment;
	}

	public void setSecondaryAssessment(String secondaryAssessment) {
		this.secondaryAssessment = secondaryAssessment;
	}

	@Column(name = "secondary_Respondent", length = 1)
	public String getSecondaryRespondent() {
		return this.secondaryRespondent;
	}

	public void setSecondaryRespondent(String secondaryRespondent) {
		this.secondaryRespondent = secondaryRespondent;
	}

	@Column(name = "start_on", length = 19)
	public Timestamp getStartOn() {
		return this.startOn;
	}

	public void setStartOn(Timestamp startOn) {
		this.startOn = startOn;
	}

	@Column(name = "zj_end_on", length = 19)
	public Timestamp getZjEndOn() {
		return this.zjEndOn;
	}

	public void setZjEndOn(Timestamp zjEndOn) {
		this.zjEndOn = zjEndOn;
	}

	@Column(name = "zj_start_on", length = 19)
	public Timestamp getZjStartOn() {
		return this.zjStartOn;
	}

	public void setZjStartOn(Timestamp zjStartOn) {
		this.zjStartOn = zjStartOn;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJieqi")
	public Set<TEndProject> getTEndProjects() {
		return this.TEndProjects;
	}

	public void setTEndProjects(Set<TEndProject> TEndProjects) {
		this.TEndProjects = TEndProjects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJieqi")
	public Set<TExpertLib> getTExpertLibs() {
		return this.TExpertLibs;
	}

	public void setTExpertLibs(Set<TExpertLib> TExpertLibs) {
		this.TExpertLibs = TExpertLibs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJieqi")
	public Set<TEmail> getTEmails() {
		return this.TEmails;
	}

	public void setTEmails(Set<TEmail> TEmails) {
		this.TEmails = TEmails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJieqi")
	public Set<TDeclaration> getTDeclarations() {
		return this.TDeclarations;
	}

	public void setTDeclarations(Set<TDeclaration> TDeclarations) {
		this.TDeclarations = TDeclarations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TJieqi")
	public Set<TProject> getTProjects() {
		return this.TProjects;
	}

	public void setTProjects(Set<TProject> TProjects) {
		this.TProjects = TProjects;
	}

}