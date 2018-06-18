package concurrent.javaConcurrencyInPractice.ch02.u03;

/**
 * 2-7
 */
public class Widget {
    public synchronized void doSomething() {
        //TODO
    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
