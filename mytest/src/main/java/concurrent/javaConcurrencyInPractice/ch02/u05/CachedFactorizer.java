package concurrent.javaConcurrencyInPractice.ch02.u05;

import concurrent.javaConcurrencyInPractice.ch01.GuardBy;
import concurrent.javaConcurrencyInPractice.ch02.Abs;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class CachedFactorizer extends Abs implements Servlet {
    @GuardBy("this") private BigInteger lastNumber;
    @GuardBy("this") private BigInteger[] lastFactors;
    @GuardBy("this") private long hits;
    @GuardBy("this") private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(servletResponse, factors);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
