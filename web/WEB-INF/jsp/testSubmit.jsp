function addGoodsToCar(){
var goodsCode = $("#goodsCode").val();//获取商品编号
var buyNum = $("#buy-num").val();//获取购买数量

location.href = "<%=basePath%>car/carActionaddOrUpdate.action?goodsCode="+goodsCode
+"&quantity="+buyNum+"";
}
<a onclick="javascript:addGoodsToCar()" id="InitCartUrl"
   class="btn-special1 btn-lg" href="#"  >加入购物车</a>