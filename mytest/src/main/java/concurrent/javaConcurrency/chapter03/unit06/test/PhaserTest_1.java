package concurrent.javaConcurrency.chapter03.unit06.test;

import java.util.concurrent.Phaser;

public class PhaserTest_1 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(5);
        
        for(int i = 0 ; i < 5 ; i++){
            Task_01 task_01 = new Task_01(phaser);
            Thread thread = new Thread(task_01, "PhaseTest_" + i);
            thread.start();
        }
    }
    
    static class Task_01 implements Runnable{
        private final Phaser phaser;
        
        public Task_01(Phaser phaser){
            this.phaser = phaser;
        }
        
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行任务完成，等待其他任务执行......");
            
            phaser.arriveAndAwaitAdvance(); //等待其他任务执行完成
            
            System.out.println(Thread.currentThread().getName() + " 继续执行任务...");
        }
    }
}
