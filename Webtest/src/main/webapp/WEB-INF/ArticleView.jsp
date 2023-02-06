<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>${article.getTitle()}</title>
</head>
<body>
	<nav aria-label="breadcrumb" class="m-2 ms-4 fs-6">
  		<ol class="breadcrumb">
    		 <li class="breadcrumb-item">
    		 <c:choose>
    		 	<c:when test="${user == null}">
    		 		<a href="GlobalHome">Home</a>
    		 	</c:when>
    		 	<c:when test="${user.getRole() == 'author' }">
    		 		<a href="AuthorHome">Home</a>
    		 	</c:when>
    		 	<c:otherwise>
    		 		<a href="ListArticle">Home</a>
    		 	</c:otherwise>
    		 </c:choose>
    		 </li>
    		 <li class="breadcrumb-item">Article</li>
   			 <li class="breadcrumb-item active" aria-current="page">${article.getTitle()}</li>
  		</ol>
	</nav>
	
	<div class="container mx-auto mt-5">
		<div class="text-center">
			<p class="h4 fw-bold">${article.getTitle()}</p>
			<p class="h6 fst-italic mb-7">${article.getExcerpt()}<p>
		</div>
		<div class="text-left w-75 text-wrap text-break">
			<p>${article.getContent()} </p>
		</div>
	</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>