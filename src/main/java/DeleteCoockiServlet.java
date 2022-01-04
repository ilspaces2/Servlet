import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class DeleteCoockiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //создаем куки c такимже name  которые хотим удалить, значения не важно какие будут
        Cookie cookie =new Cookie("name","");

        //устанавливаем время жизни куки =0 и куки удалится сразу, если поставить -1 то удалится после закрытия браузера
        cookie.setMaxAge(0);

        //добавляем куки в наш ответ для клиента
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
