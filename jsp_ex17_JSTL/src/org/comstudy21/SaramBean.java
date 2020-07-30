package org.comstudy21;

public class SaramBean {
	private int no;
	private String name, email;
	
	public SaramBean() {}

	public SaramBean(int no, String name, String email) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SaramBean [no=" + no + ", name=" + name + ", email=" + email + "]";
	}

}
