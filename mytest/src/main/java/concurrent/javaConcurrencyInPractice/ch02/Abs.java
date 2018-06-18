package concurrent.javaConcurrencyInPractice.ch02;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

public abstract class Abs {
    protected BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    protected BigInteger[] factor(BigInteger i) {
        return null;
    }

    protected void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {

    }
}
