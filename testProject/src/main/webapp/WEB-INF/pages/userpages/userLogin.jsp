<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body style="background-color: aliceblue">
<div align="center" style="background-color: blanchedalmond;height: 250px">
    <legend><h3>欢迎来到用户管理</h3></legend>
        <form method="post" action="userLogin">
            用户:<input type="text" name="u_name"/><br/>
            密码:<input type="password" name="u_pass"/><br/>
            <input type="submit" value="用户登录"/>
            <a href="goAdminLoginPage"><input type="button" value="管理员登录"></a>
            <a href="goMainPage">返回</a>
            <h3 id="h3"><%
                if(request.getAttribute("error")!=null){
                    out.print("用户名或密码错误");
                }
            %></h3>
        </form>
    </fieldset>
</div>
</body>
</html>

