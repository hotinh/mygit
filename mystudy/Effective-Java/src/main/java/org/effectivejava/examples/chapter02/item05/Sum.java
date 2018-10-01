package org.effectivejava.examples.chapter02.item05;

public class Sum {

    // Hideously slow program! can you spot the object creation?
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println();
        long sum = 0L;
        for (long i=0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
