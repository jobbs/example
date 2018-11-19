<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-스토리지 선택(팝업)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 14
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<form:form path="" id="frm" name="frm" method="get">
<!--검색 영역  -->
	<div class="col-box-100">
	<!-- box-search -->
    	<div class="box-search">
			<div class="box-body">
      			<div class="form-group">
      			<!-- 센터 --><!--/센터 -->
      				<div class="form-cell form-cell-50 col-lay-25">
				    	<div class="cell-title"><label>센터</label></div>
						<div class="cell-body"><nform:selectRegion
										name="regionId" title="센터선택"
										id="regionId"
										whole="true"
										value="${searchVo.searchRegionId}"
										wholeText="센터를 선택하세요"  byRole="false"
										cssClass="form-control input-sm"
										onchange="selectZoneDy(this, 'zoneId',  {'byRole' : false} )"  /></div>
					</div>
      			  	<!-- 존 -->
      			  	<div class="form-cell form-cell-50 col-lay-25">
				    	<div class="cell-title"><label>존</label></div>
						<div class="cell-body">
				        	<nform:selectZone name="zoneId" title="존선택"
										id="zoneId"
										whole="true"
										value="${searchVo.searchZoneId}"
										regionId="${searchVo.searchRegionId}"
										wholeText="존을 선택하세요"	byRole="false"
										cssClass="form-control input-sm"
										onchange="selectNetDy(this, 'netId',  {'byRole' : false} )" /></div>
					</div><!--/존 -->
      			  	<!-- 망 -->
      			  	<div class="form-cell form-cell-50 col-lay-25">
				    	<div class="cell-title"><label>망</label></div>
						<div class="cell-body">
							<nform:selectNet	name="netId" title="망선택"
											id="netId"
											whole="true"
											wholeText="망을 선택하세요" byRole="false"
											value="${searchVo.searchNetId}"
											zoneId="${searchVo.searchZoneId}"
											cssClass="form-control input-sm"
											onchange="selectPoolDy(this, 'regionId', 'zoneId', 'poolId', {'searchSwTypeCd':'COM', 'searchPoolTypeCd' : '01', 'byRole' : false} )" /></div>
					</div><!--/망 -->
					<!-- 자원풀 -->
					<div class="form-cell form-cell-50 col-lay-25">
				    	<div class="cell-title"><label>자원풀</label></div>
						<div class="cell-body">
							<nform:selectPool name="rsrcPoolId" id="rsrcPoolId" wholeText="자원 풀을 선택하세요"  title="자원풀"
											value="${searchVo.searchRsrcPoolId}" regionId="${searchVo.searchRegionId}"
											 zoneId="${searchVo.searchZoneId}" netId="${searchVo.searchNetId}"
											 cssClass="form-control input-sm" onchange="selectClusterDy(this, 'clusterId' )" />

											</div>
					</div><!--/자원풀 -->

				</div>	<!--/form-group -->
			</div><!--/box-body  -->
		<!-- /box-footer -->

		</div><!-- /box-search -->
	</div> <!--/검색 영역  -->

	<!-- content  -->
    <div class="col-box-100">
    	<div class="box">
 			<div class="box-header"><h3 class="box-title">스토리지 목록</h3></div><!-- /box-header -->
			<!--  box-body -->
			<div class="box-body no-padding"  style="height:500px; overflow-y: auto; overflow-y: auto;">
				<table class="table table table-vertical table-hover table-layout-fixed" id="tblPStrg">
					<caption>스토리지목록</caption>
				    <thead>
				    	<tr><th>선택</th>
				        	<th>센터</th>
				            <th>존</th>
				            <th>망</th>
				            <th>스토리지명</th>
				            <th>전체량(GB)</th>
				            <th>사용량(GB)</th>
				            <th>VM할당량(GB)</th>
				            <th>여유량(GB)</th></tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr><td><input type="radio" id="rdo" name="rdo" value="${vo.strgDmnSeq}%lt%gt${vo.strgDmnNm}" title="${vo.strgDmnSeq}_스토리지" /></td>
								<td><c:out value="${vo.regionNm}"/></td>
							    <td><c:out value="${vo.zoneNm}"/></td>
							    <td><c:out value="${vo.netNm}"/></td>
							    <td class="alignL" ><c:out value="${vo.strgDmnNm}"/></td>
							    <td class="alignR"><nobr><fmt:formatNumber value="${vo.wholeAsgnCapa}" pattern="#,###.##"/></nobr></td>
							    <td class="alignR"><nobr><fmt:formatNumber value="${vo.strgUseCapa}" pattern="#,###.##"/></nobr></td>
							    <td class="alignR"><nobr><fmt:formatNumber value="${vo.vmAsgnCapa}" pattern="#,###.##"/></nobr></td>
							    <td class="alignR"><nobr><fmt:formatNumber value="${vo.strMrgnCapa}" pattern="#,###.##"/></nobr></td></tr>
						</c:forEach>
					</tbody>
				</table>
			</div><!--  /box-body -->
		</div>
	</div><!-- /content  -->

	<!-- popup 버튼 -->
    <div class="col-box-100">
		<div class="button">
			<button class="btn btn-dark" data-target="#tree-resource" onclick="javascript:fn_selectedStrg(); return false;">선택</button>
			<button class="btn close-window" data-target="#tree-resource" onclick="self.close();">닫기</button>
		</div>
	</div><!-- /popup 버튼 -->
</form:form><!-- /form -->

<script type="text/javascript">
	$('#regionId').attr('disabled',true);
	$('#zoneId').attr('disabled',true);
	$('#netId').attr('disabled',true);
	$('#rsrcPoolId').attr('disabled',true);

	/**
	* 조회
	*/
  	function fn_search(){
  		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqStrgP.do'/>");
  	 	$('#frm').submit();
  	}
  	/**
  	 *선택
  	*/
	function fn_selectedStrg(){
		var strg = $("input[name='rdo']:checked").val();
 		if(strg=='' || strg== undefined){
 			jAlert("스토리지를 선택하여 주세요.");
 		}else{
 			var vo =  strg.split("%lt%gt");
 			var strgVo = { strgDmnSeq : vo[0], strgDmnNm: vo[1] };
 			window.opener.fn_selectedStrg(strgVo);
 			self.close();
 		}
	}

	$("#tblPStrg").DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [	{sWidth : "50px" },		//radio
		                {sWidth : "60px" },		//센터
		                {sWidth : "60px" },		//존
		                {sWidth : "60px" },		//망
		                {sWidth : "180px" },		//스토리지명
		                {sWidth : "100px" },		//전체량
		                {sWidth : "100px" },		//사용량
		                {sWidth : "100px" },		//VM할당량
		                {sWidth : "100px" }		//여유량
		],
		order : [ [ 0, "desc" ] ]
	});



	$('table tr').click(function(e){
		var $target = $(this).find("td input");
		if( $target.attr("type") == "radio" ) {
			$target.prop("checked", true);
		} else {
			var checked = $target.prop("checked");
			$target.prop("checked", !checked);
		}
	});
</script>