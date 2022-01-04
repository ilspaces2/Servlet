import someClient.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //создаем сессию
        HttpSession session = request.getSession();

        // получаем  в качестве атрибута объект
        Client client = (Client) session.getAttribute("client");

        //принимаем от клиента параметры
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        //если клиент первый раз тут то создаем клиента с полученными параметрами(выше)
        if (client == null) {
            client = new Client();
            client.setName(name);
            client.setAge(age);
        }

        //сохраняем в сессии параметры клиента
        session.setAttribute("client", client);

        //делаем форвард клиента на нужную страницу(в данном примере на jsp файл)
        getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
