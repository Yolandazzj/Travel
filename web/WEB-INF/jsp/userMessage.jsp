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
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <script src="./resources/js/jquery-2.1.4.min.js"></script>
</head>
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
    <img src="./resources/image/logo.jpg" alt="logo"/>
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
            <c:forEach items="${messageAll}" var="m" varStatus="x">
                <tr id="${x.count}">
                    <td>${m.userinfo.uid}&nbsp;&nbsp;<span style="font-size: 12px;">
                                                <fmt:formatDate  value="${m.messageTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                    </span><a href="javascript:thumb(${m.messageId})"><span style="margin-left: 850px;">👍<span id="m${m.messageId}">${m.messageScore}</span></span></a><br><br><br>${m.messageContent}</td>

                </tr>
            </c:forEach>
        </table>
<br><br><br>
    <form id="paging" style="text-align:center;">
        <tr>
            <td colspan="8" align="center" >共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页
                <br> <br>

                <a href="user/message?pageNo=${page.topPageNo}&uid=${user.uid}"><input type="button" name="fristPage" value="首页" /></a>

                <c:choose>
                    <c:when test="${page.pageNo!=1}">

                        <a href="user/message?pageNo=${page.previousPageNo}&uid=${user.uid}"><input type="button" name="previousPage" value="上一页" /></a>

                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="previousPage" value="上一页" />

                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNo!= page.totalPages}">
                        <a href="user/message?pageNo=${page.nextPageNo}&uid=${user.uid}"><input type="button" name="nextPage" value="下一页" /></a>
                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="nextPage" value="下一页" />

                    </c:otherwise>
                </c:choose>
                <a href="user/message?pageNo=${page.bottomPageNo }&uid=${user.uid}"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
    </form>

    <br><br>
    <form id="commentForm">
        <!--隐藏字段-->

        <div class="message-group">
            <div class="message-controls">
                <input  type="hidden" name="uid" value="${user.uid}">
                <div class="message-group" style="margin-bottom: 100px;position: relative;">
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


<script src="./resources/js/jquery_1.9.js"></script>
<script src="./resources/js/main.js"></script>
<script src="./resources/js/img-show.js"></script>
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
                    +${user.uid}+"&nbsp;&nbsp;<span style=\"font-size: 12px;\">"
                    +message.messageTime+"</span><br><a href='javascript:thumb("
                    +message.messageId+")'><span style=\"margin-left: 850px;\">👍<span id=m"
                    +message.messageId+">"
                    +message.messageScore+"</span></span></a><br><br><br>"
                    +message.messageContent+"</td></tr>"
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

<!--点赞--->
<script>
    function thumb(messageId) {
        $.ajax({
            url: 'user/thumbMessage',
            type: "POST",
            data: {"messageId": messageId},
            success: function (data) {

                var onumber = parseInt($("#m"+messageId).text());
                $("#m"+messageId).html(onumber + 1);


            },
            error: function () {
                alert("Ajax请求失败");
            }

        });
    }


</script>


</body>
</html>