<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 생성 요청 화면</pre>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<form:form commandName="rsrcReqVo">
	<!-- 등록/상세 영역 -->
	<div class="col-box-100 detail-col">
		<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo" />
		<c:set var="rsrcReqVmVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVmVo" />
		<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertVmCreReqValidation" />
		<!-- 수평형 테이블 -->
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">요청정보</h3>
				<div class="box-tools">
					<div class="pull-right"></div>
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
								<form:input path="sbjct"
									title="제목"
									cssClass="form-control essential"
									maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}" />
							</td>
							<th><span class="text-red">*</span>테스트여부</th>
							<td>
								<div class="input-group input-group-radio">
									<form:radiobutton path="testYn" title="테스트여부" cssClass="essential" label="예" value="Y" />
									<form:radiobutton path="testYn" title="테스트여부" cssClass="essential" label="아니오" value="N" />
								</div>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>티켓번호</th>
							<td><form:input path="ticktNo" title="티켓번호"
									cssClass="form-control essential"
									maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}" />
							</td>
							<th>HA여부</th>
							<td>
								<div class="input-group input-group-radio">
									<form:radiobutton path="haCompYn" value="Y" label="예" onclick="fn_haYn();" />
									<form:radiobutton path="haCompYn" value="N" label="아니오" onclick="fn_haYn();"/>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 수평형 테이블 -->
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">생성할 가상서버 정보</h3>
				<div class="box-tools">
					<div class="pull-right"></div>
				</div>
			</div>
			<div class="box-body no-padding">
				<table class="table table-hover table-horizon">
					<caption>생성할 가상서버 정보</caption>
					<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span>센터</th>
							<td>
								<nform:selectRegion
									path="regionId"
									name="regionId"
									id="regionId"
									title="센터"
									cssClass="form-control essential"
									wholeText="센터를 선택해주세요" />
							</td>
							<th><span class="text-red">*</span>망구분</th>
							<td>
								<select name="netClCd" title="망구분" class="form-control">
									<option value=""><c:out value="망을 선택해주세요" /></option>
									<c:forEach var="netClCd" items="${netClCdList }">
										<option value="${netClCd.cd}"><c:out value="${netClCd.cdNm }" /></option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>업무</th>
							<td>
								<div class="input-group">
									<input type="hidden" title="부처" name="useGvDprtId" />
									<input type="hidden" title="업무" name="useJobId" class="essential" />
									<input type="text" name="jobNm" class="form-control" placeholder="업무를 선택해주세요" disabled="disabled" title="업무" />
									<div class="input-group-btn">
										<button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="fn_selectJobListP();">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</td>
							<th><span class="text-red">*</span>용도</th>
							<td><select name="prposClCd" title="용도" class="form-control essential">
									<option value=""><c:out value="용도를 선택해주세요" /></option>
									<c:forEach var="prposClCd" items="${prposClCdList }">
										<option value="${prposClCd.cd}"><c:out value="${prposClCd.cdNm }" /></option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>소프트웨어</th>
							<td>
								<select name="swSeq" title="소프트웨어" class="form-control">
									<option value=""><c:out value="소프트웨어를 선택해주세요" /></option>
									<c:forEach var="tmplatSwVo" items="${tmplatSwVoList }">
										<option value="${tmplatSwVo.swSeq}"><c:out value="${tmplatSwVo.swNm }" /></option>
									</c:forEach>
								</select>
							</td>
							<th><span class="text-red">*</span>OS유형</th>
							<td>
								<%-- <nform:selectCode
									parentCd="120"
									parentGrpCd="021"
									name="osTyCd"
									wholeText="OS유형을 선택해주세요"
									class="form-control essential"
									onchange="fn_selectSpecList();" /> --%>

								<select name="osTyCd" title="OS유형" class="form-control essential" onchange="fn_selectSpecList();">
									<option value=""><c:out value="OS유형을 선택해주세요" /></option>
									<c:forEach var="osTyCd" items="${osTyCdList }">
										<option value="${osTyCd.cd}"><c:out value="${osTyCd.cdNm }" /></option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 수직형 테이블 -->
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">
					<span class="text-red">*</span>스펙 선택
				</h3>
				<div class="box-tools">
					<div class="pull-right"></div>
				</div>
			</div>
			<div class="box-body no-padding detail-list-body">
				<table class="table table-hover table-vertical table-layout-fixed" id="specListTable">
					<caption>스펙 선택</caption>
					<colgroup>
						<col class="col5">
						<col class="colAuto">
						<col class="col15">
						<col class="col15">
						<col class="col15">
					</colgroup>
					<thead>
						<tr>
							<th>선택</th>
							<th>스펙명</th>
							<th>CPU (vCore)</th>
							<th>메모리 (GB)</th>
							<th>스토리지 (GB)</th>
						</tr>
					</thead>
					<tbody>
						<tr class="custom">
							<td>
								<input type="radio" name="reqSpecSeq" title="스펙 선택" class="essential" onclick="fn_selectSpec(true);" value="" />
							</td>
							<td class="alignL">사용자 정의</td>
							<td>
								<input id="customCpuVcoreQty"
									class="form-control onlyInteger min max"
									title="사용자 정의 CPU vCore"
									disabled
									type="number"
									min="1"
									max="${ivu.getMax(rsrcReqVmVoClass, 'reqCpuVcoreQty', groupClass)}"
									step="1"
									maxlength="3" />
							</td>
							<td>
								<input id="customMemAsgnCapa"
									class="form-control onlyInteger min max"
									title="사용자 정의 메모리 (GB)"
									disabled
									type="number"
									min="1"
									max="${ivu.getMax(rsrcReqVmVoClass, 'reqMemAsgnCapa', groupClass)}"
									step="1"
									maxlength="3" />
							</td>
							<td>
								<input id="customStrgAsgnCapa"
									class="form-control onlyInteger min max"
									title="사용자 정의 스토리지 (GB)"
									disabled
									type="number"
									min="1"
									max="${ivu.getMax(rsrcReqVmVoClass, 'strgAsgnCapa', groupClass)}"
									step="1"
									maxlength="3" />
							</td>
						</tr>
						<c:forEach var="specVo" items="${specVoList }" varStatus="i">
						<tr>
							<td>
								<input
									type="radio"
									name="reqSpecSeq"
									title="스펙 선택"
									class="essential"
									onclick="fn_selectSpec(false);"
									value="${specVo.specSeq }" />
							</td>
							<td class="alignL"><c:out value="${specVo.specNm }" /></td>
							<td class="alignR"><c:out value="${specVo.cpuVcore }" /></td>
							<td class="alignR"><c:out value="${specVo.mem }" /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 수직형 테이블 -->
		<div class="box detail-list-box haInfoDiv">
			<div class="box-header">
				<h3 class="box-title">
					HA정보
				</h3>
			</div>
			<div class="box-body no-padding detail-list-body">
				<table class="table table-hover table-horizon">
					<caption>HA 정보</caption>
					<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span>HA 그룹명</th>
							<td colspan="3">
								<input type="text" name="haComp.haGrpNm" id="haGrpNm" class="form-control" title="HA 그룹명" maxlength="30"/>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>HA 그룹코드</th>
							<td>
								<input type="text" name="haComp.haGrpCd" id="haGrpCd" class="form-control" title="HA 그룹코드" maxlength="3"/>
							</td>
							<th><span class="text-red">*</span>HA 스토리지용량</th>
							<td>
								<input type="text" name="haComp.haStrgCapa" id="haStrgCapa" class="form-control onlyInteger" title="HA 스토리지용량" maxlength="4"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 수직형 테이블 -->
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">
					부가정보
				</h3>
				<div class="pull-right vmAddBtn">
					<button type="button" class="btn" onclick="fn_addVm()">추가</button>
				</div>
			</div>
			<div class="box-body no-padding detail-list-body">
				<table class="table table-vertical table-layout-fixed" id="vmTable">
					<caption>부가정보</caption>
					<thead>
					<tr>
						<th width="22%"><span class="text-red">*</span>서비스기간</th>
						<th>가상서버구성ID</th>
						<th width="18%"><span class="text-red">*</span>가상서버명</th>
						<th width="20%"><span class="text-red">*</span>호스트명</th>
						<th width="15%" class="haYnTd"><span class="text-red">*</span>Active/StandBy</th>
						<th width="8%" class="haYnTd"></th>
					</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertVmCreReq();">
					<i class="fa fa-check"></i>
				</button>
			</menu:authorize>
		</div>
	</div>
</div>


<script type="text/javascript">

	$(document).bind('selectJob', setJob);
	//업무선택 호출 (팝업)
	function fn_selectJobListP() {
		var url = contextPath + '/cmn/component/job/selectJobListP.do';
		var params = {"searchType" : "S"};
		var args = {
			key : "업무선택",
			width : 740,
			height : 820
		};
		windowOpen(url, params, args);
	}

	//업무선택 팝업창에서 선택한 정보 설정
	function setJob(evt) {
		var val = evt.datas;
		$('#rsrcReqVo input[name="jobNm"]').val(val.jobNm);
		$('#rsrcReqVo input:hidden[name="useGvDprtId"]').val(val.institutionId);
		$('#rsrcReqVo input:hidden[name="useJobId"]').val(val.jobId);
	}

	function fn_selectSpec(isCustom) {
		if (isCustom) {
			$('#customCpuVcoreQty').prop('disabled', false);
			$('#customMemAsgnCapa').prop('disabled', false);
			$('#customStrgAsgnCapa').prop('disabled', false);
			$('#customCpuVcoreQty').addClass('essential');
			$('#customMemAsgnCapa').addClass('essential');
			$('#customStrgAsgnCapa').addClass('essential');
			if (!$('#customCpuVcoreQty').val()) {
				setTimeout(function(){$('#customCpuVcoreQty').focus();}, 0);
			} else if (!$('#customMemAsgnCapa').val()) {
				setTimeout(function(){$('#customMemAsgnCapa').focus();}, 0);
			} else if (!$('#customStrgAsgnCapa').val()) {
				setTimeout(function(){$('#customStrgAsgnCapa').focus();}, 0);
			}
		} else {
			$('#customCpuVcoreQty').prop('disabled', true);
			$('#customMemAsgnCapa').prop('disabled', true);
			$('#customStrgAsgnCapa').prop('disabled', true);
			$('#customCpuVcoreQty').removeClass('essential');
			$('#customMemAsgnCapa').removeClass('essential');
			$('#customStrgAsgnCapa').removeClass('essential');
		}
	}

	function fn_srvcPreiodToggle(obj) {
		var isChecked = $(obj).prop('checked');

		$(obj).closest('td').find('.datepicker').datepicker('option',
				'disabled', isChecked);
		if (isChecked) {
			$(obj).closest('td').find('.datepicker').removeClass('essential');
		} else {
			$(obj).closest('td').find('.datepicker').addClass('essential');
		}
		$(obj).closest('td').find('.datepicker').val('');
	}

	//뒤로
	function fn_selectVmList() {
		location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
	}

	function fn_insertVmCreReq() {

		if (!fn_form_validation("rsrcReqVo")) {
			return;
		}

		jConfirm('가상서버 생성 요청하시겠습니까?', function() {

			if ($('.custom input[name="reqSpecSeq"]').is(':checked')) {
				$('input[data-name="reqCpuVcoreQty"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(2) input').val());
				$('input[data-name="reqMemAsgnCapa"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(3) input').val());
				$('input[data-name="strgAsgnCapa"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(4) input').val());
			} else if ($('input[name="reqSpecSeq"]').is(':checked')) {
				$('input[data-name="reqCpuVcoreQty"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(2) nobr').html());
				$('input[data-name="reqMemAsgnCapa"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(3) nobr').html());
				$('input[data-name="strgAsgnCapa"]').val($('input[name="reqSpecSeq"]:checked').parents('tr').find('td:eq(4) nobr').html());
			}

			$('input[data-name="netClCd"]').val($('select[name="netClCd"]').val());
			$('input[data-name="useGvDprtId"]').val($('input[name="useGvDprtId"]').val());
			$('input[data-name="useJobId"]').val($('input[name="useJobId"]').val());
			$('input[data-name="prposClCd"]').val($('select[name="prposClCd"]').val());
			$('input[data-name="swSeq"]').val($('select[name="swSeq"]').val());
			$('input[data-name="osTyCd"]').val($('select[name="osTyCd"]').val());
			$('input[data-name="reqSpecSeq"]').val($('input[name="reqSpecSeq"]:checked').val());


			fn_form_rename("rsrcReqVmVoList","servcStrtDt,servcEndDt,netClCd,useGvDprtId,useJobId,prposClCd,swSeq,osTyCd,reqSpecSeq,reqCpuVcoreQty,reqMemAsgnCapa,strgAsgnCapa,vmCompId,vmNm,hstNm,haStatCd")
			var options = {
				type : 'post',
				dataType : 'json',
				success : insertVmCreReqResultHandler,
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('오류가 발생하였습니다.');
				}
			};

			$('#rsrcReqVo').attr('action', '<c:url value="insertVmCreReq.do"/>');
			$('#rsrcReqVo').ajaxSubmit(options);

		});
	}

	function insertVmCreReqResultHandler(result) {

		if (result.success) {
			jInfo(result.messageList, function() {
				fn_selectVmList();
			});
		} else {
			alert_message(result.messageList, function() {
				if (result.data != null) {
					var inputName = getDomName(result.data);
					setTimeout(function(){$(inputName).focus();}, 0);
				}
			});
		}

	}

	function getDomName(obj) {
		return ((obj.child != null) ? ('[name*="' + obj.name + '"]' + getDomName(obj.child))
				: ('[name*="' + obj.name + '"]'));
	}

	function fn_selectSpecList() {
		var url = contextPath + '/cpt/opr/catalg/spec/selectSpecListJson.do';

		var osTyCd = $('select[name="osTyCd"]').val();
		console.log( osTyCd );
		var specClCd;
		if ("" == osTyCd) {
			$("#specListTable > tbody > tr:not(.custom)").remove();
			return;
		} else if ("01" == osTyCd || "04" == osTyCd) {
			specClCd = "05";
		} else {
			specClCd = osTyCd;
		}

		$.ncmsLoding.start('#specListTable');
		$.get(url, {"specClCd" : specClCd}, function(result) {
			if (result.success) {
				var datas = result.data;

				$("#specListTable > tbody > tr:not(.custom)").remove();

				if (datas != null) {
					//create row
					for (var i = 0; i < datas.length; i++) {

						$('#specListTable tbody').append('<tr>'
							+ '<td><input type="radio" name="reqSpecSeq" title="스펙 선택" class="essential" onclick="fn_selectSpec(false);" value="'
							+ datas[i].specSeq
							+ '"/></td>'
							+ '<td class="alignL"><nobr title="'+ datas[i].specNm +'">'
							+ datas[i].specNm
							+ '</nobr></td>'
							+ '<td class="alignR"><nobr title="'+ datas[i].cpuVcore +'">'
							+ datas[i].cpuVcore
							+ '</nobr></td>'
							+ '<td class="alignR"><nobr title="'+ datas[i].mem +'">'
							+ datas[i].mem
							+ '</nobr></td>'
							+ '<td class="alignR"><nobr title="'+ datas[i].strgDfltVl +'">'
							+ datas[i].strgDfltVl
							+ '</nobr></td>'
							+ '</tr>');
					}
				}
			}
		}, "json").always(function() {
			$.ncmsLoding.remove();
		});
	}

	$('#specListTable').on('click', 'tr', function(e) {
		if ($.contains(document.querySelector('#specListTable thead'), this)) {
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

	var haStatCds = [];
	var haStatClass = function(){};
	<c:forEach items="${haStatCdList }" var="haStatCd">
		var haStat = new haStatClass();
		haStat.cd = "<c:out value="${haStatCd.cd }" />";
		haStat.cdNm = "<c:out value="${haStatCd.cdNm }" />";
		haStatCds.push(haStat);
	</c:forEach>

	var vmIndex = 0;
	function fn_haYn() {

		vmIndex = 0;

		$("#vmTable tbody").html("");

		var haYn = $("input:radio[name='haCompYn']:checked").val();
		if( haYn == "Y" ) {

			$(".vmAddBtn").show();
			$(".haYnTd").show();
			$(".haInfoDiv").show();

			//HA 필수 처리
			$("#haVmNm").addClass("essential");
			$("#haStrgCapa").addClass("essential");
			$("#haGrpCd").addClass("essential");
			$("#haGrpNm").addClass("essential");

			fn_addVm();
			fn_addVm();
		} else {
			$(".haYnTd").hide();
			$(".vmAddBtn").hide();
			$(".haInfoDiv").hide();

			//HA 필수 제외
			$("#haVmNm").removeClass("essential");
			$("#haStrgCapa").removeClass("essential");
			$("#haGrpCd").removeClass("essential");
			$("#haGrpNm").removeClass("essential");

			fn_addVm();
		}

	}

	function fn_addVm() {

		var haYn = $("input:radio[name='haCompYn']:checked").val();

		var innerHtml = '<tr>';

		innerHtml += '<td>';
		innerHtml += '	<div class="input-group-box full">';
		innerHtml += '		<div class="input-group-cell pad-right-5 fix-cell">';
		innerHtml += '			<div class="input-group input-group-check">';
		innerHtml += '				<input title="영구여부" id="srvcUnlimit' + vmIndex + '" type="checkbox" onclick="fn_srvcPreiodToggle(this);">';
		innerHtml += '				<label for="srvcUnlimit' + vmIndex + '">영구</label>';
		innerHtml += '			</div>';
		innerHtml += '		</div>';
		innerHtml += '		<div class="input-group period-start">';
		innerHtml += '			<input type="text" name="rsrcReqVmVoList[' + vmIndex +'].servcStrtDt" id="startDate' + vmIndex + '" ';
		innerHtml += '				class="form-control datepicker essential" title="서비스 시작일자" onchange="initDate(this, \'endDate' + vmIndex + '\', \'S\')"/>';
		innerHtml += '		</div>';
		innerHtml += '		<div class="input-group period-end">'
		innerHtml += '			<input type="text" name="rsrcReqVmVoList[' + vmIndex + '].servcEndDt" id="endDate' + vmIndex + '" ';
		innerHtml += '				class="form-control datepicker essential" title="서비스 종료일자" onchange="initDate(this, \'startDate' + vmIndex + '\', \'E\')"/>';
		innerHtml += '		</div>';
		innerHtml += '	</div>';
		innerHtml += '</td>';
		innerHtml += '<td class="alignL">';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].netClCd" data-name="netClCd"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].useGvDprtId" data-name="useGvDprtId"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].useJobId" data-name="useJobId"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].prposClCd" data-name="prposClCd"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].swSeq" data-name="swSeq"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].osTyCd" data-name="osTyCd"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].reqSpecSeq" data-name="reqSpecSeq"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].reqCpuVcoreQty" data-name="reqCpuVcoreQty"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].reqMemAsgnCapa" data-name="reqMemAsgnCapa"/>';
		innerHtml += '	<input type="hidden" name="rsrcReqVmVoList[' + vmIndex + '].strgAsgnCapa" data-name="strgAsgnCapa"/>';
		innerHtml += '	<input type="text" name="rsrcReqVmVoList[' + vmIndex + '].vmCompId" class="form-control" title="가상서버구성ID" value="" maxlength=\'${ivu.getMaxlength(rsrcReqVmVoClass, "vmCompId", groupClass)}\'/>';
		innerHtml += '</td>';
		innerHtml += '<td>';
		innerHtml += '	<input type="text" name="rsrcReqVmVoList[' + vmIndex + '].vmNm" class="form-control essential" title="가상서버명" value="" maxlength=\'${ivu.getMaxlength(rsrcReqVmVoClass, "vmNm", groupClass)}\'/>';
		innerHtml += '</td>';
		innerHtml += '<td>';
		innerHtml += '	<input type="text" name="rsrcReqVmVoList[' + vmIndex + '].hstNm" class="form-control essential" title="호스트명" value="" maxlength=\'${ivu.getMaxlength(rsrcReqVmVoClass, "hstNm", groupClass)}\'/>';
		innerHtml += '</td>';

		if( haYn == "Y" ) {
			innerHtml += '<td>';
			innerHtml += '	<select name="rsrcReqVmVoList[' + vmIndex + '].haStatCd" class="form-control essential" title="HA상태">';
			innerHtml += '		<option value="">HA상태를 선택해 주세요</option>';
			for( var i=0; i < haStatCds.length; i++ ) {
				innerHtml += '		<option value="' + haStatCds[i].cd + '">' + haStatCds[i].cdNm + '</option>';
			}
			innerHtml += '	</select>';
			innerHtml += '</td>';
			innerHtml += '<td>';

			console.log( $('#vmTable tbody tr').size() );

			if( $('#vmTable tbody tr').size() >= 2 ) {
				innerHtml += '	<button type="button" class="btn" onclick="fn_delVm(this)">삭제</button>';
			}

			innerHtml += '</td>';
		}

		innerHtml += '</tr>';

		$('#vmTable tbody').append(innerHtml);
		$('#vmTable tbody tr .datepicker').datepicker();

		vmIndex++;
	}

	function fn_delVm(obj) {
		$(obj).parent().remove();
	}

	$(function() {
		fn_haYn();
	});
</script>
