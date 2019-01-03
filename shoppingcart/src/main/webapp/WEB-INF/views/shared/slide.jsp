<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="list-group">
		<c:forEach items="${catagories}" var="catagory">
			<a href="${contextRoot}/show/catagory/${catagory.catagoryid}/products" id="a_${catagory.catagoryname}"class="list-group-item">${catagory.catagoryname}</a>
		</c:forEach>
		<!-- <a href="#" class="list-group-item">Category 1</a> <a href="#"
			class="list-group-item">Category 2</a> <a href="#"
			class="list-group-item">Category 3</a> -->
	</div>


</body>
</html>