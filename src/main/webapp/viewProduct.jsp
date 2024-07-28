<%--
  Created by IntelliJ IDEA.
  User: jimmyni
  Date: 27/07/2024
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>View article</title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
    <form action="viewProduct" method="post">
        <h1>View article - ${connectedUser.firstName}</h1>
        <div>Identifier: ${catalogBrowser.currentArticle.productId}</div>
        <div>Brand: ${catalogBrowser.currentArticle.productName}</div>
        <div>Description: ${catalogBrowser.currentArticle.description}</div>
        <div>Unitary price: ${catalogBrowser.currentArticle.price}</div>
        <br/>
        <input name="btnPrevious" type="submit" value="Previous" />
        &nbsp; &nbsp;
        <input name="btnAdd" type="submit" value="Add to shopping cart" />
        &nbsp; &nbsp;
        <input name="btnNext" type="submit" value="Next" />
    </form>
    <%--${catalogBrowser.shoppingCartSize} article(s) in the shopping cart.<br/>--%>
    <%--<a href="summary">View the shopping cart</a>--%>
</body>
</html>
