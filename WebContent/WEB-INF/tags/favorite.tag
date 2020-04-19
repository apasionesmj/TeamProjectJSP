 <%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<form name="savelist" method="post"action="saveListDelete.do">

	<h2>찜 목록</h2>
    <table class="favorite"> 
      <tr>
        <th>번호<input type="hidden" id="bd_num" name="bd_num"/></th>
        <th>제목</th>
        <th>게시자</th>
        <th>게시물 게시일</th>
        <th>선택</th>
        </tr>
    <c:forEach var="listview" items="${list }" varStatus="status">
		<tr>
				<td>${listview.bd_num }</td><!-- 리스트안의 고유번호 -->
				<input type="hidden" id="bd_num${status.count }" name="bd_num${status.count }" value="${listview.s_r_num }"/><!-- 게시판 넘버 -->
				<td><a href="gesiContent.do?bd_num=${listview.bd_num}"id="goform">${listview.s_r_title }</a></td><!-- 찜목록 제목 -->
				<td>${listview.ur_id }</td><!-- 게시자아이디 -->
				<td>${listview.s_r_date }</td><!--게시글게시일-->
				<td><input type="button" id="lists${status.count }" name="list" value="삭제"></td>
		</tr>
		   <script>/*여러가지 넘버 버튼중에 선택한 넘버 버튼을 가져와 그데이터폼 전부를 엑션으로 넘겨준다. */
			  $(document).ready(function() {
    		$('#lists'+ ${status.count}).click(function(){
			  var result = confirm("찜목록에서 삭제 하시겠습니까?");
			/*  var i = ${status.count}-1; */
			 var member_num = $('#bd_num' + ${status.count }).val();
    		 document.getElementById('bd_num').value = member_num;
			   if(result){
				  document.savelist.submit();
			      }
			  	});
			  });
			</script>
		</c:forEach>
    </table>
    <br>
  </form>