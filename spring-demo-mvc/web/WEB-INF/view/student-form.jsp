<%--
  Created by IntelliJ IDEA.
  User: hwisunbae
  Date: 2020-07-16
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"></form:input>
    <br>
    Last name: <form:input path="lastName"></form:input>
    <br>
    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"></form:options>
    </form:select>

    <input type="submit" value="submit">
</form:form>
</body>
</html>
