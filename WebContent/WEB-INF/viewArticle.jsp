<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${article.author }</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
	<table style="width: 100%;" frame="border">
		<tr>
			<td style="width: 50%;" align="center">${article.title }</td>
			<td align="right">Created on: ${article.createdDate }</td>
		</tr>
		<tr>
			<td align="right" style="width: 50%;">By:</td>
			<td colspan="2">${article.author }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">${article.content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img width="100px" height="100px" src="${article.fileLocation }"/></td>
		</tr>
	</table>
	<br>
	<h3>Comments</h3>
	<c:if test="${!empty article.comments}">
		<table class="tg">
			<tr>
				<th width="80">Comment By</th>
				<th width="120">Comment</th>
				<th width="120">Created On</th>
			</tr>
			<c:forEach items="${article.comments}" var="comment">
				<tr>
					<td>${comment.commentAuthor}</td>
					<td>${comment.commentName}</td>
					<td>${comment.createdDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<a href="<c:url value='/' />" ><img width="25px" height="25px" src="<c:url value='/images/home.png'/>"/></a>
</body>
</html>