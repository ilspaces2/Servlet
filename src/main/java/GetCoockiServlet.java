import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCoockiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем массив куков
        Cookie[] cookies = request.getCookies();

        //выводим на экран полученные куки из массива
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        for (Cookie coockie : cookies) {
            printWriter.println("<h1>" + "NameParam " + coockie.getName() + ";" + "ValueParam " + coockie.getValue() + "</h1>");
        }
        printWriter.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
