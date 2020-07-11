<%@ page import="club.banyuan.eneity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="club.banyuan.eneity.Auction" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="club.banyuan.eneity.User" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/8
  Time: 8:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap" >
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>

    <div class="items sg-font lf">
        <%
            Product product=(Product) session.getAttribute("product");
        %>
        <ul class="rows">
            <li>名称：</li>
            <li class="borderno"><%=product.getPname()%></li>
        </ul>
        <ul class="rows">
            <li>描述：</li>
            <li class="borderno"><%=product.getDescription()%></li>
        </ul>
        <ul class="rows">
            <li>开始时间：</li>
            <li class="borderno"><%=product.getBeginTime()%></li>
        </ul>
        <ul class="rows">
            <li>结束时间：</li>
            <li class="borderno"><%=product.getEndTime()%></li>
        </ul>
        <ul class="rows border-no">
            <li>起拍价：</li>
            <li class="borderno"><%=product.getBeginprice()%></li>
        </ul>
    </div>
    <div class="rg borders"><img src="images/ad20.jpg" width="270" height="185" alt="" /></div>
    <div class="cl"></div>
    <div class="top10 salebd">
        <form action="addauction.do">
        <p>
            <label for="sale">出价：</label>
            <input type="text" name="price"  class="inputwd" id="sale" value="<%=product.getBeginprice()%>"/>
            <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
        </p>
        <p class="f14 red">不能低于最高竞拍价</p>
        </form>
    </div>
    <div class="top10">
        <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
        <input name="" type="submit" value="返回列表" class="spbg buttombg f14" />
    </div>
    <div class="offer">
        <h3>出价记录</h3>
        <div class="items sg-font">
            <ul class="rows even strong">
                <li>竞拍时间</li>
                <li>竞拍价格</li>
                <li class="borderno">竞拍人</li>
            </ul>
        <%

            List<Auction> auctionList=(List<Auction>)session.getAttribute("auctionList");
            for(Auction auction:auctionList){
        %>
            <ul class="rows">
                <li><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(auction.getAuctiontime())%></li>
                <li><%=auction.getPrice()%></li>
                <li class="borderno"><%=auction.getLoginName()%></li>
            </ul>
        <%
            }
        %>
        </div>
    </div>
    <!-- main end-->
</div>
</body>
</html>

