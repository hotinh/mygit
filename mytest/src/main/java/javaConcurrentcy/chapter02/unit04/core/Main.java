package javaConcurrentcy.chapter02.unit04.core;

import javaConcurrentcy.chapter02.unit04.task.Consumer;
import javaConcurrentcy.chapter02.unit04.task.EventStorage;
import javaConcurrentcy.chapter02.unit04.task.Producer;

public class Main {
    public static void main(String[] args) {
        // 创建一个事件存储对象
        EventStorage storage = new EventStorage();

        // 创建一个事件生产者对象，并且将其放入到一个线程中运行
        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        // 创建一个事件消费者对象，并且将其放入到一个线程中运行
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);

        // 启动两线程
        thread2.start();
        thread1.start();
    }
}
