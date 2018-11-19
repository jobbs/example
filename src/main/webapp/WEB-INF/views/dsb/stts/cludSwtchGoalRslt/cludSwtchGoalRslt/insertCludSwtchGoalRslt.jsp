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


</script>

<form name="insertForm" id="insertForm" onsubmit="return false;">
<div class="col-box-100 detail-col">
		<div class="box detail-list-box">
          <div class="box-header">
            <h3 class="box-title">클라우드 전환 목표</h3>
            <div class="box-tools">
               <div class="input-group-box">
        	<div class="input-group-cell pad-right">

        	</div>
        </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding list-body">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed" id="goalTable">
              <caption>클라우드 전환 목표</caption>
                <colgroup>
                	<col class="colAuto"/>
						<c:forEach var="vo" items="${yearList }" varStatus="i">
							<col  class="colAuto"/>
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th >센터</th>
                  		<c:forEach var="vo" items="${yearList }" varStatus="i">
							<th title="<c:out value="${vo}"/>"><c:out value="${vo}"/></th>
                  		</c:forEach>
                	</tr>
                </thead>
                <tbody>
					<c:forEach var="map" items="${list }" varStatus="i">
						<c:if test='${map["gubun"] eq "1"}'>
						<tr>
							<td>
								<c:choose>
									<c:when test='${map["region_id"] eq "DJ"}'>대전</c:when>
									<c:when test='${map["region_id"] eq "GJ"}'>광주</c:when>
									<c:when test='${map["region_id"] eq "DG"}'>대구</c:when>
									<c:otherwise> ${map["region_id"]}</c:otherwise>
								</c:choose>

							</td>
							<c:forEach var="year" items="${yearList }">
		              			<c:set var="year" value="${year}"/>
								<td>
									<input type="hidden" name="regionId" value='${map["region_id"]}'/>
									<input type="hidden" name='stdrYr' value="${year}"/>
		    	              		<input type="text" class="form-control essential onlyNumber alignR" maxlength="4" name="goalJobQty" id="goalJobQty" value="${map[year] }" title="${year}년도 클라우드 전환 목표"/>
								</td>
							</c:forEach>
							</tr>
						</c:if>
                  	</c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->

        </div><!-- /box(목록조회 테이블) -->

	<br/>
	<div class="box list-box">
    	<div class="box-header">
        	<h3 class="box-title">클라우드 전환 실적</h3>
            <div class="box-tools">
               	<div class="input-group-box">
        			<div class="input-group-cell pad-right">
        			</div>
        		</div>
            </div>
		</div><!-- /box-header -->
        <div class="box-body no-padding list-body">
        	<table class="table table-hover table-vertical table-bordered table-layout-fixed"  id="rsltTable">
            	<caption>클라우드 전환 실적</caption>
                <colgroup>
                	<col class="colAuto"/>
                	<col class="colAuto"/>
						<c:forEach var="vo" items="${yearList }" varStatus="i">
							<col  class="colAuto"/>
                  		</c:forEach>
                </colgroup>
                <thead>
                	<tr>
                		<th colspan="2">구분</th>
                  		<c:forEach var="vo" items="${yearList }" varStatus="i">
							<th title="<c:out value="${vo}"/>"><c:out value="${vo}"/></th>
                  		</c:forEach>
                	</tr>
                </thead>
                <tbody>
                	<c:set var="cnt" value="0"/>
					<c:forEach var="map" items="${list }" varStatus="i">
					<c:if test='${map["gubun"] ne "1"}'>
						<tr>
							<c:set var="cnt" value="${cnt+1 }"/>
								<c:if test='${cnt%2==1 }'>
								<td rowspan="2">
									<c:choose>
										<c:when test='${map["region_id"] eq "DJ"}'>대전</c:when>
										<c:when test='${map["region_id"] eq "GJ"}'>광주</c:when>
										<c:when test='${map["region_id"] eq "DG"}'>대구</c:when>
										<c:otherwise> ${map["region_id"]}</c:otherwise>
									</c:choose>
								</td>
								</c:if>
								<td>
									<c:if test='${map["gubun"] eq "2" }'>기관수</c:if>
									<c:if test='${map["gubun"] eq "3" }'>업무수</c:if>

								</td>
								<c:forEach var="year" items="${yearList }">
			              			<c:set var="year" value="${year}"/>
									<td>
										<input type="hidden" name="regionId" value='${map["region_id"]}'/>
										<input type="hidden" name='stdrYr' value="${year}"/>
										<c:if test='${map["gubun"] eq "2" }'>

											<input type="hidden" name="gubun" value="instt"/>
			    	              			<input type="text" name="rsltInsttQty" id="rsltInsttQty" value="${map[year] }" class="form-control onlyNumber alignR" maxlength="4" title="${year}년도 클라우드 전환 실적"/>
			    	              		</c:if>
			    	              		<c:if test='${map["gubun"] eq "3" }'>
			    	              			<input type="hidden" name="gubun" value="job"/>
			    	              			<input type="text"  name="rsltJobQty" id="rsltJobQty" value="${map[year] }" class="form-control onlyNumber alignR" maxlength="4" title="${year}년도 클라우드 전환 실적"/>
			    	              		</c:if>
									</td>
								</c:forEach>
							</tr>
						</c:if>
                  	</c:forEach>
              	</tbody>
			</table>
		</div><!-- /box-body -->

		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">
		       <button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_goToListPage()"><i class="fa fa-arrow-left"></i></button>
			</div>
			<ul class="pagination">
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertCludCludSwtchGoalRslt.do">
					</c:url>
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장"  onclick="fn_doInsert()"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</div>
		</div>
    </div><!-- /box(목록조회 테이블) -->
</div><!-- /col -->
</form>
<form id="excelForm" name="excelForm" action='<c:url value="selectCludSwtchGoalRsltXlsDown.do"/>'>
</form>
<script>
function fn_excelDown(){
	excelForm.submit();
}
function fn_goToUrl(url){
	location.href=url;
}
function fn_doInsert(rul){
	if(!fn_form_validation('insertForm')){
		return false;
	}
	fn_validate();
	var submitData=[];

	$('#goalTable tbody tr').each(function(){

		$('td:not(:first)',this).each(function(){
			var data={};
			var regionId = $('[name=regionId]',this).val();
			var stdrYr = $('[name=stdrYr]',this).val();
			var goalJobQty = $('[name=goalJobQty]',this).val();
			data.regionId = regionId;
			data.stdrYr = stdrYr;
			data.goalJobQty = goalJobQty;
			$('#rsltTable tbody tr').each(function(){
				$('td:not(:first)',this).each(function(){
			    	if(regionId==$("[name=regionId]",this).val() && stdrYr==$("[name=stdrYr]",this).val()){
						if($('[name=gubun]',this).val()=='instt'){
							data.rsltInstitutionQty = $('[name=rsltInsttQty]', this).val();
						}else if($('[name=gubun]',this).val()=='job'){
							data.rsltJobQty = $('[name=rsltJobQty]', this).val();
						}
					};
				});
			});
			submitData.push(data);
			console.log(data);
		});
	});

	var options = {
			url: '<c:url value="insertCludSwtchGoalRslt.do" />',
			data: JSON.stringify(submitData),
			type: 'POST',
			dataType: 'json',
			contentType:"application/json;charset=UTF-8",
			success: function(result){
				if(result.success){
					jAlert('저장 되었습니다.',fn_goToListPage);

				}else{
					jAlert(result.messageList[0]);
					return;
				}

			},
			beforeSend: function() {},
			error: function(xhr, textStatus, errorThrown){
				//jAlert('오류가 발생하였습니다.');
			}
		};
	$.ajax(options);
}
function fn_validate(){
	var isOK=true;
	$('#goalTable tbody tr').each(function(){
		$('td:not(:first) [name=goalJobQty]',this).each(function(){
			console.log(this.value);
			if( $(this).val()==""){
				var tempInput=$(this);
				jAlert('전환 목표는 필수 입력입니다.',function(){
					$(tempInput).focus();
				});

				isOK=false;
				return false;
			}
		});
	});
	return isOK;
}
function fn_goToListPage(){
	location.href="selectCludSwtchGoalRsltList.do"
}
</script>