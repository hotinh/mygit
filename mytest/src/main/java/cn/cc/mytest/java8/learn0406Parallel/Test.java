package cn.cc.mytest.java8.learn0406Parallel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Stream stream = Stream.of();
		
		String[] array = new String[] {};
		stream = Arrays.stream(array);
		
		List<?> list = Arrays.asList(array);
		stream = list.stream();
		
//		IntStream.of(new int[] {1,2,3}).forEach(System.out :: println);
//		IntStream.range(1, 3).forEach(System.out :: println);
//		IntStream.rangeClosed(1, 3).forEach(System.out::println);
		
		
		String[] ss = {"123132","fdsf"};
		List<String> wordList = Arrays.asList(ss);
		List<String> output = wordList.stream().
				map(String::toUpperCase).
				collect(Collectors.toList());
		System.out.println(output);
		
		List<String> output2 = wordList.parallelStream().
				map(String::toUpperCase).
				collect(Collectors.toList());
		
		
		Stream<List<Integer>> inputStream = Stream.of(
				 Arrays.asList(1),
				 Arrays.asList(2, 3),
				 Arrays.asList(4, 5, 6)
				 );
				Stream<Integer> outputStream = inputStream.
				flatMap((childList) -> childList.stream());
		System.out.println(outputStream.collect(Collectors.toList()));
		
		
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		Integer[] evens = Stream.of(sixNums).
				filter(n -> n%2 == 0).toArray(Integer[]::new);
		System.out.println(Arrays.asList(evens));
		
		
		Stream.of("one", "two", "three", "four")
		 .filter(e -> e.length() > 3)
		 .peek(e -> System.out.println("Filtered value: " + e))
		 .map(String::toUpperCase)
		 .peek(e -> System.out.println("Mapped value: " + e))
		 .collect(Collectors.toList());
		
		
		
		String strA = " abcd ", strB = null;
		print(strA);
		print("");
		print(strB);
		getLength(strA);
		getLength("");
		getLength(strB);
		
		
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		System.out.println(concat);
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").
		 filter(x -> x.compareTo("Z") > 0).
		 reduce("", String::concat);
		
		class Person {
			 public int no;
			 private String name;
			 public Person (int no, String name) {
				 this.no = no;
				 this.name = name;
			 }
			 public String getName() {
				 System.out.println(name);
				 return name;
			 }
		}
		
		 /*List<Person> persons = new ArrayList();
		 for (int i = 1; i <= 10000; i++) {
			 Person person = new Person(i, "name" + i);
			 persons.add(person);
		 }
		List<String> personList2 = persons.stream().
				map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		 System.out.println(personList2);*/
		 
		 
		 /*List<Person> persons = new ArrayList();
			 for (int i = 1; i <= 5; i++) {
			 Person person = new Person(i, "name" + i);
			 persons.add(person);
		 }
		List<Person> personList2 = persons.stream().sorted((p1, p2) -> 
			p1.getName().compareTo(p2.getName())).limit(2).collect(Collectors.toList());
		System.out.println(personList2);*/
		
		/*List<Person> persons = new ArrayList();
		 for (int i = 1; i <= 5; i++) {
			 Person person = new Person(i, "name" + i);
			 persons.add(person);
		 }
		List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> 
			p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
		System.out.println(personList2);*/
		
		
		BufferedReader br = new BufferedReader(new FileReader("e:\\test\\001.txt"));
//		int longest = br.lines().
//			 mapToInt(String::length).
//			 max().
//			 getAsInt();
//		br.close();
//		System.out.println(longest);
		
		List<String> words = br.lines().
				 flatMap(line -> Stream.of(line.split(" "))).
				 filter(word -> word.length() > 0).
				 map(String::toLowerCase).
				 distinct().
				 sorted().
				 collect(Collectors.toList());
		br.close();
		System.out.println(words);
		
		
		class Person2 {
			 public int no;
			 private String name;
			 private int age;
			 public Person2 (int no, String name, int age) {
				 this.no = no;
				 this.name = name;
				 this.age = age;
			 }
			 public String getName() {
				 System.out.println(name);
				 return name;
			 }
			public int getAge() {
				return age;
			}
		}
		List<Person2> persons = new ArrayList();
		persons.add(new Person2(1, "name" + 1, 10));
		persons.add(new Person2(2, "name" + 2, 21));
		persons.add(new Person2(3, "name" + 3, 34));
		persons.add(new Person2(4, "name" + 4, 6));
		persons.add(new Person2(5, "name" + 5, 55));
		
		
		boolean isAllAdult = persons.stream().
				allMatch(p -> p.getAge() > 18);
		System.out.println("All are adult? " + isAllAdult);
		boolean isThereAnyChild = persons.stream().
				anyMatch(p -> p.getAge() < 12);
		System.out.println("Any child? " + isThereAnyChild);
		
		
		Random seed = new Random();
		Supplier<Integer> random = seed :: nextInt;
		Stream.generate(random).limit(10).forEach(System.out :: println);
		
		IntStream.generate(() -> (int)(System.nanoTime() % 100))
							.limit(10).forEach(System.out :: println);
		
		class PersonSuppler implements Supplier<Person2> {
			private int index = 0;
			private Random random = new Random();
			
			public Person2 get() {
				return new Person2(index++, "StormTestUser" + index, random.nextInt(100));
			}
		}
		
		Stream.generate(new PersonSuppler())
				.limit(10)
				.forEach(p -> System.out.println(p.getName() + ", " + p.getAge() ));
		
		
		
		Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));
		
		
		
		Map<Integer, List<Person2>> person2Groups 
			= Stream.generate(new PersonSuppler())
				.limit(100)
				.collect(Collectors.groupingBy(Person2 :: getAge));
		Iterator it = person2Groups.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, List<Person2>> person2s = (Map.Entry) it.next();
			System.out.println("Age " + person2s.getKey() + " = " + person2s.getValue().size());
		}
		
		
		
		Map<Boolean, List<Person2>> children 
			= Stream.generate(new PersonSuppler())
			.limit(100)
			.collect(Collectors.partitioningBy(p -> p.getAge() < 18));
		System.out.println("Children number: " + children.get(true).size());
		System.out.println("Adult number: " + children.get(false).size());
	}
	
	
	public static void print(String text) {
		 // Java 8
		 Optional.ofNullable(text).ifPresent(System.out::println);
		 // Pre-Java 8
		 if (text != null) {
			 System.out.println(text);
		 }
	 }
	public static int getLength(String text) {
		 // Java 8
		return Optional.ofNullable(text).map(String::length).orElse(-1);
		 // Pre-Java 8
		// return if (text != null) ? text.length() : -1;
	 }
	
	
}
