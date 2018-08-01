<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/30
  Time: 13:34
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
        <span>系统管理</span>
        <span style="float: right"><a href="goMainPage">返回</a></span>
        <span style="float: right">/</span>
        <span style="float: right"><a href="goToUserMenu">${sessionScope.admin.m_name}</a></span>
    </div>
    <div style="position:absolute;width: 30%;height:900px;border-width: 2px">
        <div>
            <a href="#">XXXX</a>
        </div>
        <div>
            <a href="checkResumeSended?startPage=0&status=0">查阅招聘</a>
        </div>
        <div>
            <a href="#">面试结果确认</a>
        </div>
        <div>
            <a href="#">招聘信息创建</a>
        </div>
        <div>
            <a href="#">发布/下架招聘信息</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <span>等待处理的面试：</span>
        <c:forEach items="${sessionScope.re_recForFace}" var="i">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td>${i.resume.re_name}</td>
                    <td>求职岗位：</td>
                    <td>${i.recruitment.rec_jobname}</td>
                </tr>
                <tr>
                    <td><a href="CreateEmployee?fromNum=0&re_rec_id=${i.re_rec_id}"><input type="button">录用并导入简历</a></td>
                    <td><a href="changeRE_RECStatus?re_rec_id=${i.re_rec_id}&status=6"><input type="button">拒绝</a></td>
                </tr>
            </table>
        </c:forEach>
    </div>
</body>
</html>

