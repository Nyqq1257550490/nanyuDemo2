<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/30
  Time: 8:44
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
            <a href="#">招聘信息发布</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <span>新建招聘信息</span>
        <form action="#">
            <table>
                <tr>
                    <td>招聘职业：</td>
                    <td><input name="rec_jobname"></td>
                </tr>
                <tr>
                    <td>招聘地址：</td>
                    <td><input name="rec_address"></td>
                    <td>公司名称：</td>
                    <td><input name="rec_company"></td>
                </tr>
                <tr>
                    <td>招聘收入：</td>
                    <td><input type="number" name="rec_income"></td>
                </tr>
                <tr>
                    <td>职业介绍：</td>
                    <td><input type="text" name="rec_intro"></td>
                </tr>
                <tr>
                    <td>福利介绍：</td>
                    <td><input type="text" name="rec_welfare"></td>
                </tr>
            </table>
            <span><input type="submit" name="create">创建招聘信息</span>
        </form>
    </div>
</body>
</html>

