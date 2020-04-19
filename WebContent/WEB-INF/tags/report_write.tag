<%@ tag language="java" pageEncoding="UTF-8"%>

<h2>신고글 작성</h2>
<form action="reportPro.do?" method="post">
		<input type="hidden" name="bd_num" value="${bd_num}">
		<input type="hidden" name="ur_id" value="${login_rp}">
		<input type="hidden" name="s_r_division" value="1">
		<table class="reportwrite">
			<tr>
				<th>신고 제목</th>
				<td><input type="text" name="s_r_title" required="required">
			<tr>
				<th>신고 내용</th>
				<td><textarea rows="10" cols="90" name="s_r_body" required="required"></textarea></td>
			</tr>
		</table>
		<div id="report_btn">
			<input type="reset" value="다시작성">
			<input type="button" value="뒤로가기" onclick="history.back()">
			<input type="submit" value="확인">
		</div>
	</form>