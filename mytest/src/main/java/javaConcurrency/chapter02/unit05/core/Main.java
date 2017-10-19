package javaConcurrency.chapter02.unit05.core;

import javaConcurrency.chapter02.unit05.task.PrintQueue;
import javaConcurrency.chapter02.unit05.task.Job;

public class Main {
    public static void main(String[] args) {
        // 创建一个打印队列
        PrintQueue printQueue = new PrintQueue();

        // 创建10个打印线程
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // 启动线程
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
