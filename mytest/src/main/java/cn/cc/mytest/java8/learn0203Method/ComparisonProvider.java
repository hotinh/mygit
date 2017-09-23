package cn.cc.mytest.java8.learn0203Method;

import java.time.LocalDate;
import java.util.Arrays;

import cn.cc.mytest.java8.learn0203Method.Person.Sex;

public class ComparisonProvider {
	
	public static void main(String[] args) {
		
		Person [] persons = new Person[3];
		persons[0] = new Person("nam1", LocalDate.now().plusDays(4), Sex.MALE, "");
		persons[1] = new Person("nam2", LocalDate.now().plusDays(1), Sex.MALE, "");
		persons[2] = new Person("nam3", LocalDate.now().plusDays(2), Sex.MALE, "");
		
		
		ComparisonProvider provider = new ComparisonProvider();
		
		//使用lambda表达式
		//对象的实例方法
		Arrays.sort(persons, (a,b) -> provider.compareByAge(a,b));
		
		//使用方法引用
		//引用的是对象的实例方法
		Arrays.sort(persons, provider::compareByAge);
	}

	 public int compareByName(Person a,Person b){
         return a.getName().compareTo(b.getName());
     }

     public int compareByAge(Person a,Person b){
         return a.getBirthday().compareTo(b.getBirthday());
     }
}
