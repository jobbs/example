<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * 		Date         author         ver          Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         	   v1.0                   최초생성
 * 2016. 11. 10.     박희택         	   v1.1             동기화 및 오류 수정
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">질문내용</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>질문 본문 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>작성자</th>
						<td><c:out value="${vo.regNm }" /></td>
					</tr>
					<tr>
						<th>작성일자</th>
						<td><fmt:formatDate value="${vo.regDt }" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><c:out value="${vo.sbjct }" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td class="editor"><c:out value="${vo.contents }" escapeXml="false" /></td>
					</tr>
					<c:choose>
						<c:when test="${fn:length(vo.boardFiles) > 0 }">
							<tr>
								<th>첨부파일</th>
								<td><c:forEach var="file" items="${vo.boardFiles }">
										<c:url var="downUrl" value="downfile.do">
											<c:param name="seq" value="${file.seq }" />
										</c:url>
										<a href="<c:out value="${downUrl }" />"><c:out value="${file.originFileName }" /></a>
									</c:forEach></td>
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
		<c:url var="insertansUrl" value="insertAnswer.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>

		<c:if test="${answervo.parentSeq eq NULL }">
			<div class="pull-left btns">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
					title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
					<i class="fa fa-arrow-left"></i>
				</button>
			</div>
		</c:if>
		<div class="pull-right">
			<c:if test="${answervo.parentSeq eq NULL }">
				<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="답변추가" onclick="goToUrl('${insertansUrl}')">
					<i class="fa fa-plus"></i>
				</button>
			</c:if>
			<menu:modAuthorize regId="${vo.regId }">
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')">
					<i class="fa fa-eraser"></i>
				</button>
				<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete('${vo.boardSeq}', 'qna')">
					<i class="fa fa-times"></i>
				</button>
			</menu:modAuthorize>
		</div>
	</div>
</div>
<!-- /페이지 버튼 -->

<c:if test="${answervo.parentSeq ne NULL }">
	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">답변</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>답변 테이블</caption>
					<colgroup>
						<col class="col20">
						<col class="colAuto">
					</colgroup>
					<tbody>
						<tr>
							<th>작성자</th>
							<td class="alignL"><c:out value="${answervo.regNm }" /></td>
						</tr>
						<tr>
							<th>작성일자</th>
							<td class="alignL"><fmt:formatDate	value="${answervo.regDt }" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th>답변내용</th>
							<td colspan="3" class="alignL"><c:out value="${answervo.contents }" escapeXml="false" /></td>
						</tr>
						<c:choose>
							<c:when test="${fn:length(answervo.boardFiles) > 0 }">
								<tr>
									<th>첨부파일</th>
									<td><c:forEach var="file" items="${answervo.boardFiles }">
											<c:url var="downanswerUrl" value="downfile.do">
												<c:param name="seq" value="${file.seq }" />
											</c:url>
											<a href="<c:out value="${downanswerUrl }" />"><c:out value="${file.originFileName }" /></a>
										</c:forEach></td>
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
			<c:url var="updateansUrl" value="updateAnswer.do">
				<c:forEach var="curParam" items="${param }">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:forEach>
				<c:param name="parentSeq" value="${answervo.boardSeq }" />
			</c:url>
			<c:url var="listUrl" value="selectBoardList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'boardSeq'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>

			<div class="pull-left btns">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
					title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
					<i class="fa fa-arrow-left"></i>
				</button>
			</div>

			<menu:modAuthorize regId="${answervo.regId }">
				<div class="pull-right">
					<button class="btn btn-hover-yellow" data-toggle="tooltip"
						data-original-title="답변수정" onclick="goToUrl('${updateansUrl}')">
						<i class="fa fa-eraser"></i>
					</button>
					<button class="btn btn-hover-red" data-toggle="tooltip"
						data-original-title="답변삭제" onclick="doDelete('${answervo.boardSeq}', 'answer')">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</menu:modAuthorize>
		</div>
	</div>

</c:if>

<script type="text/javascript">
function doDelete(seq, type){
	var msg = (type=="qna")?"게시물을 삭제하시겠습니까?":"답변을 삭제하시겠습니까?";

	jConfirm(msg, function() {
		var url = "<c:url value="deleteBoard.do" />";

		$.ncmsLoding.startFullScreen();
		$.post(url, {"boardSeq": seq}, function(result) {
			alert_message(result.messageList, function() {
				if( result.success) {
					if(type == "answer"){
						location.reload();
					}else{
						goToUrl('${listUrl}');
					}
				}
			});
		}, "json").always(function() {
			$.ncmsLoding.remove();
		});
	});
}
</script>