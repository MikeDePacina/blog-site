<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Create Account</title>
</head>
<body>
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  		<symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    		<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
  		</symbol>
  		<symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
    		<path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
  		</symbol>
  		<symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    		<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
 		 </symbol>
	</svg>
	
	
	
	
	<div class="container ">
	<c:if test="${created == -1}">
			<div class="alert alert-warning alert-dismissible fade show mt-3" role="alert">
    			<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Warning:"><use xlink:href="#exclamation-triangle-fill"/></svg>Username already taken. Please enter another username.
  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
	</c:if>
	
	<c:if test="${created == -2}">
			<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
    			<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>Please fill out all input fields.
  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
	</c:if>
	<form class="mx-auto mt-5 p-5 border border-2 rounded" method="post" >
		<div class="text-center fs-2">Register</div>
  		<div class="mb-3">
    		<label for="userName" class="form-label">Username</label>
    		<input type="text" class="form-control" id="UserName" name="userName">
    	</div>
    	<div class="mb-3">
    		<label for="password" class="form-label">Password</label>
    		<input type="password" class="form-control" id="Password" name="password">
    	</div>
  		<div class="mb-3">
    		<label for="fullName" class="form-label">Full name</label>
    		<input type="text" class="form-control" id="FullName" name="fullName">
  		</div>
 		
 		<div class="d-flex">
 			Role:
 			<input class="ms-2" type="radio" id="Author" name="role" value="author">
			<label for="author">Author</label><br>
			<input class="ms-2" type="radio" id="Editor" name="role" value="editor">
			<label for="editor">Editor</label><br>
 		</div>
  		<button type="submit" class="mt-3 btn btn-primary">Register</button>
	</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>