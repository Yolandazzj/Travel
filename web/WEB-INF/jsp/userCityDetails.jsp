<%--
  Created by IntelliJ IDEA.
  User: 34703
  Date: 2019/4/26
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
    <base href="<%=request.getContextPath()%>/">
    <meta charset="UTF-8">
    <title>途牛旅行-景点</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
</head>
<body>

<!--滚动屏-->
<div class="scroll-head"></div>

<!--顶部-->
<div class="top-wrapper">
    <div class="top-info">
        <div class="top-left">
            <div data-toggle="arrowdown" id="arrow1" class="user-name">
                <a href="#">登录</a>
            </div>
            <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                <i class="fa fa-gray"></i>
                <a href="#">注册</a>
            </div>
        </div>

        <!--top-right-->
        <div class="top-right">
            <div data-toggle="arrowdown" id="arrow3" class="user-name">
                <a href="#">我的账户</a>

            </div>
            <div data-toggle="arrowdown" id="arrow4" class="user-name">
                <i class="fa fa-shopping-cart fa-orange"></i>
                <a href="#">我的订单</a>

            </div>
        </div>
    </div>

</div>

<!--top-main-->
<div class="top-main">
    <img src="resources/image/logo.jpg" alt="logo"/>
    <div class="search-wrapper">
        <div class="search-box">
            <ul data-toggle="arrowdown" id="arrow8" class="search-toggle" >
                <li class="drop-down"><a href="#">所有产品</a><span class="down-icon"></span>
                    <ul class="search-toggle-box">
                        <li><a href="#">跟团游</a></li>
                        <li><a href="#">景点</a></li>
                        <li><a href="#">攻略</a></li>
                        <li><a href="#">酒店</a></li>
                    </ul>
                </li>
            </ul>
            <input class="search-in" type="text" placeholder="请输入关键字">
            <input type="button" class="search-but" value="搜索">

        </div>
    </div>

</div>

<div class="right-con" style="height: 100px;">
    <div class="nav" style="border-bottom: 2px solid rgba(0,128,0,0.5);width: 730px;">

        <a href="#">旅行社</a>
        <a href="#">组团游</a>
        <a href="user/tours" >跟团游</a>
        <a href="#" >攻略</a>
        <a href="#" >美食</a>
        <a href="#">酒店</a>
        <a href="user/scene" >景点</a>
        <a href="#" >推荐路线</a>
        <a href="#" >留言板</a>

    </div>
</div>

<br><br><br><br><br><br>

<!-- 详情 -->
<div class="xiaomi6 fl">
    ${cityName}
</div>
<br><br><br><br>

<div class="jieshao mt20 w">
    <div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
    <div class="right fr" style="height:562px;padding-left: 20px; ">
        <br>
        <c:forEach items="${proName}" var="p">
        <div class="jianjie mr40 ml20 mt10">所在省份：<div class="jiage ml20 mt10"><br>${p[1]}</div></div>
        </c:forEach>
        <br><br><br><br><br><br>
        <c:forEach items="${cityDetail}" var="ci">
        <div class="jianjie mr40 ml20 mt10">点赞数:&nbsp;&nbsp;<span style="color: black;" id="thumbNumber2">${ci[2]}</span></div>
        <br><br><br><br><br><br>
        <div class="xiadan ml20 mt20" style="margin-left: 230px;">
            <form action="javascript:thumb_city(${ci[0]})" method="post">
                <input  type="hidden" name="cityId" value="${ci[0]}">
                <button class="jrgwc"  type="submit">我要点赞</button>
            </form>
        </div>
        </c:forEach>
    </div>
    <div class="clear"></div>
</div>

<!--footer-->
<div class="footer">
    <div class="footer-right">
        <div class="footer-nav" style="border-bottom: 1px solid rgba(0,125,0,0.5);">

        </div>
        <div class="about-tao">
            <a href="#">关于途牛</a>
            <a href="#">联系我们</a>
            <a href="#">法律声明</a>
            <span class="gary-text">&copy; 2019tuniu.com 版权所有</span>
        </div>
    </div>
</div>

<!--回到顶部和底部-->

<div class="backtoTop" id="backToTop1">
    <div id="backToTop-up" class="up-back"><i class="fa fa-angle-up"></i></div>
    <div id="backToTop-down" class="down-back"><i class="fa fa-angle-down"></i></div>
</div>


<script src="./resources/js/jquery_1.9.js"></script>
<script src="./resources/js/main.js"></script>
<script src="./resources/js/show-image.js"></script>

<script>
    function thumb_city(cityId) {
        $.ajax({
            url: 'user/thumb_city',
            type: "POST",
            data: {"cityId": cityId},
            success: function (data) {
                var onumber = parseInt($("#thumbNumber2").text());
                $("#thumbNumber2").html(onumber + 1);
            },
            error: function () {
                alert("Ajax请求失败");
            }
        });
    }
</script>
</body>
</html>
