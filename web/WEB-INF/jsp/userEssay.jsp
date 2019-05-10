<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/5/8
  Time: 10:44
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
    <title>用户游记</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <script src="./resources/js/jquery-2.1.4.min.js"></script>
    <link title="style1" rel="stylesheet" href="./resources/css/groupStyle.css" type="text/css"/>
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
                <a href="user/toCenter">我的账户</a>

            </div>
            <div data-toggle="arrowdown" id="arrow4" class="user-name">
                <i class="fa fa-shopping-cart fa-orange"></i>
                <a href="user/toCenter">我的订单</a>

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
                        <li><a href="admin/group">组团游</a></li>
                        <li><a href="admin/scene">景点</a></li>
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
<!--发表游记-->
<div class="xiaomi6 fl">
    发表游记
</div>

<div class="form_content">
    <form id="essayApply" method="post">
        <fieldset>
            <legend class="optional">游记主题</legend>
            <div class="form-row">
                <div class="field-label"><label for="eTitle">游记标题</label>:</div>
                <div class="field-widget">
                    <input id="eTitle" name="eTitle" class="optional">
                </div>
            </div>
            <div class="form-row">
                <div class="field-label"><label for="uid">游记作者</label>:</div>
                <div class="field-widget">
                    <input type="text" readonly="readonly" id="uid" name="uid"  value= "${user.uid}" class="optional">
                </div>
            </div>
            <%--            选择城市--%>
            <div class="form-row">
                <div class="field-label"><label for="cityId">游记城市</label>:</div>
                <!--省份选择-->
                <select id="provinceId">
                    <option>=请选择省份=</option>
                      <c:if test="${!empty proList}">
                        <c:forEach items="${proList}" var="pro">
                        <option value="${pro.provinceId}">${pro.cityName}</option>
                        </c:forEach>
                      </c:if>
                </select>
                <!--城市选择-->
                <select id="cityId" name="cityId">
                    <option>=请选择城市=</option>
                </select>
            </div>

        </fieldset>

        <fieldset>
            <legend>游记信息</legend>

            <div class="form-row">
                <div class="field-label"><label for="eContent">旅游内容</label>:</div>
                <div class="field-widget"><textarea id="eContent" name="eContent" class="required"></textarea></div>
            </div>

        </fieldset>
        <button type="submit" class="submit" onclick="submitApply()">发表</button>
        <%--        <input class="reset" type="button" value="Reset" onclick="valid.reset(); return false" />--%>
    </form>
</div>


<br/><br/><br/><br/><br/><br/>

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

<script type="text/javascript">
    /*页面加载就开始执行*/
    // 省市二级联动
    $(document).ready(function () {
        $("#provinceId").change(function () {
            $.get("user/getCityByPro/"+$("#provinceId").val(),function(data){
                if(data.status){
                    var result = "<option>=请选择城市=</option>";
                    $.each(data.obj,function(n,value){
                        result +="<option value='"+value[0]+"'>"+value[1]+"</option>";
                    });
                    $("#cityId").html('');
                    $("#cityId").append(result);
                }
            },"json");
        });

    });
</script>
<%--发表游记--%>
<script type="text/javascript">

    function submitApply() {
        $.ajax({
            url:'user/addEssay',
            type: "POST",
            data:$("#essayApply").serialize(),
            success:alert("已提交游记"),
            error: function (request, status, error) {
                alert("Ajax请求失败!" + error);
            }
        });
    }

</script>
<script src="./resources/js/jquery_1.9.js"></script>
<script src="./resources/js/main.js"></script>
</body>
</html>
