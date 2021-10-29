<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/29/2021
  Time: 12:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

  <g:each in="${books}" var="book">

    ${book.title}

    <br>

  </g:each>

</body>
</html>