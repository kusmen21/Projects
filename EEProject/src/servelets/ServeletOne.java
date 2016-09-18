package servelets;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;


public class ServeletOne extends HttpServlet
{
    private int count = 0;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");

        count++;
        request.getSession().setAttribute("count", count);
        request.getServletContext().setAttribute("ServeletContextAtribute", "here");

        try (PrintWriter out = response.getWriter())
        {
            out.println(getHtmlFromFile("for_ServeletOne_begin.html"));

            Enumeration e = request.getParameterNames();
            while (e.hasMoreElements())
            {
                String param = e.nextElement().toString();
                out.println("<h1>" + param + " = " + request.getParameter(param) + "</h1>");
            }
            out.println("<h1>" + "count of page reload = " + request.getSession().getAttribute("count") + "</h1>");

            out.println("<h1>CODE OF REQUEST = " + response.getStatus() + "</h1>");

            out.println("<h1>" + "ServeletContextAtribute = " +
                    request.getServletContext().getAttribute("ServeletContextAtribute") + "</h1>");

            out.println(getHtmlFromFile("for_ServeletOne_end.html"));
        }
        catch (Exception e) {}
    }

    private String getHtmlFromFile(String filename)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream reader = new FileInputStream("D:\\Projects\\EEProject\\web\\html\\" + filename))
        {
            byte[] buffer = new byte[reader.available()];
            reader.read(buffer);
            stringBuilder.append(new String(buffer, Charset.forName("UTF-8"))).append("\n");
        }
        catch (Exception e) {}
        return stringBuilder.toString();
    }

}