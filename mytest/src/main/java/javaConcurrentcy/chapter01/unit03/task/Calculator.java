package javaConcurrentcy.chapter01.unit03.task;

public class Calculator implements Runnable {
	
	// 声明一个名为number的私有 private int 属性
	private int number;
	
	// 编写这个类的一个构造器，用来为属性number设置值
	public Calculator(int number) {
		this.number = number;
	}

	// run 方法。这个方法用阿里执行我们创建的线程的指令，它将对指定的属性进行乘法表运算
	@Override
	public void run() {
		for (int i =1; i<= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, number*i);
		}
	}

}
