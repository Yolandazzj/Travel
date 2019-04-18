<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/4/17
  Time: 14:31
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
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/reg-style.css"/>

    <link rel="stylesheet" href="resources/css/font1-awesome.min.css"/>
    <link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
    <script type="text/javascript" src="resources/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<div data-vide-bg="videos/typing">
    <div class="w3-agile-signup-top">
        <h1>途牛旅行</h1>
        <div class="main">
            <div class="login-top left">
                <div class="social_icons">
                    <div class="w3-signup-head-top">
                        <h3>Signedup With</h3>
                    </div>
                    <!-- Facebook -->
                    <div class="slide-social w3l">
                        <a href="#">

                            <div class="facebook icon"> <i class="facebook"></i> </div>
                            <div class="facebook slide">
                                <p>Facebook</p>
                            </div>
                            <div class="clear"></div>
                        </a>
                    </div>
                    <!-- Twitter -->
                    <div class="slide-social w3l">
                        <a href="#">
                            <div class="twitter icon"> <i class="twitter"></i></div>
                            <div class="twitter slide">
                                <p>Twitter</p>
                            </div>
                            <div class="clear"></div>
                        </a>
                    </div>
                    <div class="w3-signup-head2-top">
                        <h3>OR</h3>
                    </div>

                </div>
                <form action="#" method="post">
                    <input type="text" name="name" class="name" placeholder="用户账号" required="">
                    <input style="margin: 0px 20px 20px 20px;padding-bottom: 12px;" type="radio" name="gender" checked="checked">女
                    <input style="margin: 0px 10px 20px 28px;padding: 12px 30px 12px 40px; " type="radio" name="gender" >男
                    <input type="text" name="city" class="name" placeholder="城市" required="">
                    <input type="text" name="phone" class="name" placeholder="联系电话" required="">
                    <input type="text" name="email" class="email" placeholder="邮箱" required="">
                    <input type="password" name="password" class="password" placeholder="密码" required="">
                    <input type="password" name="password" class="password" placeholder="确认密码" required="">

                    <input type="submit" value="SIGN UP">
                </form>
                <div class="w3-bottom-text">
                    <h3><a href="#">Already Have an account<span>?</span></a></h3>
                    <h4><a href="login">Login</a></h4>
                </div>
                <div class="clear"></div>
            </div>


        </div>
        <div class="clear"></div>
        <div class="copy-right w3l-agile">
            <p> © 2019 tuniu.com . All Rights Reserved | Design by QDU </p>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script src="../../resources/js/jquery.vide.min.js"></script>
</body>
</html>
