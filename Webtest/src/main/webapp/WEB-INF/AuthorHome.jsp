<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Author Home</title>
</head>
<body>
	<div class="d-flex justify-content-between m-4 fs-3">
		<a>Home</a>
		<a href="Logout">Logout</a>
	</div>
	
	
	<div class="container mx-auto">
		<p class="fs-4">Hello, ${user.getFullName()}</p>
		<h1 class="text-center text-decoration-underline p-5">Articles</h1>
		<a class="h3" href="addArticle">New Article</a>
	<br>
	<br>
	
	<table class="table  table-hover">
		<tr>
			<th class="h4">Article</th>
			<th class="h4">Category</th>
			<th class="h4">Submitted</th>
			<th class="h4">Published</th>
			<th class="h4">Edit</th>
		</tr>
	
		<c:forEach items="${authorView}" var="article" >
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
				<c:choose>
					<c:when test="${article.getTimeSubmitted() != null}">
						<fmt:formatDate value="${article.getTimeSubmitted()}" type="both" />
					</c:when>
					<c:when test="${article.getTimeSubmitted() == null}">
						<a href="Submit?id=${article.getId()}">Submit</a>
					</c:when>	
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${article.getTimePublished() != null}">
						<fmt:formatDate value="${article.getTimePublished()}" type="both" />
					</c:when>
					
					<c:when test="${article.getTimePublished() == null }">
						<a href="Error" class="text-muted">Publish</a>
					</c:when>
				</c:choose>	
			</td>
			<td>
				<c:choose>
					<c:when test="${article.getTimeSubmitted() == null}">
						<a href="Edit?id=${article.getId()}">Edit</a>
					</c:when>
					<c:otherwise>
						<a href="Error" class="text-muted">Edit</a>
					</c:otherwise>
					
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>