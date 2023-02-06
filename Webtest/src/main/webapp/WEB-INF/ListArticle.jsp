<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>List Article</title>
</head>
<body>
<div class="d-flex justify-content-between m-4 fs-3">
		<a>Home</a>
		<a href="Logout">Logout</a>
	</div>
<div class="container mx-auto">
<h1 class="text-center text-decoration-underline p-5">Articles</h1>





<br>
<br>
<table class="table  table-hover">
	<tr>
	<th class="h4">Article</th>
	<th class="h4">Category</th>
	<th class="h4">Submitted</th>
	<th class="h4">Published</th>
	<th class="h4">Operations</th>
	</tr>
	<c:forEach items="${listOfArticles}" var="article" >
		<tr>
		<td>
		<a href="ArticleView?id=${article.getId()}" class="h5">${article.getTitle()}</a>
		<br>
		<p class="fst-italic">${article.getExcerpt()}</p>
		</td>
		<td>
		${article.getCategory()}
		</td>
		<td>
		<fmt:formatDate value="${article.getTimeSubmitted()}" type="both" />
		</td>
		<td>
		<c:choose>
		<c:when test="${article.getTimePublished() == null}">
			<a href="Publish?id=${article.getId()}">Publish</a>
		</c:when>
		<c:when test="${article.getTimePublished() != null}">
			<fmt:formatDate value="${article.getTimePublished()}" type="both" />
		</c:when>
		</c:choose>
		</td>
		<td>
		<a href="Edit?id=${article.getId()}">Edit</a>
		</td>
		</tr>
	</c:forEach>
</table>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>