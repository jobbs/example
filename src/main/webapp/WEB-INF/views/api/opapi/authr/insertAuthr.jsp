<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이제율         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<div class="col-box-100 detail-col">
	<form:form commandName="vo" method="post">
		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(목록조회 테이블) -->
		<div class="box">
			<div class="box-body no-padding">
				<table class="table table-horizon">
				<caption>OpenAPI권한관리</caption>
					<colgroup>
						<col class="col20">
						<col class="colAuto">
					</colgroup>
				<tbody>
					<tr>
						<th><label for="authrNm"><span class="text-red">*</span>권한명</label></th>
						<td>
							<form:input path="authrNm" type="text" title="권한명" class="form-control essential" maxlength="60"/>
						</td>
					</tr>
					<tr>
						<th colspan="2"><span class="text-red">*</span>API 매핑</th>
                   	</tr>
                   	<tr>
                   		<td colspan="2">
							<!-- 셔틀 영역 -->
							<div class="suttle-box suttle-horizon" style="min-height: 300px">
								<div class="col-cell-45 no-padding">
									<div class="box">
										<div class="box-header">
											<h3 class="box-title">미할당 OpenAPI</h3>
											<div class="box-tools input-group-box">
												<div class="input-group-cell pad-right-5">
													<div class="input-group">
													</div>
												</div>
												<div class="input-group-cell">
													<div class="input-group">
														<input type="text" name="searchNm" id="searchNm" title="검색" class="form-control input-sm" >
														<div class="input-group-btn">
															<button  type="button" class="btn btn-sm" onclick="fn_searchUser();return false;"><i class="fa fa-search"></i></button>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="box-body no-padding" style="max-height: 250px; min-height: 30px; overflow-y: auto; overflow-X: hidden;">
											<table class="table table-hover table-vertical" id="searchTable">
											<caption>OpenAPI권한관리</caption>
												<colgroup>
													<col class="col5">
													<col class="colAuto">
												</colgroup>
												<thead>
													<tr>
														<th></th>
														<th>OpenAPI</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td colspan="2">검색된 데이터가 없습니다.</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<!-- 이동 버튼 -->
								<div class="col-cell-10 no-padding suttle-btns">
									<div class="suttle-button" id="suttle-button1">
										<div class="btn-group-vertical">
											<button type="button" class="btn" onclick="fn_allRight()"><i class="fa fa-angle-double-right"></i></button>
											<button type="button" class="btn" onclick="fn_right()"><i class="fa fa-angle-right"></i></button>
											<button type="button" class="btn" onclick="fn_left()"><i class="fa fa-angle-left"></i></button>
											<button type="button" class="btn" onclick="fn_allLeft()"><i class="fa fa-angle-double-left"></i></button>
										</div>
									</div>
								</div>

								<div class="col-cell-45 no-padding">
									<div class="box">
										<div class="box-header">
											<h3 class="box-title">할당 OpenAPI</h3>
										</div>
										<div class="box-body no-padding" style="max-height: 250px; min-height: 30px; overflow-y: auto; overflow-X: hidden;">
											<table class="table table-hover table-vertical"  id="dspthTable">
											<caption>OpenAPI권한관리</caption>
												<colgroup>
													<col class="col5" style="height:100px;">
													<col class="colAuto">
												</colgroup>
												<thead>
												<tr>
													<th></th>
													<th>OpenAPI</th>
												</tr></thead>
												<tbody id="targetTbody">
													<tr>
														<td colspan="2">검색된 데이터가 없습니다.</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
                   		</td>
                   	</tr>
                 		<tr>
                 			<th><label for="dc">설명</label></th>
                 			<td><form:textarea id="dc" path="dc" class="form-control" rows="3" title="설명"/></td>
             			</tr>
               		</tbody>
           		</table>
       		</div><!-- /box-body -->
       		<div class="box-footer clearfix">
       			<div class="pull-right">
   				</div>
			</div><!-- /box-footer -->
		</div><!-- /box -->
	</form:form>
</div>

<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
    <div class="edit-btn-group">
        <div class="pull-left btns">
        	<button type="button" class="btn btn-hover-gray" data-toggle="tooltip"
        		data-original-title="뒤로" onclick="goToUrl('selectAuthrList.do')"><i class="fa fa-arrow-left"></i>
        	</button>
        </div>
        <div class="pull-right btns">
        	<button type="button" class="btn btn-hover-green" data-toggle="tooltip"
        		data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i>
        	</button>
        </div>
    </div>
    <!-- /page-btn-group -->
</div>

<script type="text/javascript">
$(document).ready(function(){
	fn_searchUser();
});

// OpenApi조회
function fn_searchUser(){
	$.ncmsLoding.startFullScreen();
	$.post(	'<c:url value="/api/opapi/authr/selectOpenApiList.do"/>',
			{
			 "searchNm": $('#searchNm').val()
			},
			function(result) {
				if( result.success) {
					$('#searchTable tbody').empty();
					var len = result.data.length;
					var str="";
					var eqChk = true;
					if(len>0){
						for(var i=0; len>i; i++){
							$("input:checkbox[name='apiMapng']").each(function(){
								if ((result.data[i].opApiId+ "&" + result.data[i].uri) == $(this).val()) {
									eqChk = false;
								}
							});
							if(eqChk){
								str+="<tr onclick='fn_checkUser(this)'>"+
								"<td><input type='checkbox' name='opApiUri' title='항목선택' alt='"+result.data[i].uri+"' value='"+result.data[i].opApiId+"&"+result.data[i].uri+"' /></td>"+
								"<td>"+result.data[i].uri+"</td></tr>";
							}
							eqChk = true;
						}
					}else{
						str="<tr><td colspan='2'>검색된 데이터가 없습니다.</td></tr>"
					}
					$('#searchTable tbody').html(str);
				}
			}, "json").always(function() {
				$.ncmsLoding.remove();
			 });

	return false;
}

function fn_checkUser(tr){
	$(':checkbox',$(tr)).trigger('click');
}


// 이동
function fn_allRight(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#dspthTable').length==0 &&$('input:checkbox','#searchTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#dspthTable tbody').empty();
	}
	$('input:checkbox','#searchTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#dspthTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});
		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" alt="'+$(this).attr("alt")+'" name="apiMapng" title="항목선택" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#dspthTable tbody').append(html);

			$(this).parent().parent().remove();
		}
		this.checked=false;
	});
}
function fn_right(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#dspthTable').length==0 &&$('input:checkbox','#searchTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#dspthTable tbody').empty();
	}
	$('input:checkbox:checked','#searchTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#dspthTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});

		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" alt="'+$(this).attr("alt")+'" name="apiMapng" title="항목선택" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#dspthTable tbody').append(html);
		}

		$(this).parent().parent().remove();

		this.checked=false;
	});
}
function fn_left(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#searchTable').length==0 &&$('input:checkbox','#dspthTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#searchTable tbody').empty();
	}
	$('input:checkbox:checked','#dspthTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#searchTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});
		if(isOK){

			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" alt="'+$(this).attr("alt")+'" name="opApiUri" title="항목선택" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#searchTable tbody').append(html);

		}

		$(this).parent().parent().remove();

		this.checked=false;
	});
}
function fn_allLeft(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#searchTable').length==0 &&$('input:checkbox','#dspthTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#searchTable tbody').empty();
	}
	$('input:checkbox','#dspthTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#searchTable').each(function(){

			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});
		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" alt="'+$(this).attr("alt")+'" name="opApiUri" title="항목선택" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#searchTable tbody').append(html);

			$(this).parent().parent().remove();
		}
		this.checked=false;
	});
}

// 저장
function doSubmit(result){
	// api 매핑여부 체크
	var checked = 0;

	$("input[name='apiMapng']").each(function() {
		// 존재하는 모든 checkbox checked
		$("input:checkbox[name='apiMapng']").prop("checked",true);
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		parent.jAlert("API 매핑대상을 선택하시기 바랍니다.");
		return;
	}

	// 입력 validation 체크
	if(!fn_form_validation("vo")){
		return;
	}

	jConfirm('OpenApi권한을 저장하시겠습니까?', function(){
		// 호출
		$.ncmsLoding.startFullScreen();
		$.post('insertAuthr.do', $('#vo').serialize(), fn_pageMove, 'json').always(function() { $.ncmsLoding.remove(); });
	});
}

// 콜백 / 화면이동
function fn_pageMove(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert") {
				location.href = "selectAuthrList.do";
			}
		}
	}, (result.success?"INFO":""));
}
</script>