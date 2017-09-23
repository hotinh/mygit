package cn.cc.mytest.mybatis2.beans;

import com.google.gson.Gson;

public class UserBean {

    //实体类的属性和表的字段名称一一对应
    private int id;
    private String username;
    private String password;
    private double account;

    

    public UserBean() {
		// TODO Auto-generated constructor stub
	}



	public UserBean(String username, String password, double account) {
		this.username = username;
		this.password = password;
		this.account = account;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public double getAccount() {
		return account;
	}



	public void setAccount(double account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id 
		+ ", username=" + username 
		+ ", password=" + password 
		+ ", account=" + account 
		+ "]";
	}


}
