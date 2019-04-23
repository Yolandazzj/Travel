<%--
  Created by IntelliJ IDEA.
  User: 34703
  Date: 2019/4/23
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta charset="UTF-8">
    <title>景点</title>
    <link rel="stylesheet" href="resources/css/reset.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css"/>

</head>
<body>
<!--空div-->
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
                        <li><a href="#">组团游</a></li>
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

        <div class="sidebar-info">
            <ul class="side-li">
                <li class="s_1" style="height: 70px;line-height: 75px;"><h3>热门景点<span class="fa fa-angle-right fa-loc"></span></h3></li>
                <li class="s_2"><h3>海滨<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_3"><h3>南方<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_4"><h3>北方<span class="fa fa-angle-right fa-loc" style="line-height: 55px;"></span>
                </h3></li>
                <li class="s_5"><h3>西部<span class="fa fa-angle-right fa-loc"style="line-height: 55px;"></span>
                </h3></li>

            </ul>
            <!--hidden-li-box-->
            <ul class="hiden-box">
                <li data-hidden="li" id="hiden-1" >
                    <div class="sub-nav-right" >
                        <div class="cell-box">
                            <h1>北京</h1>
                            <div class="a-box">
                                <a href="#">故宫</a><span>|</span>
                                <a href="#">颐和园</a><span>|</span>
                                <a href="#" class="orange">长城</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>上海</h1>
                            <div class="a-box">
                                <a href="#">崇明岛</a><span>|</span>
                                <a href="#" class="orange">迪士尼乐园</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>浙江</h1>
                            <div class="a-box">
                                <a href="#">宋城</a><span>|</span>
                                <a href="#">横店影视城</a><span>|</span>
                                <a href="#">千岛湖</a><span>|</span>
                                <a href="#" class="orange">杭州西湖</a>
                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left" >
                        <div class="cell-box">
                            <h1>山东</h1>
                            <div class="a-box">
                                <a href="#">栈桥</a><span>|</span>
                                <a href="#">崂山</a><span>|</span>
                                <a href="#" class="orange">大明湖</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>西藏</h1>
                            <div class="a-box">
                                <a href="#">林芝</a><span>|</span>
                                <a href="#">稻城亚丁</a><span>|</span>
                                <a href="#">珠峰</a><span>|</span>
                                <a href="#">雅鲁藏布江</a><span>|</span>
                                <a href="#" class="orange">布达拉宫</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>重庆</h1>
                            <div class="a-box">
                                <a href="#">武隆天坑</a><span>|</span>
                                <a href="#">解放碑</a><span>|</span>
                                <a href="#">磁器口</a><span>|</span>
                                <a href="#" class="orange">洪崖洞</a>

                            </div>
                        </div>
                    </div>
                </li>
                <li data-hidden="li" id="hiden-2">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>山东</h1>
                            <div class="a-box">
                                <a href="#">崂山</a><span>|</span>
                                <a href="#" class="orange">栈桥</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>海南</h1>
                            <div class="a-box">
                                <a href="#">海口</a><span>|</span>
                                <a href="#">大龙湾</a><span>|</span>
                                <a href="#">妈祖庙</a><span>|</span>
                                <a href="#" class="orange">三亚湾</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>福建</h1>
                            <div class="a-box">
                                <a href="#">鼓浪屿</a><span>|</span>
                                <a href="#">南普陀寺</a><span>|</span>
                                <a href="#" class="orange">曾厝垵</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>香港</h1>
                            <div class="a-box">
                                <a href="#">尖沙咀</a><span>|</span>
                                <a href="#">铜锣湾</a><span>|</span>
                                <a href="#" class="orange">大屿山</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>台湾</h1>
                            <div class="a-box">
                                <a href="#">日月潭</a><span>|</span>
                                <a href="#">花莲</a><span>|</span>
                                <a href="#" class="orange">阿里山</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>浙江</h1>
                            <div class="a-box">
                                <a href="#">象山影视城</a><span>|</span>
                                <a href="#">普陀山</a><span>|</span>
                                <a href="#" class="orange">四明山</a>

                            </div>
                        </div>
                    </div>
                </li>

                <li data-hidden="li" id="hiden-3">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>上海</h1>
                            <div class="a-box">
                                <a href="#">崇明岛</a><span>|</span>
                                <a href="#" class="orange">迪士尼乐园</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>浙江</h1>
                            <div class="a-box">
                                <a href="#">宋城</a><span>|</span>
                                <a href="#">千岛湖</a><span>|</span>
                                <a href="#">横店影视城</a><span>|</span>
                                <a href="#" class="orange">杭州西湖</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>香港</h1>
                            <div class="a-box">
                                <a href="#">铜锣湾</a><span>|</span>
                                <a href="#">尖沙咀</a><span>|</span>
                                <a href="#" class="orange">大屿山</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>福建</h1>
                            <div class="a-box">
                                <a href="#">鼓浪屿</a><span>|</span>
                                <a href="#">南普陀寺</a><span>|</span>
                                <a href="#" class="orange">曾厝垵</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>云南</h1>
                            <div class="a-box">
                                <a href="#">丽江</a><span>|</span>
                                <a href="#">大理</a><span>|</span>
                                <a href="#" class="orange">西双版纳</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>广西</h1>
                            <div class="a-box">
                                <a href="#">桂林</a><span>|</span>
                                <a href="#" class="orange">阳朔</a>

                            </div>
                        </div>
                    </div>
                </li>
                <li data-hidden="li" id="hiden-4">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>北京</h1>
                            <div class="a-box">
                                <a href="#">故宫</a><span>|</span>
                                <a href="#" class="orange">长城</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>山东</h1>
                            <div class="a-box">
                                <a href="#">栈桥</a><span>|</span>
                                <a href="#">大明湖</a><span>|</span>
                                <a href="#" class="orange">崂山</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>内蒙古</h1>
                            <div class="a-box">
                                <a href="#">赤峰</a><span>|</span>
                                <a href="#" class="orange">锡林郭勒大草原</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>黑龙江</h1>
                            <div class="a-box">
                                <a href="#">牡丹江</a><span>|</span>
                                <a href="#" class="orange">哈尔滨</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>陕西</h1>
                            <div class="a-box">
                                <a href="#">兵马俑</a><span>|</span>
                                <a href="#">大雁塔</a><span>|</span>
                                <a href="#" class="orange">华清池</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>辽宁</h1>
                            <div class="a-box">
                                <a href="#">棋盘山</a><span>|</span>
                                <a href="#">白沙湾</a><span>|</span>
                                <a href="#" class="orange">海棠山</a>

                            </div>
                        </div>
                    </div>
                </li>

                <li data-hidden="li" id="hiden-5">
                    <div class="sub-nav-right">
                        <div class="cell-box">
                            <h1>西藏</h1>
                            <div class="a-box">
                                <a href="#">稻城亚丁</a><span>|</span>
                                <a href="#">纳木错</a><span>|</span>
                                <a href="#" class="orange">布达拉宫</a>
                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>重庆</h1>
                            <div class="a-box">
                                <a href="#">观音桥</a><span>|</span>
                                <a href="#">解放碑</a><span>|</span>
                                <a href="#" class="orange">洪崖洞</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>新疆</h1>
                            <div class="a-box">
                                <a href="#">坎儿井</a><span>|</span>
                                <a href="#">火焰山</a><span>|</span>
                                <a href="#">天山天池</a><span>|</span>
                                <a href="#">魔鬼城</a><span>|</span>
                                <a href="#" class="orange">赛里木湖</a>

                            </div>
                        </div>
                    </div>
                    <div class="sub-nav-left">
                        <div class="cell-box">
                            <h1>青海</h1>
                            <div class="a-box">
                                <a href="#">茶卡盐湖</a><span>|</span>
                                <a href="#" class="orange">青海湖</a>

                            </div>
                        </div>
                        <div class="cell-box">
                            <h1>甘肃</h1>
                            <div class="a-box">
                                <a href="#">莫高窟</a><span>|</span>
                                <a href="#">鸣沙山</a><span>|</span>
                                <a href="#" class="orange">月牙泉</a>

                            </div>
                        </div>
<%--                        <div class="cell-box">--%>
<%--                            <h1>省份</h1>--%>
<%--                            <div class="a-box">--%>
<%--                                <a href="#">城市</a><span>|</span>--%>
<%--                                <a href="#">城市</a><span>|</span>--%>
<%--                                <a href="#">城市</a><span>|</span>--%>
<%--                                <a href="#">城市</a><span>|</span>--%>
<%--                                <a href="#" class="orange">城市</a>--%>

<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </li>


            </ul>
        </div>
    </div>
    <!--right-con-->
    <div class="right-con">
        <div class="nav">

            <a href="#">旅行社</a>
            <a href="#">组团游</a>
            <a href="user/tours">跟团游</a>
            <a href="#">攻略</a>
            <a href="#">美食</a>
            <a href="#">酒店</a>
            <a href="#">景点</a>
            <a href="#">推荐路线</a>
            <a href="#">留言板</a>


        </div>
        <!--滚动广告box-->
        <div class="show-box" >
            <!--广告内容-->
            <div class="content" >
                <ul class="imgBox">
                    <li><a href="#"><img src="resources/image/bj.jpg"></a></li>
                    <li><a href="#"><img src="resources/image/xh.jpg"></a></li>
                    <li><a href="#"><img src="resources/image/sh.jpg"></a></li>
                    <li><a href="#"><img src="resources/image/ls.jpg"></a></li>
                    <li><a href="#"><img src="resources/image/jn.jpg"></a></li>
                </ul>
                <div class="currentNum">
                    <span class="imgNum mark-color"></span>
                    <span class="imgNum"></span>
                    <span class="imgNum"></span>
                    <span class="imgNum"></span>
                    <span class="imgNum"></span>
                </div>
            </div>

        </div>

    </div>
</div>

<!--main-->
<div class="main" style="height: 1500px;">
    <div class="main-left" style="height: 856px;">
        <div class="main-title">
            <h1 style="color: rgba(0,128,0,0.8)">当季热玩<span class="show-title">这里有当下最热门的景点！</span></h1>
        </div>
        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>
        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>
        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>
        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>
        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>

        <div class="product-box">
            <div class="inner-info">
                <div>
                    <span class="line-f40" style="color: rgba(0,128,0,0.8);">|</span>
                    <span class="text-title">景点名字</span>
                </div>
                <div class="inner-left">
                    <img src="resources/image/show1.png"/>
                    <h1><a href="#">图片换成数据库图片，这放景点点赞数</a></h1>
                    <span>景点所属城市</span>
                </div>
                <div class="inner-right">
                    <div>
                        <a href="#">
                            <p>这里放景点介绍</p>
                        </a>

                    </div>

                </div>
            </div>
        </div>
    </div>

    <%--畅销排行榜--%>

    <div class="right-sidebar" style="height: 400px;">
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

    <div class="right-sidebar" style="height: 400px;">
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
<script src="resources/js/show-image.js"></script>

</body>
</html>
