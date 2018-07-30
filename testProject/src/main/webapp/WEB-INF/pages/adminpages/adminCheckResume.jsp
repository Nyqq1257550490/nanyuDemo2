<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/28
  Time: 16:29
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
<%
    int totalPages= (int) session.getAttribute("re_recTotalPage");
%>
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
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <div style="width: 70%;height:100px;">
            <a href="checkResumeSended?startPage=0&status=0"><input type="button">查看新的简历投递</a>
            <a href="#"><input type="button">查看面试邀请</a>
            <a href="#"><input type="button">查看拒绝列表</a>
        </div>
        <div>
            <span>
                <c:choose>
                    <c:when test="${sessionScope.re_recStatus}!=null">
                        ${applicationScope.re_recStatus}
                    </c:when>
                    <c:otherwise>
                        ${sessionScope.re_recDetail}
                        <c:forEach items="${sessionScope.re_recDetail}" var="i">
                            <table>
                                <tr>
                                    <td>应聘者姓名：</td>
                                    <td>${i.resume.re_name}</td>
                                    <td>求职岗位：</td>
                                    <td>${i.recruitment.rec_jobname}</td>
                                    <td>未读</td>
                                </tr>
                                    <td>投稿时间</td>
                                    <td>${i.re_rec_time}</td>
                                <tr>
                                    <td><a href="checkRe_RecResume?re_id=${i.resume.re_id}"><input>查看简历详情</a></td>
                                    <td><a href="#"><input>查看招聘详情</a></td>
                                    <td><a href="#"><input>无视简历</a></td>
                                </tr>
                            </table>
                        </c:forEach>
                        <%
                            for (int i = 1; i <=totalPages; i++) {
                        %>
                        <a href="checkResumeSended?status=0&startPage=<%=i%>"><%=i%></a>
                        <%

                            }
                        %>
                    </c:otherwise>
                </c:choose>
            </span>

        </div>
    </div>
</body>
</html>

