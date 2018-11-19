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
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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

<c:set var="contains" value="false" /> <!-- 용도가 서비스가 아닐 경우에는 VIP여부 설정 못하도록 함, 01:WEB, 02:WAS, 03:DB -->
<c:forEach var="ipBndPrposVo" items="${ipBndVo.ipBndPrposVoList }">
	<c:if test="${(ipBndPrposVo.prposClCd eq '01') or (ipBndPrposVo.prposClCd eq '02') or (ipBndPrposVo.prposClCd eq '03')}">
		<c:set var="contains" value="true" />
	</c:if>
</c:forEach>

<div class="box detail-list-box">
	<!-- box-header -->
	<div class="box-header">
		<h3 class="box-title">할당<small>
				${ipBndVo.asgnIpQty}
		</small></h3>
		<div class="box-tools">
			<div class="pull-right">
				<button type="button" class="btn btn-sm btn-function" onclick="fn_selectAsgnListXlsDwnl()" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" data-placement="left"><i class="fa fa-download"></i></button>
			</div>
		</div>
	</div>
	<!-- /box-header -->
	<!-- box-body -->
	<form:form id="ipAsgnListFrm" name="ipAsgnListFrm" commandName="ipVo">
	<div class="box-body no-padding detail-list-body">
		<input type="hidden" name="selectBndSeq" value="${ipBndVo.bndSeq }" />
		<table class="table table-vertical table-layout-fixed" id="ipAsgnTable">
		<caption>IP할당목록(가상서버구성ID, IP, IP(NAT), 가상서버명, 호스트명, MAC주소, Hypervisor유형, VIP여부, 할당일자, 비고)</caption>
			<thead>
				<tr>
					<th><input type="checkbox" id="asgnAll" title="전체선택"></th>
					<th>가상서버구성ID</th>
					<th>IP</th>
					<th>IP(NAT)</th>
					<th>가상서버명</th>
					<th>호스트명</th>
					<th>MAC주소</th>
					<th>가상화SW</th>
					<th>VIP여부<input type="checkbox" id="asgnVipAll" title="전체"></th>
					<th>할당일자</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ipVo" items="${assigns }" varStatus="i">
					<tr>
						<td>
							<form:checkbox path="checkIps" value="${ipVo.ipAddr }" title="선택"/>
							<form:hidden path="ipList[${i.index }].bndSeq" value="${ipVo.bndSeq }" />
							<form:hidden path="ipList[${i.index }].ipAddr" value="${ipVo.ipAddr}" />
						</td>
						<td class="alignL"><c:out value="${ipVo.vmCompId}" /></td>
						<td class="alignL">
							<c:out value="${ipVo.ipAddr}" />
						</td>
						<td>
							<c:choose>
								<c:when test="${contains}">
									<form:input path="ipList[${i.index }].natIpAddr" value="${ipVo.natIpAddr}" maxlength="15" cssClass="form-control onlyIp" title="NAT IP주소" disabled="false"/>
								</c:when>
								<c:otherwise>
									<form:input path="ipList[${i.index }].natIpAddr" value="${ipVo.natIpAddr}" maxlength="15" cssClass="form-control onlyIp" title="NAT IP주소" disabled="true"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="alignL"><c:out value="${ipVo.vmNm}" /></td>
						<td class="alignL"><c:out value="${ipVo.hstNm}" /></td>
						<td><c:out value="${ipVo.macAddr}" /></td>
						<td class="alignL"><c:out value="${ipVo.hypervisor}" /></td>
						<td>
							<c:choose>
								<c:when test="${contains}">
									<c:choose>
										<c:when test="${ipVo.vipYn eq 'Y'}">
											<form:checkbox path="ipList[${i.index }].vipYn" value="Y" checked="checked" title="VIP여부" disabled="false"/>
										</c:when>
										<c:otherwise>
											<form:checkbox path="ipList[${i.index }].vipYn" value="Y" title="VIP여부" disabled="false"/>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ipVo.vipYn eq 'Y'}">
											<form:checkbox path="ipList[${i.index }].vipYn" value="Y" checked="checked" title="VIP여부" disabled="true"/>
										</c:when>
										<c:otherwise>
											<form:checkbox path="ipList[${i.index }].vipYn" value="Y" title="VIP여부" disabled="true"/>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

						</td>
						<td><fmt:formatDate value="${ipVo.asgnDt }" pattern="yyyy-MM-dd" /></td>
						<td>
							<form:input path="ipList[${i.index }].rmk" value="${ipVo.rmk}" maxlength="1000" cssClass="form-control" title="비고"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form:form>
	<form:form id="ipAsgnCheckListFrm" commandName="ipVo">
		<input type="hidden" name="checkDataList" id="checkDataList" />
	</form:form>
	<div class="box-footer clearfix">
		<div class="pull-right">
			<menu:authorize>
			<button type="button" class="btn btn-sm btn-function" onclick="fn_updateAsgnToUnasgnIps()" title="할당해제">할당해제</button>
			<button type="button" class="btn btn-sm btn-function" onclick="fn_updateAsgnIpList()" title="정보저장">정보저장</button>
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
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	// vip여부 전체선택하는 항목도 disabled, 1개 이상일때만
	if($("input:checkbox[name='checkIps']").length > 0){
		document.getElementById('asgnVipAll').disabled = $('input[id*=vipYn]')[0].disabled;
	}

	$('#asgnAll').click(function(){
		$("input:checkbox[name='checkIps']").prop('checked', $(this).is(":checked"));
	});

	$("input:checkbox[name='checkIps']").click(function(){
		if($("input:checkbox[name='checkIps']:checked").length == $("input:checkbox[name='checkIps']").length){
			$('#asgnAll').prop('checked', true);
		}
		else {
			$('#asgnAll').prop('checked', false);
		}
	});

	var allCnt = $('input[id*=vipYn]').length;
	var checkCnt = $('input[id*=vipYn]:checked').length

	// 화면이 로딩되었을 때, Vip여부의 항목이 전체선택되어 있다면 헤더부분도 선택되도록 함.
	if(allCnt != 0){
		if(checkCnt == allCnt){
			$('#asgnVipAll').prop('checked', true);
		}
		$('#asgnVipAll').click(function(){
			for( var i=0; i < allCnt; i++ ) {
				$('input[id*=vipYn]').eq(i).prop('checked', $(this).is(":checked"));
			}
		});
	}

	// vip여부가 전체선택되었을 때, 헤더부분도 선택되도록 함.
	for( var i=0; i < allCnt; i++ ) {
		$('input[id*=vipYn]').eq(i).click(function(){
			if($('input[id*=vipYn]:checked').length == allCnt){
	 			$('#asgnVipAll').prop('checked', true);
	 		}
	 		else {
	 			$('#asgnVipAll').prop('checked', false);
	 		}
		});
	}
});

//정보변경여부 확인
function fn_isIpAsgnListChangeCheck(){
	var listSize = ${ipBndVo.asgnIpQty};
	var change = false;
	for(var i=0; i < listSize; i++){
		if($("#ipAsgnListFrm input[name='ipList["+ i +"].natIpAddr']").val() != $("#ipAsgnListFrm input[name='ipList["+ i +"].natIpAddr']")[0].defaultValue){
			change = true;
		}

		if($("#ipAsgnListFrm input:checkbox[name='ipList["+ i +"].vipYn']")[0].checked != $("#ipAsgnListFrm input[name='ipList["+ i +"].vipYn']")[0].defaultChecked){
			change = true;
		}

		if($("#ipAsgnListFrm input[name='ipList["+ i +"].rmk']").val() != $("#ipAsgnListFrm input[name='ipList["+ i +"].rmk']")[0].defaultValue){
			change = true;
		}
	}
	return change;
}

// 엑셀다운로드
function fn_selectAsgnListXlsDwnl(){
	var listSize = ${ipBndVo.asgnIpQty};
	if(listSize == 0){
		jAlert("엑셀 다운로드할 목록이 존재하지 않습니다.");
		return;
	}
	$('#ipAsgnListFrm').attr('action', '<c:url value="selectIpAsgnListXlsDwnl.do"/>');
	$('#ipAsgnListFrm').submit();
}

// 성공메시지 처리
function fn_successHandler(result) {
	if( result.success) {
		jInfo("정상처리되었습니다.", function(){
			goToUrl('${detailUrl}');
		});
	}
	else {
		jAlert(result.messageList);
	}
}

// IP 할당해제
function fn_updateAsgnToUnasgnIps(){
	var checked = 0;
	$("input:checkbox[name='checkIps']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		jAlert("할당해제 할 아이피를 선택하시기 바랍니다.");
		return;
	}

	jConfirm('선택한 IP를 미할당 상태로 변경하시겠습니까?', function() {
		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_successHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('할당해제 중 오류 발생');
			}
		};

		$('#ipAsgnListFrm').attr("action", "updateAsgnToUnasgnIps.do");
		$('#ipAsgnListFrm').ajaxSubmit(options);
	});

}

// IP 목록 수정된 정보 저장
function fn_updateAsgnIpList(){
	var listSize = ${ipBndVo.asgnIpQty};
	if(listSize == 0){
		jAlert("정보저장 하려는 목록이 존재하지 않습니다.");
		return;
	}

	if(!fn_isIpAsgnListChangeCheck()){
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
			data.bndSeq = $("#ipAsgnListFrm input[name='ipList[" + index + "].bndSeq']").val();
			data.ipAddr = $("#ipAsgnListFrm input[name='ipList[" + index + "].ipAddr']").val();
			data.natIpAddr = $("#ipAsgnListFrm input[name='ipList[" + index + "].natIpAddr']").val();
			if($("#ipAsgnListFrm input:checkbox[name='ipList[" + index + "].vipYn']")[0].checked){
				data.vipYn = "Y";
			}
			else {
				data.vipYn = "N";
			}
			data.rmk = $("#ipAsgnListFrm input[name='ipList[" + index + "].rmk']").val();
			datas.push(data);
			checked++;
		}
	});
	document.getElementById('checkDataList').value = JSON.stringify(datas);

	if (checked == 0) {
		jAlert("정보저장 하려는 목록이 선택되지 않았습니다.");
		return;
	}

	if(!nat_ip_validation()){
		return;
	}

	jConfirm('입력한 정보로 정보수정 하시겠습니까?', function() {
		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_successHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('정보저장 중 오류 발생');
			}
		};

		$('#ipAsgnCheckListFrm').attr("action", "updateAsgnIpList.do");
		$('#ipAsgnCheckListFrm').ajaxSubmit(options);
	});
}

$("#ipAsgnTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "35px" },
	               {sWidth : "97px" },
	               {sWidth : "93px" },
	               {sWidth : "93px" },
	               {sWidth : "107px" },
	               {sWidth : "72px" },
	               {sWidth : "118px" },
	               {sWidth : "69px" },
	               {sWidth : "48px" },
	               {sWidth : "80px" },
	               {sWidth : "173px" }
	],
	columnDefs:[{type:'ip-address', targets:[2]}]
} );
</script>