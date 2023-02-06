
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Article</title>
</head>
<body>
	<nav aria-label="breadcrumb" class="m-2 ms-4 fs-4">
  		<ol class="breadcrumb">
    		<li class="breadcrumb-item"><a href="ListArticle">Home</a></li>
    		<li class="breadcrumb-item active" aria-current="page">Add Article</li>
  		</ol>
  	</nav>
	<h1 class="text-center m-5">Add Article</h1>
	<br>

	<div class="container rounded">
		<form class=" p-1 mx-auto" action="addArticle" method="post">
			<div class="row mb-3">
				<label for="Category" class="col-sm-2 col-form-label fw-bold">Category</label>
					<div class="col-sm-10">
						<select id="Category" name="category">
							<option value="Biz & IT">Biz & IT</option>
							<option value="Tech">Tech</option>
							<option value="Science">Science</option>
							<option value="Policy">Policy</option>
							<option value="Cars">Cars</option>
							<option value="Gaming & Culture">Gaming & Culture</option>
						</select>
					</div>
			</div>
			<div class="row mb-3">
				<label for="Title" class="col-sm-2 col-form-label fw-bold">Title</label>
			 		<div class="col-sm-10">
     		 			<input type="text" class="form-control" id="inputEmail3" name="title">
    				</div>
			</div>
			<div class="row mb-3">
				<label for="Excerpt" class="col-sm-2 col-form-label fw-bold">Excerpt</label>
			 		<div class="col-sm-10">
    			 		<input type="text" class="form-control" id="Excerpt" name="excerpt">
    				</div>
			</div>
			<div class="row mb-3">
				<label for="Content" class="col-sm-2 col-form-label fw-bold">Content</label>
			 		<div class="col-sm-10">
      					<textarea class="form-control" id="Content" name="content"></textarea>
    				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>