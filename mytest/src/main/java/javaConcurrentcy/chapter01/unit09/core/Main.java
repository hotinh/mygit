package javaConcurrentcy.chapter01.unit09.core;

import javaConcurrentcy.chapter01.unit09.handler.ExceptionHandler;
import javaConcurrentcy.chapter01.unit09.task.Task;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(); // 创建一个任务
        Thread thread = new Thread(task); // 创建一个线程
        thread.setUncaughtExceptionHandler(new ExceptionHandler()); // 设置线程的异常处理器
        thread.start();

        try {
            thread.join(); // 等待线程完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");
    }
}
