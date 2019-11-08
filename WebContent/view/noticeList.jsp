<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<jsp:include page="topmenu.jsp"></jsp:include>
		</div>
		<br />
		<div>
			<table width="800" border="1">
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>작성일</td>
					<td>조회수</td>
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