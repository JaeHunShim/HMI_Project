<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>SignIn</title>
<style>
	img{
		width:50px;
		height:50px;
	}
</style>
<script>
	$(document).ready(function(){
		$(".dropdown-item").hover(function(){
			$(this).addClass('active');
			},function(){
				$(this).removeClass('active');
			});
	});
</script>
</head>
<body>
	<div class="container-fulid">
		<nav class="navbar navbar-expand-sm navbar-light bg-light mb-5">
			<a class="navbar-brand" href="#">
				<img src="/resources/img/logo.png" class="d-inline-block">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="navbarSupport">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupport">
				<ul class="navbar-nav ml-auto mr-5 pr-5">
					<li class="nav-item dropdown" >
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
							role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Menu
						</a>
						<div class="dropdown-menu" aria-labelleby="navbarDropdown">
							<a class="dropdown-item" href="/user/signup">SignUp</a>
							<a class="dropdown-item" href="/user/signin">SignIn</a>
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="m-auto col-3 col-lg-3" style="background-color:#A9F5F2;">
				<h4 class="text-center my-3">SignIn</h4>
				<form action="/user/signin" method="post">
					<div class="from-group">
						<label for="userid">UserID</label>
						<input type="text" class="form-control" aria-describedby="useridHelp" name="user_id" placeholder="USER_ID">
					</div>
					<div class="from-group">
						<label for="userid">Password</label>
						<input type="password" class="form-control" aria-describedby="passwordidHelp" name="password" placeholder="USER_ID">
					</div>
					<div class="text-center my-3">
						<button type="submit" class="btn btn-success">Submit</button>			
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
