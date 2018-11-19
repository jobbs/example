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
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="detailUrl" value="selectScript.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>
<c:url var="listUrl" value="selectScriptList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'sRoutingScriptSeq'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<div class="col-box-100">
	<div class="info">
		<h2>실행스크립트 입력 시 아래의 문자를 사용하시면 해당 정보로 변환됩니다.</h2>
		<p>- {destination} : 목지지 IP주소</p>
		<p>- {gateway} : 게이트웨이 IP주소</p>
		<p>- {mask} : 서브넷마스크</p>
		<p>- {nic} : 네트워크인터페이스명</p>
		<p style="padding: 10px; background-color:#f5f5f5; border: 1px solid #d8d8d8"">
			예시1) echo "{destination}/24 via {gateway} dev {nic}" >> /etc/sysconfig/network-script/route-"+{nic}<br />
			예시2) route -p add {destination} mask {mask} {gateway}
		</p>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form:form commandName="vo">
			<table class="table table-horizon">
				<caption>스태틱라우팅 스크립트 저장 테이블</caption>
				<colgroup>
					<col class="col12">
					<col class="col22">
					<col class="col12">
					<col class="col22">
					<col class="col12">
					<col class="col22">
				</colgroup>
				<tbody>
				<tr>
					<th><span class="text-red">*</span> OS유형</th>
	    			<td>
	    				<nform:selectCode
                    		name="osTyCd"
                    		id="osTyCd"
                    		parentCd="102"
                    		parentGrpCd="003"
                    		value="${vo.osTyCd }"
                    		title="OS유형"
                    		class="form-control essential" />
	    			</td>
					<th><span class="text-red">*</span> OS버전</th>
					<td><form:input path="osVer" cssClass="form-control essential" title="OS버전" maxlength="16" /></td>
					<th>사용여부</th>
					<td>
						<form:select path="useYn" cssClass="form-control essential" title="사용여부">
			              	<form:option value="Y">사용</form:option>
			              	<form:option value="N">미사용</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 실행스크립트</th>
					<td colspan="6">
						<form:input path="script" cssClass="form-control essential" title="실행스크립트" maxlength="4000" />
					</td>
				</tr>
				<tr>
					<th>비고</th>
					<td colspan="6">
						<form:input path="dc" cssClass="form-control" title="비고" maxlength="4000" />
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
			<c:when test="${vo.sRoutingScriptSeq > 0 }">
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

	if(!fn_form_validation("vo")){
		return;
	}

	jConfirm('스태틱라우팅스크립트 정보를 저장하시겠습니까?', function() {
		var options = {
				type : 'post',
				dataType : 'json',
				success : function(result) {

					alert_message(result.messageList, function() {
						if (result.success) {
							if (result.procType == "insert") {
								location.href = "selectScriptList.do";
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
</script>