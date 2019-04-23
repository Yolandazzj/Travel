<%--
  Created by IntelliJ IDEA.
  User: 张紫捷
  Date: 2019/4/12
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<form action="post" method="">
    <div class="xiangqing">
        <h3>${routeName}</h3>
    </div>

    <div class="jieshao mt20 w">
        <div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
        <div class="right fr">
            <div class="h3 ml20 mt20">小米6</div>
            <div class="jianjie mr40 ml20 mt10">变焦双摄，4 轴防抖 / 骁龙835 旗舰处理器，6GB 大内存，最大可选128GB 闪存 / 5.15" 护眼屏 / 四曲面玻璃/陶瓷机身</div>
            <div class="jiage ml20 mt10">2499.00元</div>
            <div class="ft20 ml20 mt20">选择版本</div>
            <div class="xzbb ml20 mt10">
                <div class="banben fl">
                    <a>
                        <span>全网通版 6GB+64GB </span>
                        <span>2499元</span>
                    </a>
                </div>
                <div class="banben fr">
                    <a>
                        <span>全网通版 6GB+128GB</span>
                        <span>2899元</span>
                    </a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="ft20 ml20 mt20">选择颜色</div>
            <div class="xzbb ml20 mt10">
                <div class="banben">
                    <a>
                        <span class="yuandian"></span>
                        <span class="yanse">亮黑色</span>
                    </a>
                </div>

            </div>
            <div class="xqxq mt20 ml20">
                <div class="top1 mt10">
                    <div class="left1 fl">小米6 全网通版 6GB内存 64GB 亮黑色</div>
                    <div class="right1 fr">2499.00元</div>
                    <div class="clear"></div>
                </div>
                <div class="bot mt20 ft20 ftbc">总计：2499元</div>
            </div>
            <div class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />

            </div>
        </div>
        <div class="clear"></div>
    </div>
</form>





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


<script src="resources/js/jquery_1.9.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/img-show.js"></script>

</body>
</html>