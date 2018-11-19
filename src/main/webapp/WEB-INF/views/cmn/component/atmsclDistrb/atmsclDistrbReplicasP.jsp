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
							<td class="alignL"><c:out value="${avgCpuUseRt}"/></td>
							<th>메모리 사용량 (%)</th>
							<td class="alignL"><c:out value="${avgMemUseRt}"/></td>
			            </tr>
			            <tr>
							<th>현재 Pod수</th>
							<td class="alignL">
								<c:out value="${nowPodQty}"/>
							</td>
							<th><label for="chngPodQty"><span class="text-red">*</span>적용 Pod수</label></th>
							<td>
								<input type="number" name="chngPodQty" id="chngPodQty" class="form-control essential onlyInteger" step="1" min="1" max="256" maxlength="3"  title="적용 Pod수" />
							</td>
			            </tr>
		               	<tr>
							<th><label for="sclReasnRmk">사 유</label></th>
							<td colspan="3">
			             		<textarea id="sclReasnRmk" title="사유" Class="form-control" rows="3" maxlength="1000" ></textarea>
							</td>
			            </tr>
					</tbody>
				</table>
		</div>

</div>
</div>
</form:form>
<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button type="button" class="btn btn-dark" onclick="replicaAdd();">적용</button>
		</menu:authorize>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
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
		$("#sclReasn").val($("#sclReasnRmk").val());
		if(!fn_form_validation("atmsclDistrbVo")){
			return;
		}
		if(avgCpuUseRt == 0 || avgMemUseRt == 0){
			jAlert('CPU사용량 및  메모리 사용량이 없어 자원확장이 불가능합니다.');
			return;
		}
		if(curPod == apPod){
			jAlert('현재 Pod수 와 적용Pod수 값이 같습니다.');
			return;
		}else if(curPod == 0){
			jAlert('현재 Pod수가 없어서 자원확장이 불가능합니다.');
			return;
		}

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

			$('#atmsclDistrbVo').attr('action', contextPath+'/cpt/rsrc/atmscl/atmsclDistrb/insertReplicasAdd.do');
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

</script>