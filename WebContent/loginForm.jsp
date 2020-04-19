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
<c:if test="${result == 0}">
	<script type="text/javascript">
	alert("아이디 혹은 패스워드가 일치하지않습니다.");
	location.href="khome.do";
	window.close();
	</script>
</c:if>
<c:if test="${result == 1 && ur_class == 0}">
	<script type="text/javascript">
	alert("${ur_id}님! 로그인이 되었습니다 !");
	location.href="khome.do";
	window.close();
	</script>
	
</c:if>
<c:if test="${result == 2}">
	<script type="text/javascript">
	alert("정지당한 사용자 입니다.");
	window.close();
	location.href="khome.do";
	</script>
</c:if>
<c:if test="${result == 1 && ur_class == 1}">
	<script type="text/javascript">
	alert("관리자님 안녕하세요!");
	window.close();
	location.href="khome.do";
	</script>
</c:if>
</body>
</html>