<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/pet/list">返回</a><br/><br/>

<form:form action="/photo/insertImg" method="post" enctype="multipart/form-data">
    <input type="file" name="photoName"/>

    <c:forEach items="${photos}" var="photo" begin="0" end="0">
        <input type="hidden" name="petId" value="${photo.petId}">
    </c:forEach>

    <input type="submit" value="上传">
</form:form><br/><br/>


<hr>
<p style="font-size: 25px"><b>图片</b></p>

<c:forEach items="${photos}" var="photo">
    <img src="/images/${photo.photoName}" name="photoName" width="200px" height="150px">
</c:forEach>
</body>
</html>
