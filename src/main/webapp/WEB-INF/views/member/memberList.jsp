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
			<h1>MemberList</h1>

			<form class="col-xs-6" action="./memberList">
				<div class="input-group">
					<select class="form-control" id="sel1" name="kind">
						<option value="id">ID</option>
						<option value="name">Name</option>
						<option value="phone">Phone</option>
						<option value="email">E-mail</option>
					</select> 
					<input type="text" class="form-control" placeholder="Search" name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>

			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td><a href="./meberSelect?num=${vo.id}">${vo.id}</a></td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
					</tr>
				</c:forEach>
			</table>

			<div class="pageIndex">
				<ul class="pagination">
					<c:if test="${mp.curBlock gt 1}">
						<li><a
							href="./memberList?curPage=${mp.startNum-1}&kind=${mp.kind}&search=${mp.search}">[이전]</a></li>
					</c:if>
					<c:forEach begin="${mp.startNum}" end="${mp.lastNum}" var="i">
						<li><a
							href="./memberList?curPage=${i}&kind=${mp.kind}&search=${mp.search}">${i}</a></li>
					</c:forEach>
					<c:if test="${mp.curBlock lt mp.totalBlock}">
						<li><a
							href="./memberList?curPage=${mp.lastNum+1}&kind=${mp.kind}&search=${mp.search}">[다음]</a></li>
					</c:if>
				</ul>
			</div>

			<div>
				<a href="./memberJoin" class="btn btn-danger">Join</a>
			</div> 

		</div>
	</div>
</body>
</html>