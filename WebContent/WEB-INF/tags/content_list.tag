<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->

<script>
	if(${replydelete} == 1){
		 alert("삭제되었습니다");
	}
</script>

<!-- 비로그인 사용자는 글을 못봄 -->
	<h2	id="contents_title">게시판 상세내역</h2>
<div>
	<table class="contents">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<tr>
			<td>${board.bd_num}</td>
			<td>${board.bd_title}</td>
			<td>${board.bd_ur_id}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<th>종류</th>
			<th>물품가격</th>
		</tr>
		<tr>
			<td>${board.bd_date}</td>
			<td>
			<c:choose>
                <c:when test="${board.bd_sellbuy eq 'sell' }">팝니다</c:when>
                <c:otherwise>삽니다</c:otherwise>
            </c:choose>
            </td>
			<td>${board.bd_price }원</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td colspan="2"><img src="./saveFile2/${board.bd_image }" width="300" height="300" onerror="this.style.display='none'" />
			</td>
		</tr>			
		<tr>
			<th>내용</th>
			<td colspan="2"><div>${board.bd_write}</div></td>
		</tr>
		<!-- 관리자가 로그인 해서 상세내역에 들어갔을 경우   -재현 -->
		<!-- test 1,2,3, -->
		
	</table>
	<c:choose>
		<c:when test="${ur_class == 1}">
		<div id="contents_btn">
			
				<input type="button" value="삭제" onclick="location.href='deleteForm.do?bd_num=${board.bd_num}'">			
				<input type="button" value="전체 목록" onclick="location.href='khome.do?bd_num=${board.bd_num}'">
				<input type="button" value="뒤로가기" onclick="history.back()">
			
		</div>
		</c:when>
		<c:when test="${ur_id eq board.bd_ur_id}">
		<div id="contents_btn">
			
				<input type="button" value="수정" onclick="location.href='writeUpdateBtn.do?bd_num=${board.bd_num}'">
				<input type="button" value="삭제" onclick="deleteCheck()">
				<input type="button" value="내글 목록" onclick="location.href='myWritelist.do?bd_num=${board.bd_num}'">
				<input type="button" value="전체 목록" onclick="location.href='khome.do?bd_num=${board.bd_num}'">
			
		</div>
		</c:when>
		<c:otherwise>
		<div id="contents_btn">
			
				<input type="button" value="전체 목록" onclick="location.href='khome.do?bd_num=${board.bd_num}'">
				<input type="button" value="신고하기" onclick="location.href='report.do?bd_num=${board.bd_num}'">
				<input type="button" value="찜하기" onclick="location.href='favorite.do?bd_num=${board.bd_num}'"><!--김원겸 추가-->
			
		</div>
		</c:otherwise>
		</c:choose>
</div>


 <!-- **************************댓글*************************** -->
	
	
	<!--jquery이용하여 답글창 나오게 하기 -->
		<script>
			$(function() {
				$(".comment_btn").click(function() {
				
				$(this).parent().next(".reply-form").toggle(500);
				});
			});
		</script>
	<div	id="comment_box">
		<form action="reply.do" method="post" >댓글 
			<input id="comment_text"  type="text" name="replycontent">
			<input type = "hidden" name="bd_num" value="${board.bd_num}">
			<input id="commentInput_btn"  type="submit" value="댓글등록">
		</form>
		<!--게시판 댓글 출력 -->
		<c:forEach items ="${replylist}"  var = "reply"  varStatus="status">      
        		<div id="comment_box1">
         			<c:if test="${ur_id eq reply.cm_ur_id}"><!-- cm_id랑 현제 세션 아이디랑 비교 -->
       		 			<form action="ReplyDeleteAction.do" method="post" name="replydel"  >
          					<input type="hidden" name="cm_num" value="${reply.cm_num}">
         			 		<input type="hidden" name="cm_bd_num" value="${reply.cm_bd_num}">
         			 		<input type="hidden" name="cm_level" value="${reply.cm_level}">
       			  	 		<button class="comment_btn" id="replyDelete">삭제</button>
         			 	</form>
         			</c:if>
         		</div>
        		<c:if test="${reply.cm_level eq 0}">
	        		<span> ${reply.cm_ur_id}</span> | <span> ${reply.cm_body}</span> | <span> ${reply.cm_date}</span>
	         	</c:if>
         		<c:if test="${reply.cm_level >=1}">
          			<span> <c:forEach var="dept" begin="1" end="${reply.cm_level}"> &nbsp;</c:forEach>  ㄴ ${reply.cm_ur_id} |  ${reply.cm_body} | ${reply.cm_date}</span>
         		</c:if>
         		<span>
        			 <button class="comment_btn" onclick="focus()">답글등록</button>
        	 	</span>
         		<div class="reply-form" style="display: none;">
				<!--게시글 고유 번호 가져오기 -->
					<form action = "re_reply.do" name="ddong"method = "post">			
						<input type="hidden" name="bd_num" value ="${reply.cm_bd_num}" >
						<input type="hidden" name="cm_num" value ="${reply.cm_num}" >
						<input type="hidden" name="cm_groupid" value ="${reply.cm_groupid}">
						<input type="text" name="re_body"> <input  class="comment_btn" type="submit" value="확정"> <br>
					</form>
				</div>		
				<br>
        	 	
            </c:forEach>
            
</div>