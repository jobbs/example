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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ page import="ncis.cmn.security.vo.UserVo" %>

<sec:authentication property="principal" var="user" />

<section class="board " >
	<div class="row">
		<div class="col-box-100 col-lay-20 info-box">

			<div>
             	<h2 class="box-title pad-bottom-10">
             		<small>최종접속일 : <fmt:formatDate value="${user.ncmsRcntLoginDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></small>
				</h2>
            </div>

			<div class="box serverinfo-box border-2px border-red no-margin-left">
            	<div class="box-body " style="padding:7px" >
                	<div class="left pull-left" >
                    	<h4 class="text-red alignC pad-bottom-5">부처업무</h4>
                        <p style="margin:0;"><img src="<c:url value="/resources/images/icon-work.png" />" width="26px" height="25px" alt=""></p>
                    </div>
                    <div class="right" >
	                    <table class="table table-no-bordered" style="width:70%; float:right;">
							<caption>부처업무 정보 테이블</caption>
							<colgroup>
							<col class="col40">
							<col class="col10">
							<col class="col5">
							</colgroup>
							<tbody>
							  <tr>
							    <th>이용부처</th>
							    <th class="alignR" id="mainInsttCnt">0</th>
							    <td>개</td>
							  </tr>
							  <tr>
							    <th>이용업무</th>
							    <th class="alignR" id="mainJobCnt">0</th>
							    <td>개</td>
							  </tr>
							</tbody>
	                  </table>
                    </div>
                </div>
            </div>

			<div class="box serverinfo-box border-2px border-blue" id="pmServerDiv">
				<div class="box-body" style="padding:7px">
					<div class="left pull-left">
						<h4 class="text-blue alignC pad-bottom-5">물리서버</h4>
						<p style="margin:0;"><img src="<c:url value="/resources/images/icon-server.png" />" width="26px" height="25px" alt=""></p>
					</div>
					<div class="right" style="position:relative;">
					<table class="table table-no-bordered" style="width:70%; float:right;">
						<caption>물리서버 정보 테이블</caption>
						<colgroup>
						  <col class="col40">
						  <col class="col10">
						  <col class="col5">
						</colgroup>
						<tbody>
						  <tr>
							<th>물리서버수</th>
							<th class="alignR" id="pmServerCnt">0</th>
							<td>개</td>
						  </tr>
						  <tr>
							<th>Core보유수</th>
							<th class="alignR" id="pmCpuCnt">0</th>
							<td>개</td>
						  </tr>
						  <tr>
							<th>메모리</th>
							<th class="alignR" id="pmMemCapa">0</th>
							<td>GB</td>
						  </tr>
						</tbody>
				  	</table>
				</div>
			</div>
		</div>

		<div class="box serverinfo-box border-2px border-green" id="vmServerDiv">
           	<div class="box-body" style="padding:7px">
               	<div class="left pull-left">
                 	<h4 class="text-green alignC pad-bottom-5">가상서버</h4>
                    <p style="margin:0;"><img src="<c:url value="/resources/images/icon-virtual-server.png" />" width="26px" height="25px" alt=""></p>
                </div>
                <div class="right" style="position:relative;">
                   	<table class="table table-no-bordered" style="width:70%; float:right;">
	                   <caption>가상서버 정보 테이블</caption>
	                   <colgroup>
	                     <col class="col40">
	                     <col class="col10">
	                     <col class="col5">
	                   </colgroup>
	                   <tbody>
	                     <tr>
	                       <th>가상서버수</th>
	                       <th class="alignR" id="vmServerCnt">0</th>
	                       <td>개</td>
	                     </tr>
	                     <tr>
	                       <th>vCore보유수</th>
	                       <th class="alignR" id="vmVcoreCnt">0</th>
	                       <td>개</td>
	                     </tr>
	                     <tr>
	                       <th>메모리</th>
	                       <th class="alignR" id="vmMemAsgnCapa">0</th>
	                       <td>GB</td>
	                     </tr>
	                     <tr>
	                       <th>스토리지</th>
	                       <th class="alignR" id="vmStrgAsgnCapa">0</th>
	                       <td>GB</td>
	                     </tr>
	                   </tbody>
                 	</table>
             	</div>
         	</div>
     	</div>

		<div class="box serverinfo-box border-2px border-yellow" id="atmsclDiv">
           	<div class="box-body" style="padding:7px">
               	<div class="left pull-left">
                	<h4 class="text-yellow alignC pad-bottom-5">자동확장<br>서비스</h4>
                    <p style="margin:0;"><img src="<c:url value="/resources/images/icon-expand.png" />" width="26px" height="25px" alt=""></p>
               	</div>
               	<div class="right" style="position:relative;">
                   <table class="table table-no-bordered" style="width:70%; float:right;">
                   <caption>자동확장서비스 정보 테이블</caption>
                   <colgroup>
                     <col class="col40">
                     <col class="col10">
                     <col class="col5">
                   </colgroup>
                   <tbody>
                     <tr>
                       <th>서비스수</th>
                       <th class="alignR" id="atmsclServcCnt">0</th>
                       <td>개</td>
                     </tr>
                     <tr>
                       <th>Core보유수</th>
					<th class="alignR" id="atmsclCoreCnt">0</th>
                       <td>개</td>
                     </tr>
                     <tr>
                       <th>메모리</th>
                       <th class="alignR" id="atmsclMemAsgnCnt">0</tH>
                       <td>GB</td>
                     </tr>
                     <tr>
                       <th>Pod</th>
                       <th class="alignR" id="atmsclPodCnt">0</tH>
                       <td>개</td>
                     </tr>
                   </tbody>
                 </table>
             </div>
         </div>
     </div>
</div>
		<script type="text/javascript">
		doExtraSelectComStte(function(datas) {

			try {
				var pmData = datas.pm;
				var vmData = datas.vm;
				var jobData = datas.job;
				var atmsclData = datas.atmscl;

				$("#mainInsttCnt").html(jobData.institution_cnt);
				$("#mainJobCnt").html(jobData.job_cnt);

				$("#vmServerCnt").html(comma(vmData.vm_cnt));
				$("#vmVcoreCnt").html(comma(vmData.tot_cpu_vcore_qty));
				if(vmData.tot_mem_asgn_capa>10000) {
					$("#vmMemAsgnCapa").html(comma(Math.round(vmData.tot_mem_asgn_capa/1024)));
					$("#vmMemAsgnCapa").next().html('TB')
				} else {
					$("#vmMemAsgnCapa").html(comma(vmData.tot_mem_asgn_capa));
				}
				//$("#vmStrgAsgnCapa").html(vmData.tot_strg_asgn_capa);
				if (vmData.tot_strg_asgn_capa>10000) {
					$("#vmStrgAsgnCapa").html(comma(Math.round(vmData.tot_strg_asgn_capa/1024)+''));
					$("#vmStrgAsgnCapa").next().html('TB')
				} else {
					$("#vmStrgAsgnCapa").html(comma(vmData.tot_strg_asgn_capa));
				}

				$("#atmsclServcCnt").html(atmsclData.servc_qty);
				$("#atmsclCoreCnt").html(atmsclData.sum_cpu_cor_qty);
				$("#atmsclMemAsgnCnt").html(atmsclData.sum_mem_asgn_capa);
				$("#atmsclPodCnt").html(atmsclData.pod_qty);


				//담당자일 경우 VM만 보여 준다.
				if( superposedUserRole == "OPRCHR" ) {
					//$("#pmServerDiv").appendTo("#userinfo-box");
					//$("#pmServerDiv").css("visibility", "hidden");
					$("#pmServerDiv").hide();
				} else {
					$("#pmServerCnt").html(pmData.pm_cnt);
					$("#pmCpuCnt").html(comma(pmData.tot_cpu_core_qty));
					if(pmData.tot_mem_capa>10000) {
						$("#pmMemCapa").html(comma(Math.round(pmData.tot_mem_capa/1024)));
						$("#pmMemCapa").next().html('TB');
					} else {
						$("#pmMemCapa").html(comma(pmData.tot_mem_capa));
					}
				}
			} catch(err) {
				console.log("err : " + err);
			}

			function comma(str) {
				if(str==null) return null;
				x = str+'';
                return x.toString().replace(/,/g,"").replace(/\B(?=(\d{3})+(?!\d))/g,",");
			}
		});
		</script>
		<div class="col-box-30 col-lay-25 col-lay-no-padding-left">
			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">요청 진행상황</h3>
					<div class="box-tools">
						<div class="pull-right">
							<button type="button" class="btn btn-sm" data-toggle="tooltip" data-original-title="더보기" onclick="goRsrcReq()">
								<i class="fa fa-ellipsis-v"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#" onclick="doExtraSelectRsrcReqList('', printRsrcReq)" data-toggle="tab">전체</a></li>
						<li><a href="#" onclick="doExtraSelectRsrcReqList('01', printRsrcReq)" data-toggle="tab">요청</a></li>
						<li><a href="#" onclick="doExtraSelectRsrcReqList('02', printRsrcReq)" data-toggle="tab">처리중</a></li>
					</ul>
					<div class="tab-content" style=" height: 295px">
						<div class="tab-pane active" id="tap-rsrcReq">
							<table class="table table-no-bordered table-layout-fixed">
								<caption>요청진행상황 목록 테이블</caption>
								<colgroup>
									<col width="10px">
									<col width="60px">
									<col class="*">
									<col width="90px">
								</colgroup>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box(목록조회 테이블) -->
		</div>

		<div class="col-box-40 col-lay-30 no-padding-left">
			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">이벤트 현황</h3>
					<div class="box-tools">
						<div class="pull-right">
							<button class="btn btn-sm" data-toggle="tooltip" data-original-title="더보기" onclick="goEvntStte()">
								<i class="fa fa-ellipsis-v"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<ul class="nav nav-tabs">
						<li class="active"><a href="javascript:void(0)" onclick="fn_selectEvntStte('')" data-toggle="tab">전체</a></li>
						<li><a href="javascript:void(0)" onclick="fn_selectEvntStte('01')" data-toggle="tab"><span class="label label-red label-dot"></span> Down</a></li>
						<li><a href="javascript:void(0)" onclick="fn_selectEvntStte('02')" data-toggle="tab"><span class="label label-yellow label-dot"></span> Critical</a></li>
						<li><a href="javascript:void(0)" onclick="fn_selectEvntStte('03')" data-toggle="tab"><span class="label label-gray label-dot"></span> Major</a></li>
					</ul>
					<div class="tab-content" style=" height: 295px">
						<div class="tab-pane active" id="tap_evntStte">
							<table class="table table-no-bordered table-layout-fixed">
								<caption>이벤트 현황 목록 테이블</caption>
								<colgroup>
									<col width="15px">
									<col width="100px">
									<col width="*">
									<col width="120px">
								</colgroup>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box(목록조회 테이블) -->
		</div>

		<div class="col-box-30 col-lay-25 no-padding-left">
			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">공지사항</h3>
					<div class="box-tools">
						<div class="pull-right">
							<button class="btn btn-sm" data-toggle="tooltip" data-original-title="더보기" onclick="goNotice()">
								<i class="fa fa-ellipsis-v"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<div class="tab-content notice" style=" height: 323px">
						<div class="tab-pane active">
							<table class="table table-no-bordered table-layout-fixed">
								<caption>공지사항 목록 테이블</caption>
								<colgroup>
									<col width="20px">
									<col width="*">
									<col width="120px">
								</colgroup>
								<tbody>
								<c:forEach items="${noticeList }" var="notice">
									<c:url var="detailUrl" value="/cpt/board/notice/selectBoard.do">
										<c:param name="boardSeq" value="${notice.boardSeq }" />
									</c:url>
									<tr>
										<td class="list-style alignR">·</td>
										<td class="alignL ellipsis">
											<a href="${detailUrl }" title="<c:out value="${notice.sbjct}"/>"><c:out value="${notice.sbjct }" /></a>
										</td>
										<td class="text-gray alignR"><fmt:formatDate value="${notice.regDt }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box(목록조회 테이블) -->
		</div>

	</div>

	<script type="text/javascript">
		$(function() {
			$("#tab-atmscl").hide();
			//fn_boardResize();
		});

		/* 창 크기에 따른 요청진행상황, 이벤트현황, 공지사항 BOX 크기 변경 */
		function fn_boardResize() {
			var base = $(".board .info-box");
			var rowHeight = base.height() - 3;

			if($(window).width() >= 1200 ){
				base.siblings("div").css({
					"height" : rowHeight
				});
				var boxbodyHeight = rowHeight - 40 - 30;
				$(".board .board-box .tab-content").css({ "height" : boxbodyHeight });
				$(".board .board-box .notice").css({ "height" : boxbodyHeight + 28 });
			}else{
				base.siblings("div").removeAttr("style");
				$(".board .board-box .tab-content").css({ "height" : "295px" });
				$(".board .board-box .notice").css({ "height" : "323px" });
			}

		}

		//$(window).resize(fn_boardResize);

		/* json형태의 Data를 이용하여 요청진행 상황 출력 */
		function printRsrcReq(datas) {

			var html = "";

			$("#tap-rsrcReq tbody").html("");

			if( datas != null ) {
				var data = null;
				for( var i = 0 ; i < datas.length; i++ ) {
					data = datas[i];

					var rsrcReqTyCd = data.rsrcReqTyCd;
					var rsrcReqNo = data.rsrcReqNo;

					html = '<tr>';
					html += '	<td class="list-style alignR">·</td>';

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

					html += '	<td class="alignL ellipsis"><a href="';

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

					html += '?schRsrcReqNo=' + rsrcReqNo + '" title="' + data.sbjct + '">' + data.sbjct + '</a></td>';
					html += '	<td class="text-gray alignR">' + data.rsrcReqDttm.substring(0,10) + '</td>';
					html += '</tr>';

					$("#tap-rsrcReq tbody").append(html);
				}
			} else {
				html = '<tr>';
				html += '	<td class="alignC" colspan="4">요청 진행 데이터가 없습니다.</td>';
				html += '</tr>';
				$("#tap-rsrcReq tbody").append(html);
			}
		}
		doExtraSelectRsrcReqList("", printRsrcReq);

		/* 최초 메인페이지 로딩시 이벤트 현황 호출 후 출력 */
		doExtraSelectEvntStteList(function(datas) {

			var html = "";

			$("#tap_evntStte tbody").html("");

			if( datas != null ) {
				var data = null;
				for( var i = 0 ; i < datas.length; i++ ) {
					data = datas[i];

					html = '<tr class="evntStte' + data.thresGrdId + '">';

					if( data.thresGrdId == "01") {
						html += '	<td><i class="label label-red label-dot"></i></td>';
					} else if( data.thresGrdId == "02") {
						html += '	<td><i class="label label-yellow label-dot"></i></td>';
					} else {
						html += '	<td><i class="label label-gray label-dot"></i></td>';
					}

					html += '	<td class="alignL ellipsis">' + data.trgtNm + '</td>';
					html += '	<td class="alignL ellipsis">' + data.nowVl + '(' + data.thresNm.replace("\r",",") + ')</td>';
					html += '	<td class="text-gray alignR">' + data.occrDttm.substring(0,16) + '</td>';
					html += '</tr>';

					$("#tap_evntStte tbody").append(html);
				}
			} else {
				html = '<tr>';
				html += '	<td class="alignC" colspan="4">이벤트 데이터가 없습니다.</td>';
				html += '</tr>';
				$("#tap_evntStte tbody").append(html);
			}
		});

		/* 이벤트 현황 중 해당 상태에 따른 정보만 추려 보여 주도록 처리 */
		function fn_selectEvntStte(thresGrdId) {
			$("#tap_evntStte  tbody  tr").show();
			if( thresGrdId != "" ) {
				$("#tap_evntStte  tbody  tr").not(".evntStte" + thresGrdId).hide();
			}
		}

		function goRsrcReq() {
			location.href= "<c:url value="/cpt/opr/req/rsrcreq/selectRsrcReqList.do" />";
		}

		function goEvntStte() {
			location.href= "<c:url value="/dsb/thrd/evnt/evntStte/selectEvntStteList.do" />";
		}

		function goNotice() {
			location.href= "<c:url value="/cpt/board/notice/selectBoardList.do" />";
		}
	</script>
</section>


<section class="content no-padding">
<!--
<section class="content pad-top-10">
-->
	<div class="row">
        <div class="col-box-100" >
          	<div class="nav-tabs-custom">
	            <ul class="nav nav-tabs-noback">
	                <li class="active"><a href="#tab-vm" onclick="fn_changTab('vm')" data-toggle="tab">가상서버목록</a></li>
	                <li class=""><a href="#tab-atmscl" onclick="fn_changTab('atmscl')" data-toggle="tab">자동확장 서비스목록</a></li>

	                <div class="box-tools">
	                  <div class="pull-right">
	                    <button class="btn btn-sm mg-right-5 mg-top-2" data-toggle="tooltip" data-original-title="더보기" onclick="goList()">
	                      <i class="fa fa-ellipsis-v"></i>
	                    </button>
	                    <input type="hidden" id="btnType" name="btnType" value="vm">
	                  </div>
	                </div>
	            </ul>
	            <div class="nopad-tab-content">
	              	<div class="tab-pane active" id="tab-vm">
		                <div class="box-body no-padding list-body">
		                    <table class="table table-hover table-layout-fixed" id="vmListTbl">
								<caption>가상서버 목록 테이블</caption>
								<thead>
									<tr>
										<th>No.</th>
										<th class="ellipsis">상태</th>
										<th class="ellipsis">부처명</th>
										<th class="ellipsis">업무명</th>
										<th>가상서버명</th>
										<th class="ellipsis">가상서버 구성ID</th>
										<th>CPU(vCore)</th>
										<th>CPU사용률(%)</th>
										<th class="ellipsis">메모리(GB)</th>
										<th class="ellipsis">메모리사용률(%)</th>
										<th>호스트명</th>
										<th class="ellipsis">IP주소</th>
										<th>기동일시</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${vmList }" var="vm" varStatus="index">
										<c:url var="detailUrl" value="/cpt/rsrc/com/vm/selectVm.do">
											<c:param name="vmSeq" value="${vm.vmSeq }" />
										</c:url>
										<tr>
											<td class="list-style alignC">${index.count }</td>
											<td class="alignL">
												<div class="server-info server
													<c:choose>
														<c:when test='${"02" eq vm.statGrpCd}'><c:out value="server-up"/></c:when>
														<c:when test='${"01" eq vm.statGrpCd}'><c:out value="server-down"/></c:when>
														<c:when test='${"04" eq vm.statGrpCd}'><c:out value="server-exception"/></c:when>
														<c:otherwise><c:out value="server-inprogress"/></c:otherwise>
													</c:choose>"
												>
													<div class="server-info-body alignL">
														<div class="server-info-box alignL">
															<span class="label"></span>
															<h4 class="stat"><c:out value="${vm.statGrpCdNm }" /></h4>
														</div>
													</div>
												</div>
											</td>
											<td class="alignL ellipsis"><c:out value="${vm.institutionNm }" /></td>
											<td class="alignL ellipsis"><c:out value="${vm.jobsNm }" /></td>
											<td class="alignL ellipsis"><a href="${detailUrl }" title="<c:out value="${vm.vmNm}"/>"><c:out value="${vm.vmNm }" /></a></td>
											<td>
												<c:if test='${vm.vmCompId ne null and vm.vmCompId ne "" }'>
												<a href="${detailUrl }" title="<c:out value="${vm.vmCompId}"/>"><c:out value="${vm.vmCompId }" /></a>
												</c:if>
											</td>
											<td class="alignR"><c:out value="${vm.cpuVcoreQty }" /></td>
											<td class="alignR"><c:out value="${vm.cpuUseRt }" /></td>
											<td class="alignR"><c:out value="${vm.memAsgnCapa }" /></td>
											<td class="alignR"><c:out value="${vm.memUseRt }" /></td>
											<td class="alignL"><c:out value="${vm.hstNm }" /></td>
											<td class="ellipsis alignL"><c:out value="${vm.rprsntIpAddr }" /></td>
											<td><fmt:formatDate value="${vm.strtupDttm }" pattern="yyyy-MM-dd HH:mm" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
		              	</div>
					</div>


					<div class="tab-pane active" id="tab-atmscl">
		                <div class="box-body no-padding list-body">
		                    <table class="table table-hover table-layout-fixed" id="servcListTbl">
								<caption>서비스 목록 테이블</caption>
								<thead>
			                    	<tr>
				                        <th>No.</th>
				                        <th>부처</th>
				                        <th>업무</th>
				                        <th>서비스명</th>
				                        <th>Pod수</th>
										<th>CPU(Core)</th>
										<th>CPU사용률(%)</th>
										<th>메모리할당량(GB)</th>
										<th>메모리사용률(%)</th>
										<th>네트워크In(KB/Sec)</th>
										<th>네트워크Out(KB/Sec)</th>
			                      	</tr>
			                    </thead>

								<tbody>
									<c:forEach var="vo" items="${servcList }" varStatus="i" >
										<tr>
											<c:url var="detailUrl" value="/cpt/rsrc/atmscl/servc/selectServc.do">
												<c:param name="servcSeq" value="${vo.servcSeq }" />
											</c:url>
											<td class="list-style alignC">${i.count }</td>
											<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
											<td class="alignL"><c:out value="${vo.jobNm}" /></td>
					                        <td class="alignL">
					                        	<a href="${detailUrl }" title="<c:out value="${vo.servcNm}"/>"><c:out value="${vo.servcNm}" /></a>
					                        </td>
					                        <td class="alignC"><c:out value="${vo.podQty}" /></td>
					                        <c:if test="${vo.servcTyCd eq '01' }">
												<td class="alignC"><c:out value="${vo.sumCpuCorQty}" /></td>
												<td class="alignC"><c:out value="${vo.avgCpuUseRt}" /></td>
												<td class="alignC"><c:out value="${vo.sumMemAsgnCapa}" /></td>
												<td class="alignC"><c:out value="${vo.avgMemUseRt}" /></td>
											</c:if>
											<c:if test="${vo.servcTyCd ne '01' }">
												<td class="alignC">-</td>
												<td class="alignC">-</td>
												<td class="alignC">-</td>
												<td class="alignC">-</td>
											</c:if>
											<td class="alignC"><c:out value="${vo.netwkIn}" /></td>
											<td class="alignC"><c:out value="${vo.netwkOut}" /></td>
					                       </tr>
									</c:forEach>
								</tbody>
		                  	</table>
		              	</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">

	//더보기
	function goList() {
		var btnType = btnType
		if($("#btnType").val() == 'vm') {
			location.href= "<c:url value="/cpt/rsrc/com/vm/selectVmList.do" />";
		}else if($("#btnType").val() == 'atmscl') {
			location.href= "<c:url value="/cpt/rsrc/atmscl/servc/selectServcList.do" />";
		}
	}

	//텝 클릭 시
	function fn_changTab(tabType) {
		if(tabType == 'atmscl') {
			$("#tab-atmscl").show();
			$("#tab-vm").hide();
			$("#btnType").val('atmscl');

		}else if(tabType == 'vm') {
			$("#tab-atmscl").hide();
			$("#tab-vm").show();
			$("#btnType").val('vm');
		}
	}


	$("#vmListTbl").DataTable( {
		dom: 'Zlfrtip',
		aoColumns : [
		              {sWidth : "35px" },
		              {sWidth : "80px" },
		              {sWidth : "100px" },
		              {sWidth : "130px" },
		              {sWidth : "195px" },
		              {sWidth : "90px" },
		              {sWidth : "75px" },
		              {sWidth : "85px" },
		              {sWidth : "70px" },
		              {sWidth : "95px" },
		              {sWidth : "90px" },
		              {sWidth : "95px" },
		              {sWidth : "110px" }
				],
		order : [[0, "asc"]]
	} );

	$("#servcListTbl").DataTable( {
		dom: 'Zlfrtip',
		aoColumns : [
		              {sWidth : "35px" },
		              {sWidth : "100px" },
		              {sWidth : "130px" },
		              {sWidth : "285px" },
		              {sWidth : "70px" },
		              {sWidth : "90px" },
		              {sWidth : "100px" },
		              {sWidth : "100px" },
		              {sWidth : "100px" },
		              {sWidth : "100px" },
		              {sWidth : "100px" }

				],
		order : [[0, "asc"]]
	} );

	</script>
	<!-- /row -->

</section>
<!-- /컨텐츠 -->

<c:set var="servcUrl" value="/cpt/rsrc/atmscl/servc/selectServcList.do" />
<c:set var="isAuth" value="true" />
<sec:authorize url="${servcUrl}" var="isAuth"></sec:authorize>
<c:if test="${!isAuth}">
<script type="text/javascript">
	$('#servcListTbl a[href]').each( function(row) { $(this).parent().html($(this).html()); } );
	function fn_changTab(tabType) {
		if(tabType == 'atmscl') {
			$("#tab-atmscl").show();
			$("#tab-vm").hide();
			//$("#btnType").val('atmscl');
			$('.box-tools .pull-right button').eq(3).attr('disabled', 'true')

		}else if(tabType == 'vm') {
			$("#tab-atmscl").hide();
			$("#tab-vm").show();
			$("#btnType").val('vm');
			$('.box-tools .pull-right button').eq(3).removeAttr('disabled');
		}
	}
</script>
</c:if>
