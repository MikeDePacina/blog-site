<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Edit Article</title>
</head>
<body>
	<nav aria-label="breadcrumb" class="m-2 ms-4 fs-6">
  		<ol class="breadcrumb">
    		 <li class="breadcrumb-item"><a href="ListArticle">Home</a></li>
    		 <li class="breadcrumb-item">Edit Article</li>
   			 <li class="breadcrumb-item active" aria-current="page">${articleToEdit.getTitle()}</li>
  		</ol>
	</nav>
	<div class="container mx-auto">
		<h1 class="text-center p-5 text-decoration-underline">Edit Article</h1>
		<form class="p-1 mx-auto" action="Edit" method="post">
			<div class="row mb-3">
				<label for="Category" class="col-sm-2 col-form-label fw-bold">Category</label>
				<div class="col-sm-10">
					<select id="Category" name="category">
						<c:forEach items="${categories}" var="category">
							<c:choose>
								<c:when test="${articleToEdit.category == category}">
									<option value="${category}" selected>${category}</option>
								</c:when>
								<c:otherwise><option value="${category}">${category}</option> </c:otherwise>
							</c:choose>
				
						</c:forEach>
					</select>
				</div>
		</div>
		
		<div class="row mb-3">
			<label for="title" class="col-sm-2 col-form-label fw-bold">Title</label>
			 <div class="col-sm-10">
     		 	<input type="text" class="form-control" value="${articleToEdit.getTitle()}" name="title">
    		</div>
		</div>
	
		<div class="row mb-3">
			<label for="excerpt" class="col-sm-2 col-form-label fw-bold">Excerpt</label>
			 <div class="col-sm-10">
     		 	<input type="text" class="form-control" value="${articleToEdit.getExcerpt()}" name="excerpt">
    		</div>
		</div>
		
		<div class="row mb-3">
			<label for="content" class="col-sm-2 col-form-label fw-bold">Content</label>
			 <div class="col-sm-10">
      			<textarea class="form-control" name="content"> ${articleToEdit.getContent()}</textarea>
    		</div>
		</div>
		
		<input type="hidden" class="form-control" value="${articleToEdit.getId()}" name="id">
		<button type="submit" class="btn btn-primary">Save</button>
	 </form>
	
	</div>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>