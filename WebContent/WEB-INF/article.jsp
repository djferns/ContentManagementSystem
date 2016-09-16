<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
</head>
<body>
	<c:url var="addAction" value="/article/add"/>
	<form:form action="${addAction}" commandName="article" enctype="multipart/form-data">
	<table>
		<tr>
			<td>
				<spring:message text="Title"/>
			</td>
			<td>
				<form:input path="title" /><form:hidden path="id" />
			</td>
			<td colspan="2">
				<spring:message text="Content"/>
			</td>		
		</tr>
		<tr>
			<td>
				<spring:message text="Author"/>
			</td>
			<td>
				<form:input path="author" />
			</td>
			<td>
				<form:textarea rows="2" path="content"/>
			</td>		
		</tr>
		<tr>
			<td>
				<spring:message text="Summary"/>
			</td>
			<td>
				<form:input path="summary" />
			</td>		
		</tr>
		<tr>
			<td>
				<spring:message text="File to upload"/>
			</td>
			<td>
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td>
				<spring:message text="File Name"/>
			</td>
			<td>
				<form:input path="fileName" />
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<c:if test="${!empty article.title}">
					<input type="submit" value="<spring:message text="Update Article"/>" />
				</c:if>
				<c:if test="${empty article.title}">
					<input type="submit" value="<spring:message text="Add Article"/>" />
				</c:if>
			</td>
		</tr>
	</table>
	</form:form>
	<br>
	<br>
	<a href="<c:url value='/' />" ><img width="25px" height="25px" src="<c:url value='/images/home.png'/>"/></a>
</body>
</html>