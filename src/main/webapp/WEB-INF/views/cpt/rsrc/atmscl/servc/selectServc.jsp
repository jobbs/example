<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>서비스 수정 화면</pre>
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
 * 2016. 10. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>


<div class="col-box-100">
	<div class="col-info server
		<c:choose>
			<c:when test='${"01" eq servcVo.statCd}'><c:out value="server-inprogress"/></c:when>
			<c:when test='${"02" eq servcVo.statCd}'><c:out value="server-up"/></c:when>
			<c:when test='${"03" eq servcVo.statCd}'><c:out value="server-exception"/></c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<c:if test='${null ne servcVo.statCd and "" ne servcVo.statCd}'>
					<span class="label"></span>
				</c:if><h4 class="stat"><c:out value="${servcVo.statCdNm}"/></h4>

				<menu:authorize authType="act">
					<button type="button" class="btn btn-sm btn-refresh vm-sync" title="새로고침" onclick="fn_executeServcSync();">새로고침</button>
				</menu:authorize>
			</div>

			<div class="col-info-box alignR">
                <div class="col-info-btn">
	                <c:if test='${"Y" eq servcVo.ctlTrgtYn }'>
		                <c:if test='${"01" eq servcVo.servcTyCd}'>
		                	<menu:authorize authType="act">
			                    <button type="button" class="btn vm-stop" title="빌드" onclick="javascript:fn_build();"><i class="fa fa-cog"></i><span>빌드</span></button>
			                    <button type="button" class="btn vm-stop" title="배포" onclick="javascript:fn_deploy();"><i class="fa fa-sign-in"></i><span>배포</span></button>
			                    <button type="button" class="btn vm-shutdown" title="라우트생성" onclick="javascript:fn_openServcRoute();"><i class="fa fa-plus-square-o"></i><span>라우트생성</span></button>
		                	</menu:authorize>
		                </c:if>
	                </c:if>
                </div>
            </div>
		</div>
	</div>
</div>


<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU Core 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:choose>
					<c:when test='${"DJ_03_A_ATS_OCP_3.4_001" eq servcVo.rsrcPoolId}'>
						<h4 class="num" id="sumCpuCorQty"><fmt:formatNumber value="${servcVo.sumCpuCorQty }" pattern="0"/></h4>
					</c:when>
					<c:when test='${"01" eq servcVo.servcTyCd}'>
						<h4 class="num" id="sumCpuCorQty"><fmt:formatNumber value="${servcVo.sumCpuCorQty }" pattern="0"/></h4>
					</c:when>
					<c:otherwise>
						<c:if test='${"01" ne servcVo.servcTyCd}'>-</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:choose>
					<c:when test='${"DJ_03_A_ATS_OCP_3.4_001" eq servcVo.rsrcPoolId}'>
						<h4 class="num" id="avgCpuUseRt"><c:out value="${servcVo.avgCpuUseRt }" /><small>%</small></h4>
					</c:when>
					<c:when test='${"01" eq servcVo.servcTyCd}'>
						<h4 class="num" id="avgCpuUseRt"><c:out value="${servcVo.avgCpuUseRt }" /><small>%</small></h4>
					</c:when>
					<c:otherwise>
						<c:if test='${"01" ne servcVo.servcTyCd}'>-</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 할당량</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:choose>
					<c:when test='${"DJ_03_A_ATS_OCP_3.4_001" eq servcVo.rsrcPoolId}'>
						<h4 class="num" id="sumMemAsgnCapa"><c:out value="${servcVo.sumMemAsgnCapa }" /><small>GB</small></h4>
					</c:when>
					<c:when test='${"01" eq servcVo.servcTyCd}'>
						<h4 class="num" id="sumMemAsgnCapa"><c:out value="${servcVo.sumMemAsgnCapa }" /><small>GB</small></h4>
					</c:when>
					<c:otherwise>
						<c:if test='${"01" ne servcVo.servcTyCd}'>-</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:choose>
					<c:when test='${"DJ_03_A_ATS_OCP_3.4_001" eq servcVo.rsrcPoolId}'>
						<h4 class="num" id="avgMemUseRt"><c:out value="${servcVo.avgMemUseRt }" /><small>%</small></h4>
					</c:when>
					<c:when test='${"01" eq servcVo.servcTyCd}'>
						<h4 class="num" id="avgMemUseRt"><c:out value="${servcVo.avgMemUseRt }" /><small>%</small></h4>
					</c:when>
					<c:otherwise>
						<c:if test='${"01" ne servcVo.servcTyCd}'>-</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkIn"><fmt:formatNumber value="${servcVo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkOut"><fmt:formatNumber value="${servcVo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">Pod 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="podQty"><fmt:formatNumber value="${servcVo.podQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<form:form id="servcVo" commandName="servcVo" action="updateServc.do">
<form:hidden path="servcSeq" title="서비스SEQ"  />
<form:hidden path="servcAreaId" title="서비스영역ID"  />
<form:hidden path="bldId" title="빌드ID"  />
<form:hidden path="servcId" title="서비스ID"  />
<form:hidden path="regionId" title="센터"  />
<form:hidden path="zoneId" title="존"  />
<form:hidden path="netClCd" title="망"  />
<form:hidden path="rsrcPoolId" title="자원풀ID"  />
<form:hidden path="creImgId" title="생성이미지ID"  />
<form:hidden path="statCd" title="상태코드"  />
<form:hidden path="lastBldVer" title="최종빌드버전"  />
<form:hidden path="lastDistrbVer" title="최종배포버전"  />
<form:hidden path="distrbConfId" title="배포설정ID"  />

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="servcNm"><span class="text-red">*</span>서비스명</label></th>
					    <td colspan="5">
					        <form:input path="servcNm" title="서비스명" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					    <th>서비스ID</th>
					    <td>
					        <c:out value="${servcVo.servcId }"/>
					    </td>
					</tr>
					<tr>
					    <th>서비스영역명</th>
					    <td>
					        <c:out value="${servcVo.servcAreaNm }"/>
					    </td>
						<th><span class="text-red"></span>부처</th>
	                    <td><c:out value="${servcVo.institutionNm }"/></td>
	                    <th><span class="text-red"></span>업무</th>
	                    <td colspan="3"><c:out value="${servcVo.jobNm }"/></td>
					</tr>
					<tr>
						<th>센터</th>
						<td><c:out value="${servcVo.regionNm }"/></td>
						<th>존</th>
						<td><c:out value="${servcVo.zoneNm }"/></td>
						<th>망구분</th>
						<td><c:out value="${servcVo.netNm }"/></td>
						<th>자원풀</th>
						<td><c:out value="${servcVo.rsrcPoolNm }"/></td>
					</tr>
					<tr>
						<th>비고</th>
						<td colspan="7">
					    	<form:textarea path="rmk" cssClass="form-control" title="비고" rows="3" maxlength="1000" />
						</td>
					</tr>
					<tr>
						<th>생성자</th>
						<td><c:out value="${servcVo.creUserNm }"/></td>
						<th>생성일시</th>
						<td><c:out value="${servcVo.creDttm }"/></td>
						<th>수정자</th>
						<td><c:out value="${servcVo.updtUserNm }"/></td>
						<th>수정일시</th>
						<td><c:out value="${servcVo.updtDttm }"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<div class="col-box-100 search-col">
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tapPod" data-toggle="tab">Pod정보</a></li>
			<li><a href="#tapRoute" data-toggle="tab">라우트정보</a></li>
			<li><a href="#tapAtmScl" data-toggle="tab">오토스케일정보</a></li>
			<li><a href="#tapLimit" data-toggle="tab">자원제한설정정보</a></li>
			<li><a href="#tapBld" data-toggle="tab">빌드정보</a></li>
			<li><a href="#tapDistrb" data-toggle="tab">배포정보</a></li>
			<li><a href="#tapImg" data-toggle="tab">이미지정보</a></li>
		</ul><!-- /nav-tabs -->

		<div class="tab-content">
			<div class="tab-pane active" id="tapPod">Pod정보</div>
			<div class="tab-pane" id="tapRoute">라우트정보</div>
			<div class="tab-pane" id="tapAtmScl">오토스케일정보 </div>
			<div class="tab-pane" id="tapLimit">자원제한설정정보</div>
			<div class="tab-pane" id="tapBld">자원제한설정정보</div>
			<div class="tab-pane" id="tapDistrb">자원제한설정정보</div>
			<div class="tab-pane" id="tapImg">자원제한설정정보</div>
		</div>
	</div>
</div>

<input type="hidden" title="삭제여부" name="delYn" id="delYn" />

</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectServcList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<c:if test='${"Y" eq servcVo.ctlTrgtYn }'>
				<c:if test='${"01" eq servcVo.servcTyCd}'>
				<menu:authorize authType="act">
					<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateServc();"><i class="fa fa-check"></i></button>
		    		<button id = "deleteServcAreaBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteServc()"><i class="fa fa-minus"></i></button>
				</menu:authorize>
				</c:if>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로 이동
function fn_selectServcList(){
	location.href = '<c:url value="selectServcList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'servcSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
}


$(function(){
	var servcStatCd = "<c:out value="${servcVo.statCd }" />";
	fn_getTabInfo();

	//서비스 상태가 완료, 오류가 아닐 경우만 화면 리로딩 호출
	//if(servcStatCd != '02') {
		fn_checkStat(servcStatCd);
		setInterval(fn_checkStat, 30*1000);  // 30초마다 상태동기화
	//}

});


//새로고침 버튼 클릭 시
function fn_executeServcSync() {
	fn_reloadPage();
}


//서비스 수정
function fn_updateServc() {

	if(!fn_form_validation("servcVo")){
		return;
	}


	jConfirm('저장 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateServc.do', $('#servcVo').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					location.href = '<c:url value="selectServcList.do"/>';
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}



//서비스 삭제
function fn_deleteServc() {
	jConfirm('삭제 하시겠습니까?', function(){

		$('#delYn').val('Y');
		$.ncmsLoding.startFullScreen();
		$.post('deleteServc.do', $('#servcVo').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					location.href = '<c:url value="selectServcList.do"/>';
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});

}


//빌드실행
function fn_build() {

	jConfirm('빌드를 실행 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: execResultHandler,
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

		$('#servcVo').attr('action', '<c:url value="insertBldHstry.do"/>');
		$('#servcVo').ajaxSubmit(options);

	});
}


//배포실행
function fn_deploy() {

	jConfirm('배포를 실행 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: execResultHandler,
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

		$('#servcVo').attr('action', '<c:url value="updateDeploymentConfig.do"/>');
		$('#servcVo').ajaxSubmit(options);

	});
}


//라우트 생성 팝업화면 호출
function fn_openServcRoute() {

	var servcSeq = $('#servcSeq').val();
	var servcId = $('#servcId').val();
	var servcNm = $('#servcNm').val();
	var rsrcPoolId = $('#rsrcPoolId').val();
	var servcAreaId = $('#servcAreaId').val();
	var regionId = $('#regionId').val();
	var zoneId = $('#zoneId').val();
	var netClCd = $('#netClCd').val();
	var rsrcPoolId = $('#rsrcPoolId').val();

	var params = {"servcNm" : servcNm,
			      "servcId" : servcId,
			      "servcAreaId" : servcAreaId,
			      "servcSeq" : servcSeq,
			      "regionId" : regionId,
			      "zoneId" : zoneId,
			      "netClCd" : netClCd,
			      "rsrcPoolId" : rsrcPoolId};

	var url = 'insertServcRouteP.do';
	var width = 1000;
	var height = 400;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);

}



//저장 결과 콜백
function execResultHandler(result){
	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}

}

//화면 리로딩
function fn_reloadPage(){
	location.reload();
}


//Tab 정보를 조회한다.
function fn_getTabInfo() {

	$("#tapPod").load("<c:url value="selectPodListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapRoute").load("<c:url value="selectRouteListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapAtmScl").load("<c:url value="selectAtmSclListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapLimit").load("<c:url value="selectLimitListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapBld").load("<c:url value="selectBldListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapDistrb").load("<c:url value="selectDistrbListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
	$("#tapImg").load("<c:url value="selectImgListT.do" />?servcSeq=<c:out value="${servcVo.servcSeq }" />");
}


//상태정보를 확인 후 업데이트 한다.
function fn_checkStat(statCd){

	var delYn = $('#delYn').val(); //삭제버튼 클릭 여부

	if(delYn != 'Y') {  //삭제버튼 클릭시에는 상태정보 조회를 하지 않도록 한다.
		var options = {
				type: 'post',
				dataType: 'json',
				success: fn_successHandler,
				beforeSend: function() {
				},
				error: function(xhr, textStatus, errorThrown){
					jAlert('상태 조회 실패');
				}
			}

			$('#servcVo').attr("action", "<c:url value='selectServcStat.do'/>");
			$('#servcVo').ajaxSubmit(options);
	}
}


/**
* 응답 성공시 조회
*/
function fn_successHandler(result) {

	if(result.success) {
		var servcStatCd = result.messageList;

		if(servcStatCd != '') {

			var $container = $('div.server');

			//$container.find('.col-info-box.alignL .label').remove();
			switch(servcStatCd){
			case '02' : // 완료
				$container.removeClass('server-inprogress').removeClass('server-exception').addClass('server-up');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '03' : // 오류
				$container.removeClass('server-up').removeClass('server-inprogress').addClass('server-exception');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			default : // 그외
				break;
			}

			$container.find('.stat').html(result.data.statCdNm);
		}
	}
}

//텝 클릭 시
$('a[data-toggle="tab"]').on('shown.bs.tab',function(e){
	$($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});

</script>
