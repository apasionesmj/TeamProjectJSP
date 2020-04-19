<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<script type="text/javascript">
	function chk() {
		if (frm.ur_passwd1.value != frm.ur_passwd2.value) {
			alert("변경 비밀번호가 일치하지 않습니다.");
			// frm.passwd2.focus(); 		문제가 생겨서 사용안하기로함.
			return false;
		}
		return true;
	}
</script>
	<h2>${ur_id}님의 회원정보 수정</h2>
	<form action="updateForm.do" method="post" name="frm" onsubmit="return chk()">
		<table class="update">
		
	
		
			<tr>
				<th>아이디</th>
				<td id="update_id">${ur_id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td id="update_name">${ur_name}</td>
			</tr>
			<tr>
				<th>현재 비밀번호</th>
				<td><input type="password" name="ur_passwd" required="required"></td>
			</tr>
			<tr>
				<th>변경 비밀번호</th>
				<td><input type="password" name="ur_passwd1" required="required"></td>
			</tr>
			<tr>
				<th>변경 비밀번호 확인</th>
				<td><input type="password" name="ur_passwd2" required="required"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="ur_address" required="required" value="${ur_address}"></td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td><input type="text" name="ur_phone" required="required" value="${ur_phone}" pattern="\d{2,3}-\d{3,4}-\d{4}" placeholder="xxx-xxxx-xxxx" title="2,3자리-3,4자리-4자리"></td>
			</tr>
			
		</table>
		<div id="update_btn">
				<input type="button" value="회원탈퇴" onclick="location.href='memberOutCheck.do'">
					<input type="submit" value="정보수정">
					<input type="button" value="취소" onclick="location.href='khome.do'">
			</div>
	</form>