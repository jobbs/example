<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2016. 09. 30.
 * @lastmodified 2016. 09. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 17.     x         v1.0             최초생성
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

<form:form id="insertSpecAtmScl" commandName="vo" action="insertSpec.do">
	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">기본정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙 기본정보</caption>
					<colgroup>
						<col class="col20">
						<col class="col80">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="clCd"><span class="text-red">*</span>구분</label></th>
							<td>
								<div class="cell-body">
			                		<nform:selectCode
			                            parentCd="151"
			                            parentGrpCd="098"
			                            name="clCd"
			                            id="clCd"
			                            cssClass="form-control input-sm"
			                            value="${vo.clCd}"
			                            whole="false"
			                            onChange="fn_changeClcd();"  />
			            		</div>
							</td>
						</tr>
						<tr>
							<th><label for="specClCd"><span class="text-red">*</span>분류</label></th>
							<td>
								<nform:selectCode parentCd="102" parentGrpCd="003" name="specClCd" id="specClCd" whole="false" extra1="02" cssClass="form-control" onChange="fn_changeCatagory();" title="스펙분류"/>
							</td>
						</tr>
						<tr>
							<th><label for="specNm"><span class="text-red">*</span>스펙명</label></th>
							<td>
								<form:input path="specNm" type="text" class="form-control essential" title="스펙명" maxlength="60"/>
							</td>
						</tr>
						<tr>
							<th><label for="dc"><span class="text-red">*</span>설명</label></th>
							<td>
								<form:textarea path="dc" class="form-control essential" rows="3" title="설명" maxlength="4000"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">스펙정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙 기본정보</caption>
					<colgroup>
						<col class="col10">
						<col class="col20">
                        <col class="col10">
						<col class="col20">
					</colgroup>
					<tbody>
						<tr>
							<th>
								<label for="vcoreMinVl"><span class="text-red">*</span>요청 CPU(Core)</label>
							</th>
							<td>
								<form:input path="vcoreMinVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128" title="최소 CPU(Core)" onblur="fn_checkData();" />
							</td>
					  		<th>
								<label for="vcoreMaxVl"><span class="text-red">*</span>제한 CPU(Core)</label>
							</th>
							<td>
								<form:input path="vcoreMaxVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128" title="최대 CPU(Core)" onblur="fn_checkData();" />
							</td>
						</tr>
						<tr>
							<th>
								<label for="memMinVl"><span class="text-red">*</span>요청 메모리(GB)</label>
							</th>
							<td>
								<form:input path="memMinVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최소 메모리(GB)" onblur="fn_checkData();" />
							</td>
							<th>
								<label for="memMaxVl"><span class="text-red">*</span>제한 메모리(GB)</label>
							</th>
							<td>
								<form:input path="memMaxVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 메모리(GB)" onblur="fn_checkData();" />
							</td>
						</tr>
						<tr id="maxPodQtyTr">
                            <th><label for="maxPodQty"><span class="text-red">*</span>최대 Pod 수</label></th>
                            <td>
								<form:input path="maxPodQty" type="number" class="form-control onlyInteger" step="1" min="1" max="256" title="최대 Pod 수" />
							</td>
							<td colspan="2"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="col-box-100">
		<div class="edit-btn-group">
			<div class="pull-left btns">
				<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectSpecList();"><i class="fa fa-arrow-left"></i></button>
			</div>
			<menu:authorize>
				<div class="pull-right btns">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>
</form:form>
<script type="text/javascript">
	//스펙분류코드 초기값 설정
	$(document).on('ready', function(){
		$('#clCd').val('02');
		$('#specClCd').val('06');

		fn_changeCatagory();
	});

	// 구분변경
	function fn_changeClcd(){
		if($('#clCd').val()=='01'){
			goToUrl('insertSpecAix.do');
		}else if($('#clCd').val()=='02'){
			goToUrl('insertSpecAtmScl.do');
		}
	}

	// 스펙분류코드별 입력양식변경
	function fn_changeCatagory(){

		if($('#specClCd').val()=='06'){
			$("#maxPodQtyTr").show();
			$("#maxPodQty").addClass("essential");

		}else if($('#specClCd').val()=='07'){
			$("#maxPodQtyTr").hide();
			$("#maxPodQty").removeClass("essential");
		}
	}

	// Uncapped Weight 체크에 따른 텍스트박스 활성/비활성
	function fn_changeUncappWeight(){
		if($('#uncappWeightCheck').prop("checked")==true){
			$('#uncappWeight').val("128.00");
			$('#uncappWeight').prop("disabled",false);
		}else{
			$('#uncappWeight').val("");
			$('#uncappWeight').prop("disabled",true);
		}
	}

	// 뒤로 이동
	function fn_selectSpecList(){

		location.href = '<c:url value="selectSpecList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'specSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// submit
	function doSubmit(result){

		if(!fn_form_validation("insertSpecAtmScl")){
			return;
		}

		if(!fn_checkData()){
			return;
		}

		jConfirm('스펙을 저장하시겠습니까?', fn_insertSpec);

	}

	// 스펙생성 처리
	function fn_insertSpec(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_pageMove,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				alert('오류 발생');
			}
		};
		$('#insertSpecAtmScl').ajaxSubmit(options);
	}

	// 콜백 / 화면이동
	function fn_pageMove(result){

		if(result.success){
			jInfo("저장되었습니다.", function (){
				if(result.procType == "insert") {
					location.href = '<c:url value="selectSpecList.do"/>';
				}
			});
		}else{
			jAlert(result.messageList);
		}
	}

	// 데이터 체크
	function fn_checkData(){

		var rtfFlag = true;

		if(parseInt($('#vcoreMaxVl').val()) > 128 || parseInt($('#vcoreMaxVl').val()) <= 0 ||
		   parseInt($('#vcoreMinVl').val()) > 128 || parseInt($('#vcoreMinVl').val()) <= 0){
			jAlert("CPU 값은 1 ~ 128 사이의 값으로 설정해주세요.");
			rtfFlag = false;
		}

		if(parseInt($('#vcoreMaxVl').val()) < parseInt($('#vcoreMinVl').val())){
			jAlert("최소 CPU 값은 최대 CPU 값 보다 클 수 없습니다.");
			rtfFlag = false;
		}

		if(parseInt($('#memMaxVl').val()) > 256 || parseInt($('#memMaxVl').val()) <= 0 ||
		   parseInt($('#memMinVl').val()) > 256 || parseInt($('#memMinVl').val()) <= 0){
			jAlert("메모리값은 1 ~ 256 사이의 값으로 설정해주세요.");
			rtfFlag = false;
		}

		if(parseInt($('#memMaxVl').val()) < parseInt($('#memMinVl').val())){
			jAlert("최소 메모리 값은 최대 메모리 값 보다 클 수 없습니다.");
			rtfFlag = false;
		}

		return rtfFlag;
	}
</script>