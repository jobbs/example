<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 04. 28.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>




<div class="col-box-100">
	<form:form commandName="atmsclDistrbVo">
		<input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${servcAreaId }" />
		<input type="hidden" title="서비스SEQ" name="servcSeq" id="servcSeq" value="${servcSeq }" />
		<input type="hidden" title="배포설정Id" name="distrbConfId" id="distrbConfId" value="${distrbConfId }" />
		<input type="hidden" title="센터Id" name="regionId" id="regionId" value="${regionId }" />
		<input type="hidden" title="존Id" name="zoneId" id="zoneId" value="${zoneId }" />
		<input type="hidden" title="망구분코드" name="netClCd" id="netClCd" value="${netClCd }" />
		<input type="hidden" title="자원풀ID" name="rsrcPoolId" id="rsrcPoolId" value="${rsrcPoolId }" />
		<input type="hidden" title="등록자ID" name="regUserId" id="regUserId" value="${regUserId }" />
		<input type="hidden" title="현재POD수" name="nowPodQty" id="nowPodQty" value="${nowPodQty }" />
		<input type="hidden" title="CPU사용률" name="avgCpuUseRt" id="avgCpuUseRt" value="${avgCpuUseRt}" />
		<input type="hidden" title="메모리사용률" name="avgMemUseRt" id="avgMemUseRt" value="${avgMemUseRt}" />
		<input type="hidden" title="사유" name="sclReasn" id="sclReasn"/>
		<input type="hidden" title="최종배포버전" name="lastDistrbVer" id="LastDistrbVer" value="${lastDistrbVer}"/>

		<div class="box">
				<div class="box-body no-padding">

						<table class="table table-hover table-vertical" id="atmsclDistrbStrgTable">
							<caption>자원 확장 테이블</caption>

						<colgroup>
							<col class="col10">
							<col class="col20">
							<col class="col10">
							<col class="col20">
			      		</colgroup>

							<tbody>
								<tr>
									<th>CPU사용량 (%)</th>
									<c:choose>
										<c:when test="${empty avgCpuUseRt}">
											<td class="alignL"><c:out value="0.0"/></td>
										</c:when>
										<c:when test="${'NaN' eq avgCpuUseRt}">
											<td class="alignL"><c:out value="0.0"/></td>
										</c:when>
										<c:otherwise>
											<td class="alignL"><c:out value="${avgCpuUseRt}"/></td>
										</c:otherwise>
									</c:choose>
									<th>메모리 사용량 (%)</th>
									<c:choose>
										<c:when test="${empty avgMemUseRt }">
											<td class="alignL"><c:out value="0.0"/></td>
										</c:when>
										<c:when test="${'NaN' eq avgMemUseRt}">
											<td class="alignL"><c:out value="0.0"/></td>
										</c:when>
										<c:otherwise>
											<td class="alignL"><c:out value="${avgMemUseRt}"/></td>
										</c:otherwise>
									</c:choose>
					            </tr>
					            <tr>
									<th>현재 Pod수</th>
										<c:choose>
											<c:when test="${empty nowPodQty}">
												<td class="alignL"><c:out value="0"/></td>
											</c:when>
											<c:otherwise>
												<td class="alignL"><c:out value="${nowPodQty}"/></td>
											</c:otherwise>
										</c:choose>
									<th><label for="chngPodQty"><span class="text-red">*</span>적용 Pod수</label></th>
									<td>
										<input type="number" name="chngPodQty" id="chngPodQty" class="form-control essential onlyInteger" step="1" min="0" max="99" maxlength="2" oninput="maxLengthCheck(this);" title="적용 Pod수" />
									</td>
					            </tr>
				               	<tr>
									<th><label for="sclReasnRmk">사 유</label></th>
									<td colspan="3">
					             		<textarea id="sclReasnRmk" title="사유" Class="form-control" rows="3" maxlength="1000"></textarea>
									</td>
					            </tr>
							</tbody>
						</table>
				</div>

		</div>
	</form:form>
</div>
<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button type="button" class="btn btn-dark" onclick="replicaAdd();">적용</button>
		</menu:authorize>
		<button type="button" class="btn close-window">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {


	});

    function replicaAdd(){
		var curPod = $("#nowPodQty").val();
		var apPod = $("#chngPodQty").val();
		var avgCpuUseRt = $("#avgCpuUseRt").val();
		var avgMemUseRt = $("#avgMemUseRt").val();
		if(avgCpuUseRt == "" || avgCpuUseRt == "undefined"){
			$("#avgCpuUseRt").val(0.0);
		}
		if(avgMemUseRt == "" || avgMemUseRt == "undefined"){
			$("#avgMemUseRt").val(0.0);
		}
		if(curPod == "" || curPod == "undefined"){
			$("#nowPodQty").val(0);
		}

		$("#sclReasn").val($("#sclReasnRmk").val());
		if(!fn_form_validation("atmsclDistrbVo")){
			return;
		}
		/*
		if(avgCpuUseRt == 0 || avgMemUseRt == 0){
			jAlert('CPU사용량 및  메모리 사용량이 없어 자원확장이 불가능합니다.');
			return;
		}
		*/
		if(curPod == apPod){
			jAlert('현재 Pod수 와 적용Pod수 값이 같습니다.', function() { $("#chngPodQty").focus(); });
			return;
		}
		/*
		else if(curPod == 0){
			jAlert('현재 Pod수가 없어서 자원확장이 불가능합니다.');
			return;
		}
		else if(apPod == 0){
			jAlert('적용 Pod수는 0 으로 설정  불가능합니다.', function() { $("#chngPodQty").focus(); });
			return;
		}*/

		 jConfirm('자원확장 하시겠습니까?', function(){

			var options = {
				type: 'post',
				dataType: 'json',
				success: insertReplicasResultHandler,
				beforeSend: function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();

				},
				error: function(xhr, textStatus, errorThrown){
					jAlert('오류가 발생하였습니다.');
				}
			};

			$('#atmsclDistrbVo').attr('action', '<c:url value="insertReplicasAdd.do"/>');
			$('#atmsclDistrbVo').ajaxSubmit(options);

		});
    }
  //생성 결과 콜백
    function insertReplicasResultHandler(result){

    	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

    	if(result.success){
    		jInfo(result.messageList, function(){
    			window.close();
    		});
    	}
    	else{
    		alert_message(result.messageList)
    	}
    }
    function maxLengthCheck(data){
   		if(data.value.length > data.maxLength){
    		data.value = data.value.slice(0,data.maxLength)
    	}
    }

</script>