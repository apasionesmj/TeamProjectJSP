<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<h2>내 게시글</h2>
		<table class="list">

		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>삽니다/팝니다</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<!-- TEST -->
		<c:if test="${totCnt > 0 }">
			<c:forEach var="board" items="${MW_list }">
				<c:if test="${ur_id eq board.bd_ur_id }">
				<tr>

					<td id="bd_num">${board.bd_num}</td>
					<td>${board.bd_ur_id}</td>
					<td id="bd_sellbuy">${board.bd_sellbuy}</td>
					<td><a href='gesiContent.do?bd_num=${board.bd_num}'>${board.bd_title}</a></td>
					<td>${board.bd_date}</td>
				</tr>
				<c:set var="startNum" value="${startNum - 1 }" />
				</c:if>
			</c:forEach>
		</c:if>
		
	</table>
	<div id="list_btn">
			
				<input type="button" value="돌아가기" onclick="location.href='khome.do'">
			
		