<%@page import="vo.SignInVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getAttribute("signUp_ok") != null){
	String signUp_ok = (String)request.getAttribute("signUp_ok");
%>
		<script>
		alert("회원가입 성공. 로그인해주세요.");
		</script>
<%
}

if(session.getAttribute("user") != null){
	SignInVO user = (SignInVO) session.getAttribute("user");
	System.out.println("유저가 널이 아닌 곳에 왔습니다");
	%>
	<script>
		alert("로그인 성공.");
		document.body.html('<%=user.getId() %> | <%=user.getPassword() %>');
	</script>
	<%
}

if(request.getAttribute("loginError") != null){
	%> 
	<script>
		alert("아이디 또는 비밀번호가 잘못되었습니다.");
	</script>
	<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Say That</title>
</head>
<body>
<h2>Say That</h2>
<p>하지 못한 말을 해야한다! Say That 메인 페이지입니다. <br></p>
<a href="/signUp">회원가입 페이지</a>
<a href="/signIn">로그인</a>
<a href="/recording">일기 쓰기</a>
</body>
</html>