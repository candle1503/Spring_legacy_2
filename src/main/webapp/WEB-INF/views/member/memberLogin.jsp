<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1></h1>
		<h1></h1>
  <h2>Member Login</h2>
  <form action="./memberLogin" method="post">
    <div class="form-group">
      <label for="id">ID:</label>

      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" >
    </div>
    
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="text" class="form-control" id="password" placeholder="Enter Password" name="password">
    </div>
   
    <input type="submit" class="btn btn-default" value="Submit">
  </form>
</div>

</body>
</html>