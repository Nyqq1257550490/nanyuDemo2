<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/26
  TimeTool: 22:49
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
    int totalPages= (int) session.getAttribute("recruitmentTotalPage");
%>
    <div style="height: 35px">
        <span>魔都XXXXX公司主页</span>
        <span style="float: right"><a href="goToPage">注册</a></span>
        <span style="float: right">/</span>
        <span style="float: right">
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <form action="goToUserMenu" method="get">
                            <input type="submit" name="viewUserMenu" value="${sessionScope.user.u_name}">
                            <input type="hidden" name="startPage" value="0">
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
        招聘信息
        <c:forEach items="${sessionScope.recruitmentDetail}" var="i">
            <table>
                <tr>
                    <td>${i.rec_jobname}</td>
                    <td>${i.rec_income}</td>
                </tr>
                <tr>
                    <td>${i.rec_company}</td>
                    <td>${i.rec_address}</td>
                </tr>
                <tr>
                    <td>${i.rec_intro}</td>
                </tr>
                <tr>
                    <td>${i.rec_welfare}</td>
                </tr>
                <tr>
                    <a href="sendRecruitment?recruitmentId=${i.rec_id}&startPage=0"><input type="button">投递简历</a>
                </tr>
            </table>
        </c:forEach>
        <%
            for (int i = 1; i <=totalPages; i++) {
        %>
        <a href="goToRecruitmentPage?startPage=<%=i%>"><%=i%></a>
        <%
            }
        %>
    </div>
</body>
</html>

