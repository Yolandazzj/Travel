<%--
  Created by IntelliJ IDEA.
  User: 34703
  Date: 2019/4/30
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
    <base href="<%=request.getContextPath()%>/">
    <meta charset="UTF-8">
    <title>本店美食</title>
    <link rel="stylesheet" href="resources/css/reset.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css"/>
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
        <a href="/user/food" >美食</a>
        <a href="#">酒店</a>
        <a href="user/scene" >景点</a>
        <a href="#" >推荐路线</a>
        <a href="/user/message" >留言板</a>

    </div>
</div>
<br><br><br><br><br><br>
<!--美食列表-->
<div class="control-group" style="border: 10px solid rgba(0,128,0,0.5); width: 1000px;height: 1000px;margin-bottom:0px;margin: 0 auto;">

    <table id="commentTable">
        <c:forEach items="${storeFoodList}" var="sf">
            <tr>
                <td>${sf[0]}&nbsp;&nbsp;<a href="javascript:thumb_food(${sf[0]})" ><span style="margin-left: 850px;">👍<span id="${sf[0]}">${sf[2]}</span></span></a><br><br><br>
                    <a href="user/foodDetails?fid=${sf[0]}&fname=${sf[1]}">${sf[1]}</a></td>

            </tr>
        </c:forEach>
    </table>
    <br><br><br>

    <br><br>

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
    function thumb_food(fid) {
        $.ajax({
            url: 'user/thumb_food',
            type: "POST",
            data: {"fid": fid},
            success: function (data) {
                var onumber = parseInt($("#"+fid).text());
                $("#"+fid).html(onumber + 1);
            },
            error: function () {
                alert("Ajax请求失败");
            }
        });
    }
</script>
</body>
</html>
