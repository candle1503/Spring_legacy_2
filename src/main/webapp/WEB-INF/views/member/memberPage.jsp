<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
		<div class="row">
		<h1>Point Select Page</h1>
			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Phone</td>
					<td>Email</td>
					<td>Age</td>
				</tr>
				
					<tr class= info>
						<td>${member.id}</td>
						<td>${member.name}</td>
						<td>${member.phone}</td>
						<td>${member.email}</td>
						<td>${member.age}</td>
					</tr>
			</table>
			
			<button class="btn btn-primary" id="update">Update</button>
			<button class="btn btn-danger" id="del" name=result>Delete</button>
		</div>
		
		<script type="text/javascript">
			//js	document.getElementById
			//js	document.querySelector
			//jquery $(선택자)
			
			$("#del").click(function() {
				var result = confirm("탈퇴 할거냐??");
				console.log(result);
			if(result){
				location.href="./memberDelete";
			}else{
				location.href="#";
			}
			});
		
			$("#update").on("click", function() {
				location.href="./memberUpdate";
			});
		</script>
		
</body>
</html>