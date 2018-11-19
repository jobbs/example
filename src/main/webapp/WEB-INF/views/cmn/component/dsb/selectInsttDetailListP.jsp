<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2017. 11. 13.
 * @lastmodified 2017. 11. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 11. 13.     신재훈         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authentication property="principal" var="user" />

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.cookie.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.alerts.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.sparkline.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/custom.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<section class="content">
</section>
<div class="col-box-100">
	<c:if test="${insttDetailView}">
		<div class="box treemenu-box">
			<div class="box-header">
				<h3 class="box-title">
					<i class="ci ci-boxes"></i>부처별 구성정보
				</h3>
				<div class="box-tools pull-right" style="width: 120px; text-align: right;">
					<div class="btn-group">
						<button class="btn btn-default tree-open-all" data-target="#tree-resource" onclick="fn_allOpen()" style="width:50px">모두열기</button>
						<button class="btn btn-default tree-close-all" data-target="#tree-resource" onclick="fn_allClose()" style="width:50px">모두닫기</button>
					</div>
				</div>
			</div>
			<!-- /box-header -->
			<table class="table table-vertical table-layout-fixed">
				<caption>부처별 구성정보</caption>
				<tbody>
					<tr>
						<td class="alignL" style="display: inline-block; overflow: auto; height: 600px; width: 100%;">
							<div class="tree-resource tree-organ collapse in" id="organ_tree-resource">
								<div class="tree-box" id="tree_inc"></div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark" onclick="selectInstt()">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<div>
	<input type="hidden" id="echoSelection" value="">
	<input type="hidden" id="echoSelectionKeys" value="">
	<input type="hidden" id="echoSelectionTitles" value="">
</div>

<script type="text/javascript">
$(function() {
	<c:if test = "${insttDetailView}">
	$("#tree_inc").dynatree(
		{
			checkbox : true,
			selectMode : 3,
// 			persist : true,
// 			minExpandLevel : 1,
// 			clickFolderMode : 1,
// 			debugLevel: 1,
// 			onActivate : function(node) {
// 				keydata = node.data.key;
// 				if($('#tree').length>0) {
// 					if ($('#tree').dynatree("getActiveNode")!=null) $('#tree').dynatree("getActiveNode").deactivate();
// 				}
// 				loadSelectDetail_inc(node.data.key,node.data.gubun);
// 			},
			initAjax : {
				url : '<c:url value="/cmn/component/dsb/selectInstitutionToVmTreeByOnnara.do?vmTree=main&searchGubun=popup"/>'
// 				url : '<c:url value="/cmn/component/dsb/selectInstitutionToVmTreeByOnnara.do"/>'
			},
			onPostInit : function(isReloading, isError) {
				if(isError){
					$("#tree_inc").html("<div class=alignC>기관별 구성정보가 없습니다.</div>");
				}
				this.activateKey(this.persistence.activeKey);
				this.reactivate(true);
			},
			onDblClick : function() {
				this.activeNode.toggleExpand();
			},
			onSelect : function(select, node){
				// Get a list of all selected nodes, and convert to a key array
				var selKeys = $.map(node.tree.getSelectedNodes(), function(node){
					return node.data.key;
				});
				var selTitles = $.map(node.tree.getSelectedNodes(), function(node){
					return node.data.title;
				});
				var selDatas = $.map(node.tree.getSelectedNodes(), function(node){
					return node.data.key + "/" + node.data.title;
				});

				$("#echoSelectionKeys").val(selKeys.join("|"));
				$("#echoSelectionTitles").val(selTitles.join("|"));
				$("#echoSelection").val(selDatas.join("|"));
				console.log($("#echoSelection").val());
			},
			onKeydown: function(node, event){
				if(event.which == 32){
					node.toggleSelect();
					return false;
				}
			},
			cookieId: "dynatree-Cb",
			idPrefix: "dynatree-Cb-"
		});
	</c:if>

// 	fn_inition();
	treeResize();
});

function treeResize() {
	$(".treemenu-box").each(function() {
		var boxHeight = $(this).height();
		var boxHeader = $(this).children(".box-header").height();
		var boxFooter = $(this).children(".box-footer").height();

		if (boxFooter == null)
			boxFooter = 0;

		var tableHeight = boxHeight - (boxHeader + boxFooter) - 5;

		$(this).find("table * td").css("height", tableHeight + "px");

	});
}
// 선택한 정보에 따른 상세정보 출력
function loadSelectDetail_inc(key, gubun) {

}

function fn_inition() {
	var cookiedata = document.cookie;
	var dynSelect = $.cookie("dynatree-active");
}

function selectInstt(){
	var keyDatas = new Array();
	var titleDatas = new Array();
	var datas = new Array();

// 	if($("#echoSelectionKeys").val() == ""){
// 		jAlert("부처를 선택하여 주시기 바랍니다.");
// 		return;
// 	}

// 	var selectKeyList = $("#echoSelectionKeys").val().split('|');

// 	$.each(selectKeyList, function(index, item){
// 		if(item.split(',').length == 3){ // length가 3이면 부처ID, 업무ID, 가상서버SEQ 형태의 값을 가지고 있다는 말.
// 			var splitItem = item.split(',');
// 			console.log('key value = '+splitItem[2])
// 			keyDatas.push(splitItem[2]);
// 		}
// 	});
// 	console.log('vmseq list length ='+keyDatas.length);

// 	var selectTitleList = $("#echoSelectionTitles").val().split('|');

// 	$.each(selectTitleList, function(index, item){
// 		if(item.split(',').length == 3){ // length가 3이면 부처ID, 업무ID, 가상서버SEQ 형태의 값을 가지고 있다는 말.
// 			var splitItem = item.split(',');
// 			console.log('title value = '+splitItem[2])
// 			titleDatas.push(splitItem[2]);
// 		}
// 	});
// 	console.log('vmseq list length ='+titleDatas.length);

// 	var evt = jQuery.Event('selectInstitution', {
// 		"keyDatas" : keyDatas
//     });


	if($("#echoSelection").val() == ""){
		jAlert("가상서버를 선택하여 주시기 바랍니다.");
		return;
	}
	// data는 key/title|key/title|key/title 형태로 구성되어 있음.
	var selectList = $("#echoSelection").val().split('|');
	var data = null;
	$.each(selectList, function(index, item){
		var splitItem = item.split('/');
		if(splitItem[0].split(',').length == 3){
			var keyItem = splitItem[0].split(',');
			keyDatas.push(keyItem[2]);
			titleDatas.push(splitItem[1]);

			data = new EntityVmInfo();
			data.vmSeq = keyItem[2];
			data.vmNm = splitItem[1];
			datas.push(data);
		}
	});

/* 	if(keyDatas.length > 7){ // 최대 7개까지 선택이 가능함.
		jAlert("선택한 가상서버가 7개를 넘을 수 없습니다.");
		return;
	} */

	if(keyDatas.length > 15){ // 최대 15개까지 선택이 가능함.
		jAlert("선택한 가상서버가 15개를 넘을 수 없습니다.");
		return;
	}

	var evt = jQuery.Event('selectInstitution', {
		"keyDatas" : keyDatas,
		"titleDatas" : titleDatas,
		"datas" : datas
	});


    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}

function fn_allOpen() {
	$("#tree_inc").dynatree("getRoot").visit(function(node) {
		node.expand(true);
	});
}
function fn_allClose() {
	$("#tree_inc").dynatree("getRoot").visit(function(node) {
		node.expand(false);
	});
}

</script>