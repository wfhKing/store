<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/pet/update" method="post">
    宠物ID：<span>${pet.petId}</span>
    宠物名：<input type="text" name="petName" value="${pet.petName}">
    宠物类型：
    <select name="categoryId">
        <option value="${pet.category.categoryId}">${pet.category.categoryName}</option>
        <c:forEach items="${categories}" var="c">
            <option value="${c.categoryId}">${c.categoryName}</option>
        </c:forEach>
    </select>
    宠物价格：<input type="number" name="petPrice" value="${pet.petPrice}">
    宠物状态：
    <select name="petStatus">
        <option value="${pet.petStatus}">${pet.petStatus}</option>
        <option value="可用">可用</option>
        <option value="待定">待定</option>
        <option value="已售出">已售出</option>
    </select>
    <input type="submit" value="确认修改">
</form:f>
<br/><br/>

</body>
</html>
