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

<script language='javascript' src='/resources/NX_TPKIENT/SettingForClient/spin.js'></script>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">상위 메뉴정보</h3>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-horizon table-layout-fixed" id="testTable">
				<colgroup>
					<col width="100px">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
					<th>부분</td>
					<td>
						<button type="button" class="btn btn-green" onclick="doLoading()">부분적용</button>
					</td>
				</tr>
				<tr>
					<th>전체</td>
					<td>
						<button type="button" class="btn btn-green" onclick="doFillLoading()">전체적용</button>
					</td>
				</tr>
				<tr>
					<th>로딩종료</td>
					<td>
						<button type="button" class="btn btn-green" onclick="doStopLoading()">로딩종료</button>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="col-box-100">
	<div class="box" id="testDiv" style="width: 500px; height: 500px; border:1px solid #000">
		동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
	</div>
</div>

<script type="text/javascript">

function doFillLoading() {
	$.ncmsLoding.startFullScreen();
}

function doLoading() {
	$.ncmsLoding.start($("#testDiv"));
}

function doStopLoading() {
	$.ncmsLoding.remove();
}

</script>