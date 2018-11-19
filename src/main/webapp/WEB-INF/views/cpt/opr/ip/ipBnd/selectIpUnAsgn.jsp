<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<c:url var="detailUrl" value="selectIpBnd.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
	<c:param name="ipBndSeq" value="${ipBndVo.bndSeq }" />
</c:url>

<c:set var="contains" value="false" />
<!-- 용도가 서비스가 아닐 경우에는 VIP여부 설정 못하도록 함, 01:WEB, 02:WAS, 03:DB -->
<c:forEach var="ipBndPrposVo" items="${ipBndVo.ipBndPrposVoList }">
	<c:if
		test="${(ipBndPrposVo.prposClCd eq '01') or (ipBndPrposVo.prposClCd eq '02') or (ipBndPrposVo.prposClCd eq '03')}">
		<c:set var="contains" value="true" />
	</c:if>
</c:forEach>

<div class="box detail-list-box">
	<!-- box-header -->
	<div class="box-header">
		<h3 class="box-title">
			미할당<small> ${ipBndVo.unasgnIpQty} </small>
		</h3>
		<div class="box-tools">
			<div class="pull-right">
				<menu:authorize>
					<button type="button" class="btn btn-sm btn-function" onclick="fn_updateUnasgnToAsgnIps()" title="수동할당">수동할당</button>
				</menu:authorize>
				<button type="button" class="btn btn-sm btn-function" onclick="fn_selectIpUnasgnListXlsDwnl()" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" data-placement="left">
					<i class="fa fa-download"></i>
				</button>
			</div>
		</div>
	</div>
	<!-- /box-header -->
	<!-- box-body -->
	<form:form id="ipUnasgnListFrm" commandName="ipVo">
		<div class="box-body no-padding detail-list-body">
			<input type="hidden" name="selectBndSeq" value="${ipBndVo.bndSeq }" />
			<input type="hidden" name="selectVmSeq" id="selectVmSeq" />
			<input type="hidden" name="selectNetwkIntfcSeq" id="selectNetwkIntfcSeq" />
			<input type="hidden" name="selectNetClCd" value="${ipBndVo.netClCd }" />
			<input type="hidden" name="selectRegionId" value="${ipBndVo.regionId }" />
			<table class="table table-vertical table-layout-fixed" id="ipUnasgnTable">
				<caption>IP미할당목록 (IP, IP(NAT), VIP여부, 회수일자, 비고)</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="unasgnAll" title="전체선택"></th>
						<th>IP</th>
						<th>IP(NAT)</th>
						<th>VIP여부<input type="checkbox" id="unasgnVipAll" title="전체선택"></th>
						<th>회수일자</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ipVo" items="${unassigns }" varStatus="i">
						<tr>
							<td>
								<form:checkbox path="checkIps" value="${ipVo.ipAddr }" title="선택" />
								<form:hidden path="ipList[${i.index }].bndSeq" value="${ipVo.bndSeq }" />
								<form:hidden path="ipList[${i.index }].ipAddr" value="${ipVo.ipAddr}" />
							</td>
							<td class="alignL"><c:out value="${ipVo.ipAddr}" /></td>
							<td><c:choose>
									<c:when test="${contains}">
										<form:input path="ipList[${i.index }].natIpAddr" value="${ipVo.natIpAddr}" maxlength="15" cssClass="form-control onlyIp" title="NAT IP주소" disabled="false" />
									</c:when>
									<c:otherwise>
										<form:input path="ipList[${i.index }].natIpAddr" value="${ipVo.natIpAddr}" maxlength="15" cssClass="form-control onlyIp" title="NAT IP주소" disabled="true" />
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${contains}">
										<c:choose>
											<c:when test="${ipVo.vipYn eq 'Y'}">
												<form:checkbox path="ipList[${i.index }].vipYn" value="Y" checked="checked" title="VIP여부" disabled="false" />
											</c:when>
											<c:otherwise>
												<form:checkbox path="ipList[${i.index }].vipYn" value="Y" title="VIP여부" disabled="false" />
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${ipVo.vipYn eq 'Y'}">
												<form:checkbox path="ipList[${i.index }].vipYn" value="Y" checked="checked" title="VIP여부" disabled="true" />
											</c:when>
											<c:otherwise>
												<form:checkbox path="ipList[${i.index }].vipYn" value="Y" title="VIP여부" disabled="true" />
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose></td>
							<td><fmt:formatDate value="${ipVo.withdrawDt }" pattern="yyyy-MM-dd" /></td>
							<td><form:input path="ipList[${i.index }].rmk" value="${ipVo.rmk}" maxlength="1000" cssClass="form-control" title="비고" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
	<form:form id="ipUnasgnCheckListFrm" commandName="ipVo">
		<input type="hidden" name="checkDataList" id="checkDataList" />
	</form:form>
	<div class="box-footer clearfix">
		<div class="pull-right">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-function" onclick="fn_updateUnasgnToAsgnIps()" title="수동할당">수동할당</button>
				<button type="button" class="btn btn-sm btn-function" onclick="fn_updateUnasgnToBlkIps()" title="블락설정">Block설정</button>
				<button type="button" class="btn btn-sm btn-function" onclick="fn_updateUnasgnIpList()" title="정보저장">정보저장</button>
			</menu:authorize>
		</div>
	</div>
	<div class="box-footer edit-btn-group">
		<c:url var="listUrl" value="selectIpBndList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${(curParam.key ne 'bndSeq') and (curParam.key ne 'searchType')}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		// vip여부 전체선택하는 항목도 disabled
		if($("input:checkbox[name='checkIps']").length > 0){
			document.getElementById('unasgnVipAll').disabled = $('input[id*=vipYn]')[0].disabled;
		}

		$('#unasgnAll').click(function() {
			$("input:checkbox[name='checkIps']").prop('checked', $(this).is(":checked"));
		});

		$("input:checkbox[name='checkIps']").click(function() {
			if ($("input:checkbox[name='checkIps']:checked").length == $("input:checkbox[name='checkIps']").length) {
				$('#unasgnAll').prop('checked', true);
			} else {
				$('#unasgnAll').prop('checked', false);
			}
		});

		var allCnt = $('input[id*=vipYn]').length;
		var checkCnt = $('input[id*=vipYn]:checked').length

		// 화면이 로딩되었을 때, Vip여부가 전체선택상태라면 헤더부분도 선택되도록 수정
		if (allCnt != 0) {
			if (checkCnt == allCnt) {
				$('#unasgnVipAll').prop('checked', true);
			}
			$('#unasgnVipAll').click(function() {
				for (var i = 0; i < allCnt; i++) {
					$('input[id*=vipYn]').eq(i).prop('checked', $(this).is(":checked"));
				}
			});
		}

		for (var i = 0; i < allCnt; i++) {
			$('input[id*=vipYn]').eq(i).click(function(){
				if($('input[id*=vipYn]:checked').length == allCnt){
					$('#unasgnVipAll').prop('checked', true);
				} else {
					$('#unasgnVipAll').prop('checked', false);
				}
			});
		}
	});

	// 정보변경여부 확인
	function fn_isIpUnasgnListChangeCheck() {
		var listSize = ${ipBndVo.unasgnIpQty};
		var change = false;
		for (var i = 0; i < listSize; i++) {
			if ($("#ipUnasgnListFrm input[name='ipList[" + i + "].natIpAddr']").val() != $("#ipUnasgnListFrm input[name='ipList[" +i+ "].natIpAddr']")[0].defaultValue) {
				change = true;
			}

			if ($("#ipUnasgnListFrm input:checkbox[name='ipList[" + i + "].vipYn']")[0].checked != $("#ipUnasgnListFrm input[name='ipList[" + i + "].vipYn']")[0].defaultChecked) {
				change = true;
			}

			if ($("#ipUnasgnListFrm input[name='ipList[" + i + "].rmk']").val() != $("#ipUnasgnListFrm input[name='ipList[" + i + "].rmk']")[0].defaultValue) {
				change = true;
			}
		}
		return change;
	}

	//엑셀다운로드
	function fn_selectIpUnasgnListXlsDwnl() {
		var listSize = ${ipBndVo.unasgnIpQty};
		if (listSize == 0) {
			jAlert("엑셀 다운로드할 목록이 존재하지 않습니다.");
			return;
		}

		$('#ipUnasgnListFrm').attr('action','<c:url value="selectIpUnasgnListXlsDwnl.do"/>');
		$('#ipUnasgnListFrm').submit();
	}

	function fn_goToUrl(url) {
		location.href = url;
	}

	function fn_successHandler(result) {
		if (result.success) {
			jInfo("정상처리되었습니다.", function() {
				fn_goToUrl('${detailUrl}');
			});
		} else {
			jAlert(result.messageList);
		}
	}

	function getStatus(width, height) {
		var left = (screen.width - width) / 2;
		var top = (screen.height - height) / 2;
		var params = 'width=' + width + ', height=' + height;
		params += ', top=' + top + ', left=' + left;
		params += ', directories=no';
		params += ', location=no';
		params += ', menubar=no';
		params += ', resizeble=no';
		params += ', scrollbars=no';
		params += ', status=no';
		params += ', toolbar=no';

		return params;
	}

	function fn_updateUnasgnToAsgnIps() {
		var checked = 0;
		var vipYnValue = false;

		$("input:checkbox[name='checkIps']").each(function(index) {
			if ($(this).prop("checked")) {
				vipYnValue = $("#ipUnasgnListFrm input[name='ipList[" + index + "].vipYn']")[0].defaultChecked;
				checked++;
			}
		});

		if (checked == 0) {
			jAlert("수동할당 할 IP를 선택하시기 바랍니다.");
			return;
		}

		if (checked > 1) {
			jAlert("다중으로 수동할당 할 수 없습니다. 하나만 선택하시기 바랍니다.");
			return;
		}

		if (vipYnValue) {
			jAlert("VIP여부가 'Y'인 IP는 수동할당 할 수 없습니다.");
			return;
		}

		var regionId = $("#ipUnasgnListFrm input:hidden[name='selectRegionId']").val();
		var netClCd = $("#ipUnasgnListFrm input:hidden[name='selectNetClCd']").val();
		var url = contextPath + "selectVmListP.do?netClCd=" + netClCd + "&regionId=" + regionId;

		var width = 1280;
		var height = 720;
		var posY = (screen.width - width) / 2;
		var posX = (screen.height - height) / 2;
		var args = {
			width : width,
			height : height,
			posX : posX,
			posY : posY
		};

		windowOpen(url, "selectVmListP", args);
	}

	function getSelected(vmSequence, netwkId) {
		document.getElementById('selectVmSeq').value = vmSequence;
		document.getElementById('selectNetwkIntfcSeq').value = netwkId;

		var options = {
			type : 'post',
			dataType : 'json',
			success : fn_successHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				jAlert('가상서버에 IP 수동할당 중 오류 발생');
			}
		}

		$('#ipUnasgnListFrm').attr("action", "updateUnasgnToAsgnIps.do");
		$('#ipUnasgnListFrm').ajaxSubmit(options);
	}

	function fn_updateUnasgnToBlkIps() {
		var checked = 0;
		$("input:checkbox[name='checkIps']").each(function() {
			if( $(this).prop("checked") ) {
				checked++;
			}
		});

		if (checked == 0) {
			jAlert("블락설정 할 IP를 선택하시기 바랍니다.");
			return;
		}

		jConfirm('선택한 IP를 블락 상태로 변경 하시겠습니까?', function() {
			var options = {
				type : 'post',
				dataType : 'json',
				success : fn_successHandler,
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('블락설정 중 오류 발생');
				}
			};

			$('#ipUnasgnListFrm').attr("action", "updateUnasgnToBlkIps.do");
			$('#ipUnasgnListFrm').ajaxSubmit(options);
		});
	}

	function fn_updateUnasgnIpList() {
		var listSize = ${ipBndVo.unasgnIpQty};
		if (listSize == 0) {
			jAlert("정보저장 하려는 목록이 존재하지 않습니다.");
			return;
		}

		if (!fn_isIpUnasgnListChangeCheck()) {
			jAlert("변경된 정보가 존재하지 않습니다.");
			return;
		}

		var object = new Object();
		var datas = new Array();
		var data = null;
		var checked = 0;
		$("input:checkbox[name='checkIps']").each(function(index) {
			if ($(this).prop("checked")) {
				data = new EntityRnIp();
				data.bndSeq = $("#ipUnasgnListFrm input[name='ipList[" + index + "].bndSeq']").val();
				data.ipAddr = $("#ipUnasgnListFrm input[name='ipList[" + index + "].ipAddr']").val();
				data.natIpAddr = $("#ipUnasgnListFrm input[name='ipList[" + index + "].natIpAddr']").val();
				if($("#ipUnasgnListFrm input:checkbox[name='ipList[" + index + "].vipYn']")[0].checked){
					data.vipYn = "Y";
				}
				else {
					data.vipYn = "N";
				}
				data.rmk = $("#ipUnasgnListFrm input[name='ipList[" + index + "].rmk']").val();
				datas.push(data);
				checked++;
			}
		});
		document.getElementById('checkDataList').value = JSON.stringify(datas);

		if (checked == 0) {
			jAlert("정보저장 하려는 목록이 선택되지 않았습니다.");
			return;
		}

		if (!nat_ip_validation()) {
			return;
		}

		jConfirm('입력한 정보로 정보수정 하시겠습니까?', function() {
			var options = {
				type : 'post',
				dataType : 'json',
				success : fn_successHandler,
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('미할당IP 정보수정 중 오류 발생');
				}
			};
			$('#ipUnasgnCheckListFrm').attr("action", "updateUnasgnIpList.do");
			$('#ipUnasgnCheckListFrm').ajaxSubmit(options);
		});
	}

	$("#ipUnasgnTable").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
		              {	sWidth : "35px"	},
		              {	sWidth : "200px"},
		              {	sWidth : "200px"},
		              {	sWidth : "120px"},
		              {	sWidth : "100px"},
		              { sWidth : "250px"} ],
		columnDefs : [ {
			type : 'ip-address',
			targets : [ 1 ]
		} ]
	});
</script>