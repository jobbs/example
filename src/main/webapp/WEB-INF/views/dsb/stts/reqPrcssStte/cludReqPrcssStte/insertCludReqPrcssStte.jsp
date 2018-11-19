<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 09. 29.
 * @lastmodified 2016. 09. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 29.     양정순         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<form id="insertForm">
<div class="col-box-100 detail-col">
  <div class="box detail-list-box">
    <div class="box-header">
		<h3 class="box-title">요청처리 상세 현황</h3>
		<div class="box-tools">
        	<div class="input-group-box">
		    	<div class="input-group-cell pad-right">
				   	<button type="button" class="btn btn-sm btn-function" onclick="fn_addTr()" title="추가">추가</button>
				   	<button type="button" class="btn btn-sm btn-function" onclick="fn_delTr()" title="삭제">삭제</button>
				</div>
		    </div>
    	</div>
    </div>
    <div class="box-body no-padding list-body">
      <table class="table table-vertical table-hover" id="tableInsttReqPrcss">
      	<caption>클라우드 요청 처리 현황</caption>
      	<colgroup>
      		<col class="col5">
      		<col class="col20">
      		<col class="col15">
      		<col class="col20">
      		<col class="col20">
      		<col class="col20">
      	</colgroup>
        <thead>
          <tr>
          	<th></th>
            <th>년도</th>
            <th>월</th>
            <th>자원풀</th>
            <th>기관</th>
            <th>SAN 회수</th>
          </tr>
        </thead>
        <tbody>
        <c:choose>
        	<c:when test="${not empty list}">
	        	<c:forEach var="vo" items="${list}" varStatus="i">
					<tr>
						<td onclick="fn_clickDelCheckBox(this)"><input type="checkbox" name="delCheck" title="선택" onclick='fn_clickCheckBox(event);'/></td>
						<td><select name="yy" id="yy" class="form-control input-sm" title="년도" disabled>
							<c:forEach var="yearVo" items="${yearCdList }">
								<option value="${yearVo.cd}" <c:if test='${yearVo.cd eq vo.yy}'>selected</c:if>><c:out value="${yearVo.cdNm }"/></option>
							</c:forEach>
						</select></td>
						<td>
							<select id="mm" name="mm" class="form-control input-sm" disabled title="월">
								<option value="01" <c:if test='${"01" eq vo.mm}'>selected</c:if>>1월</option>
								<option value="02" <c:if test='${"02" eq vo.mm}'>selected</c:if>>2월</option>
								<option value="03" <c:if test='${"03" eq vo.mm}'>selected</c:if>>3월</option>
								<option value="04" <c:if test='${"04" eq vo.mm}'>selected</c:if>>4월</option>
								<option value="05" <c:if test='${"05" eq vo.mm}'>selected</c:if>>5월</option>
								<option value="06" <c:if test='${"06" eq vo.mm}'>selected</c:if>>6월</option>
								<option value="07" <c:if test='${"07" eq vo.mm}'>selected</c:if>>7월</option>
								<option value="08" <c:if test='${"08" eq vo.mm}'>selected</c:if>>8월</option>
								<option value="09" <c:if test='${"09" eq vo.mm}'>selected</c:if>>9월</option>
								<option value="10" <c:if test='${"10" eq vo.mm}'>selected</c:if>>10월</option>
								<option value="11" <c:if test='${"11" eq vo.mm}'>selected</c:if>>11월</option>
								<option value="12" <c:if test='${"12" eq vo.mm}'>selected</c:if>>12월</option>
							</select>
						</td>
						<td>
							<div class="input-group">
								<input type="text" name="rsrcPoolNm" id="rsrcPoolNm"	class="form-control essential" value="${vo.rsrcPoolNm}" readonly title="자원풀"/>
								<input type="hidden" name="rsrcPoolId" id="rsrcPoolId"	value="${vo.rsrcPoolId}" title="자원ID"/>
								<!-- <div class="input-group-btn"><button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div> -->
							</div>
						</td>
						<td>
							<div class="input-group">
								<input type="text" name="institutionNm" id="institutionNm"	class="form-control essential" value="${vo.institutionNm}" title="기관명" readonly/>
								<input type="hidden" name="institutionId" id="institutionId"	value="${vo.institutionId}" title="기관ID"/>
								<div class="input-group-btn"><button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div>
							</div>
						</td>
						<td>
							<input type="text" name="withdrawQty" id="withdrawQty"	title="SAN 회수"	class="form-control essential onlyNumber alignR"  value="${vo.withdrawQty }" maxlength="4"/>
						</td>
					</tr>
		        </c:forEach>
        	</c:when>
        	<c:otherwise>
	        	<tr>
					<td onclick="fn_clickDelCheckBox(this)"><input type="checkbox" name="delCheck" title="선택" onclick='fn_clickCheckBox(event);'/></td>
					<td>
						<select name="yy" id="yy" class="form-control input-sm" title="년도" <c:if test='${cmd eq "U" }'>disabled</c:if>>
							<c:forEach var="yearVo" items="${yearCdList }" >
								<option value="${yearVo.cd}" <c:if test='${cmd eq "U" and yearVo.cd eq vo.yy}'>selected</c:if>><c:out value="${yearVo.cdNm }"/></option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select id="mm" name="mm" class="form-control input-sm" title="월" <c:if test='${cmd eq "U" }'>disabled</c:if>>
							<option value="01" <c:if test='${cmd eq "U" and "01" eq vo.mm}'>selected</c:if>>1월</option>
							<option value="02" <c:if test='${cmd eq "U" and "02" eq vo.mm}'>selected</c:if>>2월</option>
							<option value="03" <c:if test='${cmd eq "U" and "03" eq vo.mm}'>selected</c:if>>3월</option>
							<option value="04" <c:if test='${cmd eq "U" and "04" eq vo.mm}'>selected</c:if>>4월</option>
							<option value="05" <c:if test='${cmd eq "U" and "05" eq vo.mm}'>selected</c:if>>5월</option>
							<option value="06" <c:if test='${cmd eq "U" and "06" eq vo.mm}'>selected</c:if>>6월</option>
							<option value="07" <c:if test='${cmd eq "U" and "07" eq vo.mm}'>selected</c:if>>7월</option>
							<option value="08" <c:if test='${cmd eq "U" and "08" eq vo.mm}'>selected</c:if>>8월</option>
							<option value="09" <c:if test='${cmd eq "U" and "09" eq vo.mm}'>selected</c:if>>9월</option>
							<option value="10" <c:if test='${cmd eq "U" and "10" eq vo.mm}'>selected</c:if>>10월</option>
							<option value="11" <c:if test='${cmd eq "U" and "11" eq vo.mm}'>selected</c:if>>11월</option>
							<option value="12" <c:if test='${cmd eq "U" and "12" eq vo.mm}'>selected</c:if>>12월</option>
						</select>
					</td>
					<td>
						<div class="input-group">
							<input type="text" name="rsrcPoolNm" id="rsrcPoolNm"		class="form-control essential" title="자원풀" readonly <c:if test='${cmd eq "U" }'>value='<c:out value="${searchVo.rsrcPoolNm}"/>'</c:if>/>
							<input type="hidden" name="rsrcPoolId" id="rsrcPoolId"	title="자원풀" <c:if test='${cmd eq "U" }'> value='<c:out value="${searchVo.rsrcPoolId }"/>'</c:if>/>
							<c:if test='${cmd ne "U" }'>
								<div class="input-group-btn"><button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div>
							</c:if>
						</div>
					</td>
					<td>
						<div class="input-group">
							<input type="text" name="institutionNm" id="institutionNm"	class="form-control essential" title="기관" readonly/>
							<input type="hidden" name="institutionId" id="institutionId"	title="기관"/>
							<div class="input-group-btn"><button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div>
						</div>
					</td>
					<td>
						<input type="text" name="withdrawQty" id="withdrawQty"	title="SAN 회수"	class="form-control essential onlyNumber alignR" maxlength="4"/>
					</td>
				</tr>
        	</c:otherwise>
        </c:choose>
        </tbody>
      </table>

    </div><!-- /box-body -->

  </div><!-- /box -->
</div><!-- /col -->
</form>
<div class="col-box-100">
	  <div class="edit-btn-group">
	      <div class="pull-left btns">
	        <button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_goToListPage()"><i class="fa fa-arrow-left"></i></button>
	      </div>
	     <div class="pull-right btns">
	     	<menu:authorize>
	     		<c:if test='${cmd eq "I"}'>
	      			<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="등록"  onclick="fn_doInsert()"><i class="fa fa-check"></i></button>
	      		</c:if>
	      	</menu:authorize>
	      	<menu:authorize>
	      		<c:if test='${cmd eq "U"}'>
	      			<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="fn_doUpdate()"><i class="fa fa-eraser"></i></button>
	      		</c:if>
	      	</menu:authorize>
	      </div>
	  </div>
</div>


<form:form commandName="searchVo" method="get">

   <form:hidden path="ym"/>
   <input type="hidden" name="yy"/>
   <input type="hidden" name="mm"/>
   <form:hidden path="year"/>
   <form:hidden path="trm"/>
   <form:hidden path="institutionId"/>

   <form:hidden path="rsrcPoolId"/>

</form:form>
<script type="text/javascript">

$(document).bind('selectPool',fn_setRsrcPoolId);//부처팝업 function설정
$(document).bind('selectInstitution',fn_setInstitution);//부처팝업 function설정
//목록조회 페이지로 이동
function fn_goToListPage(){

		location.href = "selectCludReqPrcssStteList.do";


}
function fn_setRsrcPoolId(obj){
	$('[name=rsrcPoolId]',clickBtnTr).val(obj.datas.rsrcPoolId);
	$('[name=rsrcPoolNm]',clickBtnTr).val(obj.datas.rsrcPoolNm);
}
function fn_setInstitution(obj){

	$('[name=institutionId]',clickBtnTr).val(obj.datas.institutionId);
	$('[name=institutionNm]',clickBtnTr).val(obj.datas.institutionNm);
}
//var initTr = $('#tableInsttReqPrcss tbody tr:first').clone().html();
var initTr = $('#tableInsttReqPrcss tbody tr:first').clone().html();

function fn_addTr(){
	var tmplTr='<tr>'+initTr+'</tr>';

	$('#tableInsttReqPrcss').prepend(tmplTr);
	$('[name=institutionNm]','#tableInsttReqPrcss tbody tr:first').val("");//추가한 행의 기관명 삭제
	$('[name=institutionId]','#tableInsttReqPrcss tbody tr:first').val("");//추가한 행의 기관ID 삭제
	$('[name=withdrawQty]'  ,'#tableInsttReqPrcss tbody tr:first').val("");//추가한 행의 기관ID 삭제
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
	if($('#tableInsttReqPrcss tbody tr').length==0){
		jAlert("요청처리 현황을 입력하시기 바랍니다.");
		return;
	}

	if(!fn_form_validation('insertForm')){
		return false;
	}
	$('#tableInsttReqPrcss tbody tr').each(function(){
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



	//jConfirm("요청처리 현황을 저장하시겠습니까?", function() {
		var options = {
				url: '<c:url value="insertCludReqPrcssStte.do" />',
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
	//});
}
function fn_doDelete(){
	$('[name=yy]','#searchVo').val($('#year').val());
	$('[name=mm]','#searchVo').val($('#ym').val());
	var options = {
			url: '<c:url value="deleteCludReqPrcssStte.do" />',
			type: 'POST',
			dataType: 'json',
			//contentType:"application/json;charset=UTF-8",
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
	$("#searchVo").ajaxSubmit(options);
}
function fn_doUpdate(){
	if($('#tableInsttReqPrcss tbody tr').length==0){
		fn_doDelete();
		return;

	}
	var submitData = [];
	var rowNum=1;
	var isOK=false;

	$('#tableInsttReqPrcss tbody tr').each(function(){
		var data = getContainerData(this);
		isOK = fn_valdate(data,rowNum);
		if(!isOK){
			return false;
		}
		isOK = fn_checkDup();
		if(!isOK){
			return false;
		}
		submitData.push(data);
		rowNum++;
	});
	if(!isOK){
		return;
	}

	//jConfirm("요청처리 현황을 저장하시겠습니까?", function() {
		var options = {
				url: '<c:url value="updateCludReqPrcssStte.do" />',
				data: JSON.stringify(submitData),
				type: 'POST',
				dataType: 'json',
				contentType:"application/json;charset=UTF-8",
				success: function(result){
					if(result.success){
						jAlert('수정 되었습니다.',fn_goToListPage);

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
	//});
}
function fn_valdate(data, rowNum){
	if(data.rsrcPoolId==""){
		jAlert(rowNum+"행의 자원풀을 입력하시기 바랍니다.");
		return false;
	}
	if(data.institutionId==""){
		jAlert(rowNum+"행의 기관을 입력하시기 바랍니다.");
		return false;
	}
	if(data.withdrawQty==""){
		jAlert(rowNum+"행의 SAN 회수를 입력하시기 바랍니다.");
		return false;
	}
	return true;
}
function fn_checkDup(){
	var isOK=true;
	var arrYear=[];
	var arrMon=[];
	var arrRsrcPoolId=[];
	var arrInstitutionId=[];
	$('#tableInsttReqPrcss tbody tr').each(function(){
		arrYear.push($('#yy',this).val());
		arrMon.push($('#mm',this).val());
		arrRsrcPoolId.push($('#institutionId',this).val());
		arrInstitutionId.push($('#rsrcPoolId',this).val());
	});
	for(var i=0;i<arrYear.length; i++){
		for(var j=i+1;j<arrYear.length; j++){
			if(arrYear[i]==arrYear[j] && arrMon[i]==arrMon[j]&&arrRsrcPoolId[i]==arrRsrcPoolId[j]&&arrInstitutionId[i]==arrInstitutionId[j]){
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
</script>
