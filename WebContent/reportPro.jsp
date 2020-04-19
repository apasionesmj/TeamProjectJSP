<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>report 완료 여부</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("신고 완료");
			location.href = "gesiContent.do?bd_num=${num}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("똑바로 헤");
			location.href = "reportForm.do?bd_num=${num}";
		</script>
	</c:if>
</body>
</html>