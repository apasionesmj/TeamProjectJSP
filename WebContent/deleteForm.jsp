<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- FROM DeleteProAction -->
<body>
	<c:if test="${result != 0 }">
		<script type="text/javascript">
			alert("삭제 완료 ! ");
			location.href = "khome.do";
			self.close();
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("당신은 권한이 없습니다.");
			location.href = "deleteForm.do?bd_num=${bd_num}";
		</script>
	</c:if>

</body>
</html>