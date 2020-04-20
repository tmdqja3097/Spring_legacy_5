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
		<h1>Member Join Form</h1>

		<form action="./memberJoin" id="frm" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="id">ID:</label> <input type="text"
					class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" id="pw" name="pw">
			</div>
			<div class="form-group">
				<label for="age">Age:</label> <input type="text"
					class="form-control" id="age" name="age">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text"
					class="form-control" id="phone" name="phone">
			</div>
			<div class="form-group">
				<label for="email">E-mail:</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>
			
			<input type="submit" id="btn" class="btn btn-default" value="Join">
		</form>

	</div>

</body>
</html>