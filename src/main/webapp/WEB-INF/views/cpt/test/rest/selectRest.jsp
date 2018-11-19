<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">상위 메뉴정보</h3>
<!-- 			<div class="box-tools"> -->
<!-- 				<div class="pull-right"> -->
<!-- 					<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="수정하기"><i class="fa fa-font"></i></button> -->
<!-- 					<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드"><i class="fa fa-download"></i></button> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>기본</th>
					<td>
						<button class="btn btn-get">GET</button>
					    <button class="btn btn-post">POST</button>
					    <button class="btn btn-put">PUT</button>
					    <button class="btn btn-delete">DELETE</button>
					</td>
				</tr>
				<tr>
					<th>nTOPS 통신</th>
					<td>
						<button class="btn btn-ntops">GET</button>
					</td>
				</tr>
				<tr>
					<th>SWAGGER 연동</th>
					<td>
						<button class="btn btn-machines-list">/machines</button>
						<button class="btn btn-machines">/machines?manerId=RHEV-01</button>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$(".btn-get").on('click', function(){

	$.post("selectRest.do", {"sendType":"GET"}, function(result) {
		console.log( result );
	}, "json");

});

$(".btn-post").on('click', function(){

	$.post("selectRest.do", {"sendType":"POST"}, function(result) {
		console.log( result );
	}, "json");

});

$(".btn-put").on('click', function(){

	$.post("selectRest.do", {"sendType":"PUT"}, function(result) {
		console.log( result );
	}, "json");

});

$(".btn-delete").on('click', function(){

	$.post("selectRest.do", {"sendType":"DELETE"}, function(result) {
		console.log( result );
	}, "json");

});

$(".btn-ntops").on('click', function(){

	console.log("Aaaaa");

	$.post("selectNtops.do", function(result) {
		console.log( result );
	}, "json");

});

$(".btn-machines-list").on('click', function(){

	$.post("selectMachineList.do", function(result) {
		console.log( result );
	}, "json");

});

$(".btn-machines").on('click', function(){

	$.post("selectMachine.do", function(result) {
		console.log( result );
	}, "json");

});
</script>