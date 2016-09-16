<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<a href="<c:url value='/getAllArticles/list'/>">Get all Articles</a> <br>
	<a href="<c:url value='/addArticle'/>">Add an Article</a> <br>
	<a href="<c:url value='/getAllArticles/updateArticle'/>">Update an Article</a> <br>
	<a href="<c:url value='/getAllArticles/addComment'/>">Comment on an Article</a> <br>
	<a href="<c:url value='/getAllArticles/deleteArticle'/>">Delete an Article</a> <br>
</body>
</html>