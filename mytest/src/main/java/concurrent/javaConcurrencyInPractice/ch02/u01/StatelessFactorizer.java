package concurrent.javaConcurrencyInPractice.ch02.u01;


import concurrent.javaConcurrencyInPractice.ch01.ThreadSafe;
import concurrent.javaConcurrencyInPractice.ch02.Abs;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@ThreadSafe
public class StatelessFactorizer extends Abs implements Servlet {
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
