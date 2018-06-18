package concurrent.javaConcurrencyInPractice.ch02.u02;

import concurrent.javaConcurrencyInPractice.ch01.NotThreadSafe;
import concurrent.javaConcurrencyInPractice.ch02.Abs;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@NotThreadSafe
public class UnsafeCountingFactorizer extends Abs implements Servlet {
    private long count = 0;

    public long getCount() {
        return count;
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
        BigInteger[] factors = factor(i);
        ++count;
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
