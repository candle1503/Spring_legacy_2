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
		<h1></h1>
		<h1></h1>
  <h2>Member Join</h2>
  <form action="./memberJoin" method="post">
    <div class="form-group">
      <label for="Id">ID:</label>

      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" value="${id}">
    </div>
    
    <div class="form-group">
      <label for="Password">Password:</label>
      <input type="text" class="form-control" id="password" placeholder="Enter Password" name="password">
    </div>
    
   <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
   
   <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>
   
   <div class="form-group">
      <label for="Email:">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Email:" name="email">

    </div>
   
   <div class="form-group">
      <label for="Age:">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age:" name="age">

    </div>
    <input type="submit" class="btn btn-default" value="Submit">
  </form>
</div>


</body>
</html>