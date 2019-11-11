<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 공지 목록</title>
</head>
<body>
	<div align="center">
		<div>
			<jsp:include page="topmenu.jsp"></jsp:include>
		</div>
		<br />
		<div>
			<table border="1" width="800">
				<tr>
					<th width="40">글번호</th>
					<th width="80">제목</th>
					<th width="100">내용</th>
					<th width="20">작성일</th>
					<th width="20">조회수</th>
				</tr>
				<tr>
					<td>${list }</td>
					<td>제목</td>
					<td>내용</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>