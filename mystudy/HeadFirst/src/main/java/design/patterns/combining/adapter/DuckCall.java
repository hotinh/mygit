package design.patterns.combining.adapter;

public class DuckCall implements Quackable {
	public void quack() {
		System.out.println("Kwak");
	}
}
