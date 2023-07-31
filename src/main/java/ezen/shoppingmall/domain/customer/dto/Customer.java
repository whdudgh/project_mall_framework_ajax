package ezen.shoppingmall.domain.customer.dto;

public class Customer {

	private int custKey;
	private String email;
	private String uName;
	private String uPwd;
	private String uBirth;
	private String phoneNum;
	private String signout;
	
	public Customer() {}
	
	public Customer(int custKey, String email, String uName, String uPwd, String uBirth, String phoneNum,
			String signout) {
		this.custKey = custKey;
		this.email = email;
		this.uName = uName;
		this.uPwd = uPwd;
		this.uBirth = uBirth;
		this.phoneNum = phoneNum;
		this.signout = signout;
	}
	
//	생성자 오버로딩
	public Customer(String email, String uName, String uPwd, String uBirth, String phoneNum) {
		this.email = email;
		this.uName = uName;
		this.uPwd = uPwd;
		this.uBirth = uBirth;
		this.phoneNum = phoneNum;
	}



	public int getCustKey() {
		return custKey;
	}



	public void setCustKey(int custKey) {
		this.custKey = custKey;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getuName() {
		return uName;
	}



	public void setuName(String uName) {
		this.uName = uName;
	}



	public String getuPwd() {
		return uPwd;
	}



	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}



	public String getuBirth() {
		return uBirth;
	}



	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}



	public String getPhoneNum() {
		return phoneNum;
	}



	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}



	public String getSignout() {
		return signout;
	}



	public void setSignout(String signout) {
		this.signout = signout;
	}



	@Override
	public String toString() {
		return "Customer [custKey=" + custKey + ", email=" + email + ", uName=" + uName + ", uPwd=" + uPwd + ", uBirth="
				+ uBirth + ", phoneNum=" + phoneNum + ", signout=" + signout + "]";
	}
	
	
	
}
