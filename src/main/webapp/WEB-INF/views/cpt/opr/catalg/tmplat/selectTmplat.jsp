<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     송승규         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<form:form id="tmplatVo" commandName="vo" action="updateTmplat.do" enctype="multipart/form-data">
	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">기본정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon" id="tmplatBaseData">
					<caption>템플릿 기본정보 테이블</caption>
					<colgroup>
						<col class="col11">
						<col class="col22">
						<col class="col11">
						<col class="col22">
						<col class="col11">
						<col class="col22">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="regionId">센터</label></th>
							<td>
								<input id="regionId" type="text" class="form-control" value="${vo.regionNm }" title="센터" readonly />
							</td>
							<th><label for="zoneId">존</label></th>
							<td>
								<input id="zoneId" type="text" class="form-control" value="${vo.zoneNm }" title="존" readonly />
							</td>
							<th><label for="netClNm">망구분(망)</label></th>
							<td>
								<input id="netClNm" type="text" class="form-control" value="${vo.netClNm }(${vo.netNm })" title="망구분(망)" readonly />
								<input id="netId" type="hidden" class="form-control" value="${vo.netNm }" title="망" />
							</td>
						</tr>
						<tr>
							<th><label for="rsrcPoolNm">자원풀</label></th>
							<td>
								<input id="rsrcPoolNm" type="text" class="form-control" value="${vo.rsrcPoolNm }" title="자원풀" readonly />
							</td>
							<th><label for="tmplatId"><span class="text-red">*</span>템플릿ID</label></th>
							<td>
								<form:input id="tmplatId" path="tmplatId" class="form-control" value="${vo.tmplatId }" title="템플릿ID" maxlength="30" readonly="true" />
							</td>
							<th><label for="tmplatNm"><span class="text-red">*</span>템플릿명</label></th>
							<td>
								<form:input id="tmplatNm" path="tmplatNm" class="form-control essential" value="${vo.tmplatNm }" title="템플릿명" maxlength="30" />
							</td>
						</tr>
						<tr>
							<th><label for="useYn"><span class="text-red">*</span>사용여부</label></th>
							<td>
								<input id="useYn2" type="hidden" value="${vo.useYn }" class="form-control"/>
								<form:select id="useYn" path="useYn" cssClass="form-control essential" title="사용여부">
					              	<form:option value="Y">사용</form:option>
					              	<form:option value="N">미사용</form:option>
								</form:select>
							</td>
							<th><label for="tmplatClCd"><span class="text-red">*</span>템플릿구분</label></th>
							<td>
								<input id="tmplatClCd2" type="hidden" value="${vo.tmplatClCd }" class="form-control"/>
								<form:select id="tmplatClCd" path="tmplatClCd" cssClass="form-control essential" title="템플릿구분" >
									<c:forEach var="tmplatClCdCode" items="${tmplatClCdCode}" varStatus="i">
										<form:option value="${tmplatClCdCode.cd}">${tmplatClCdCode.cdNm}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<th><label for="tmplatVer"><span class="text-red">*</span>템플릿버전</label></th>
							<td>
								<form:input id="tmplatVer" path="tmplatVer" type="text" class="form-control" value="${vo.tmplatVer }" title="템플릿버전" maxlength="30" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon" id="tmplatDetailData">
					<caption>템플릿 상세정보 테이블</caption>
					<colgroup>
						<col class="col11">
						<col class="col22">
						<col class="col11">
						<col class="col22">
						<col class="col11">
						<col class="col22">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="vrlzSwTyCd">가상화SW</label></th>
							<td>
								<input id="vrlzSwTyCd2" type="hidden" value="${vo.vrlzSwTyCd }" class="form-control"/>
								<form:select id="vrlzSwTyCd" path="vrlzSwTyCd" cssClass="form-control" title="가상화SW" disabled="true">
									<c:forEach var="vrlzSwTyCdCode" items="${vrlzSwTyCdCode}" varStatus="i">
										<form:option value="${vrlzSwTyCdCode.cd}">${vrlzSwTyCdCode.cdNm}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<th><label for="osTyCd"><span class="text-red">*</span>OS타입</label></th>
							<td>
								<input id="osTyCd2" type="hidden" value="${vo.osTyCd }" class="form-control"/>
								<form:select id="osTyCd" path="osTyCd" cssClass="form-control essential" title="OS타입">
									<c:forEach var="osTyCdCode" items="${osTyCdCode}" varStatus="i">
										<form:option value="${osTyCdCode.cd}">${osTyCdCode.cdNm}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<th><label for="osVer"><span class="text-red">*</span>OS버전</label></th>
							<td>
								<form:input id="osVer" path="osVer" type="text" class="form-control essential" value="${vo.osVer }" title="OS버전" maxlength="16" />
							</td>
						</tr>
						<tr>
							<th><label for="osBit"><span class="text-red">*</span>OS Bit</label></th>
							<td>
								<input id="osBit2" type="hidden" value="${vo.osBit }" class="form-control"/>
								<form:select id="osBit" path="osBit" cssClass="form-control essential" title="OSbit" >
									<c:forEach var="osBitCode" items="${osBitCode}" varStatus="i">
										<form:option value="${osBitCode.cd}">${osBitCode.cdNm}</form:option>
									</c:forEach>
								</form:select>
							</td>
							<th><label for="osNm"><span class="text-red">*</span>운영체제</label></th>
							<td>
								<form:input id="osNm" path="osNm" type="text" class="form-control essential" value="${vo.osNm }" title="운영체제" maxlength="30" />
							</td>
							<th><label for="lang"><span class="text-red">*</span>언어</label></th>
							<td>
								<input id="lang2" type="hidden" value="${vo.lang }" class="form-control"/>
								<form:select id="lang" path="lang" cssClass="form-control essential" title="언어" >
									<c:forEach var="langCode" items="${langCode}" varStatus="i">
										<form:option value="${langCode.cd}">${langCode.cdNm}</form:option>
									</c:forEach>
								</form:select>
							</td>
						</tr>
						<tr>
							<th><label for="strgAsgnCapa">스토리지</label></th>
							<td>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<form:input id="strgAsgnCapa" path="strgAsgnCapa" type="text" class="form-control essential onlyInteger" value="${vo.strgAsgnCapa }" title="스토리지" maxlength="7" readonly="true"/>
									</div>
									<div class="input-group-cell">
										<label for="strgAsgnCapa">GB</label>
									</div>
								</div>
							</td>
							<th><label for="regUserNm">생성자</label></th>
							<td>
								<input id="regUserNm" type="text" class="form-control" value="${vo.regUserNm }" title="생성자" readonly />
							</td>
							<th><label for="regDttm">생성일자</label></th>
							<td class="alignL">
								<input id="regDttm" type="text" class="form-control" value='<fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd" />' title="생성일자" readonly />
							</td>
						</tr>
						<tr>
							<th><label for="pltfrm">Platform</label></th>
							<td class="alignL">
								<form:input id="pltfrm" path="pltfrm" type="text" class="form-control" value="${vo.pltfrm }" title="플랫폼" maxlength="300" />
							</td>
							<th><label for="updtUserNm">최종수정자</label></th>
							<td>
								<input id="updtUserNm" type="text" class="form-control" value="${vo.updtUserNm }" title="최종수정자" readonly />
							</td>
							<th><label for="updtDttm">최종수정일자</label></th>
							<td class="alignL" title="최종수정일자">
								<input id="updtDttm" type="text" class="form-control" value='<fmt:formatDate value="${vo.updtDttm }" pattern="yyyy-MM-dd" />' title="최종수정일자" readonly />
							</td>
						<tr>
							<th><label for="krnlVer">Kernel</label></th>
							<td>
								<form:input id="krnlVer" path="krnlVer" type="text" class="form-control" value="${vo.krnlVer }" title="커널버전" maxlength="30" />
							</td>
							<th><label for="krnlVer">가상화진행여부</label></th>
							<td>
								<input id="vmCrePrcssYn2" type="hidden" value="${vo.vmCrePrcssYn }" class="form-control"/>
								<form:select id="vmCrePrcssYn" path="vmCrePrcssYn" cssClass="form-control" title="가상화진행여부">
									<form:option value="">선택하세요</form:option>
					              	<form:option value="N">N</form:option>
					              	<form:option value="Y">Y</form:option>
								</form:select>
							</td>
							<th><label for="checkPrpos"><span class="text-red">*</span>용도</label></th>
							<td class="alignL">
								<c:forEach var="prposCode" items="${prposCode }">
									<c:set var="contains" value="false"/>
									<c:forEach var="tmplatPrposVo" items="${vo.prposList }">
										<c:if test="${tmplatPrposVo.prposCd eq prposCode.cd}">
											<c:set var="contains" value="true"/>
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${contains}">
											<input type="checkbox" name="checkPrpos" id="prpos${prposCode.cd}" value="${prposCode.cd}" title="용도 ${prposCode.cdNm}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="checkPrpos" id="prpos${prposCode.cd}" value="${prposCode.cd}" title="용도 ${prposCode.cdNm}" />
										</c:otherwise>
									</c:choose>
									<label for="prpos${prposCode.cd}"><c:out value="${prposCode.cdNm}"/></label>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th><label for="rmk">비고</label></th>
							<td colspan="5">
								<textarea id="rmk" class="form-control" rows="3" title="비고" maxlength="1000">${vo.rmk }</textarea>
								<form:hidden id="rmk2" path="rmk" value="${vo.rmk }" />
								<form:hidden id="tmplatSeq" path="tmplatSeq" />
								<form:hidden id="prposInsert" path="prposInsert" />
								<form:hidden id="swInsert" path="swInsert" />
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span><label for="rmk">스태틱라우팅설정</label></th>
							<td colspan="5">
								<div class="input-group">
									<form:hidden path="sRoutingScriptSeq" />
									<form:input path="sRoutingScript" disabled="true" class="form-control"  />
									<menu:authorize onlyOprAdm="true">
										<div class="input-group-btn"><button type="button" class="btn btn-function" onclick="doSearchScript()">선택</button></div>
									</menu:authorize>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">소프트웨어 정보 (<input id="swCnt" type="button" style="background-color:white;border-width:0px;padding:0px;margin-top:-2px;font-weight:bold;" value="${vo.tmplatSwList.size() }" disabled="disabled" />)</h3>
				<menu:authorize onlyOprAdm="true">
				<div class="box-tools">
					<div class="pull-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_openSwPopup();" title="소프트웨어 선택 팝업">소프트웨어 선택</button>
					</div>
				</div>
				</menu:authorize>
			</div>
			<div class="box-body no-padding detail-list-body">
				<table class="table table-hover table-vertical" id="swTable">
					<caption>소프트웨어 목록 테이블</caption>
					<thead>
						<tr>
							<th><nobr>소프트웨어명</nobr></th>
							<th><nobr>소프트웨어 버전</nobr></th>
							<th><nobr>소프트웨어 제조사</nobr></th>
							<th><nobr>비고</nobr></th>
							<menu:authorize onlyOprAdm="true">
							<th><nobr>삭제</nobr></th>
							</menu:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tmplatSwVo" items="${vo.tmplatSwList }">
							<c:choose>
								<c:when test="${tmplatSwVo.swNm eq NULL or tmplatSwVo.swNm eq '' }">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td class='alignL'>삭제된 소프트웨어 입니다.</td>
									<menu:authorize onlyOprAdm="true">
									<td>
										<button type="button" class="btn btn-red" onclick="fn_deleteSw(this);" title="소프트웨어 삭제">삭제</button>
										<input type="hidden" id="sw${tmplatSwVo.swSeq }" value="${tmplatSwVo.swSeq }" />
									</td>
									</menu:authorize>
								</tr>
								</c:when>
								<c:otherwise>
								<tr>
									<td class='alignL'><nobr><c:out value="${tmplatSwVo.swNm }"/></nobr></td>
									<td><nobr><c:out value="${tmplatSwVo.swVer }"/></nobr></td>
									<td class='alignL'><nobr><c:out value="${tmplatSwVo.swMnfctCo }"/></nobr></td>
									<td class='alignL'><c:out value="${tmplatSwVo.rmk }"/></td>
									<menu:authorize onlyOprAdm="true">
									<td>
										<button type="button" class="btn btn-red" onclick="fn_deleteSw(this);" title="소프트웨어 삭제">삭제</button>
										<input type="hidden" id="sw${tmplatSwVo.swSeq }" value="${tmplatSwVo.swSeq }" />
									</td>
									</menu:authorize>
								</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-box-100">
		<div class="edit-btn-group">
			<div class="pull-left btns">
				<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectTmplatList();"><i class="fa fa-arrow-left"></i></button>
			</div>
			<menu:authorize onlyOprAdm="true">
				<div class="pull-right">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>
</form:form>
<script type="text/javascript">
	$(document).ready(function() {
		$('#swTable > tbody').find(':hidden').each(function(){
			swInfo.push(this.value); // 소프트웨어ID 배열
		});
		// 2017-02-24 HP의 경우, 용량정보 수정가능토록 변경.
		if ($('#vrlzSwTyCd2').val() == '03') {
			$('#strgAsgnCapa').attr('readonly', false);
		}
	});

	var swInfo = [];
	var swAdd = [];
	var checkPrpos = [];

	function fn_selectTmplatList(){

		location.href = '<c:url value="selectTmplatList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'tmplatSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// 소프트웨어 선택팝업 호출
	function fn_openSwPopup() {

		var url = '<c:url value="selectSwListP.do"/>';
		var args = {key:"SelectSw", width:740,height:820};
		windowOpen(url, "", args);
	}

	// SW 팝업에서 swTable에 데이터셋
	$(document).bind('swTable',setSw);
	function setSw(evt) {

		var $swTable = $('#swTable').DataTable().destroy();
		if($('#swTable tr.dataTables_empty').length == 1){
			$('#swTable tr.dataTables_empty').remove();
		}

		$.each(evt.datas, function(index) {

			$('#swTable').append(
				"<tr>"
					+"<td class='alignL'>"+this.swNm+"</td>"
					+"<td>"+this.swVer+"</td>"
					+"<td class='alignL'>"+this.swMnfctCo+"</td>"
					+"<td class='alignL'>"+this.rmk+"</td>"
					+"<td>"
						+"<button type='button' class='btn btn-red' onclick='fn_deleteSw(this);'>삭제</button>"
						+"<input type='hidden' id="+this.swSeq+" value="+this.swSeq+" />"
					+"</td>"
				+"</tr>"
			);

			$('#swCnt').val(parseInt($('#swCnt').val())+1);
		});

	}

	// SW 삭제
	function fn_deleteSw(obj){

		var $swTable = $("#swTable").DataTable();
		$swTable.row($(obj).closest('tr')).remove();
		$swTable.draw();
	/*	var rowCnt = obj.parentNode.parentNode.rowIndex;
		swTable.deleteRow(rowCnt);*/
		$('#swCnt').val(parseInt($('#swCnt').val())-1);
	}

	// 저장
	function doSubmit(){

		if(!fn_form_validation("tmplatVo")){
			return;
		}

		var checked = 0;
		// 용도코드 초기화
		checkPrpos = [];
		$(":checkbox").each(function() {
			if ($(this).prop("checked")) {
				checked++;
				checkPrpos.push(this.value); // 용도코드 배열
			}
		});

		if (checked == 0) {
			jAlert("용도 : 필수 항목입니다");
			return;
		}

		/* if($('#strgAsgnCapa').val() == 0){
			jAlert("스토리지값은 1GB이상 이어야합니다.");
			$('#strgAsgnCapa').val(1);
			return;
		}
 		*/
		var bool = false;

		if($('#tmplatId').val() != document.querySelector(('#tmplatId')).defaultValue){
			bool = true;
		}
		if($('#tmplatNm').val() != document.querySelector(('#tmplatNm')).defaultValue){
			bool = true;
		}
		if($('#useYn').val() != document.querySelector(('#useYn2')).defaultValue){
			bool = true;
		}
		if($('#tmplatClCd').val() != document.querySelector(('#tmplatClCd2')).defaultValue){
			bool = true;
		}
		if($('#tmplatVer').val() != document.querySelector(('#tmplatVer')).defaultValue){
			bool = true;
		}
		if($('#osTyCd').val() != document.querySelector(('#osTyCd2')).defaultValue){
			bool = true;
		}
		if($('#osNm').val() != document.querySelector(('#osNm')).defaultValue){
			bool = true;
		}
		if($('#lang').val() != document.querySelector(('#lang2')).defaultValue){
			bool = true;
		}
		if($('#osVer').val() != document.querySelector(('#osVer')).defaultValue){
			bool = true;
		}
		if($('#osBit').val() != document.querySelector(('#osBit2')).defaultValue){
			bool = true;
		}
		if($('#strgAsgnCapa').val() != document.querySelector(('#strgAsgnCapa')).defaultValue){
			bool = true;
		}
		if($('#krnlVer').val() != document.querySelector(('#krnlVer')).defaultValue){
			bool = true;
		}
		if($('#pltfrm').val() != document.querySelector(('#pltfrm')).defaultValue){
			bool = true;
		}
		if($('#vmCrePrcssYn').val() != document.querySelector(('#vmCrePrcssYn2')).defaultValue){
			bool = true;
		}

		if($('#sRoutingScriptSeq').val() != "${vo.sRoutingScriptSeq }"){
			bool = true;
		}

		// 용도 변경 확인
		var length = $("#tmplatVo input[name='checkPrpos']").length;

		for(var i=0; i<length; i++){
			if($("#tmplatVo input[name='checkPrpos']")[i].checked != $("#tmplatVo input[name='checkPrpos']")[i].defaultChecked){
				bool = true;
			}
		}

		if($('#rmk').val() != document.querySelector(('#rmk2')).defaultValue){
			bool = true;
		}


		// 소프트웨어 변경여부 확인
		swAdd = [];

		$('#swTable > tbody').find(':hidden').each(function(){
			swAdd.push(this.value); // 소프트웨어ID 배열
		});

		if(swInfo.length != swAdd.length){
			bool = true;
		}else{
			$.each(swInfo, function(i){
				var str1 = this;
				var cnt1 = 0;
				$.each(swAdd, function(j){
					if(str1.toString() == this){
						cnt1++;
					}
				});
				if(cnt1 == 0){
					bool = true;
				}
			});
		}

		if(bool){
			jConfirm('템플릿을 저장하시겠습니까?', fn_updateTmplat);
		}else{
			jConfirm('수정된 항목이 없습니다.<br/>템플릿 목록조회 화면으로 이동하시겠습니까?', fn_selectTmplatList);
		}
	}

	// 템플릿 수정
	function fn_updateTmplat(){

		var bool = true;

		//소프트웨어ID 배열 중복체크
		$.each(swAdd, function(i){
			var str = this;
			$.each(swAdd, function(j){
				//jInfo("i="+i+", value="+str+" : j="+j+", value="+this);
				if(str.toString() == this){
					if(i!=j){
						jAlert("중복된 소프트웨어가 있습니다.");
						swAdd = [];
						checkPrpos = [];
						bool = false;
						return false;
					}
				}
			});
		});

		if(bool){

			//jAlert("템플릿 시퀀스 : <"+${vo.tmplatSeq}+">의 저장 프로세스 시작!");
			$('#rmk2').val($('#rmk').val());
			$('#vrlzSwTyCd').removeAttr('disabled');
			$('#swInsert').val(swAdd);
			$('#prposInsert').val(checkPrpos);

			// 용도와 소프트웨어 항목 기존데이터를 모두 지우고 다시 저장한다
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
			$('#tmplatVo').ajaxSubmit(options);
		}
	}

	// 콜백 / 화면이동
	function fn_pageMove(result){

		if(result.success){
			jInfo("저장되었습니다.", function(){
				if(result.procType == "update") {
					location.reload();
					//location.href = '<c:url value="selectTmplatList.do"/>';
				}
			});
		}else{
			swAdd = [];
			checkPrpos = [];
			jAlert(result.messageList);
		}

	}

	// 스태틱라우팅 스크립트
	function doSearchScript() {
		var url = "selectScriptListP.do";
		var params = {"searchOSType" : $("#osTyCd").val(), "searchOSVer" : $("#osVer").val() };
		var args = {key:"SelectRoutingScript", width:1000,height:610};
		windowOpen(url, params, args);
	}

	$(document).bind('selectRoutingScript', setRoutingScript);
	function setRoutingScript(evt) {
		var data = evt.datas;
		$("#sRoutingScriptSeq").val(data.sRoutingScriptSeq);
		$("#sRoutingScript").val( data.script );
	}

	$("#swTable").DataTable({
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "180px" }
					,{sWidth : "90px" }
					,{sWidth : "180px" }
					,{sWidth : "300px" }
					<menu:authorize onlyOprAdm="true">
					,{sWidth : "40px" }
					</menu:authorize>
					],
		order : [ [ 0, "asc" ] ]
	});
</script>