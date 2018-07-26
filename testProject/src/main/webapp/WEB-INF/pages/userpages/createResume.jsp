<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  Time: 20:06
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
            $("#submit").click(function () {
                var ok = true;
                $("input").each(function () {
                    if($(this).val()==null){
                        ok = false;
                    }else{
                        alert($(this).val());
                    }
                })
            })
        })
    </script>
</head>
<body>
    <div style="height: 35px">
        <span>用户管理</span>
        <span style="float: right"><a href="goMainPage">返回</a></span>
        <span style="float: right">/</span>
        <span style="float: right"><a href="goToUserMenu">${sessionScope.user.u_name}</a></span>
    </div>
    <div style="height: 35px">
        <h1>建立你的新简历</h1>
        <form>
        <span>简历命名</span><br/>
        <input name="re_title"><br/>
        <table>
            <tr>
                <td colspan="2">姓名：</td>
                <td colspan="2"><input name="re_name" ></td>
                <td colspan="2">性别：</td>
                <td colspan="2"><input name="re_sex"></td>
                <td colspan="2">年龄：</td>
                <td colspan="2"><input name="re_age"></td>
            </tr>
            <tr>
                <td colspan="2">联系电话：</td>
                <td colspan="4"><input name="re_phone"></td>
                <td colspan="2">联系邮箱：</td>
                <td colspan="4"><input name="re_email"></td>
            </tr>
            <tr>
                <td colspan="2">家庭住址：</td>
                <td colspan="6"><input name="re_address"></td>
                <td colspan="2">毕业院校：</td>
                <td colspan="2"><input name="re_school"></td>
            </tr>
            <tr>
                <td colspan="2">个人技能：</td>
                <td colspan="10"><input name="re_skill"></td>
            </tr>
            <tr>
                <td colspan="2">个人介绍：</td>
                <td colspan="10"><input name="re_intro"></td>
            </tr>
            <tr>
                <td><input type="button" id="submit" value="submit">提交新简历</td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>

