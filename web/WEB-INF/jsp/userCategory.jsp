<%--
  Created by IntelliJ IDEA.
  User: 34703
  Date: 2019/5/1
  Time: 15:04
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
    <title>美食类别</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <script src="./resources/js/jquery-2.1.4.min.js"></script>
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
                        <li><a href="user/scene">景点</a></li>
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

<div class="right-con" style="height: 100px;">
    <div class="nav" style="border-bottom: 2px solid rgba(0,128,0,0.5);width: 730px;">

        <a href="#">旅行社</a>
        <a href="#">组团游</a>
        <a href="user/tours" >跟团游</a>
        <a href="#" >攻略</a>
        <a href="user/food" >美食</a>
        <a href="#">酒店</a>
        <a href="user/scene" >景点</a>
        <a href="#" >推荐路线</a>
        <a href="user/message" >留言板</a>


    </div>


</div>

<br><br><br><br><br><br><br><br>



<!--美食列表-->
<div class="xiaomi6 fl">
    ${fcategoryName}
</div>
<div class="control-group" style="border: 10px solid rgba(0,128,0,0.5); width: 1000px;height: 1000px;margin-bottom:0px;margin: 0 auto;">


    <table id="commentTable">
        <c:forEach items="${foodCateList}" var="f">
            <tr>
                <td>${f[0]}&nbsp;&nbsp;<a href="javascript:thumb_food(${f[0]})" ><span style="margin-left: 850px;">👍<span id="${f[0]}">${f[4]}</span></span></a><br><br><br>
                    <a href="user/foodDetails?fid=${f[0]}&fname=${f[3]}">${f[3]}</a></td>

            </tr>
        </c:forEach>
    </table>
    <br><br><br>
    <form id="paging" style="text-align:center;">
        <tr>
            <td colspan="8" align="center" >共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页
                <br> <br>

                <a href="user/category?pageNo=${page.topPageNo}"><input type="button" name="fristPage" value="首页" /></a>

                <c:choose>
                    <c:when test="${page.pageNo!=1}">

                        <a href="user/category?pageNo=${page.previousPageNo}"><input type="button" name="previousPage" value="上一页" /></a>

                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="previousPage" value="上一页" />

                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNo!= page.totalPages}">
                        <a href="user/category?pageNo=${page.nextPageNo}"><input type="button" name="nextPage" value="下一页" /></a>
                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="nextPage" value="下一页" />

                    </c:otherwise>
                </c:choose>
                <a href="user/category?pageNo=${page.bottomPageNo }"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
    </form>

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
    //点赞美食
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
