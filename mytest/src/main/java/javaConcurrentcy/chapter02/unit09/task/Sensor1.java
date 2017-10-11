package javaConcurrentcy.chapter02.unit09.task;

public class Sensor1 implements Runnable {
	
	/**
     * 建筑物状态对象
     */
	private BuildStats stats;
	
	 /**
     * 构造函数
     *
     * @param stats 建筑物状态对象
     */
	public Sensor1(BuildStats stats) {
		this.stats = stats;
	}

	/**
     * 核心方法，模拟人在建筑物中的进出
     */
	@Override
	public void run() {
		stats.comeIn();
		stats.comeIn();
		stats.comeIn();
		stats.goOut();
		stats.comeIn();
	}
}
