<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/1
  Time: 13:37
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
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#findEmployeeIn").click(function () {
                $.ajax({
                    url:"findEmployeeIn",
                    data:{},
                    type:"post",
                    success:function () {
                        location.reload();
                    }
                })
            })
            $("#findEmployeeOut").click(function () {
                $.ajax({
                    url:"findEmployeeOut",
                    data:{},
                    type:"post",
                    success:function () {
                        location.reload();
                    }
                })
            })
            $("#findEmployeeHoliday").click(function () {
                $.ajax({
                    url:"findEmployeeHoliday",
                    data:{},
                    type:"post",
                    success:function () {
                        location.reload();
                    }
                })
            })
        })
    </script>
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
        <div>
            <a href="#">部门/职位操作</a>
        </div>
        <div>
            <a href="goToEmployeeFinder">员工查询</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <div>
            <input type="button" value="查看在职员工" id="findEmployeeIn">
            <input type="button" value="查看离职员工" id="findEmployeeOut">
            <input type="button" value="查看请假员工" id="findEmployeeHoliday">
        </div>
        <div>
            <table>
                <tr>
                    <td>姓名</td>
                    <td>部门</td>
                    <td>职位</td>
                    <td>电话</td>
                    <td>邮箱</td>
                    <td>状态</td>
                </tr>
                <c:forEach items="${sessionScope.findEmployee}" var="i">
                    <tr>
                        <td>${i.emp_name}</td>
                        <td>${i.department.dep_name}</td>
                        <td>${i.position.pos_name}</td>
                        <td>${i.emp_phone}</td>
                        <td>${i.emp.email}</td>
                        <td>
                            <c:choose>
                                <c:when test="${i.emp_status}=0">
                                    ${"实习"}
                                </c:when>
                                <c:when test="${i.emp_status}=1">
                                    ${"正式员工"}
                                </c:when>
                                <c:when test="${i.emp_status}=2">
                                    ${"请假"}
                                </c:when>
                                <c:otherwise>
                                    ${"离职"}
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>

