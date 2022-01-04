import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class PostgresqlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            //грубо говоря подключаемся к драйверу
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //делаем соединение к базе данных
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "1234");


            Statement statement = connection.createStatement();


            //у нас уже есть в базе данных таблица с данными. хочу добавить из java данные. в статемент добавляем нужные поля
//             statement.executeUpdate("INSERT INTO books (title,autor,quantity) VALUES ('BarnYYY', 'Creazy', 20)");

            //молжно удалить и базы
//             statement.executeUpdate("DELETE FROM books WHERE title = 'BarnYYY'");

            //когда закончили манипуляции с базой, получаем данные в объект результСет с помощью селект.
            //пишем что хотим выбрать и откуда
             ResultSet resultSet = statement.executeQuery("SELECT title,quantity from books");

            //перебираем с помощью цикла полученные данные и выводим на страницу
            while (resultSet.next()){
                printWriter.println(resultSet.getString("title")+" "+resultSet.getString("quantity"));
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
