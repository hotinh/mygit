package headfirst.designPatterns.observer.weatherStation;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
