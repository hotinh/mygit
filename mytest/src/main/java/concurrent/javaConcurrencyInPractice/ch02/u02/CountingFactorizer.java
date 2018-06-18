package concurrent.javaConcurrencyInPractice.ch02.u02;

import concurrent.javaConcurrencyInPractice.ch01.ThreadSafe;
import concurrent.javaConcurrencyInPractice.ch02.Abs;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class CountingFactorizer extends Abs implements Servlet {
    private final AtomicLong count = new AtomicLong();

    public long getCount() {return count.get();}

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
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
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
