<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<aside id="left">
				<img id="login_ttl" src="${loot }/SH_img/login_title.gif">
					<c:if test="${loginResult == 1 && ur_class == 0}">
					<article class="login_box">
					<p>${ur_id}님환영합니다.</p>
					<table>
						<tr>
							<td>
								<button class="buttons" type="submit" onclick="location.href='favoriteshow.do'">				
									<img src="${loot }/SH_img/SH_zzimbtn.png">				<!-- 찜목록 -->
								</button>
							</td>
							<td>
								<button class="buttons" type="submit" onclick="location.href='update.do'">
									<img src="${loot }/SH_img/SH_updatebtn.png">			<!-- 회원정보수정 -->
								</button>
							</td>
							<td>
								<button class="buttons" type="submit" onclick="location.href='myWritelist.do'">
									<img src="${loot }/SH_img/SH_mywritebtn.png">			<!-- 내가쓴글 -->
								</button>
							</td>
							<td>
								<button class="buttons" type="submit" onclick="location.href='logout.do'">
									<img src="${loot }/SH_img/SH_logoutbtn.png">			<!-- 로그아웃 -->
								</button>
							</td>
						</tr>
					</table>
				</article>
			</c:if>
			<c:if test="${loginResult != 1}">
					<form action="loginForm.do" method="post">													<!-- 로그인 -->
						<article class="login_box">
								<table>
									<tr>
										<td id="login_input">
											<input class="main_input" type	="text" name="ur_id" placeholder="id">
											<input class="main_input" type="password" name="ur_passwd" placeholder="password">
											<input id="signUp"  type="button" value="회원가입" onclick="location.href='signUp.do'">
											<input id="signUp"  type="submit" value="로그인">
										</td>
									</tr>
								</table>
						</article>
					</form>
				</c:if>
				<c:if test="${loginResult == 1 && ur_class == 1}">
				<article class="login_box">
					<p>관리자님! 환영합니다.</p>
					<table>
						<tr>
								<td>
									<button class="buttons" type="submit" onclick="location.href='admin_UserList.do'">								
										<img src="${loot }/SH_img/userList_btn.png">				<!-- 유저목록보기 -->
									</button>
								</td>
								<td>
									<button class="buttons" type="submit" onclick="location.href='reportList.do'">
										<img src="${loot }/SH_img/singo_btn.png">			<!-- 신고내역보기 -->
									</button>
																	</td>
								<td>
									<button class="buttons" type="submit" onclick="location.href='noticeWrite.do'">
										<img src="${loot }/SH_img/gongji_btn.png">			<!-- 공지사항글쓰기 -->
									</button>
								</td>
								<td>
									<button class="buttons" type="submit" onclick="location.href='logout.do'">
										<img src="${loot }/SH_img/SH_logoutbtn.png">			<!-- 로그아웃 -->
									</button>
								</td>
						</tr>
					</table>
				</article>
				</c:if>
				<div id="sub_menu">
					<table>
						<tr>
							<td><input class="gongji_singo"  type="button" value="공지사항" onclick="location.href='noticeList.do'"></td>
							<td><input class="gongji_singo"  type="button" value="신고게시판" onclick="location.href='reportGesi.do'"></td>
							<td><input class="gongji_singo"  type="button"  value="글쓰기" onclick="location.href='write.do'"></td>
						</tr>
					</table>
				</div>
			</aside>