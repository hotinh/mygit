package cn.cc.mytest.java8.learn0203Method;

import java.time.LocalDate;
import java.util.Arrays;

import cn.cc.mytest.java8.learn0203Method.Person.Sex;

public class ComparisonStatic {

	public static void main(String[] args) {
		Person [] persons = new Person[3];
		persons[0] = new Person("nam1", LocalDate.now().plusDays(4), Sex.MALE, "");
		persons[1] = new Person("nam2", LocalDate.now().plusDays(1), Sex.MALE, "");
		persons[2] = new Person("nam3", LocalDate.now().plusDays(2), Sex.MALE, "");
		
		System.out.println("---原始顺序---");
		Arrays.asList(persons).forEach(System.out :: println);
		
//		使用匿名类
//		Arrays.sort(persons, new Comparator<Person>() {
//	        @Override
//	        public int compare(Person o1, Person o2) {
//	            return o1.birthday.compareTo(o2.birthday);
//	        }
//		});
		
		//使用lambda表达式
//		Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));

		//使用lambda表达式和类的静态方法
//		Arrays.sort(persons, (o1, o2) -> Person.compareByAge(o1,o2));

		//使用方法引用
		//引用的是类的静态方法
		Arrays.sort(persons, Person::compareByAge);
		
		System.out.println("---排序后---");
		Arrays.asList(persons).forEach(System.out :: println);

	}

}
