<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<div class="box detail-list-box">
	<!-- box-header -->
	<div class="box-header">
		<h4 class="box-title">스태틱라우터 설정</h4>
		<div class="box-tools">
			<div class="pull-right">
				<menu:authorize>
				<button type="button" class="btn btn-sm btn-function" onclick="fn_insertSRout()" title="추가">추가</button>
				</menu:authorize>
			</div>
		</div>
	</div>
	<div class="box-body no-padding">
	<form id="selectSRoutListFrm" name="selectSRoutListFrm" method="post">
		<input type="hidden" name="bndSeq" value="${vo.bndSeq }" />
		<input type="hidden" name="ipBndSeq" value="${ipBndVo.bndSeq}" />
	<table class="table table-vertical" id="sRoutListTable">
	<caption>스태틱라우터목록 (IP, 서브넷마스크, 게이트웨이)</caption>
			<thead>
				<tr>
					<th>IP</th>
					<th>서브넷마스크</th>
					<th>게이트웨이</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="sRoutListTBody">
				<c:forEach var="vo" items="${list }" varStatus="i">
				<tr>
					<td>
						<input type="text" name="sRoutList[].ipBndAddr" value="${vo.ipBndAddr}" class="form-control onlyIp" maxlength="15" title="Static IP주소"/>
					</td>
					<td>
						<input type="text" name="sRoutList[].subnetMask" value="${vo.subnetMask}" class="form-control onlyIp" maxlength="15" title="Static 서브넷마스크"/>
					</td>
					<td>
						<input type="text" name="sRoutList[].gtwyNm" value="${vo.gtwyNm}" class="form-control onlyIp" maxlength="15" title="Static 게이트웨이"/>
					</td>
					<td>
						<button type="button" class="btn btn-sm btn-function" name="btnDeleteSRout" onclick="fn_deleteSRout(this)" title="삭제">삭제</button>
					<input type="hidden" name="sRoutList[].sRoutSeq" value="${vo.sRoutSeq }" />
					<input type="hidden" name="sRoutList[].bndSeq" value="${vo.bndSeq }" />
					<input type="hidden" name="sRoutList[].ipBndSeq" value="${ipBndVo.bndSeq}" />
					<input type="hidden" name="checkSRoutSeq" value="${vo.sRoutSeq }" />
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
	</div>
	<div class="box-footer clearfix">
		<div class="pull-right">
			<menu:authorize>
			<button type="button" class="btn btn-sm btn-function" onclick="fn_saveSRout()" title="정보저장">정보저장</button>
			</menu:authorize>
		</div>
	</div>
	<div class="box-footer edit-btn-group">
		<c:url var="listUrl" value="selectIpBndList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${(curParam.key ne 'bndSeq') and (curParam.key ne 'searchType')}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div>
</div>
<script type="text/javascript">
var compareRowCnt = 0;
var orignalSeqArr;
makeSRoutClone();

//페이지 이동
function fn_goToUrl(url){
	location.href = url;
}

function makeSRoutClone(){
	orignalSeqArr = new Array();
	$("#sRoutListTable input[name='checkSRoutSeq']").each(function(){
		orignalSeqArr.push((this).value);
	});
}

function fn_inputIpCheckBySRout(ip){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(ip)){
		// split into units with dots '.'
		var parts = ip.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parts[0]) == 0){
			return false;
		}

		for(var i=0; i<parts.length; i++){
			if(i == 0){
				if(parseInt(parts[i]) > 223){
					return false;
				}
			}
			else {
				if(parseInt(parts[i]) > 255){
					return false;
				}
			}
		}
		return true;
	}
	else {
		return false;
	}

}

//fn_form_rename("sRoutList","ipBndAddr,subnetMask,gtwyNm,sRoutSeq,bndSeq");
function input_validation(){
	var checkCnt = $("input[name='sRoutList[].ipBndAddr']").size();
	for( var i=0; i < checkCnt; i++ ) {
		if( !fn_inputIpCheckBySRout($("input[name='sRoutList[].ipBndAddr']").eq(i).val()) ) {
			jAlert("아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].ipBndAddr']").eq(i).focus();
			});
			return false;
		}

		if( !fn_subnetMaskCheck($("input[name='sRoutList[].subnetMask']").eq(i).val()) ) {
			jAlert("서브넷마스크 아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].subnetMask']").eq(i).focus();
			});
			return false;
		}

		if( !fn_inputIpCheck($("input[name='sRoutList[].gtwyNm']").eq(i).val()) ) {
			jAlert("게이트웨이 아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].gtwyNm']").eq(i).focus();
			});
			return false;
		}
	}
	return true;
}

function fn_isSRoutListChangeCheck(){
	change = false;

	var preSRoutListLength = orignalSeqArr.length;
	var sRoutListlength = $("#sRoutListTable input[name='sRoutList[].ipBndAddr']").length;

	if(preSRoutListLength != sRoutListlength){ // 크기가 다르다면 무조건 가상스위치 정보는 변경되었음.
		change = true;
	}
	else { // 크기가 같다면 vrSwtchSeq 비교!
		$.each(orignalSeqArr, function(i, seq){
			var sRoutSeq = seq;
			$.each($("#sRoutListTable input[name='checkSRoutSeq']"), function(index, item){
				if($(item).val() == sRoutSeq){
					compareRowCnt++;
				}
			});
		});
		if(compareRowCnt != preSRoutListLength){
			change = true;
		}
		else { // 정보비교
			for(var i=0; i < compareRowCnt; i++){
				if($("input[name='sRoutList[].ipBndAddr']").eq(i).val() != $("input[name='sRoutList[].ipBndAddr']")[i].defaultValue){
					change = true;
				}

				if($("input[name='sRoutList[].subnetMask']").eq(i).val() != $("input[name='sRoutList[].subnetMask']")[i].defaultValue){
					change = true;
				}

				if($("input[name='sRoutList[].gtwyNm']").eq(i).val() != $("input[name='sRoutList[].gtwyNm']")[i].defaultValue){
					change = true;
				}
			}
		}
	}
	compareRowCnt = 0;
	return change;

}

function fn_saveSRout(){
	if(!input_validation()){
		return;
	}

	if(!fn_isSRoutListChangeCheck()){
		jAlert("변경된 정보가 존재하지 않습니다.");
		return;
	}

	jConfirm('위의 정보로 저장 하시겠습니까?', function() {
		fn_form_rename("sRoutList", "ipBndAddr,subnetMask,gtwyNm,sRoutSeq,bndSeq,ipBndSeq");

		var options = {
			type : 'post',
			dataType : 'json',
			success : fn_successHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				jAlert('정보저장 중 오류 발생');
			}
		};

		$('#selectSRoutListFrm').attr("action", "updateSRoutList.do");
		$('#selectSRoutListFrm').ajaxSubmit(options);
	});
}

function fn_successHandler(result){
	if (result.success) {
		jInfo("스태틱 라우터 정보 수정에 성공하였습니다.");
	} else {
		jAlert(result.messageList);
	}
}

function fn_insertSRout() {
	// IP대역정보에 게이트웨이 정보가 입력되어 있으면 설정할 수 없다.
	var gwIpAddrLength = ${gwIpAddrLength};
	if(${gwIpAddrLength} > 0){
		jAlert("게이트웨이 정보가 입력된 상황에서는 스태틱라우터 설정을 할 수 없습니다.");
		return;
	}

	// row가 1개도 없을 경우에는 "검색된 결과 없음" row 삭제한 후에 추가해줄 것
	var length = $("#sRoutListTable input[name='sRoutList[].ipBndAddr']").length;
	if(length == 0){
		$("#sRoutListTable tr td").remove();
	}

	// 행 추가 한다.
	var html = null;
	var bndSeq = ${ipBndVo.bndSeq};
	html = '<tr>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].ipBndAddr" class="form-control" value="" maxlength="16" title="IP대역"/>'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].subnetMask" class="form-control" value="" maxlength="16" title="NetMask"/>'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].gtwyNm" class="form-control" value="" maxlength="16" title="Gateway"/>'
			+ '</td>'
			+ '<td>'
			+ '<button type="button" class="btn btn-sm btn-function" name="btnDeleteSRout" onclick="fn_deleteSRout(this)">삭제</button>'
			+ '</td>'
			+ '<input type="hidden" name="sRoutList[].bndSeq" value="'+bndSeq+'" />'
			+ '</tr>';
	$("#sRoutListTable tbody").append(html);
}

// Static Router 삭제
function fn_deleteSRout(obj) {
	var tr = $(obj).parent().parent();
	tr.remove();
}

$("#sRoutListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "600px" },
	               {sWidth : "600px" },
	               {sWidth : "600px" },
	               {sWidth : "200px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>