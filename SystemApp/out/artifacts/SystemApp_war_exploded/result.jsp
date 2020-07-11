<%@ page import="club.banyuan.eneity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="club.banyuan.eneity.Product" %>
<%@ page import="club.banyuan.service.AuctionService" %>
<%@ page import="club.banyuan.service.impl.AuctionServiceImpl" %>
<%@ page import="club.banyuan.eneity.Auction" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/11
  Time: 3:14 下午
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
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">拍卖结束的商品</h1>
        <div class="right rulse">当前用户是：<span class="blue strong"><a href="#" title="张三">张三</a></span></div>
        <div class="cl"></div>
    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="list-wd">成交价</li>
            <li class="borderno">买家</li>
        </ul>
        <%
            HttpSession session1=request.getSession();
            List<Product> productList=(List<Product>)session1.getAttribute("products");
            for(Product product:productList){
                Auction auction;
                AuctionService auctionService=new AuctionServiceImpl();
                auction=auctionService.selectResultByPId(product.getId());
                System.out.println(product.getId());
                System.out.println(auction);
        %>
        <ul class="rows">
            <li><a href="国书" title=""><%=product.getPname()%></a></li>
            <li><%=product.getBeginTime()%></li>
            <li><%=product.getEndTime()%></li>
            <li><%=product.getBeginprice()%></li>
            <li class="list-wd"><%=auction.getPrice()%></li>
            <li class="borderno red"><a href="#"><%=auction.getLoginName()%></a></li>
        </ul>
        <%

            }
        %>
    </div>
    <h1>拍卖中的商品</h1>
    <div class="items records">
        <ul class="rows even strong rowh">
            <li>名称</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno record">出价记录</li>
            <div class="cl"></div>
        </ul>
        <%
            productList=(List<Product>) session1.getAttribute("products1");
            for(Product product:productList){
        %>
        <ul class="rows">
            <li><a href="国书" title=""><%=product.getPname()%></a></li>
            <li><%=product.getBeginTime()%></li>
            <li><%=product.getEndTime()%></li>
            <li><%=product.getBeginprice()%></li>
            <%
                List<Auction> auctionList;
                AuctionService auctionService=new AuctionServiceImpl();
                auctionList=auctionService.selectResult(product.getId());
                System.out.println(auctionList);
            %>
            <li class="borderno blue record">
                <%
                    for(Auction auction:auctionList){
                %>
                <p><%=auction.getLoginName()%> <%=auction.getPrice()%>元</p>

            <%
                }
            %>
            </li>
            <div class="cl"></div>
        </ul>
        <%
            }
        %>
    </div>
    <!-- main end-->
</div>
</body>
</html>

