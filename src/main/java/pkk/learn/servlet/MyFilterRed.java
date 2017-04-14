package pkk.learn.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Kyrylo_Pysarenko on 4/13/2017.
 */
public class MyFilterRed implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(MyFilterRed.class);

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("call MyFilterRed");
        request.setAttribute("colour", "red");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
