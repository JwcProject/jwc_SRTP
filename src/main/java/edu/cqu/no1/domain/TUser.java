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
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "srtp")
public class TUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userPassword;
	private String userState;
	private String userIntroduction;
	private String isdeleted;
	private String userType;
	private Set<TJournal> TJournals = new HashSet<TJournal>(0);
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);
	private Set<TStudent> TStudents = new HashSet<TStudent>(0);
	private Set<TAttachment> TAttachments = new HashSet<TAttachment>(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userName, String userPassword, String userState,
			String userIntroduction, String isdeleted, String userType,
			Set<TJournal> TJournals, Set<TUserRole> TUserRoles,
			Set<TStudent> TStudents, Set<TAttachment> TAttachments) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.userIntroduction = userIntroduction;
		this.isdeleted = isdeleted;
		this.userType = userType;
		this.TJournals = TJournals;
		this.TUserRoles = TUserRoles;
		this.TStudents = TStudents;
		this.TAttachments = TAttachments;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_state", length = 2)
	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Column(name = "user_introduction", length = 200)
	public String getUserIntroduction() {
		return this.userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "user_type", length = 2)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TJournal> getTJournals() {
		return this.TJournals;
	}

	public void setTJournals(Set<TJournal> TJournals) {
		this.TJournals = TJournals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TStudent> getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set<TStudent> TStudents) {
		this.TStudents = TStudents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TAttachment> getTAttachments() {
		return this.TAttachments;
	}

	public void setTAttachments(Set<TAttachment> TAttachments) {
		this.TAttachments = TAttachments;
	}

}