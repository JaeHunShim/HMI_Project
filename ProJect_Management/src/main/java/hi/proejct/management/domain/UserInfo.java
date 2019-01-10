package hi.proejct.management.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="USER")
public class UserInfo implements Serializable{
	
	
	@Id
	@Column(name="USER_ID")
	private String user_id;
	
	@OneToMany(mappedBy="userInfo")
	List<Board> board = new ArrayList<Board>();
	
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
	
	@Column(name="AUTH")
	private String auth;
	
	
	public UserInfo() {}
	
	public UserInfo(String user_id) {
		
		this.user_id = user_id;
	}
	public UserInfo(String user_id, String password) {
		
		this.user_id = user_id;
		this.password = password;
	}
	public UserInfo(String user_id, String password,String company_name, String position, String email, String address) {
		
		this.user_id  = user_id;
		this.password = password;
		this.company_name = company_name;
		this.position = position;
		this.email = email;
		this.address = address;
	}
	public List<Board> getBoard() {
		return board;
	}

	public void setBoard(List<Board> board) {
		this.board = board;
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
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", board=" + board + ", password=" + password + ", company_name="
				+ company_name + ", position=" + position + ", email=" + email + ", address=" + address + ", auth="
				+ auth + "]";
	}

	

	
}
