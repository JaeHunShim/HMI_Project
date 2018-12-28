package hi.proejct.management.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import hi.proejct.management.domain.enumType.Status;

@Entity
public class Board implements Serializable{
	
	@Id
	@Column(name="PNO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pno;
	
	@Column(name="COMPANY_NAME")
	private String company_name;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserInfo userInfo;
	
	@Column(name="PROJECT_NAME")
	private String project_name;
	
	@Column(name="Content")
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", columnDefinition="default 'proceeding'")
	private Status status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REGDATE")
	private Date regdate;
	
	public Board() {}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}


	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board [pno=" + pno + ", company_name=" + company_name + ", userInfo=" + userInfo + ", project_name="
				+ project_name + ", status=" + status + ", regdate=" + regdate + "]";
	}

	
	
}
