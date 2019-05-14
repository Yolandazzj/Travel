<%--
  Created by IntelliJ IDEA.
  User: zyr
  Date: 2019/5/13
  Time: 9:48
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
    <title>酒店预定</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <link title="style1" rel="stylesheet" href="./resources/css/groupStyle.css" type="text/css" />
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
                        <li><a href="user/group">组团游</a></li>
                        <li><a href="user/scene">景点</a></li>
                        <li><a href="user/essay">攻略</a></li>
                        <li><a href="user/hotel">酒店</a></li>
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

<div class="xiaomi6 fl">
    酒店预定
</div>

<div class="form_content">
    <form id="groupApply" method="post">
        <fieldset>
            <legend>PERSONAL INFORMATION</legend>
            <div class="form-row">
                <div class="field-label"><label for="uid">账户名</label>:</div>
                <div class="field-widget"><input type="text" readonly="readonly" id="uid" name="uid"  value= "${user.uid}" class="required"></div>
            </div>
        </fieldset>

        <fieldset>
            <legend class="optional">ORDER INFORMATIONS</legend>
            <%--            选择城市--%>
            <div class="form-row">
                <div class="field-label"><label for="cityId">旅游城市</label>:</div>
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

            <div class="form-row">
                <div class="field-label"><label for="hotelId">酒店名称</label>:</div>
                <select id="hotelId">
                    <option >=请选择酒店=</option>
                </select>
                <input  type="hidden" name="hotelName" id="hotelName">
            </div>
            <div class="form-row">
                <div class="field-label"><label for="layoutSize">酒店房型</label>:</div>
                <select id="layoutSize">
                    <option >=请选择房型=</option>
                </select>

                <input id="layoutPrice" readonly="readonly" value="价格">

            </div>
            <div class="form-row">
                <div class="field-label"><label for="orderpeople">预定人数</label>:</div>
                <div class="field-widget">
                    <a style="border: 1px solid #adedad;" class="bd-box subtraction min" onclick="changerBuyQuantity(0)" href="javascript:;">-</a>

                    <input style="background-color:#f3fef3;border: 1px solid #adedad; height: 27.98px" id="orderpeople" name="orderpeople" class="bd-box number-box" value="1" readonly="readonly"  onkeyup="setAmount.modify('#orderpeople');"/>
                    <a style="background-color:#f3fef3;border: 1px solid #adedad;" class="bd-box addition add" style="height: 32px;" onclick="changerBuyQuantity(1)" href="javascript:;">+</a>
                </div>

            </div>
            <div class="form-row">
                <div class="field-label"><label for="orderday">预定天数</label>:</div>
                <div class="field-widget">
                    <a style="border: 1px solid #adedad;" class="bd-box subtraction min" onclick="changerByDay(0)" href="javascript:;">-</a>

                    <input style="background-color:#f3fef3;border: 1px solid #adedad; height: 27.98px" id="orderday" name="orderday" class="bd-box number-box" value="1" readonly="readonly"  onkeyup="setAmount.modify('#orderpeople');"/>
                    <a style="background-color:#f3fef3;border: 1px solid #adedad;" class="bd-box addition add" style="height: 32px;" onclick="changerByDay(1)" href="javascript:;">+</a>
                </div>
            </div>
            <div class="form-row">
                <div class="field-label"><label for="hotelPrice">预定价格</label>:</div>
                <div class="field-widget"><input type="text" readonly="readonly" onclick="javascript:calculate()" id="hotelPrice" name="hotelPrice" class="required" value="0"></div>
            </div>


        </fieldset>

        <fieldset>
            <legend>CONTACT INFORMATION</legend>

            <div class="form-row">
                <div class="field-label"><label for="ordername">预定人姓名</label>:</div>
                <div class="field-widget"><input name="ordername" id="ordername" class="required" title="Enter your name" /></div>
            </div>

            <div class="form-row">
                <div class="field-label"><label for="contact">预定联系方式</label>:</div>
                <div class="field-widget"><input type="text" name="contact" id="contact" class="required" title="Enter your contact"><span id="sj"></span></div>
            </div>
<%--            <input  type="hidden" name="uid" value="${user.uid}" id="uid">--%>
        </fieldset>
        <input class="jrgwc"  type="button" value="预定" onclick="javascript:toOrder();" id="sub" />
        <%--        <input class="reset" type="button" value="Reset" onclick="valid.reset(); return false" />--%>
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

<script type="text/javascript">
    /*页面加载就开始执行*/
    // 省市二级联动
    $(document).ready(function () {
        $("#provinceId").change(function () {
            $.get("user/getCityByPro/"+$("#provinceId").val(),function(data){
                if(data.status){
                    var result = "<option>=请选择城市=</option>";
                    $.each(data.obj,function(n,value){
                        result +="<option value='"+value[0]+"' >"+value[1]+"</option>";
                    });
                    $("#cityId").html('');
                    $("#cityId").append(result);
                }
            },"json");
        });

    });
</script>
<script type="text/javascript">

    $("#hotelId").change(
        function () {
            $("#hotelName").val($("#hotelId").find("option:selected").attr("hotel"));
        }
    );
    $(document).ready(function () {
        $("#cityId").change(function () {
            $.get("user/toGetHotel/"+$("#cityId").val(),function(data){
                if(data.status){
                    var result = "<option>=请选择酒店=</option>";
                    $.each(data.obj,function(n,value){
                        result +="<option value='"+value[0]+"' hotel='"+value[1]+"'>"+value[1]+"</option>";
                    });
                    $("#hotelId").html('');
                    $("#hotelId").append(result);
                }
            },"json");
        });

    });
</script>
<script>
         var int=self.setInterval("calculate()",50)
        function calculate() {
            // alert($("#layoutPrice").val());
            // alert($("#orderday").val())
            parseInt( $("#hotelPrice").val((parseInt($("#layoutPrice").val()))*(parseInt($("#orderday").val()))));
        }
</script>
<script type="text/javascript">
    $("#layoutSize").change(
      function () {
          $("#layoutPrice").val($("#layoutSize").find("option:selected").attr("price"));
      }
    );

    $(document).ready(function () {
        $("#hotelId").change(function () {
            // alert("change")
            $.get("user/toGetLayout/"+$("#hotelId").val(),function(data){
                // alert("2");
                if(data.status){
                    var result = "<option>=请选择房型=</option>";
                    // alert(data.obj.length)
                    $.each(data.obj,function(n,value){
                        result +="<option value='"+value[0]+"' price='"+value[1]+"'>"+value[2]+"</option>";
                    });
                    $("#layoutSize").html('');
                    $("#layoutSize").append(result);
                }
            },"json");
        });

    });
</script>
<%--提交申请--%>
<script type="text/javascript">

    function submitApply() {
        $.ajax({
            url:'user/submitGroup',
            type: "POST",
            data:$("#groupApply").serialize(),
            success:alert("已提交申请"),
            error: function (request, status, error) {
                alert("Ajax请求失败!" + error);
            }
        });
    }

</script>
<script>

    function changerBuyQuantity(obj) {
        if (obj === 1) {
            $("#orderpeople").val(parseInt($("#orderpeople").val()) + 1);
        } else {
            if ($("#orderpeople").val() <= 1)
                $("#orderpeople").val(1);
            else
                $("#orderpeople").val($("#orderpeople").val() - 1);
        }
    }

</script>
<script>

    function changerByDay(obj) {
        if (obj === 1) {
            $("#orderday").val(parseInt($("#orderday").val()) + 1);
        } else {
            if ($("#orderday").val() <= 1)
                $("#orderday").val(1);
            else
                $("#orderday").val($("#orderday").val() - 1);
        }
    }

</script>

<script type="text/javascript">

    function getHotel(cityId) {
        $.ajax({
            url:'user/toGetHotel',
            type: "POST",
            data: {"cityId": cityId},
            success:alert("已获取到"),
            error: function (request, status, error) {
                alert("Ajax请求失败!" + error);
            }
        });
    }

</script>
<script>

    function toOrder(){
        var hotelId = $("#hotelId").val();
        var hotelName = $("#hotelName").val();
        var contact=$("#contact").val();
        var orderDay=$("#orderday").val();
        var hotelPrice=(parseFloat($("#hotelPrice").val()));
        var orderName=$("#ordername").val();
        var orderPeople=$("#orderpeople").val();
        var uid=$("#uid").val();



        location.href = "<%=request.getContextPath()%>/user/submitOrder?hotelId="+hotelId
            +"&hotelName="+hotelName+"&contact="+contact+"&orderDay="+orderDay+"&hotelPrice="+hotelPrice+"&orderName="+orderName+"&orderPeople="+orderPeople+"&uid"+uid+"";
    }
</script>
<script  type="text/javascript">
    function checkMobile(str) {
        var  re = /^1\d{10}$/ //验证是不是11位数字
        if (re.test(str)) {
            $("#sj").html("手机号码格式正确");
            $("#sj").css("color","green");
        }
        else {
            $("#sj").html("手机号码格式错误");
            $("#sj").css("color","red");
            $("#sub").prop("disabled",true);
        }
    }
</script>
</body>
</html>

