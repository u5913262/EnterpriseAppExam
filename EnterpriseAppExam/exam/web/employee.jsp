<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "com.mysql.jdbc.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sql:query dataSource="jdbc/employees" var="result">
    SELECT * FROM category
</sql:query>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>
<body>
<h1>Product</h1>
<form action="/Employee-Controller">
    <table>
        <tr>
            <td>Fist Name</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="text" name="gender"></td>
        </tr>
        <tr>
            <td>Employee Number</td>
            <td><input type="number" name="emp_no"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create">
            </td>
        </tr>
    </table>
</form>

</body>
</html>