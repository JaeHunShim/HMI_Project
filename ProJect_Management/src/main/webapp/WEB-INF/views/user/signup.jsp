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
<title>SignUp</title>
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
				<h4 class="text-center my-3">SignUp</h4>
				<form action="/user/signup" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-group">
						<label for="usrid"><strong>ID</strong></label>
						<div class="input-group">
							<input type="text" name="user_id" class="form-control" id="user_id" aria-descibedby="useridHelp" placeholder="USER_ID">
							<div class="input-group-append">
								<button class="btn btn-outline-info" onclick="fn_idcheck()">check</button>
							</div>	
						</div>
						<small id="useridHelp">중복확인인후 경고메세지 넣을곳 </small>
					</div>
					<div class="form-group">
						<label for="usrid"><strong>PASSWORD</strong></label>
						<div class="input-group">
							<input type="text" name="password" class="form-control" id="password" aria-descibedby="passHelp" placeholder="PASSWORD">
							<div class="input-group-append">
								<button class="btn btn-outline-info" onclick="fn_passcheck()">check</button>
							</div>	
						</div>
						<small id="passHelp">중복확인인후 경고메세지 넣을곳 </small>
					</div>
					<div class="form-group">
						<label for="company_name"><strong>COMPANY</strong></label>
						<div class="input-group mb-3">
							<select name="company_name" class="form-control"  aria-descibedby="useridHelp">
								<option>naver</option>
								<option>google</option>
								<option>humanint</option>
								<option>MircroSoft</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="posision"><strong>POSISION</strong></label>
						<div class="input-group mb-3">
							<select name="position" class="form-control"  aria-descibedby="useridHelp" >
								<option>Manager</option>
								<option>Temple</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="email"><strong>Email</strong></label>
						<div class="input-group">
							<input type="email" name="email" class="form-control" aria-label="Text input with dropdown button" placeholder="Email">
							  <div class="input-group-append">
							    <select name="company_name" class="form-control btn btn-outline-info"  aria-descibedby="useridHelp" placeholder="COMPANY">
									<option>직접입력</option>
									<option>naver.com</option>
									<option>gmail.com</option>
									<option>daum.net</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="address"><strong>Address</strong></label>
						<div class="input-group">
							<input type="text" name="address" class="form-control" id="address" aria-descibedby="useridHelp" placeholder="Address">
							<div class="input-group-append">
								<button class="btn btn-outline-info" onclick="fn_addressCheck()">Search</button>
							</div>	
						</div>
					</div>
					<div class="text-center mb-3">
						<button type="submit" class="btn btn-success">Submit</button>
						<a role="button" href="/user/signin" class="btn btn-danger">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
