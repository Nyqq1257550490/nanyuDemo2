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

//            年龄判定
            var agetest = true;
            $("#age").blur(function () {
                var age = $("#age").val();
                var rule = /^([1-9][0-9]*){1,3}$/;
               if(!rule.test(age)){
                    $("#age").attr("style","border-color:red");
                   agetest = false;
               }else{
                   $("#age").attr("style","border-color:green");
                   agetest = true;
               }
            });
            电话判断
            var phonetest = true;
            $("#phone").blur(function () {
                var phone = $("#phone").val();
                var rule = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if(!rule.test(phone)){
                    phonetest = false;
                    $("#phone").attr("style","border-color:red");
                }else{
                    $("#phone").attr("style","border-color:green");
                    phonetest = true;
                }
            });
//            邮箱判断
            var emailtest = true;
            $("#email").blur(function () {
                var email = $("#email").val();
                var rule = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if(!rule.test(email)){
                    emailtest = false;
                    $("#email").attr("style","border-color:red");
                }else{
                    $("#email").attr("style","border-color:green");
                    emailtest = true;
                }

            });
//            所有空格非空判断
            var ok = true;
            $("#submit").click(function () {
                $("input").each(function () {
                    if($("input").val()==null||$("input").val()==""){
                        ok = false;
                    }
                });
//                未填完不能提交
                if(ok&&agetest&&phonetest&&emailtest){
                    $("#submit").submit();
                }else{
                    $("#s1").html("请全部填写完整");
                    return false;
                }
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
        <form action="addNewResume">
        <span>简历命名</span><br/>
        <input name="re_title"><br/>
        <table>
            <tr>
                <td colspan="2">姓名：</td>
                <td colspan="2"><input name="re_name" id="name"></td>
                <td colspan="2">性别：</td>
                <td colspan="2">
                    <input type="radio" name="re_sex" value="男">男
                    <input type="radio" name="re_sex" value="女">女
                </td>
                <td colspan="2">年龄：</td>
                <td colspan="2">
                    <input name="re_age" id="age"><br/>
                    <span id="s2" style="color:red"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2">联系电话：</td>
                <td colspan="4">
                    <input name="re_phone" id="phone"><br/>
                    <span id="s3" style="color:red"></span>
                </td>
                <td colspan="2">联系邮箱：</td>
                <td colspan="4">
                    <input name="re_email" id="email"><br/>
                    <span id="s4" style="color:red"></span>
                </td>
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
                <td>
                    <input type="submit" id="submit" value="submit">提交新简历<br/>
                    <span id="s1" style="color:red"></span>
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>

