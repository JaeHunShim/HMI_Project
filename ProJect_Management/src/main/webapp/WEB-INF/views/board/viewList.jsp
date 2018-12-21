<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" type="text/javascript"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous" type="text/javascript"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Board</title>
<style type="text/css">
img {
	width: 50px;
	height: 50px;
}
</style>
<script type="text/javascript">
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
				<img src="/resources/img/logo.png" class="d-inline-block" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="navbarSupport">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupport">
					<ul class="navbar-nav ml-auto mr-5 pr-5">
					<li class="nav-item dropdown mr-2">
						<a class="nav-link dropdown-toggle" href="#" id="userinfo" 
							role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >${userInfo.user_id}
						</a>
						<div class="dropdown-menu" aria-labelleby="navbarDropdown">
							<a class="dropdown-item" href="/user/logout">Logout</a>
							<a class="dropdown-item" href="/user/info">Modify</a>
							<a class="dropdown-item" href="/project/subscription">Subsription</a>
						</div>
					</li>
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
		<div class="table-responsive-lg col-8 m-auto">
			<form action="/project/search" method="post">
				
			</form>
			<table class="table text-center">
				<thead class="thead-dark">
					<tr>
						<th scope="col">No</th>
						<th scope="col">Company_Name</th>
						<th scope="col">ProJectName</th>
						<th scope="col">Reservaion_Date</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Naver</td>
						<td>ProjectManagement System</td>
						<td>2018-12-29</td>
						<td>Complete</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Naver</td>
						<td>User Management System</td>
						<td>2018-12-25</td>
						<td>proceeding</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>