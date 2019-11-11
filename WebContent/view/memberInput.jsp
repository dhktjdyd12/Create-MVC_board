<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div align="center">
		<!-- 위에 따라다니는 메뉴 -->
		<diV><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<br />
			<c:choose>
				<c:when test="${id != null}">	<!--아이디가 존재한다면 -->
					<h1>${id}님은이미 등록된 회원입니다.</h1>
				</c:when>
				<c:otherwise> <!-- 아이디가 없다면 -->
					<<h1>회원등록 화면</h1>
					<div>
						<form id="frm" name="frm" action="memberInputOK.do" method="post" onsubmit="return memberFormCheck()">
							<div>
								<table border="1">
									<tr>
										<th width="140">아이디</th>
										<td>
											<input type="text" id="id" name="id" size="40">&nbsp;&nbsp;
											<button type="button" id="idch" name="idch" onclick="idCheck()" value="unCheck">중복체크</button>
										</td>
									</tr> 
									<tr>
										<th width="140">이름</th>
										<td><input type="text" id="name" name="name" size="40"></td>
									</tr>
									<tr>
										<th width="140">비밀번호</th>
										<td><input type="password" id="pw" name="pw" size="40"></td>
									</tr>
									<tr>
										<th width="140">패스워드 확인</th>
										<td><input type="password" id="pwCheck" name="pwCheck" size="40"></td>
									</tr>
									<tr>
										<th width="140">주소</th>
										<td><input type="text" id="address" name="address" size="40"></td>
									</tr>
									<tr>
										<th width="140">전화번호</th>
										<td><input type="tel" id="tel" name="tel" size="40"></td>
									</tr>
								</table>
								<div>
									<!-- 버튼 -->
									<br />
									<input type="submit" value="가입">&nbsp;&nbsp;
									<input type="reset" value="취소">
								</div>
							</div>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>