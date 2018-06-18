package concurrent.javaConcurrencyInPractice.ch02.u02;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

    private static class ExpensiveObject {

    }
}
