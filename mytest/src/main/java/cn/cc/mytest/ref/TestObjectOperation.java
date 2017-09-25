package cn.cc.mytest.ref;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings ("unchecked" )
public class TestObjectOperation {

       public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException,
                  IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
    	   
            User p1 = new User( "张三" , 12);
            System. out.println(p1);
            System. out.println();

            System. out.println( "--------直接操作对象属性----------" );
            TestObjectOperation t = new TestObjectOperation();
            t.mf1(p1, "name", "李四" );
            t.mf1(p1, "age", 30);
            System. out.println(p1);
            System. out.println();

            System. out.println( "---------直接操作类属性---------" );
            t.mf2( "reflection.User" , "total" , 88);
//          t.mf2("reflection.User", "name", "1111");
            System. out.println();

            System. out.println( "---------调用对象成员方法---------" );
             Class[] argTypes = { String. class, int. class };
            Object[] argso = new Object[] { "王五" , 88 };
            t.mf3(p1, "setAll", argTypes, argso);
            System. out.println(p1);
            System. out.println();

            System. out.println( "--------调用类成员方方法----------" );
            t.mf4( "reflection.User" , "showTotal" , null, null);
//          t.mf4("reflection.User", "ttt", null, null);
            
            

      }

       // 直接操作对象属性
       public void mf1(Object o, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
             Class c = o.getClass();
            Field f = c.getField(fieldName);
            Object fv = f.get(o);
            System. out.println( "修改前：" + fieldName + "=" + fv);
            f.set(o, newValue);
            System. out.println( "\t修改后:" + fieldName + "=" + f.get(o));
      }

       // 直接操作类属性
       public void mf2(String className, String fieldName, Object newValue) throws ClassNotFoundException,
                  NoSuchFieldException, IllegalAccessException {
             Class c = Class.forName (className);
            Field f = c.getField(fieldName);
            Object fv = f.get(c);
            System. out.println( "修改前：" + fieldName + "=" + fv);
            f.set(c, newValue);
            System. out.println( "\t修改后:" + fieldName + "=" + f.get(c));
      }

       // 调用对象成员方法
       public void mf3(Object o, String methodName, Class[] argTypes, Object[] args) throws NoSuchMethodException,
                  IllegalAccessException, IllegalArgumentException, InvocationTargetException {
             Class c = o.getClass();
            Method m = c.getMethod(methodName, argTypes);
            Object result = m.invoke(o, args);
            System. out.println( "result:" + result);
      }

       // 调用类成员方方法
       public void mf4(String className, String methodName, Class[] argTypes, Object[] args)
                   throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException,
                  IllegalAccessException, InvocationTargetException {
             Class c = Class.forName (className);
            Method m = c.getMethod(methodName, argTypes);
            Object result = m.invoke( null, args);
            System. out.println( "result=" + result);
      }

}

