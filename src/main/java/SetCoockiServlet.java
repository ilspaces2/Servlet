import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SetCoockiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //создаем куки с параметрами текстовыми
        Cookie cookie_0 = new Cookie("name", "Joe");
        Cookie cookie_1 = new Cookie("age", "30");

        //устанавливаем время жизни куки (в данном примере один день)
        cookie_0.setMaxAge(24*60*60);
        cookie_1.setMaxAge(24*60*60);

        //добавляем куки в наш ответ для клиента
        response.addCookie(cookie_0);
        response.addCookie(cookie_1);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
