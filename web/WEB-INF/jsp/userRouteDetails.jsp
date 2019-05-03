<%--
  Created by IntelliJ IDEA.
  User: 张紫捷
  Date: 2019/4/12
  Time: 17:26
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
    <title>途牛旅行-跟团游</title>
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
        <a href="#" >跟团游</a>
        <a href="#" >攻略</a>
        <a href="#" >美食</a>
        <a href="#">酒店</a>
        <a href="#" >景点</a>
        <a href="#" >推荐路线</a>
        <a href="#" >留言板</a>


    </div>


</div>
<br><br><br><br><br><br>
<!-- xiangqing -->

    <div class="xiaomi6 fl">
        ${routeName}
    </div>
<br><br><br><br>
    <div class="jieshao mt20 w">
        <div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
        <div class="right fr" style="height:562px;padding-left: 20px; ">
            <br>
            <div class="jianjie mr40 ml20 mt10">促销价：<div class="jiage ml20 mt10"><br>${routeDetails.routePrice}元</div></div>
            <br><br>
            <div class="jianjie mr40 ml20 mt10">
                <label >出游日期:<span style="color: black;"><fmt:formatDate value="${routeDetails.routeStartDay}" pattern="yyyy-MM-dd HH:mm:ss" /></span></label>
            </div>

            <div class="jianjie mr40 ml20 mt10">
                <div class="room-number">
                    <p class="clearfix">
                        <span class="desc">出游人数:&nbsp;&nbsp;</span>
                        <span class="bd-box subtraction min" style="height: 32px;">-</span>
                        <input class="bd-box number-box" value="1" readonly="readonly"/>
                        <span class="bd-box addition add" style="height: 32px;">+</span>
                    </p>
                </div>

            </div>
            <br><br><br><br>
            <div class="jianjie mr40 ml20 mt10">出行天数:&nbsp;&nbsp;<span style="color: black;">${routeDetails.routeDay}天</span></div>
            <br><br><br>
            <div class="jianjie mr40 ml20 mt10">行程概要：
                <br><br>
            <div class="xqxq mt20 ml20">
                <div class="top1 mt10" style="color: black;">
                    ${routeDetails.routeContent}
                </div>
            </div>
            </div>
            <br><br><br>
            <div class="xiadan ml20 mt20" style="margin-left: 230px;">
                <form action="user/toOrderRoute" method="post">
                <input  type="hidden" name="routeId" value="${routeDetails.routeId}">
                <button class="jrgwc"  type="submit">立即预定</button>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>



<img src="./resources/image/user1.png" id="image1">
<div class="detail" style="width: 1000px;">
    <div class="title">
        <img src="./resources/image/copy.png">
    </div>
    <br>
    <img src="./resources/image/tupian.png"  style="margin-left: 100px;">
    <br><br>
    <c:forEach items="${agencyDetails}" var="a">
    <span class="spana">旅行社：${a[1]}</span>
    <br><br>
    <span class="spana">联系方式：${a[2]}</span>
    <br><br>
    <span class="spana">旅行社好评度：已经有${a[3]}人点赞过这个旅行社啦！</span>
    <br><br>
    <span class="spana">旅行社介绍：${a[4]}</span>
    </c:forEach>
    <br><br>

 </div>
<img src="./resources/image/user2.png" id="user2" >
<div class="detail2">

    <img src="./resources/image/copy2.png"   style="margin-left: 100px;">
    <br><br>
    <img src="./resources/image/tupian.png"  style="margin-left: 100px;">
    <br><br>
    <span class="spana" style="color:black;">优惠价格：${routeDetails.routePrice}元！抓紧预定，此线路保证你${routeDetails.routeDay}天的欢乐时光！</span>
    <br><br>
    <span class="spana" style="color:black;">线路介绍：${routeDetails.routeContent}</span>
</div>

<img src="./resources/image/user3.png" id="image2">
<div class="detail" style="width: 1000px;">
    <br>

    <div class="control-group">
        <div class="controls" style="margin-left: 100px;">

            <br><br><br><br><br><br><br><br>
            <table id="commentTable">
                <c:forEach items="${routeCommentList}" var="r">
                    <tr>
                        <td>${r[6]}&nbsp;&nbsp;<span style="font-size: 12px;">
                                                <fmt:formatDate  value="${r[5]}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </span>:<br><br><br>${r[3]}</td>

                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>



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
<script src="./resources/js/img-show.js"></script>

<script>
    $(function(){
        /*单击加号按钮增加数量*/
        $(".add").click(function(){
            var add = $(this).siblings(".number-box");
            add.val(parseInt(add.val())+1)
        });

        /*单击减号按钮减少房间*/
        $(".min").click(function(){
            var min = $(this).siblings(".number-box");
            min.val(parseInt(min.val())-1)
            if(parseInt(min.val())<1){
                min.val(1);
            }

        });
});
</script>

</body>
</html>