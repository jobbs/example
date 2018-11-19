<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>
<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
<div class="col-box-100">
	<div class="box">
	<form:form commandName="packgVo" name="patchAlrmFrm" id="patchAlrmFrm" method="post" action="">
	<input type="hidden" name="trgPackgSeq" value="${packgVo.trgPackgSeq }">
	<input type="hidden" name="trgRelease" value="${packgVo.trgRelease }">
				<div class="box-header">
  				<h3 class="box-title">알림 상세정보</h3>
				</div><!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-horizon">
					<caption>알림상세 정보 등록</caption>
  					<colgroup>
						<col class="col25">
						<col class="col25">
						<col class="col25">
						<col class="col25">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>알림명</th>
						<td colspan="3"><form:input path="patchAlrmNm" cssClass="form-control essential" value="" title="알림명" maxlength="60"/></td>
					</tr>
					<tr>
						<th>대상 패키지명</th>
						<td><form:input id="trgPackgNm" path="trgPackgNm" type="text" cssClass="form-control" value="" title="대상 패키지명" readonly="true"/></td>
						<th>최신버전</th>
						<td><form:input id="trgPackgVer" path="trgPackgVer" type="text" cssClass="form-control" value="" title="최신버전" readonly="true"/></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>적용 패키지명</th>
						<td><form:input id="applcPackgNm" path="applcPackgNm" type="text" cssClass="form-control essential" title="적용 패키지명" value="" readonly="true"/></td>
						<th><span class="text-red">*</span>버전</th>
						<td>
							<div class="input-group">
								<form:input id="applcPackgVer" path="applcPackgVer" type="text" cssClass="form-control essential" title="적용 버전" value="" readonly="true"/>
								<form:hidden path="applcPackgSeq"/>
								<form:hidden path="applcRelease"/>
								<div class="input-group-btn">
		                          <button class="btn" type="button" onclick="fn_selectPackVerList('${packgVo.trgPackgNm}','${packgVo.trgPackgSeq}')"><i class="fa fa-search"></i></button>
		                        </div>
							</div>
						</td>
					</tr>
					<tr>
						<th>알림유형</th>
						<td colspan="3">
							<form:select path="patchAlrmTyCd" title="알림유형" cssClass="form-control input-sm">
								<c:forEach var="patchAlrmTyCd" items="${patchAlrmTyCdList }">
									<form:option value="${patchAlrmTyCd.cd}" ><c:out value="${patchAlrmTyCd.cdNm }"/></form:option>
								</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
						<th>알림내용</th>
						<td colspan="3"><form:textarea id="patchAlrmCn" path="patchAlrmCn" class="form-control" rows="5" maxlength="4000" title="알림내용"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form:form>
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<menu:authorize>
	      	<button class="btn btn-dark" data-toggle="tooltip" title="" data-original-title="저장"  onclick="fn_insertParchAlrmReq();">저장</button>
	      	<button class="btn close-window">닫기</button>
      	</menu:authorize>
	</div>
</div>

<script type="text/javascript">

//패키지 선택 호출 팝업
function fn_selectPackVerList(packgNm, packgSeq){
	var url = 'selectPackgVerListP.do';
	var searchPackgNm = packgNm;
	var packgSeq = packgSeq;
	var params = {"searchType" : "S", searchPackgNm : packgNm, packgSeq : packgSeq};
	var args = {key:"SelectPackVer", width:740,height:820};
	windowOpen(url, params, args);
}

$(document).bind('selectPackgNmVer',setPackgVer);
function setPackgVer(evt) {
	var job = evt.datas;
	$('#patchAlrmFrm input[name="applcPackgSeq"]').val(job.applcPackgSeq);
	$('#patchAlrmFrm input[name="applcRelease"]').val(job.applcRelease);
	$('#patchAlrmFrm input[name="applcPackgNm"]').val(job.applcPackgNm);
	$('#patchAlrmFrm input[name="applcPackgVer"]').val(job.applcPackgVer);
}

function fn_insertParchAlrmReq(){

	if(!fn_form_validation("patchAlrmFrm")){
		return;
	}

	jConfirm('패치알림을 등록하시겠습니까?', function(){

	var options = {
			type: 'post',
			dataType: 'json',
			success: insertParchAlrmReqHandler,
			beforeSend: function() {

			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#patchAlrmFrm').attr('action', 'insertPatchAlrm.do');
		$('#patchAlrmFrm').ajaxSubmit(options);

	});
}

function insertParchAlrmReqHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo("패치알림이 등록되었습니다.", function(){
			opener.location.href = '<c:url value="selectPackgList.do"/>';
			window.close();
		});
	}
	else{
		alert_message(result.messageList);
	}

}


</script>
