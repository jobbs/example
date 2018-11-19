<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 07.
 * @lastmodified 2016. 10. 07.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 07.     박봉춘         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>공지사항 상세 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>작성자</th>
					<td><c:out value="${vo.regNm }"/></td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td><fmt:formatDate value="${vo.regDt }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><c:out value="${vo.sbjct }"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td class="editor"><c:out value="${vo.contents }" escapeXml="false"/></td>
				</tr>
				<c:choose>
					<c:when test="${fn:length(vo.boardFiles) > 0 }">
					<tr>
						<th>첨부파일</th>
						<td>
							<c:forEach var="file" items="${vo.boardFiles }">
								<c:url var="downUrl" value="downfile.do">
									<c:param name="seq" value="${file.seq }"/>
								</c:url>
								<a href="<c:out value="${downUrl }" />"><c:out value="${file.originFileName }"/></a><br>
							</c:forEach>
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>첨부파일</th>
							<td>등록한 파일이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">

		<c:url var="updateUrl" value="updateBoard.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectBoardList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<menu:modAuthorize regId="${vo.regId }">
			<div class="pull-right">
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
				<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
			</div>
		</menu:modAuthorize>
	</div>
</div>
<!-- /페이지 버튼 -->

<script type="text/javascript">
function doDelete(){

	jConfirm("공지사항을 삭제하시겠습니까?", function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();
		$.post("deleteBoard.do", {"boardSeq": ${vo.boardSeq}}, function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json").always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
	});

}

</script>