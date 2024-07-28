
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
    <form method="post" action="login">
        <h1>Veuillez vous identifier:</h1>
        <label for="txtLogin">Login:</label>
        <input id="txtLogin" name="txtLogin" type="text" value='${login}' autofocus /> <br/>
        <label for="txtPassword">Password:</label>
        <input id="txtPassword" name="txtPassword" type="text" value='${password}' /> <br/>
        <input name="btnConnect" type="submit" />
        <div class="errorMessage">${errorMessage}</div>
    </form>
    <br/>
</body>
</html>