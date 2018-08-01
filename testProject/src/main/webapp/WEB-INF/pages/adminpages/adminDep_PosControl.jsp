<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/31
  Time: 13:49
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
            $("#addDep").click(function () {
                var a = $("#newDep").val();
                $.ajax({
                    url:"checkDepOnly",
                    data:{"dep_name":a},
                    type:"post",
                    success:function (obj) {
                        if(obj==true){
                            $("#addDep").submit();
                        }else{
                            $("#error1").attr("value","部门已存在");
                            return false;
                        }
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
        </div>
        <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
            <table>
            <c:forEach items="${sessionScope.allDepartment}" var="i">
                <tr>
                    <td>${i.dep_name}</td>
                    <td><a href="checkPosInDep?dep_id=${i.dep_id}"><input type="button" value="查看职位"></a></td>
                    <td><a href="#?dep_id=${i.dep_id}"><input type="button" value="删除部门"></a></td>
                </tr>
            </c:forEach>
            </table>
            <form action="addNewDep">
                <span>新部门名：</span>
                <input name="dep_name" id="newDep">
                <input type="submit" id="addDep" value="添加新部门">
                <span id="error1"></span>
            </form>
        </div>
    </body>
</html>

