<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복체크</title>
<script type="text/javascript">
	function idCheck() {
		window.opener.document.getElementById("idch").value="Checked";
		window.opener.document.getElementById("name").focus();
		window.close();
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${b == false }">
			<h1>${id}는 존재하는 아이디입니다.</h1>
		</c:when>
		<c:otherwise>
			<h1>${id}는 사용할 수 있는 아이디입니다.</h1>
		</c:otherwise>
	</c:choose>
	<div>
		<button type="button" onclick="idCheck()">확인</button>
	</div>
</body>
</html>