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
    <base href="${pageContext.request.contextPath}/">
    <meta charset="UTF-8">
    <title>途牛旅行</title>
    <link rel="stylesheet" href="./resources/css/reset.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./resources/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="./resources/css/list.css"/>
    <link rel="stylesheet" type="text/css" href="./resources/css/manhuaDate.1.0.css"/>
    <script type="text/javascript" src="./resources/js/jquery-1.5.1.js"></script><!--日期控件，JS库版本不能过高否则tab会失效-->
    <script type="text/javascript" src="./resources/js/datejs.js"></script>
    <script type="text/javascript" src="./resources/js/shaixuan.js"></script>
    <script type="text/javascript" src="./resources/js/ui.tab.js"></script>
    <script src="./resources/js/jquery-2.1.4.min.js"></script>


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
                <li class="drop-down"><a href="#">我的账户</a><span class="down-icon"></span>
                    <ul class="user-toggle-box">
                        <li><a href="#">个人中心</a></li>
                        <li><a href="#">修改信息</a></li>
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
    <div class="nav" style="border-bottom: 2px solid rgba(0,128,0,0.5);width: 760px;">

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
<br><br><br><br><br><br>

<!----筛选框-->
<div class="w1200">
    <div class="list-screen">
        <div style="padding:10px 30px 10px 10px;"><div class="screen-address">
            <div class="list-tab">
                <div id="demo1" class="clearfix">
                    <div class="jiud-name">类型</div>
                    <div class="ui-tab-container">
                        <ul class="clearfix ui-tab-list">
                            <li><a href="javascript:ajaxbyScore('${keyword}')">按好评</a></li>
<%--                            <li><a href="javascript:ajaxbyNumber('${keyword}')">按销量</a></li>--%>
                        </ul>

            </div>
        </div>
            <div class="screen-term">
                <div class="selectNumberScreen">
                    <div id="selectList" class="screenBox screenBackground">

                        <dl class="listIndex" attr="价格范围">
                            <dt>路线价格</dt>
                            <dd>
                                <label><a href="javascript:ajaxByNo('${keyword}');">不限</a></label>
                                <label>
                                    <input name="routePrice" type="radio" value="100" />
                                    <a href="javascript:ajaxByPrice1('${keyword}')">1000元以下</a></label>
                                <label>
                                    <input name="routePrice" type="radio" value="300" />
                                    <a href="javascript:ajaxByPrice2('${keyword}')"> 1000-2000元 </a></label>
                                <label>
                                    <input name="routePrice" type="radio" value="601" />
                                    <a href="javascript:ajaxByPrice3('${keyword}')">2000元以上</a></label>

                            </dd>
                        </dl>

<%--                        <dl class=" listIndex" attr="terminal_os_s">--%>
<%--                            <dt>出行天数</dt>--%>
<%--                            <dd>--%>
<%--                                <label>--%>
<%--                                    <input type="hidden" name="routeDay"/>--%>
<%--                                    <a href="javascript:;">不限</a>--%>
<%--                                </label>--%>
<%--                                <label>--%>
<%--                                    <input name="routeDay" type="checkbox" value="1" autocomplete="off"/>--%>
<%--                                    <a href="javascript:;" >1</a> </label>--%>
<%--                                <label>--%>
<%--                                    <input name="routeDay" type="checkbox" value="2" autocomplete="off"/>--%>
<%--                                    <a href="javascript:;" >2</a></label>--%>
<%--                                <label>--%>
<%--                                    <input name="routeDay" type="checkbox" value="3" autocomplete="off"/>--%>
<%--                                    <a href="javascript:;">3</a></label>--%>

<%--                            </dd>--%>
<%--                        </dl>--%>



                    </div>
                </div>
            </div>

        </div>

        <div class="hasBeenSelected clearfix">
            <div style="float:right;" class="eliminateCriteria">【清空全部】 </div>
<%--            <dl>--%>
<%--                <dt>已选条件：</dt>--%>
<%--                <dd style="DISPLAY: none" class=clearDd>--%>
<%--                    <div class=clearList></div>--%>
<%--            </dl>--%>
        </div>
        <script type="text/javascript" src="./resources/js/shaixuan.js"></script>
    </div>
</div>
    </div>
</div>

<br><br>
<!--main-->
<div class="main" style="height: 3000px;">
    <table class="main-left" style="height: 250px;" id="routeHidden">
        <tr class="main-title">
                    <th style="color: rgba(0,128,0,0.8);background-color: white">${keyword}<span class="show-title"></span></th>
        </tr>
        <c:forEach items="${searchListByRoute}" var="sr">
        <tr class="product-box" style="width:788px;height: 200px;">
            <td class="inner-info" style="width: 790px;height: 202px;">

                <div class="inner-left" style="height: 200px;margin-top: 0">
                    <a href="user/routesDetails?routeId=${sr.routeId}&routeName=${sr.routeName}"><img src="/IMAGE/${sr.routeImage}"  style="width: 150px;height: 140px;"/></a>
                    <h1><a href="user/routesDetails?routeId=${sr.routeId}&routeName=${sr.routeName}"><${sr.routeName}></a></h1>
                    <p>已有${sr.routeScore}人点赞过啦！</p>
                </div>
                <div class="inner-right" style="width: 600px;height: 150px;">
                    <div>
                        <a href="#">
                            <a href="user/routesDetails?routeId=${sr.routeId}&routeName=${sr.routeName}&cityId=${sr.city.cityId}">${sr.routeContent}</a>
                        </a>

                    </div>

                </div>
            </td>
        </tr>
        </c:forEach>

    </table>
<div class="clear"></div>
    <br><br><br>

    <form id="paging" style="width: 791px;height:50px; text-align: center" method="post">
        <tr>
            <td colspan="8" align="center" >共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页
                <br> <br>

                <a id="firstPage" href="user/searchAll?pageNo=${page.topPageNo}&keyword=${keyword}"><input type="button" name="fristPage" value="首页" /></a>

                <c:choose>
                    <c:when test="${page.pageNo!=1}">

                        <a id="previousPage" href="user/searchAll?pageNo=${page.previousPageNo}&keyword=${keyword}"><input type="button" name="previousPage" value="上一页" /></a>

                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="previousPage" value="上一页" />

                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNo!= page.totalPages}">
                        <a id="nextPage" href="user/searchAll?pageNo=${page.nextPageNo}&keyword=${keyword}"><input type="button" name="nextPage" value="下一页" /></a>
                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="nextPage" value="下一页" />

                    </c:otherwise>
                </c:choose>
                <a  id="lastPage" href="user/searchAll?pageNo=${page.bottomPageNo }&keyword=${keyword}"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
    </form>

    <br> <br> <br>
    <table class="main-left" style="height: 250px;" id="essayHidden">
        <tr class="main-title">
            <th style="color: rgba(0,128,0,0.8);background-color: white">${keyword}攻略<span class="show-title"></span></th>
        </tr>
        <c:forEach items="${searchListByEssay}" var="se">
            <tr class="product-box" style="width:788px;height: 200px;">
                <td class="inner-info" style="width: 790px;height: 202px;">

                    <div class="inner-left" style="height: 200px;margin-top: 0;">
                        <a href="#"><img src="/IMAGE/scene/3.jpg" style="width: 168px;height: 200px;"/></a>
                        <h1><a href="#"><${se[1]}></a></h1>
                        <p>已有${se[2]}人点赞过啦！</p>
                    </div>
                    <div class="inner-right" style="width: 600px;height: 150px;">
                        <div>
                            <a href="#">
                                <a href="#">${se[5]}</a>
                            </a>

                        </div>

                    </div>
                </td>
            </tr>
        </c:forEach>

    </table>

    <div class="clear"></div>

    <br> <br> <br> <br> <br> <br>
    <table class="main-left" style="height: 250px;" id="hotelHidden">
        <tr class="main-title">
            <th style="color: rgba(0,128,0,0.8);background-color: white;">${keyword}酒店<span class="show-title"></span></th>
        </tr>
        <c:forEach items="${searchListByHotel}" var="sh">
            <tr class="product-box" style="width:788px;height: 200px;">
                <td class="inner-info" style="width: 790px;height: 202px;">

                    <div class="inner-left" style="height: 200px;margin-top: 0">
                        <a href="#"><img src="/IMAGE/${sh[6]}" style="width: 150px;height: 140px;"/></a>
                        <h1><a href="#"><${sh[1]}></a></h1>
                        <p>已有${sh[5]}人点赞过啦！</p>
                    </div>
                    <div class="inner-right" style="width: 600px;height: 150px;">
                        <div>
                            <a href="#">
                                <a href="#">${sh[3]}起，${sh[4]}星级酒店！</a>
                            </a>

                        </div>

                    </div>
                </td>
            </tr>
        </c:forEach>

    </table>

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
            $(document).ready(function(){
                var tab = new $.fn.tab({
                    tabList:"#demo1 .ui-tab-container .ui-tab-list li",
                    contentList:"#demo1 .ui-tab-container .ui-tab-content"
                });
                var tab = new $.fn.tab({
                    tabList:"#demo1 .ui-tab-container .ui-tab-list2 li",
                    contentList:"#demo1 .ui-tab-container .ui-tab-content2"
                });
            });
        </script>
<%--        <script type="text/javascript">--%>
<%--            $(function (){--%>
<%--                $("input.mh_date").datejs({--%>
<%--                    Event : "click",//可选--%>
<%--                    Left : 0,//弹出时间停靠的左边位置--%>
<%--                    Top : -16,//弹出时间停靠的顶部边位置--%>
<%--                    fuhao : "-",//日期连接符默认为---%>
<%--                    isTime : false,//是否开启时间值默认为false--%>
<%--                    beginY : 2010,//年份的开始默认为1949--%>
<%--                    endY :2015//年份的结束默认为2049--%>
<%--                });--%>

<%--            });--%>
<%--        </script>--%>
<%--        <script type="text/javascript">--%>
<%--            $(document).ready(function(e) {--%>
<%--                $("#selectList").find(".more").toggle(function(){--%>
<%--                    $(this).addClass("more_bg");--%>
<%--                    $(".more-none").show()--%>
<%--                },function(){--%>
<%--                    $(this).removeClass("more_bg");--%>
<%--                    $(".more-none").hide()--%>
<%--                });--%>
<%--            });--%>
<%--        </script>--%>
        <script type="text/javascript">
            $(document).ready(function(){
                var taboy_box=$(".lefttable-list");
                taboy_box.children("tbody").find("tr:gt(2)").hide();
                $(".leftbox-morea").toggle(function(){
                        $(this).parent().prev().find("tr").show();
                        $(this).addClass("more-i")
                    },function(){
                        $(this).removeClass("more-i");
                        $(this).parent().prev().children("tbody").find("tr:gt(2)").hide();
                    }
                );
            });
        </script>


<!-------好评分类---------->
<script>
    function ajaxbyScore(keyword) {
        $.ajax({
            url: 'user/keywordByScore',
            type:"POST",
            data:{"keyword":keyword},
            success: function (list) {
                $("#routeHidden").empty();
                $("#routeHidden").append("<tr class=\"main-title\"><th style=\"color: rgba(0,128,0,0.8);background-color: white\">"
                   +keyword+"<span class=\"show-title\"></span></th></tr>");
                $.each(list, function (index, route,page) {
                    var str ="<tr class=\"product-box\" style=\"width:788px;height: 200px;\"><td class=\"inner-info\" style=\"width: 790px;height: 202px;\"><div class=\"inner-left\" style=\"height: 200px;margin-top: 0\"> <a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><img src='/IMAGE/"
                        +route.routeImage+"' style=\"width: 150px;height: 140px;\"/></a><h1><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><"
                        +route.routeName+"></a></h1><p>已有"
                        +route.routeScore+"人点赞过啦！</p></div><div class=\"inner-right\" style=\"width: 600px;height: 150px;\"><div><a href=\"#\"><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+">"
                        +route.routeContent+"</a></a></div></div></td></tr>";
                    $("#routeHidden").append(str);


                });


            },
            error: function (request, status, error) {
                alert("Ajax请求失败!!!" + error);
            }
        });
    }
</script>


<script>
    function ajaxByPrice1(keyword) {
        $.ajax({
            url: 'user/keywordByPrice1',
            type:"POST",
            data:{"keyword":keyword},
            success: function (list) {
                $("#routeHidden").empty();
                $("#routeHidden").append("<tr class=\"main-title\"><th style=\"color: rgba(0,128,0,0.8);background-color: white\">"
                    +keyword+"<span class=\"show-title\"></span></th></tr>");
                $.each(list, function (index, route) {
                    var str ="<tr class=\"product-box\" style=\"width:788px;height: 200px;\"><td class=\"inner-info\" style=\"width: 790px;height: 202px;\"><div class=\"inner-left\" style=\"height: 200px;margin-top: 0\"> <a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><img src='/IMAGE/"
                        +route.routeImage+"' style=\"width: 150px;height: 140px;\"/></a><h1><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><"
                        +route.routeName+"></a></h1><p>已有"
                        +route.routeScore+"人点赞过啦！</p></div><div class=\"inner-right\" style=\"width: 600px;height: 150px;\"><div><a href=\"#\"><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+">"
                        +route.routeContent+"</a></a></div></div></td></tr>";
                    $("#routeHidden").append(str);


                });


            },
            error: function (request, status, error) {
                alert("Ajax请求失败!!!" + error);
            }
        });
    }
</script>

<script>
    function ajaxByPrice2(keyword) {
        $.ajax({
            url: 'user/keywordByPrice2',
            type:"POST",
            data:{"keyword":keyword},
            success: function (list) {
                $("#routeHidden").empty();
                $("#routeHidden").append("<tr class=\"main-title\"><th style=\"color: rgba(0,128,0,0.8);background-color: white\">"
                    +keyword+"<span class=\"show-title\"></span></th></tr>");
                $.each(list, function (index, route) {
                    var str ="<tr class=\"product-box\" style=\"width:788px;height: 200px;\"><td class=\"inner-info\" style=\"width: 790px;height: 202px;\"><div class=\"inner-left\" style=\"height: 200px;margin-top: 0\"> <a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><img src='/IMAGE/"
                        +route.routeImage+"' style=\"width: 150px;height: 140px;\"/><h1><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><"
                        +route.routeName+"></a></h1><p>已有"
                        +route.routeScore+"人点赞过啦！</p></div><div class=\"inner-right\" style=\"width: 600px;height: 150px;\"><div><a href=\"#\"><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+">"
                        +route.routeContent+"</a></a></div></div></td></tr>";
                    $("#routeHidden").append(str);


                });


            },
            error: function (request, status, error) {
                alert("Ajax请求失败!!!" + error);
            }
        });
    }
</script>

<script>
    function ajaxByPrice3(keyword) {
        $.ajax({
            url: 'user/keywordByPrice3',
            type:"POST",
            data:{"keyword":keyword},
            success: function (list) {
                $("#routeHidden").empty();
                $("#routeHidden").append("<tr class=\"main-title\"><th style=\"color: rgba(0,128,0,0.8);background-color: white\">"
                    +keyword+"<span class=\"show-title\"></span></th></tr>");
                $.each(list, function (index, route) {
                    var str ="<tr class=\"product-box\" style=\"width:788px;height: 200px;\"><td class=\"inner-info\" style=\"width: 790px;height: 202px;\"><div class=\"inner-left\" style=\"height: 200px;margin-top: 0\"> <a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><img src='/IMAGE/"
                        +route.routeImage+"' style=\"width: 150px;height: 140px;\"/><h1><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><"
                        +route.routeName+"></a></h1><p>已有"
                        +route.routeScore+"人点赞过啦！</p></div><div class=\"inner-right\" style=\"width: 600px;height: 150px;\"><div><a href=\"#\"><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+">"
                        +route.routeContent+"</a></a></div></div></td></tr>";
                    $("#routeHidden").append(str);


                });


            },
            error: function (request, status, error) {
                alert("Ajax请求失败!!!" + error);
            }
        });
    }
</script>

<script>
    function ajaxByNo(keyword) {
        $.ajax({
            url: 'user/searchByNo',
            type:"POST",
            data:{"keyword":keyword},
            success: function (list) {
                $("#routeHidden").empty();
                $("#routeHidden").append("<tr class=\"main-title\"><th style=\"color: rgba(0,128,0,0.8);background-color: white\">"
                    +keyword+"<span class=\"show-title\"></span></th></tr>");
                $.each(list, function (index, route) {
                    var str ="<tr class=\"product-box\" style=\"width:788px;height: 200px;\"><td class=\"inner-info\" style=\"width: 790px;height: 202px;\"><div class=\"inner-left\" style=\"height: 200px;margin-top: 0\"> <a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><img src='/IMAGE/"
                        +route.routeImage+"' style=\"width: 150px;height: 140px;\"/><h1><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+"><"
                        +route.routeName+"></a></h1><p>已有"
                        +route.routeScore+"人点赞过啦！</p></div><div class=\"inner-right\" style=\"width: 600px;height: 150px;\"><div><a href=\"#\"><a href=user/routesDetails?routeId="
                        +route.routeId+"&routeName="
                        +route.routeName+">"
                        +route.routeContent+"</a></a></div></div></td></tr>";
                    $("#routeHidden").append(str);


                });


            },
            error: function (request, status, error) {
                alert("Ajax请求失败!!!" + error);
            }
        });
    }
</script>
    </body>
</html>