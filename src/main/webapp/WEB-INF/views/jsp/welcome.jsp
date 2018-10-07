<%--
  Created by IntelliJ IDEA.
  User: kks-home
  Date: 2018-10-05
  Time: 오후 6:20
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@
        taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%@
        taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="welcome.title" text="Welcome" /></title>
</head>
<body>
    <h2><spring:message code="welcome.message" text="Welcome to Court Reservation System" /></h2>
    Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />
    <hr/>
    Handling time : ${handlingTime} ms
    <br>
    Locale : ${pageContext.response.locale}
</body>
</html>
