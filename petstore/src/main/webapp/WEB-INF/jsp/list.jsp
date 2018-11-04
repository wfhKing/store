<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #stable th, #stable td {
        border: 1px solid black;
        width: 150px;
    }
</style>
<body>

<form action="/pet" method="post">
    宠物名：<input type="text" name="petName">
    宠物类型：
    <select name="categoryId">
        <c:forEach items="${categories}" var="c">
            <option value="${c.categoryId}">${c.categoryName}</option>
        </c:forEach>
    </select>
    宠物价格：<input type="number" name="petPrice">
    宠物状态：
    <select name="petStatus">
        <option value="可用">可用</option>
        <option value="待定">待定</option>
        <option value="已售出">已售出</option>
    </select>
    <input type="submit" value="确认添加">
</form><br/><br/>


<table border="0" cellspacing="0" cellpadding="1" id="stable" style="text-align: center">
    <tr>
        <th>宠物名</th>
        <th>宠物类型</th>
        <th>宠物价格</th>
        <th>宠物状态</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${pets}" var="pet">
        <tr>
            <td>
                <a href="/pet/selectByPrimaryKey?petId=${pet.petId}">
                        ${pet.petName}
                </a></td>
            <td>${pet.category.categoryName}</td>
            <td>${pet.petPrice}</td>
            <td>${pet.petStatus}</td>
            <td><a href="/pet/delete?petId=${pet.petId}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
