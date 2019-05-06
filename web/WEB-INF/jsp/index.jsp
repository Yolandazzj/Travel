<%--
  Created by IntelliJ IDEA.
  User: 张紫捷
  Date: 2019/4/12
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="UTF-8">
    <title>途牛旅行</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <link rel="stylesheet" href="./resources/css/table.css"/>
</head>
<body>
<!--空div-->
<div class="scroll-head"></div>
<!--顶部-->
<div class="top-wrapper">
    <div class="top-info">
        <div class="top-left">
            <c:if test="${user==null}">
                <div data-toggle="arrowdown" id="arrow1" class="user-name">
                    <a href="user/toLogin">登录</a>
                </div>
                <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                    <i class="fa fa-gray"></i>
                    <a href="#">注册</a>
                </div>
            </c:if>
            <c:if test="${user!=null}">
                <div data-toggle="arrowdown" id="arrow1" class="user-name">
                    <p>登录成功，欢迎：${user.uid} &nbsp; &nbsp;</p>
                </div>
                <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                    <a href="user/loginout">注销</a>
                </div>
            </c:if>
        </div>

        <!--top-right-->
        <div class="top-right">
            <div data-toggle="arrowdown" id="arrow3" class="user-name">
                <li class="drop-down"><a href="#">我的账户</a><span class="down-icon"></span>
                    <ul class="user-toggle-box">
                        <c:if test="${user!=null}">
                            <li><a href="user/toCenter">个人中心</a></li>
                            <li><a href="#">修改信息</a></li>
                        </c:if>
                    </ul>
                </li>

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
    <img src="./resources/image/logo.jpg" alt="logo"/>
    <div class="search-wrapper">
        <form action="user/searchAll" method="post">
        <div class="search-box">
            <ul data-toggle="arrowdown" id="arrow8" class="search-toggle" >
                <li class="drop-down"><a href="#">所有产品</a><span class="down-icon"></span>
                <ul class="search-toggle-box">
                    <li><a href="user/groupAll">组团游</a></li>
                    <li><a href="#">景点</a></li>
                    <li><a href="#">攻略</a></li>
                    <li><a href="#">酒店</a></li>
                </ul>
                   </li>
            </ul>
            <input class="search-in" type="text" placeholder="请输入关键字" name="keyword">
            <button type="submit" class="search-but" value="搜索"></button>

        </div>
        </form>
    </div>
    <!--two-code-->
    <div class="two-code">
        <h3>定位板块</h3>

    </div>

</div>

<!--content-top-->
<div class="content-top" style="height: 400px;">
    <!--sidebar-->
    <div class="sidebar" style="height: 400px;">
        <h3 style="background-color: rgba(0,128,0,0.5);">产品服务</h3>

        <!--侧拉菜单-->

        <div class="sidebar-info">
            <ul class="side-li">
                <li class="s_1" style="height: 70px;line-height: 75px;"><h3>自由行<span class="fa fa-angle-right fa-loc"></span></h3></li>
                <li class="s_2"><h3>跟团旅游<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_3"><h3>酒店<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_4"><h3>攻略<span class="fa fa-angle-right fa-loc" style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_5"><h3>美食<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>

            </ul>
            <!--hidden-li-box-->
            <ul class="hiden-box">
                <li data-hidden="li" id="hiden-1" >
                    <div class="sub-nav-right" >
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left" >
                        <div class="cell-box">
                            <h1>山东省</h1>
                            <div class="a-box">
                                <a href="#">济南</a><span>|</span>
                                <a href="#">青岛</a><span>|</span>
                                <a href="#">潍坊</a><span>|</span>
                                <a href="#">淄博</a><span>|</span>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                </li>
                <li data-hidden="li" id="hiden-2">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>山东省</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=37">济南</a><span>|</span>
                                <a href="user/routeForCity?cityId=38">青岛</a><span>|</span>
                                <a href="#">潍坊</a><span>|</span>
                                <a href="#">淄博</a><span>|</span>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>上海市</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=3">上海</a><span>|</span>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>黑龙江省</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=24">哈尔滨</a><span>|</span>
                                <a href="user/routeForCity?cityId=25">大庆</a><span>|</span>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>江苏省</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=26">南京</a><span>|</span>
                                <a href="user/routeForCity?cityId=27">无锡</a><span>|</span>
                                <a href="user/routeForCity?cityId=28">苏州</a><span>|</span>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>浙江省</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=29">杭州</a><span>|</span>
                                <a href="user/routeForCity?cityId=30">宁波</a><span>|</span>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>安徽省</h1>
                            <div class="a-box">
                                <a href="user/routeForCity?cityId=31">合肥</a><span>|</span>
                                <a href="user/routeForCity?cityId=32">莱湖</a><span>|</span>

                            </div>
                        </div>
                    </div>
                </li>

                <li data-hidden="li" id="hiden-3">
                    酒店查询表
                </li>
                <li data-hidden="li" id="hiden-4">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                </li>

                <li data-hidden="li" id="hiden-5">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>省份</h1>
                            <div class="a-box">
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#">城市</a><span>|</span>
                                <a href="#" class="orange">城市</a>

                            </div>
                        </div>
                    </div>
                </li>


            </ul>
        </div>
    </div>
    <!--right-con-->
    <div class="right-con">
        <div class="nav">

            <a href="#">首页</a>
            <a href="user/groupAll">组团游</a>
            <a href="user/tours">跟团游</a>
            <a href="#">攻略</a>
            <a href="user/food">美食</a>
            <a href="#">酒店</a>
            <a href="user/scene">景点</a>
            <a href="user/message">留言板</a>


        </div>
        <!--滚动广告box-->
        <div class="show-box" >
            <!--广告内容-->
            <div class="content" >
                <ul class="imgBox">
                    <li><a href="user/routeForCity?cityId=29"><img src="./resources/image/xh.jpg"></a></li>
                    <li><a href="user/routeForCity?cityId=3"><img src="./resources/image/ts.jpg"></a></li>
                    <li><a href="user/routeForCity?cityId=1"><img src="./resources/image/yl.jpg"></a></li>
<%--                    <li><a href="#"><img src="./resources/image/4.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="./resources/image/5.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="resources/image/1.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="resources/image/2.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="resources/image/3.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="resources/image/4.jpg"></a></li>--%>
<%--                    <li><a href="#"><img src="resources/image/5.jpg"></a></li>--%>
                </ul>
                <div class="currentNum">
                    <span class="imgNum mark-color"></span>
                    <span class="imgNum"></span>
                    <span class="imgNum"></span>
<%--                    <span class="imgNum"></span>--%>
<%--                    <span class="imgNum"></span>--%>
                </div>
            </div>

        </div>
        <!--right-sidbar-->
        <div class="right-sidebar" style="height: 400px;">
            <div class="info-box" style="height: 350px;">
                <ul class="tab-nav">
                    <li id="li-1" class="li-nav li-nav-hover li-border">热门游记</li>
                    <li id="li-2" class="li-nav">热门景点</li>
                    <li id="li-3" class="li-nav">热门留言</li>
                    <li style="border-right: none" id="li-5" class="li-nav">热门路线</li>
                </ul>
                <div id="box-1" style="display: block" class="hiddenBox">

                    <a href="#">热门1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                </div>
                <div id="box-2" class="hiddenBox">
                    <c:forEach items="${sceneList}" var="sl">
                    <a style="display: block;font-size: 13px;text-decoration: underline" href="user/sceneDetails?sceneId=${sl.sceneId}&sceneName=${sl.sceneName}">${sl.sceneName}</a>
                    </c:forEach>
                </div>
                <div id="box-3" class="hiddenBox">
                    <c:forEach items="${hotMessageList}" var="hm">
                        <a style="display: block;font-size: 13px;text-decoration: underline" href="user/message">${hm.messageContent}</a>
                    </c:forEach>
                </div>
                <div id="box-5" class="hiddenBox">

                    <c:forEach items="${hotRouteList}" var="hr">
                        <a style="display: block;font-size: 13px;text-decoration: underline" href="user/routesDetails?routeName=${hr.routeName}&routeId=${hr.routeId}">${hr.routeName}</a>
                    </c:forEach>
                </div>

            </div>


        </div>
    </div>
</div>
<!--main-->
<div class="sub-nav">
    <!--sub-nav-cell-->
    <div class="sub-nav-cell" style="width: 300px;height: 150px;">
        <h3 class="orange">超值酒店</h3>
        酒店图片和价钱
    </div>
    <div class="sub-nav-cell" style=" width: 300px;height: 150px;">
        <h3 class="green-sp">超值路线</h3>
        <c:forEach items="${lowerPriceRoute}" var="l">
            <a href="user/routesDetails?routeName=${l.routeName}&routeId=${l.routeId}"><img src="/IMAGE/${l.routeImage}" style="width: 150px;height: 100px;"></a>
            <span style="float: left;margin-top: 20px;"><a href="user/routesDetails?routeName=${l.routeName}&routeId=${l.routeId}"><${l.routeName}></a></span>
            <span style="float: left;margin-top: 20px;"><a href="user/routesDetails?routeName=${l.routeName}&routeId=${l.routeId}">${l.routePrice}元！</a></span>
        </c:forEach>
    </div>

</div>

<br><br><br><br>
<!--main-->
<div class="main" style="height: 580px;">
    <div class="main-left" style="height: 590px;">
<%--        <div class="main-title">--%>
<%--            <h1 style="color: rgba(0,128,0,0.8)">当季热玩<span class="show-title">这里有当下最热门的景点！</span></h1>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <c:forEach items="${cityDetails}" var="c">--%>
<%--                    <span>${c[1]}</span>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <span>景点所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <span>景点所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <span>景点所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <span>景点所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">景点名字</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>--%>
<%--                    <span>景点所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
    <div class="main-title">
        <h1 style="color: orangered;">攻略精选<span class="show-title">这里有最全面的攻略！</span></h1>
    </div>
    <div class="product-box">
        <div class="inner-info">
            <div>
                <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                <span class="text-title">攻略题目</span>
            </div>
            <div class="inner-left">
                <img src="./resources/image/show1.png"/>
                <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>
                <span>攻略所属城市</span>
            </div>
            <div class="inner-right">
                <div>
                    <a href="#">
                        <p>这里放攻略介绍</p>
                    </a>

                </div>

            </div>
        </div>
    </div>
    <div class="product-box">
        <div class="inner-info">
            <div>
                <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                <span class="text-title">攻略题目</span>
            </div>
            <div class="inner-left">
                <img src="./resources/image/show1.png"/>
                <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>
                <span>攻略所属城市</span>
            </div>
            <div class="inner-right">
                <div>
                    <a href="#">
                        <p>这里放攻略介绍</p>
                    </a>

                </div>

            </div>
        </div>
    </div>
    <div class="product-box">
        <div class="inner-info">
            <div>
                <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                <span class="text-title">攻略题目</span>
            </div>
            <div class="inner-left">
                <img src="./resources/image/show1.png"/>
                <h1><a href="#">图片换成数据库图片，这放景攻略点赞数</a></h1>
                <span>攻略所属城市</span>
            </div>
            <div class="inner-right">
                <div>
                    <a href="#">
                        <p>这里放攻略介绍</p>
                    </a>

                </div>

            </div>
        </div>
    </div>

    <div class="product-box">
        <div class="inner-info">
            <div>
                <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                <span class="text-title">攻略题目</span>
            </div>
            <div class="inner-left">
                <img src="./resources/image/show1.png"/>
                <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>
                <span>攻略所属城市</span>
            </div>
            <div class="inner-right">
                <div>
                    <a href="#">
                        <p>这里放攻略介绍</p>
                    </a>

                </div>

            </div>
        </div>
    </div>

    </div>
    <%--畅销排行榜--%>

    <div class="right-sidebar" style="height: 300px;float: right;">
        <div class="info-box" style="height: 350px;">
            <ul class="tab-nav">
                <li id="li-4" class="li-nav li-nav-hover li-border" style="color:rgba(0,125,0,0.5);">畅销酒店</li>
            </ul>
            <div id="box-6" style="display: block" class="showDetails">

                畅销酒店信息
            </div>

        </div>


    </div>


    <%--畅销排行榜--%>

    <div class="right-sidebar" style="height: 300px;float: right;">
        <div class="info-box" style="height: 350px;">
            <ul class="tab-nav">
                <li id="li-6" class="li-nav li-nav-hover li-border">畅销路线</li>
            </ul>
            <div id="box-7" style="display: block" class="showDetails">

                畅销路线信息
            </div>

        </div>


    </div>
        </div>

<div class="clear"></div>




<%--第二个板块:热门游记--%>

<%--    <div class="main-left" style="height: 587px;">--%>
<%--        <div class="main-title">--%>
<%--            <h1 style="color: orangered;">攻略精选<span class="show-title">这里有最全面的攻略！</span></h1>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">攻略题目</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>--%>
<%--                    <span>攻略所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放攻略介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">攻略题目</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>--%>
<%--                    <span>攻略所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放攻略介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">攻略题目</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放景攻略点赞数</a></h1>--%>
<%--                    <span>攻略所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放攻略介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="product-box">--%>
<%--            <div class="inner-info">--%>
<%--                <div>--%>
<%--                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>--%>
<%--                    <span class="text-title">攻略题目</span>--%>
<%--                </div>--%>
<%--                <div class="inner-left">--%>
<%--                    <img src="./resources/image/show1.png"/>--%>
<%--                    <h1><a href="#">图片换成数据库图片，这放攻略点赞数</a></h1>--%>
<%--                    <span>攻略所属城市</span>--%>
<%--                </div>--%>
<%--                <div class="inner-right">--%>
<%--                    <div>--%>
<%--                        <a href="#">--%>
<%--                            <p>这里放景点介绍</p>--%>
<%--                        </a>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>




<%--    </div>--%>
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

</body>
</html>