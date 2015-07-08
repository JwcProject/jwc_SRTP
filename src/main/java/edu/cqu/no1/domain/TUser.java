package edu.cqu.no1.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private TRole TRole;
	private String isdeleted;
	private String userIntroduction;
	private String username;
	private String password;
	private String userState;
	private String previousType;
	private String userType;
	private String email;
	private Set<TJournal> TJournals = new HashSet<TJournal>(0);
	private Set<TAttachment> TAttachments = new HashSet<TAttachment>(0);
	private Set<TStudent> TStudents = new HashSet<TStudent>(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(TRole TRole, String isdeleted, String userIntroduction,
			String username, String password, String userState,
			String previousType, String userType, String email,
			Set<TJournal> TJournals, Set<TAttachment> TAttachments,
			Set<TStudent> TStudents) {
		this.TRole = TRole;
		this.isdeleted = isdeleted;
		this.userIntroduction = userIntroduction;
		this.username = username;
		this.password = password;
		this.userState = userState;
		this.previousType = previousType;
		this.userType = userType;
		this.email = email;
		this.TJournals = TJournals;
		this.TAttachments = TAttachments;
		this.TStudents = TStudents;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false, length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "user_introduction", length = 200)
	public String getUserIntroduction() {
		return this.userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_state", length = 2)
	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Column(name = "previous_type", length = 2)
	public String getPreviousType() {
		return this.previousType;
	}

	public void setPreviousType(String previousType) {
		this.previousType = previousType;
	}

	@Column(name = "user_type", length = 2)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TJournal> getTJournals() {
		return this.TJournals;
	}

	public void setTJournals(Set<TJournal> TJournals) {
		this.TJournals = TJournals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TAttachment> getTAttachments() {
		return this.TAttachments;
	}

	public void setTAttachments(Set<TAttachment> TAttachments) {
		this.TAttachments = TAttachments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TStudent> getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(Set<TStudent> TStudents) {
		this.TStudents = TStudents;
	}

}