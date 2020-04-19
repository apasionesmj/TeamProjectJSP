<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loot" value="${pageContext.request.contextPath}" /><!-- 유동 contextpath -->
<div id="main_box">
						<table  class="main_items">
                        <tr>
                           <th class="main_border">번호</th>
                           <th class="main_border">말머리</th>
                           <th colspan="4"  class="main_border">제 목</th>
                           <th class="main_border">ID</th>
                           <th class="main_border">등록일</th>
                           <th class="main_border">조회수</th>
                        </tr>         
                        <!-- DB 총 갯수가 하나라도 있으면... -->            
                        <c:if test="${totCnt>0 }">
                           <!-- 10개이하의 항목을 가져왔을때 -->
                            <c:forEach var="used_boardDto" items="${board_list }">
                              <tr>
                                 <!-- 번호 출력 -->
                                 <td class="main_border" id="bd_num">${startNum }</td>
                                 <td class="main_border" id="bd_head">
                                 <c:choose>
                                 <c:when test="${used_boardDto.bd_sellbuy eq 'sell' }">팝니다</c:when>
                                 <c:otherwise>삽니다</c:otherwise>
                                 </c:choose>
                                 </td>
                                 <td colspan="4" class="main_border" id="bd_title"><a href="gesiContent.do?bd_num=${used_boardDto.bd_num }" >${used_boardDto.bd_title }</a></td>
                                 <td class="main_border" id="bd_rest">${used_boardDto.bd_ur_id }</td>
                                 <td class="main_border" id="bd_rest">${used_boardDto.bd_date }</td>
                                 <td class="main_border" id="bd_rest">${used_boardDto.bd_readCount }</td>                                 
                              </tr>
                              <!-- 번호를 -1씩 줄인다 -->
                              <c:set var="startNum" value="${startNum - 1 }" />
                              <!-- 번호가 없으면 빈 칸으로 출력 -->
                              <c:if test="${startNum==0 }">
                              <c:forEach var="i" begin="1" end="${10-(totCnt%10) }">
                                 </c:forEach>
                              </c:if>                        
                               </c:forEach>                                            
                        </c:if>
                        <!-- DB 총 갯수가 하나도 없으면... -->
                        <c:if test="${totCnt==0 }">
                           <tr>
                              <td colspan="7">데이터가 없습니다.</td>
                           </tr>
                        </c:if>
                    </table>
					
					<div  class="main_footer">
						<table>
							<tr>
								<td>
									<c:if test="${startPage > blockSize }" >
										<a href="khome.do?pageNum=${startPage-blockSize}">[◀ 이전 ]</a>
									</c:if>
									<c:forEach var="i" begin="${startPage }" end="${endPage }">
										<a href='khome.do?pageNum=${i}'>[ ${i } ]</a>
									</c:forEach>
									<c:if test="${endPage < pageCnt }">
										<a href='khome.do?pageNum=${startPage+blockSize}' >[다음 ▶ ]</a>
									</c:if>
								</td>
							</tr>
						</table>
					</div>
					
							<!-- page 나타나는 부분 END -->
							
							
					<div id="serch">
						<form action="searchPro.do?pageNum=${pageNum}" method="post">
							<table>
								<tr>
									<td>
										<select name="bd_sellbuy" id="bd_sellbuy">
											<option value="ALL" <c:if test="${bd_sellbuy=='ALL' }">selected</c:if>>전체</option>
											<option value="SELL" <c:if test="${bd_sellbuy=='SELL' }">selected</c:if>>팝니다</option>
											<option value="BUY" <c:if test="${bd_sellbuy=='BUY' }">selected</c:if>>삽니다</option>
										</select>
									</td>
									<td>
										<input id="search_input" type="text" name="search" value="${search }" placeholder="검색어 입력">
									</td>
									<td>
										<button id="search_btn" type="submit">
											<img id="search_btn_img" src="${loot }/SH_img/search_btn.png">
										</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
					
					
				</div>