<%@ page import="javax.security.auth.message.callback.PrivateKeyCallback.Request, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전자나라</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	if(${deleteResult} == 1){
		alert("삭제되었습니다!");
	}
</script>
<script>
	function deleteCheck(){
		if(confirm("정말삭제하시겠습니까?") == true){
			location.href="deleteForm.do?bd_num=${board.bd_num}";	
		}else {
			return false;
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="${loot }/css/SH_main.css">
</head>
<body>
	<div>
			<tf:login_box/>				<!-- 로그인박스 -->
			<tf:top_logo/>				<!-- 상단 로고 -->
			<section id="main">
					<c:if test="${tag_num == null}">
						<tf:board_box/>									<!-- 게시판 표출 -->
					</c:if>
					<c:if test="${tag_num == 0 }">			<!-- 찜목록 -->
						<tf:favorite/>
					</c:if>
					<c:if test="${tag_num == 1 }">			<!-- 정보수정 -->
						<tf:member_update/>
					</c:if>
					<c:if test="${tag_num == 2 }">			<!-- 내가쓴글 -->
						<tf:mw_list/>
					</c:if>
					<c:if test="${tag_num == 3 }">			<!-- 유저목록 -->
						<tf:member_list/>
					</c:if>
					<c:if test="${tag_num == 4 }">			<!-- 신고내역 -->
						<tf:report_list/>
					</c:if>
					<c:if test="${tag_num == 5 }">			<!-- 공지등록 -->
						<tf:notice_write/>
					</c:if>
					<c:if test="${tag_num == 6 }">			<!-- 공지사항 보기 -->
						<tf:notice_list/>
					</c:if>
					<c:if test="${tag_num == 7 }">			<!-- 신고확정게시판 -->
						<tf:reportGesi/>
					</c:if>
					<c:if test="${tag_num == 8 }">			<!-- 글쓰기 -->
						<tf:board_write/>
					</c:if>
					<c:if test="${tag_num == 9 }">			<!-- 게시글 보기 -->
						<tf:content_list/>
					</c:if>
					<c:if test="${tag_num == 10 }">			<!-- 회원가입 -->
						<tf:signUp/>
					</c:if>
					<c:if test="${tag_num == 11 }">			<!-- 신고하기 -->
						<tf:report_write/>
					</c:if>
					<c:if test="${tag_num == 12 }">			<!-- 신고글 보기 -->
						<tf:report_detail/>
					</c:if>
					<c:if test="${tag_num == 13 }">			<!-- 회원 탈퇴 -->
						<tf:member_out/>
					</c:if>
					<c:if test="${tag_num == 14 }">			<!-- 글쓰기 수정 -->
						<tf:board_write_update/>
					</c:if>
					<c:if test="${tag_num == 15 }">			<!-- 공지사항글 보기 -->
						<tf:notice_detail/>
					</c:if>
					<c:if test="${tag_num == 16 }">			<!-- 공지사항글 수정 -->
						<tf:notice_update/>
					</c:if>
					<c:if test="${tag_num == 17 }">			<!-- 검색한 게시글 -->
						<tf:serch_content/>
					</c:if>
			</section>
		<footer>
		<img src="${loot }/SH_img/SH_footer_logo.gif">
		<table>
			<tr>
				<td>중앙정보기술인재원 2조</td>
			</tr>
			<tr>
				<td>구성원 : 김원겸 홍성화 마재현 심문철 김의환 김승율 김기전</td>
			</tr>
			<tr>
				<td>서울시 강남구 </td>
			</tr>
		</table>
	</footer>
	</div>
	
</body>

</html>