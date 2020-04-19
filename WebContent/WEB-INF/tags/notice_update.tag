<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form action="noticeUpdateForm.do" method="post">
		<input type = "hidden" name = "nt_num1" value = "${noticeDetail.nt_num}">
		<table class="noticewrite">
			<tr>
				<th>공지번호</th>
				<td>${noticeDetail.nt_num}
			<tr>
			<tr>
				<th>공지제목</th>
				<td><input type="text" name="nt_title" required="required" value = "${noticeDetail.nt_title}" 
				>
			<tr>
				<th>공지내용</th>
				<td><textarea  rows="10" cols="30" name="nt_body"
						required="required" >${noticeDetail.nt_body}</textarea></td>
			</tr>

			
		</table>
		<div id="noticewrite_btn">

						<input type="submit" value="저장">
						<input type="button" value="취소" onclick="history.back()">
			</div>
		</form>