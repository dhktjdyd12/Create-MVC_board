<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div><h1>자유게시판 세부글 읽기</h1></div>
		<div>
			<table border="1">
			<tr>
				<td>글 세부 내역</td>
			</tr>
			</table>
		</div>
		<div>
			<br />
			<button type="button" onclick="location.href='boardWrite.do'">글쓰기</button>
		<c:if test=${id != user1 }>
		</c:if test="${id == dto.userid }">
				
		</div>
	</div>
</body>
</html>