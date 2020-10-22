package green.vo;

import java.util.Date;

public class Member {
	protected int no;
	protected String name;
	protected String email;
	protected String password;
	protected Date createdDate;
	protected Date modifiedDate;
	
	public Member(String name, String password, String email, int no) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
		this.email = email;
		this.no = no;
		
	}
	public Member() {
		
	}
	public Member setNo(int no){
		this.no = no;
		return this;
		
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Member setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;	
		return this;

	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Member setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;

	}
	public int getNo() {
		return this.no;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getName() {
		return this.name;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getEmail() {
		return this.email;
	}
	public String toString() {
		return getNo()+"번 : " + getName()+ " "+getPassword()+" "+ getEmail();
	}
}
