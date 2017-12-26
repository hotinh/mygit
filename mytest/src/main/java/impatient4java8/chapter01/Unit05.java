package impatient4java8.chapter01;

import java.util.Arrays;

public class Unit05 {
    
    public static void main(String[] args) {
        repeatMessage1("Hello", 10);
    }
    
    public static void repeatMessage1(String text, int count) {
        Runnable r = () -> {
            for (int i=0; i<count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
    
//    public static void repeatMessage2(String text, int count) {
//        Runnable r = () -> {
//            while(count > 0) {
//                count--;
//                System.out.println(text);
//                Thread.yield();
//            }
//        };
//        new Thread(r).start();
//    }
}
