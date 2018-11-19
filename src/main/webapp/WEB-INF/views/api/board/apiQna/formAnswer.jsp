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
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 * 2016. 11. 10.     정승용         v1.0            소스동기화
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="detailUrl" value="selectBoard.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>

<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">질문내용</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>질문 내용 테이블</caption>
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
						<td><fmt:formatDate	value="${vo.regDt }" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><c:out value="${vo.sbjct }" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><c:out value="${vo.contents }" escapeXml="false" /></td>
					</tr>
					<c:choose>
						<c:when test="${fn:length(vo.boardFiles) > 0 }">
							<tr>
								<th>첨부파일</th>
								<td><c:forEach var="file" items="${vo.boardFiles }">
										<c:url var="downUrl" value="downfile.do">
											<c:param name="seq" value="${file.seq }" />
										</c:url>
										<a href="<c:out value="${downUrl }" />"><c:out
												value="${file.originFileName }" /></a>
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

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">답변정보</h3>
		</div>
		<div class="box-body no-padding">
			<form:form commandName="answervo" enctype="multipart/form-data">
				<form:hidden path="parentSeq" value="${vo.boardSeq }" />
				<form:hidden path="boardSeq" value="${answervo.boardSeq }" />
				<table class="table table-horizon">
					<caption>답변 등록 테이블</caption>
					<colgroup>
						<col class="col20">
						<col class="colAuto">
					</colgroup>
					<tbody>
						<form:hidden path="sbjct" cssClass="form-control" title="제목" value="${vo.sbjct }" maxlength="4000"/>
						<tr>
							<th><span class="text-red">*</span>내용</th>
							<td><form:hidden path="contents" cssClass="form-control essential" cssStyle="height:260px" title="내용" maxlength="4000"/></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
								<div class="" id="fileAnswerDiv"></div>
								<script type="text/javascript">
									var files = new Array();
									<c:forEach var="answerfile" items="${answervo.boardFiles }">
									files.push({
										idx : "${answerfile.seq}",
										fileName : "${answerfile.originFileName}"
									});
									</c:forEach>

									$("#fileAnswerDiv").createSelectboxFile({
										maxCount : 3,
										data : files,
										allowExt : ["jpg","png","gif","pptx", "xlsx", "hwp"]
									});
								</script>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="detailUrl" value="selectBoard.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'parentSeq'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
				title="" data-original-title="뒤로" onclick="goToUrl('${detailUrl}')"><i class="fa fa-arrow-left"></i>
			</button>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"
				data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript">
	var oEditors = [];

	setTimeout(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "contents",
			sSkinURI : "<c:url value="/resources/sedit2/SmartEditor2Skin.html" />",
			htParams : {
				bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true
			},
			fCreator : "createSEditor2"
		});
	}, '500');

	function doSubmit(result) {
		oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);

		if($("#contents").val() == "<br>"){
			$("#contents").val("");
		}

		if (!fn_form_validation("answervo")) {
			return;
		}

		jConfirm('Q&A답변 정보를 저장하시겠습니까?', function() {
			var options = {
					type : 'post',
					dataType : 'json',
					success : function(result) {

						alert_message(result.messageList, function() {
							if (result.success) {
								location.href = "${detailUrl}";
							}
						},(result.success?"INFO":""));
					},
					error : function(xhr, textStatus, errorThrown) {
						jAlert('오류 발생');
					}
			};

			$('#answervo').ajaxSubmit(options);
		});
	}

	function deleteFile(obj){
		var con = confirm("파일을 삭제 하시겠습니까?");
		if( !con ) return false;
		$(obj).parent().parent().remove();
	}
</script>