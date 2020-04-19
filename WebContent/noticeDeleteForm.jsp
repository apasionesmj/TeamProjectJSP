<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지글 삭제 확인</title>
</head>
<!-- FROM NoticeDeleteFormAction -->
<body>
	<c:if test="${Result > 0 }">
		<script type="text/javascript">
			alert("삭제 완료 !");
			location.href = "noticeList.do";
			self.close();
		</script>
	</c:if>
	<c:if test="${Result == 0 }">
		<script type="text/javascript">
			alert("삭제 실패 !");
			location.href = "noticeDetail.do?nt_num=${nt_num}";
			self.close();
		</script>
	</c:if>
</body>
</html>