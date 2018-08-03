<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/8/2
  Time: 14:29
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
    <script src="js/jquery.js"/>
    <script>

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
        <h3>建立新的培训</h3>
        <form action="#">
            <table>
                <tr>
                    <td>培训主题：</td>
                    <td><input name="t_title"></td>
                </tr>
                <tr>
                    <td>培训内容</td>
                    <td><input type="text" name="t_content"></td>
                </tr>
                <tr>
                    <td>开始时间</td>
                    <td><input type="date" name="t_starttime"></td>
                    <td>结束时间</td>
                    <td><input type="date" name="t_endtime"></td>
                </tr>
                <tr>
                    <td>培训地点</td>
                    <td><input name="t_address"></td>
                </tr>
                <tr>
                    <td>选择对象</td>
                    <td>
                        <select name="selectTarget">
                            <option value="0">实习生</option>
                            <c:forEach items="${sessionScope.allDep}" var="i">
                                <option value="${i.dep_id}">${i.dep_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>

