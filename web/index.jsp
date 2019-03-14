<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 2019-03-13
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="logged" method="post">
    Username : <input name = "username" value="${cookie.username.value}" /><br />
    Password: <input name = "password" type="password" /><br/>
    Remember me <input type="checkbox"
                       <%--<c:if test="{userCookie.containsKey('name')}">--%>
                       <%--</c:if>--%>
                         checked name ="check" value = "no" />
                       <br />
    <input type = "submit" />

  </form>
  </body>
</html>
