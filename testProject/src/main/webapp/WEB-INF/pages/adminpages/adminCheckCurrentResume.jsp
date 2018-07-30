<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/28
  Time: 21:53
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
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <table>
            <tr>
                <td colspan="2">姓名：</td>
                <td colspan="2">${sessionScope.checkResume.re_name}</td>
                <td colspan="2">性别：</td>
                <td colspan="2">
                    ${sessionScope.checkResume.re_sex}
                </td>
                <td colspan="2">年龄：</td>
                <td colspan="2">
                    ${sessionScope.checkResume.re_age}
                </td>
            </tr>
            <tr>
                <td colspan="2">联系电话：</td>
                <td colspan="4">
                    ${sessionScope.checkResume.re_phone}
                </td>
                <td colspan="2">联系邮箱：</td>
                <td colspan="4">
                    ${sessionScope.checkResume.re_email}
                </td>
            </tr>
            <tr>
                <td colspan="2">家庭住址：</td>
                <td colspan="6">${sessionScope.checkResume.re_address}</td>
                <td colspan="2">毕业院校：</td>
                <td colspan="2">${sessionScope.checkResume.re_school}</td>
            </tr>
            <tr>
                <td colspan="2">个人技能：</td>
                <td colspan="10">${sessionScope.checkResume.re_skill}</td>
            </tr>
            <tr>
                <td colspan="2">个人介绍：</td>
                <td colspan="10">${sessionScope.checkResume.re_intro}</td>
            </tr>
        </table>
        <form action="#">
            面试时间：<input type="datetime-local" name="re_rec_facetime">
            <input type="submit">发送面试消息</a>
            <input type="hidden" name="re_rec_id" value="${sessionScope.re_recDetail.re_rec_id}">
        </form>
        <a href="refuseRE_REC?re_rec_id=${sessionScope.re_recDetail.re_rec_id}"><input type="button">拒绝</a>
    </div>
</body>
</html>

