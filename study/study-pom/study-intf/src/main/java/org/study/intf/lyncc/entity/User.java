package org.study.intf.lyncc.entity;

import java.io.Serializable;

 
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;  
	
    private String username;  
    
    private String password;  
    
    private int age;
    
    private String mail;

    public User() {
    	
    }


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	 
}
