<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
B
<%
    if (session.getAttribute("auth") == null)
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("needLogin.txt");
        dispatcher.forward(request, response);
    }
%>
news!!!
</body>
</html>
