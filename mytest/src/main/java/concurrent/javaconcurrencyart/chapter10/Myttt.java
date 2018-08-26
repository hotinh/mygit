package concurrent.javaconcurrencyart.chapter10;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;


import java.util.concurrent.Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;



public class Myttt {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);


        // org.apache.commons.lang3.concurrent.BasicThreadFactory
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
                1, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService pool2 = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool2.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool2.shutdown();//gracefully shutdown

    }
}
