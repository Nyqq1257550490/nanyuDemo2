<%--
  Created by IntelliJ IDEA.
  User: NCZ
  Date: 2018/7/25
  Time: 13:43
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
            var nameCheck = false;
            var passCheck = false;

            $("#uname").blur(function () {
                var name = $("#uname").val();
                var notnull = /.+/;
                var rule = /\w{6,12}/;
                if(!notnull.test(name)){
                    $("#s1").html("不能为空");
                    nameCheck = false;
                }else{
                    if(!rule.test(name)){
                        $("#s1").html("请输入6～12位");
                        nameCheck = false;
                    }else{
                        $("#s1").html("");
                        nameCheck = true;
                    }
                }
            });

            $("#upass").blur(function () {
                var pass = $("#upass").val();
                var notnull = /.+/;
                var rule = /\w{5,10}/;
                if(!notnull.test(pass)){
                    $("#s2").html("不能为空");
                    passCheck = false;
                }else{
                    if(!rule.test(pass)){
                        $("#s2").html("请输入5～10位");
                        passCheck = false;
                    }else{
                        $("#s2").html("");
                        passCheck = true;
                    }
                }
            });

            $("#submit").click(function () {
                if(nameCheck&&passCheck){
                    $("#submit").submit();
                }else{
                   return false;
                }
            })
        })
    </script>
    <style>
        form{
            position: relative;
            /*left: 370px;*/
            background-color: bisque;
            width: 350px;
            height: 160px;
            top: -20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div align="center">
        <h2>欢迎注册账号</h2>
        <form method="get" action="userRegiste">
            账号:<input type="text" name="u_name" id="uname"/><br/>
            <span style="color: red" id="s1"></span><br/>
            密码:<input type="password" name="u_pass" id="upass"/><br/>
            <span style="color: red" id="s2"></span><br/>
            <input type="submit"  id="submit" value="提交">
            <%--<input type="reset" value="重置">--%>
            <a href="goMainPage"><input type="button" value="返回"></a>
        </form>
        <p align="center">${sessionScope.error}</p>
    </div>
</body>
</html>

