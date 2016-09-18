import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTwo extends HttpServlet {
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

        try (PrintWriter out = response.getWriter())
        {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Название</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Заголовок страницы</h1>\n" +
                    "    <p>Основной текст</p>\n" +
                    "    Просто текст\n" +
                    "    <blockquote>Text s blockquote</blockquote>\n" +
                    "    <div>\n" +
                    "        Nichoshnui text\n" +
                    "        <hr>\n" +
                    "        <pre>Hren poimi chto eto za tag</pre>\n" +
                    "    </div>\n" +
                    "    <div>\n" +
                    "        <a href=\"onliner.by\">lul</a>\n" +
                    "        <ins>chito eta takoe</ins>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
        }
        catch (Exception e){}
    }
}
