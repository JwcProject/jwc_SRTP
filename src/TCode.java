// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_code", catalog = "srtp")
public class TCode implements java.io.Serializable {

	// Fields

	private String encodeId;
	private String encodeValue;
	private String encodeDesc;
	private String encodeRemark;
	private String isdeleted;

	// Constructors

	/** default constructor */
	public TCode() {
	}

	/** full constructor */
	public TCode(String encodeValue, String encodeDesc, String encodeRemark,
			String isdeleted) {
		this.encodeValue = encodeValue;
		this.encodeDesc = encodeDesc;
		this.encodeRemark = encodeRemark;
		this.isdeleted = isdeleted;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "encode_id", unique = true, nullable = false, length = 32)
	public String getEncodeId() {
		return this.encodeId;
	}

	public void setEncodeId(String encodeId) {
		this.encodeId = encodeId;
	}

	@Column(name = "encode_value", length = 2)
	public String getEncodeValue() {
		return this.encodeValue;
	}

	public void setEncodeValue(String encodeValue) {
		this.encodeValue = encodeValue;
	}

	@Column(name = "encode_desc", length = 20)
	public String getEncodeDesc() {
		return this.encodeDesc;
	}

	public void setEncodeDesc(String encodeDesc) {
		this.encodeDesc = encodeDesc;
	}

	@Column(name = "encode_remark", length = 20)
	public String getEncodeRemark() {
		return this.encodeRemark;
	}

	public void setEncodeRemark(String encodeRemark) {
		this.encodeRemark = encodeRemark;
	}

	@Column(name = "isdeleted", length = 1)
	public String getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

}