<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/30
  Time: 9:52
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
        <table>
            <tr>
                <td>职位名称</td>
                <td>职位薪水</td>
                <td>职位公司</td>
                <td>职位地址</td>
                <td>职位介绍</td>
                <td>职位福利</td>
                <td>修改</td>
                <td>删除</td>
                <td>操作</td>
            </tr>
        <c:forEach items="${sessionScope.recruitmentView}" var="i">
            <form action="modifyRecruitment?${i.rec_id}">
                <tr>
                    <td><input name="rec_jobname" value="${i.rec_jobname}"></td>
                    <td><input name="rec_income" value="${i.rec_income}"></td>
                    <td><input name="rec_company" value="${i.rec_company}"></td>
                    <td><input name="rec_address" value="${i.rec_address}"></td>
                    <td><input name="rec_intro" value="${i.rec_intro}"></td>
                    <td><input name="rec_welfare" value="${i.rec_welfare}"></td>
                    <td><input type="submit" name="changeInfo"></td>
                    <td><a href="#"><input type="button" value="删除"></a></td>
                    <td>
                        <c:choose>
                            <c:when test="${i.rec_status}=0">
                                <a href="#"><input type="button" value="上架"></a>
                            </c:when>
                            <c:otherwise>
                                <a href="#"><input type="button" value="下架"></a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </table>
    </div>
</body>
</html>

