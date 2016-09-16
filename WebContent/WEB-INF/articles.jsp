<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Articles</title>

	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>

</head>
<body>

	<h3>Articles List</h3>
	<c:if test="${!empty listArticles}">
		<table class="tg">
		<tr>
			<th width="120">Title</th>
			<th width="120">Summary</th>
			<th width="60">Author</th>
			<th width="60">Created On</th>
			<c:if test="${actionValue == 'Edit'}">
				<th width="60">Edit</th>
			</c:if>
			<c:if test="${actionValue == 'Delete'}">
				<th width="60">Delete</th>
			</c:if>
			<c:if test="${actionValue == 'Comment'}">
				<th width="60">Comment</th>
			</c:if>
		</tr>
		<c:forEach items="${listArticles}" var="article">
			<tr>
				<td align="center"><a href="<c:url value='/viewArticle/${article.id}'/>" style="text-decoration: none; color: orange;">${article.title}</a></td>
				<td>${article.summary}</td>
				<td>${article.author}</td>
				<td>${article.createdDate}</td>
				<c:if test="${actionValue == 'Edit'}">
					<td align="center"><a href="<c:url value='/editArticle/${article.id}'/>"><img width="25px" height="25px" src="<c:url value='/images/edit.png'/>"/></a></td>
				</c:if>
				<c:if test="${actionValue == 'Delete'}">
					<td align="center"><a href="<c:url value='/removeArticle/${article.id}'/>"><img width="25px" height="25px" src="<c:url value='/images/delete.png'/>"/></a></td>
				</c:if>
				<c:if test="${actionValue == 'Comment'}">
					<td align="center"><a href="<c:url value='/addComment/${article.id}'/>"><img width="25px" height="25px" src="<c:url value='/images/edit.png'/>"/></a></td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<a href="<c:url value='/' />" ><img width="25px" height="25px" src="<c:url value='/images/home.png'/>"/></a>

</body>
</html>