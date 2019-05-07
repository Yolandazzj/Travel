<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/4/28
  Time: 10:12
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
</head>
<body>
<!--空div-->
<div class="scroll-head"></div>
<!--顶部-->
<div class="top-wrapper">
    <div class="top-info">
        <div class="top-left">
            <a href="index">首页</a>
            <%--            <c:if test="${user==null}">--%>
            <%--                <div data-toggle="arrowdown" id="arrow1" class="user-name">--%>
            <%--                    <a href="user/toLogin">登录</a>--%>
            <%--                </div>--%>
            <%--                <div data-toggle="arrowdown" id="arrow2" class="msg-info">--%>
            <%--                    <i class="fa fa-gray"></i>--%>
            <%--                    <a href="#">注册</a>--%>
            <%--                </div>--%>
            <%--            </c:if>--%>
            <%--            <c:if test="${user!=null}">--%>
            <%--                <div data-toggle="arrowdown" id="arrow1" class="user-name">--%>
            <%--                    <p>登录成功，欢迎：${user.uid} &nbsp; &nbsp;</p>--%>
            <%--                </div>--%>
            <%--                <div data-toggle="arrowdown" id="arrow2" class="msg-info">--%>
            <%--                    <a href="user/loginout">注销</a>--%>
            <%--                </div>--%>
            <%--            </c:if>--%>
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
        <div class="search-box">
            <ul data-toggle="arrowdown" id="arrow8" class="search-toggle">
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

<!--main-->
<div class="main" style="height: 600px;width: 800px;">
    <div class="login-top left">
        <form class="login-form" id="loginValidate" action="user/editInfo" method="post" style="margin-top: 100px">
            <div class="form-group" style="margin-top:50px; padding: 50px 50px 50px 120px;">
                <input type="hidden" class="form-control" id="uid" name="uid" style="width: 80%; height:25px;"
                       value="${user.uid}">
                <br>
                <label for="upassword">密码：</label>
                <input class="form-control" id="upassword" type="password" name="upassword"
                       style="width: 80%;height:25px;"
                       value="${user.upassword}">
                <br>
                <label for="ugender">性别：</label>

                <input type="radio" name="ugender" value="男">&nbsp;男&nbsp;
                <input type="radio" name="ugender" value="女">&nbsp;女
                <br><br>
                <label for="ucity">城市：</label>
                <input type="text" class="form-control" id="ucity" name="ucity" style="width: 80%; height:25px;" value="${user.ucity}">

                <br>
                <label for="ucontact">电话：</label>
                <input type="text" class="form-control" id="ucontact" name="ucontact" style="width: 80%; height:25px;"
                       placeholder="请输入手机号" value="${user.ucontact}">

                <br>
                <label for="uemail">邮箱：</label>
                <input type="text" class="form-control" id="uemail" name="uemail" style="width: 80%; height:25px;"
                       placeholder="请输入正确格式的邮箱" value="${user.uemail}">
                <br>
                <button type="submit" class="btn btn-default">提交修改</button>
            </div>
        </form>
    </div>
</div>
<%--    <table class="altrowstable" id="alternatecolor">--%>
<%--        --%>
<%--        <tr>--%>
<%--            <th>信息</th>--%>
<%--            <th> </th>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>名字</td>--%>
<%--            <td>${user.uid}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>性别</td>--%>
<%--            <td>${user.ugender}</td>--%>
<%--        </tr>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>城市</td>--%>
<%--            <td>${user.ucity}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>联系方式</td>--%>
<%--            <td>${user.ucontact}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>电子邮箱</td>--%>
<%--            <td>${user.uemail}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>是否禁用</td>--%>
<%--&lt;%&ndash;            <td>${user.isban}</td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>密码</td>--%>
<%--            <td>${user.upassword}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>等级</td>--%>
<%--            <td>${user.urank}</td>--%>
<%--        </tr>--%>
<%--    </table>--%>


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