<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reportAfter처리 완료 여부</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("처리 완료");
			location.href = "khome.do";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("이미 박제된 게시판 입니다.");
			history.back();
		</script>
	</c:if>
</body>
</html>