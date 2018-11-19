<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<aside class="extra-side">
	<section class="sidebar">

		<div class="form-group info">

			<!-- server info -->
			<div class="box extra-box serverinfo-box">
				<div class="box-body">
					<div class="form-group">
						<table class="table table-no-bordered">
							<caption>부처 자원현황 테이블</caption>
							<colgroup>
								<col class="col43">
								<col class="col40">
								<col class="colAuto">
								<col class="col5">
							</colgroup>
							<tbody>
								<tr>
									<th class="text-red"><i class="fa fa-check-square-o"></i>부처업무</th>
									<th>이용부처</th>
									<th class="alignR" id="extraInsttCnt">0</th>
									<td>개</td>
								</tr>
								<tr>
									<th></th>
									<th>이용업무</th>
									<th class="alignR" id="extraJobCnt">0</th>
									<td>건</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /server info -->

			<!-- server info -->
			<div class="box extra-box serverinfo-box" id="pmServerDiv">
				<div class="box-body">
					<div class="form-group">
						<table class="table table-no-bordered">
							<caption>물리서버 정보 테이블</caption>
							<colgroup>
								<col class="col43">
								<col class="col40">
								<col class="colAuto">
								<col class="col5">
							</colgroup>
							<tbody>
								<tr>
									<th class="text-blue"><i class="fa fa-check-square-o"></i>물리서버</th>
									<th>물리서버수</th>
									<th class="alignR" id="pmServerCnt">0</th>
									<td>개</td>
								</tr>
								<tr>
									<th></th>
									<th>Core보유수</th>
									<th class="alignR" id="pmCpuCnt">0</th>
									<td>개</td>
								</tr>
								<tr>
									<th></th>
									<th>메모리</th>
									<th class="alignR" id="pmMemCapa">0</th>
									<td>GB</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /server info -->

			<!-- server info -->
			<div class="box extra-box serverinfo-box">
				<div class="box-body">
					<div class="form-group">
						<table class="table table-no-bordered">
							<caption>가상서버 정보 테이블</caption>
							<colgroup>
								<col class="col43">
								<col class="col40">
								<col class="colAuto">
								<col class="col5">
							</colgroup>
							<tbody>
								<tr>
									<th class="text-green"><i class="fa fa-check-square-o"></i>가상서버</th>
									<th>가상서버수</th>
									<th class="alignR" id="vmServerCnt">0</th>
									<td>개</td>
								</tr>
								<tr>
									<th></th>
									<th>vCore보유수</th>
									<th class="alignR" id="vmVcoreCnt">0</th>
									<td>개</td>
								</tr>
								<tr>
									<th></th>
									<th>메모리</th>
									<th class="alignR" id="vmMemAsgnCapa">0</th>
									<td>GB</td>
								</tr>
								<tr>
									<th></th>
									<th>스토리지</th>
									<th class="alignR" id="vmStrgAsgnCapa">0</th>
									<td>GB</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<script type="text/javascript">
			doExtraSelectComStte(function(datas) {
				var pmData = datas.pm;
				var vmData = datas.vm;
				var jobData = datas.job;

				$("#extraInsttCnt").html(jobData.institution_cnt);
				$("#extraJobCnt").html(jobData.job_cnt);

				$("#vmServerCnt").html(vmData.vm_cnt);
				$("#vmVcoreCnt").html(vmData.tot_cpu_vcore_qty);
				$("#vmMemAsgnCapa").html(vmData.tot_mem_asgn_capa);
				$("#vmStrgAsgnCapa").html(vmData.tot_strg_asgn_capa);

				//담당자일 경우 VM만 보여 준다.
				if( superposedUserRole == "OPRCHR" ) {
					$("#pmServerDiv").hide();
				} else {
					$("#pmServerCnt").html(pmData.pm_cnt);
					$("#pmCpuCnt").html(pmData.tot_cpu_core_qty);
					$("#pmMemCapa").html(pmData.tot_mem_capa);
				}
			});
			</script>
			<!-- /server info -->

			<!-- user -->
<!-- 			<div class="box extra-box serverinfo-box tap-box nav-tabs-custom"> -->
<!-- 				<ul class="nav nav-tabs"> -->
<!-- 					<li class="active"><a href="#tap-a" data-toggle="tab">사용자</a></li> -->
<!-- 					<li><a href="#tap-b" data-toggle="tab">가상서버 ID</a></li> -->
<!-- 				</ul> -->


		</div>


		<div class="form-group widgets">

			<div class="scroll">

				<div class="box extra-box loginuser-box">
					<div class="box-header">
						<h3 class="box-title"><i class="fa fa-users"></i>사용자정보</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-sm" data-toggle="collapse" data-target="#extra-widget-user">
								<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
							</button>
						</div>
					</div>
					<div class="box-body collapse in" id="extra-widget-user">
						<div class="form-group">
							<form id="extraSearchUserFrm" method="get" onsubmit="doExtraSearchUser(); return false;">
							<table class="table table-no-bordered">
								<caption>사용자 검색 테이블</caption>
								<colgroup>
									<col class="col35">
									<col class="colAuto">
								</colgroup>
								<tbody>
									<tr>
										<th><label for="extraSearchUsrNm">이름</label></th>
										<td>
										  <div class="input-group search-name">
												<input type="text" id="extraSearchUsrNm" class="form-control input-sm" title="이름검색">
												<div class="input-group-btn"><button class="btn btn-sm" onclick="doExtraSearchUser()"><i class="fa fa-search"></i></button></div>
											</div>
										</td>
									</tr>
									<tr>
										<th>ID</th>
										<td id="extraUsrId"></td>
									</tr>
									<tr>
										<th>기관</th>
										<td id="extraInstt"></td>
									</tr>
									<tr>
										<th>직위</th>
										<td id="extraOfcpsNm"></td>
									</tr>
									<tr>
										<th>전화번호</th>
										<td id="extraTelno"></td>
									</tr>
									<tr>
										<th>이메일</th>
										<td id="extraMail"></td>
									</tr>
								</tbody>
							</table>
							</form>
						</div>
					</div>
					<!-- /box-body -->
				</div><!-- /user -->

				<script type="text/javascript">
				function doExtraSearchUser() {

					doExtraSearUserInit();

					var searchUserNm = $("#extraSearchUsrNm").val();
					if( $.trim(searchUserNm) == "" ) {
						jAlert("사용자명을 입력하여 주시기 바랍니다.", function() {
							$("#extraSearchUsrNm").focus();
						});
						return;
					}

					var url = contextPath+'/cmn/component/cpt/usr/selectUsr.do';
					$.get(url, {"searchUserNm" : searchUserNm }, function(result) {

						if( result.success ) {
							var datas = result.data;

							//없을 경우
							if(datas == null ) {
								jAlert("검색된 사용자가 없습니다.");
							//여러명이 나오면 팝업 호출
							} else if( datas.length > 1 ) {
								openUserList({"searchUserNm" : searchUserNm });
							//한명일 경우 화면에 출력
							} else {
								var data = datas[0];
								$("#extraUsrId").text(data.userId);
								$("#extraInstt").text(data.institutionNm);
								$("#extraOfcpsNm").text(data.ofcpsNm);
								$("#extraTelno").text(data.telno);
								$("#extraMail").text(data.email);

							}
						}

					});
				}

				function doExtraSearUserInit() {
					$("#extraUsrId").text("");
					$("#extraInstt").text("");
					$("#extraOfcpsNm").text("");
					$("#extraTelno").text("");
					$("#extraMail").text("");
				}
				</script>


				<!-- box -->
				<div class="box extra-box widget-box" id="extra-widget2">
					<div class="box-header">
						<h3 class="box-title">
							<i class="ci ci-graph"></i>이벤트
						</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-sm" data-toggle="collapse" data-target="#extra-widget-body2">
								<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-placement="bottom"></i>
							</button>
						</div>
					</div>
					<!-- /box-header -->
					<div class="box-body collapse in" id="extra-widget-body2">
						<div class="form-group no-padding">
							<ul class="nav nav-label-list" id="extraEventNav"></ul>
						</div>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box -->


				<!-- box -->
				<div class="box extra-box widget-box" id="extra-widget3">
					<div class="box-header">
						<h3 class="box-title">
							<i class="ci ci-boxes"></i>요청 진행현황
						</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-sm" data-toggle="collapse" data-target="#extra-widget-body3">
								<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
							</button>
						</div>
					</div>
					<!-- /box-header -->
					<div class="box-body collapse in" id="extra-widget-body3">
						<div class="form-group">
							<table class="table table-no-bordered table-left table-layout-fixed" id="extraRsrcReqTbl">
								<caption>요청 진행현황 테이블</caption>
								<colgroup>
									<col class="colAuto">
									<col class="col20">
								</colgroup>
								<tbody>
									<tr><td></td><td></td></tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box -->

			</div>

		</div>
	</section>
</aside>
<!-- /Extra Area -->
<script type="text/javascript">
/* json형태의 Data를 이용하여 요청진행 상황 출력 */

doExtraSelectRsrcReqList("", function(datas) {

	var html = "";

	$("#extraRsrcReqTbl tbody").html("");

	if( datas != null ) {
		var data = null;
		for( var i = 0 ; i < datas.length; i++ ) {
			data = datas[i];

			var rsrcReqTyCd = data.rsrcReqTyCd;
			var rsrcReqNo = data.rsrcReqNo;

			html = '<tr>';
			html += '	<th class="ellipsis"><a href="';

			if(rsrcReqTyCd == "01") { //가상서버 생성
				html += contextPath+'/cpt/opr/req/rsrcreq/selectRsrcReqVmCre.do';
			}else if(rsrcReqTyCd == "02") { //가상서버 삭제
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqVmDel.do';
			}else if(rsrcReqTyCd == "03") { //가상서버 스펙변경
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do';
			}else if(rsrcReqTyCd == "04") {  //SLB설정
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqSlbCre.do';
			}else if(rsrcReqTyCd == "05") { //물리서버추가
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqPhySrvAdd.do';
			}else if(rsrcReqTyCd == "06") {  //물리서버삭제
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqPhySrvDel.do';
			}else if(rsrcReqTyCd == "07") {  //클러스터추가
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqClstAdd.do';
			}else if(rsrcReqTyCd == "08") {  //클러스터삭제
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqClstDel.do';
			}else if(rsrcReqTyCd == "09") {  //스토리지 삭제
				html += contextPath+'/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do';
			}

			html += '?schRsrcReqNo=' + rsrcReqNo + '" title="' + data.sbjct + '">' + data.sbjct + '</a></th>';

			if( data.rsrcReqPrcssStatCd == "01") {
				html += '	<td class="alignC"><span class="status status-blue">요청</span></td>';
			} else if( data.rsrcReqPrcssStatCd == "02") {
				html += '	<td class="alignC"><span class="status status-yellow">처리중</span></td>';
			} else if( data.rsrcReqPrcssStatCd == "03") {
				html += '	<td class="alignC"><span class="status status-green">완료</span></td>';
			} else if( data.rsrcReqPrcssStatCd == "04") {
				html += '	<td class="alignC"><span class="status status-aqua">반려</span></td>';
			} else if( data.rsrcReqPrcssStatCd == "05") {
				html += '	<td class="alignC"><span class="status status-red">오류</span></td>';
			} else {
				html += '	<td class="alignC"><span class="status status-gray">기타</span></td>';
			}
			html += '</tr>';

			$("#extraRsrcReqTbl tbody").append(html);

		}
	} else {
		$("#extraRsrcReqTbl tbody").append("<tr><td class='alignC' colspan='3' style='height:150px;'>데이터가 없습니다.</td></tr>");
	}
});

/* 최초 메인페이지 로딩시 이벤트 현황 호출 후 출력 */
doExtraSelectEvntStteList(function(datas) {

	var html = "";

	$("#extraEventNav").html("");

	if( datas != null ) {
		var data = null;
		for( var i = 0 ; i < datas.length; i++ ) {
			data = datas[i];

			html = '<li><a href="#"><p class="list-title">' + data.trgtNm + '</p>';
			html += '<p class="list-date">' + data.occrDttm + '</p>';
			html += '<p class="list-content">' + data.nowVl + '</p></a></li>';

			$("#extraEventNav").append(html);

			//5개 까지만 보여 지도록 한다.
			if( i >= 5 ) break;
		}
	} else {
		$("#extraEventNav").append("<li class='alignC' style='padding:20px 0;'>데이터가 없습니다.</li>");
	}

});

</script>