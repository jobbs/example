<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 22.
 * @lastmodified 2016. 12. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 22.     양정순         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart_2.2.0.js" />"></script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<!-- section.content의 하위 요소는 .row → .col → .box 순으로 진행됩니다. -->
<section class="board">
	<div class="row">
		<div class="col-box-50 dashboard-box monitor-main">
			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">센터별 서비스 현황</h3>
				</div>
				<c:forEach var="vo" items="${ServStteCvo.cntServStteList}" varStatus="ri">

					<div class="board-box-cell col-cell-33">
						<div class="box-body">
							<div class="center-status-info <c:if test="${vo.regionNm eq '소계' }">total</c:if>">
								<h4>
									<c:out value="${vo.regionNm }" />
								</h4>
								<div class="center-status-info-box ogan">
									<span class="info-box-icon"> <i class="fa fa-building-o"></i>
									</span>
									<div class="info-box-content">
										<span class="info-box-text">입주기관</span>
											<span class="info-box-number"><c:out value="${vo.institutionCnt }" /><b>건</b></span>
									</div>
								</div>
								<div class="center-status-info-box work">
									<span class="info-box-icon"> <i class="fa fa-folder-open-o"></i>
									</span>
									<div class="info-box-content">
										<span class="info-box-text">업무수</span>
											<span class="info-box-number"><c:out value="${vo.jobCnt }" /><b>건</b></span>
									</div>
								</div>
								<div class="center-status-info-box server">
									<span class="info-box-icon"> <i class="fa fa-hdd-o"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">가상서버수</span>
											<span class="info-box-number"><c:out value="${vo.vmCnt }" /><b>건</b></span>
									</div>
								</div>
							</div>
						</div>
						<!-- /box-body -->
					</div>
				</c:forEach>
			</div>
			<!-- /box -->

			<div class="box board-box monitor-main">
				<div class="box-header">
					<h3 class="box-title">클라우드 업무 진행 현황</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-horizon">
						<tbody>
							<tr>
								<td>
									<div class="chart">
										<canvas id="cloudChart"></canvas>
										<div class="chartLegend"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->

		</div>
		<!-- /col -->


		<div class="col-box-50 dashboard-box monitor-main">
			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">물리서버 현황</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<div class="chart col-cell-50">
						<canvas id="daejeonChart"></canvas>
						<div class="chartLegend"></div>
					</div>
					<div class="chart col-cell-50">
						<canvas id="gwangjuChart"></canvas>
						<div class="chartLegend"></div>
					</div>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->

			<div class="box board-box">
				<div class="box-header">
					<h3 class="box-title">가상서버 현황</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<colgroup>
							<col class="col25">
							<col class="col25">
							<col class="col25">
							<col class="col25">
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<c:forEach var="vo" items="${ServStteCvo.vmStteList}" varStatus="ri">
									<th><span class="font-lg"><c:out value="${vo.regionNm }" /></span></th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th><span class="font-lg">가상서버수</span></th>
								<c:forEach var="vo" items="${ServStteCvo.vmStteList}" varStatus="ri">
									<td><span class="font-lg"><c:out value="${vo.vmCnt }" /></span></td>
								</c:forEach>
							</tr>
							<tr>
								<th><span class="font-lg">가상화율</span></th>
								<c:forEach var="vo" items="${ServStteCvo.vmStteList}" varStatus="ri">
									<td><span class="font-lg"><c:out value="${vo.virRt }" />%</span></td>
								</c:forEach>
							</tr>
							<tr>
								<td colspan="4" class="pad10">
									<div class="chart">
										<canvas id="serverBarChart"></canvas>
										<div class="chartLegend"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col -->

	</div>
	<!-- /row -->

</section>
<!-- /컨텐츠 -->

<script>
$(function () {
			var contentAreaHeight = $(".board").height() - $(".content-header").height() - 139 - $(".copyright").height() - 21;
			$("section.board").parent(".chart").css({"height":contentAreaHeight});
			console.log("contentAreaHeight=>"+contentAreaHeight);

			var cloudChartHeight = contentAreaHeight - $(".row > .dashboard-box:first-child > .board-box:first-child").height() - 120;
			$("#cloudChart").parent(".chart").css({"height":cloudChartHeight});
			//console.log($(".row > .dashboard-box:first-child > .board-box:first-child").height());
			//var cloudChartHeight = $(".chart)
			//$("#cloudChart").parent(".chart").css({"height":cloudChartHeight});

			var serverBarChartHeight = contentAreaHeight - $(".row > .dashboard-box:last-child > .board-box:first-child").height() - 290;
			$("#serverBarChart").parent(".chart").css({"height":serverBarChartHeight});

});
</script>

<script>
  $(function () {
    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */


     //--------------
     //- 클라우드 업무 진행 현황 CHART -
     //--------------

//      var cloudChartData = {
//        labels: ["'12", "'13", "'14", "'15", "'16"],
//        datasets: [
//        	 {
//        		 label: "전환 업무",
// 	         backgroundColor: "rgba(34, 136, 225, 0.5)",
// 	         borderColor: "#288be2",
// 	         data: [150, 250, 280, 300, 456]
// 	       },
//        	 {
// 	         label: "총 업무",
// 	         backgroundColor: "rgba(210, 214, 222, 0.5)",
// 	         borderColor: "#d2d6de",
// 	         data: [850, 900, 1000, 1100, 1234]
// 	       }
//        ]
//      };

//      var cloudChartOptions = {
//     		  events: ["click"],
// 	    		legend : {
// 	    		 	display: false
// 	    		},
// 	    		tooltips: {
// 	    		 	enabled: false
// 	    		},
// 	    		elements: {
// 		    		 line: {borderWidth: 2},
// 		    		 point: {borderWidth: 5}
// 	    		},
// 		      scales: {
// 			    	  xAxes: [{ ticks: {fontSize: 20} }],
// 						  yAxes: [{ display: false, ticks: {fontSize: 20} }]
// 		      },
// 		      maintainAspectRatio: false,
// 		      responsive: true,
// 		      animation:{
// 			      onComplete: function(){

// 			    	  var ctx = this.chart.ctx;
// 						  ctx.textAlign = "left";
// 						  ctx.textBaseline = "bottom";
// 						  ctx.font = "20px nanumBold";

// 						  var index = 1;
// 						  var pointsLength = this.data.labels.length;

// 						  this.data.datasets.forEach(function (dataset, i){
// 							  var pointData = dataset;
// 							  dataset._meta[0].data.forEach(function (_data, i){
// 									  if(index == 1){
// 										  ctx.textAlign = "left";
// 									  }else if(index > 1 && index < pointsLength){
// 										  ctx.textAlign = "center";
// 									  }else if(index == pointsLength){
// 										  ctx.textAlign = "right";
// 									  	index = 0;
// 									  }
// 									  index++;
// 									  ctx.fillStyle = "#000";
// 									  ctx.fillText(pointData.data[i], _data._model.x, _data._model.y - 10);
// 							  });
// 						  });

// 			      }
// 		      }
//      }

//      var cloudChartCanvas = $("#cloudChart").get(0).getContext("2d");
//      var cloudChart = new Chart(cloudChartCanvas, {
//     	 type : 'line',
//     	 data : cloudChartData,
//     	 options : cloudChartOptions
//      });

//      var thisDatasets = cloudChartData.datasets;
//      thisDatasets.forEach(function(_this, i){
// 		 		var legendItem = $('<span></span>').append('<i></i>' + _this['label']);
// 		 		legendItem.find('i').css('background', thisDatasets[i].borderColor);
// 		 		$('#cloudChart ~ .chartLegend').append(legendItem);
// 	 	 });

//      var cloudParents = $('#cloudChart').parent(".chart").height();
//      $('#cloudChart').css({"height":cloudParents - 35 + "px"});





     //--------------
     //- 클라우드 업무 진행 현황 CHART -
     //--------------

     var cloudData = {
	       labels: [ <c:forEach var="CloudJobItem" items="${ServStteCvo.cloudJobList }" varStatus="i">
	                     <c:if test="${i.count>1}">,</c:if>"'<c:out value='${CloudJobItem.stdrYr}'/>"
                    </c:forEach>

	                ],
	       datasets: [
	       	 {
	       		 label: "전환업무",
	       		 backgroundColor: [ <c:forEach var="CloudJobItem" items="${ServStteCvo.cloudJobList }" varStatus="i">
						                <c:if test="${i.count>1}">,</c:if>
						                  <c:choose>
						                      <c:when test="${ i.count < CloudJobItem.cnt}">
						                        "#2288e1"
						                       </c:when>
						                       <c:otherwise>
						                         "rgba(210, 214, 222, 0.5)"
						                        </c:otherwise>
						                   </c:choose>
						            </c:forEach>
                                    ],
	       		 borderWidth: 1,
	       		 borderColor: [ "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "#aaa" ],
	       		 data: [ <c:forEach var="CloudJobItem" items="${ServStteCvo.cloudJobList }" varStatus="i">
			                 <c:if test="${i.count>1}">,</c:if>"<c:out value='${CloudJobItem.goalJobQty}'/>"
			            </c:forEach>
                       ]
	       	 },
		       {
	       		 label: "초과업무",
	       		 backgroundColor: [ <c:forEach var="CloudJobItem" items="${ServStteCvo.cloudJobList }" varStatus="i">
						                <c:if test="${i.count>1}">,</c:if>
						                  <c:choose>
						                      <c:when test="${i.count < CloudJobItem.cnt}">
						                         "#f7684f"
						                       </c:when>
						                       <c:otherwise>
						                          "rgba(210, 214, 222, 0.5)"
						                        </c:otherwise>
						                  </c:choose>
						               </c:forEach>
						             ],
	       		 borderWidth: 1,
	       		 borderColor: [ "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "rgba(0,0,0,0)", "#aaa" ],
	       		 data: [ <c:forEach var="CloudJobItem" items="${ServStteCvo.cloudJobList }" varStatus="i">
			                 <c:if test="${i.count>1}">,</c:if>"<c:out value='${CloudJobItem.rsltJobQty}'/>"
			            </c:forEach>
                       ]
		       }
	       ]
     };

     var cloudOptions = {
    		 events: ["touchend"],
   	      scales: {
   	    		xAxes: [{
     	    		stacked: true,
     	    		barThickness: 80,
   	    			ticks: {fontSize: 20},
   	    			gridLines: {
   	    				drawOnChartArea: false
   	    			}
   	    		}],
   	    	  yAxes: [{
   	    			display: false,
   	    			ticks: {fontSize: 20, beginAtZero: true}
   	    	  }],
   	      },
 	    		legend : {
 	    		 	display: false
 	    		},
 	    		tooltips: {
 	    		 	enabled: false
 	    		},

 		      maintainAspectRatio: false,
 		      responsive: true,
		      animation:{
			      onComplete: function(){

			    	  var ctx = this.chart.ctx;
						  ctx.textAlign = "center";
						  ctx.textBaseline = "top";
						  var pointData=new Array();
                          console.log(this.data);
						  this.data.datasets.forEach(function (dataset, j){
							  pointData[j] = dataset;
							  dataset._meta[0].data.forEach(function (_data, i){
								 // debugger;
								 //console.log("j"+j+"=>"+"i"+i+"=>"+pointData[j].data[i]+"=>"+pointData[j].data.length);
								  if(pointData[j].data.length > i+1 && pointData[j].data[i] !== 0){
									  if(pointData[j].label == '초과업무'){
										  if(pointData[j].data[i] !=  pointData[j-1].data[i]){
											  ctx.fillStyle = "#fff";
											  ctx.fillText(pointData[j].data[i], _data._model.x, _data._model.y - 1);
										  }
									  }else{
										  ctx.fillStyle = "#fff";
										  ctx.fillText(pointData[j].data[i], _data._model.x, _data._model.y + 5);
									  }

								  }else if(pointData[j].data[i] != 0){
									  ctx.fillStyle = "#000";
									  ctx.fillText(pointData[j].data[i], _data._model.x, _data._model.y + 5);
								  }
							  });
						  });

			      }
		      }
     }

     // Chart 생성
     var cloudCanvas = $("#cloudChart").get(0).getContext("2d");
     var cloudChart = new Chart(cloudCanvas, {
    	 type : 'bar',
    	 data : cloudData,
    	 options : cloudOptions
     });

     cloudData.datasets.forEach(function(label, i){
				var legendItem = $('<span></span>').append('<i></i>' + label['label']);
				legendItem.find('i').css('background', cloudData.datasets[i].backgroundColor[1]);
				$('#cloudChart ~ .chartLegend').append(legendItem);
		 });

     var cloudParents = $('#cloudChart').parent(".chart").height();
     $('#cloudChart').css({"height":cloudParents + 1 + "px"});




     //--------------
     //- 물리서버현황-대전 CHART -
     //--------------

     var daejeonData = {
	       labels: [
					<c:forEach var="DjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
						<c:if test="${DjPmItem.regionId eq 'DJ'}">
					    	<c:if test="${i.count>1}">,</c:if>"<c:out value='${DjPmItem.cdNm}'/>"
					    </c:if>
	                </c:forEach>
					 ],
	       datasets: [
	       	 {
	       		 borderWidth: 0,
	       		 backgroundColor: [ "#2288e1", "#00b15c", "#f7684f", "#ffa60c", "#00c0ef" ],
	       		 data: [
	       		        <c:set var="dJTot" value="0"/>
						<c:forEach var="DjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
						<c:if test="${DjPmItem.regionId eq 'DJ'}">
						    <c:set var="dJTot" value="${dJTot+DjPmItem.pmCnt}"/>
							<c:if test="${i.count>1}">,</c:if>"<c:out value='${DjPmItem.pmCnt+10}'/>"
						</c:if>
						</c:forEach>

	       		        ],
	       		 label: [
						<c:forEach var="DjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
						<c:if test="${DjPmItem.regionId eq 'DJ'}">
							<c:set var="cnt" value="${i.count}"/>
							<c:if test="${i.count>1}">,</c:if>"<c:out value='${DjPmItem.cdNm}'/>"
						</c:if>
						</c:forEach>

	       		         ]
		       }
	       ]
     };

     var gwangjuData = {
	       labels: [
					<c:forEach var="GjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
					<c:if test="${GjPmItem.regionId eq 'GJ'}">
						<c:if test="${i.count>cnt+1}">,</c:if>"<c:out value='${GjPmItem.cdNm}'/>"
					</c:if>
					</c:forEach>
                    ],
	       datasets: [
	       	 {
	       		 borderWidth: 0,
	       		 backgroundColor: [ "#2288e1", "#00b15c", "#f7684f", "#ffa60c", "#00c0ef" ],
	       		 data: [
	       		     	<c:set var="gJTot" value="0"/>
						<c:forEach var="GjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
						<c:if test="${GjPmItem.regionId eq 'GJ'}">
							<c:set var="gJTot" value="${gJTot+GjPmItem.pmCnt}"/>
							<c:if test="${i.count>cnt+1}">,</c:if>"<c:out value='${GjPmItem.pmCnt+10}'/>"
						</c:if>
						</c:forEach>
	       		         ],
	       		 label: [
						<c:forEach var="GjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
						<c:if test="${GjPmItem.regionId eq 'GJ'}">
							<c:if test="${i.count>cnt+1}">,</c:if>"<c:out value='${GjPmItem.cdNm}'/>"
						</c:if>
						</c:forEach>
	       		        ]
		       }
	       ]
     };

     var daejeonOptions = {
    		 events: ["touchend"],
   	         scale: {
   	    	   scaleShowVerticalLines: false,
   	         },
 	    	legend : {
 	    		 	display: false
 	    	 },
 	    	tooltips: {
 	    		 	enabled: false
 	    	},
 		     maintainAspectRatio: true,
 		     responsive: true,
    		 cutoutPercentage: 50,
    		 	animation: {
	    		 	onComplete: function(){

				    	var ctx = this.chart.ctx;
	    		 		var datasets = this.data.datasets[0];

    		      // 합계 생성
    		      var sum = 0;
    		      datasets.data.forEach(function(_this, i){
    		     	 sum += Number(_this);
    		      });

	   				  // 데이터 라벨 생성
    		      var midX = this.chart.width /2;
	   				  var midY = this.chart.height / 2;

	   				  var innerRadius = parseInt(this.innerRadius);
	   				  var outerRadius = this.outerRadius + innerRadius + 20;

	   				  for(var i=0; i < datasets.data.length; i++){
	   					  ctx.fillStyle = "black";
	   					  var textSize_val = this.chart.width / 30;
	   					  var textSize_per = this.chart.width / 40;
	   					  ctx.font = textSize_val + "px nanumBold";

	   					  var value = datasets.data[i]-10;
	   					  var valuePer = (value*100/sum).toFixed(1) + "%";

	   					  var dataindex = this.data.datasets.length -1;

	   					  var startAngle = datasets._meta[1].data[i]._model.startAngle;
	   					  var endAngle = datasets._meta[1].data[i]._model.endAngle;
	   					  var middleAngle = startAngle + ((endAngle - startAngle)/2);

	   					  var posX = (outerRadius/2) * Math.cos(middleAngle) + midX;
	   					  var posY = (outerRadius/2) * Math.sin(middleAngle) + midY;

	   					  var w_offset = ctx.measureText(value).width/2;
	   					  var h_offset = textSize_val/4;

	   					  ctx.fillText(value, posX - w_offset, posY + h_offset - 5);

	   					  ctx.font = textSize_per + "px nanumBold";
	   					  var w_offset_per = ctx.measureText(valuePer).width/2;
	   					  var h_offset_per = textSize_per/4;
	   					  ctx.fillText(valuePer, posX - w_offset_per, posY + h_offset_per + 5);
	   				  }



	   			  }
    		 	}

     }
  // Total 생성
      var chartTotal = $('<div class="chartTotal"></div>').append('<h5>대전</h5>' + '<p></p>')
      chartTotal.find('p').text(<c:out value='${dJTot}'/>);
      $('#daejeonChart ~ .chartLegend').after(chartTotal);
      var marginTop = (chartTotal.height() / 2 * -1) - chartTotal.siblings(".chartLegend").height() - 15;
      chartTotal.css({"margin-top":marginTop});

     var gwangjuOptions = {
    		 events: ["touchend"],
   	      scale: {
   	    	  scaleShowVerticalLines: false,
   	      },
 	    		legend : {
 	    		 	display: false
 	    		},
 	    		tooltips: {
 	    		 	enabled: false
 	    		},
 		      maintainAspectRatio: true,
 		      responsive: true,
    		 	cutoutPercentage: 50,

    		 	animation: {
	    		 	onComplete: function(){

				    	var ctx = this.chart.ctx;
	    		 		var datasets = this.data.datasets[0];

    		      // 합계 생성
    		      var sum = 0;
    		      datasets.data.forEach(function(_this, i){
    		     	 sum += Number(_this);
    		      });

	   				  // 데이터 라벨 생성
    		      var midX = this.chart.width /2;
	   				  var midY = this.chart.height / 2;

	   				  var innerRadius = parseInt(this.innerRadius);
	   				  var outerRadius = this.outerRadius + innerRadius + 20;

	   				  for(var i=0; i < datasets.data.length; i++){
	   					  ctx.fillStyle = "black";
	   					  var textSize_val = this.chart.width / 30;
	   					  var textSize_per = this.chart.width / 40;
	   					  ctx.font = textSize_val + "px nanumBold";

	   					  var value = datasets.data[i]-10;
	   					  var valuePer = (value*100/sum).toFixed(1) + "%";

	   					  var dataindex = this.data.datasets.length -1;

	   					  var startAngle = datasets._meta[2].data[i]._model.startAngle;
	   					  var endAngle = datasets._meta[2].data[i]._model.endAngle;
	   					  var middleAngle = startAngle + ((endAngle - startAngle)/2);

	   					  var posX = (outerRadius/2) * Math.cos(middleAngle) + midX;
	   					  var posY = (outerRadius/2) * Math.sin(middleAngle) + midY;

	   					  var w_offset = ctx.measureText(value).width/2;
	   					  var h_offset = textSize_val/4;

	   					  ctx.fillText(value, posX - w_offset, posY + h_offset - 5);

	   					  ctx.font = textSize_per + "px nanumBold";
	   					  var w_offset_per = ctx.measureText(valuePer).width/2;
	   					  var h_offset_per = textSize_per/4;
	   					  ctx.fillText(valuePer, posX - w_offset_per, posY + h_offset_per + 5);
	   				  }



	   			  }
    		 	}
     }
     <c:forEach var="GjPmItem" items="${ServStteCvo.pmStteList }" varStatus="i">
		<c:if test="${GjPmItem.regionId eq 'GJ'}">
			<c:if test="${i.count > 0}">
		     // Total 생성
		        var chartTotal = $('<div class="chartTotal"></div>').append('<h5>광주</h5>' + '<p></p>')
		        chartTotal.find('p').text(<c:out value='${gJTot}'/>);
		        $('#gwangjuChart ~ .chartLegend').after(chartTotal);
		        var marginTop = (chartTotal.height() / 2 * -1) - chartTotal.siblings(".chartLegend").height() - 5;
		        chartTotal.css({"margin-top":marginTop});
        	</c:if>
          </c:if>
       </c:forEach>
     // Chart 생성
     var daejeonCanvas = $("#daejeonChart").get(0).getContext("2d");
     var daejeonChart = new Chart(daejeonCanvas, {
    	 type : 'doughnut',
    	 data : daejeonData,
    	 options : daejeonOptions
     });

     // Chart 생성
     var gwangjuCanvas = $("#gwangjuChart").get(0).getContext("2d");
     var gwangjuChart = new Chart(gwangjuCanvas, {
    	 type : 'doughnut',
    	 data : gwangjuData,
    	 options : gwangjuOptions
     });

	   // 대전차트 Label 생성
		 daejeonData.labels.forEach(function(_this, i){
		 		var legendItem = $('<span></span>').append('<i></i>' + _this);
		 		legendItem.find('i').css('background', daejeonData.datasets[0].backgroundColor[i]);
		 		$('#daejeonChart ~ .chartLegend').append(legendItem);
	 	 });

	   // 대전차트 Label 생성
		 gwangjuData.labels.forEach(function(_this, i){
		 		var legendItem = $('<span></span>').append('<i></i>' + _this);
		 		legendItem.find('i').css('background', gwangjuData.datasets[0].backgroundColor[i]);
		 		$('#gwangjuChart ~ .chartLegend').append(legendItem);
	 	 });


     //--------------
     //- 가상서버 현황 CHART -
     //--------------

     var serverData = {
	       labels: [
					<c:forEach var="VmItem" items="${ServStteCvo.vrlzStteList }" varStatus="i">
						<c:if test="${i.count>1}">,</c:if>"<c:out value='${VmItem.cdNm}'/>"
					</c:forEach>
	                 ],
	       datasets: [
	       	 {
	       		 label: "물리현황",
	       		 backgroundColor: "#2288e1",
	       		 data: [
						<c:forEach var="VmItem" items="${ServStteCvo.vrlzStteList }" varStatus="i">
						<c:if test="${i.count>1}">,</c:if>"<c:out value='${VmItem.pmCnt}'/>"
						</c:forEach>
	       		        ]
	       	 },
		       {
	       		 label: "가상화현황",
	       		 backgroundColor: "#00b15c",
	       		 data: [
						<c:forEach var="VmItem" items="${ServStteCvo.vrlzStteList }" varStatus="i">
						<c:if test="${i.count>1}">,</c:if>"<c:out value='${VmItem.virRt}'/>"
						</c:forEach>
	       		        ]
		       }
	       ]
     };


     var serverOptions = {
    		 events: ["touchend"],
   	      scales: {
   	    		xAxes: [{
   	    			display: false,
   	    			ticks: {fontSize: 20},
   	    		}],
   	    	  yAxes: [{
    	    		  stacked: true,
   	    		      barThickness: 20,
   	    			  ticks: {fontSize: 20},
   	    			  gridLines: {
   	    			  drawOnChartArea: false
   	    			}
   	    	  }],
   	      },
 	    		legend : {
 	    		 	display: false
 	    		},
 	    		tooltips: {
 	    		 	enabled: false
 	    		},
 		      maintainAspectRatio: false,
 		      responsive: true,
		      animation:{
			      onComplete: function(){

			    	  var ctx = this.chart.ctx;
						  ctx.textAlign = "left";
						  ctx.textBaseline = "middle";

						  this.data.datasets.forEach(function (dataset, i){
							  var pointData = dataset;
							 // debugger;
							  dataset._meta[3].data.forEach(function (_data, i){
									  ctx.fillStyle = "#000";
									  ctx.fillText(pointData.data[i], _data._model.x + 5, _data._model.y);
							  });
						  });

			      }
		      }
     }

     // Chart 생성
     var serverCanvas = $("#serverBarChart").get(0).getContext("2d");
     var serverChart = new Chart(serverCanvas, {
    	 type : 'horizontalBar',
    	 data : serverData,
    	 options : serverOptions
     });

     serverData.datasets.forEach(function(label, i){
				var legendItem = $('<span></span>').append('<i></i>' + label['label']);
				legendItem.find('i').css('background', serverData.datasets[i].backgroundColor);
				$('#serverBarChart ~ .chartLegend').append(legendItem);
		 });

     var serverParents = $('#serverBarChart').parent(".chart").height();
     console.log("serverParents"+serverParents);
     $('#serverBarChart').css({"height":serverParents + 1+ "px"});






});

</script>

