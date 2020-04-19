<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
	<h2 id="board_title">신고게시판</h2>
	<table class="report">

		<tr>
			<th>신고번호</th>
			<th>게시글 번호</th>
			<th>게시글 제목</th>
			<th>말머리</th>
			<th colspan="4">내용</th>
		</tr>
		<c:forEach var="ReportGesiDto" items="${reportGesi_list}">
			<tr>
				<td>${ReportGesiDto.s_r_num}</td>
				<td>${ReportGesiDto.bd_num}</td>
				<td>${ReportGesiDto.bd_title}</td>
				<td>
				<c:choose>
				<c:when test="${ReportGesiDto.bd_sellbuy eq 'sell'}">
				팝니다
				</c:when>
				<c:otherwise>
				삽니다
				</c:otherwise>
				</c:choose>
				</td>
				<td colspan="4">${ReportGesiDto.bd_write}</td>
			</tr>
		</c:forEach>
			
	</table>
	<div id="reportgesi_btn">
				<input type="button" value="메인으로"
					onclick="location.href='khome.do'">
			</div>