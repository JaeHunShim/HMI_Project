<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	$(".dropdown-item").hover(function(){
		$(this).addClass('active');
		},function(){
			$(this).removeClass('active');
		});
});
</script>
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
							role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
							<c:out value="${sessionScope.session.user_id}"/>
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
							<c:if test="${empty sessionScope.session}">
							<a class="dropdown-item" href="/user/signup">SignUp</a>
							<a class="dropdown-item" href="/user/signin">SignIn</a>
							</c:if>
							<c:if test="${not empty sessionScope.session}">
							<a class="dropdown-item" href="/board/regster">Write</a>
							<a class="dropdown-item" href="/board/viewList">List</a>
							</c:if>
						</div>
					</li>
				</ul>
			</div>
		</nav>