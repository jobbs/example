<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 4.
 * @lastmodified 2016. 12. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 4.     양정순         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">가상서버 생성 가용량</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_doDelete()" title="삭제">삭제</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body" style="overflow: hidden;">
			<table class="table table-hover table-vertical" id="useFulTable">
				<caption>가상서버 생성 가용량</caption>
				<colgroup>
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="col10">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">망</th>
						<th rowspan="2">자원풀코드</th>
						<th rowspan="2">클러스터</th>
						<th colspan="2">보유량</th>
						<th colspan="2">최대 할당률</th>
						<th colspan="2">최대 할당량</th>
						<th colspan="2">현재 할당량</th>
						<th colspan="2">여유량</th>
						<th colspan="2">가상서버<br>평균사양
						</th>
						<th rowspan="2">가상서버<br>할당가능수량
						</th>
						<th rowspan="2"></th>
					</tr>
					<tr>
						<th>Core</th>
						<th>MEM</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>vCore</th>
						<th>MEM</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="tempNet" value="" />
					<c:set var="tempPool" value="" />
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="17">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<c:if test="${tempNet != vo.netNm }">
										<c:set var="tempNet" value="${vo.netNm }" />
										<td
											<c:if test="${vo.netCnt >1 }"> rowspan="<c:out value="${vo.netCnt }" />" </c:if> class="alignL"><c:out value="${vo.netNm}" /></td>
									</c:if>

									<c:if test="${tempPool != vo.rsrcPoolNm }">
										<c:set var="tempPool" value="${vo.rsrcPoolNm }" />
										<td
											<c:if test="${vo.rsrcPoolIdCnt >1 }"> rowspan="<c:out value="${vo.rsrcPoolIdCnt }" />" </c:if> class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
									</c:if>
									<input type="hidden" name="regionId" id="regionId" value="${vo.regionId}" title="리전ID" />
									<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" value="${vo.rsrcPoolId}" title="자원ID" />
									<input type="hidden" name="clstrUuid" id="clstrUuid" value="${vo.clstrUuid}" title="클러스터UUID" />

									<td class="alignL"><c:out value="${vo.clstrUuid}" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastCpuCorQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" /></td>
									<td class="alignR"><input type="text" name="maxVcoreAsgnRt" class="col55 alignR essential onlyFloat" title="vCore 최대 할당률" maxlength="7" value="<fmt:formatNumber value="${vo.maxVcoreAsgnRt}" pattern="#,###.#" />">%</td>
									<td class="alignR"><input type="text" name="maxMemAsgnRt" class="col55 alignR essential onlyFloat" title="MEM 최대 할당률" maxlength="7" value="<fmt:formatNumber value="${vo.maxMemAsgnRt}" pattern="#,###.#" />">%</td>
									<td class="alignR"><fmt:formatNumber value="${vo.maxVcoreAsgn}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.maxMemAsgn}" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnVcorQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnMemCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.marginVcoreCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.marginMemCapa}" pattern="#,###" /></td>
									<td class="alignR"><input type="text" name="vmVcoreAvgSpec" class="col55 alignR essential onlyFloat" title="vCore 가상서버 평균사양" maxlength="5" value="<fmt:formatNumber value="${vo.vmVcoreAvgSpec}" pattern="#,###" />"></td>
									<td class="alignR"><input type="text" name="vmMemAvgSpec" class="col55 alignR essential onlyFloat" title="MEM 가상서버 평균사양" maxlength="5" value="<fmt:formatNumber value="${vo.vmMemAvgSpec}" pattern="#,###" />"></td>
									<td class="alignR"><c:out value="${vo.vmAsgnQty}" /></td>
									<td><input type="checkbox" name="delCheck" title="선택" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>


		</div>
		<!-- /box-body -->
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_goToListPage()">
					<i class="fa fa-arrow-left"></i>
				</button>
			</div>
			<div class="pull-right btns">
				<menu:authorize>
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_doInsert()">
						<i class="fa fa-check"></i>
					</button>
				</menu:authorize>

			</div>

			<ul class="pagination"></ul>
		</div>

	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->


<script type="text/javascript">


function fn_goToListPage(){
	location.href='<c:url value="selectUsefulList.do" />';

}


//조회버튼 클릭시.
function fn_search() {
	//debugger;
	if(!fn_form_validation("searchVo")){

		return;
	}
	searchVo.action='<c:url value="selectUsefulList.do" />';
	searchVo.submit();


}

function fn_excelDown(){
	if(${list eq null or empty list}) {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	searchVo.action='<c:url value="selectUsefulXlsDown.do" />';
	searchVo.submit();

}

function fn_doInsert(){

	var submitData = [];
	var rowNum=1;
	var isOK=false;

	//if(!fn_form_validation('insertForm')){
		//return false;
	//}
	$('#useFulTable tbody tr').each(function(){
		var data = getContainerData(this);

		if(data.maxVcoreAsgnRt != ""){
			isOK = fn_valdate(data,rowNum);
			if(!isOK){
				return false;
			}
			data['ym']=${searchVo.year}${searchVo.mm};
			submitData.push(data);

		}

		rowNum++;
		console.log($('#useFulTable tbody tr').length);
		//console.log(rowNum)
	});
	if(!isOK){
		return;
	}
	//isOK = fn_checkDup();
	if(!isOK){
		return false;
	}
	console.log(JSON.stringify(submitData));
	jConfirm("내용을 저장하시겠습니까?", function() {
		var options = {
				url: '<c:url value="insertUseful.do" />',
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
	});
}


function fn_doDelete(){
	if($('[name=delCheck]:checked').parents('tr').length==0){
		jAlert('삭제할 행을 선택하시기 바랍니다.');
		return;
	}

	var submitData = [];
	var isOK=true;

   $('#useFulTable tbody tr').each(function(index){
	   var data={};
    	//console.log($(this).prop("checked") );
    	if($("input:checkbox[name=delCheck]").eq(index).prop('checked')){

    		//console.log($("input:checkbox[name=delCheck]").eq(index).prop("checked") );

    		//console.log($("select[name=quarter]").eq(index).val() );
    		//sconsole.log("rsrcPoolId"+$("input[name=rsrcPoolId]").eq(index).val() );
    		if($("input[name=maxVcoreAsgnRt]").eq(index).val()=="" ){
    			jAlert(index+1+"행의 vCore 최대 할당률을 입력하시기 바랍니다.");
    			isOK = false;
    			return false;
    		}

    		data["ym"] = ${searchVo.year}${searchVo.mm};
    		data["rsrcPoolId"] = $("input[name=rsrcPoolId]").eq(index).val();
    		data["clstrUuid"] = $("input[name=clstrUuid]").eq(index).val();

    		submitData.push(data);
    	}
	});

   console.log(JSON.stringify(submitData));
   if(!isOK){
		return false;
	}
	//$('[name=year]','#searchVo').val($('#stdrYr').val());
	//$('[name=quarter]','#searchVo').val($('#quarter').val());
	jConfirm("가상서버 생성 가용량을 삭제 하시겠습니까?", function() {
	var options = {
			url: '<c:url value="deleteUseful.do" />',
			data: JSON.stringify(submitData),
			type: 'POST',
			dataType: 'json',
			contentType:"application/json;charset=UTF-8",
			success: function(result){
				if(result.success){
					jAlert('삭제 되었습니다.',fn_goToListPage);

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

	});
}


function fn_valdate(data, rowNum){
	if(data.maxVcoreAsgnRt==""){
		jAlert(rowNum+"행의 vCore 최대 할당률을 입력하시기 바랍니다.");
		return false;
	}
	if(data.maxMemAsgnRt==""){
		jAlert(rowNum+"행의 MEM 최대 할당률을 입력하시기 바랍니다.");
		return false;
	}
	if(data.vmVcoreAvgSpec==""){
		jAlert(rowNum+"헹의 vCore 가상서버 평균사양을 입력하시기 바랍니다.");
		return false;
	}
	if(data.vmMemAvgSpec==""){
		jAlert(rowNum+"행의 MEM 가상서버 평균사양을 입력하시기 바랍니다.");
		return false;
	}
	return true;
}


function goToUrl(url) {
	location.href = url;
}

</script>

