<%--
  Created by IntelliJ IDEA.
  User: hwisunbae
  Date: 2020-07-28
  Time: 7:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
The Customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
Free passes : ${customer.freePass}
<br>
Postal code: ${customer.postalCode}
<br>
Course code: ${customer.courseCode}
</body>
</html>
