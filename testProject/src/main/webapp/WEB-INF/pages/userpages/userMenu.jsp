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
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <table>
            <tr>
                <td colspan="2">姓名：</td>
                <td colspan="2">${sessionScope.resumeDetail.get(0).re_name}</td>
                <td colspan="2">性别：</td>
                <td colspan="2">
                    ${sessionScope.resumeDetail.get(0).re_sex}
                </td>
                <td colspan="2">年龄：</td>
                <td colspan="2">
                    ${sessionScope.resumeDetail.get(0).re_age}
                </td>
            </tr>
            <tr>
                <td colspan="2">联系电话：</td>
                <td colspan="4">
                    ${sessionScope.resumeDetail.get(0).re_phone}
                </td>
                <td colspan="2">联系邮箱：</td>
                <td colspan="4">
                    ${sessionScope.resumeDetail.get(0).re_email}
                </td>
            </tr>
            <tr>
                <td colspan="2">家庭住址：</td>
                <td colspan="6">${sessionScope.resumeDetail.get(0).re_address}</td>
                <td colspan="2">毕业院校：</td>
                <td colspan="2">${sessionScope.resumeDetail.get(0).re_school}</td>
            </tr>
            <tr>
                <td colspan="2">个人技能：</td>
                <td colspan="10">${sessionScope.resumeDetail.get(0).re_skill}</td>
            </tr>
            <tr>
                <td colspan="2">个人介绍：</td>
                <td colspan="10">${sessionScope.resumeDetail.get(0).re_intro}</td>
            </tr>
            <tr>
                <td colspan="6">
                    <a href="goToChangeResume"><input type="button" value="修改简历"></a>
                </td>
                <td colspan="6">
                    <a href="#"><input type="button" value="删除简历"></a>
                </td>
            </tr>
        </table>
        <%
            for (int i = 1; i <=totalPages; i++) {
        %>
        <a href="goToUserMenu?startPage=<%=i%>"><%=i%></a>
        <%

            }
        %><br/>
    </div>
</body>
</html>

