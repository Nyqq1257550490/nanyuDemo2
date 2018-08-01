<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  TimeTool: 11:05
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
                    <form action="goToUserMenu" method="get">
                        <input type="submit" name="viewUserMenu" value="${sessionScope.user.u_name}">
                        <input type="hidden" name="startPage" value="1">
                    </form>
                </c:when>
                <c:otherwise>
                    <a href="goToLoginPage">登录</a>
                </c:otherwise>
            </c:choose>
        </span>
    </div>
    <div style="position:absolute;width: 30%;height:900px;border-width: 2px">
       <a href="goToRecruitmentPage?startPage=0">查看招聘信息</a>

    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        公司大致介绍
    </div>
</body>
</html>

