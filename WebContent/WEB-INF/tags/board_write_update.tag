<%@ tag language="java" pageEncoding="UTF-8"%>

<form action="WriteUpdate.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bd_num" value="${board.bd_num}">
		<input type="hidden" name="ur_num" value="${ur_num}">
	<h2>게시글 수정</h2>
		<table class="write">

			
			
			
			<tr>
				<th>번호</th>
				<td>${board.bd_num}</td>
			</tr>
			<tr>

				<th>제목</th>
				<td><select id="selectbox" name="bd_sellbuy" value="${board.bd_sellbuy}">
						<option value="sell">삽니다</option>
						<option value="buy">팝니다</option>
				</select> <input type="text" name="bd_title" value="${board.bd_title}" required="required"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bd_ur_id" value="${board.bd_ur_id}"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" value="파일 선택" name="bd_image"
					id="bd_image" accept="image/*" onchange="loadFile(event)">
					<br>
					<img id="output" height=100px weight=100px>
					<script>
					//업로드전 파일 미리보기용 스크립트
						var loadFile = function(event) {
							var output = document.getElementById('output');
							output.src = URL.createObjectURL(event.target.files[0]);
							//첨부하는 파일의 URL(경로)를 만들어서 ID를 사용하는 곳에 출력하여라
							output.onload = function() {
								URL.revokeObjectURL(output.src) // free memory(이미지 크기를 위한 버퍼)
							}
						};
	
					</script>
					</td>

			</tr>
				<tr>
				<th>물품가격</th>
				<td><input type="text" name="bd_price" id="bd_price" value="${board.bd_price }"
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>원</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="80" name="bd_write"
						required="required">${board.bd_write }</textarea>
						
						</td>
			</tr>

			
		</table>
		<div id="write_btn">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</div>
	</form>