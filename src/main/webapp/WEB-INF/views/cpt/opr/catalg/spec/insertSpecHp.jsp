<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 09. 30.
 * @lastmodified 2016. 09. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 30.     송승규         v1.0             최초생성
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

<form:form id="insertSpecHp" commandName="vo" action="insertSpec.do">
	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">기본 정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-bordered table-horizon">
					<caption>스펙 기본정보</caption>
					<colgroup>
						<col class="col20">
						<col class="col80">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="specClCd"><span class="text-red">*</span>구분</label></th>
							<td>
								<div class="cell-body">
			                		<nform:selectCode
			                            parentCd="151"
			                            parentGrpCd="098"
			                            name="clCd"
			                            id="clCd"
			                            whole="false"
			                            cssClass="form-control input-sm"
			                            value="${vo.clCd}"
			                            onChange="fn_changeClcd();"  />
			            		</div>
							</td>
						</tr>
						<tr>
							<th><label for="specClCd"><span class="text-red">*</span>분류</label></th>
							<td>
								<nform:selectCode parentCd="102" parentGrpCd="003" name="specClCd" id="specClCd" whole="false" extra1="01" cssClass="form-control" onChange="fn_changeCatagory();" title="스펙분류"/>
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
	<div class="col-box-33 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">스펙(HP-UX) - CPU</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(HP-UX) - Entitlement</caption>
					<colgroup>
						<col class="col40">
						<col class="col60">
					</colgroup>
					<tbody>
					  	<tr>
					    	<th colspan="2">Entitlement</th>
					  	</tr>
					  	<tr>
					  		<th>
								<label for="entMaxVl"><span class="text-red">*</span>최대값</label>
							</th>
							<td>
								<form:input id="entMaxVl" path="entMaxVl" type="number" class="form-control essential onlyFloat" step="0.01" min="0.01" max="1.00" value="1.00" title="Entitlement 최대값" onblur="fn_checkData();" maxlength="4" />
							</td>
						</tr>
						<tr>
							<th>
								<label for="entDfltVl"><span class="text-red">*</span>기본값</label>
							</th>
							<td>
								<form:input id="entDfltVl" path="entDfltVl" type="number" class="form-control essential onlyFloat" step="0.01" min="0.01" max="1.00" value="1.00" title="Entitlement 기본값" onblur="fn_checkData();" maxlength="4" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="box">
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(HP-UX) - vCore</caption>
					<colgroup>
						<col class="col40">
						<col class="col60">
					</colgroup>
					<tbody>
					  	<tr>
					    	<th colspan="2">vCore</th>
					  	</tr>
					  	<tr>
					  		<th>
								<label for="vcoreMaxVl"><span class="text-red">*</span>최대값</label>
							</th>
							<td>
								<form:input id="vcoreMaxVl" path="vcoreMaxVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128" value="1" title="vCore 최대값"  onblur="fn_checkData();" maxlength="3" />
							</td>
						</tr>
						<tr>
							<th>
								<label for="vcoreDfltVl"><span class="text-red">*</span>기본값</label>
							</th>
							<td>
								<form:input id="vcoreDfltVl" path="vcoreDfltVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128" value="1" title="vCore 기본값"  onblur="fn_checkData();" maxlength="3" />
							</td>
						</tr>
						<tr>
							<th>
								<label for="vcoreMinVl"><span class="text-red">*</span>최소값</label>
							</th>
							<td>
								<form:input id="vcoreMinVl" path="vcoreMinVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="128" value="1" title="vCore 최소값"  onblur="fn_checkData();" maxlength="3" />
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
				<h3 class="box-title">스펙(HP-UX) - 메모리</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(HP-UX) - 메모리</caption>
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
								<form:input id="memMaxVl" path="memMaxVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" value="1" title="메모리 최대값" onblur="fn_checkData();" maxlength="3" />
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
				<h3 class="box-title">스펙(HP-UX) - 스토리지 (GB)</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>스펙(HP-UX) - 스토리지 (GB)</caption>
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
								<form:input id="strgDfltVl" path="strgDfltVl" type="number" class="form-control essential onlyInteger" step="1" min="1" max="9999999" value="100" title="스토리지 기본값" onblur="fn_checkData();" maxlength="7" />
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
			<menu:authorize>
				<div class="pull-right">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>
</form:form>
<script type="text/javascript">
	// 스펙분류코드 초기값 설정
	$(document).on('ready', function(){
		$('#clCd').val('01');
		$('#specClCd').val('02');
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

		if($('#specClCd').val()=='01'){
			goToUrl('insertSpecLinux.do');
		}
		else if($('#specClCd').val()=='02'){
			goToUrl('insertSpecHp.do');
		}
		else if($('#specClCd').val()=='03'){
			goToUrl('insertSpecAix.do');
		}
		else if($('#specClCd').val()=='04'){
			goToUrl('insertSpecWin.do');
		}
		else if($('#specClCd').val()=='05'){
			goToUrl('insertSpecX86.do');
		}
		else if($('#specClCd').val()=='09'){
			goToUrl('insertSolaris.do');
		}else {
			goToUrl('insertSpecAtmScl.do');
		}
	}

	// 뒤로 이동
	function fn_selectSpecList(){

		location.href = '<c:url value="selectSpecList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'specSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// submit
	function doSubmit(result){

		if(!fn_form_validation("insertSpecHp")){
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
		$('#insertSpecHp').ajaxSubmit(options);
	}

	// 콜백 / 화면이동
	function fn_pageMove(result){

		if(result.success){
			jAlert("저장되었습니다.", function (){
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
				if(parseFloat($('#entMaxVl').val()) < parseFloat($('#entDfltVl').val())){
					jAlert("Entitlement 기본값은 최대값보다 클 수 없습니다.", function(){
						$('#entDfltVl').focus();
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

		return boo;
	}
</script>