<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->

<script type="text/javascript">
	function chk(){
		if(frm.ur_passwd.value != frm.ur_passwd1.value){
			alert("재입력비밀번호가 일치하지 않습니다.");
			return false;
		}
		return true;
	}
</script>
<body>
	<h2>회원 탈퇴</h2>
	<form action="memberOurForm.do" method="post" name="frm" onsubmit="return chk()">
		<table class="signout">
			<tr>
				<th>비밀번호 입력</th>
				<td><input type="password" name="ur_passwd" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호 재입력</th>
				<td><input type="password" name="ur_passwd1" required="required"></td>
			</tr>
			
		</table>
		<div id="signout_btn">
				<input type="submit" value="회원 탈퇴">
				<input type="button" value="탈퇴 취소" onclick="location.href='update.do'">
			</div>
	</form>
</body>