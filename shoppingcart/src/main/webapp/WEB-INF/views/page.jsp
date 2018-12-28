<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/assets/css" />
<spring:url var="js" value="/assets/js" />
<spring:url var="images" value="/assets/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>My Shopping-${title }</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<%-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>


<!-- Bootstrap DataTables -->
<%-- <link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> --%>


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>
	<div class="se-pre-con"></div>
	<div class="wrapper">
		<%@ include file="./shared/navber.jsp"%>
		<!-- Page Content -->
		<div class="content">
			<c:if test="${userclickHome== true }">
				<%@ include file="home.jsp"%>
			</c:if>

			<c:if test="${userclickAbout== true }">
				<%@ include file="about.jsp"%>
			</c:if>

			<c:if test="${userclickContact==true }">
				<%@ include file="contact.jsp"%>
			</c:if>
		</div>
		<!-- /.container -->

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<%-- <script src="${js}/myapp.js"></script> --%>
	</div>
</body>

</html>
