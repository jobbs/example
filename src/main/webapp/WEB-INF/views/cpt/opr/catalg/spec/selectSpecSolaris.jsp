<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 03.
 * @lastmodified 2016. 10. 03.
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

<form:form id="selectSpecSolaris" commandName="resultVo" action="updateSpec.do">
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
								<form:input path="specNm" type="text" value="${resultVo.specNm }" class="form-control essential" maxlength="60" title="이름"/>
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
	<div class="col-box-33 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">스펙(Solaris) - CPU</h3>
			</div>
		</div>
		<div class="box">
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(Solaris) - vCore</caption>
					<colgroup>
						<col class="col40">
						<col class="col60">
					</colgroup>
					<tbody>
						<tr>
					  		<th>
								<label for="vcoreMaxVl"><span class="text-red">*</span>최대값</label>
							</th>
							<td>
								<form:input path="vcoreMaxVl" type="number" class="form-control essential onlyInteger" value="${resultVo.vcoreMaxVl }" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="vCore 최대값"/>
							</td>
						</tr>
						<tr>
							<th>
								<label for="vcoreDfltVl"><span class="text-red">*</span>기본값</label>
							</th>
							<td>
								<form:input path="vcoreDfltVl" type="number" class="form-control essential onlyInteger" value="${resultVo.vcoreDfltVl }" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="vCore 기본값"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-box-33 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">스펙(Solaris) - 메모리</h3>
			</div>
		</div>
		<div class="box">
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(Solaris) - 메모리</caption>
					<colgroup>
						<col class="col40">
						<col class="col47">
						<col class="col13">
					</colgroup>
					<tbody>
						<tr>
					  		<th>
								<label for="memMaxVl"><span class="text-red">*</span>최대값</label>
							</th>
							<td>
								<form:input path="memMaxVl" type="number" class="form-control essential onlyInteger" value="${resultVo.memMaxVl }" step="1" min="1" max="256" onblur="fn_checkData();" maxlength="3" title="메모리 최대값"/>
							</td>
							<td>GB</td>
						</tr>
						<tr>
					  		<th>
								<label for="memDfltVl"><span class="text-red">*</span>기본값</label>
							</th>
							<td>
								<form:input path="memDfltVl" type="number" class="form-control essential onlyInteger" value="${resultVo.memDfltVl }" step="1" min="1" max="256" onblur="fn_checkData();" maxlength="3" title="메모리 기본값"/>
							</td>
							<td>GB</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-box-33 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">스펙(Solaris) - 스토리지 (GB)</h3>
			</div>
		</div>
		<div class="box">
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(Solaris) - 스토리지 (GB)</caption>
					<colgroup>
						<col class="col40">
						<col class="col47">
						<col class="col13">
					</colgroup>
					<tbody>
						<tr>
							<th>
								<label for="strgDfltVl"><span class="text-red">*</span>기본값</label>
							</th>
							<td>
								<form:input name="strgDfltVl" path="strgDfltVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="9999999" value="100" title="스토리지 기본값" onblur="fn_checkData();" maxlength="7" />
							</td>
							<td>GB</td>
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
	// 스펙분류코드 선택 / 비고내용 표시 / Uncapped Weight 값이 존재할때 체크박스 체크
	$(document).on('ready', function(){
		$('#specClCd').val('09');
	});

	// Uncapped Weight 체크에 따른 텍스트박스 활성/비활성
	function fn_changeUncappWeight(){
		if($('#uncappWeightCheck').prop("checked")==true){
			$('#uncappWeight').prop("disabled",false);
		}else{
			$('#uncappWeight').val("");
			$('#uncappWeight').prop("disabled",true);
		}
	}

	// textarea control
	function fn_dcSet(){
		//$('#dc2').val($('#dc').val());
	}

	// 뒤로 이동
	function fn_selectSpecList(){

		location.href = '<c:url value="selectSpecList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'specSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// submit
	function doSubmit(result){

		if(!fn_form_validation("selectSpecSolaris")){
			return;
		}

		if(!fn_checkData()){
			return;
		}

		var bool = false;

		if($('#specNm').val() != document.querySelector(('#specNm')).defaultValue){
			bool = true;
		}
		if($('#dc').val() != document.querySelector(('#dc')).defaultValue){
			bool = true;
		}
		if($('#vcoreMaxVl').val() != document.querySelector(('#vcoreMaxVl')).defaultValue){
			bool = true;
		}
		if($('#vcoreDfltVl').val() != document.querySelector(('#vcoreDfltVl')).defaultValue){
			bool = true;
		}
		if($('#memMaxVl').val() != document.querySelector(('#memMaxVl')).defaultValue){
			bool = true;
		}
		if($('#memDfltVl').val() != document.querySelector(('#memDfltVl')).defaultValue){
			bool = true;
		}
		if($('#strgDfltVl').val() != document.querySelector(('#strgDfltVl')).defaultValue){
			bool = true;
		}

		if(bool){
			jConfirm('스펙을 저장하시겠습니까?', fn_updateSpec);
		}else{
			jConfirm('수정된 항목이 없습니다.<br/>스펙목록조회 화면으로 이동하시겠습니까?', fn_selectSpecList);
		}
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
		$('#selectSpecSolaris').ajaxSubmit(options);
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

		var boo = false;

		if(parseFloat($('#entMaxVl').val()) > 1.00 || parseFloat($('#entMaxVl').val()) <= 0){
			jAlert("Entitlement 최대값은 0.01 ~ 1.00 사이의 값으로 설정해주세요.", function(){
				$('#entMaxVl').val(1.00);
				$('#entMaxVl').focus();
			});
		}else{
			if(parseFloat($('#entDfltVl').val()) > 1.00 || parseFloat($('#entDfltVl').val()) <= 0){
				jAlert("Entitlement 기본값은 0.01 ~ 1.00 사이의 값으로 설정해주세요.", function(){
					$('#entDfltVl').val(1.00);
					$('#entDfltVl').focus();
				});
			}else{
				if(parseFloat($('#entMinVl').val()) > 1.00 || parseFloat($('#entMinVl').val()) <= 0){
					jAlert("Entitlement 최소값은 0.01 ~ 1.00 사이의 값으로 설정해주세요.", function(){
						$('#entMinVl').val(1.00);
						$('#entMinVl').focus();
					});
				}else{
					if(parseFloat($('#entMaxVl').val()) < parseFloat($('#entDfltVl').val())){
						jAlert("Entitlement 기본값은 최대값보다 클 수 없습니다.", function(){
							$('#entDfltVl').focus();
						});
					}else{
						if(parseFloat($('#entMaxVl').val()) < parseFloat($('#entMinVl').val()) || parseFloat($('#entDfltVl').val()) < parseFloat($('#entMinVl').val())){
							jAlert("Entitlement 최소값은 최대값이나 기본값보다 클 수 없습니다.", function(){
								$('#entMinVl').focus();
							});
						}else{
							if(parseInt($('#vcoreMaxVl').val()) > 128 || parseInt($('#vcoreMaxVl').val()) <= 0){
								jAlert("vCore 최대값은 1 ~ 128 사이의 값으로 설정해주세요.", function(){
									$('#vcoreMaxVl').val(1);
									$('#vcoreMaxVl').focus();
								});
							}else{
								if(parseInt($('#vcoreDfltVl').val()) > 128 || parseInt($('#vcoreDfltVl').val()) <= 0){
									jAlert("vCore 기본값은 1 ~ 128 사이의 값으로 설정해주세요.", function(){
										$('#vcoreDfltVl').val(1);
										$('#vcoreDfltVl').focus();
									});
								}else{
									if(parseInt($('#vcoreMinVl').val()) > 128 || parseInt($('#vcoreMinVl').val()) <= 0){
										jAlert("vCore 최소값은 1 ~ 128 사이의 값으로 설정해주세요.", function(){
											$('#vcoreMinVl').val(1);
											$('#vcoreMinVl').focus();
										});
									}else{
										if(parseInt($('#vcoreMaxVl').val()) < parseInt($('#vcoreDfltVl').val())){
											jAlert("vCore 기본값은 최대값보다 클 수 없습니다.", function(){
												$('#vcoreDfltVl').focus();
											});
										}else{
											if(parseInt($('#vcoreMaxVl').val()) < parseInt($('#vcoreMinVl').val()) || parseInt($('#vcoreDfltVl').val()) < parseInt($('#vcoreMinVl').val())){
												jAlert("vCore 최소값은 최대값이나 기본값보다 클 수 없습니다.", function(){
													$('#vcoreMinVl').focus();
												});
											}else{
												if(parseFloat($('#uncappWeight').val()) > 128.00 || parseFloat($('#uncappWeight').val()) <= 0){
													jAlert("Uncapped Weight 값은 0.01 ~ 128.00 사이의 값으로 설정해주세요.", function(){
														//uncappWeight.value = 128.0;
														$('#uncappWeight').focus();
													});
												}else{
													if(parseInt($('#memMaxVl').val()) > 256 || parseInt($('#memMaxVl').val()) <= 0){
														jAlert("메모리 최대값은 1 ~ 256 사이의 값으로 설정해주세요.", function(){
															$('#memMaxVl').val(1);
															$('#memMaxVl').focus();
														});
													}else{
														if(parseInt($('#memDfltVl').val()) > 256 || parseInt($('#memDfltVl').val()) <= 0){
															jAlert("메모리 기본값은 1 ~ 256 사이의 값으로 설정해주세요.", function(){
																$('#memDfltVl').val(1);
																$('#memDfltVl').focus();
															});
														}else{
															if(parseInt($('#memMinVl').val()) > 256 || parseInt($('#memMinVl').val()) <= 0){
																jAlert("메모리 최소값은 1 ~ 256 사이의 값으로 설정해주세요.", function(){
																	$('#memMinVl').val(1);
																	$('#memMinVl').focus();
																});
															}else{
																if(parseInt($('#memMaxVl').val()) < parseInt($('#memDfltVl').val())){
																	jAlert("메모리 기본값은 최대값보다 클 수 없습니다.", function(){
																		$('#memDfltVl').focus();
																	});
																}else{
																	if(parseInt($('#memMaxVl').val()) < parseInt($('#memMinVl').val()) || parseInt($('#memDfltVl').val()) < parseInt($('#memMinVl').val())){
																		jAlert("메모리 최소값은 최대값이나 기본값보다 클 수 없습니다.", function(){
																			$('#memMinVl').focus();
																		});
																	}else{
																		if(parseInt($('#strgDfltVl').val()) > 9999999 || parseInt($('#strgDfltVl').val()) <= 0){
																			jAlert("스토리지 값은 1 ~ 9999999 사이의 값으로 설정해주세요.", function(){
																				$('#strgDfltVl').val(100);
																				$('#strgDfltVl').focus();
																			});
																		}else{
																			boo = true;
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return boo;
	}
</script>