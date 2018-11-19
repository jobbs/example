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

<c:url var="detailUrl" value="selectBoard.do">
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

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form:form commandName="vo" enctype="multipart/form-data">
			<table class="table table-horizon">
				<caption>공지사항 등록 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th><span class="text-red">*</span> 제목</th>
					<td><form:input path="sbjct" cssClass="form-control essential" title="제목" maxlength="4000" /></td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 내용</th>
					<td>
						<form:hidden path="contents" cssClass="form-control essential" cssStyle="height:260px" title="내용" maxlength="4000"/>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<div class="" id="fileDiv"></div>
						<script type="text/javascript">

						var files = new Array();
						<c:forEach var="file" items="${vo.boardFiles }">
							files.push({idx : "${file.seq}", fileName : "${file.originFileName}"});
						</c:forEach>

						$("#fileDiv").createSelectboxFile({maxCount:3, data : files});
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
		<div class="pull-left btns">
		<c:choose>
			<c:when test="${vo.boardSeq > 0 }">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${detailUrl}')"><i class="fa fa-arrow-left"></i></button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
			</c:otherwise>
		</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
		</div>
	</div>
</div>

<script type="text/javascript">

var oEditors = [];

function doSubmit(){
	oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);

	if($("#contents").val() == "<br>"){
		$("#contents").val("");
	}

	if(!fn_form_validation("vo")){
		return;
	}

	jConfirm('공지사항 정보를 저장하시겠습니까?', function() {
		var options = {
				type : 'post',
				dataType : 'json',
				success : function(result) {

					alert_message(result.messageList, function() {
						if (result.success) {
							if (result.procType == "insert") {
								location.href = "selectBoardList.do";
							} else {
								location.href = "${detailUrl}";
							}
						}
					},(result.success?"INFO":""));
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('오류 발생');
				}
		};

		$('#vo').ajaxSubmit(options);
	});
}
function deleteFile(obj){
	var con = confirm("파일을 삭제 하시겠습니까?");
	if( !con ) return false;
	$(obj).parent().parent().remove();
}

setTimeout(function() {
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "contents",
		sSkinURI: "../../../resources/sedit2/SmartEditor2Skin.html",
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true
		},
		fCreator: "createSEditor2"
	});
}, '500');


</script>