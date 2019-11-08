function loginFormCheck() {

	if(frm.id.value == "") {
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	if(frm.pw.value == "") {
		alert("비밀번호를 입력해주세요");
		frm.pw.focus();
		return false;
	}
	return true;
}
			
function memberFormCheck() {
	if(frm.id.value="") {
		alert("사용할 아이디를 입력하세요.");
		frm.id.focus();
		return false;
	}
	if(frm.idch.value="unCheck") {
		alert("아이디 중복체크를 확인해주세요.");
		return false;
	}
	if(frm.pw.value="") {
		alert("패스워드를 입력하세요.");
		frm.pw.focus();
		return false;
	}
	if(frm.pwCheck.value="") {
		alert("패스워드 확인값을 입력하세요.");
		frm.id.focus();
		return false;
	}
	if(frm.pw.value != frm.pwCheck.value ) {
		alert("패스워드 값이 일치하지않습니다.");
		frm.pwCheck.focus();
		return false;
	}
	return true;
}


function idCheck() {
	var id = frm.id.value;
	window.open("idCh.do?id="+id,"", "width=500, height=400, top=50, left=50");
}
