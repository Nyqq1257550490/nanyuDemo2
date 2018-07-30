<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/28
  Time: 15:14
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
<body>
    <div align="center" style="background-color: blanchedalmond;height: 250px">
        <legend><h3>欢迎来到管理登录</h3></legend>
        <form method="post" action="adminLogin">
            用户:<input type="text" name="m_name"/><br/>
            密码:<input type="password" name="m_pass"/><br/>
            <input type="submit" value="管理登录"/>
            <a href="goToLoginPage">我是用户</a>
            <a href="goMainPage">返回</a>
            <h3 id="h3"><%
                if(request.getAttribute("error")!=null){
                    out.print("账号名或密码错误");
                }
            %></h3>
        </form>
        </fieldset>
    </div>
</body>
</html>

