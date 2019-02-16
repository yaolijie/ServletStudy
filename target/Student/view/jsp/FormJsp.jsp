
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜鸟教程</title>
    <%
        String path=request.getContextPath();
    %>
</head>
<body>
<form action="/Syudenty/TomcatTest/HelloForm" method="post">
    网站名：<input type="text" name="name">
    <br/>
    网址: <input type="text" name="url">
    <input type="submit" value="提交">
</form>
<%--<form action=<%=path%>/CheckServlet method="post" target="_blank">--%>
    <%--<input type="checkbox" name="runoob" checked="checked" value="菜鸟教程" >菜鸟教程--%>
    <%--<input type="checkbox" name="goole" value="goole">goole--%>
    <%--<input type="checkbox" name="taobao" checked="checked" value="淘宝">淘宝--%>
    <%--<input type="submit" value="选择站点">--%>
<%--</form>--%>
</body>
</html>
