package cn.cc.mytest.testArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/** 
 * TODO Comment of Client 
 * @author 百恼 2013-11-16下午07:58:38 
 * 
 */  
public class Client {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        int capacity = 10;  
        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<Bread>(capacity);  
  
        new Thread(new Producer(queue)).start();  
        new Thread(new Producer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
    }  
  
}  
