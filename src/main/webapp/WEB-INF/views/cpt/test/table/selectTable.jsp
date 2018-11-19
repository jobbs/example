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

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">상위 메뉴정보</h3>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-horizon table-layout-fixed" id="testTable">
				<%-- <colgroup>
					<col width="100px">
					<col width="*">
					<col width="150px">
					<col width="200px">
					<col width="200px">
				</colgroup> --%>
				<thead>
				<tr>
					<th class="ellipsis">엄청나게 긴 컬럼1</th>
					<th class="ellipsis">컬럼2</th>
					<th class="ellipsis">컬럼3</th>
					<th class="ellipsis">엄청길게 컬럼4</th>
					<th class="ellipsis">컬럼5</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td class="ellipsis">컬럼1값</td>
					<td class="ellipsis">컬럼2값</td>
					<td class="ellipsis">컬럼3값</td>
					<td class="ellipsis">컬럼4값</td>
					<td class="ellipsis">컬럼5값</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$("#testTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	scrollX : true,
	fnHeaderCallback : function() {
		console.log("Header....");
	},
	fnPreDrawCallback : function() {
		console.log("Pre Draw....");
	},
	fnRowCallback : function() {
		console.log("Row....");
	},
	colResize : {
		resizeCallback : function() {
			$("#testTable").css("width","100%");
		}
	},
	"aoColumns" : [
	               {sWidth : "15%" },
	               {sWidth : "*" },
	               {sWidth : "15%" },
	               {sWidth : "20%x" },
	               {sWidth : "10%" }
	],
	fnInitComplete : function() {
	}
} );

</script>