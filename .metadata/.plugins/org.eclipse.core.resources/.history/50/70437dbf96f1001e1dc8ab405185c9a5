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
}else if(request.getAttribute("user") != null){
	SignInVO user = (SignInVO) request.getAttribute("user");
	%>
	<script>
		alert("로그인 성공.");
		document.body.html('<%=user.getId() %> | <%=user.getPassword() %>');
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
</body>
</html>