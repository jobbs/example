<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>진행내역 팝업(마이크레이션)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 11. 16.
 * @lastmodified 2016. 11. 16.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 16.     김봉민         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="col-box-100">
	<form:form commandName="searchVo" id="frm" name="frm">
		<form:hidden path="procssInstSeq"/>
	</form:form>

	<!-- 요청정보 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">요청정보</h3>
		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>실행내역 요청정보</caption>
				<colgroup>
					<col class="col15">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr><th>요청명</th><td><c:out value ="${procssInstVo.title}"/></td>
				</tbody>
           	</table>
		</div>
	</div>
	<!-- /요청정보- ->

		<!-- 진행상태 -->
		<div class="box" id="divProcss">
			<div class="box-header">
				<div class="pull-left">
					<h3 class="box-title">진행상태<small><c:out value="[${procssInstVo.procssInstSeq}]"/></small></h3>
				</div>
				<div class="pull-right">
					<div class="box-tools mg-5">
						<button class="btn btn-sm btn-function" id="btnReflash" data-toggle="tooltip" data-original-title="새로고침" onclick="fn_syncExecList();"><i class="fa fa-refresh" data-toggle="tooltip" data-original-title="새로고침"></i></button>
						<button class="btn btn-sm btn-function" id="btnCancel" data-toggle="tooltip" data-original-title="실행취소" onclick="fn_procssReqCancel(); return false;"><i class="fa fa-undo" data-toggle="tooltip" data-original-title="실행취소"></i></button>
					</div>
				</div>
			</div><!-- /box-header -->
			<div class="box-body no-padding" id="divProcssArrow">
	            <button class="btn btn-side-info mg-5"><i class="fa fa-caret-right"></i> 실행</button><i class="fa fa-arrow-right"></i>
	            <c:forEach var="vo" items="${list}" varStatus="i">
	            	<button class="btn 	<c:choose>
											<c:when test="${vo.statCd eq '01' or vo.statCd eq '03'}"><c:out value="btn-green"/></c:when>
											<c:when test="${vo.statCd eq '04'}"><c:out value="btn-red"/></c:when>
											<c:otherwise><c:out value="btn-default"/></c:otherwise>
										</c:choose>
									 		btn-lg mg-5" data-toggle="collapse"  data-target=".procssDtl-collapse${i.count}" >

									 	<c:if test="${vo.uJobTyCd eq '03' and vo.statCd ne null
									 					and vo.unitJobProcssListVoList ne null and fn:length(vo.unitJobProcssListVoList)>0}">
									 		<i class="fa  fa-toggle-down"></i>
									 	</c:if>
									<c:out value="${i.count}. ${vo.uJobNm}"/></button><i class="fa fa-arrow-right"></i>
	            </c:forEach>
	            <button class="btn btn-side-info mg-5"><i class="fa fa-check-square-o"></i> 완료</button>
			</div><!-- /box-body -->

			 <div id="divProcssArrowTable">
				 <c:forEach var="unitVo" items="${list}" varStatus="i">
				 	<c:choose>
				 		<c:when test="${unitVo.unitJobProcssListVoList ne null}">
				 			<div class="box-body collapse procssDtl-collapse${i.count}" id="dtl${i.count}">
				 				<div class="box-header"><h3 class="box-title"><small><c:out value="${i.count}. ${unitVo.uJobNm}"></c:out></small></h3></div><!-- /box-header -->
								<div class="box-body no-padding">
				 					<c:forEach var="sbUnitVo" items="${unitVo.unitJobProcssListVoList}" varStatus="idx">
				 						<c:choose>
				 							<c:when test="${sbUnitVo.unitJobProcssVoList  ne null}">
				 								<div class="box-header"><h3 class="box-title">진행상태  <small>프로세스 인스턴스 SEQ <c:out value=" [${sbUnitVo.procssInstSeq}]" /></small></h3></div><!-- /box-header -->
				 								<div class="box-body no-padding">
					 								<button class="btn btn-side-info mg-5"><i class="fa fa-caret-right"></i> 실행</button><i class="fa fa-arrow-right"></i>
					 								<c:forEach var="vo" items="${sbUnitVo.unitJobProcssVoList}" varStatus="j">
					 									<button class="btn	<c:choose>
					 															<c:when test="${vo.statCd eq '01' or vo.statCd eq '03' }">
					 																<c:out value="btn-green"/>
					 															</c:when>
					 															<c:when test="${vo.statCd eq '04' }">
					 																<c:out value="btn-red"/>
					 															</c:when>
					 															<c:otherwise>
					 																<c:out value="btn-default"/>
					 															</c:otherwise>
					 														</c:choose>
					 														btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse-sub${i.count}_${idx.count}_${j.count}">
					 										<c:out value="${j.count}. ${vo.uJobNm}"/>
					 									</button><i class="fa fa-arrow-right"></i>
					 								</c:forEach>
					 								<button class="btn btn-side-info mg-5"><i class="fa fa-check-square-o"></i> 완료</button>
				 								</div><!--  /box-body -->

												<!--  inner table  -->

				 								<div class="box-body no-padding">
				 									<table class="table table-bordered">
				 										<caption>하위 진행내역의 상세 정보</caption>
														<colgroup>
													  		<col class="col4">
															<col class="col12">
															<col class="col10">
															<col class="col10">
															<col class="col8">
															<col class="col10">
															<col class="col6">
															<col class="colAuto">
														</colgroup>
									                	<thead>
											            	<tr><th>No.</th>
											                    <th>작업명</th>
											                    <th>수행 요청일시</th>
											                    <th>처리일시</th>
											                    <th>작업상태</th>
											                    <th>비고</th>
											                    <th>재처리 횟수</th>
											                    <th>오류메시지</th></tr>
														</thead>
											            <tbody>
											            	<c:forEach var="vo" items="${sbUnitVo.unitJobProcssVoList}" varStatus="i">
											                	<tr><td><c:out value="${i.count}"/></td>
											                		<td><c:out value="${vo.uJobNm}"/></td>
											                		<td><c:out value="${vo.strtDttm}"/></td>
											                		<td><c:out value="${vo.endDttm}"/></td>
											                		<td><c:out value="${vo.statNm}"/>
											                			<c:choose>
			                												<c:when test="${vo.statCd eq '04' }">
			                													<br><button class="btn btn-sm btn-function" onclick="fn_reProcssJob(${vo.procssInstSeq}, ${vo.procssJobInstSeq}); ">재처리</button>
			                												</c:when>
			                											</c:choose>
											                		</td>
											                		<td class="alignL"><c:out value="${vo.dc}"/></td>
											                		<td><c:out value="${vo.reProcssCnt}"/></td>
			                										<td class="alignL"><c:out value="${vo.errCn}"/></td></tr>
											                </c:forEach>
									                	</tbody>
									              	</table>
				 								</div><!--  /inner table  -->
				 							</c:when>
				 						</c:choose>
				 					</c:forEach>
				 				</div>
							</div><!-- /box-body collapse-->
						</c:when>
				 	</c:choose>
				</c:forEach>
			</div><!-- /divProcssArrowTable -->
		</div>
		<!-- 진행상태 상세-->
		<div class="box">
			<div class="box-header"><h3 class="box-title">진행상태 <small>[실행내역 상세정보]</small></h3></div><!-- /box-header -->
			<div class="box-body no-padding" id="divProcssDtl">
				<table class="table table-hover table-vertical"  id="noticeTable">
					<caption>진행내역의 상세 정보</caption>
					<colgroup>
				  		<col class="col4">
						<col class="col12">
						<col class="col10">
						<col class="col10">
						<col class="col8">
						<col class="col10">
						<col class="col6">
						<col class="colAuto">
					</colgroup>
                	<thead>
		            	<tr><th>No.</th>
		                    <th>작업명</th>
		                    <th>수행 요청일시</th>
		                    <th>처리일시</th>
		                    <th>작업상태</th>
		                    <th>비고</th>
		                    <th>재처리 횟수</th>
		                    <th>오류메시지</th></tr>
					</thead>
		            <tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
		                	<tr><td><c:out value="${i.count}"/></td>
		                		<td><c:out value="${vo.uJobNm}"/></td>
		                		<td><c:out value="${vo.strtDttm}"/></td>
		                		<td><c:out value="${vo.endDttm}"/></td>
		                		<td><c:out value="${vo.statNm}"/>
		                			<c:choose>
		                				<c:when test="${vo.statCd eq '04' }">
		                					<br><button class="btn btn-sm btn-function" onclick="fn_reProcssJob(${vo.procssInstSeq}, ${vo.procssJobInstSeq}); ">재처리</button>
		                				</c:when>
		                			</c:choose>
		                		</td>
		                		<td class="alignL"><c:out value="${vo.dc}"/></td>
		                		<td><c:out value="${vo.reProcssCnt}"/></td>
		                		<td class="alignL">${vo.errCn}</td></tr>
						</c:forEach>
                	</tbody>
              	</table>
			</div>
		</div>
	</div>
	<!-- popup 버튼 -->
	<div class="col-box-100">
		<div class="button"><button class="btn close-window"  data-target="#tree-resource">닫기</button></div>
	</div><!-- /popup 버튼 -->
	<script type="text/javascript">

	$(function() {

		//주기적 호출
		setInterval(function(){
			fn_syncExecList();
		}, 30*1000);

		if ($('#divProcssArrow button.btn-green, #divProcssArrow button.btn-red').size() == 0) {
			$('#divProcssArrow .btn-side-info').eq(1).addClass('btn-green');
		}
	});

	/**
	* 재처리 실행
	*/
	function fn_reProcssJob(procssInstSeq, procssJobInstSeq){
		jAlert("procssInstSeq="+ procssInstSeq+", procssJobInstSeq="+procssJobInstSeq);
		jConfirm("재처리를 실행하시겠습니까", function(result){
			var data ={procssInstSeq : procssInstSeq, procssJobInstSeq : procssJobInstSeq};
			$.post("<c:url value='updateRsrcReqProcssJobStat.do'/>", data, function(result){
				if(result.success){
					jInfo(result.messageList, function() {
						//self.close();
						fn_syncExecList();
					});
				}else{
					jAlert(result.messageList, function() {});
				}
			}, 'json');
		});
	}

	/**
	* 새로 고침
	*/
	function fn_syncExecList(){
		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_successHandler,
			beforeSend: function() {
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('실행내역 조회 실패');
			}
		}

		$('#frm').attr("action", "<c:url value='selectRsrcReqExeListPSub.do'/>");
		$('#frm').ajaxSubmit(options);
	}

	/**
	* 실행 취소
	*/
	function fn_procssReqCancel(){
		jConfirm('프로세스 실행 취소를 하시겠습니까?', function(){
			$.ncmsLoding.startFullScreen();
			$.post('updateRsrcReqProcssCancel.do', $('#frm').serialize(), function(result){
				if(result.success){
					jInfo("프로세스실행 취소 처리에 성공하였습니다.");
					self.close();
				}else{
					jAlert("프로세스 실행 취소 처리에 실패하였습니다.");
				}
			}, 'json').always(function(){$.ncmsLoding.remove();});
		});
	}


	/**
	* 응답 성공시 조회
	*/
	function fn_successHandler(result) {
		if(result.success) {
			//진행 요약 표시
			$('#divProcssArrow').html(reflushProcessArrow(result.data));
			//서브 진행 내역 출력
			$('#divProcssArrowTable').html(reflushProcessArrowSub(result.data));
			//전체 진행 내역 상세
			$('#divProcssDtl table tbody').html(reflushProcssDtl(result.data));

			if ($('#divProcssArrow button.btn-green, #divProcssArrow button.btn-red').size() == 0) {
				$('#divProcssArrow .btn-side-info').eq(1).addClass('btn-green');
			}
		}
		else {
			jAlert(result.messageList);
		}
	}

	/*
	* 진행내역 서버 표시
	*/
	function reflushProcessArrowSub(list){
		if(list == null) return;
		var html = '';
		for(var i=0; i<list.length;i++){
			var unitVo = list[i];
			if(unitVo != null && unitVo.unitJobProcssListVoList != null && unitVo.unitJobProcssListVoList.length>0){
				var icount = i+1;

				html += '<div class="box-body collapse procssDtl-collapse'+icount+'" id="dtl'+icount+'">';
				html += '<div class="box-header"><h3 class="box-title"><small>'+icount+'. '+unitVo.uJobNm+'</small></h3></div>';	//header
				html += '<div class="box-body no-padding">';

				for(var j = 0; j<unitVo.unitJobProcssListVoList.length; j++){
					var sbUnitVo = unitVo.unitJobProcssListVoList[j];
					var idxcount = j+1;
					if(sbUnitVo.unitJobProcssVoList != null && sbUnitVo.unitJobProcssVoList.length>0){
						html += '<div class="box-header"><h3 class="box-title">진행상태  <small>프로세스 인스턴스 SEQ ['+sbUnitVo.procssInstSeq+']</small></h3></div>';
						html += '<div class="box-body no-padding">';

						html += '<button class="btn btn-side-info mg-5"><i class="fa fa-caret-right"></i> 실행</button>';
						html += '<i class="fa fa-arrow-right"></i> ';

						for(var k=0; k<sbUnitVo.unitJobProcssVoList.length; k++){
							var vo = sbUnitVo.unitJobProcssVoList[k];
							var jcount = k+1;

							html += getProcssButton(vo, jcount);
							html += '<i class="fa fa-arrow-right"></i> ';
						}

						html += '<button class="btn btn-side-info mg-5"><i class="fa fa-check-square-o"></i> 완료</button>';
						html += '</div>';	//box-body

						html += '<div class="box-body no-padding">';
						html += '<table class="table table-bordered">';
						html += reflushProcssDtlHeader('하위 진행내역의 상세 정보');
						html += '<tbody>';
						html += reflushProcssDtl(sbUnitVo.unitJobProcssVoList);
						html += '</tbody>';
						html += '</table>';
						html += '</div>';	//box-body table
					}
				}

				html += '</div>';	//box-body
				html += '</div>';	//collapse
			}
		}
		return  html;
	}

	/**
	* 진행 버튼
	*/
	function getProcssButton(vo, icount ){
		var html='';
	  	var toggleDownHtml = "";
 		if(vo != null && vo.uJobTyCd == '03' && vo.statCd != null
			&& vo.unitJobProcssListVoList != null && vo.unitJobProcssListVoList.length>0){
 			toggleDownHtml ='<i class="fa fa-toggle-down"></i>';
 		}

		if(vo.statCd == '01' || vo.statCd == '03'){
			if(vo.uJobTyCd == '03'){
				html += '<button class="btn btn-green btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">' +toggleDownHtml + icount+'. ' + vo.uJobNm+ '</button>';
			}else{
				html += '<button class="btn btn-green btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">'+icount + '. ' + vo.uJobNm +'</button>';
			}
		}else if(vo.statCd == '04'){
			if(vo.uJobTyCd == '03'){
				html += '<button class="btn btn-red btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">'+toggleDownHtml+icount+'. ' + vo.uJobNm+ '</button>';
			}else{
				html += '<button class="btn btn-red btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">'+icount + '. ' + vo.uJobNm +'</button>';
			}
		}else if(vo.statCd != null &&  vo.statCd != ''){
			if(vo.uJobTyCd == '03'){
				html += '<button class="btn btn-default btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">' +toggleDownHtml +icount+'. ' + vo.uJobNm+ '</button>';
			}else{
				html += '<button class="btn btn-default btn-lg mg-5" data-toggle="collapse" data-target=".procssDtl-collapse'+icount+'">'+icount + '. ' + vo.uJobNm +'</button>';
			}
		}else{
			html += '<button class="btn btn-default btn-lg mg-5" >'+icount+'. ' + vo.uJobNm +'</button>';
		}
		return html;
	}

	/*
	* 진행 내역 요약 표시
	*/
	function reflushProcessArrow(list){
		var html = '';
		html += '<button class="btn btn-side-info mg-5"><i class="fa fa-caret-right"></i> 실행</button>';
		html += '<i class="fa fa-arrow-right"></i> ';
		for(var i=0; i<list.length; i++){
			var vo = list[i];
			var icount = i+1;
			html += getProcssButton(vo, icount);
			html += '<i class="fa fa-arrow-right"></i> ';
		}
		html += '<button class="btn btn-side-info mg-5"><i class="fa fa-check-square-o"></i> 완료</button>';
		return html;
	}

	function reflushProcssDtlHeaderColgroup(){
		html ='';
		html += '<colgroup>';
		html += '<col class="col4">';
		html += '<col class="col12">';
		html += '<col class="col10">';
		html += '<col class="col10">';
		html += '<col class="col8">';
		html += '<col class="col10">';
		html += '<col class="col6">';
		html += '<col class="colAuto">';
		html += '</colgroup>';
		return html;
	}

	function reflushProcssDtlHeader(caption){
		html = '<caption>'+caption+'</caption>';
		html += reflushProcssDtlHeaderColgroup();
		html += '<thead>';
		html += '<tr><th>No.</th>';
		html += '<th>작업명</th>';
		html += '<th>수행 요청일시</th>';
		html += '<th>처리일시</th>';
		html += '<th>작업상태</th>';
		html += '<th>비고</th>';
		html += '<th>재처리 횟수</th>';
		html += '<th>오류메시지</th></tr>';
		html += '</thead>';
		return html;
	}
	/*
	*	진행내역 상세 표시
	*/
	function reflushProcssDtl(list){
		var html = '';
		for(var i=0; i<list.length; i++){
			var vo = list[i];
			html += "<tr>";
			html += "<td>"+ (i+1) + "</td>";
			html += "<td>"+ ( vo.uJobNm != null ? vo.uJobNm: "") + "</td>";
			html += "<td>"+ ( vo.strtDttm != null ? vo.strtDttm:"") + "</td>";
			html += "<td>"+ ( vo.endDttm != null ? vo.endDttm:"") + "</td>";
			html += "<td>"+ (vo.statNm != null ? vo.statNm:"" );

			if(vo.statCd == '04'){
				html += '<br><button class="btn btn-sm btn-function" onclick="fn_reProcssJob('+vo.procssInstSeq+',' +vo.procssJobInstSeq+ '); ">재처리</button>';
			}
			html += "</td>";
			html += "<td class='alignL'>"+ (vo.dc  != null ? vo.dc:"") + "</td>";
			html += "<td>"+ vo.reProcssCnt + "</td>";
			html += "<td class='alignL'>"+ (vo.errCn != null ? vo.errCn:"" ) + "</td>";
			html += "</tr>";
		}
		return html;
	}
	</script>
