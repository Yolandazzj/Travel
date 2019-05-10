<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/5/10
  Time: 10:53
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
    <title>游记详情</title>
    <link rel="stylesheet" href="resources/css/reset.css"/>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css"/>
<body>

<!--滚动屏-->
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
        <a href="user/essayAll" >攻略</a>
        <a href="/user/food" >美食</a>
        <a href="#">酒店</a>
        <a href="user/scene" >景点</a>
        <a href="#" >推荐路线</a>
        <a href="/user/message" >留言板</a>

    </div>
</div>
<br><br><br><br><br><br>

<!-- 详情 -->
<div class="xiaomi6 fl">
    ${essayDetails.etitle}
</div>
<br><br><br><br>
<div class="jieshao mt20 w">
    <div class="left fl"><img src="/IMAGE/${essayDetails.eimage}"></div>
    <div class="right fr" style="height:562px;padding-left: 20px; ">
        <br>
        <div class="jianjie mr40 ml20 mt10">游记城市：<div class="jiage ml20 mt10"><br>${essay.cityId}</div></div>
        <br><br><br>
        <div class="jianjie mr40 ml20 mt10">游记作者：<div class="jiage ml20 mt10"><br>${essay.userinfo.uid}</div></div>
        <br><br><br>
        <c:forEach items="${cityInfo}" var="ci">
            <div class="jianjie mr40 ml20 mt10">所在城市:&nbsp;&nbsp;<span style="color: black;">${ci[1]}</span></div>
        </c:forEach>
        <br><br><br>
        <div class="jianjie mr40 ml20 mt10">点赞数:&nbsp;&nbsp;<span style="color: black;" id="thumbNumber">${essayDetails.escore}</span></div>
        <br><br><br>
        <div class="xiadan ml20 mt20" style="margin-left: 230px;">
            <form action="javascript:thumb_food(${essayDetails.essayId})" method="post">
                <input  type="hidden" name="sceneId" value="${essayDetails.essayId}">
                <button class="jrgwc"  type="submit">我要点赞</button>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>

<img src="./resources/image/user3.png" id="image2">
<div class="control-group" style="border: 10px solid rgba(0,128,0,0.5); width: 1000px;height: 1000px;margin-bottom:0px;margin: 0 auto;">

    <table id="commentTable">
        <c:forEach items="${essayCommentList}" var="e">
            <tr>
                <td>${e[2]}&nbsp;&nbsp;<span style="font-size: 12px;">
                                                <fmt:formatDate  value="${e[5]}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </span>:
                    <a href="javascript:thumb_comment(${e[0]})"><span style="margin-left: 850px;">👍<span id="${e[0]}">${e[4]}</span></span></a>
                    <br><br><br>${e[3]}</td>
            </tr>
        </c:forEach>
    </table>

    <br><br><br>


    <br><br>
    <form id="commentForm" method="post">
        <div class="message-group">
            <div class="message-controls">
                <input  type="hidden" name="uid" value="${user.uid}">
                <input  type="hidden" name="fid" value="${essayDetails.essayId}">
                <div class="message-group" style="margin-bottom: 100px;position: relative;">
                    <div class="controls">
                        <textarea cols="100" rows="10" id="writeComment" name="fcommentContent" style="resize: none;margin-left: 130px"></textarea>
                        <br> <br>
                        <input type="button" value="发表评论" id="submitBtn" style="margin-left:450px;resize:none;border:1px solid rgba(0,128,0,0.5);background-color: rgba(0,128,0,0.5);color: white">
                    </div>
                </div>
            </div>
        </div>
    </form>
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
    //游记点赞
    function thumb_food(fid) {
        $.ajax({
            url: 'user/thumb_food',
            type: "POST",
            data: {"essayId": essayId},
            success: function (data) {
                var onumber = parseInt($("#thumbNumber").text());
                $("#thumbNumber").html(onumber + 1);
            },
            error: function () {
                alert("Ajax请求失败");
            }
        });
    }

    //美食评论点赞
    function thumb_comment(fcommentId) {
        $.ajax({
            url: 'user/thumb_comment',
            type: "POST",
            data: {"fcommentId": fcommentId},
            success: function (data) {
                var onumber = parseInt($("#"+fcommentId).text());
                $("#"+fcommentId).html(onumber + 1);
            },
            error: function () {
                alert("Ajax请求失败");
            }
        });
    }
</script>

<script>
    //发表评论
    $(document).ready(function () {
        $("#submitBtn").click(function (foodComment) {
            $.ajax({
                url: 'user/toFoodComment',
                type: "POST",
                data: $("#commentForm").serialize(),
                success: function (foodComment) {
                    var str =  "<tr><td>"
                    +${user.uid}+"&nbsp;&nbsp;<span style=\"font-size: 12px;\">"
                    +foodComment.fcommentTime+"</span><br><a href='javascript:thumb_comment("
                    +foodComment.fcommentId+")'><span style=\"margin-left: 850px;\">👍<span id=m"
                    +foodComment.fcommentId+">"
                    +foodComment.fcommentScore+"</span></span></a><br><br><br>"
                    +foodComment.fcommentContent+"</td></tr>"
                    $("#commentTable").append(str);
                    $("#8").remove();
                    $("#writeComment").val("");

                },
                error: function (request, status, error) {
                    alert("Ajax请求失败!" + error);
                }
            });
        });
    });
</script>
</body>
</html>
