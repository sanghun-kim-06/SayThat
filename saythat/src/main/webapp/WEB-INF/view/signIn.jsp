<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<form action="/signIn" method="post" name="frm">
<label id="label1">ID : </label>
<input type="text" id="id" name="id"><br><br>
<label>PASSWORD : </label>
<input type="password" id="password" name="password"><br><br>
<input type="checkbox" id="login_keep" name="login_keep">
<label>로그인 유지</label><br><br><br>
<input type="submit" onclick="return check()">
</form>
<br>
<a href="/findId">ID 찾기</a>
<a href="/findPassword">PW 찾기</a>
<script>
<%
//로그인 실패의 경우 에러 경고창을 띄우고 Id 입력에 포커스를 맞춘다.
if(request.getAttribute("loginError") != null){
	String loginError = (String)request.getAttribute("loginError"); 
%>
	alert('<%=loginError %>');
	document.frm.id.focus();
	<% 
}
%>

function check(){
	if(document.frm.id.value.trim() == ""){
		document.frm.id.focus();
		alert("아이디를 입력해주세요");
		return false;
	}
	if(document.frm.password.value.trim() == ""){
		document.frm.password.focus();
		alert("비밀번호를 입력해주세요");
		return false;
	}
	return true;
}
</script>
</body>
</html>