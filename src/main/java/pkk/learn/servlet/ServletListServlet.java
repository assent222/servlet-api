package pkk.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kyrylo_Pysarenko on 4/13/2017.
 */
public class ServletListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");

        out.println("<h1>ServletName: " + getServletConfig().getServletName() + "</h1>");
        out.println("<h4>servletRegistrations: </h4>");

        Map<String, ? extends ServletRegistration> servletRegistrations = getServletContext().getServletRegistrations();
        for (Map.Entry<String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {
            String key = entry.getKey();
//            out.println("<h4>key=" + key + " </h4>");

            ServletRegistration value = entry.getValue();
//            out.println("<h4>servletName=" + value.getName() + " </h4>");
//            out.println("<h4>className=" + value.getClassName() + " </h4>");
            for (String mappingUrl : value.getMappings()) {
//                out.println("<h4>mappingUrl=" + mappingUrl + " </h4>");
                String url = req.getServerName() + ":" + req.getServerPort() + mappingUrl;
                out.println(String.format("<p>servletName=%s; servletClass=%s; URL=<a href=\"%s\">%s</a></p>",
                                          value.getName(), value.getClassName(), mappingUrl, url));
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
}
