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
		<h1>Notice Update Form</h1>
		
		
		<form action="./${board}Update" id="frm" method="post">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="hidden" class="form-control" id="num" name="num" value="${vo.num}">
		  </div>
		  	  
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" class="form-control" id="title" name="title" value="${vo.title}">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" class="form-control" id="writer" name="writer" value="${vo.writer}" disabled="disabled">
		  </div>
		 <div class="form-group" >
		    <label for="contents">Contents:</label>
		    <textarea rows="5" cols="" class="form-control" id="contents" name="contents">${vo.contents}</textarea>
		  </div> 
		  
		  
		  
		  
		  <input type="submit" id="btn" class="btn btn-default" value="Update">
		</form>
		
	</div>
</body>

</html>