<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/27 0027
  Time: 下午 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
    <script type="text/javascript" src="../resources/jquery/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="../resources/scripts/index.js"></script>
</head>
<body>
<p>
    用户名:<input type="text" id="login_username"/>
</p>
<p>
    密码:&nbsp;<input type="password" id="login_password"/>
</p>
<p>
    <input type="submit" id="login_submit" value="登入"/>
    <input type="submit" id="register" value="注册" onclick="locationToHref('/resources/page/register.html')"/>
</p>
</body>
</html>
