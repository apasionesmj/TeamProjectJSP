<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->

	<form action="writeForm.do" method="post" name="writeForm" enctype="multipart/form-data">
		<table class="write">
		<caption>
		<h2>게시판 글쓰기</h2>
		</caption>
			<tr>
				<th>제목</th>
				<td><select id="selectbox" name="bd_sellbuy">
						<option value="sell">팝니다</option>
						<option value="buy">삽니다</option>
				</select> <input type="text" name="bd_title" required="required"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${ur_id}</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" value="파일 선택" name="bd_image"
					id="bd_image" accept="image/*" onchange="loadFile(event)"><br>
					<img id="output" height=100px weight=100px>
					<script>
					//업로드전 파일 미리보기용 스크립트
						var loadFile = function(event) {
							var output = document.getElementById('output');
							output.src = URL.createObjectURL(event.target.files[0]);
							//첨부하는 파일의 URL(경로)를 만들어서 ID를 사용하는 곳에 출력하여라
							output.onload = function() {
								URL.revokeObjectURL(output.src) // free memory
							}
						};
					</script>
					</td>
			</tr>
			<tr>
				<th>물품가격</th>
				<td><input type="text" name="bd_price" id="bd_price"
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>원</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="20" cols="80" name="bd_write" required="required"></textarea>
				</td>
			</tr>
			
		</table>
		<div id="write_btn">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.back()">				
			</div>
	</form>