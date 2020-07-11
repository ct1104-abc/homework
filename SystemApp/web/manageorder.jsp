<%@ page import="java.util.List" %>
<%@ page import="club.banyuan.eneity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/8
  Time: 5:08 下午
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
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="result.do" title="竞拍结果">竞拍结果</a></div>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="forms">
        <form action="search.do">
        <label for="name">名称</label>
        <input name="pname" type="text" class="nwinput"  id="name"/>
        <label for="names">描述</label>
        <input name="description" type="text" id="names"  class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="beginTime" type="text" id="time"  class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="endTime" type="text" id="end-time"  class="nwinput" />
        <label for="price">起拍价</label>
        <input name="beginprice" type="text" id="price"  class="nwinput" />

        <input name="" type="submit"  value="查询" class="spbg buttombg f14  sale-buttom"/>
        <a href="addproduct.jsp">
        <input type="button"   value="发布" class="spbg buttombg f14  sale-buttom buttomb"/></a>
        </form>
    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
        <%
            List<Product> productList=(ArrayList<Product>)session.getAttribute("productList");
                for(Product product:productList){
        %>
        <ul class="rows">
            <li><a href="国书" title=""><%=product.getPname()%></a></li>
            <li class="list-wd"><%=product.getDescription()%></li>
            <li><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(product.getBeginTime())%></li>
            <li><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(product.getEndTime())%></li>
            <li><%=product.getBeginprice()%></li>
            <li class="borderno red">
                <a href="getproduct.do?pid=<%=product.getId()%>" title="竞拍" onclick="dele();">修改</a>|
                <a href="delete.do?pid=<%=product.getId()%>" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <%
            }
        %>

        <div class="page">
            <a href="#" title="">首页</a>
            <a href="#" title="">上一页</a>
            <span class="red">前5页</span>
            <a href="#" title="">1</a>
            <a href="#" title="">2</a>
            <a href="#" title="">3</a>
            <a href="#" title="">4</a>
            <a href="#" title="">5</a>
            <a href="#" title="">下一页</a>
            <a href="#" title="">尾页</a>
        </div>
    </div>
    <script>
        function abc(){

            if(confirm("你真的确认要删除吗？请确认")){

                return true;
            }
            else{
                return false;
            }

        };
        function dele(){
            if(confirm("你真的确认要修改吗？请确认")){
                return true;
            }
            else{
                return false;
            }
        }
    </script>
    <!-- main end-->
</div>
</body>
</html>

