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

<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>

<form:form commandName="searchVo" method="get">
<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
</form:form>
<form id="insertForm" onsubmit="return false;">

<div class="col-box-100 detail-col">
		<div class="box detail-list-box">
          <div class="box-header">
            <h3 class="box-title">기관별 전환 현황</h3>
            <div class="box-tools">
               <div class="input-group-box">
		        	<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_addTr()" title="추가">추가</button>
						<button type="button" class="btn btn-sm btn-function" onclick="fn_delTr()" title="삭제">삭제</button>
		        	</div>
		        </div>
            </div>
          </div><!-- /box-header -->
          <div class="box-body no-padding list-body">
              <table class="table table-hover table-vertical table-bordered " id="tableInsttSwtchStte">
              <caption>기관별 전환 현황</caption>
                <colgroup>
                	<col width="80px"/>
                	<col width="300px"/>
                	<col width="150px"/>
                	<col width="*"/>
                </colgroup>
                <thead>
                	<tr>
                		<th>선택</th>
                		<th>기관명</th>
                		<th>전환 업무수</th>
                		<th>주요 전환 사례</th>
                	</tr>
                </thead>
                <tbody>
	                <c:forEach var="vo" items="${list }" varStatus="i">
	                	<tr>
		                	<td onclick="fn_clickDelCheckBox(this);"><input type="checkbox" name="delCheck" title="선택" onclick='fn_clickCheckBox(event);'/></td>
		                	<td>
							<div class="input-group">
								<input type="text" name="institutionNm" id="institutionNm"	class="form-control essential" title="기관" readonly value="${vo.institutionNm }"/>
								<input type="hidden" name="institutionId" id="institutionId"	title="기관" value="${vo.institutionId }"/>
								<div class="input-group-btn"><button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div>
							</div>
						</td>
		                <td>
							<input type="text" name="swtchJobQty" id="swtchJobQty"	title="전환 업무수"	class="form-control essential onlyNumber alignR" maxlength="4" value="${vo.swtchJobQty }"/>
						</td>
						<td>
							<input type="text" name="primeSwtchExam" id="primeSwtchExam"	title="주요 전환 사례"	class="form-control essential " maxlength="1000" value="${vo.primeSwtchExam }"/>
						</td>

	                	</tr>
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
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장"  onclick="fn_doInsert()"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div><!-- /box(목록조회 테이블) -->
</div><!-- /col -->
</form>
<table id="tmplTable" style="display:none">
	<tr>
		<td onclick="fn_clickDelCheckBox(this);"><input type="checkbox" name="delCheck" title="선택" onclick='fn_clickCheckBox(event);'/></td>
       	<td>
			<div class="input-group">
				<input type="text" name="institutionNm" id="institutionNm"	class="form-control essential" title="기관" readonly/>
				<input type="hidden" name="institutionId" id="institutionId"	title="기관"/>
				<div class="input-group-btn"><button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div>
			</div>
		</td>
		<td>
			<input type="text" name="swtchJobQty" id="swtchJobQty"	title="전환 업무수"	class="form-control essential onlyNumber alignR" maxlength="4"/>
		</td>
		<td>
			<input type="text" name="primeSwtchExam" id="primeSwtchExam"	title="주요 전환 사례"	class="form-control essential " maxlength="1000"/>
		</td>
	</tr>
</table>
<script>
$(document).bind('selectInstitution',fn_setInstitution);//부처팝업 function설정

function fn_excelDown(){
	excelForm.submit();
}
function fn_goToUrl(url){
	location.href=url;
}
function fn_goToListPage(){
	location.href="<c:url value='selectInsttSwtchStteList.do'/>";
}
function fn_setInstitution(obj){

	$('[name=institutionId]',clickBtnTr).val(obj.datas.institutionId);
	$('[name=institutionNm]',clickBtnTr).val(obj.datas.institutionNm);
}

var initTr = $('#tmplTable tbody tr:first').clone().html();
function fn_addTr(){
	var tmplTr='<tr>'+initTr+'</tr>';
	$('#tableInsttSwtchStte').prepend(tmplTr);

	$('.onlyNumber').on({
		'focus' : function(){
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 숫자만 입력하세요."
			});
		}
	});
}
function fn_delTr(){
	if($('[name=delCheck]:checked').parents('tr').length==0){
		jAlert('삭제할 행을 선택하시기 바랍니다.');
		return;
	}
	$('[name=delCheck]:checked').parents('tr').remove();
}
var clickBtnTr=null;
function fn_setClickRow(obj){
	clickBtnTr = $(obj).parents('tr');
}

function fn_doInsert(){
	var submitData = [];
	var rowNum=1;
	var isOK=false;
	if($('#tableInsttSwtchStte tbody tr').length==0){
		//jAlert("기관별 전환 현황을 입력하시기 바랍니다.");
		//return;
		isOK=true;
	}

	if(!fn_form_validation('insertForm')){
		return false;
	}
	$('#tableInsttSwtchStte tbody tr').each(function(){
		var data = getContainerData(this);
		isOK = fn_valdate(data,rowNum);
		if(!isOK){
			return false;
		}
		submitData.push(data);
		rowNum++;
	});
	if(!isOK){
		return;
	}
	isOK = fn_checkDup();
	if(!isOK){
		return false;
	}

	var options = {
			url: '<c:url value="insertInsttSwtchStte.do" />',
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
function fn_valdate(data, rowNum){
	if(data.institutionId==""){
		jAlert(rowNum+"행의 기관명을 입력하시기 바랍니다.");
		return false;
	}
	if(data.swtchJobQty==""){
		jAlert(rowNum+"행의 기관 업무수를 입력하시기 바랍니다.");
		return false;
	}
	if(data.primeSwtchExam==""){
		jAlert(rowNum+"행의 주요 전환 사례를 입력하시기 바랍니다.");
		return false;
	}
	return true;
}
function fn_checkDup(){
	var isOK=true;
	var arrInstitutionId=[];

	$('#tableInsttSwtchStte tbody tr').each(function(){
		arrInstitutionId.push($('#institutionId',this).val());
	});
	for(var i=0;i<arrInstitutionId.length; i++){
		for(var j=i+1;j<arrInstitutionId.length; j++){
			if(arrInstitutionId[i]==arrInstitutionId[j]){
				jAlert((i+1)+"행과 "+(j+1)+"행의 데이터가 중복되었습니다.");
				isOK = false;
				return false;
			}
		}
	}
	return isOK;
}
function fn_clickDelCheckBox(obj){
	$('input[type=checkbox]',obj).trigger('click')
}
function fn_clickCheckBox(event){
	event.stopPropagation();
}
function fn_init(){
	if($('#tableInsttSwtchStte tbody tr').length==0){//등록된건이 하나도 없는경우 기본으로 행추가.
		fn_addTr();
	}
}
fn_init();
</script>