<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/31
  Time: 14:51
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
            var notnull = /.+/;
            var incomeOk = false;
            $("#pos_income").blur(function () {
                var income = $("#pos_income").val();
                if(!notnull.test(income)){
                    $("#error2").html("请输入底薪");
                    incomeOk = false;
                }else{
                    if(!isNaN(income)){
                        incomeOk = true;
                    }else{
                        $("#error2").html("请输入正确数字");
                        incomeOk = false;
                    }
                }
            })

            var Pos_nameOk = false;
            $("#newPos").blur(function () {
                var Pos_name = $("#newPos").val();
                if(!notnull.test(Pos_name)){
                    $("#error1").html("请输入正确的职位名称");
                    Pos_nameOk = false;
                }else{
                    $.ajax({
                        url:"checkPosOnly",
                        data:{"pos_name":Pos_name},
                        type:"post",
                        success:function (obj) {
                            if(obj==true){
                                $("#error1").html("职位可以使用");
                                Pos_nameOk = true;
                            }else{
                                $("#error1").html("职位已存在");
                                Pos_nameOk = false;
                            }
                        }
                    })
                }
            })

            $("#addPos").click(function () {
                if(Pos_nameOk&&incomeOk){
                    $("#addPos").submit();
                }else{
                    return false;
                }
            })

            $("#deletePos").click(function () {
                var posId = $("this").sibling(":eq(0)").val()
                $.ajax({
                    url:"checkPosEmpty",
                    data:{"pos_id":posId},
                    type:"post",
                    success:function (obj) {
                        if(obj==true){
                            location.reload();
                        }else{
                            $("#s1").html("不能删除");
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
            <c:forEach items="${sessionScope.currentPos}" var="i">
                <tr>
                    <td>${i.pos_name}</td>
                    <td><a href="#?pos_id=${i.pos_id}"><input type="button" value="查看所属员工"></a></td>
                    <td>
                        <input type="button" value="删除职位" id="deletePos">
                        <input type="hidden" value="${i.pos_id}" name="pos_id">
                        <span id="s1"></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="addNewPos">
            <span>新职位名：</span>
            <input name="pos_name" id="newPos">
            <span id="error1"></span>
            <span>底薪：</span>
            <input type="number" name="pos_income" id="pos_income">
            <span id="error2"></span>
            <input type="submit" id="addPos" value="添加新职位">
        </form>
    </div>
</body>
</html>

