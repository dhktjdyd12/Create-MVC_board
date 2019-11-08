<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<br />
			<h1>로그인</h1>
			<div>
				<form id="frm" name="frm" action="loginOK.do" method="post" onsubmit="return loginFormCheck()">
					<table border="1">
						<tr>
							<th>아이디</th>
							<td>&nbsp;&nbsp;<input type="text" id="id" name="id" size="70"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>&nbsp;&nbsp;<input type="password" id="pw" name="pw" size="70"></td>
						</tr>
					</table>
					<!-- 버튼 -->
					<div>
						<br />
						<!--  <button type="button" id="login" name="login" onclick="loginFormCheck()">로그인</button> -->
						<input type="submit" value="로그인">&nbsp;&nbsp;
						<input type="reset" value="취소">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>