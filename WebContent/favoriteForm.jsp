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
<c:if test="${favorite_result == 1}">
	<script type="text/javascript">
		alert("찜 완료!");
		location.href="gesiContent.do?bd_num=${bd_num}";
	</script>
</c:if>
<c:if test="${favorite_result != 1}">
	<script type="text/javascript">
		alert("이미 찜한 상품 입니다!");
		location.href="gesiContent.do?bd_num=${bd_num}";
	</script>
</c:if>
</body>
</html>