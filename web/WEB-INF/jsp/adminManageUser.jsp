<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/5/7
  Time: 15:20
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
    <title>管理用户</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <script src="./resources/js/jquery-2.1.4.min.js"></script>

    <style type="text/css">
        table.altrowstable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #a9c6c9;
            border-collapse: collapse;
            width: 1000px;
        }
        table.altrowstable th {
            background-color: #a9c6c9;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        table.altrowstable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
            text-align: center;
        }
    </style>

</head>
<body>
<!--空div-->
<div class="scroll-head"></div>
<!--顶部-->
<div class="top-wrapper">
    <div class="top-info">
        <div class="top-left">
            <c:if test="${admin==null}">
                <div data-toggle="arrowdown" id="arrow1" class="user-name">
                    <a href="admin/toLogin">登录</a>
                </div>
            </c:if>
            <c:if test="${admin!=null}">
                <div data-toggle="arrowdown" id="arrow1" class="user-name">
                    <p>登录成功，欢迎：管理员${admin.adminId} &nbsp; &nbsp;</p>
                </div>
                <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                    <a href="admin/loginout">注销</a>
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
            <ul data-toggle="arrowdown" id="arrow8" class="search-toggle">
                <li class="drop-down"><a href="#">所有产品</a><span class="down-icon"></span>
                    <ul class="search-toggle-box">
                        <li><a href="user/groupAll">组团游</a></li>
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
<!--main-->
<div class="sub-nav">
<div class="container">
    <div class="row">

        <section class="col-sm-12 maincontent">
            <table class="altrowstable" id="alternatecolor" style="width: 1000px">
                <tr>
                    <th>用户id</th>
                    <th>用户状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${reportUserList}" var="u">
                    <tr>
                        <td>${u.uid}</td>
                        <td>
                            <c:if test="${u.isBan==0}">
                                等待禁用
                            </c:if>
                            <c:if test="${u.isBan==1}">
                                已禁用
                            </c:if>
                        </td>
                        <td>
                            <a href="#">查看详情</a>&nbsp;
                            <a href="#">编辑</a>&nbsp;
                            <a href="javascript:banUser('${u.uid}')">禁用</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>


        </section>
    </div>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="resources/js/custom.js"></script>
</div>
</div>
<br/><br/><br/><br/><br/><br/>
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
<script>
    function banUser(uid) {
        $.ajax({
            url: 'admin/banUser',
            type: "POST",
            data: {"uid": uid},
            success: function (data) {


                alert("禁用成功！")
            },
            error: function () {
                alert("Ajax请求失败!");
            }
        });
    }
</script>
</body>
</html>
