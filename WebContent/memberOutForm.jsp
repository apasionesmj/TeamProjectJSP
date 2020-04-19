<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${outCheck == 1}">
	<script type="text/javascript">
		alert("회원 탈퇴에 성공하셨습니다. 안녕히 가세요~");
		location.href="khome.do";
	</script>
</c:if>
<c:if test="${outCheck == 0}">
	<script type="text/javascript">
		alert("비밀번호가 맞지 않습니다.");
		location.href="loginPro.do";
	</script>
</c:if>
</body>
</html>