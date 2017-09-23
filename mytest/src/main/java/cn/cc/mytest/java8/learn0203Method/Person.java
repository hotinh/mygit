package cn.cc.mytest.java8.learn0203Method;

import java.time.*;

public class Person {
	
	public enum Sex{
        MALE,FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    
    

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
        return emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public static int compareByAge(Person a,Person b){
        return a.birthday.compareTo(b.birthday);
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress="
				+ emailAddress + "]";
	}
    
}
