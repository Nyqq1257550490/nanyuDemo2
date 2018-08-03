<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/2
  Time: 13:09
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
            $("#inTrain").click(function () {
                var a = 0;
                $.ajax({
                    url:"findStateTrain",
                    data:{"state":a},
                    type:"post",
                    success:function (obj) {
                        location.reload();
                    }
                })
            })
            $("#outTrain").click(function () {
                var a = 1;
                $.ajax({
                    url:"findStateTrain",
                    data:{"state":a},
                    type:"post",
                    success:function (obj) {
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
        <div>
            <a href="#">培训设置</a>
        </div>
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <div>
            <a href="#"><input type="button" value="创建新培训"></a>
            <input type="button" value="查看未发布培训" id="inTrain">
            <input type="button" value="查看已发布培训" id="outTrain">
        </div>
        <div>
            <table>
                <tr>
                    <td>培训id</td>
                    <td>培训名称</td>
                    <td>培训开始时间</td>
                    <td>培训结束时间</td>
                    <td>培训地址</td>
                    <td>培训状态</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${sessionScope.allTrain}" var="i">
                    <tr>
                        <td>${i.t_id}</td>
                        <td>${i.t_title}</td>
                        <td>${i.t_starttime}</td>
                        <td>${i.t_endtime}</td>
                        <td>${i.t_address}</td>
                        <td>
                            <c:choose>
                                <c:when test="${i.t_state}=0">
                                    ${"未发布"}
                                </c:when>
                                <c:otherwise>
                                    ${"已发布"}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>EMP_DEP_ID
                                <c:when test="${i.t_state}=0">
                                    <a href="adminControlTrainStatus?t_id=${i.t_id}&t_state=0"><input type="button" value="发布"></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="adminControlTrainStatus?t_id=${i.t_id}&t_state=1"><input type="button" value="撤销"></a>
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

