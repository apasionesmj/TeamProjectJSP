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
<c:if test="${result == 1}">
	<script type="text/javascript">
	alert("회원정보 수정 성공! 다시 로그인 해 주세요!");
	location.href="khome.do";
	</script>
</c:if>
<c:if test="${result != 1}">
	<script type="text/javascript">
	alert("회원정보 수정 실패!");
	location.href="khome.do";
	</script>
</c:if>
</body>
</html>