<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     김동훈         v1.0             최초생성
 *
 --%>
<%@page import=" java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script>
$(function () {
    var areaChartData = {
    		labels: [
    	<c:forEach var="vo" items="${list }" varStatus="i">
				<c:if test="${i.count>1}">
					,
				</c:if>
				"<c:out value='${vo.stdrYr}'/>"
      	</c:forEach>
      		],
      datasets: [
		{
		  label: "업무수",
		  data: [
				<c:forEach var="vo" items="${list }" varStatus="j">
					<c:if test="${j.count>1}">
						,
					</c:if>
					<c:out value='${vo.rsltJobQty}'/>
					<c:if test='${empty vo.rsltJobQty}'>0</c:if>
				</c:forEach>
		         ]
		}
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
});
</script>
<div class="col-box-100 detail-col">
	<div class="col-cell-group clearfix">

		<div class="col-cell-100 no-padding-right">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">전환 실적</h3>
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
	</div>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">클라우드 전환 목표 및 실적</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-bordered table-layout-fixed">
				<caption>클라우드 전환 목표 및 실적</caption>
				<colgroup>
					<col class="colAuto" />
					<col class="colAuto" />
					<c:forEach var="vo" items="${yearList }" varStatus="i">
						<col class="colAuto" />
					</c:forEach>
				</colgroup>
				<thead>
					<tr>
						<th colspan="2">구분</th>
						<c:forEach var="vo" items="${yearList }" varStatus="i">
							<th title="<c:out value="${vo}"/>"><c:out value="${vo}" /></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list eq null or empty list}">
						<tr>
							<td>검색된 데이터가 없습니다.</td>
						</tr>
					</c:if>
					<tr>
						<td class="ellipsis" rowspan="2">전환목표</td>
						<td class="ellipsis alignL">업무수</td>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<td class="alignR"><fmt:formatNumber value="${vo.goalJobQty}" pattern="#,###" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td class="ellipsis alignL">누적업무수(누계 비율)</td>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<td class="alignR"><fmt:formatNumber value="${vo.sumGoalJobQty}" pattern="#,###" />(<fmt:formatNumber value="${vo.goalJobRt}" pattern="#,###" />%)</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="ellipsis" rowspan="2">전환실적</td>
						<td class="ellipsis alignL">업무수</td>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<td class="alignR"><fmt:formatNumber value="${vo.rsltJobQty}" pattern="#,###" /></td>
						</c:forEach>
					</tr>
					<tr>
						<td class="ellipsis alignL">누적업무수(누계 비율)</td>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<td class="alignR"><c:if test='${not empty vo.rsltJobQty }'> <fmt:formatNumber value="${vo.sumRsltJobQty}" pattern="#,###" />(<fmt:formatNumber value="${vo.rsltJobRt}" pattern="#,###" />%)</c:if></td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

	</div>
	<!-- /box(목록조회 테이블) -->

	<br />
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">클라우드 실적</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right"></div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-bordered table-layout-fixed">
				<caption>클라우드 실적</caption>
				<colgroup>
					<col class="colAuto" />
					<col class="colAuto" />
					<c:forEach var="vo" items="${yearList }" varStatus="i">
						<col class="colAuto" />
					</c:forEach>
				</colgroup>
				<thead>
					<tr>
						<th colspan="2">구분</th>
						<th>계</th>
						<c:forEach var="vo" items="${yearList }" varStatus="i">
							<th title="<c:out value="${vo}"/>"><c:out value="${vo}" /></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:if test="${dtlList eq null or empty dtlList }">
						<tr>
							<td>검색된 데이터가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="map" items="${dtlList }" varStatus="i">
						<tr>
							<c:if test='${i.count%2==1}'>
								<td class="ellipsis" rowspan="2"><c:out value="${map['region_nm']}" /></td>
							</c:if>

							<td class="ellipsis">
								<c:choose>
									<c:when test='${i.count%2==0}'>업무수</c:when>
									<c:otherwise>기관수</c:otherwise>
								</c:choose>
							</td>
							<td class="ellipsis alignR"><fmt:formatNumber value="${map['tot']}" pattern="#,###" /></td>
							<c:forEach var="year" items="${yearList }">
								<c:set var="year" value="${year}" />
								<td class="alignR"><fmt:formatNumber value="${map[year]}" pattern="#,###" /></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<div class="box-footer edit-btn-group">

			<div class="pull-left btns"></div>
			<ul class="pagination">
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertCludSwtchGoalRsltView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>

		</div>
	</div>
	<!-- /box(목록조회 테이블) -->

</div>
<!-- /col -->
<form id="excelForm" name="excelForm"
	action='<c:url value="selectCludSwtchGoalRsltXlsDown.do"/>'></form>
<script>
function fn_excelDown(){
	excelForm.submit();
}
function fn_goToUrl(url){
	location.href=url;
}
</script>