<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/3
  Time: 15:43
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
    <div style="height: 35px">
        <span>员工自我管理</span>
        <span style="float: right"><a href="goMainPage">返回</a></span>
        <span style="float: right">/</span>
        <span style="float: right"><a href="goToUserMenu">${sessionScope.employee.emp_name}</a></span>
    </div>
    <div style="position:absolute;width: 30%;height:900px;border-width: 2px">
        <div>
            <a href="goEmpClockIn">考勤打卡</a>
        </div>
        <div>
            <a href="#"></a>
        </div>
        <div>
            <a href="#"></a>
        </div>
        <div>
            <a href="#"></a>
        </div>
        <div>
            <a href="#"></a>
        </div>
        <div>
            <a href="#"></a>
        </div>
        <div>
            <a href="empCheckTrain">培训查询</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <h3>考勤打卡</h3>
        <c:choose>
            <c:if test="#{sessionScope.currentAttendance!=null}">
                <a href="morningClockIn"><input type="button" value="上班打卡`"></a>
            </c:if>
            <c:otherwise>
                <a href="#"><input type="button" value="下班打卡"></a>
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>

