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
<%@page	import=" java.util.*"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script>

var totLineChartLine;
var cpuLineChartLine;
var memLineChartLine;
var sanLineChartLine;

$(function () {
	ChartDraw();
});

function ChartDraw() {

	var cpuValArr =[];
	var memValArr =[];
	var sanValArr =[];
	var maxCpuUseRt=0,maxMemUseRt=0, maxSanUseRt=0;
	<c:forEach var="item" items="${chartList }">
			<fmt:formatNumber var="useRt" type="number" value="${item.cpuUseRatio}"/>
			cpuValArr.push(<c:out value='${useRt}'/>);
			<fmt:formatNumber var="useRt" type="number" value="${item.memUseRatio}"/>
			memValArr.push(<c:out value='${useRt}'/>);
			<fmt:formatNumber var="useRt" type="number" value="${item.sanUseRatio}"/>
			sanValArr.push(<c:out value='${useRt}'/>);
	</c:forEach>
	maxCpuUseRt = Math.max.apply(null,cpuValArr);
	maxMemUseRt = Math.max.apply(null,memValArr);
	maxSanUseRt = Math.max.apply(null,sanValArr);

	var maxTotalUseRt = maxSanUseRt;
	if(maxTotalUseRt < maxMemUseRt ) maxTotalUseRt = maxMemUseRt;
	if(maxTotalUseRt < maxCpuUseRt ) maxTotalUseRt = maxCpuUseRt;


	var cpuAreaChartData = {
		      labels: [
		               	<c:forEach var="item" items="${chartList }" varStatus="i">
		               		<c:if test="${i.count>1}">,</c:if>
		               		<c:choose>
		               			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
		               			"${fn:substringAfter(item.time,' ')}"
		               			</c:when>
		               			<c:otherwise>"<c:out value='${item.time}'/>"</c:otherwise>
		               		</c:choose>
		      			</c:forEach>
		               ],
		      datasets: [
						{
					          label:"CPU",
					          data: [
									<c:forEach var="item" items="${chartList }" varStatus="j">
										<c:if test="${j.count>1}">	,		</c:if>
										<fmt:formatNumber var="useRt" type="number" value="${item.cpuUseRatio}"/>
										<c:choose>
											<c:when test="${empty item.cpuUseRatio }">""</c:when>
											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
										</c:choose>

									</c:forEach>
					                 ]
						},
						{
					          label:"MEM",
					          data: [
									<c:forEach var="item" items="${chartList }" varStatus="j">
										<c:if test="${j.count>1}">	,		</c:if>
										<fmt:formatNumber var="useRt" type="number" value="${item.memUseRatio}"/>
										<c:choose>
											<c:when test="${empty item.memUseRatio }">""</c:when>
											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
										</c:choose>

									</c:forEach>
					                 ]
						},
						{
					          label:"SAN",
					          data: [
									<c:forEach var="item" items="${chartList }" varStatus="j">
										<c:if test="${j.count>1}">	,		</c:if>
										<fmt:formatNumber var="useRt" type="number" value="${item.sanUseRatio}"/>
										<c:choose>
											<c:when test="${empty item.sanUseRatio }">""</c:when>
											<c:otherwise><c:out value='${useRt}'/></c:otherwise>
										</c:choose>

									</c:forEach>
					                 ]
						}
		      ]
		    };
	setChartColor(cpuAreaChartData,'line');


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
		     pointDotRadius: 2,
		     pointDotStrokeWidth: 2,
		     pointHitDetectionRadius: 40,
		     maintainAspectRatio: true,
		     responsive: true
    };

    $('#cpulineChart ~ .chartLegend').html('');
    cpuAreaChartData.datasets.forEach(function(label, i){
		var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
		arealegendItem.find('i').css('background', cpuAreaChartData.datasets[i].strokeColor);
		$('#cpulineChart ~ .chartLegend').append(arealegendItem);
	});




    //-------------
    //- LINE CHART -
    //--------------
    var lineChartCanvas = $("#cpulineChart").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas);
    var lineChartOptions = areaChartOptions;
    lineChartOptions.datasetFill = false;
    lineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxTotalUseRt)/areaChartOptions.scaleSteps);
    cpuLineChartLine = lineChart.Line(cpuAreaChartData, lineChartOptions);



    //10분단위일경우 시간단위로만 label을 출력함.
    <c:if test="${searchVo.colctCd eq 'MI'}">
	    for(var i=0; i<cpuAreaChartData.labels.length; i++){
	    	if(cpuAreaChartData.labels[i].substring(3,5)!='00'){
	    	cpuAreaChartData.labels[i]="";//값을 "" 으로 변경
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

// 윈도우 resize 시, chart redraw 하도록
$(window).resize(function() {
	if(window.console) console.log('resize');
    $('#cpulineChart ~ .chartLegend').html('');
    if (cpuLineChartLine != null) cpuLineChartLine.destroy();
    window.setTimeout(function() {
    	$('#cpulineChart').height('200px');
    	ChartDraw();
    }, 200);
});

</script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get">
	<form:hidden path="vmSeq" />
	<div class="col-box-100 search-col">
		<div class=" box-search">
			<div class="box-body ">
				<div class="form-group">
		           <div class="form-cell form-cell-100">
			           <div class="cell-title">
			           		<label>가상서버명</label>
			           </div>
			           <div class="cell-title"><b><c:choose><c:when test="${ null eq vmInfo.vmCompId }"><c:out value="${vmInfo.vmNm }"/></c:when><c:otherwise><c:out value="${vmInfo.vmNm } ( ${vmInfo.vmCompId } )"/></c:otherwise></c:choose></b></div>
				   </div>
					<div class="form-cell form-cell-50">
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
					<div class="form-cell form-cell-50">
			           <div class="cell-title">
			           		<label>수집간격</label>
			           </div>
			           <div class="cell-body">
			           		<div class="input-group-box">
			             		<form:radiobutton path="colctCd" name="colctCd" cssClass="essential" title="10분" label="10분" value="MI" />
								<form:radiobutton path="colctCd" name="colctCd" cssClass="essential" title="1시간" label="1시간" value="HH" />
								<form:radiobutton path="colctCd" name="colctCd" cssClass="essential" title="1일" label="1일" value="DD" />
								<form:radiobutton path="colctCd" name="colctCd" cssClass="essential" title="1개월" label="1개월" value="MM" />
							</div>
		             	</div>
				    </div>
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<button class="btn btn-red btn-sm" type="submit" onclick="fn_search(); ">조회</button>
					</div>

        		</div>
			</div><!-- /box-body -->
		</div><!-- /box(검색조건) -->
	</div><!-- /col -->
</form:form>
<div class="col-box-100 detail-col">
        <div class="box">
          <div class="box-header">
              <h3 class="box-title">사용률</h3>
          </div><!-- /box-header -->
          <div class="box-body collapse in" id="graph-b">
            <div class="chart">
            	<div>(%)</div>
              	<canvas id="cpulineChart" style="height:200px;"></canvas>
              	<div id="chartLegend" class="chartLegend"></div>
            </div>
          </div><!-- /box-body -->
        </div><!-- /box(Line Chart) -->

        <div class="box">
          <div class="box-header">
            <h3 class="box-title">자원사용 현황</h3>
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
              <caption>자원사용 현황</caption>
                <colgroup>
                	<col width="100px"/>
                		<c:if test="${vmInfo eq null }">
							<script>
								$('canvas').hide();
							</script>
						</c:if>
						<col width="80px"/>
						<col width="80px"/>
						<col width="80px"/>
						<col width="80px"/>
                    </colgroup>
                <thead>
                	<tr>
                		<th width="100px">기간</th>
						<th width="80px" title="CPU 사용률">CPU 사용률</th>
						<th width="80px" title="MEMORY 사용률">MEMORY 사용률</th>
						<th width="80px" title="스토리지 사용률">스토리지 사용률</th>
						<th width="80px" title="Network 사용률">Network 사용량(In/Out)</th>
                	</tr>
                </thead>
                <tbody>
                <c:if test="${chartList eq null or empty chartList }">
                	<tr><td>검색된 데이터가 없습니다.</td></tr>
                </c:if>
                <c:forEach var="item" items="${chartList }" varStatus="i">
                	<tr>
	                  <td class="ellipsis"><c:out value="${item.time}"/></td>
	    	          <td class="alignR">${item.cpuUseRatio}</td>
	    	          <td class="alignR">${item.memUseRatio}</td>
	    	          <td class="alignR">${item.sanUseRatio}</td>
	    	          <td class="alignR">${item.inTrafficUsed} / ${item.outTrafficUsed}</td>
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
    	<c:if test="${chartList eq null or empty chartList }">
    	  	jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
      	</c:if>
    		searchVo.action='<c:url value="selectVmMornitorPXlsDown.do" />';
    		searchVo.submit();
    }
    function fn_search(){
    	searchVo.action='<c:url value="selectVmMonitorP.do" />';
  		searchVo.submit();
    }

</script>