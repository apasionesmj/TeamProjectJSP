<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- FROM NoticeModifyAction -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${Result != 0 }">
   <script type="text/javascript">
      alert("공지 수정 완료");  
      location.href="noticeDetail.do?nt_num=${nt_num}";
      
   </script>
</c:if>
<c:if test="${Result == 0 }">  
   <script type="text/javascript">
      alert("공지 수정 실패");  
      location.href="noticeModify.do?nt_num=${nt_num}";
   </script>
</c:if>
</body>
</html>