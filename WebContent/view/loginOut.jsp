<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<br />
			<h1>${id}님정상적으로 로그아웃되었습니다.</h1>
		</div>
		<div>
			<br />
			<button type="button" onclick="location.href='index.do'">확인</button>
		</div>
	</div>

</body>
</html>