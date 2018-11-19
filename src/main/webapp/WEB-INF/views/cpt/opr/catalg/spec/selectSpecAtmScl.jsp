<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 17.
 * @lastmodified 2017. 05. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 03.     송승규         v1.0             최초생성
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

<form:form id="selectSpecAtmScl" commandName="resultVo" action="updateSpec.do">
	<form:hidden path="clCd" title="구분코드"  />
	<form:hidden path="specClCd" title="스펙유형코드"  />
	<form:hidden path="specSeq" title="스펙SEQ" />

	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">기본 정보</h3>
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
							<th><label for="clCdNm"><span class="text-red">*</span>구분</label></th>
							<td>
								<form:input path="clCdNm" type="text" class="form-control essential"  title="구분" disabled="true" />
							</td>
						</tr>
						<tr>
							<th><label for="specClCdNm"><span class="text-red">*</span>분류</label></th>
							<td>
								<form:input path="specClCdNm" type="text" class="form-control essential"  title="분류" disabled="true" />
							</td>
						</tr>
						<tr>
							<th><label for="specNm"><span class="text-red">*</span>스펙명</label></th>
							<td>
								<form:input path="specNm" type="text" class="form-control essential" maxlength="60" title="스펙명"/>
							</td>
						</tr>

						<tr>
							<th><label for="dc"><span class="text-red">*</span>설명</label></th>
							<td>

								<form:textarea path="dc" cssClass="form-control essential" title="설명" rows="3" maxlength="2000" />


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
								<label for="vcoreMinVl"><span class="text-red">*</span>최소 CPU(Core)</label>
							</th>
							<td>
								<form:input path="vcoreMinVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128"  title="최소 CPU(Core)" onblur="fn_checkData();" />
							</td>
					  		<th>
								<label for="vcoreMaxVl"><span class="text-red">*</span>최대 CPU(Core)</label>
							</th>
							<td>
								<form:input path="vcoreMaxVl"  type="number" class="form-control essential onlyInteger" step="1" min="1" max="128"  title="최대 CPU(Core)" onblur="fn_checkData();" />
							</td>
						</tr>
						<tr>
							<th>
								<label for="memMinVl"><span class="text-red">*</span>최소 메모리(GB)</label>
							</th>
							<td>
								<form:input path="memMinVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256"  title="최소 메모리(GB)" onblur="fn_checkData();" />
							</td>
							<th>
								<label for="memMaxVl"><span class="text-red">*</span>최대 메모리(GB)</label>
							</th>
							<td>
								<form:input path="memMaxVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256"  title="최대 메모리(GB)" onblur="fn_checkData();" />
							</td>
						</tr>
						<tr id="maxPodQtyTr">
                            <th><label for="maxPodQty"><span class="text-red">*</span>최대 Pod 수</label></th>
                            <td>
								<form:input path="maxPodQty" type="number" class="form-control onlyInteger" step="1" min="1" max="256"  title="최대 Pod 수" />
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
			<menu:authorize onlyOprAdm="true">
				<div class="pull-right btns">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>
</form:form>
<script type="text/javascript">
	// 스펙분류코드 선택 / 비고내용 표시
	$(document).on('ready', function(){

		if($('#specClCd').val()=='06'){
			$("#maxPodQtyTr").show();
			$("#maxPodQty").addClass("essential");

		}else if($('#specClCd').val()=='07'){
			$("#maxPodQtyTr").hide();
			$("#maxPodQty").removeClass("essential");
		}
	});

	// textarea control
	function fn_dcSet(){
		$('#dc2').val($('#dc').val());
	}

	// 뒤로 이동
	function fn_selectSpecList(){

		location.href = '<c:url value="selectSpecList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'specSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// submit
	function doSubmit(result){

		if(!fn_form_validation("selectSpecAtmScl")){
			return;
		}

		if(!fn_checkData()){
			return;
		}

		jConfirm('스펙을 저장하시겠습니까?', fn_updateSpec);
	}

	// 스펙수정 처리
	function fn_updateSpec(){


		//$('#dc').val($('#dc2').val());
		$('#specClCd').prop('disabled',false);

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
		$('#selectSpecAtmScl').ajaxSubmit(options);
	}

	// 콜백 / 화면이동
	function fn_pageMove(result){

		if(result.success){
			jInfo("저장되었습니다.", function(){
				if(result.procType == "update") {
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