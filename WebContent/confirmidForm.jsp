<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function wincl(){
		opener.document.frm.ur_id.value="${ur_id}";
		opener.document.frm.signUp.type="submit";
		window.close();
	}	
</script>
</head>
<body>
<c:if test="${result == 0}">
	<p>${ur_id} 는 사용할 수 없습니다.</p>
	<form>
		새로운 아이디 : <input type="text" name="ur_id"><p>
		<input type="submit" value="확인">
	</form>
</c:if>
<c:if test="${result == 1}">
	<p>${ur_id} 는 사용할 수 있습니다.</p>
	<input name="checkData" type="button" value="닫기" onclick="wincl()">
</c:if>
</body>
</html>