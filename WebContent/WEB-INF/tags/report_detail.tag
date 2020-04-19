<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<h2>신고글 보기</h2>
<form action="reportlist.do" method="post">
		<input type="hidden" name="s_r_division" value="1">
				<!-- 신고글은 1 로 값 설정 (신고글과 찜글이 같은 table을 쓰니까) -->
		<table class="Detail">

			<tr>
				<th>신고 제목</th>
				<td><input type="text" name="s_r_title" required="required" value = "${repordetail.s_r_title}" 
				disabled>
			<tr>
				<th>신고 내용</th>
				<td><textarea disabled rows="10" cols="30" name="s_r_body"
						required="required" >${repordetail.s_r_body}</textarea></td>
			</tr>

			
		</table>
		<div id="report_btn">
					<input type="button" value="거부" onclick="location.href='reportAfter.do?s_r_num=${repordetail.s_r_num}&s_r_division=2&s_r_bd_num=${repordetail.s_r_bd_num}'">	
					<input type="button" value="박제" onclick="location.href='reportAfter.do?s_r_num=${repordetail.s_r_num}&s_r_division=3&s_r_bd_num=${repordetail.s_r_bd_num }'">
					<input type="button" value="글로가기" onclick="location.href='gesiContent.do?bd_num=${repordetail.s_r_bd_num}'">
					<input type="button" value="뒤로가기" onclick="history.back()">
				
			</div>
	</form>