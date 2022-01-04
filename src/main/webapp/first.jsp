<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: tryyr
  Date: 09.11.2021
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First</title>
</head>
<body>
<h1>ЭТО JSP ФАЙЛ</h1>

<%--вывод по параметру аналогично как в сервлете--%>
    <%  String name =request.getParameter("name");  %>
    <%= "hello "+ name%>
</body>
</html>
