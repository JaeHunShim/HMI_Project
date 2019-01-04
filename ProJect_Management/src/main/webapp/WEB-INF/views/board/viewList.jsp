<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		 	PagingActive();
		 	PerPageChange();
		 	selectValue();
	});
	// 페이지 active 효과 처리 
	function PagingActive(){
		var idx = ${pageMaker.cri.page};
		$('.page-link').each(function(){
			var a = $(this).text();
				console.log(a);
			if(idx == a){
				$(this).parent().addClass('active');
			}
		});
	}
	// perPageNum 변경 
	function PerPageChange(){
		$('select').change(function(){
			var perPage = $(this).val();
			self.location = "/board/viewList?"
			+'page=1&'
			+'perPageNum='+perPage+''
		});
	}
	//select Value 값 유지 
	function selectValue(){
		var selValue= ${pageMaker.cri.perPageNum};
		console.log(selValue);
		$('select').val(selValue).prop('selected',true);
	}
</script>
</head>
<body>
	<div class="container-fulid">
		<%@ include file="../include/header.jsp" %>
		<div class="row m-auto text-center">
			<div class="m-auto text-cetner">
				<span class="my-3 py-3"><h1>Current Project Status</h1></span>
			</div>
		</div>
		<div class="table-responsive-lg col-8 m-auto">
			<div class="form-row m-0">
				<select class="custom-select my-1 mr-sm-2 col-2">
					<option>10</option>
					<option>20</option>
					<option>30</option>
				</select>
			<form class="form-inline ml-auto" action="/project/search" method="post">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			</div>
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
					<c:forEach items="${board}" var="board">
					<tr>
						<th scope="row">${board.pno}</th>
						<td>${board.userInfo.user_id}</td>
						<td><a href="/board/detailView?pno=${board.pno}">${board.project_name}</a></td>
						<td><fmt:formatDate value="${board.regdate}" pattern="yyyy.MM.dd"/></td>
						<td>${board.status}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<nav aria-label="Pagenaion my-3">
 			 <ul class="pagination justify-content-center mt-3">
 			 	<c:if test="${pageMaker.prev}">
   				 <li class="page-item">
     				 <a href="/board/viewList${pageMaker.makeQuery(pageMaker.startPage-1)}" class="page-link">Previous</a>
    			</li>
    			</c:if>
   				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="idx">
   				<li class="page-item">
   					<a class="page-link" href="/board/viewList${pageMaker.makeQuery(idx)}">${idx}</a>
   				</li>
				</c:forEach>
				<c:if test="${pageMaker.next}">
   				<li class="page-item">
      				<a class="page-link" href="/board/viewList${pageMaker.makeQuery(pageMaker.endPage+1)}">Next</a>
  				</li>
  				</c:if>
  			</ul>
		</nav>
	</div>
</body>
</html>