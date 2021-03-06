
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="user" />

<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/custom.js" />"></script>

<script>

function fn_search(vmPod){
	if(!fn_form_validation("searchVo")){
		return;
	}
	//$('#vmPod').val(vmPod);
	searchVo.action='<c:url value="index.do" />';

	searchVo.submit();
}

function goVmList() {
	location.href= "<c:url value="/cpt/rsrc/com/vm/selectVmList.do" />";
}

function goPodList(){
	location.href= "<c:url value="/cpt/rsrc/atmscl/servc/selectServcList.do" />";
}

function f_tabView(tabId) {
	$('#' + tabId).show();
	if (tabId == 'tab-vm') {
		$('#li-vm').addClass('active');
		$('#li-pod').removeClass('active');
		$('#tab-pod').hide();
		$('#tab-vm-list').show();
		$('#tab-pod-list').hide();
	}else if(tabId == 'tab-pod') {
		$('#li-pod').addClass('active');
		$('#li-vm').removeClass('active');
		$('#tab-vm').hide();
		$('#tab-vm-list').hide();
		$('#tab-pod-list').show();

	}

}

$(document).ready(function(){
	<c:choose>
		<c:when test = "${searchVo.vmPod eq 'vm'}">
			$('#tab-pod').hide();
			$('#tab-pod-list').hide();
			$('#li-vm').addClass('active');
			$('#li-pod').removeClass('active');
		</c:when>
		<c:when test = "${searchVo.vmPod eq 'pod'}">
			$('#tab-vm').hide();
			$('#tab-vm-list').hide();
			$('#li-vm').removeClass('active');
			$('#li-pod').addClass('active');
		</c:when>
		<c:otherwise>
			$('#tab-pod').hide();
			$('#tab-pod-list').hide();
			$('#li-vm').addClass('active');
			$('#li-pod').removeClass('active');
		</c:otherwise>
	</c:choose>
});
</script>


   <section class="board">

      <div class="server-info row" style="margin-bottom: 10px;">

        <div class="col-box-85 dashboard-box pad-right-5">
          <div class="box board-box">
			<c:if test = "${searchVo.view eq 'PM'}">
            <div class="board-box-cell col-cell-15">
              <div class="box-body">
              	<div class="info-box">
              		<div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-light-purple pull-left" >Core</h4>
						</div>
						<div class="col-cell-50 no-padding">
							<span class="info-icon pull-right">
								<img src="<c:url value="/resources/images/icon-dash-core.png" />" alt="">
							</span>
						</div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
						<span class="info-box-number pull-left pad-top-5">${mainCvo.pmResSttsVo.lastCpuCorQty }<b>개</b></span>
						<span class="col-cell-40 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">자동확장</span>
							<span class="autoexpand-number text-light-purple col-cell-100 no-padding alignR"><fmt:formatNumber value="${mainCvo.podResSttsVo.cpuCorQty }" pattern="#,###.#"/><b>개</b></span>
						</span>
					</div>
               	</div><!-- /info-box -->
              </div><!-- /box-body -->
            </div><!-- /cell -->
            <div class="board-box-cell col-cell-20">
              <div class="box-body">
                <div class="info-box">
                	<div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-aqua pull-left" >Memory</h4>
						</div>
						<div class="col-cell-50 no-padding">
							<span class="info-icon pull-right">
								<img src="<c:url value="/resources/images/icon-dash-memory.png" />" alt="">
							</span>
						</div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
						<c:if test="${mainCvo.pmResSttsVo.lastMemSumCapa < 102 }">
						<span class="info-box-number pull-left pad-top-5">${mainCvo.pmResSttsVo.lastMemSumCapa }<b>Gbyte</b></span>
						</c:if>
						<c:if test="${mainCvo.pmResSttsVo.lastMemSumCapa >= 102 }">
						<span class="info-box-number pull-left pad-top-5"><fmt:formatNumber value="${mainCvo.pmResSttsVo.lastMemSumCapa/1024 }" pattern="#,###.#"/><b>TByte</b></span>
						</c:if>
						<span class="col-cell-40 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">자동확장</span>
							<c:if test="${mainCvo.podResSttsVo.memAsgnCapa < 102 }">
							<span class="autoexpand-number text-aqua col-cell-100 no-padding alignR">${mainCvo.podResSttsVo.memAsgnCapa }<b>Gbyte</b></span>
							</c:if>
							<c:if test="${mainCvo.podResSttsVo.memAsgnCapa >= 102 }">
							<span class="autoexpand-number text-aqua col-cell-100 no-padding alignR"><fmt:formatNumber value="${mainCvo.podResSttsVo.memAsgnCapa/1024 }" pattern="#,###.#"/><b>Tbyte</b></span>
							</c:if>
						</span>
					</div>
                </div><!-- /info-box -->
              </div><!-- /box-body -->
            </div><!-- /cell -->
            <div class="board-box-cell col-cell-20">
              <div class="box-body">
                <div class="info-box">
					 <div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-green pull-left" >Storage</h4>
						</div>
						<div class="col-cell-50 no-padding">
							<span class="info-icon pull-right">
								<img src="<c:url value="/resources/images/icon-dash-storage.png" />" alt="">
							</span>
						</div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
					<c:if test="${mainCvo.pmResSttsVo.lastStrgSumCapa < 102 }">
						<span class="info-box-number pull-left pad-top-5"><fmt:formatNumber value="${mainCvo.pmResSttsVo.lastStrgSumCapa }" pattern="#,###.#"/><b>Gbyte</b></span>
					</c:if>
					<c:if test="${mainCvo.pmResSttsVo.lastStrgSumCapa >= 102 }">
						<span class="info-box-number pull-left pad-top-5"><fmt:formatNumber value="${mainCvo.pmResSttsVo.lastStrgSumCapa/1024 }" pattern="#,###.#"/><b>Tbyte</b></span>
					</c:if>
						<span class="col-cell-40 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">자동확장</span>
							<c:if test="${mainCvo.podResSttsVo.strgAsgnCapa < 102 }">
							<span class="autoexpand-number text-green col-cell-100 no-padding alignR"><fmt:formatNumber value="${mainCvo.podResSttsVo.strgAsgnCapa }" pattern="#,###.#"/><b>Gbyte</b></span>
							</c:if>
							<c:if test="${mainCvo.podResSttsVo.strgAsgnCapa >= 102 }">
							<span class="autoexpand-number text-green col-cell-100 no-padding alignR"><fmt:formatNumber value="${mainCvo.podResSttsVo.strgAsgnCapa/1024 }" pattern="#,###.#"/><b>Tbyte</b></span>
							</c:if>
						</span>
					</div>
                </div><!-- /info-box -->
              </div><!-- /box-body -->
            </div><!-- /cell -->
		</c:if>

            <div class="board-box-cell col-cell-15">
              <div class="box-body">
                <div class="info-box">
					<div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-blue pull-left" >이용기관</h4>
						</div>
						<div class="col-cell-50 no-padding">
							<span class="info-icon pull-right">
								<img src="<c:url value="/resources/images/icon-dash-stage.png" />" alt="">
							</span>
						</div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
						<span class="info-box-number pull-left pad-top-5">${mainCvo.dept }<b>개</b></span>
						<span class="col-cell-50 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">자동확장</span>
							<span class="autoexpand-number col-cell-100 text-blue col-cell-100 no-padding alignR">${mainCvo.podResSttsVo.institutionCnt }<b>개</b></span>
						</span>
					</div>
                </div><!-- /info-box -->
              </div><!-- /box-body -->
            </div><!-- /cell -->
            <div class="board-box-cell col-cell-15">
              <div class="box-body">
                <div class="info-box">
					<div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-yellow pull-left" >이용업무</h4>
						</div>
						<div class="col-cell-50 no-padding">
							<span class="info-icon pull-right"><img src="<c:url value="/resources/images/icon-dash-work.png" />" alt=""></span>
						</div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
						<span class="info-box-number pull-left pad-top-5">${mainCvo.job }<b>건</b></span>
						<span class="col-cell-50 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">자동확장</span>
							<span class="autoexpand-number col-cell-100 text-yellow col-cell-100 no-padding alignR">${mainCvo.podResSttsVo.jobCnt }<b>건</b></span>
						</span>
					</div>
                </div><!-- /info-box -->
              </div><!-- /box-body -->
            </div><!-- /cell -->
			<div class="board-box-cell col-cell-15">
				<div class="box-body">
					<div class="info-box">
						<div class="col-box-100 no-padding">
							<div class="col-cell-50 no-padding pad-top-5">
								<h4 class="info-box-main-text text-red pull-left" >Pod</h4>
							</div>
							<div class="col-cell-50 no-padding"><span class="info-icon pull-right"><img src="<c:url value="/resources/images/icon-dash-pod.png" />" alt=""></span></div>
                		</div>
                		<div class="col-box-100 no-padding pad-top-10">
							<span class="info-box-number pull-left pad-top-5">${mainCvo.podResSttsVo.podCnt }<b>건</b></span>
							<span class="col-cell-50 no-padding pull-right">
								<span class="autoexpand-text col-cell-100 no-padding alignR">&nbsp;</span>
								<span class="autoexpand-number text-red col-cell-100 no-padding alignR">&nbsp;<b>&nbsp;</b></span>
							</span>
						</div>
					</div><!-- /info-box -->
				</div><!-- /box-body -->
			</div><!-- /cell -->
          </div><!-- /box -->
        </div>
        <div class="col-box-15 dashboard-box no-padding-left">
          <div class="box board-box">
            <div class="box-body">
                <div class="info-box">
					<div class="col-box-100 no-padding">
						<div class="col-cell-50 no-padding pad-top-5">
							<h4 class="info-box-main-text text-orange pull-left" >vCore</h4>
						</div>
						<div class="col-cell-50 no-padding"><span class="info-icon pull-right"><img src="<c:url value="/resources/images/icon-dash-vcore.png" />" alt=""></span></div>
					</div>
					<div class="col-box-100 no-padding pad-top-10">
						<span class="info-box-number pull-left pad-top-5">${mainCvo.vcore }<b>개</b></span>
						<span class="col-cell-50 no-padding pull-right">
							<span class="autoexpand-text col-cell-100 no-padding alignR">&nbsp;</span>
							<span class="autoexpand-number text-orange col-cell-100 no-padding alignR">&nbsp;<b>&nbsp;</b></span>
						</span>
					</div>
                </div><!-- /info-box -->
            </div><!-- /box-body -->
          </div><!-- /box -->
        </div>

      </div>

    <div class="graph-info row">

        <div class="dashboard-box col-box-100">

          <div class="box board-box">
            <div class="board-box-cell col-cell-25">
              <div class="box-header">
                <h3 class="box-title">CPU 사용률</h3>
              </div><!-- /box-header -->
              <div class="box-body">
                <div class="chart" style="padding-bottom: 0px;">
                <div>(%)</div>
                  <canvas id="cpuChart" style="height: 150px; width: 212px;" height="187" width="265"></canvas>
                  <div class="chartLegend"></div>
                </div>
              </div><!-- /box-body -->
            </div><!-- /cell -->
            <div class="board-box-cell col-cell-25">
              <div class="box-header">
                <h3 class="box-title">메모리 사용률</h3>
              </div><!-- /box-header -->
              <div class="box-body">
                <div class="chart" style="padding-bottom: 0px;">
                	<div>(%)</div>
                  <canvas id="memoryChart" style="height: 150px; width: 212px;" height="187" width="265"></canvas>
                  <div class="chartLegend"></div>
                </div>
              </div><!-- /box-body -->
            </div><!-- /cell -->
            <div class="board-box-cell col-cell-25">
              <div class="box-header">
                <h3 class="box-title">네트워크 IN/OUT 트래픽</h3>
              </div><!-- /box-header -->
              <div class="box-body">
                <div class="chart" style="padding-bottom: 0px;">
                <div>(MB/s)</div>
                  <canvas id="netTrficChart" style="height: 150px; width: 212px;" height="187" width="265"></canvas>
                  <div class="chartLegend"></div>
                </div>
              </div><!-- /box-body -->
            </div><!-- /cell -->

          <div class="board-box-cell col-cell-25">
            <div class="box-header">
              <h3 class="box-title">매니저 종류별 <c:choose><c:when test = "${searchVo.view eq 'PM'}">물리, 노드</c:when><c:otherwise>가상, POD</c:otherwise></c:choose> 통계</h3>
            </div><!-- /box-header -->
            <div class="box-body">
              <div class="chart" style="padding-bottom: 0px;">
                <canvas id="managerChart" style="height: 133px; width: 205px;" height="166" width="256"></canvas>
                <div class="chartLegend"></div>
              </div>
            </div><!-- /box-body -->
          </div><!-- /box -->
        </div>

      </div>
	</div>


    </section>

	<section class="content">

      <!-- 수평 요소를 감싸주는 row 요소 -->
      <div class="row">

        <!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
		<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
		<form:hidden path="vmPod" />
        <div class="col-box-100 no-padding">

	          <!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	          <!-- box(목록조회 테이블) -->
	          <div class="box no-box-top list-box">
	            <div class="box-header pad-top-5">
					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs-noback pull-left">
							<li id="li-vm"><a href="javascript:f_tabView('tab-vm')">가상서버목록</a></li>
	              			<li id="li-pod"><a href="javascript:f_tabView('tab-pod')">Pod 목록</a></li>

	            		</ul>

	              		<div class="box-tools search-filter pull-right pad-right-10" id="tab-vm">
	                		<div class="pull-right pad-left-5">
	                  			<button type="button" class="btn btn-sm" data-toggle="tooltip" data-original-title="더보기" onclick="goVmList()"><i class="fa fa-ellipsis-v"></i></button>
	                		</div>

		                	<button class="btn btn-sm btn-red btn-function dropdown-toggle" data-toggle="dropdown"><i class="fa fa-filter"></i> 검색조건설정</button>

			                  <div class="dropdown-menu">
			                    <div class="header">검색조건</div>
			                    <div class="body">

			                      <div class="form-group">
									  <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="Hypervisor 종류" for="vrlzSwTyCd">Hypervisor 종류</label>
			                          </div>
			                          <div class="cell-body">
			                          <div class="input-group">
										<nform:selectCode
										parentCd="100"
										parentGrpCd="001"
										name="vrlzSwTyCd"
										id="vrlzSwTyCd"
										whole="true"
										extra1=""
										extra2=""
										extra3=""
										extra4=""
										extra5=""
										cssClass="notClose form-control input-sm"
			                            title="Hypervisor 종류"
			                            />

										</div>

			                          </div>
			                        </div>

			                         <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                             <label title="가상서버 구성ID" for="vmCompId">가상서버 구성ID</label>
			                          </div>
			                          <div class="cell-body">
			                            <form:input path="vmCompId" title="가상서버 구성ID" cssClass="form-control input-sm" value=""/>
			                          </div>
			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                           <label title="생성일자" for="strtDt">생성일자</label>
			                          </div>
			                          <div class="cell-body">
								        <div class="input-group-box">
								          <div class="input-group-cell" id="divDate">
												<div class="input-group  period-start">
													<form:input path="strtDt" cssClass="form-control  datepicker onlyDate" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')"/>

												</div>
												<div class="input-group  period-end">
													<form:input path="endDt" cssClass="form-control  datepicker onlyDate"  title="종료일자" onchange="initDate(this, 'strtDt', 'E')"/>

												</div>
											</div>
								        </div>
							        </div>

			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="물리서버 구성ID" for="pmCompId">물리서버 구성ID</label>
			                          </div>
			                           <div class="cell-body">
			                            <form:input path="pmCompId" title="물리서버 구성ID" cssClass="form-control input-sm" value=""/>
			                          </div>
			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="가상서버명" for="vmNm">가상서버명</label>
			                          </div>
			                          <div class="cell-body">
										<form:input path="vmNm" title="가상서버명" cssClass="form-control input-sm" value=""/>
									</div>
			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="부처명" for="institutionNm">부처명</label>
			                          </div>
			                          <div class="cell-body">
											<form:input path="institutionNm" title="부처" cssClass="form-control input-sm" value=""/>
										</div>
			                        </div>
									<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="업무명" for="jobNm">업무명</label>
			                          </div>
			                          <div class="cell-body">
										<form:input path="jobNm" title="업무명" cssClass="form-control input-sm" value=""/>
									</div>
			                        </div>
			                      </div>


			                    </div><!-- /body -->
			                    <div class="footer">
			                      <div class="pull-left">
			                        <button type="reset" class="btn btn-function" >초기화</button>
			                      </div>
			                      <div class="pull-right">
			                        <button type="submit" class="btn btn-red btn-function" onclick="fn_search('vm'); return false;">조회</button>
			                      </div>
			                    </div><!-- /footer -->
			                  </div>
							</div>

							<!-- pod -->
							<div class="box-tools search-filter pull-right pad-right-10" id="tab-pod">
	                		<div class="pull-right pad-left-5">
	                  			<button type="button" class="btn btn-sm" data-toggle="tooltip" data-original-title="더보기" onclick="goPodList()"><i class="fa fa-ellipsis-v"></i></button>
	                		</div>

		                	<button class="btn btn-sm btn-red btn-function dropdown-toggle" data-toggle="dropdown"><i class="fa fa-filter"></i> 검색조건설정</button>

			                  <div class="dropdown-menu">
			                    <div class="header">검색조건</div>
			                    <div class="body">

			                      <div class="form-group">
									  <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                         <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                             <label title="자동확장 PODID" for="PODID">PODID</label>
			                          </div>
			                          <div class="cell-body">
			                            <form:input path="podId" title="자동확장 PODID" cssClass="form-control input-sm" value=""/>
			                          </div>
			                        </div>
									<div class="form-cell">
			                          <div class="cell-title">
			                             <label title="자동확장 POD명" for="PODNM">POD명</label>
			                          </div>
			                          <div class="cell-body">
			                            <form:input path="podNm" title="자동확장 POD명" cssClass="form-control input-sm" value=""/>
			                          </div>
			                        </div>
			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                           <label title="생성일자" for="strtDt">생성일자</label>
			                          </div>
			                          <div class="cell-body">
								        <div class="input-group-box">
								          <div class="input-group-cell" id="divDate">
												<div class="input-group  period-start">
													<form:input path="strtDtPod" cssClass="form-control  datepicker onlyDate" maxlength="" title="시작일자" onchange="initDate(this, 'endDtPod', 'S')"/>

												</div>
												<div class="input-group  period-end">
													<form:input path="endDtPod" cssClass="form-control  datepicker onlyDate"  title="종료일자" onchange="initDate(this, 'strtDtPod', 'E')"/>

												</div>
											</div>
								        </div>
							        </div>

			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="부처명" for="institutionNmPod">부처명</label>
			                          </div>
			                           <div class="cell-body">
			                            <form:input path="institutionNmPod" title="부처명" cssClass="form-control input-sm" value=""/>
			                          </div>
			                        </div>

			                        <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
			                        <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
			                        <div class="form-cell">
			                          <div class="cell-title">
			                            <label title="서비스명" for="servcNm">서비스명</label>
			                          </div>
			                          <div class="cell-body">
										<form:input path="servcNm" title="서비스명" cssClass="form-control input-sm" value=""/>
									</div>
			                        </div>
			                      </div>


			                    </div><!-- /body -->
			                    <div class="footer">
			                      <div class="pull-left">
			                        <button type="reset" class="btn btn-function" >초기화</button>
			                      </div>
			                      <div class="pull-right">
			                        <button type="submit" class="btn btn-red btn-function" onclick="fn_search('pod'); return false;">조회</button>
			                      </div>
			                    </div><!-- /footer -->

			                  </div>

							</div>
						</div>

					</form:form>

		             </div>
		           <!-- /box-header -->
		            <div class="box-body no-padding list-body tab-pane active" id="tab-vm-list">
		                <table class="table table-hover table-layout-fixed" id="vmTable">
		                 <caption>가상서버 목록</caption><%--
		                  <colgroup>
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col8">
		                    <col class="colAuto">
		                    <col class="col7">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col5">
		                    <col class="col8">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col7">
		                    <col class="col8">
		                  </colgroup> --%>
		                  <thead>
		                    <tr>
		                      <th>No.</th>
		                      <th class="ellipsis">상태</th>
		                      <th class="ellipsis">수집</th>
		                      <th class="ellipsis">부처명</th>
		                      <th class="ellipsis">업무명</th><%--
		                      <th>존</th> --%>
		                      <th>가상서버명</th>
		                      <th class="ellipsis">가상서버구성ID</th>
		                      <th>vCore</th>
		                      <th class="ellipsis">메모리(GB)</th>
		                      <th class="ellipsis">스토리지(GB)</th>
		                      <th>생성일자</th>
		                      <th>호스트명</th>
		                      <th class="ellipsis">IP주소</th>
		                    </tr>
		                  </thead><%--
		                </table>
		                <table class="table table-hover table-layout-fixed">
		                  <colgroup>
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col8">
		                    <col class="colAuto">
		                    <col class="col7">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col5">
		                    <col class="col8">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col7">
		                    <col class="col8">
		                  </colgroup> --%>
		                  <tbody>
		                  <c:choose>
			                <c:when test="${ mainCvo.vmInfoList eq null or empty mainCvo.vmInfoList }">
							<%--<tr><td colspan="14">검색된 데이터가 없습니다.</td></tr> --%>
							</c:when>
							<c:otherwise>
								<c:forEach var="vo" items="${mainCvo.vmInfoList}" varStatus="ri">
		                        <tr data-toggle="modal" data-target="#myModal${ri.index+1}">
				                    <td class="">${ri.count}</td>
				                    <td class=""><%-- <c:out value="${vo.stat }" /> --%>
										<div class="server-info server
											<c:choose>
												<c:when test='${"02" eq vo.statCd}'><c:out value="server-up"/></c:when>
												<c:when test='${"01" eq vo.statCd}'><c:out value="server-down"/></c:when>
												<c:when test='${"04" eq vo.statCd}'><c:out value="server-exception"/></c:when>
												<c:otherwise><c:out value="server-inprogress"/></c:otherwise>
											</c:choose>">
											<div class="server-info-body alignL">
												<div class="server-info-box alignL">
													<span class="label"></span>
													<h4 class="stat"><c:out value="${vo.stat}" /></h4>
												</div>
											</div>
										</div>
				                    </td>
				                    <td class=""><c:out value="${vo.suzip }" /></td>
				                    <td class="ellipsis alignL"><c:out value="${vo.institutionNm }" /></td>
				                    <td class="ellipsis alignL"><c:out value="${vo.jobsNm }" /></td><%--
				                    <td class=""><c:out value="${vo.zoneNm }" /></td> --%>
				                    <td class="alignL"><c:out value="${vo.vmNm }" /></td>
				                    <td class=""><c:out value="${vo.vmCompId }" /></td>
				                    <td class="alignR"><c:out value="${vo.vcore }" /></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.mem}" pattern="#,###" /></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.strg}" pattern="#,###" /></td>
				                    <td class="alignC"><c:out value="${vo.reg }" /></td>
				                    <td class="alignL"><c:out value="${vo.hstNm }" /></td>
				                    <td class="ellipsis alignL"><c:out value="${vo.ip }" /></td>
		                         </tr>
		                         </c:forEach>
					    	</c:otherwise>
						</c:choose>

		                </tbody>
		              </table>
		            </div>
					<!-- POD -->



					<div class="box-body no-padding list-body" id="tab-pod-list">
		                <table class="table table-hover table-layout-fixed" id="podTable">
		                 <caption>자동확장 목록</caption><%--
		                  <colgroup>
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col8">
		                    <col class="colAuto">
		                    <col class="col7">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col5">
		                    <col class="col8">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col7">
		                    <col class="col8">
		                  </colgroup> --%>
		                  <thead>
		                    <tr>
		                      <th>No.</th>
		                      <th class="ellipsis">부처명</th>
		                      <th class="ellipsis">업무명</th>
		                      <th>서비스명</th>
		                      <th>Pod상태</th>
		                      <th>PodId</th>
		                      <th>CPU(Core)수</th>
		                      <th>CPU사용률(%)</th>
		                      <th>메모리(GB)</th>
		                      <th>메모리사용률(%)</th>
		                    </tr>
		                  </thead><%--
		                </table>
		                <table class="table table-hover table-layout-fixed">
		                  <colgroup>
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col4">
		                    <col class="col8">
		                    <col class="colAuto">
		                    <col class="col7">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col5">
		                    <col class="col8">
		                    <col class="col8">
		                    <col class="col9">
		                    <col class="col7">
		                    <col class="col8">
		                  </colgroup> --%>
		                  <tbody>
		                  <c:choose>
			                <c:when test="${ mainCvo.podInfoList eq null or empty mainCvo.podInfoList }">
							<%--<tr><td colspan="14">검색된 데이터가 없습니다.</td></tr> --%>
							</c:when>
							<c:otherwise>
								<c:forEach var="vo" items="${mainCvo.podInfoList}" varStatus="ri">
		                        <tr data-toggle="modal" data-target="#myPodModal${ri.index+1}">
				                    <td class="">${ri.count}</td>
				                    <td class="ellipsis alignL"><c:out value="${vo.institutionNm }" /></td>
				                    <td class="ellipsis alignL"><c:out value="${vo.jobNm }" /></td>
				                    <td class="alignL"><c:out value="${vo.servcNm }" /></td>
				                    <td class=""><c:out value="${vo.statNm }" /></td>
				                    <td class="alignL"><c:out value="${vo.podId }" /></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.cpuCorQty}" pattern="#,###.##" /></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.cpuUseRt}" pattern="#,###.##" /></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.memAsgnCapa }" pattern="#,###.##"/></td>
				                    <td class="alignR"><fmt:formatNumber value="${vo.memUseRt }" pattern="#,###.##"/></td>
		                         </tr>
		                         </c:forEach>
					    	</c:otherwise>
						</c:choose>

		                </tbody>
		              </table>
		            </div>
					<!-- POD -->
				</div> <!-- list box -->

            </div><!-- /box-footer -->
          </div><!-- /box(목록조회 테이블) -->



	</section><!-- /컨텐츠 -->

<c:if test="${ mainCvo.vmInfoList ne null or !empty mainCvo.vmInfoList }">
<c:forEach var="vo" items="${mainCvo.vmInfoList}" varStatus="ri">
  <!-- 기본 모달 VM-->
    <div class="modal fade" id="myModal${ri.index+1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-default" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
              <div class="title pull-left">
                <h4 class="modal-title" id="myModalLabel-default">가상서버 상세보기</h4>
              </div>
              <div class="tools pull-right">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">닫기</span></button>
              </div>
          </div>
          <div class="modal-body">
              <div class="box">
                <div class="box-body no-padding">
                    <table class="table table-horizon">
                     <caption>가상서버 상세보기</caption>
                      <colgroup>
                        <col class="col25">
                        <col class="col25">
                        <col class="col25">
                        <col class="col25">
                      </colgroup>
                      <tbody>
                        <tr>
                          <th>상태</th>
                          <td><c:out value="${vo.stat }" /></td>
                          <th>데이터수집</th>
                          <td><c:out value="${vo.suzip }" /></td>
                        </tr>
                        <tr>
                          <th>부처명</th>
                          <td><c:out value="${vo.institutionNm }" /></td>
                          <th>존</th>
                          <td><c:out value="${vo.zoneNm }" /></td>
                        </tr>
                        <tr>
                          <th>업무명</th>
                          <td colspan="3"><c:out value="${vo.jobsNm }" /></td>
                        </tr>
                        <tr>
                          <th>가상서버명</th>
                          <td><c:out value="${vo.vmNm }" /></td>
                          <th>가상서버 구성 ID</th>
                          <td><c:out value="${vo.vmCompId }" /></td>
                        </tr>
                        <tr>
                          <th>스토리지</th>
                          <td><fmt:formatNumber value="${vo.strg}" pattern="#,###" />GB</td>
                          <th>vCore</th>
                          <td><c:out value="${vo.vcore }" /></td>
                        </tr>
                        <tr>
                          <th>메모리</th>
                          <td><fmt:formatNumber value="${vo.mem}" pattern="#,###" />GB</td>
                          <th>생성일자</th>
                          <td><c:out value="${vo.reg }" /></td>
                        </tr>
                        <tr>
                          <th>호스트명</th>
                          <td><c:out value="${vo.hstNm }" /></td>
                          <th>IP주소</th>
                          <td><c:out value="${vo.ip }" /></td>
                        </tr>
                    </tbody>
                  </table>
                </div><!-- /box-body -->
              </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /기본 모달 -->
</c:forEach>
</c:if>

<c:if test="${ mainCvo.podInfoList ne null or !empty mainCvo.podInfoList }">
<c:forEach var="vo" items="${mainCvo.podInfoList}" varStatus="ri">
  <!-- 기본 모달 POD -->
    <div class="modal fade" id="myPodModal${ri.index+1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-default" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
              <div class="title pull-left">
                <h4 class="modal-title" id="myModalLabel-default">POD 상세보기</h4>
              </div>
              <div class="tools pull-right">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">닫기</span></button>
              </div>
          </div>
          <div class="modal-body">
              <div class="box">
                <div class="box-body no-padding">
                    <table class="table table-horizon">
                     <caption>POD 상세보기</caption>
                      <colgroup>
                        <col class="col25">
                        <col class="col25">
                        <col class="col25">
                        <col class="col25">
                      </colgroup>
                      <tbody>
                        <tr>
                          <th>상태</th>
                          <td><c:out value="${vo.statNm }" /></td>
                          <th>서비스명</th>
                          <td><c:out value="${vo.servcNm }" /></td>
                        </tr>
                        <tr>
                          <th>부처명</th>
                          <td><c:out value="${vo.institutionNm }" /></td>
                          <th>존</th>
                          <td><c:out value="${vo.zoneNm }" /></td>
                        </tr>
                        <tr>
                          <th>업무명</th>
                          <td colspan="3"><c:out value="${vo.jobNm }" /></td>
                        </tr>
                        <tr>
                          <th>POD명</th>
                          <td><c:out value="${vo.podNm }" /></td>
                          <th>PODID</th>
                          <td><c:out value="${vo.podId }" /></td>
                        </tr>
                        <tr>
                          <th>스토리지</th>
                          <td><fmt:formatNumber value="${vo.strgAsgnCapa}" pattern="#,###.##" />GB</td>
                          <th>CPU(Core)</th>
                          <td><fmt:formatNumber value="${vo.cpuCorQty }" pattern="#,###.##"/></td>
                        </tr>
                        <tr>
                          <th>메모리</th>
                          <td><fmt:formatNumber value="${vo.memAsgnCapa}" pattern="#,###.##" />GB</td>
                          <th>생성일자</th>
                          <td><c:out value="${vo.reg }" /></td>
                        </tr>
                        <tr>
                          <th>노드명</th>
                          <td><c:out value="${vo.atmsclNodeNm }" /></td>
                          <th>PODIP주소</th>
                          <td><c:out value="${vo.podIpAddr }" /></td>
                        </tr>
                    </tbody>
                  </table>
                </div><!-- /box-body -->
              </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /기본 모달 -->
</c:forEach>
</c:if>
<script type="text/javascript">
var cpuChart;
var memoryChart;
var netTrficChart;
var managerChart;

function ChartJS() {

  /* ChartJS
   * -------
   * Here we will create a few charts using ChartJS
   */

  //--------------
  //- AREA CHART -
  //--------------

	var cpuValArr =[];
	var memValArr =[];
	var netValArr =[];
	var maxCpuUseRt=0,maxMemUseRt=0, maxNetUseRt=0;
	<c:forEach var="cpuItem" items="${mainCvo.vmCpuList }">
		<c:choose>
			<c:when test="${not empty cpuItem.rt}" >
				<fmt:formatNumber var="useRt" type="number" value="${cpuItem.rt}"/>
			</c:when>
			<c:otherwise>
				<fmt:formatNumber var="useRt" type="number" value="0"/>
			</c:otherwise>
		</c:choose>
		cpuValArr.push(<c:out value='${useRt}'/>);
	</c:forEach>
	<c:forEach var="memItem" items="${mainCvo.vmMemList }">
		<c:choose>
			<c:when test="${not empty memItem.rt}" >
				<fmt:formatNumber var="useRt" type="number" value="${memItem.rt}"/>
			</c:when>
			<c:otherwise>
				<fmt:formatNumber var="useRt" type="number" value="0"/>
			</c:otherwise>
		</c:choose>
		memValArr.push(<c:out value='${useRt}'/>);
	</c:forEach>
	<c:forEach var="netItem" items="${mainCvo.vmNetTrficList }">
		<c:choose>
			<c:when test="${not empty netItem.avgInTrfic and not empty netItem.avgOutTrfic}" >
				<fmt:formatNumber var="inTrfic" type="number" value="${netItem.avgInTrfic}"/>
				<fmt:formatNumber var="outTrfic" type="number" value="${netItem.avgOutTrfic}"/>
				<c:choose>
					<c:when test="${inTrfic >= outTrfic}">
						<c:set var="useRt" value="${inTrfic}"/>
					</c:when>
					<c:otherwise>
						<c:set var="useRt" value="${outTrfic}"/>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<fmt:formatNumber var="useRt" type="number" value="0"/>
			</c:otherwise>
		</c:choose>
		netValArr.push(<c:out value='${useRt}'/>);
	</c:forEach>
	maxCpuUseRt = Math.max.apply(null,cpuValArr);
	maxMemUseRt = Math.max.apply(null,memValArr);
	maxNetUseRt = Math.max.apply(null,netValArr);

  // Get context with jQuery - using jQuery's .get() method.
  var cpuChartCanvas = $("#cpuChart").get(0).getContext("2d");
  // This will get the first returned node in the jQuery collection.
  cpuChart = new Chart(cpuChartCanvas);

  var cpuChartData = {
    labels: [<c:choose>
               <c:when test="${mainCvo.vmCpuList ne null and !empty mainCvo.vmCpuList}" >
               	<c:forEach var="vo" items="${mainCvo.vmCpuList}" varStatus="ri">
                	  "<c:out value="${vo.mi }" />"
                  	  <c:if test="${fn:length(mainCvo.vmCpuList) > (ri.index + 1) }"><c:out value=","/></c:if>
               	</c:forEach>
              </c:when>
              <c:otherwise>
                ""
              </c:otherwise>
            </c:choose>
            ],
    datasets: [

      {
        label: "CPU 사용률",
        fillColor: "rgba(34, 136, 225, 0.5)",
        strokeColor: "#288be2",
        pointColor: "#288be2",
        pointStrokeColor: "rgba(0,0,0,0)",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#288be2",

        data: [<c:choose>
                 <c:when test="${mainCvo.vmCpuList ne null and !empty mainCvo.vmCpuList}" >
               		<c:forEach var="vo" items="${mainCvo.vmCpuList}" varStatus="ri">
		        		"<c:out value="${vo.rt }" />"
		        		 <c:if test="${fn:length(mainCvo.vmCpuList) > (ri.index + 1) }"><c:out value=","/></c:if>
		    		</c:forEach>
		    		</c:when>
		             <c:otherwise>
		                ""
		             </c:otherwise>
		        </c:choose>
		       ]
      }
    ]
  };

	// Get context with jQuery - using jQuery's .get() method.
  var memoryChartCanvas = $("#memoryChart").get(0).getContext("2d");
  // This will get the first returned node in the jQuery collection.
  memoryChart = new Chart(memoryChartCanvas);

  var memoryChartData = {
    labels: [<c:choose>
    		   <c:when test="${mainCvo.vmMemList ne null and !empty mainCvo.vmMemList}" >
	             	<c:forEach var="vo" items="${mainCvo.vmMemList}" varStatus="ri">
				    	"<c:out value="${vo.mi }" />"
				    	 <c:if test="${fn:length(mainCvo.vmMemList) > (ri.index + 1) }"><c:out value=","/></c:if>
					</c:forEach>
			    </c:when>
			    <c:otherwise>
                ""
                 </c:otherwise>
              </c:choose>
			 ],
    datasets: [

      {
        label: "메모리 사용률",
        fillColor: "rgba(165, 29, 48, 0.5)",
        strokeColor: "#d8580c",
        pointColor: "#d8580c",
        pointStrokeColor: "rgba(0,0,0,0)",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#d8580c",
        data: [<c:choose>
		   		<c:when test="${mainCvo.vmMemList ne null and !empty mainCvo.vmMemList}" >
	               <c:forEach var="vo" items="${mainCvo.vmMemList}" varStatus="ri">
			        "<c:out value="${vo.rt }" />"
			        <c:if test="${fn:length(mainCvo.vmMemList) > (ri.index + 1) }"><c:out value=","/></c:if>
			   	  </c:forEach>
			   	</c:when>
			    <c:otherwise>
                ""
                 </c:otherwise>
              </c:choose>
			  ]
      }
    ]
  };

	// Get context with jQuery - using jQuery's .get() method.
  var netTrficChartCanvas = $("#netTrficChart").get(0).getContext("2d");
  // This will get the first returned node in the jQuery collection.
  netTrficChart = new Chart(netTrficChartCanvas);

  var netTrficChartData = {
    labels: [<c:choose>
				<c:when test="${mainCvo.vmNetTrficList ne null and !empty mainCvo.vmNetTrficList}" >
		             <c:forEach var="vo" items="${mainCvo.vmNetTrficList}" varStatus="ri">
					    "<c:out value="${vo.mi }" />"
					    <c:if test="${fn:length(mainCvo.vmNetTrficList) > (ri.index + 1) }"><c:out value=","/></c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
	                ""
	            </c:otherwise>
	         </c:choose>
			],
    datasets: [

      {
        label: "IN",
        fillColor: "rgba(0, 0, 0, 0)",
        strokeColor: "#ffa811",
        lineColor: "#ffa811",
        pointColor: "#ffa811",
        pointStrokeColor: "rgba(0,0,0,0)",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#ffa811",

        data: [<c:choose>
			 	 <c:when test="${mainCvo.vmNetTrficList ne null and !empty mainCvo.vmNetTrficList}" >
	               <c:forEach var="vo" items="${mainCvo.vmNetTrficList}" varStatus="ri">
				        "<c:out value="${vo.avgInTrfic }" />"
				        <c:if test="${fn:length(mainCvo.vmNetTrficList) > (ri.index + 1) }"><c:out value=","/></c:if>
				    </c:forEach>
				 </c:when>
				<c:otherwise>
		                ""
		        </c:otherwise>
		      </c:choose>
		      ]
      }
      ,
      {
          label: "OUT",
          fillColor: "rgba(0, 0, 0, 0)",
          strokeColor: "#9D66BB",
          lineColor: "#9D66BB",
          pointColor: "#9D66BB",
          pointStrokeColor: "rgba(0,0,0,0)",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "#9D66BB",

          data: [<c:choose>
  			 	 <c:when test="${mainCvo.vmNetTrficList ne null and !empty mainCvo.vmNetTrficList}" >
  	               <c:forEach var="vo" items="${mainCvo.vmNetTrficList}" varStatus="ri">
  				        "<c:out value="${vo.avgOutTrfic }" />"
  				        <c:if test="${fn:length(mainCvo.vmNetTrficList) > (ri.index + 1) }"><c:out value=","/></c:if>
  				    </c:forEach>
  				 </c:when>
  				<c:otherwise>
  		                ""
  		        </c:otherwise>
  		      </c:choose>
  		      ]
        }
    ]
  };

  var CpuAreaChartOptions = {
    //Boolean - If we should show the scale at all
    scaleOverride : true,
    scaleSteps: 5,
    scaleStepWidth : 20,
    showScale: true,
    //Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines: true,
    //String - Colour of the grid lines
    scaleGridLineColor: "rgba(0,0,0,.05)",
    //Number - Width of the grid lines
    scaleGridLineWidth: 1,
    //Boolean - Whether to show horizontal lines (except X axis)
    scaleShowHorizontalLines: true,
    //Boolean - Whether to show vertical lines (except Y axis)
    scaleShowVerticalLines: true,
    //Boolean - Whether the line is curved between points
    bezierCurve: true,
    //Number - Tension of the bezier curve between points
    bezierCurveTension: 0.3,
    //Boolean - Whether to show a dot for each point
    pointDot: false,
	//Number - Radius of each point dot in pixels
    <c:choose>
      <c:when test="${mainCvo.vmCpuList eq null or empty mainCvo.vmCpuList}">
	     pointDotRadius: 0,
	    //Number - Pixel width of point dot stroke
	     pointDotStrokeWidth: 0,
	    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
	    pointHitDetectionRadius: 0,
    	//Boolean - Whether to show a stroke for datasets
      </c:when>
      <c:otherwise>
	     pointDotRadius: 4,
	    //Number - Pixel width of point dot stroke
	     pointDotStrokeWidth: 2,
	    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
	    pointHitDetectionRadius: 20,
    	//Boolean - Whether to show a stroke for datasets
      </c:otherwise>
    </c:choose>

    //datasetStroke: true,
    //Number - Pixel width of dataset stroke
    //datasetStrokeWidth: 2,
    //Boolean - Whether to fill the dataset with a color
    //datasetFill: true,
    //String - A legend template
       //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
    maintainAspectRatio: true,
    //Boolean - whether to make the chart responsive to window resizing
    responsive: true,
	  // String - Template string for multiple tooltips

  };

  var MemAreaChartOptions = {
		    scaleOverride : true,
		    scaleSteps: 5,
		    scaleStepWidth : 20,

		    //Boolean - If we should show the scale at all
		    showScale: true,
		    //Boolean - Whether grid lines are shown across the chart
		    scaleShowGridLines: true,
		    //String - Colour of the grid lines
		    scaleGridLineColor: "rgba(0,0,0,.05)",
		    //Number - Width of the grid lines
		    scaleGridLineWidth: 1,
		    //Boolean - Whether to show horizontal lines (except X axis)
		    scaleShowHorizontalLines: true,
		    //Boolean - Whether to show vertical lines (except Y axis)
		    scaleShowVerticalLines: true,
		    //Boolean - Whether the line is curved between points
		    bezierCurve: true,
		    //Number - Tension of the bezier curve between points
		    bezierCurveTension: 0.3,
		    //Boolean - Whether to show a dot for each point
		    pointDot: false,
			//Number - Radius of each point dot in pixels
		    <c:choose>
		      <c:when test="${mainCvo.vmMemList eq null or empty mainCvo.vmMemList}">
			     pointDotRadius: 0,
			    //Number - Pixel width of point dot stroke
			     pointDotStrokeWidth: 0,
			    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
			    pointHitDetectionRadius: 0,
		    	//Boolean - Whether to show a stroke for datasets
		      </c:when>
		      <c:otherwise>
			     pointDotRadius: 4,
			    //Number - Pixel width of point dot stroke
			     pointDotStrokeWidth: 2,
			    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
			    pointHitDetectionRadius: 20,
		    	//Boolean - Whether to show a stroke for datasets
		      </c:otherwise>
		    </c:choose>

		    //datasetStroke: true,
		    //Number - Pixel width of dataset stroke
		    //datasetStrokeWidth: 2,
		    //Boolean - Whether to fill the dataset with a color
		    //datasetFill: true,
		    //String - A legend template
		       //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		    maintainAspectRatio: true,
		    //Boolean - whether to make the chart responsive to window resizing
		    responsive: true,
			  // String - Template string for multiple tooltips

		  };

  var NetTrficAreaChartOptions = {
		    scaleOverride : true,
		    scaleSteps: 5,
		    scaleStepWidth : 20,
		    //Boolean - If we should show the scale at all
		    showScale: true,
		    //Boolean - Whether grid lines are shown across the chart
		    scaleShowGridLines: true,
		    //String - Colour of the grid lines
		    scaleGridLineColor: "rgba(0,0,0,.05)",
		    //Number - Width of the grid lines
		    scaleGridLineWidth: 1,
		    //Boolean - Whether to show horizontal lines (except X axis)
		    scaleShowHorizontalLines: true,
		    //Boolean - Whether to show vertical lines (except Y axis)
		    scaleShowVerticalLines: true,
		    //Boolean - Whether the line is curved between points
		    bezierCurve: true,
		    //Number - Tension of the bezier curve between points
		    bezierCurveTension: 0.3,
		    //Boolean - Whether to show a dot for each point
		    pointDot: false,
			//Number - Radius of each point dot in pixels
		    <c:choose>
		      <c:when test="${mainCvo.vmNetTrficList eq null or empty mainCvo.vmNetTrficList}">
			     pointDotRadius: 0,
			    //Number - Pixel width of point dot stroke
			     pointDotStrokeWidth: 0,
			    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
			    pointHitDetectionRadius: 0,
		    	//Boolean - Whether to show a stroke for datasets
		      </c:when>
		      <c:otherwise>
			     pointDotRadius: 4,
			    //Number - Pixel width of point dot stroke
			     pointDotStrokeWidth: 2,
			    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
			    pointHitDetectionRadius: 20,
		    	//Boolean - Whether to show a stroke for datasets
		      </c:otherwise>
		    </c:choose>

		    //datasetStroke: true,
		    //Number - Pixel width of dataset stroke
		    //datasetStrokeWidth: 2,
		    //Boolean - Whether to fill the dataset with a color
		    //datasetFill: true,
		    //String - A legend template
		       //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		    maintainAspectRatio: true,
		    //Boolean - whether to make the chart responsive to window resizing
		    responsive: true,
			  // String - Template string for multiple tooltips

		  };

    $('#cpuChart ~ .chartLegend').empty();
	cpuChartData.datasets.forEach(function(label, i){
		//var cpulegendItem = $('<span></span>').append('<i></i>' + label['label']+'<br><br>');
		//cpulegendItem.find('i').css('background', cpuChartData.datasets[i].strokeColor);
		//$('#cpuChart ~ .chartLegend').append(cpulegendItem);

	});

	$('#memoryChart ~ .chartLegend').empty();
	memoryChartData.datasets.forEach(function(label, i){
		//var memorylegendItem = $('<span></span>').append('<i></i>' + label['label']+'<br><br>');
		//memorylegendItem.find('i').css('background', memoryChartData.datasets[i].strokeColor);
		//$('#memoryChart ~ .chartLegend').append(memorylegendItem);
	});

	$('#netTrficChart ~ .chartLegend').empty();
	netTrficChartData.datasets.forEach(function(label, i){
		var netTrficlegendItem = $('<span></span>').append('<i></i>' + label['label']);
		netTrficlegendItem.find('i').css('background', netTrficChartData.datasets[i].strokeColor);
		$('#netTrficChart ~ .chartLegend').append(netTrficlegendItem);
	});

  //Create the line chart
  <c:if test="${mainCvo.vmCpuList ne null and !empty mainCvo.vmCpuList}" >
  	CpuAreaChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxCpuUseRt)/CpuAreaChartOptions.scaleSteps);
  </c:if>
  cpuChartLine = cpuChart.Line(cpuChartData, CpuAreaChartOptions);

  <c:if test="${mainCvo.vmMemList ne null and !empty mainCvo.vmMemList}" >
  	MemAreaChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxMemUseRt)/MemAreaChartOptions.scaleSteps);
  </c:if>
  memoryChartLine = memoryChart.Line(memoryChartData, MemAreaChartOptions);

  <c:if test="${mainCvo.vmNetTrficList ne null and !empty mainCvo.vmNetTrficList}" >
  	NetTrficAreaChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxNetUseRt)/NetTrficAreaChartOptions.scaleSteps);
  </c:if>
  netTrficChartLine = netTrficChart.Line(netTrficChartData, NetTrficAreaChartOptions);


  function fn_getMaxScaleStepWidth(val){
		var retVal = (Math.floor((val+4)/10)+1)*10;
		if(retVal>100){
			retVAl=100;
		}
		return retVal;
	}

//-------------
  //- PIE CHART -
  //-------------
  // Get context with jQuery - using jQuery's .get() method.
  var managerChartCanvas = $("#managerChart").get(0).getContext("2d");
  managerChart = new Chart(managerChartCanvas);
  var managerData = [
    <c:choose>
       <c:when test="${mainCvo.managerSttsList eq null or empty mainCvo.managerSttsList }">
	    {
	        value: 1,
	        color: "#CACCCF",
	        highlight: "",
	        label: ""
	      }
        </c:when>

        <c:otherwise>
	        <c:set var="sumCnt" value=""/>
			<c:forEach var="vo" items="${mainCvo.managerSttsList}" varStatus="i">
			   <c:set var="sumCnt" value="${sumCnt+vo.mngCnt}" />
			</c:forEach>
			<c:choose>
        		<c:when test="${sumCnt <= 0}">
	        		{
				        value: 1,
				        color: "#CACCCF",
				        highlight: "",
				        label: ""
				      }
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${mainCvo.managerSttsList}" varStatus="i">
				    {
				      value: ${vo.mngCnt },
						<c:choose>
				          <c:when test="${'01' eq vo.mngCd}">
						      color: "#2288e1",
						      highlight: "#2288e1",
						      label: "RHEV"
						  </c:when>
				          <c:when test="${'02' eq vo.mngCd}">
						      color: "#00b15c",
						      highlight: "#00b15c",
						      label: "VmWare"
					  	   </c:when>
				          <c:when test="${'03' eq vo.mngCd}">
						      color: "#f7684f",
						      highlight: "#f7684f",
						      label: "HPVM"
				  	   	  </c:when>
				          <c:when test="${'04' eq vo.mngCd}">
						      color: "#ffa60c",
						      highlight: "#ffa60c",
						      label: "PowerVM"
			  	   	  	  </c:when>
				          <c:when test="${'05' eq vo.mngCd}">
						      color: "#00c0ef",
						      highlight: "#00c0ef",
						      label: "OpenStack"
				   	  	  </c:when>
				          <c:otherwise>
					          color: "#798A00",
						      highlight: "#798A00",
						      label: "<c:out value='${vo.mngNm}'/>"
						 </c:otherwise>
						</c:choose>
				    }
				         <c:if test="${fn:length(mainCvo.managerSttsList) > (i.index + 1) }"><c:out value=","/></c:if>
			   </c:forEach>
		    </c:otherwise>
		  </c:choose>
	  </c:otherwise>
   </c:choose>
  ];
  var pieOptions = {
    //Boolean - Whether we should show a stroke on each segment
    segmentShowStroke: true,
    //String - The colour of each segment stroke
    segmentStrokeColor: "#fff",
    //Number - The width of each segment stroke
    segmentStrokeWidth: 2,
    //Number - The percentage of the chart that we cut out of the middle
    percentageInnerCutout: 50, // This is 0 for Pie charts
    //Number - Amount of animation steps
    animationSteps: 100,
    //String - Animation easing effect
    animationEasing: "easeOutBounce",
    //Boolean - Whether we animate the rotation of the Doughnut
    animateRotate: true,
    //Boolean - Whether we animate scaling the Doughnut from the centre
    animateScale: false,
    //Boolean - whether to make the chart responsive to window resizing
    responsive: true,
    // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
    maintainAspectRatio: true,
    //String - A legend template
   };
  //Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.
  managerChartDoughnut = managerChart.Doughnut(managerData, pieOptions);

  $('#managerChart ~ .chartLegend').empty();
  managerData.forEach(function(label, i){
		//if(managerData[i].value > 0){
			//var legendItem="";
			var legendItem = $('<span></span>').append('<i></i>' + label['label']);
			var legendRow = $('<br>');
			legendItem.find('i').css('background', managerData[i].highlight);
			if(i==3){
				//$('#managerChart ~ .chartLegend').append(legendRow);
			}

			$('#managerChart ~ .chartLegend').append(legendItem);
		//}else{
		//	$('#managerChart ~ .chartLegend').append("<div></div>");
		//}
	});


	console.log("chart");
}

$(document).ready(ChartJS);

/*
if (timer !=null) clearInterval(timer);
var timer = setInterval(function(){
	ChartJS();}, 600000
);
 */

// 화면 resize 시에, Chart redraw
$(window).resize(function() {

	if (cpuChartLine != null) cpuChartLine.destroy();
	if (memoryChartLine != null) memoryChartLine.destroy();
	if (netTrficChartLine != null) netTrficChartLine.destroy();
	if (managerChartDoughnut != null) managerChartDoughnut.destroy();

	setTimeout(function() {
		$('#cpuChart, #memoryChart, #storageChart').css('height', '150px');
		$('#managerChart').css('height', '133px');
		ChartJS();
	}, 200);
});

$('.chart').css('padding-bottom', '0px')

$(".datepicker").datepicker();

$("#vmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "25px" }, // No.
		{sWidth : "70px" }, // 서버
		{sWidth : "40px" }, // 데이터수집
		{sWidth : "80px" }, // 부처
		{sWidth : "90px" }, // 업무
		//{sWidth : "40px" }, // 존
		{sWidth : "120px" }, // 가상서버명
		{sWidth : "70px" }, // 가상서버구성Id
		{sWidth : "50px" }, // vCore
		{sWidth : "50px" }, // 메모리할당량
		{sWidth : "50px" }, // 스토리지
		{sWidth : "70px" }, // 생성일자
		{sWidth : "80px" }, // 호스트명
		{sWidth : "80px" }, // IP주소
	],
	order : [],
});

$("#podTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "25px" }, // No.
		{sWidth : "80px" }, // 부처명
		{sWidth : "90px" }, // 업무명
		{sWidth : "80px" }, // 서비스명
		{sWidth : "50px" }, // pod상태
		{sWidth : "70px" }, // podId
		{sWidth : "60px" }, // CPU(Core)수
		{sWidth : "60px" }, // CPU사용률(%)
		{sWidth : "60px" }, // 메모리(GB)
		{sWidth : "60px" }, // 메모리사용률(%)
	],
	order : [],
})
</script>
