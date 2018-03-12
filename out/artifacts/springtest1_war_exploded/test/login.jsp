<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>登录页面</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script language="javascript">
$(document).ready(function(){
    $("#reg_btn").click(function(){
        window.location = "/struts2/register";
    });
})
</script>
</head>
<body>
    <form action="/struts2/login" method="post">
        用户名 ：<input type="text" name="username" /><br/>
        密  码 ：<input type="password" name="password" /><br/>
        <input type="submit" value="登录"/>
        <input type="button" id="reg_btn" value="注册"/>
    </form>
</body>
</html>