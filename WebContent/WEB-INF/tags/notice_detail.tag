<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2 >공지사항 상세보기</h2>
<table class="Detail">
			<tr>
				<th>공지번호</th>
				<td>${noticeDetail.nt_num}</td>
			<tr>
			<tr>
				<th>공지제목</th>
				<td>${noticeDetail.nt_title}</td>
			<tr>
				<th>공지내용</th>
				<td>${noticeDetail.nt_body}</td>
			</tr>

			
		</table>
		<div id="Detail_btn">
				
					<input type="button" value="목록으로" onclick="location.href='noticeList.do?nt_num=${noticeDetail.nt_num}'">
				</div>
				<c:if test="${ ur_class == 1}">
					<div id="Detail_btn">
						<!-- NoticeDeleteFormAction -->
						<input type="button" value="삭제" onclick="location.href='noticeDeleteForm.do?nt_num=${noticeDetail.nt_num}'">
						<!-- NoticeModifyFormAction -->
						<input type="button" value="수정" onclick="location.href='noticeModify.do?nt_num=${noticeDetail.nt_num}'">
					</div>
				</c:if>
			</tr>