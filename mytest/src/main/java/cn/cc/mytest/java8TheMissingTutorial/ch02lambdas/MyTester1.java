package cn.cc.mytest.java8TheMissingTutorial.ch02lambdas;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyTester1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");
        Collections.sort(names, (a, b) -> a.length() - b.length());
        names.forEach(System.out :: println);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("1", "lily", 23));
        personList.add(new Person("2", "lily", 14));
        personList.add(new Person("3", "lily", 28));

        Collections.sort(personList, (a,b) -> a.age.compareTo(b.age));
        personList.forEach(System.out :: println);
    }

    public MyTester1() {
    }

    private static class Person {
        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

        private String id;
        private String name;
        private Integer age;

        public Person(String id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
