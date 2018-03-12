<%--
  Created by IntelliJ IDEA.
  User: wersom
  Date: 2017/10/20 0020
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册页</title>
</head>
<body>
<form action="/struts2/addUser" method="post">
    用户名 ：<input type="text" name="username" /><br/>
    密  码 ：<input type="password" name="password" /><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
