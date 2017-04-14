package pkk.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kyrylo_Pysarenko on 4/13/2017.
 */
public class CommonServlet extends HttpServlet {

    private static AtomicInteger servletInitCount = new AtomicInteger(0);
    private static AtomicInteger servletServiceCallCount = new AtomicInteger(0);

    @Override
    public void init() throws ServletException {
        servletInitCount.incrementAndGet();
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        servletServiceCallCount.incrementAndGet();
        super.service(req, res);
    }

    protected void showServletInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");

        out.println("<h1>ServletName: " + getServletConfig().getServletName() + "</h1>");
        out.println("<h2>Thread: " + Thread.currentThread().getName() + "</h2>");
        out.println("<h2>ServletContext: " + getServletContext() + "</h2>");
        out.println("<h1>CommonServletCount: " + servletInitCount.get() + "</h1>");
        out.println("<h1>CommonServletServiceCallCount: " + servletServiceCallCount.get() + "</h1>");

        Enumeration<String> names;

        out.println("<h4>ServletContext.InitParameters:</h4>");
        names = getServletContext().getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = getServletContext().getInitParameter(name);
            out.println(String.format("<h4>InitPapameter[ %s ] = %s</h4>", name, value));
        }

        out.println("<h4>ServletContext.Attributes:</h4>");
        names = getServletContext().getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = getServletContext().getAttribute(name).toString();
            out.println(String.format("<h4>Attribute[ %s ] = %s</h4>", name, value));
        }

        out.println("<h4>ServletConfig.InitParameters:</h4>");
        names = getServletConfig().getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = getServletConfig().getInitParameter(name);
            out.println(String.format("<h4>configInitPapameter[ %s ] = %s</h4>", name, value));
        }

        out.println("<h4>Request.Attributes:</h4>");

        names = req.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = req.getAttribute(name).toString();
            out.println(String.format("<h4>configInitPapameter[ %s ] = %s</h4>", name, value));
        }

        out.println("</body>");
        out.println("</html>");
    }
}
