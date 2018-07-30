<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  Time: 16:38
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
    int totalPages= (int) session.getAttribute("resumeTotalPage");
%>
<div style="height: 35px">
    <span>用户管理</span>
    <span style="float: right"><a href="goMainPage">返回</a></span>
    <span style="float: right">/</span>
    <span style="float: right"><a href="goToUserMenu">${sessionScope.user.u_name}</a></span>
</div>
<div style="position:absolute;width: 30%;height:900px;border-width: 2px">
    <div>
        <a href="#">个人资料</a>
    </div>
    <div>
        <a href="goToCreateResume">创建新简历</a>
    </div>
    <div>
        <a href="#">查看投递反馈</a>
    </div>
</div>
<div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
    <c:forEach items="${sessionScope.feedBackRE_REC}" var="i">
        <table>
            <tr>
                <td>简历名：</td>
                <td>${i.resume.re_title}</td>
                <td>求职名：</td>
                <td>${i.recruitment.rec_jobname}</td>
                <td>公司名称：</td>
                <td>${i.recruitment.rec_company}</td>
            </tr>
            <tr>
                <td>
                    恭喜你，通过海选，请在规定时间，来参加面试
                </td>
            </tr>
            <tr>
                <td>面试时间：</td>
                <td>${i.re_rec_facetime}</td>
                <td><a href="userAnswerFace?changeStatus=3"> <input type="button">确认面试</a></td>
                <td><a href="userAnswerFace?changeStatus=4"> <input type="button">回绝面试</a></td>
            </tr>

        </table>
    </c:forEach>
    <%--<%--%>
        <%--for (int i = 1; i <=totalPages; i++) {--%>
    <%--%>--%>
    <%--<a href="goToUserMenu?startPage=<%=i%>"><%=i%></a>--%>
    <%--<%--%>

        <%--}--%>
    <%--%><br/>--%>
</div>
</body>
</html>

