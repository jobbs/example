<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>IP 주소 선택(팝업)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     김봉민    v1.0        최초생성
 * 2017. 06. 26.     gnsl      v1.0        IP 소팅 버그로, default order 주석처리
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

 <!-- Popup box -->

<form:form commandName="searchVo" id="frm" name="frm" method="get">
	<form:hidden path="searchBndSeq" />
	<form:hidden path="bndSeq" />
	<form:hidden path="ipAddr" />
	<form:hidden path="prposClCd" />
	<form:hidden path="nicPrposCd" />
	<form:hidden path="zoneId" />
	<form:hidden path="netClCd" />
	<form:hidden path="institutionId" />
	<form:hidden path="idIndex" />
	<form:hidden path="natYn" />
	<form:hidden path="searchRegion" />


	<!-- 검색 영역  -->
	<div class="col-box-100">
		<div class="box-search">
			<!-- box-body -->
		    		<div class="box-body">
						<div class="form-group">
							<div class="form-cell form-cell-50 col-lay-25">
								<div class="cell-title"><label>센터</label></div>
								<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value="${regionVo.regionNm }"/>"  title="센터" readonly="readonly"></div>
							</div>
		    		      	<!-- 망 -->
							<div class="form-cell form-cell-50 col-lay-25">
								<div class="cell-title"><label>망구분</label></div>
								<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${netCodeVo.cdNm}'/>"  title="망" readonly="readonly"></div>
							</div>
							<!-- /망 -->

							<div class="form-cell form-cell-50 col-lay-25">
								<div class="cell-title"><label>부처</label></div>
								<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${insttVo.institutionNm}'/>" title="부처" readonly="readonly"></div>
							</div>
							<div class="form-cell form-cell-50 col-lay-25">
								<div class="cell-title"><label>용도</label></div>
								<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${prposCodeVo.cdNm}'/>" title="용도" readonly="readonly"></div>
							</div>
						</div>
		    		</div><!-- /box-body -->
				</div>
 	   		</div><!-- /검색 영역  -->

 	<!-- content  -->
	<div class="col-box-100">
		<div class="box">
			<div class="box-body no-padding"  style="height:110px; overflow-x: auto; overflow-y: auto;">
				<table class="table table-vertical table-hover table-layout-fixed" id="tblIpBnd">
					<caption>템플릿목록</caption>
					<thead>
						<tr><th>선택</th>
							<th>용도</th>
							<th>IP 대역명</th>
							<th>서브넷마스크</th>
							<th>게이트웨이</th>
							<th>시작 IP</th>
							<th>종료 IP</th>
							<th>VLAN</th></tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${ipBndList}" varStatus="i">
							<tr><td><c:choose>
										<c:when test="${vo.bndSeq eq searchVo.searchBndSeq}">
											<form:radiobutton path="bndSeq"  id="bndSeq" value="${vo.bndSeq}" checked="checked"  title="${vo.bndSeq}_선택"/>
									 	</c:when>
										<c:otherwise>
											<form:radiobutton path="bndSeq" id="bndSeq" value="${vo.bndSeq}" title="${vo.bndSeq}_선택"/>
										</c:otherwise>
									</c:choose></td>
								<td title="${vo.prposClNm }"><c:out value='${vo.prposClNm}'/></td> <!-- 용도 -->
								<td class="alignL" title="${vo.ipBndNm }"><c:out value='${vo.ipBndNm}'/></td> <!-- ip대역명 -->
								<td class="alignL" title="${vo.subnetMask }"><c:out value='${vo.subnetMask}'/></td> <!-- 서브넷마스크 -->
								<td class="alignL" title="${vo.gtwyIpAddr }"><c:out value='${vo.gtwyIpAddr}'/></td>	<!-- 게이트웨이 -->
								<td class="alignL" title="${vo.bndStrtIp }"><c:out value='${vo.bndStrtIp}'/></td>	<!-- 시작 IP -->
								<td class="alignL" title="${vo.bndEndIp }"><c:out value='${vo.bndEndIp}'/></td> <!-- 종료 IP -->
								<td class="alignL" title="${vo.vlan }"><c:out value='${vo.vlan}'/></td>				<!-- VLAN -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="box">
			<div class="box-header"><h3 class="box-title">미할당 IP</h3></div><!-- /box-header -->
			<div class="box-body no-padding"  style="height:320px; overflow-x: auto; overflow-y: auto;">
				<table class="table table-hover table-vertical table-layout-fixed" id="tblIpList">
					<caption>ip목록</caption>
					<thead>
						<tr><th>선택</th>
							<th>IP</th>
							<th>IP(NAT)</th>
							<th>VIP여부</th>
							<th>비고</th></tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${unasgnIpList}" varStatus="i">
							<tr><td><form:radiobutton path="ipAddr" id="ipAddr" name="ipAddr" value="${vo.ipAddr}" title="${vo.ipAddr}"/></td>
								<td class="alignL" title="${vo.ipAddr }"><c:out value="${vo.ipAddr}"/></td>
								<td class="alignL" title="${vo.natIpAddr }"><c:out value='${vo.natIpAddr}'/></td>
								<td><c:out value='${vo.vipYn}'/></td>
								<td class="alginL" title="${vo.rmk }"><c:out value='${vo.rmk }'/></td></tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div><!-- /content -->


 	<!-- popup 버튼 -->
    <div class="col-box-100">
		<div class="button">
			<button class="btn btn-dark" data-target="#tree-resource" onclick="javascript:fn_selectedIP(); return false;">선택</button>
		    <button class="btn close-window" data-target="#tree-resource" onclick="self.close();">닫기</button>
		</div>
	</div><!-- /popup 버튼 -->
</form:form>

<script type="text/javascript" src="/resources/js/jquery/dataTables.customSort.js"></script>
<script type="text/javascript">

	$('#tblIpBnd tr').click(function(e){
		var $target = $(this).find("input");
		if( $target.attr("type") == "radio" ) {
			$target.prop("checked", true);
		} else {
			var checked = $target.prop("checked");
			$target.prop("checked", !checked);
		}

		var bndSeq = $("#tblIpBnd input[id='bndSeq']:checked").val();
		$('#frm #bndSeq').val(bndSeq);
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqIpAddrP.do'/>");
		$('#frm').submit();
	});

	$('#tblIpList tr').click(function(e){
		var $target = $(this).find("input");
		if( $target.attr("type") == "radio" ) {
			$target.prop("checked", true);
		} else {
			var checked = $target.prop("checked");
			$target.prop("checked", !checked);
		}
	});


	//목록 선택하기
 	function fn_selectedIP(){
 		var ipAddr = $("input[name='ipAddr']:checked").val();
 		var bndSeq = $("#tblIpBnd input[id='bndSeq']:checked").val();
 		if(ipAddr=='' || ipAddr== undefined){
 			jAlert("IP를 선택하여 주세요.");
 		}else{
 			window.opener.fn_selectedIPAddr(ipAddr, bndSeq, $('#idIndex').val());
 			self.close();
 		}
 	}


	$("#tblIpBnd").DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [	{sWidth : "50px" },		//선택
		                {sWidth : "50px" },		//용도
		                {sWidth : "125px" },	//ip 대역명
		                {sWidth : "120px" },	//서브넷마스크
		                {sWidth : "120px" },	//게이트웨이
		                {sWidth : "120px" },	//시작IP
		                {sWidth : "120px" },	//종료IP
		                {sWidth : "50px" }		//VLAN

		],
		order : [ [ 1, "asc" ] ]
	});

	$("#tblIpList").DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
		             	{sWidth : "50px" },		//선택
		                {sWidth : "120px" },	//ip, , "sType":"ip-address"
		                {sWidth : "120px" },	//ip(nat)
		                {sWidth : "80px" },		//vip여부
		                {sWidth : "370px" }		//비고
		],
		//order : [ [ 1, "asc" ] ], 2017-06-29 IP 소팅 버그로 주석처리
		order : [ ],
	    columnDefs:[{type:'ip-address', targets:[1]}]
	});

</script>
