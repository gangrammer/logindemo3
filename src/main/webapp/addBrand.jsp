<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/logindemo3_war_exploded/AddServlet" method="post">
    品牌名称：<input name="brandName" type="text"><br>
    企业名称：<input name="companyName" type="text"><br>
    排序：<input name="ordered" type="text"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态：
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用<br>

    <input type="submit" value="提交" >
</form>
</body>
</html>