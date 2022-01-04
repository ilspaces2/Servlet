<%@ page import="someClient.Client" %><%--
  Created by IntelliJ IDEA.
  User: tryyr
  Date: 14.11.2021
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><% Client client = (Client) session.getAttribute("client");%></p>
<p><%="Меня зовут " + client.getName() %>
</p>
<p><%= "Мне " + client.getAge()  %>
</p>
</body>
</html>
