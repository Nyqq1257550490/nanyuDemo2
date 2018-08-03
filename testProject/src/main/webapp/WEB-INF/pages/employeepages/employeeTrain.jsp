<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/3
  Time: 15:06
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
            <a href="#">XXXX</a>
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
            <a href="goToEmployeeFinder"></a>
        </div>
        <div>
            <a href="empCheckTrain">培训查询</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <table>
            <tr>
                <td>培训编号</td>
                <td>培训主题</td>
                <td>培训内容</td>
                <td>培训开始时间</td>
                <td>培训结束时间</td>
                <td>培训地址</td>
            </tr>
            <c:forEach items="${sessionScope.emp_TrainInfo}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.title}</td>
                    <td>${i.content}</td>
                    <td>${i.starttime}</td>
                    <td>${i.endtime}</td>
                    <td>${i.address}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

