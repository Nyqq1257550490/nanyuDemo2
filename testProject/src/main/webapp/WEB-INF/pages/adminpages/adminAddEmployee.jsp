<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/30
  Time: 15:29
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
            $("#department").blur(function () {
                var a = $("#department").val();
                $.ajax({
                    url : "getPosition",
                    date:{"dep_id":a},
                    type:"post",
                    success:function (obj) {
                        $(obj).each(function (index) {
                            $("#position").append(
                                "<option value='obj.pos_id'>"+obj.pos_name+"</option>"
                            )
                        })
                    }
                });
            })

            $("#create").click(function () {
                $.ajax({
                    url:"createCode",
                    date:{},
                    type:"post",
                    success:function (str) {
                        $("#emp_code").attr("value",str);
                        $("#emp_pass").attr("value",str);
                    }
                })
            })

            $("#quickIn").click(function () {
               if(${sessionScope.fromNum}=1){
                   return false;
               }else{${sessionScope.inRollRe_Rec}
                   $("#ename").attr("value",${sessionScope.inRollRe_Rec.resume.re_name})
                   $("#esex").attr("value",${sessionScope.inRollRe_Rec.resume.re_sex})
                   $("#eage").attr("value",${sessionScope.inRollRe_Rec.resume.re_age})
                   $("#ephone").attr("value",${sessionScope.inRollRe_Rec.resume.re_phone})
                   $("#eemail").attr("value",${sessionScope.inRollRe_Rec.resume.re_email})
               }
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
    </div>
    <div style="width: 70%;height:900px;border-width: 2px;margin-left: 30%">
        <form action="saveNewEmployee">
            <table>
                <tr>
                    <td>员工姓名：</td>
                    <td><input id="ename" name="emp_name"></td>
                    <td>员工性别：</td>
                    <td><input id="esex" name="emp_sex"></td>
                    <td>员工年龄</td>
                    <td><input id="eage" name="emp_age"></td>
                </tr>
                <tr>
                    <td>员工电话：</td>
                    <td><input id="ephone" name="emp_phone"></td>
                    <td>员工邮箱：</td>
                    <td><input id="eemail" name="emp_email"></td>
                </tr>
                <tr>
                    <td>请分配职位：</td>
                    <td>
                        <select id="department">
                            <option>请选择部门</option>
                            <c:forEach items="${sessionScope.departments}" var="i">
                                <option value="${i.dep_id}" id="depart">${i.dep_name}</option>
                            </c:forEach>
                        </select>
                        <select id="position"></select>
                    </td>
                </tr>
                <tr>
                    <td>员工代号</td>
                    <td><input id="emp_code"></td>
                    <td>员工密码</td>
                    <td><input id="emp_pass"></td>
                    <td><input type="button" id="create" value="生成"></td>
                </tr>
            </table>
            <input type="button" value="导入简历" id="quickIn">
            <input type="submit" value="添加">
        </form>

    </div>

</body>
</html>

