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
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:url var="detailUrl" value="selectErrRpt.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>
<c:url var="listUrl" value="selectErrRptList.do">
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
				<colgroup>
					<col width="130px;"/>
					<col width="*"/>
				</colgroup>
				<tbody>
				<tr>
					<th><span class="text-red">*</span> 카테고리</th>
					<td>
						<nform:selectCode parentCd="ERRCATE" parentGrpCd="070" name="errCateCd"
							whole="false" cssClass="form-control essential" value="${vo.errCateCd }" />
					</td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 제목</th>
					<td><form:input path="errTitle" cssClass="form-control essential" title="제목" maxlength="200" /></td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 결함구분</th>
					<td>
						<nform:selectCode parentCd="ERRTY" parentGrpCd="070" name="errTyCd"
							whole="false" cssClass="form-control" value="${vo.errTyCd }" />
						<form:hidden path="procssStatCd"/>
					</td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 담당자</th>
					<td>
						<div class="input-group">
							<input type="text" name="chargeNm" id="chargeNm" readonly="readonly" class="form-control" value="${vo.chargeNm }" title="담당자" />
							<div class="input-group-btn">
								<button type="button" class="btn" onclick="openUserSearch()">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
						<form:hidden path="chargeId"/>
					</td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 내용</th>
					<td>
						<form:hidden path="errCont" cssClass="form-control  essential" cssStyle="height:260px" title="내용" maxlength="4000"/>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<div class="" id="fileDiv"></div>
						<script type="text/javascript">

						var files = new Array();
						<c:forEach var="file" items="${vo.errRptFiles }">
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
			<c:when test="${vo.errRptSeq > 0 }">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${detailUrl}')"><i class="fa fa-arrow-left"></i></button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
			</c:otherwise>
		</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="jConfirm('결함사항을 저장하시겠습니까?', doSubmit);"><i class="fa fa-check"></i></button>
		</div>
	</div>
</div>

<script type="text/javascript">

var oEditors = [];

$(document).bind('selectUser',setUser);
function setUser(evt) {
	var user = evt.datas;
	$("#chargeId").val(user.userId);
	$("#chargeNm").val(user.userNm);
}

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "errCont",
	sSkinURI: "<c:url value="/resources/sedit2/SmartEditor2Skin.html" />",
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true
	},
	fCreator: "createSEditor2"
});

function doSubmit(result){

	oEditors.getById["errCont"].exec("UPDATE_CONTENTS_FIELD", []);

	if(!fn_form_validation("vo")){
		return;
	}

	var options = {
		type: 'post',
		dataType: 'json',
		success: successHandler,
		beforeSend : function() {
			$.ncmsLoding.startFullScreen();
		},
		complete : function() {
			$.ncmsLoding.remove();
		},
		error: function(xhr, textStatus, errorThrown){
			jAlert('오류 발생');
		}
	};
	$('#vo').ajaxSubmit(options);
}

function successHandler(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert") {
				location.href = "selectErrRptList.do";
			} else {
				location.href = "${detailUrl}";
			}
		}
	}, (result.success?"INFO":""));
}



function deleteFile(obj){
	var con = confirm("파일을 삭제 하시겠습니까?");
	if( !con ) return false;
	$(obj).parent().parent().remove();
}
</script>