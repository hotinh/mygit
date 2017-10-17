package javaConcurrentcy.chapter05.unit02.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

       private static final long serialVersionUID = 4499838940473967871L;

       private static final int THRESHOLD = 2;

       private int start ;
       private int end ;

       public CountTask(int start, int end) {
             this.start = start;
             this.end = end;
      }

       @Override
       protected Integer compute() {
             int sum = 0;
             int start_t, end_t;

             if (start == end) {
                   return start + end;
            }
             if (start > end) {
                  start_t = end;
                  end_t = start;
            } else {
                  start_t = start;
                  end_t = end;
            }

             // 如果任务足够就计算任务
             boolean canCompute = (end_t - start_t) <= THRESHOLD;

             if (canCompute) {
                   for (int i = start_t; i <= end_t; i++) {
                        sum += i;
                  }
            } else {
                   // 如果任务大于阈值，就分裂成两个任务计算
                  System. out.println("-2-" );
                   int middle = (start_t + end_t) / 2;
                  CountTask leftTask = new CountTask(start_t, middle);
                  CountTask rightTask = new CountTask(middle + 1, end_t);

                   // 执行子任务
                  leftTask.fork();
                  rightTask.fork();

                   // 等待子任务执行完，并得到结果
                   int leftResult = leftTask.join();
                   int rightResult = rightTask.join();

                   // 合并子任务
                  sum = leftResult + rightResult;
            }
             return sum;
      }

       public static void main(String[] args) {
            ForkJoinPool forkJoinPool = new ForkJoinPool();

             // 生成一个计算任务，负责计算 1+2+3+4
              CountTask task = new CountTask(1, 4);

//          CountTask task = new CountTask(1, 2);
//            CountTask task = new CountTask(2, 1);

             // 执行一个任务
            Future<Integer> result = forkJoinPool.submit(task);

             try {
                  System. out.println(result.get());

            } catch (InterruptedException e) {

            } catch (ExecutionException e) {

            }
      }
}

