<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
  <h2 id="board_title">신고 게시판!</h2> 
   		<table class="Detail">

    		<tr>
        		<th>번호</th>
        		<th>제목</th>
        		<th>신고내용</th>
        		<th>신고일</th>
    		</tr>
 
    <c:forEach var ="report" items="${reportlist}" >
    	
    		<tr>
   	     		<td>${report.s_r_num}</td>
				<td>
					<a href="repordeatil.do?report=${report.s_r_num}">${report.s_r_title}</a>
				</td>
				<td>${report.s_r_body}</td>
   	     		<td>${report.s_r_date}</td>
			</tr>
		
	</c:forEach>
	</table>