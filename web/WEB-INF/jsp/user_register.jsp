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
    <title>用户注册</title>
    <link rel="stylesheet" href="resources/css/reset.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <%--    <link rel="stylesheet" href="resources/css/style.css"/>--%>
    <link rel="stylesheet" href="resources/css/reg-style.css"/>
<%--    <script src="resources/js/jquery.vide.min.js"></script>--%>
    <script src="resources/js/jquery_1.9.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="resources/js/show-image.js"></script>
    <link rel="stylesheet" href="resources/css/font1-awesome.min.css"/>
    <script type="text/javascript" src="resources/js/jquery-2.1.4.min.js"></script>


</head>
<body>

<script type="text/javascript">
    function validate() {
        var pwd1 = document.getElementById("upassword").value;
        var pwd2 = document.getElementById("upassword2").value;

        if (pwd1 == pwd2) {
            document.getElementById("tishi").innerHTML = "<span>两次密码相同</span>";

        } else {
            document.getElementById("tishi").innerHTML = "<span>两次密码不相同</span>";
        }
    }
</script>
<div data-vide-bg="videos/typing">
    <div class="w3-agile-signup-top">
        <h1>途牛旅行</h1>
        <div class="main">
            <div class="login-top left">
                <div class="social_icons">
<%--                    <div class="w3-signup-head-top">--%>
<%--                        <h3>Signedup With</h3>--%>
<%--                    </div>--%>
                    <!-- Facebook -->
<%--                    <div class="slide-social w3l">--%>
<%--                        <a href="#">--%>

<%--                            <div class="facebook icon"><i class="facebook"></i></div>--%>
<%--                            <div class="facebook slide">--%>
<%--                                <p>Facebook</p>--%>
<%--                            </div>--%>
<%--                            <div class="clear"></div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
                    <!-- Twitter -->
<%--                    <div class="slide-social w3l">--%>
<%--                        <a href="#">--%>
<%--                            <div class="twitter icon"><i class="twitter"></i></div>--%>
<%--                            <div class="twitter slide">--%>
<%--                                <p>Twitter</p>--%>
<%--                            </div>--%>
<%--                            <div class="clear"></div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                    <div class="w3-signup-head2-top">--%>
<%--                        <h3>OR</h3>--%>
<%--                    </div>--%>

                </div>
                <form action="user/register" method="post">
                    <span style="color: red;" id="msg"></span>
                    <input type="text" name="uid" id="uid" class="name" placeholder="用户账号" required="">
                    <input style="margin: 0px 20px 20px 20px;padding-bottom: 12px;" type="radio" name="ugender"
                           checked="checked" value="女">女
                    <input style="margin: 0px 10px 20px 28px;padding: 12px 30px 12px 40px; " type="radio"
                           name="ugender" value="男">男
                    <input type="text" name="ucity" class="name" placeholder="城市" required="">
                    <input type="text" id = "ucontact" name="ucontact" class="name" placeholder="联系电话" required=""><span id="sj"></span>
                    <input type="text" name="uemail" id="uemail" class="email" placeholder="邮箱" required=""><span id="yx"></span>
                    <input type="password" id="upassword" name="upassword" class="password" placeholder="密码"
                           required="">
                    <input type="password" id="upassword2" class="password" placeholder="确认密码" required=""
                           onkeyup="validate()">
                    <br/>
                    <span id="tishi" style="color: red;"></span>
                    <br/>
                    <input type="submit" value="SIGN UP" id="submit">
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
<script  type="text/javascript">
    function checkEmail(str) {
        var re = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (re.test(str)) {
            $("#yx").html("ok");
            $("#yx").css("color","green");
        }
        else {
            $("#yx").html("<br/>邮箱格式错误<br/>");
            $("#yx").css("color","red");
            $("#sub").prop("disabled",true);
        }
    }
</script>
<script  type="text/javascript">
    $("#uemail").blur(function(){
        var str = $(this).val();
        checkEmail(str);
    })
</script>
<script type="text/javascript">
    $("#uid").blur(function()
    {
        var ordername = $(this).val();
        if(ordername ===""){
            $("#on").html("<br/>姓名不能为空！");
            $("#on").css("color","red");
            $("#sub").prop("disabled",true);
        }else{
            $("#sub").prop("disabled",false);
            $("#on").html("");
        }
    })
</script>
<script  type="text/javascript">
    function checkMobile(str) {
        // var  re = /^1\d{10}$/ //验证是不是11位数字
        var re = /^[1][3,4,5,7,8,9][0-9]{9}$/;
        if (re.test(str)) {
            $("#sj").html("ok");
            $("#sj").css("color","green");
        }
        else {
            $("#sj").html("<br/>手机号码格式错误<br/>");
            $("#sj").css("color","red");
            $("#sub").prop("disabled",true);
        }
    }
</script>
<script  type="text/javascript">
    $("#ucontact").blur(function(){
        var str = $(this).val();
        checkMobile(str);
    })
</script>
<script type="text/javascript">
    $(document).ready(function(){

        $("#uid").blur(function(){
            var uid = {uid:$("#uid").val()};
            $.ajax(
                {url:"user/checkName",
                    data:uid,
                    async:true,
                    type:"POST",
                    dataType:"html",
                    success:function(msg){

                        $("#msg").html(msg);
                        if(msg!=""){
                            $("#submit").prop("disabled",true);
                        }else{
                            $("#submit").prop("disabled",false);
                        }

                       }

                });
        });
    })


</script>
</body>
</html>
