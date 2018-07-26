<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  Time: 11:05
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
    <style>

    </style>
</head>
<body>
    <div style="height: 35px">
        <span>魔都XXXXX公司主页</span>
        <span style="float: right"><a href="goToPage">注册</a></span>
        <span style="float: right">/</span>
        <span style="float: right">
            <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <a href="goToUserMenu">${sessionScope.user.u_name}</a>
                </c:when>
                <c:otherwise>
                    <a href="goToLoginPage">登录</a>
                </c:otherwise>
            </c:choose>
        </span>
    </div>
</body>
</html>

