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
<br><br><br><br><br><br><br><br>


<div class="control-group" style="border: 10px solid rgba(0,128,0,0.5); width: 1000px;height: 1000px;margin-bottom:0px;margin: 0 auto;">


        <table id="commentTable">
            <c:forEach items="${messageAll}" var="m">
                <tr>
                    <td>${m.userinfo.uid}&nbsp;&nbsp;<span style="font-size: 12px;">
                                                <fmt:formatDate  value="${m.messageTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                    </span><a href="#"><span style="margin-left: 850px;">👍<span id="thumbNumber">${m.messageScore}</span></span></a><br><br><br>${m.messageContent}</td>

                </tr>
            </c:forEach>
        </table>

    <form id="commentForm">
        <!--隐藏字段-->

        <div class="message-group">
            <div class="message-controls">
                <input  type="hidden" name="uid" value="001">
                <div class="message-group" style="margin-top: 500px;">
                    <div class="controls">

                        <textarea cols="100" rows="10" id="writeComment" name="messageContent" style="resize: none;margin-left: 130px"></textarea>
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


<script src="resources/js/jquery_1.9.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/img-show.js"></script>
<!--留言板-->
<script>
    $(document).ready(function () {
        $("#submitBtn").click(function (message) {
            $.ajax({
                url: 'user/toMessage',
                type: "POST",
                data: $("#commentForm").serialize(),
                success: function (message) {

                    var str =  "<tr><td>"
                    +"001"+"&nbsp;&nbsp;<span style=\"font-size: 12px;\">"
                    +message.messageTime+"</span><a href=\"#\"><span style=\"margin-left: 850px;\">👍<span id=\"thumbNumber\">"
                    +message.messageScore+"</span></span></a><br><br><br>"
                    +message.messaageContent+"</td></tr>"
                    $("#commentTable").append(str);
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