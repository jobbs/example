<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-템플릿 선택(팝업)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 17
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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<form:form commandName="searchVo" id="frm" name="frm" method="get">
	<div class="col-box-100">
		<div class="box-search">
			<div class="box-body">
				<div class="form-group">
					<!-- 센터 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title"><label>센터</label></div>
						<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${regionVo.regionNm}'/>"  title="센터" readonly="readonly"></div>
					</div>
					<!--  망구분 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title"><label>망구분</label></div>
						<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${netClVo.cdNm}'/>"  title="망" readonly="readonly"></div>
					</div>
					<!-- 운영체제 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title"><label>운영체제</label></div>
						<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${osTyCd.cdNm}'/>"  title="운영체제" readonly="readonly"></div>
					</div>
					<!-- 용도 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title"><label>용도</label></div>
						<div class="cell-body"><input type="text" class="form-control input-sm" value="<c:out value='${prpos.cdNm}'/>"  title="용도" readonly="readonly"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- content  -->
    <div class="col-box-100">
    	<div class="box">
 			<div class="box-header"><h3 class="box-title">템플릿 목록</h3></div><!-- /box-header -->
			<!--  box-body -->
			<div class="box-body no-padding"  style="height:500px; overflow-x: auto; overflow-y: auto;">
			<table class="table table-vertical table-hover table-layout-fixed" id="tblTmplt">
				<caption>템플릿목록</caption>
				<thead>
					<tr><th>선택</th>
						<th><nobr>사용<br>여부</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>템플릿ID</nobr></th>
						<th><nobr>템플릿명</nobr></th>
						<th><nobr>템플릿<br>구분</nobr></th>
						<th><nobr>템플릿<br>버전</nobr></th>
						<th><nobr>가상화<br>SW</nobr></th>
						<th><nobr>OS<br>타입</nobr></th>
						<th><nobr>운영체제</nobr></th>
						<th><nobr>OS<br>버전</nobr></th>
						<th><nobr>용도</nobr></th>
						<th><nobr>Platform</nobr></th>
						<th><nobr>OS<br>Bit</nobr></th>
						<th><nobr>Kernel</nobr></th>
						<th><nobr>언어</nobr></th>
						<th><nobr>생성일자</nobr></th>
				</thead>
				<tbody>
					<c:forEach var="tmplatVo" items="${list}" varStatus="i">
						<tr>
							<td><form:radiobutton path="" id="rdoTmplat" name ="rdoTmplat" value="${tmplatVo.tmplatSeq }" title="${tmplatVo.tmplatSeq}_선택"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_tmplatSeq"  value="${tmplatVo.tmplatSeq }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_tmplatNm"  value="${tmplatVo.tmplatNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_regionId" value="${tmplatVo.regionId }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_regionNm"  value="${tmplatVo.regionNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_zoneId" value="${tmplatVo.zoneId }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_zoneNm"  value="${tmplatVo.zoneNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_netId"  value="${tmplatVo.netId }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_netNm"  value="${tmplatVo.netNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_netClCd"  value="${tmplatVo.netClCd }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_netClNm"  value="${tmplatVo.netClNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_rsrcPoolId"  value="${tmplatVo.poolId }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_rsrcPoolNm"  value="${tmplatVo.rsrcPoolNm }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_vrlzSwTyCd"  value="${tmplatVo.vrlzSwTyCd }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_vrlzSwTyNm"  value="${tmplatVo.vrlzSwTyNm  }"/>
								<input type="hidden" id="tmplatVo_${tmplatVo.tmplatSeq}_strgAsgnCapa" value="${tmplatVo.strgAsgnCapa  }"/>
							</td>
							<td><nobr>
									<c:choose>
										<c:when test = "${ tmplatVo.useYn eq 'Y' }">
											<span class="status status-green">사용</span>
										</c:when>
										<c:otherwise>
											<span class="status status-gray">미사용</span>
										</c:otherwise>
									</c:choose>
								</nobr></td>
							<td><nobr><c:out value="${tmplatVo.regionNm}"/></nobr></td>
							<td><nobr><c:out value="${tmplatVo.zoneNm}"/></nobr></td>
							<td><nobr><c:out value="${tmplatVo.netClNm}"/></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.rsrcPoolNm}" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.tmplatId}" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.tmplatNm}" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.tmplatClNm}" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.tmplatVer}" /></nobr></td>
							<c:choose>
								<c:when test="${tmplatVo.vrlzSwTyCd ne null}">
									<td class="alignL"><nobr><c:out value="${tmplatVo.vrlzSwTyNm}" /></nobr></td>
								</c:when>
								<c:otherwise>
									<td class="alignL"><nobr>Docker Container</nobr></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${tmplatVo.osTyCd ne null}">
									<td class="alignL"><nobr><c:out value="${tmplatVo.osNm}" /></nobr></td>
								</c:when>
								<c:otherwise>
									<td class="alignL"><nobr>x86</nobr></td>
								</c:otherwise>
							</c:choose>
							<td class="alignL"><nobr><c:out value="${tmplatVo.osNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.osVer }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.prpos }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.pltfrm }" /></nobr></td>
							<td class="alignC"><nobr><c:out value="${tmplatVo.osBitNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.krnlVer }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${tmplatVo.langNm }" /></nobr></td>
							<td><nobr><fmt:formatDate value="${tmplatVo.regDttm }" pattern="yyyy-MM-dd" /></nobr></td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div><!--  /box-body -->
		</div>
	</div><!-- /content  -->
<!-- popup 버튼 -->

	<div class="col-box-100">
		<div class="button">
			<button class="btn btn-dark" data-target="#tree-resource" onclick="javascript:fn_selectedTmplatP(); return false;">선택</button>
			<button class="btn close-window" data-target="#tree-resource" onclick="self.close();">닫기</button>
		</div>
	</div>
<!-- /popup 버튼 -->
</form:form>

<script type="text/javascript">
 	$('#tblTmplt tr').click(function(e){
 		var $target = $(this).find("td input");
		if( $target.attr("type") == "radio" ) {
			$target.prop("checked", true);
		} else {
			var checked = $target.prop("checked");
			$target.prop("checked", !checked);
		}
 	});


  	/**
  	* 템플릿 선택
  	*/
  	function fn_selectedTmplatP(){
  		var tmplat = $("input[name='rdoTmplat']:checked").val();
 		if(tmplat=='' || tmplat== undefined){
 			jAlert("템플릿을 선택하여 주세요.");
 		}else{
 			var tmplatSeq  =  tmplat;

 			var tmplatVo = {
 					tmplatSeq : $("#tmplatVo_"+tmplatSeq+"_tmplatSeq" ).val()
 					, tmplatNm : $("#tmplatVo_"+tmplatSeq+"_tmplatNm" ).val()
 					, regionId : $("#tmplatVo_"+tmplatSeq+"_regionId" ).val()
 					, regionNm : $("#tmplatVo_"+tmplatSeq+"_regionNm" ).val()
 					, zoneId: $("#tmplatVo_"+tmplatSeq+"_zoneId" ).val()
 					, zoneNm: $("#tmplatVo_"+tmplatSeq+"_zoneNm" ).val()
 					, netId: $("#tmplatVo_"+tmplatSeq+"_netId" ).val()
 					, netNm : $("#tmplatVo_"+tmplatSeq+"_netNm " ).val()
 					, netClCd: $("#tmplatVo_"+tmplatSeq+"_netClCd" ).val()
 					, netClNm: $("#tmplatVo_"+tmplatSeq+"_netClNm" ).val()
 					, rsrcPoolId: $("#tmplatVo_"+tmplatSeq+"_rsrcPoolId " ).val()
 					, rsrcPoolNm: $("#tmplatVo_"+tmplatSeq+"_rsrcPoolNm" ).val()
 					, vrlzSwTyCd :$("#tmplatVo_"+tmplatSeq+"_vrlzSwTyCd" ).val()
 					, vrlzSwTyNm : $("#tmplatVo_"+tmplatSeq+"_vrlzSwTyNm" ).val()
 					, strgAsgnCapa : $("#tmplatVo_"+tmplatSeq+"_strgAsgnCapa" ).val()
 			};

 			window.opener.fn_selectedTmplat(tmplatVo);
 			self.close();

 		}
  	}

  	$("#tblTmplt").DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [	{sWidth : "30px" },		//radio
		                {sWidth : "45px" },		//사용여부
		                {sWidth : "40px" },		//센터
		                {sWidth : "45px" },		//존
		                {sWidth : "60px" },		//망구분

		                {sWidth : "130px" },	//자원풀
		                {sWidth : "150px" },	//템플릿ID
		                {sWidth : "150px" },	//템플릿명
		                {sWidth : "40px" },		//템플릿구분
		                {sWidth : "40px" },		//템플릿버전

		                {sWidth : "75px" },		//가상화유형
		                {sWidth : "60px" },		//OS타입
		                {sWidth : "60px" },		//운영체제
		                {sWidth : "40px" },		//OS버전
		                {sWidth : "100px" },	//용도

		                {sWidth : "60px" },		//Platform
		                {sWidth : "40px" },		//OSBit
		                {sWidth : "60px" },		//Kernel
		                {sWidth : "50px" },		//언어
		                {sWidth : "80px" },		//생성일자

		],
		order : [ [ 0, "desc" ] ]
	});
</script>
