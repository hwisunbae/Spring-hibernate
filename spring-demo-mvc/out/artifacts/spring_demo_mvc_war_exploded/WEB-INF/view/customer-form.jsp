<%--
  Created by IntelliJ IDEA.
  User: hwisunbae
  Date: 2020-07-28
  Time: 6:52 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>

    <style>
        .error {color: red}
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="customer">
        First name: <form:input path="firstName"></form:input>
        <br>
        Last name (*): <form:input path="lastName"></form:input>
        <form:errors path="lastName" cssClass="error"></form:errors>
        <br>
        Free pass: <form:input path="freePass"></form:input>
        <form:errors path="freePass" cssClass="error"></form:errors>
        <br>
        Postal code: <form:input path="postalCode"></form:input>
        <form:errors path="postalCode" cssClass="error"></form:errors>
        <br>
        Course code: <form:input path="courseCode"></form:input>
        <form:errors path="courseCode" cssClass="error"></form:errors>
        <br>
        <input type="submit" value="submit">
    </form:form>
</body>
</html>
