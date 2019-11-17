package edu.gcccd.csis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/MyWebservice/sqr

@WebServlet("/sqr")
public class WS extends HttpServlet {
    private static String html = "<html><body><h1>Square Root Calculator</h1><p>%s</p></body></html>";
    @Override
    protected void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        try {
            int k = Integer.parseInt(req.getParameter("x"));
            double d = Math.sqrt(k);
            String result = String.format("The square root of %d is %f",k,d);
            resp.getWriter().println(String.format(html,result));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (NumberFormatException e) {
            resp.getWriter().println(String.format("Something went wrong, did you use 'x' as a parameter name?"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
