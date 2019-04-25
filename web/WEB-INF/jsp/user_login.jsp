<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/4/16
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="resources/css/reset.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <%--    <link rel="stylesheet" href="resources/css/style.css"/>--%>
    <link rel="stylesheet" href="resources/css/log-style.css"/>

    <link rel="stylesheet" href="resources/css/font1-awesome.min.css"/>


    <link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
</head>
<body>
<%--    <jsp:include page="header.jsp"/>--%>


<!-- main -->
<div class="w3layouts-main">
    <div class="bg-layer">
        <h1>途牛旅行</h1>
        <div class="header-main">
            <div class="main-icon">
                <span class="fa fa-eercast"></span>
            </div>
            <div class="header-left-bottom">
                <form action="user/login" method="post" id="loginValidate">
                    <div class="icon1">
                        <span class="fa fa-user"></span>
                        <input type="text" placeholder="账户名" required="true" value="uid"/>
                    </div>
                    <div class="icon1">
                        <span class="fa fa-lock"></span>
                        <input type="password" placeholder="密码" required="true" value="upassword"/>
                    </div>
                    <div class="login-check">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i> Keep me
                            logged in</label>
                    </div>
                    <div class="bottom">
                        <button id="submitBtn" class="btn">登 录</button>
                    </div>
                    <div class="links">
                        <p><a href="#">Forgot Password?</a></p>
                        <p class="right"><a href="register">New User? Register</a></p>
                        <div class="clear"></div>
                    </div>
                </form>
            </div>
            <div class="social">
                <ul>
                    <li>or login using :</li>
                    <li><a href="#" class="facebook"><span class="fa fa-facebook"></span></a></li>
                    <li><a href="#" class="twitter"><span class="fa fa-twitter"></span></a></li>
                    <li><a href="#" class="google"><span class="fa fa-google-plus"></span></a></li>
                </ul>
            </div>
        </div>

        <!-- copyright -->
        <div class="copyright">
            <p><a href="index">© 2019 tuniu.com .</a> All rights reserved</p>
        </div>
        <!-- //copyright -->
    </div>
    <script>
        $(document).ready(function () {
            $("#submitBtn").click(function () {
                $.ajax({
                    url: 'login',
                    type: 'POST',
                    data: $("#loginValidate").serialize(), //将表单的数据编码成一个字符串提交给服务器
                    success: function (msg) {
                        $("#msg").html(msg);
                    },
                    error: function (req, status, error) {
                        alert("Ajax请求失败!" + error);
                    }
                });
            });
        });
    </script>
</div>


<%--    <jsp:include page="footer.jsp"/>--%>
<script src="resources/js/jquery_1.9.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/show-image.js"></script>
</body>
</html>
