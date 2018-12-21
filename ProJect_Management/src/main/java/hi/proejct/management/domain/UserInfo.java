package hi.proejct.management.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserInfo implements Serializable {
	
	
	@Id
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="COMPANY_NAME")
	private String company_name;
	
	@Column(name="POSITION")
	private String position;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name="ADDRESS")
	private String address;

	
	public UserInfo() {}
	
	public UserInfo(String user_id, String password) {
		
		this.user_id = user_id;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", company_name=" + company_name + ", position=" + position
				+ ", email=" + email + ", address=" + address + "]";
	}
	
	
}