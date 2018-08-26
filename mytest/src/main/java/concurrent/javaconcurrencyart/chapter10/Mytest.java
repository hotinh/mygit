package concurrent.javaconcurrencyart.chapter10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Mytest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("---程序开始运行---");

        Date date1 = new Date();
        int taskSize = 5;

        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        List<Future<Object>> list = new ArrayList<Future<Object>>();

        for (int i=0; i<taskSize; i++) {
            Callable<Object> callable = new My_Callable(i+"");
            Future<Object> future = pool.submit(callable);
            list.add(future);
        }

        /*for (int i=0; i<taskSize; i++) {
            My_Runnable runnable = new My_Runnable(i+"");
            pool.submit(runnable);
        }*/

        pool.shutdown();


        for (Future<Object> future : list) {
            System.out.println("===" + future.get().toString());
        }

        Date date2 = new Date();
        System.out.println("---程序结束运行---，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");

    }
}

class My_Callable implements Callable<Object> {

    private String taskNum;

    public My_Callable(String taskNum) {
        super();
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果，当前任务时间【" + time + "毫秒】";
    }
}

class My_Runnable implements Runnable {

    private String taskNum;

    public My_Runnable(String taskNum) {
        super();
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
    }

}
