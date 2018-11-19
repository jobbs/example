<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 18.
 * @lastmodified 2017. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 18.     양정순         v1.0             최초생성
 *
 --%>
 <%@page	import=" java.util.*"  %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script>

var cpuLineChartLine;
var memLineChartLine;
var netInLineChartLine;
var netOutLineChartLine;

$(function () {
	ChartDraw();
});

function ChartDraw() {
	    var cpuValArr =[];
		var memValArr =[];
		var netInValArr =[];
		var netOutValArr =[];
		var maxCpuUseRt=0,maxMemUseRt=0, maxNetInUseRt=0, maxNetOutUseRt=0;
		<c:forEach var="nodeItem" items="${nodeList }">
			<c:forEach var="cpuItem" items="${cpuList }">
				<fmt:formatNumber var="useRt" type="number" value="${cpuItem[nodeItem.atmscl_node_id]}"/>
				<c:choose>
					<c:when test="${empty useRt}">cpuValArr.push(0);</c:when>
					<c:otherwise>cpuValArr.push(<c:out value='${useRt}'/>);</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:forEach var="memItem" items="${memList }">
				<fmt:formatNumber var="useRt" type="number" value="${memItem[nodeItem.atmscl_node_id]}"/>
				<c:choose>
					<c:when test="${empty useRt}">memValArr.push(0);</c:when>
					<c:otherwise>memValArr.push(<c:out value='${useRt}'/>);</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:forEach var="netInItem" items="${netInList }">
				<c:set var="useRt" value="${netInItem[nodeItem.atmscl_node_id]}"/>
				<c:choose>
					<c:when test="${empty useRt}">netInValArr.push(0);</c:when>
					<c:otherwise>netInValArr.push(<c:out value='${useRt}'/>);</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:forEach var="netOutItem" items="${netOutList }">
				<fmt:formatNumber var="useRt" type="number" value="${netOutItem[nodeItem.atmscl_node_id]}"/>
				<c:choose>
					<c:when test="${empty useRt}">netOutValArr.push(0);</c:when>
					<c:otherwise>netOutValArr.push(<c:out value='${useRt}'/>);</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:forEach>
		maxCpuUseRt = Math.max.apply(null,cpuValArr);
		maxMemUseRt = Math.max.apply(null,memValArr);
		maxNetInUseRt = Math.max.apply(null,netInValArr);
		maxNetOutUseRt = Math.max.apply(null,netOutValArr);


    var cpuAreaChartData = {
      labels: [
               	<c:forEach var="cpuItem" items="${cpuList }" varStatus="i">
               		<c:if test="${i.count>1}">,</c:if>
               		<c:choose>
	           			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
	           			"${fn:substringAfter(cpuItem.dt,' ')}"
	           			</c:when>
	           			<c:otherwise>"<c:out value='${cpuItem.dt}'/>"</c:otherwise>
           			</c:choose>
      			</c:forEach>
               ],
      datasets: [
		<c:forEach var="nodeItem" items="${nodeList }" varStatus="i">

			<c:if test="${i.count>1}">
				,
			</c:if>
				{
			          label:"<c:out value='${nodeItem.atmscl_node_nm}'/>",
			          data: [
							<c:forEach var="cpuItem" items="${cpuList }" varStatus="j">
								<c:if test="${j.count>1}">	,		</c:if>
								<fmt:formatNumber var="useRt" type="number" value="${cpuItem[nodeItem.atmscl_node_id]}"/>
								<c:choose>
									<c:when test="${empty cpuItem[nodeItem.atmscl_node_id]}">""</c:when>
									<c:otherwise><c:out value='${useRt}'/></c:otherwise>
								</c:choose>

							</c:forEach>
			                 ]
				}
		</c:forEach>

      ]
    };
    setChartColor(cpuAreaChartData,'line');
    	var memAreaChartData = {
    			 labels: [
    		               	<c:forEach var="memItem" items="${memList }" varStatus="i">
    		               		<c:if test="${i.count>1}">,</c:if>
    		               		<c:choose>
	    	               			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
	    	               			"${fn:substringAfter(memItem.dt,' ')}"
	    	               			</c:when>
	    	               			<c:otherwise>"<c:out value='${memItem.dt}'/>"</c:otherwise>
    	               			</c:choose>
    		      			</c:forEach>
    		               ],
    		      datasets: [
    				<c:forEach var="nodeItem" items="${nodeList }" varStatus="i">
    					<c:if test="${i.count>1}">
    						,
    					</c:if>
    						{
    					          label:"<c:out value='${nodeItem.atmscl_node_nm}'/>",
    					          data: [
    									<c:forEach var="memItem" items="${memList }" varStatus="j">
    										<c:if test="${j.count>1}">	,		</c:if>
    										<fmt:formatNumber var="useRt" type="number" value="${memItem[nodeItem.atmscl_node_id]}"/>
    										<c:choose>
    											<c:when test="${empty memItem[nodeItem.atmscl_node_id]}">""</c:when>
    											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
    										</c:choose>

    									</c:forEach>
    					                 ]
    						}
    				</c:forEach>

    		      ]
    	    };
    setChartColor(memAreaChartData,'line');
    var netInAreaChartData = {
    		labels: [
		               	<c:forEach var="netInItem" items="${netInList }" varStatus="i">
		               		<c:if test="${i.count>1}">,</c:if>
		               		<c:choose>
		               			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
		               			"${fn:substringAfter(netInItem.dt,' ')}"
		               			</c:when>
		               			<c:otherwise>"<c:out value='${netInItem.dt}'/>"</c:otherwise>
	               			</c:choose>
		      			</c:forEach>
		               ],
		      datasets: [
				<c:forEach var="nodeItem" items="${nodeList }" varStatus="i">
					<c:if test="${i.count>1}">
						,
					</c:if>
						{
					          label:"<c:out value='${nodeItem.atmscl_node_nm}'/>",
					          data: [
									<c:forEach var="netInItem" items="${netInList }" varStatus="j">
										<c:if test="${j.count>1}">	,		</c:if>
										<c:set var="useRt" value="${netInItem[nodeItem.atmscl_node_id]}"/>
										<c:choose>
											<c:when test="${empty netInItem[nodeItem.atmscl_node_id]}">""</c:when>
											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
										</c:choose>

									</c:forEach>
					                 ]
						}
				</c:forEach>

		      ]
  	    };
    setChartColor(netInAreaChartData,'line');


    var netOutAreaChartData = {
    		labels: [
		               	<c:forEach var="netOutItem" items="${netOutList }" varStatus="i">
		               		<c:if test="${i.count>1}">,</c:if>
		               		<c:choose>
		               			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
		               			"${fn:substringAfter(netOutItem.dt,' ')}"
		               			</c:when>
		               			<c:otherwise>"<c:out value='${netOutItem.dt}'/>"</c:otherwise>
               				</c:choose>
		      			</c:forEach>
		               ],
		      datasets: [
				<c:forEach var="nodeItem" items="${nodeList }" varStatus="i">
					<c:if test="${i.count>1}">
						,
					</c:if>
						{
					          label:"<c:out value='${nodeItem.atmscl_node_nm}'/>",
					          data: [
									<c:forEach var="netOutItem" items="${netOutList }" varStatus="j">
										<c:if test="${j.count>1}">	,		</c:if>
										<fmt:formatNumber var="useRt" type="number" value="${netOutItem[nodeItem.atmscl_node_id]}"/>
										<c:choose>
											<c:when test="${empty netOutItem[nodeItem.atmscl_node_id]}">""</c:when>
											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
										</c:choose>

									</c:forEach>
					                 ]
						}
				</c:forEach>

		      ]
  	    };
    setChartColor(netOutAreaChartData,'line');
    var areaChartOptions = {
    		scaleOverride : true,
			  scaleSteps: 5,
			 scaleStepWidth : 20,
		     showScale: true,
		     tooltips: {
	    		 	enabled: true,
	    		 	xLabel:"%"
	    		},
		     scaleShowGridLines: true,
		     scaleGridLineColor: "rgba(0,0,0,.05)",
		     scaleGridLineWidth: 1,
		     scaleShowHorizontalLines: true,
		     scaleShowVerticalLines: true,
		     bezierCurve: true,
		     bezierCurveTension: 0.3,
		     pointDot: false,
		     <c:choose>
		      <c:when test="${graphNode eq 'emty'}">
		      	pointDotRadius: 0,
			    pointDotStrokeWidth: 0,
			    pointHitDetectionRadius: 0,
			   </c:when>
			   <c:otherwise>
		     	pointDotRadius: 2,
		     	pointDotStrokeWidth: 2,
		     	pointHitDetectionRadius: 40,
			  </c:otherwise>
			 </c:choose>
		     maintainAspectRatio: true,
		     responsive: true
    };
    cpuAreaChartData.datasets.forEach(function(label, i){
    	if(label['label'] != ""){
			var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', cpuAreaChartData.datasets[i].strokeColor);
			$('#cpulineChart ~ .chartLegend').append(arealegendItem);
    	}
	});
    memAreaChartData.datasets.forEach(function(label, i){
    	if(label['label'] != ""){
			var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', memAreaChartData.datasets[i].strokeColor);
			$('#memlineChart ~ .chartLegend').append(arealegendItem);
    	}
	});
    netInAreaChartData.datasets.forEach(function(label, i){
    	if(label['label'] != ""){
    		var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', netInAreaChartData.datasets[i].strokeColor);
			$('#netInlineChart ~ .chartLegend').append(arealegendItem);
    	}
	});
    netOutAreaChartData.datasets.forEach(function(label, i){
    	if(label['label'] != ""){
			var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', netOutAreaChartData.datasets[i].strokeColor);
			$('#netOutlineChart ~ .chartLegend').append(arealegendItem);
    	}
	});



    //-------------
    //- LINE CHART -
    //--------------
    var lineChartCanvas = $("#cpulineChart").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas);
    var lineChartOptions = areaChartOptions;
    lineChartOptions.datasetFill = false;
    lineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxCpuUseRt)/areaChartOptions.scaleSteps);
    cpuLineChartLine = lineChart.Line(cpuAreaChartData, lineChartOptions);

    var memLineChartCanvas = $("#memlineChart").get(0).getContext("2d");
    var memLineChart = new Chart(memLineChartCanvas);
    lineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxMemUseRt)/areaChartOptions.scaleSteps);
    memLineChartLine = memLineChart.Line(memAreaChartData, lineChartOptions);

    var netInLineChartCanvas = $("#netInlineChart").get(0).getContext("2d");
    var netInLineChart = new Chart(netInLineChartCanvas);
    lineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxNetInUseRt)/areaChartOptions.scaleSteps);
    netInLineChartLine = netInLineChart.Line(netInAreaChartData, lineChartOptions);

    var netOutLineChartCanvas = $("#netOutlineChart").get(0).getContext("2d");
    var netOutLineChart = new Chart(netOutLineChartCanvas);
    lineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxNetOutUseRt)/areaChartOptions.scaleSteps);
    netOutLineChartLine = netOutLineChart.Line(netOutAreaChartData, lineChartOptions);

  //10분단위일경우 시간단위로만 label을 출력함.
    <c:if test="${searchVo.colctCd eq 'MI'}">
	    for(var i=0; i<cpuAreaChartData.labels.length; i++){
	    	if(cpuAreaChartData.labels[i].substring(3,5)!='00'){
	    	cpuAreaChartData.labels[i]="";//값을 "" 으로 변경
	    	}
	    }
	    for(var i=0; i<memAreaChartData.labels.length; i++){
	    	if(memAreaChartData.labels[i].substring(3,5)!='00'){
	    		memAreaChartData.labels[i]="";
	    	}
	    }
	    for(var i=0; i<netInAreaChartData.labels.length; i++){
	    	if(netInAreaChartData.labels[i].substring(3,5)!='00'){
	    		netInAreaChartData.labels[i]="";
	    	}
	    }
	    for(var i=0; i<netOutAreaChartData.labels.length; i++){
	    	if(netOutAreaChartData.labels[i].substring(3,5)!='00'){
	    		netOutAreaChartData.labels[i]="";
	    	}
	    }
    </c:if>

    function fn_getMaxScaleStepWidth(val){
		var retVal = (Math.floor(val/10)+1)*10;
		if(retVal>100){
			retVAl=100;
		}
		return retVal;
	}

}

//윈도우 resize 시, chart redraw 하도록
$(window).resize(function() {
	if(window.console) console.log(new Date().toISOString() + ' resize');
    $('#cpulineChart ~ .chartLegend').html('');
    $('#memlineChart ~ .chartLegend').html('');
    $('#netInlineChart ~ .chartLegend').html('');
    $('#netOutlineChart ~ .chartLegend').html('');
    if (cpuLineChartLine != null) cpuLineChartLine.destroy();
    if (memLineChartLine != null) memLineChartLine.destroy();
    if (netInLineChartLine != null) netInLineChartLine.destroy();
    if (netOutLineChartLine != null) netOutLineChartLine.destroy();
    window.setTimeout(function() {
    	$('#cpulineChart, #memlineChart, #netInlineChart, #netOutlineChart').height('200px');
    	ChartDraw();
    }, 200);
});

</script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get">
	<form:hidden path="rsrcPoolId" />
	<form:hidden path="atmsclNodeId" />
	<div class="col-box-100 search-col">
		<div class=" box-search">

			<div class="box-body ">
				<div class="form-group">
		           <div class="form-cell form-cell-25">
					<c:choose>
						<c:when test="${empty searchVo.atmsclNodeNm}">
						<div class="cell-title">
			           		<label>자원풀명</label>
			           </div>
			           <div class="cell-body">
		             		<form:input path="rsrcPoolNm" cssClass="form-control input-sm" maxlength="" title="자원풀명" readonly="true"/>
		             	</div>
		             	</c:when>
		             	<c:otherwise>
		             	<div class="cell-title">
			           		<label>노드명</label>
			           </div>
			           <div class="cell-body">
		             		<form:input path="atmsclNodeNm" cssClass="form-control input-sm" maxlength="" title="노드명" readonly="true"/>
		             	</div>
						</c:otherwise>
		            </c:choose>
				   </div>
			       <div class="form-cell form-cell-75">
	            		<div class="cell-title">
		            		<label>검색기간</label>
		            	</div>
	            		<div class="cell-body">
              				<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<form:select path="searchTrmCd" cssClass="form-control input-sm" title="검색기간" onchange="f_changeSearchTrmCd(this.value)">
					                     	<form:option value="DD">일</form:option>
					                     	<form:option value="MM">월</form:option>
					                     	<form:option value="QQ">분기</form:option>
					                     	<form:option value="HH">반기</form:option>
					                     	<form:option value="YY">년</form:option>
					                     	<form:option value="DI">직접입력</form:option>
					                   	</form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divDD">
									<div class="input-group period">
										<form:input path="date" cssClass="form-control input-sm datepicker onlyDate" title="날짜" />
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divDI">
									<div class="input-group period period-start">
										<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')"/>
									</div>
									<div class="input-group period period-end">
										<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate"  title="종료일자" onchange="initDate(this, 'strtDt', 'E')"/>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divYY">
									<div class="">
										<form:select path="year" cssClass="form-control input-sm" title="년도">
											<c:forEach var="yearVo" items="${yearCdList }">
												<form:option value="${yearVo.cd}"><c:out value="${yearVo.cdNm }"/></form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divMM">
									<div class="">
										<form:select path="searchMmCd" cssClass="form-control input-sm" title="월" >
					                       	<form:option value="01">1월</form:option>
					                       	<form:option value="02">2월</form:option>
					                       	<form:option value="03">3월</form:option>
					                       	<form:option value="04">4월</form:option>
					                       	<form:option value="05">5월</form:option>
					                       	<form:option value="06">6월</form:option>
					                       	<form:option value="07">7월</form:option>
					                       	<form:option value="08">8월</form:option>
					                       	<form:option value="09">9월</form:option>
					                       	<form:option value="10">10월</form:option>
					                       	<form:option value="11">11월</form:option>
					                       	<form:option value="12">12월</form:option>
					                     </form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divQQ">
									<div class="">
										<form:select path="searchQqCd" cssClass="form-control input-sm" title="분기" >
					                       	<form:option value="01">1분기</form:option>
					                       	<form:option value="02">2분기</form:option>
					                       	<form:option value="03">3분기</form:option>
					                       	<form:option value="04">4분기</form:option>
				                     	</form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divHH">
									<div class="">
										<form:select path="searchHhCd" cssClass="form-control input-sm" title="반기" >
					                       	<form:option value="01">상반기</form:option>
					                       	<form:option value="02">하반기</form:option>
				                     	</form:select>
									</div>
								</div>
							</div>
						</div>
          			</div>
					<div class="form-cell form-cell-100">
			           <div class="cell-title">
			           		<label>수집간격</label>
			           </div>
			           <div class="cell-body">
		             		<form:radiobutton path="colctCd" cssClass="essential" title="10분" label="10분" value="MI" />
							<form:radiobutton path="colctCd" cssClass="essential" title="1시간" label="1시간" value="HH" />
							<form:radiobutton path="colctCd" cssClass="essential" title="1일" label="1일" value="DD" />
							<form:radiobutton path="colctCd" cssClass="essential" title="1개월" label="1개월" value="MM" />
		             	</div>
				    </div>
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<button class="btn btn-red btn-sm" onclick="javascript:fn_search();return false;">조회</button>
					</div>
        		</div>
			</div><!-- /box-body -->
		</div><!-- /box(검색조건) -->
	</div><!-- /col -->
</form:form>
<div class="col-box-100 detail-col">
        <div class="box">
          <div class="box-header">
              <h3 class="box-title">CPU 사용률</h3>
          </div><!-- /box-header -->
          <div class="box-body collapse in">
            <div class="chart">
            <div>(%)</div>
              <canvas id="cpulineChart" style="height:200px;"></canvas>
              <div class="chartLegend"></div>
            </div>
          </div><!-- /box-body -->
        </div><!-- /box(Line Chart) -->
        <div class="box">
          <div class="box-header">
              <h3 class="box-title">MEM 사용률</h3>
          </div><!-- /box-header -->
          <div class="box-body collapse in">
            <div class="chart">
            <div>(%)</div>
              <canvas id="memlineChart" style="height:200px;"></canvas>
              <div class="chartLegend"></div>
            </div>
          </div><!-- /box-body -->
        </div><!-- /box(Line Chart) -->
       <div class="box">
          <div class="box-header">
              <h3 class="box-title">네트워크 IN</h3>
          </div><!-- /box-header -->
          <div class="box-body collapse in">
            <div class="chart">
            <div>(KB/s)</div>
              <canvas id="netInlineChart" style="height:200px;"></canvas>
              <div class="chartLegend"></div>
            </div>
          </div><!-- /box-body -->
        </div><!-- /box(Line Chart) -->
         <div class="box">
          <div class="box-header">
              <h3 class="box-title">네트워크 OUT</h3>
          </div><!-- /box-header -->
          <div class="box-body collapse in">
            <div class="chart">
            <div>(KB/s)</div>
              <canvas id="netOutlineChart" style="height:200px;"></canvas>
              <div class="chartLegend"></div>
            </div>
          </div><!-- /box-body -->
        </div><!-- /box(Line Chart) -->
        <!-- box(Bar Chart) -->

        <div class="box">
          <div class="box-header">
            <h3 class="box-title">CPU 사용률</h3>
            <div class="box-tools">
               <div class="input-group-box">
        	<div class="input-group-cell pad-right">
        		<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()"><i class="fa fa-download"></i></button>
        	</div>
        </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed">
              <caption>CPU 사용률</caption>
                <colgroup>
                	<col class="col50">
                		<c:if test="${nodeList eq null or empty nodeList }">
							<script>
								$('canvas').hide();
							</script>
						</c:if>
						<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<col class="col40">
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th>기간</th>
                  		<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<th title="<c:out value="${vo.atmscl_node_nm}"/>"><c:out value="${vo.atmscl_node_nm}"/></th>
                  		</c:forEach>
                	</tr>
                </thead>
                <tbody>
                <c:if test="${nodeList eq null or empty nodeList }">
                	<tr><td>검색된 데이터가 없습니다.</td></tr>
                </c:if>
                <c:forEach var="map" items="${cpuList }" varStatus="i">
                	<tr>
	                  <td class="ellipsis"><c:out value="${map['dt']}"/></td>
		              <c:forEach var="nodeItem" items="${nodeList }">
		              	<c:set var="atmsclNodeId" value="${nodeItem.atmscl_node_id}"/>
	    	              <td class="alignR">${map[atmsclNodeId]}</td>
	                  </c:forEach>
	                </tr>
	                </c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->

        </div><!-- /box(목록조회 테이블) -->
        <div class="box">
          <div class="box-header">
            <h3 class="box-title">MEM 사용률</h3>
            <div class="box-tools">
              <div class="input-group pull-right">
                <div class="input-group-select">
                </div>
                <div class="input-group-btn">
                </div>
              </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed">
              <caption>MEM 사용률</caption>
                <colgroup>
                	<col class="col50">
						<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<col class="col40">
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th>기간</th>
                  		<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<th title="<c:out value="${vo.atmscl_node_nm}"/>"><c:out value="${vo.atmscl_node_nm}"/></th>
                  		</c:forEach>
                	</tr>

                </thead>
                <tbody>
                <c:if test="${nodeList eq null or empty nodeList }">
                	<tr><td>검색된 데이터가 없습니다.</td></tr>
                </c:if>
                <c:forEach var="map" items="${memList }" varStatus="i">
                	<tr>
	                  <td class="ellipsis"><c:out value="${map['dt']}"/></td>
		              <c:forEach var="nodeItem" items="${nodeList }">
		              	<c:set var="atmsclNodeId" value="${nodeItem.atmscl_node_id}"/>
	    	              <td class="alignR">${map[atmsclNodeId]}</td>
	                  </c:forEach>
	                </tr>
	                </c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->

        </div><!-- /box(목록조회 테이블) -->
        <div class="box">
          <div class="box-header">
            <h3 class="box-title">네트워크 IN</h3>
            <div class="box-tools">
              <div class="input-group pull-right">
                <div class="input-group-select">
                </div>
                <div class="input-group-btn">
                </div>
              </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed">
              	<caption>네트워크 IN</caption>
                <colgroup>
                	<col class="col50">
						<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<col class="col40">
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th>기간</th>
                  		<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<th title="<c:out value="${vo.atmscl_node_nm}"/>"><c:out value="${vo.atmscl_node_nm}"/></th>
                  		</c:forEach>
                	</tr>

                </thead>
                <tbody>
                <c:if test="${nodeList eq null or empty nodeList }">
                	<tr><td>검색된 데이터가 없습니다.</td></tr>
                </c:if>
                <c:forEach var="map" items="${netInList }" varStatus="i">
                	<tr>
	                  <td class="ellipsis"><c:out value="${map['dt']}"/></td>
		              <c:forEach var="nodeItem" items="${nodeList }">
		              	<c:set var="atmsclNodeId" value="${nodeItem.atmscl_node_id}"/>
	    	              <td class="alignR">${map[atmsclNodeId]}</td>
	                  </c:forEach>
	                </tr>
	                </c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->

        </div><!-- /box(목록조회 테이블) -->

        <div class="box">
          <div class="box-header">
            <h3 class="box-title">네트워크 OUT</h3>
            <div class="box-tools">
              <div class="input-group pull-right">
                <div class="input-group-select">
                </div>
                <div class="input-group-btn">
                </div>
              </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed">
              	<caption>네트워크 OUT</caption>
                <colgroup>
                	<col class="col50">
						<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<col class="col40">
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th>기간</th>
                  		<c:forEach var="vo" items="${nodeList }" varStatus="i">
							<th title="<c:out value="${vo.atmscl_node_nm}"/>"><c:out value="${vo.atmscl_node_nm}"/></th>
                  		</c:forEach>
                	</tr>

                </thead>
                <tbody>
                <c:if test="${nodeList eq null or empty nodeList }">
                	<tr><td>검색된 데이터가 없습니다.</td></tr>
                </c:if>
                <c:forEach var="map" items="${netOutList }" varStatus="i">
                	<tr>
	                  <td class="ellipsis"><c:out value="${map['dt']}"/></td>
		              <c:forEach var="nodeItem" items="${nodeList }">
		              	<c:set var="atmsclNodeId" value="${nodeItem.atmscl_node_id}"/>
	    	              <td class="alignR">${map[atmsclNodeId]}</td>
	                  </c:forEach>
	                </tr>
	                </c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->

        </div><!-- /box(목록조회 테이블) -->


      </div><!-- /col -->
<script>
      $(document).ready(function(){

    		function pageInit(){
    			$('#searchTrmCd').trigger('change');
    			//fn_dataTable1("tableEvntNtceHistList",0)//테이블 정렬및 resize
    			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
    		}
    		pageInit();
    	});

      function f_changeSearchTrmCd(val){
    	  $(':radio[name=colctCd]').prop('disabled','disabled');//수집간격 전체 disabled
    		if(val=='DD'){//일
    			$('#divDD').show();
    			$('#divMM').hide();
    			$('#divQQ').hide();
    			$('#divHH').hide();
    			$('#divYY').hide();
    			$('#divDI').hide();

    			$('#colctCd1').prop('disabled','');//1분
    			$('#colctCd2').prop('disabled','');//1시간
    			if(!$('#colctCd1').prop('checked') && !$('#colctCd2').prop('checked')){
    				$('#colctCd2').prop('checked',true);
    			}
    		}else if(val=='MM'){//월
    			$('#divDD').hide();
    			$('#divMM').show();
    			$('#divQQ').hide();
    			$('#divHH').hide();
    			$('#divYY').show();
    			$('#divDI').hide();
    			$('#colctCd3').prop('disabled','');//1일
    			$('#colctCd4').prop('disabled','');//1개월
    			if(!$('#colctCd3').prop('checked') && !$('#colctCd4').prop('checked')){
    				$('#colctCd3').prop('checked',true);
    			}
    		}else if(val=='QQ'){//분기
    			$('#divDD').hide();
    			$('#divMM').hide();
    			$('#divQQ').show();
    			$('#divHH').hide();
    			$('#divYY').show();
    			$('#divDI').hide();
    			$('#colctCd4').prop('disabled','');//1개월
    			if(!$('#colctCd4').prop('checked') ){
    				$('#colctCd4').prop('checked',true);
    			}
    		}else if(val=='HH'){//반기
    			$('#divDD').hide();
    			$('#divMM').hide();
    			$('#divQQ').hide();
    			$('#divHH').show();
    			$('#divYY').show();
    			$('#divDI').hide();
    			$('#colctCd4').prop('disabled','');//1개월
    		}else if(val=='YY'){//년
    			$('#divDD').hide();
    			$('#divMM').hide();
    			$('#divQQ').hide();
    			$('#divHH').hide();
    			$('#divYY').show();
    			$('#divDI').hide();
    			$('#colctCd4').prop('disabled','');//1개월
    			if(!$('#colctCd4').prop('checked') ){
    				$('#colctCd4').prop('checked',true);
    			}
    		}else if(val=='DI'){//직접입력
    			$('#divDD').hide();
    			$('#divMM').hide();
    			$('#divQQ').hide();
    			$('#divHH').hide();
    			$('#divYY').hide();
    			$('#divDI').show();
    			$('#colctCd3').prop('disabled','');//1일
    			if(!$('#colctCd3').prop('checked') ){
    				$('#colctCd3').prop('checked',true);
    			}
    			//$('#strtDt').val('');
    			//$('#endDt').val('');
    		}

    	}
      function excelDown(){
    	 <c:if test="${nodeList eq null or empty nodeList }">
    	  	jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
      	</c:if>
    		searchVo.action='<c:url value="selectAxNodeTimeResUseRtPXlsDown.do" />';
    		searchVo.submit();
    	}
      function fn_search(){
     		searchVo.action='<c:url value="selectAxNodeTimeResUseRtP.do" />';
     		searchVo.submit();
     		return false;
     	}
</script>