
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.ssh.jd.model.car.pojo.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车</title>
    <link href="<%=basePath %>css/base.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.6.4.js"></script>
    <script type="text/javascript" language="javascript" >
        function changeBuyQuantity(obj,id) {
            var byStr = document.getElementById(id);
            var byNum = parseInt(byStr.value);

            if (byNum <= 1 && obj == 0) {//参数为0并且数量为1则不能再减
                byStr.value=1;
            } else {
                if (obj == 0)
                    byStr.value = (byNum-1);
                else
                    byStr.value = (byNum+1);
            }

            //请求服务器处理
            location.href = "<%=basePath%>car/carActionaddOrUpdate.action?goodsCode="+id
                +"&quantity="+byStr.value+"";
        }

    </script>

</head>
<body>
<div id="shortcut-2014">
    <div class="w">
        <ul class="fr">
            <li class="fore1" id="ttbar-login" clstag="h|keycount|2015|01b">
                <a href="<%=basePath%>goods/goodsActionloadGoodsTypeList.action" class="link-login  style-red">
                    <c:if test="${not empty sessionScope.currentUser.name }">
                        你好，${sessionScope.currentUser.name }&nbsp;&nbsp;
                        <a href="<%=basePath%>login.jsp"> 退出</a>&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${empty sessionScope.currentUser.name }">
                        <a href="<%=basePath%>login.jsp" style="color: red;">请登录&nbsp;&nbsp;</a>
                    </c:if>
                </a>
            </li>
            <li class="spacer"></li>
            <li class="fore2" clstag="h|keycount|2015|01c">
                <div class="dt">
                    <a href="<%=basePath%>order/orderActionloadOrder.action">我的订单</a>
                </div>
            </li>
            <li class="spacer"></li>
            <li class="fore3" clstag="h|keycount|2015|01c">
                <div class="dt">
                    <a href="<%=basePath%>order/orderActionloadOrder.action">我的趣淘</a>
                </div>
            </li>

        </ul>
        <span class="clr"></span>
    </div>
</div>l
<div class="w header clearfix">
    <div id="logo">
        <a href="<%=basePath%>goods/goodsActionloadGoodsTypeList.action" class="link1"><img src="<%=basePath%>img/logo-201305.png" alt="京东商城"></a>
        <a href="#none" class="link2"><b></b>购物车</a>	</div>
    <div class="cart-search">
        <div class="form">
            <input id="key" type="text" class="itxt" autocomplete="off" accesskey="s" style="color: rgb(153, 153, 153);">
            <input type="button" class="button" value="搜索" clstag="clickcart|keycount|xincart|cart_search" onclick="javascript:void(0);">
        </div>
    </div>
</div>

<div id="container" class="cart">
    <div class="w">
        <div id="chunjie" class="mb10"></div>
        <div class="cart-filter-bar">
            <ul class="switch-cart">
                <li class="switch-cart-item curr">
                    <a href="#none">
                        <em>全部商品</em>
                        <span class="number">${fn:length(sessionScope.car) }</span>
                    </a>
                </li>
            </ul>
            <div class="clr"></div>
            <div class="w-line">
                <div class="floater" style="width: 82px; left: 0px;"></div>
            </div>
            <div class="tab-con ui-switchable-panel-selected" style="display: block;"></div>
            <div class="tab-con hide" style="display: none;"></div>
        </div>
    </div>
    <div class="cart-warp">
        <div class="w">
            <div id="jd-cart">
                <div class="cart-main cart-main-new">
                    <div class="cart-thead">
                        <div class="column t-checkbox">
                            <div class="cart-checkbox">
                                <input type="checkbox" name="toggle-checkboxes" class="jdcheckbox" clstag="clickcart|keycount|xincart|cart_allCheck">
                                <label for="">勾选全部商品</label>
                            </div>
                            全选
                        </div>
                        <div class="column t-goods">商品</div>
                        <!--                         <div class="column t-props"></div>
                         -->                        <div class="column t-price">单价(元)</div>
                        <div class="column t-quantity">数量</div>
                        <div class="column t-sum">小计(元)</div>
                        <div class="column t-action">操作</div>
                    </div>
                    <div id="cart-list">
                        <div class="cart-item-list" id="cart-item-list-01">
                            <div class="cart-tbody" id="vender_66621">
                                <div class="shop">
                                    <div class="cart-checkbox">
                                        <!--                                         <input type="checkbox" name="checkShop" class="jdcheckbox" clstag="clickcart|keycount|xincart|cart_checkOn_shop">
                                         -->                                        <label for="">勾选店铺内全部商品</label>
                                    </div>
                                </div>
                                <div class="item-list" style="z-index: auto;">
                                    <!--单品-->
                                    <!-- 单品-->
                                    <!-- 单品-->
                                    <!-- 单品-->
                                    <!-- 单品-->
                                    <c:forEach items="${sessionScope.car }" var="goods">
                                        <div class="item-single  item-item item-selected  " id="" >
                                            <div class="item-form">
                                                <div class="cart-checkbox">
                                                    <!--单品-->

                                                    <input p-type="10124632023_1" type="checkbox" name="checkItem" value="10124632023_1" checked="checked" data-bind="cbid" class="jdcheckbox" clstag="clickcart|keycount|xincart|cart_checkOn_sku">
                                                    <label for="" class="checked">勾选商品</label>
                                                    <span class="line-circle"></span>
                                                    <!--                                      <input type="checkbox" name="checkShop" class="jdcheckbox" clstag="clickcart|keycount|xincart|cart_checkOn_shop">
                                                     -->                                                </div>
                                                <div class="cell p-goods">
                                                    <div class="goods-item">
                                                        <div class="p-img">
                                                            <a href="<%=basePath%>goods/goodsActionloadGoodsDetails.action?goodsCode=${goods.goodsCode}" target="_blank" class="J_zyyhq_10124632023">
                                                                <img alt="" src="<%=basePath%>imgs/${goods.img}.jpg" style="width:80px;height:80px"></a>
                                                        </div>
                                                        <div class="item-msg">
                                                            <div class="p-name">
                                                                <a clstag="clickcart|keycount|xincart|cart_sku_name" href="goodsdetails.html" target="_blank">
                                                                        ${goods.goodsName }
                                                                </a>
                                                            </div>
                                                            <div class="p-extend">
							<span class="promise" _giftcard="giftcard_10124632023">
							</span>

                                                                <span class="promise" _yanbao="yanbao_10124632023_">
								<i class="jd-service-icon"></i>
								<a href="#none" class="ftx-03 jd-service" clstag="clickcart|keycount|xincart|cart_fuWu" data-tips="购买京东服务">购买京东服务
								        ${goods.producer }
								</a>
							</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="cell p-price">
                                                    <strong>${goods.price }&nbsp;&nbsp;&nbsp;</strong>
                                                </div>
                                                <div class="cell p-quantity">
                                                    <!--单品-->
                                                    <div class="quantity-form">

                                                        <a href="javascript:void(0);" clstag="clickcart|keycount|xincart|cart_num_down" onclick="changeBuyQuantity(0,'${goods.goodsCode}')" class="decrement" >-</a>
                                                        <input id="${goods.goodsCode }" autocomplete="off" type="text" class="itxt" value="${goods.quantity }">
                                                        <a href="javascript:void(0);" clstag="clickcart|keycount|xincart|cart_num_up" onclick="changeBuyQuantity(1,'${goods.goodsCode}')"  class="increment" id="increment_66621_10124632023_1_1_0">+</a>

                                                    </div>
                                                    <div class="ac ftx-03 quantity-txt" _stock="stock_10124632023">有货</div>
                                                </div>
                                                <div class="cell p-sum">
                                                    <strong>${goods.subtotal }</strong>
                                                </div>
                                                <div class="cell p-ops">
                                                    <!--单品-->
                                                    <a id="remove_66621_10124632023_1" clstag="clickcart|keycount|xincart|cart_sku_del"
                                                       data-name=""
                                                       data-more="removed_78.00_1" class="cart-remove"
                                                       href="<%=basePath%>car/carActionremoveSingleGoods.action?goodsCode=${goods.goodsCode}">删除</a>
                                                </div>
                                            </div>
                                            <div class="item-extra">
                                            </div>
                                            <div class="item-line"></div>
                                        </div>
                                    </c:forEach>
                                    <!-- 单品-->
                                    <!-- 单品-->
                                    <!-- 单品-->
                                    <!-- 单品-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clr"></div>
            <div id="cart-floatbar" style="position: relative; top:60px;">
                <div class="ui-ceilinglamp-1" style="width: 990px; height: 52px;"><div class="cart-toolbar" style="width: 988px; height: 50px;">
                    <div class="toolbar-wrap">
                        <div class="selected-item-list hide" style="display: none;">
                        </div>
                        <div class="options-box">
                            <div class="select-all">
                                <div class="cart-checkbox">
                                    <input type="checkbox" id="toggle-checkboxes_down" name="toggle-checkboxes" class="jdcheckbox" clstag="clickcart|keycount|xincart|cart_allCheckDown">
                                    <label for="">勾选全部商品</label>
                                </div>
                                全选
                            </div>
                            <div class="operation">
                                <a href="#none" clstag="clickcart|keycount|xincart|cart_somesku_del" class="remove-batch">删除选中的商品</a>
                            </div>
                            <div class="clr"></div>
                            <div class="toolbar-right">
                                <div class="normal">
                                    <div class="comm-right">
                                        <div class="btn-area">
                                            <a href="<%=basePath %>jiesuan.jsp" target="_blank" class="submit-btn" data-bind="1">
                                                去结算
                                                <b></b>
                                            </a>
                                            <!-- <a href="javascript:void(0);" class="submit-btn submit-btn-disabled">
                                            去结算<b></b></a> -->
                                        </div>
                                        <div class="price-sum">
                                            <div>
                                                <span class="txt">总价（不含运费）：</span>
                                                <span class="price sumPrice">
                                                <em>

                                                <%=((Car)session.getAttribute("car")).getTotal()%>

                                                </em></span>
                                            </div>
                                        </div>

                                        <div class="clr"></div>
                                    </div>
                                    <div class="clr"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div></div>
            </div>
        </div>
    </div>
</div>
<div class="clr"></div>
<footer  style="position: relative; top: 90px">
    <div id="service-2014" clstag="h|keycount|2015|32a">
        <div class="slogen">
		<span class="item fore1">
			<img src="<%=basePath%>img/service_items_1.png" style="margin-left: 40px">
		</span>
            <span class="item fore2">
			<img src="<%=basePath%>img/service_items_2.png" style="margin-left: 80px" >
		</span>
            <span class="item fore3">
			<img src="<%=basePath%>img/service_items_3.png" style="margin-left: 80px">
		</span>
            <span class="item fore4">
			<img src="<%=basePath%>img/service_items_4.png" style="margin-left: 80px">
		</span>
        </div>
    </div>
    <div id="footer-2014" clstag="h|keycount|2015|33a">
        <div class="links"><a rel="nofollow" target="_blank" href="#">关于我们</a>|<a rel="nofollow" target="_blank" href="#">联系我们</a>|<a rel="nofollow" target="_blank" href="#">商家入驻</a>|<a rel="nofollow" target="_blank" href="#">营销中心</a>|<a rel="nofollow" target="_blank" href="#">手机趣淘</a>|<a target="_blank" href="#">友情链接</a>|<a target="_blank" href="#">销售联盟</a>|<a href="//club.jd.com/" target="_blank">趣淘社区</a>|<a href="#" target="_blank">趣淘公益</a>|<a href="#" target="_blank">English Site</a>|<a href="#" target="_blank">Contact Us</a></div>
        <div class="copyright"><a target="_blank" href="<%=basePath%>img/56a0a994Nf1b662dc.png"> 京公网安备 11000002000088号</a>&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;<a target="_blank" href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>&nbsp;&nbsp;|&nbsp;&nbsp;新出发京零&nbsp;字第大120007号<br>互联网出版许可证编号新出网证(京)字150号&nbsp;&nbsp;|&nbsp;&nbsp;<a rel="nofollow" href="#" target="_blank">出版物经营许可证</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a>&nbsp;&nbsp;|&nbsp;&nbsp;违法和不良信息举报电话：4006561155<br>Copyright&nbsp;?&nbsp;2004&nbsp;-&nbsp;2016&nbsp;&nbsp;趣淘QT.com&nbsp;版权所有&nbsp;&nbsp;|&nbsp;&nbsp;消费者维权热线：4006067733<br>趣淘旗下网站：<a href="#" target="_blank">趣淘钱包</a>
        </div>
        <div class="authentication">
            <a rel="nofollow" target="_blank" href="#">
                <img width="103" height="32" alt="经营性网站备案中心" src="<%=basePath%>img/54b8871eNa9a7067e.png" class="err-product">
            </a>

            <a rel="nofollow" target="_blank" id="urlknet" tabindex="-1" href="#">
                <img border="true" width="103" height="32" alt="可信网站" src="<%=basePath%>img/54b8872dNe37a9860.png" class="err-product">
            </a>
            <a rel="nofollow" target="_blank" href="#">
                <img width="103" height="32" alt="网络警察" src="<%=basePath%>img/56a89b8fNfbaade9a.jpg" class="err-product">
            </a>
            <a rel="nofollow" target="_blank" href="#">
                <img width="103" height="32" src="<%=basePath%>img/54b8875fNad1e0c4c.png" class="err-product">
            </a>
            <a target="_blank" href="#"><img width="103" height="32" src="<%=basePath%>img/5698dc03N23f2e3b8.jpg"></a>
            <a target="_blank" href="#"><img width="103" height="32" src="<%=basePath%>img/5698dc16Nb2ab99df.jpg"></a>
        </div>
    </div>
</footer>
</body>
</html>
