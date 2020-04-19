<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
 <h2 id="board_title">공지사항</h2>
    <table class="notice">

    	<tr>
        	<th>번호</th>
        	<th>제목</th>
        	<th>공지일</th>
    	</tr>
   
    <c:forEach var ="notice"  items="${noticeList}" >
    	
    		<tr>
   	     		<td>${notice.nt_num}</td>
				<td class="col2">
					<a href="noticeDetail.do?nt_num=${notice.nt_num}">${notice.nt_title}</a>
				</td>
   	     		<td class="col4">${notice.nt_date}</td>
			</tr>
    	
	</c:forEach>   
	
	
</table>
<c:if test="${ur_class == 1}">	
			<div id="notice_btn">
				
					<input type="button" value="공지사항쓰기" onclick="location.href='noticeWrite.do'">
					<input type="button" value="메인으로" onclick="location.href='khome.do'">
				
			</div>
		
	</c:if>