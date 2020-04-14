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
  <h2>Form control: text area</h2>
  <form action="./boardAdd" method="post">
    <div class="form-group">
   	 <label for="comment">Subject:</label>
      <textarea class="form-control" rows="1" id="subject" name="subject"></textarea>
      <label for="comment">Text:</label>
      <textarea class="form-control" rows="15" id="text" name="text"></textarea>
      <br>
      <input type="submit" class="btn btn-primary" value="작성완료">
    </div>
  </form>
</div>
</body>
</html>