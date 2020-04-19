<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->

<script type="text/javascript">
	function chk() {
		if (frm.ur_passwd.value != frm.ur_passwd1.value) {
			alert("비밀번호가 일치하지 않습니다.")
			// frm.passwd2.focus(); 		문제가 생겨서 사용안하기로함.
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
	function winop() {
		if (!frm.ur_id.value) {
			alert("id를 입력하고 사용하세요");
			frm.ur_id.focus();
			return false;
		}
		window.open("confirmidForm.do?ur_id=" + frm.ur_id.value, "",
				"width=500 height=200");
		
	}

</script>
<h2>회원가입</h2>
	<form action="signUpForm.do" method="post" name="frm" onsubmit="return chk()">
		<table class="signup">
			<tr>
				<th>이름</th>
				<td><input type="text" name="ur_name" placeholder="이름" required="required"></td>

			</tr>
			<tr>
				<th>아이디</th>
				<td class="">
					<input type="text" name="ur_id" placeholder="아이디" required="required">
					<input type="button" value="중복체크" onclick="winop()">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="ur_passwd" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="ur_passwd1" required="required"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="ur_address" placeholder="주소" required="required">
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td><input type="text" name="ur_phone" required="required" pattern="\d{2,3}-\d{3,4}-\d{4}" placeholder="xxx-xxxx-xxxx" title="2,3자리-3,4자리-4자리">
			</tr>
		</table>
			<div id="sign_btn">
					<input type="reset" value="다시작성">
					<input type="button" value="돌아가기" onclick="history.back()">	
					<input name="signUp" type="hidden" value="회원가입">
			</div>
	</form>