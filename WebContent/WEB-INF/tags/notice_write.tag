<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<h2>공지사항 등록</h2>
<form action="noticeWriteForm.do" method="post">
		<table class="noticewrite">	

			<tr>
				<th>제목</th>
				<td><input type="text" name="title" required="required">
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50"  name="body" required="required"></textarea>
				</td>
			</tr>
			
		</table>
		<div id="noticewrite_btn">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.back()">
			</div>
	</form>