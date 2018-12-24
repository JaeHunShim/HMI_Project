package hi.proejct.management.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BOARD")
public class Board implements Serializable{
	
	@Id
	@Column(name="pno")
	private Integer pno;

	@Column(name="user_id")
	private String user_id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="regdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
	@Column(name="status")
	private String status;
	
	
	public Board(){}

	public Board(String user_id) {
		
		this.user_id = user_id;
	}
	public Integer getPno() {
		return pno;
	}

	
	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getReservationDate() {
		return reservationDate;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [pno=" + pno + ", user_id=" + user_id + ", companyName=" + companyName + ", projectName="
				+ projectName + ", reservationDate=" + reservationDate + ", status=" + status + "]";
	}

	
}
