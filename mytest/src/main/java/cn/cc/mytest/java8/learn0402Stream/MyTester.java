package cn.cc.mytest.java8.learn0402Stream;

import com.alibaba.fastjson.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.google.common.base.*;

public class MyTester {

    public static void main(String[] args) {
        MyTester tester = new MyTester();
//        tester.matchTester();
//        tester.filterTester();
//        tester.mapTester();
//        tester.countTester();
        tester.tester();
    }

    public void tester() {
        BigDecimal max = list.stream().max((a,b) -> a.getPrice().compareTo(b.getPrice())).get().getPrice();
        BigDecimal min = list.stream().min((a,b) -> a.getPrice().compareTo(b.getPrice())).get().getPrice();
        BigDecimal total = list.stream().map(e -> e.getPrice()).reduce(BigDecimal.ZERO, (a,b) -> a.add(b));

        System.out.println(max);
        System.out.println(min);
        System.out.println(total);

        long n = list.stream().map(e -> e.getGender()).distinct().count();
        System.out.println(n);
    }

    public void collectTester() {
        long m = list.stream().map(e -> e.getGender()).collect(Collectors.toSet()).size();
        System.out.println(m);

        list.stream().sorted((a,b) -> b.getPrice().compareTo(a.getPrice())).limit(3).collect(Collectors.toList()).forEach(System.out :: println);

        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(e -> e.getGender()));
        map.keySet().forEach(e -> {
            System.out.println(e + ":" + JSON.toJSONString(map.get(e)));
        });

        Map<Boolean, List<Person>> map2 = list.stream().collect(Collectors.partitioningBy(e -> e.getGender() == 1));
        List<Person> man = map2.get(true);
        List<Person> woman = map2.get(false);
        System.out.println(JSON.toJSONString(man));
        System.out.println(JSON.toJSONString(woman));

        Map<String, Person> map3 = list.stream().collect(Collectors.toMap(Person :: getName, e -> e));

        Map<String, Integer> map4 = list.stream().collect(Collectors.toMap(Person :: getName, e -> e.getGender()));

        Person[] p = list.stream().toArray(Person[] :: new);

        list.stream().collect(Collectors.groupingBy(Person :: getGender, Collectors.averagingDouble(Person :: getAge)));
    }

    public void countTester() {
        long l = list.stream().filter(e -> e.getName().startsWith("l")).count();
        System.out.println(l);
    }

    public void reduceTester() {
//        list.stream().sorted().reduce((a, b) -> ).get();
    }

    public void matchTester() {
        System.out.println(list.stream().anyMatch(s -> s.getName().startsWith("l")));
    }

    public void mapTester() {
        list.stream().map(e -> CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, e.getName())).forEach(System.out :: println);
    }

    public void filterTester() {
        list.stream().filter((a) -> a.getAge()>15).forEach(System.out :: println);
    }

    public void forEarchTester() {
        list.forEach(System.out :: println);
    }

    List<Person> list = new ArrayList<>();

    public MyTester() {
        init();
    }

    private void init() {
        list.add(new Person(1, "likel", 1, 12, "2018-06-16 00:00:00", new BigDecimal(11.1)));
        list.add(new Person(2, "daiiy", 1, 23, "2018-06-17 00:00:00", new BigDecimal(13.2)));
        list.add(new Person(3, "ranig", 0, 14, "2018-06-16 00:00:00", new BigDecimal(10.2)));
        list.add(new Person(4, "happy", 0, 21, "2018-06-20 00:00:00", new BigDecimal(15.2)));
        list.add(new Person(5, "homel", 1, 17, "2018-06-21 00:00:00", new BigDecimal(12.1)));
    }
    private static final class Person {
        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

        private Integer id;
        private String name;
        private Integer gender;
        private Integer age;
        private String time;
        private BigDecimal price;

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public BigDecimal getPrice() {
            return price.setScale(4, BigDecimal.ROUND_HALF_DOWN);
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Person(Integer id, String name, Integer gender, Integer age, String time, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.time = time;
            this.price = price;
        }
    }

}
