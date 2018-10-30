<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isErrorPage="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form>
    <table>
        <tr>
            <th>名字</th>
            <th>类型</th>
            <th>图片</th>
            <th>状态</th>
            <th>标签</th>
        </tr>
    </table>
</form>

<c:forEach items="${pets}" var="pet">
    ${pet.petId},${pet.category.categoryName},${pet.petName},${pet.petPhoto},${pet.petStatus},${pet.tag.tagName}<br/>
</c:forEach>

</body>
</html>
