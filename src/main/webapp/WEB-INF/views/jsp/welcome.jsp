<%--
  Created by IntelliJ IDEA.
  User: kks-home
  Date: 2018-10-05
  Time: 오후 6:20
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@
        taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome to Court Reservation System</h2>
    Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />
    <hr/>
    Handling time : ${handlingTime} ms
    <br>
    Locale : ${pageContext.reponse.locale}
</body>
</html>
