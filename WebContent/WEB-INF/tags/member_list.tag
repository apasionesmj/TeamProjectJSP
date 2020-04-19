<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->


<form name="member_list" method="post"action="admin_Ben.do">
	<input type="hidden" name="ur_num_send" id="ur_num_send" >
	<input type="hidden" name="ur_ben_num" id="ur_ben_num">
<h1>유저목록</h1>
<table class="memberlist">
	<tr>
		<th>유저고유번호</th>
		<th>유저아이디</th>
		<th>유저성명</th>
		<th>유저 핸드폰번호</th>
		<th>계정 생성일</th>
		<th>유저 아이피</th>
		<th>유저 밴여부</th>
		<th>유저 정지버튼</th>		
	</tr>
	<c:forEach  var="memberlist" items="${member_list }" varStatus="status">
	<tr>
			<td>${memberlist.ur_num}
			<input type="hidden" name="ur_num${status.count }" id="ur_num${status.count }" value="${memberlist.ur_num}"></td>
			<td>${memberlist.ur_id}
			<input type="hidden" name="ur_id" id="ur_id${status.count }" value="${memberlist.ur_id}"></td>
			<td>${memberlist.ur_name}</td>
			<td>${memberlist.ur_phone}</td>
			<td>${memberlist.ur_date}</td>
			<td>${memberlist.ur_localip}</td>
			<td>${memberlist.ur_ben}
			<input type="hidden" name="ur_ben${status.count }" id="ur_ben${status.count }" value="${memberlist.ur_ben}"></td>
			<td><input type="button" id="ben${status.count }" name="ben" value='btn_msg()'></td>
	</tr>
		<%--  staatus.count는 1부터 시작하고 배열은 0부터 시작하기 때문에 -1을 해서 0부터 들어갈 수 있게 한다.
		    		 var i = ${status.count}-1; 
		    			//member_list폼의 ur_num_send[i]값에 member_num을 넣는다.
		    		  document.member_list.ur_num_send[i].value = member_num; 
		       		 alert('ur_num->'+member_num);
		       		 alert('${status.count}->'+${status.count});  --%>
		  <script>
		        (function process() {
		        	var buttonmsg = null;
		        	var ur_ben = $('#ur_ben' + ${status.count}).val();
				  	if(ur_ben == 0){buttonmsg = "영구정지";}else{buttonmsg = "영구정지해제";}
				 	 document.getElementById('ben' + ${status.count }).value = buttonmsg;
							}());
		 
		 </script>
		<script>/*액션으로 넘겨주고 버튼에 맞는 userid를 찾아 화면에 띄운다.*/
			  $(document).ready(function() {
		    		$('#ben'+ ${status.count}).click(function(){
		    		var member_id =  $('#ur_id' + ${status.count }).val();//id값이 ur_id${status.count }인 input박스를 찾아서 그 value값을 저장한다.
		    		var member_num = $('#ur_num' + ${status.count }).val();
		    		var ur_ben = $('#ur_ben' + ${status.count}).val();
		    		 var message = null;
		       		 if(ur_ben == 0){message = "해당유저를 영구정지 하시겠습니까?";}else{message = "해당유저의 영구정지를 해제하겠습니까?";}
		    		 document.getElementById("ur_num_send").value = member_num;//그리고 가져온 저장된값을 다른 input박스 value에 저장
		    		 document.getElementById("ur_ben_num").value = ur_ben;
		       		  var result = confirm(member_id + message);
		       		  if(result){
						  document.member_list.submit();//그리고 inputbox가 담긴 폼자체를 submit한다.
		       		  }
					 }); 
			});
		</script>
	</c:forEach>
</table>
</form>	