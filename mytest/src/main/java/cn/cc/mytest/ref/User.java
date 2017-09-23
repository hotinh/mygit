package cn.cc.mytest.ref;

public class User {
       public String name;
       public int age;
       public static int total = 100;

       public User() {
             super();
             total++;
      }

       public User(String name, int age) {
             super();
             this. name = name;
             this. age = age;
             total++;
      }

       public void setAll(String name, int age) {
             this. name = name;
             this. age = age;
      }

       public static void showTotal() {
            System. out.println( "total=" + total);
      }

       public String toString() {
             return "用户名：" + name + "\t密码：" + age ;
      }
}
