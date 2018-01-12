package test;

public class StringTest {

	public static void main(String[] args) {
		
		String s1 = "qwe";
		String s2 = "asd";
		
		System.out.println(String.format("Can not find %2$s's and %1$s's properties", s1, s2));
		
		System.out.println(String.format("%1$7s %3$2s %2$2s %1$2s", "a", "b", "c", "d"));
		
		String ss = "incrementRefireCount";

		System.out.println(ss.startsWith("get"));
	}

}
