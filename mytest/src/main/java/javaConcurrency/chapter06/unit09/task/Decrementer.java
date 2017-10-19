package javaConcurrency.chapter06.unit09.task;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 加法器，将数组中的每元素增加指定个单位
 */
public class Decrementer implements Runnable {
	/**
     * 要执行加法的数组
     */
	private AtomicIntegerArray vector;

	/**
     * 构造函数
     *
     * @param vector 要执行加法的数组
     */
	public Decrementer(AtomicIntegerArray vector) {
		this.vector = vector;
	}

	/**
     * 核心方法，将数组中的每元素增加指定个单位
     */
	@Override
	public void run() {
		for (int i=0; i<vector.length(); i++) {
			vector.getAndDecrement(i);
		}
	}

}
