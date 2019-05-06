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
                <li class="drop-down"><a href="#">跟团游</a><span class="down-icon"></span>
                    <ul class="search-toggle-box">
                        <li><a href="#">所有产品</a></li>
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

        <div class="sidebar-info" style="height: 360px;">
            <ul class="side-li">
                <li class="s_1" style="height: 70px;line-height: 75px;"><h3>热门目的地<span
                        class="fa fa-angle-right fa-loc" style="line-height: 55px;"></span></h3></li>
                <li class="s_2" style="height: 70px;line-height: 75px;"><h3>海滨<span class="fa fa-angle-right fa-loc"
                                                                                      style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_3" style="height: 70px;line-height: 75px;"><h3>南方<span class="fa fa-angle-right fa-loc"
                                                                                    style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_4" style="height: 70px;line-height: 75px;"><h3>北方<span class="fa fa-angle-right fa-loc"
                                                                                    style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_5" style="height: 70px;line-height: 75px;"><h3>西部<span class="fa fa-angle-right fa-loc"
                                                                                    style="line-height: 55px;"></span>
                </h3></li>

            </ul>
            <!--hidden-li-box-->
            <ul class="hiden-box" style="height:340px;" >
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
                <li data-hidden="li" id="hiden-2">
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

                <li data-hidden="li" id="hiden-3">
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
    <div class="right-con" style="height: 400px;">
        <div class="nav" style="border-bottom: 2px solid rgba(0,128,0,0.5);">

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
        <div class="show-box" style="width: 720px;height: 350px;" >
            <!--广告内容-->
            <div class="content" >
                <ul class="imgBox">
                    <li><a href="user/routeForCity?cityId=2"><img src="./resources/image/tian.jpg"></a></li>
                    <li><a href="user/routeForCity?cityId=3"><img src="./resources/image/mei.jpg"></a></li>
                    <li><a href="user/routeForCity?cityId=1"><img src="./resources/image/ye.jpg"></a></li>
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

    </div>
</div>

<br><br><br><br>
<!--路线-->




<div class="gentuan w">
    <div class="biaoti center">境内跟团游</div>
    <div class="routemain center">
        <div class="routecontent">
            <div class="remen fl" style="height: 490px;width: 203px;background: url(./resources/image/left.png); ">
                <c:forEach items="${hotCity}" var="h">
                    <div style="margin-top: 33px;margin-left: 60px;"><a href="user/routeForCity?cityId=${h.cityId}&cityName=${h.cityName}">${h.cityName}&nbsp;❤${h.cityScore}</a></div>

                </c:forEach>


            </div>

                <div class="remen fl">
                    <div class="luxian"><span>top1</span></div>
                    <div class="tu"><a href="user/routesDetails?routeId=${route1.routeId}&routeName=${route1.routeName}"><img src="/IMAGE/${route1.routeImage}"></a></div>
                    <div class="miaoshu"><a href="">${route1.routeName}</a></div>
                    <div class="jiage">${route1.routePrice}</div>
<%--                    <div class="pingjia">372人评价</div>--%>
                    <div class="piao" style="margin-bottom:30px;position: relative;">
                        <a href="">
                            <span>${route1.routeScore}人点赞</span>
                        </a>
                    </div>
                </div>

            <div class="remen fl">
                <div class="luxian"><span>top2</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route2.routeId}&routeName=${route2.routeName}"><img src="/IMAGE/${route2.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route2.routeName}</a></div>
                <div class="jiage">${route2.routePrice}</div>
<%--                <div class="pingjia">372人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route2.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="luxian"><span>top3</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route3.routeId}&routeName=${route3.routeName}"><img src="/IMAGE/${route3.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route3.routeName}</a></div>
                <div class="jiage">${route3.routePrice}</div>
<%--                <div class="pingjia">372人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route3.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="luxian"><span>top4</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route4.routeId}&routeName=${route4.routeName}"><img src="/IMAGE/${route4.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route4.routeName}</a></div>
                <div class="jiage">${route4.routePrice}</div>
<%--                <div class="pingjia">372人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route4.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="routecontent">

            <div class="remen fl">
                <div class="luxian"><span>top5</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route5.routeId}&routeName=${route5.routeName}"><img src="/IMAGE/${route5.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route5.routeName}</a></div>
                <div class="jiage">${route5.routePrice}</div>
<%--                <div class="pingjia">372人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route5.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="luxian"><span>top6</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route6.routeId}&routeName=${route6.routeName}"><img src="/IMAGE/${route6.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route6.routeName}</a></div>
                <div class="jiage">${route6.routePrice}</div>
<%--                <div class="pingjia">372人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route6.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="luxian"><span>top7</span></div>
                <div class="tu"><a href="user/routesDetails?routeId=${route7.routeId}&routeName=${route7.routeName}"><img src="/IMAGE/${route7.routeImage}"></a></div>
                <div class="miaoshu"><a href="">${route7.routeName}</a></div>
                <div class="jiage">${route7.routePrice}</div>
<%--                <div class="pingjia">775人评价</div>--%>
                <div class="piao">
                    <a href="">
                        <span>${route7.routeScore}人点赞</span>
                    </a>
                </div>
            </div>
            <div class="remenlast fr">
                <div class="liulangengduo"><a href="user/searchAll?keyword="><img src="./resources/image/liulan.png" alt=""></a></div>
            </div>
            <div class="clear"></div>
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
<script src="./resources/js/show-image.js"></script>

</body>
</html>