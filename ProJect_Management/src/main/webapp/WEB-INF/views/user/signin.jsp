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
</head>
<body>
	<div class="container-fulid">
		<%@ include file="../include/header.jsp" %>
		<div class="row">
			<div class="m-auto col-3 col-lg-3" style="background-color:#A9F5F2;">
				<h4 class="text-center my-3">SignIn</h4>
				<form action='<c:url value="/user/signin"/>' method="post">
					<div class="from-group">
						<label for="userid">UserID</label>
						<input type="text" class="form-control" aria-describedby="useridHelp" name="user_id" placeholder="USER_ID">
					</div>
					<div class="from-group">
						<label for="userid">Password</label>
						<input type="password" class="form-control" aria-describedby="passwordidHelp" name="password" placeholder="USER_ID">
					</div>
					<c:if test="${not empty ERRORMSG}">
					<font color="red">
				  		<p>${ERRORMSG }</p>
					</font>
					</c:if>
					<div class="text-center my-3">
						<button type="submit" class="btn btn-success">Submit</button>			
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
