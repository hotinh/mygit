package concurrent.javaConcurrency.chapter03.unit08.test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

       private static final Exchanger<String> exgr = new Exchanger<>();

       private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

       public static void main(String[] args) {
             threadPool.execute( new Runnable() {
                   @Override
                   public void run() {
                         // TODO Auto-generated method stub
                         try {
                              String A = "银行流水A" ; // A录入银行流水
                              System. out.println( "---A---");
                               exgr.exchange(A);
                        } catch (InterruptedException e) {
                              e.printStackTrace();
                        }
                  }
            });

             threadPool.execute( new Runnable() {
                   @Override
                   public void run() {
                         // TODO Auto-generated method stub
                         try {
                              String B = "银行流水B" ;// B录入银行流水数据
                              System. out.println( "---B---");
                              String A = exgr.exchange(B);
                              System. out.println( "A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入的是：" + B);
                        } catch (InterruptedException e) {

                        }
                  }
            });
             threadPool.shutdown();
      }
}

