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
.table {
	border:1px solid #2ECCFA;
}
</style>
<script>
function fn_submit(mode){
	var frm = document.frm;
	if(mode=="1"){
		frm.action ="/board/modify?pno='${fileVO.board.pno}'";
		frm.method ="get";
	}else if(mode=="2"){
		frm.action ="/board/delete?pno='${fileVO.board.pno}'";
		frm.method ="get";
	}else if(mode="3"){
		frm.action="/board/viewList";
		frm.method="get";
	}else if(mode='4'){
		frm.action="/board/modify?pno='${fileVO.board.pno}'";
		frm.method="post"
	}
	frm.submit();
}
</script>
</head>
<body>
	<div class="container-fulid">
		<%@ include file="../include/header.jsp" %>
		<div class="container">
			<div class="text-center" style="margin:30px">
					<h1><span>Project DetailView</span></h1>
			</div>
			<form name="frm" method="post" action="/board/modify">
				<input type="hidden" name="user_id" value="${sessionScope.session.user_id}">
				<table class="table">
					<tbody>
						<tr>
							<th scope="row" style="border-top:1px solid #2ECCFA">PNO</th>
							<td style="border-top:1px solid #2ECCFA"><input type="text" name="pno" class="form-control" value="${fileVO.board.pno}" readonly></td>
						</tr>
						<tr>
							<th scope="row">Project_name</th>
							<td><input type="text" name="project_name" class="form-control" value="${fileVO.board.project_name}" readonly></td>
						</tr>
						<tr>
							<th scope="row">Company_name</th>
							<td><input type="text" name="company_name" class="form-control" value="${fileVO.board.company_name }" readonly></td>
						</tr>
						<tr>
							<th scope="row">Status</th>
							<td><input type="text" name="status" class="form-control" value="${fileVO.board.status}" readonly></td>
						</tr>
						<tr>
							<th scope="row">Content</th>
							<td><textarea name="content"class="form-control" id="exampleFormControlTextarea1" rows="3" readonly>${fileVO.board.content}</textarea></td>
						</tr>
						<tr>
							<th scope="row">File</th>
							<td><a href="/board/fileDownload?fileId=${fileVO.fileId}" class="form-control-file">${fileVO.originalFileName}</a></td>
							
						</tr>
					</tbody>
				</table>
				<div class="text-center">
					<button onclick="fn_submit('1')"class="btn btn-success">Modify</button>
					<button onclick="fn_submit('2')" class="btn btn-danger">Delete</button>
					<button onclick="fn_submit('3')" class="btn btn-warning">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>