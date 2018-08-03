<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/3
  Time: 10:18
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
        <legend><h3>欢迎来到员工管理</h3></legend>
        <form method="post" action="employeeLogin">
            用户:<input type="text" name="emp_code"/><br/>
            密码:<input type="password" name="emp_pass"/><br/>
            <input type="submit" value="用户登录"/>
            <a href="goToLoginPage">我是用户</a>
            <a href="goAdminLoginPage">我是管理员</a>
            <a href="goMainPage">返回</a>
            <h3 id="h3"><%
                if(request.getAttribute("employeeLoginStatus")!=null){
                    out.print("用户名或密码错误");
                }
            %></h3>
        </form>
        </fieldset>
    </div>
</body>
</html>

