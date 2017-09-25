package cn.cc.mytest.ref;

import java.lang.reflect.Field;

public class TestField {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Test tset = new Test();
		
		Field[] fields = tset.getClass().getFields();
		
		for (Field field : fields) {
//			System.out.println(field + "=" + field.getType());
			
			Class type = field.getType();
			if (type == String.class) {
				System.out.println("String=" + field.getName());
				field.set(null, "2");
			} else if (type == Integer.class) {
				System.out.println("Integer=" + field.getName());
				field.set(null, 2);
			}
		}

		System.out.println(tset.name);
	}

}
