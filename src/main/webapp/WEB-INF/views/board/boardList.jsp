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
			<h1>Point List page</h1>
			<table class="table table-hover">
				<tr>
					<td>NUM</td>
					<td>SUBJECT</td>
					<td>NAME</td>
					<td>DATE</td>
					<td>HIT</td>
					
				</tr>
				
				
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./boardSelect?num=${dto.num}&id=${dto.id}">${dto.subject}</a></td>	<!-- 파라미터이름,컬럼명,변수명 을 같게 -->
						<td>${dto.id}</td>
						<td>${dto.creatDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>


			</table>
			<c:if test="${member.id eq 'admin'}">
			<a href="./boardAdd" class="btn btn-primary">글쓰기</a>
			</c:if>
		</div>
	</div>
</body>
</html>