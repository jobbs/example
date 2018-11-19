<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     김동훈         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>

<script>
$(function () {
    var areaChartData = {
    		labels: [
    	<c:forEach var="val" items="${dateList }" varStatus="i">
				<c:if test="${i.count>1}">
					,
				</c:if>
				"<c:out value='${val}'/>"
      	</c:forEach>
      		],
      datasets: [

		<c:forEach var="job" items="${objList }" varStatus="i">
		<c:set var="objCnt" value="0"/>
			<c:if test="${i.count>1}">
				,
			</c:if>
				{
				  label: "<c:out value='${job}'/>",
				  data: [
					<c:forEach var="date" items="${dateList }" varStatus="k">
						<c:set var="dateCnt" value="0"/>
						<c:forEach var="vo" items="${list }" varStatus="j">
							<c:if test="${vo.objName eq job and date eq vo.checkDatetime}">
								<c:set var="dateCnt" value="${dateCnt+1}"/>
								<c:set var="objCnt" value="${objCnt+1}"/>
								<c:if test="${objCnt>1}">
									,
								</c:if>
								<c:out value='${vo.reqPageMax}'/>
							</c:if>
						</c:forEach>
						<c:if test="${dateCnt==0}">
						<c:set var="objCnt" value="${objCnt+1}"/>
							<c:if test="${k.count>1}">
							,
							</c:if>
							<c:out value=''/>
						</c:if>
					</c:forEach>
				         ]
				}
		</c:forEach>
      ]
    };
    setChartColor(areaChartData,'bar');
    var barChartCanvas = $("#barChart").get(0).getContext("2d");
    var barChart = new Chart(barChartCanvas);
    var barChartData = areaChartData;

    var barChartOptions = {
      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero: true,
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
      //Boolean - If there is a stroke on each bar
      barShowStroke: true,
      //Number - Pixel width of the bar stroke
      barStrokeWidth: 2,
      //Number - Spacing between each of the X value sets
      barValueSpacing: 5,
      //Number - Spacing between data sets within X values
      barDatasetSpacing: 1,
      //String - A legend template
      <%-- legendTemplate: "<ul class=\"<<%="%"%>=name.toLowerCase()<%="%"%>>-legend\"><<%="%"%> for (var i=0; i<datasets.length; i++){<%="%"%>><li><span style=\"background-color:<<%="%"%>=datasets[i].fillColor<%="%"%>>\"></span><<%="%"%>if(datasets[i].label){<%="%"%>><<%="%"%>=datasets[i].label<%="%"%>><<%="%"%>}<%="%"%>></li><<%="%"%>}<%="%"%>></ul>", --%>
      //Boolean - whether to make the chart responsive
      responsive: true,
      maintainAspectRatio: true
    };

    barChartOptions.datasetFill = false;
    barChart.Bar(barChartData, barChartOptions);

    barChartData.datasets.forEach(function(label, i){
		var legendItem = $('<span></span>').append('<i></i>' + label['label']);
		legendItem.find('i').css('background', barChartData.datasets[i].fillColor);
		$('#barChart ~ .chartLegend').append(legendItem);
	});

    var areaChartData1 = {
    		labels: [
    	<c:forEach var="val" items="${dateList }" varStatus="i">
				<c:if test="${i.count>1}">
					,
				</c:if>
				"<c:out value='${val}'/>"
      	</c:forEach>
      		],
      datasets: [

<c:forEach var="job" items="${objList }" varStatus="i">
<c:set var="objCnt" value="0"/>
	<c:if test="${i.count>1}">
		,
	</c:if>
		{
		  label: "<c:out value='${job}'/>",
		  data: [
			<c:forEach var="date" items="${dateList }" varStatus="k">
				<c:set var="dateCnt" value="0"/>
				<c:forEach var="vo" items="${list }" varStatus="j">
					<c:if test="${vo.objName eq job and date eq vo.checkDatetime}">
						<c:set var="dateCnt" value="${dateCnt+1}"/>
						<c:set var="objCnt" value="${objCnt+1}"/>
						<c:if test="${objCnt>1}">
							,
						</c:if>
						<c:out value='${vo.hitMax}'/>
					</c:if>
				</c:forEach>
				<c:if test="${dateCnt==0}">
				<c:set var="objCnt" value="${objCnt+1}"/>
					<c:if test="${k.count>1}">
					,
					</c:if>
					<c:out value=''/>
				</c:if>
			</c:forEach>
		         ]
		}
</c:forEach>

      ]
    };
    setChartColor(areaChartData1,'bar');
    var barChartCanvas1 = $("#barChart1").get(0).getContext("2d");
    var barChart1 = new Chart(barChartCanvas1);
    var barChartData1 = areaChartData1;

    var barChartOptions1 = {
      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero: true,
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
      //Boolean - If there is a stroke on each bar
      barShowStroke: true,
      //Number - Pixel width of the bar stroke
      barStrokeWidth: 2,
      //Number - Spacing between each of the X value sets
      barValueSpacing: 5,
      //Number - Spacing between data sets within X values
      barDatasetSpacing: 1,
      //String - A legend template
      <%-- legendTemplate: "<ul class=\"<<%="%"%>=name.toLowerCase()<%="%"%>>-legend\"><<%="%"%> for (var i=0; i<datasets.length; i++){<%="%"%>><li><span style=\"background-color:<<%="%"%>=datasets[i].fillColor<%="%"%>>\"></span><<%="%"%>if(datasets[i].label){<%="%"%>><<%="%"%>=datasets[i].label<%="%"%>><<%="%"%>}<%="%"%>></li><<%="%"%>}<%="%"%>></ul>", --%>
      //Boolean - whether to make the chart responsive
      responsive: true,
      maintainAspectRatio: true
    };

    barChartOptions1.datasetFill = false;
    barChart1.Bar(barChartData1, barChartOptions1);

    barChartData1.datasets.forEach(function(label, i){
		var legendItem = $('<span></span>').append('<i></i>' + label['label']);
		legendItem.find('i').css('background', barChartData1.datasets[i].fillColor);
		$('#barChart1 ~ .chartLegend').append(legendItem);
	});

      });
$(document).bind('selectJob',setJob);
function setJob(evt) {

	var job = evt.datas;
	$('#jobId').val(job.jobId);
	$('#jobNm').val(job.institutionNm+" "+ job.jobNm);
	fn_searchWebServer(job.jobId);
}
function fn_searchWebServer(jobId){
	var data={
			'managetypeId' : 'WEB',
			'jobId' : jobId
	};
	var options = {
			url: '<c:url value="/dsb/stts/etc/wasSmTimeConect/selectJobWebWasDbmsList.do" />',
			data: data,
			type: 'POST',
			dataType: 'json',
			//contentType:"application/json;charset=UTF-8",
			success: function(result){
				fn_setWebServer(result.data);
			},
			beforeSend: function() {},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

	$.ajax(options);
}
function fn_setWebServer(webServerList){
	$('#objId option').remove();//삭제
	var option ='<option value="">전체</option>';
	$(option).appendTo($('#objId'));
	for(var i=0; i<webServerList.length; i++){
		var option ='<option value="'+webServerList[i].objId+'">'+webServerList[i].objName+'</option>';
		$(option).appendTo($('#objId'));
	}
}

function fn_search(){
	if(!fn_form_validation("searchVo")){
		return;
	}

	searchVo.action='<c:url value="selectWebReqPageIncrList.do" />';
	searchVo.submit();
}

</script>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
		<form:hidden path="jobId" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse" onclick="return false;">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<div class="box-body collapse in search-collapse">
				<div class="form-group">

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>부처명/업무</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input type="text" path="jobNm" cssClass="form-control input-sm essential" title="부처명/업무" readonly="true" />
								<div class="input-group-btn">
									<button class="btn btn-sm" onclick="openJobeSearch(); return false;">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>WEB SERVER</label>
						</div>
						<div class="cell-body">
							<form:select cssClass="form-control input-sm" path="objId" title="WEB SERVER">
								<form:option value="">전체</form:option>
								<c:forEach var="vo" items="${webList}" varStatus="i">
									<form:option value="${vo.objId}">
										<c:out value='${vo.objName}' />
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label>기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell" id="divDate">
									<div class="input-group period period-start">
										<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate essential" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')" />
									</div>
									<div class="input-group period period-end">
										<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate essential" title="종료일자" onchange="initDate(this, 'strtDt', 'E')" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="table-btn pull-left">
					<button type="reset" class="btn btn-default">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red " onclick="fn_search(); return false;">조회</button>
					<!-- <button type="button" class="btn btn-default ">엑셀 다운로드</button> -->
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</form:form>
</div>

<div class="col-box-100 detail-col">
	<div class="col-cell-group clearfix">

		<div class="col-cell-50 no-padding-right">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">요청페이지수</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body" id="graph-d">
					<div class="chart">
						<canvas id="barChart" style="height: 200px;"></canvas>
						<div class="chartLegend"></div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>

		<div class="col-cell-50">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">히트 수</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body" id="graph-d">
					<div class="chart">
						<canvas id="barChart1" style="height: 200px;"></canvas>
						<div class="chartLegend"></div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>

	</div>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				요청 페이지 수 및 히트 수 <small></small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="table">
				<caption>(WEB)요청페이지수 목록</caption>
				<colgroup>
					<col class="col25">
					<col class="col25">
					<col class="col25">
					<col class="col25">
				</colgroup>
				<thead>
					<tr>
						<th>일자</th>
						<th>가상서버명</th>
						<th>요청페이지 수</th>
						<th>히트 수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<script>
								$('canvas').hide();
							</script>
							<tr>
								<c:if test="${searchVo.jobNm eq null}">
									<td colspan="8">조회 버튼을 클릭해 주시기 바랍니다.</td>
								</c:if>
								<c:if test="${searchVo.jobNm ne null}">
									<td colspan="8">검색된 데이터가 없습니다.</td>
								</c:if>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td><c:out value="${vo.checkDatetime}" /></td>
									<td class="alignL"><c:out value="${vo.objName}" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.reqPageMax}" type="number" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.hitMax}" type="number" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
</div>
<!-- /col -->

<script>
//일자 칼럼 merge
function fn_mergeTableDate(){
	var tempDate="";
	var firstTd;
	var cnt=1;
	$('#table tbody tr').each(function(){
		var td = $('td:first',this);
		var date = $(td).text();
		if(date!=tempDate){
			$(firstTd).attr('rowspan',cnt)
			firstTd = td;
			tempDate=date;
			cnt=1;
		}else{
			cnt++;
			$(td).remove();
		}
		console.log(date);
	});
	$(firstTd).attr('rowspan',cnt)
}

fn_mergeTableDate();//일자 칼럼 merge 호출

function excelDown(){
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	searchVo.action='<c:url value="selectWebReqPageIncrXlsDown.do" />';
	searchVo.submit();
}
</script>