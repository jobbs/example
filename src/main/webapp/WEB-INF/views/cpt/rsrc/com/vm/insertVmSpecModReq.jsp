<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 스펙변경 요청 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<form:form commandName="rsrcReqVo">
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo"/>
	<c:set var="rsrcReqVmVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVmVo"/>
	<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertVmSpecModReqValidation"/>
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">요청정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
  		<table class="table table-horizon">
  			<caption>요청정보</caption>
    		<colgroup>
     			<col class="col20">
     			<col class="col30">
     			<col class="col20">
     			<col class="col30">
     		</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>제목</th>
						<td>
							<form:input path="sbjct" name="sbjct" title="제목" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}"/>
						</td>
						<th><span class="text-red">*</span>테스트여부</th>
						<td>
							<div class="input-group input-group-radio">
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="예" value="Y"/>
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="아니오" value="N"/>
							</div>
						</td>
		            </tr>
		            <tr>
						<th><span class="text-red">*</span>티켓번호</th>
						<td>
							<form:input path="ticktNo" name="ticktNo" title="티켓번호" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}"/>
						</td><td></td><td></td>
          </tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">스펙변경할 가상서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>스펙변경할 가상서버 정보</caption>
		   		<colgroup>
		    			<col class="col20">
		    			<col class="col30">
		    			<col class="col20">
		    			<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>가상서버명</th>
						<td>
							<form:hidden path="regionId" name="regionId" title="센터" value="${vmVo.regionId }"/>
							<form:hidden path="rsrcReqVmVoList[0].vmSeq" name="rsrcReqVmVoList[0].vmSeq" title="가상서버" value="${vmVo.vmSeq }"/>
							<form:hidden path="rsrcReqVmVoList[0].vmCompId" name="rsrcReqVmVoList[0].vmCompId" title="가상서버구성ID" value="${vmVo.vmCompId }"/>
							<c:out value="${vmVo.vmNm }"/>
						</td>
						<th>가상서버ID</th>
						<td>
							<c:out value="${vmVo.vmId }"/>
						</td>
					</tr>
					<tr>
						<th>CPU (vCore)</th>
						<td id="beforeCpuVcoreQty">
							<c:out value="${vmVo.cpuVcoreQty }"/>
						</td>
						<th>메모리 (GB)</th>
						<td id="beforeMemAsgnCapa">
							<c:out value="${vmVo.memAsgnCapa }"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title"><span class="text-red">*</span>스펙 선택</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="specListTable">
				<caption>스펙 선택</caption>
		        <thead>
		        	<tr>
		        		<th><nobr title="선택">선택</nobr></th>
						<th><nobr title="스펙명">스펙명</nobr></th>
						<th><nobr title="CPU (vCore)">CPU (vCore)</nobr><form:hidden path="rsrcReqVmVoList[0].chngReqCpuVcoreQty" name="rsrcReqVmVoList[0].chngReqCpuVcoreQty" title="요청 CPU vCore"/></th>
						<th><nobr title="메모리 (GB)">메모리 (GB)</nobr><form:hidden path="rsrcReqVmVoList[0].chngReqMemAsgnCapa" name="rsrcReqVmVoList[0].chngReqMemAsgnCapa" title="요청 메모리"/></th>
		        	</tr>
		        </thead>
				<tbody>
					<tr class="custom">
						<td>
							<form:radiobutton path="rsrcReqVmVoList[0].chngReqSpecSeq" name="rsrcReqVmVoList[0].chngReqSpecSeq" title="스펙 선택" cssClass="essential" onclick="fn_selectSpec(true);" value=""/>
						</td>
						<td class="alignL"><nobr title="사용자 정의">사용자 정의</nobr></td>
						<td>
							<input id="customCpuVcoreQty" class="form-control onlyInteger min max" title="사용자 정의 CPU (vCore)" value="" disabled="true" type="number" min="1" max="${ivu.getMax(rsrcReqVmVoClass, 'chngReqCpuVcoreQty', groupClass)}" step="1" maxlength="${ivu.getMaxlength(rsrcReqVmVoClass, 'chngReqCpuVcoreQty', groupClass)}" onkeydown="fn_maxlengthCheck(event, this);"/>
						</td>
						<td>
							<input id="customMemAsgnCapa" class="form-control onlyInteger min max" title="사용자 정의 메모리 (GB)" value="" disabled="true" type="number" min="1" max="${ivu.getMax(rsrcReqVmVoClass, 'chngReqMemAsgnCapa', groupClass)}" step="1" maxlength="${ivu.getMaxlength(rsrcReqVmVoClass, 'chngReqMemAsgnCapa', groupClass)}" onkeydown="fn_maxlengthCheck(event, this);"/>
						</td>
					</tr>
					<c:forEach var="specVo" items="${specVoList }" varStatus="i">
						<tr>
							<td>
								<form:radiobutton path="rsrcReqVmVoList[0].chngReqSpecSeq" name="rsrcReqVmVoList[0].chngReqSpecSeq" title="스펙 선택" cssClass="essential" onclick="fn_selectSpec(false);" value="${specVo.specSeq }"/>
							</td>
							<td class="alignL"><nobr title="<c:out value="${specVo.specNm }"/>"><c:out value="${specVo.specNm }"/></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${specVo.cpuVcore }"/>"><c:out value="${specVo.cpuVcore }"/></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${specVo.mem }"/>"><c:out value="${specVo.mem }"/></nobr></td>
						</tr>
					</c:forEach>
                </tbody>
			</table>
		</div>
	</div>
</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertVmSpecModReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

function fn_selectSpec(isCustom){
	if(isCustom){
		$('#customCpuVcoreQty').prop('disabled', false);
		$('#customMemAsgnCapa').prop('disabled', false);
		$('#customCpuVcoreQty').addClass('essential');
		$('#customMemAsgnCapa').addClass('essential');
		if(!$('#customCpuVcoreQty').val()){
			setTimeout(function(){$('#customCpuVcoreQty').focus();},0);
		}
		else if(!$('#customMemAsgnCapa').val()){
			setTimeout(function(){$('#customMemAsgnCapa').focus();},0);
		}
	}
	else{
		$('#customCpuVcoreQty').prop('disabled', true);
		$('#customMemAsgnCapa').prop('disabled', true);
		$('#customCpuVcoreQty').removeClass('essential');
		$('#customMemAsgnCapa').removeClass('essential');
	}
}

//뒤로
function fn_selectVmList(){
	location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_insertVmSpecModReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}

	var beforeCpuVcoreQty = ($('#beforeCpuVcoreQty').html()).trim();
	var beforeMemAsgnCapa = ($('#beforeMemAsgnCapa').html()).trim();

	var reqCpuVcoreQty;
	var reqMemAsgnCapa;
	if($('.custom input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]').is(':checked')){
		reqCpuVcoreQty = ($('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').parents('tr').find('td:eq(2) input').val()).trim();
		reqMemAsgnCapa = ($('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').parents('tr').find('td:eq(3) input').val()).trim();
	}
	else if($('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]').is(':checked')){
		reqCpuVcoreQty = ($('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').parents('tr').find('td:eq(2) nobr').html()).trim();
		reqMemAsgnCapa = ($('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').parents('tr').find('td:eq(3) nobr').html()).trim();
	}

	if(beforeCpuVcoreQty == reqCpuVcoreQty && beforeMemAsgnCapa == reqMemAsgnCapa){
		jAlert("현재 스펙과 변경 요청 스펙이 동일합니다. 다른 스펙 정보로 요청하시기 바랍니다.", function(){
			if($('.custom input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]').is(':checked')){
				setTimeout(function(){$('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').parents('tr').find('td:eq(2) input').focus();},0);
			}
			else{
				setTimeout(function(){$('input[name="rsrcReqVmVoList[0]\\.chngReqSpecSeq"]:checked').focus();},0);
			}
		});
		return;
	}


	jConfirm('가상서버 스펙을 변경 요청하시겠습니까?', function(){

		$('input[name="rsrcReqVmVoList[0]\\.chngReqCpuVcoreQty"]').val(reqCpuVcoreQty);
		$('input[name="rsrcReqVmVoList[0]\\.chngReqMemAsgnCapa"]').val(reqMemAsgnCapa);

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertVmSpecModReqResultHandler,
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

		$('#rsrcReqVo').attr('action', '<c:url value="insertVmSpecModReq.do"/>');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertVmSpecModReqResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmList();
		});
	}
	else{
		jAlert(result.messageList);
	}

}

$('#specListTable').on('click', 'tr', function(e){
	if($.contains(document.querySelector('#specListTable thead'), this)){
		return;
	}
	$(this).find('input[type="radio"]').prop('checked', true);
	fn_selectSpec($(this).hasClass('custom'));
});

$('#specListTable input[type="radio"]').click(function(e) {
	e.stopPropagation();
});

$('#specListTable input[type="number"]').click(function(e) {
	e.stopPropagation();
});

$("#specListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	fnDrawCallback : function(){
		$('#specListTable tr.custom').prependTo($('#specListTable tbody'));
	},
	aoColumns : [
   		{sWidth : "28px" }, //선택
   		{sWidth : "250px" }, //스펙명
   		{sWidth : "100px" }, //CPU vCore
   		{sWidth : "100px" }, //메모리
   	],
});

</script>
