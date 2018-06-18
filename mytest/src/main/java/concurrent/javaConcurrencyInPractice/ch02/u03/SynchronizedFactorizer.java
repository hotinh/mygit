package concurrent.javaConcurrencyInPractice.ch02.u03;

import concurrent.javaConcurrencyInPractice.ch01.GuardBy;
import concurrent.javaConcurrencyInPractice.ch01.ThreadSafe;
import concurrent.javaConcurrencyInPractice.ch02.Abs;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 2-6
 */
@ThreadSafe
public class SynchronizedFactorizer extends Abs implements Servlet {
    @GuardBy("this") private BigInteger lastNumber;
    @GuardBy("this") private BigInteger[] lastFactors;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(servletResponse, lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(servletResponse, factors);
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
