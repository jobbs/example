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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<c:url var="selectListUrl" value="selectCodeSearchList.do"></c:url>
<c:url var="selectUrl" value="selectCode.do"></c:url>
<c:url var="selectTreeUrl" value="selectCodeListTree.do"></c:url>
<c:url var="insertUrl" value="insertCode.do"></c:url>
<c:url var="updateOrderUpUrl" value="updateCodeOrderUp.do"></c:url>
<c:url var="updateOrderDownUrl" value="updateCodeOrderDown.do"></c:url>

<div class="col-box-30 detail-col no-padding-right">
	<div class="box">
		<div class="box-body no-padding tree-box">
			<table class="table table-vertical table-layout-fixed">
				<caption>코드 트리 목록 테이블</caption>
				<tbody>
				<tr>
					<td class="alignL no-padding">
						<div class="tree-resource " id="tree" style="max-height: 600px">
						</div>
					</td>
				</tr>
				<menu:authorize>
				<tr>
					<td>
						<div class="pull-left">
							<div class="btn-group">
								<button class="btn" onclick="onClickMove('${updateOrderUpUrl}')"><i class="fa fa-angle-up"></i></button>
								<button class="btn" onclick="onClickMove('${updateOrderDownUrl}')"><i class="fa fa-angle-down"></i></button>
							</div>
						</div>
						<div class="pull-right" id="addBtnDiv">
							<button class="btn btn-blue" onclick="doInsertForm()"><i class="fa fa-plus"></i></button>
						</div>
					</td>
				</tr>
				</menu:authorize>
				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer clearfix">
		</div><!-- /box-footer -->
	</div>
</div>
<div class="col-box-70">
	<div class="row">

		<div class="col-box-100 search-col">
			<div class="box box-search">
				<div class="box-header">
					<h3 class="box-title">검색조건</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse"><i class="fa fa-chevron-down" data-toggle="tooltip" title="접어두기"></i></button>
					</div>

					<form name="searchFrm" id="searchFrm" method="get" onsubmit="doSearchCode(); return false;">
					<input type="hidden" name="searchType" value="S" />
					<input type="hidden" id="recordCountPerPage" name="paginationInfo.recordCountPerPage" value="20" />
					<div class="box-body collapse search-collapse">
						<div class="form-group">
							<div class="form-cell form-cell-100 col-lay-50">
								<div class="cell-title">
									<label for="searchCd">코드</label>
								</div>
								<div class="cell-body">
									<input type="text" name="searchCd" id="searchCd" class="form-control input-sm" title="코드" />
								</div>
							</div>
							<div class="form-cell form-cell-100 col-lay-50">
								<div class="cell-title">
									<label for="searchGrpCd">그룹코드</label>
								</div>
								<div class="cell-body">
									<input type="text" name="searchGrpCd" id="searchGrpCd" class="form-control input-sm" title="그룹" />
								</div>
							</div>
							<div class="form-cell form-cell-100 col-lay-50">
								<div class="cell-title">
									<label for="searchParentCd">부모코드</label>
								</div>
								<div class="cell-body">
									<input type="text" name="searchParentCd" id="searchParentCd" class="form-control input-sm" title="부모코드" />
								</div>
							</div>
							<div class="form-cell form-cell-100 col-lay-50">
								<div class="cell-title">
									<label for="searchCdNm" title="코드명">코드명</label>
								</div>
								<div class="cell-body">
									<input type="text" name="searchCdNm" id="searchCdNm" class="form-control input-sm" title="코드명" />
								</div>
							</div>
						</div>
					</div>
					</form>
					<div class="box-footer collapse search-collapse">
						<div class="pull-left">
							<button type="button" class="btn" onclick="formReset('searchFrm')">초기화</button>
						</div>
						<div class="pull-right">
							<button type="button" class="btn btn-red pull-right" onclick="doSearchCode()">조회</button>
						</div>
					</div>
					<!-- /box-footer -->
				</div>
			</div>
		</div>

		<div class="col-box-100 search-col tree_content_area">
		</div>
	</div>
</div>

<script type="text/javascript">
$(function() {
	$("#tree").dynatree({
		persist : true,
		minExpandLevel : 2,
		clickFolderMode : 1,
		onActivate : function(node) {
			controlAddBtn(node);
			loadSelectDetail(node.data.key);
		},
		initAjax : {
			url : '${selectTreeUrl}'
		},
		onPostInit : function(isReloading, isError) {
			this.activateKey(this.persistence.activeKey);
			this.reactivate(true);
		},
		onDblClick : function() {
			this.activeNode.toggleExpand();
		}
	});
});

function controlAddBtn(node) {
	/* if( node.getLevel() > 2 ) {
		$("#addBtnDiv").hide();
	} else {
		$("#addBtnDiv").show();

	} */
}

function loadSelectDetail(key) {
	var url = '${selectUrl}';
	var cd, grpCd;

	if (key) {
		var keys = key.split('^|^');
		cd = keys[0];
		grpCd = keys[1];

	} else {
		var node = $("#tree").dynatree("getActiveNode");
		if (node != null) {
			var keys = node.data.key.split("^|^");
			cd = keys[0];
			grpCd = keys[1];
		}
	}

	if (key != null) {
		//로딩바
		$.ncmsLoding.start($('.tree_content_area'));
		$.get(url, {
			'cd' : cd, 'grpCd' : grpCd
		}, loadSuccessHandler, 'html');
	}
}

function loadSuccessHandler(data) {
	$.ncmsLoding.remove($('.tree_content_area'));
	$('.tree_content_area').html(data);
}

/**
 * 코드 등록 폼 호출
 */
function doInsertForm() {
	var activeNode = $("#tree").dynatree("getActiveNode");
	if (activeNode == null) {
		return;
	}

	var keys = activeNode.data.key.split("^|^");
	var parentCd = keys[0];
	var parentGrpCd = keys[1];

	//로딩바
	$.ncmsLoding.start($('.tree_content_area'));
	$.get('${insertUrl}', {
		'parentCd' : parentCd, 'parentGrpCd' : parentGrpCd
	}, loadSuccessHandler, 'html');
}

function submitSuccessHandler(result) {
	alert_message(result.messageList, function() {
		if (result.success) {

			if (result.procType == "delete") {
				$("#tree").dynatree("getTree")
						.activateKey(
								$("#tree").dynatree("getActiveNode")
										.getParent().data.key);
			}

			$("#tree").dynatree("getActiveNode").expand(true);
			reloadTree();
		}
	});

}

function reloadTree() {
	$("#tree").dynatree("getTree").reload();
}

function callbackReloadChildren(tree) {
	loadSelectDetail(tree.data.key);
}

function onClickMove(url) {

	var cd, grpCd, parentCd, parentGrpCd;

	var activeNode = $("#tree").dynatree("getActiveNode");
	if (activeNode.data.parentKey == null) {
		alert("최상위 메뉴는 이동이 불가합니다.");
		return;
	}

	var keys = activeNode.data.key.split("^|^");
	var parentKeys = activeNode.data.parentKey.split("^|^");

	$.ncmsLoding.startFullScreen();
	$.post(url, {
		'cd' : keys[0],
		'grpCd' : keys[1],
		'parentCd' : parentKeys[0] ,
		'parentGrpCd' : parentKeys[1]
	}, moveSuccessHandler, 'json')
	.always(function() {
		$.ncmsLoding.remove();
	});
}

function moveSuccessHandler(result) {
	if (result.success) {
		var activeNode = $("#tree").dynatree("getActiveNode");
		if (result.data == 'before') {
			if (activeNode.getPrevSibling() != null) {
				activeNode.move(activeNode.getPrevSibling(), 'before');
			}
		} else {
			if (activeNode.getNextSibling() != null) {
				activeNode.move(activeNode.getNextSibling(), 'after');
			}
		}
	} else {
		if (result.messageList) {
			alert(result.messageList.join('\n'));
		}
	}
}

function doSearchCode() {
	//로딩바
	$.ncmsLoding.start($('.tree_content_area'));
	$.get('${selectListUrl}', $("#searchFrm").serialize(), loadSuccessHandler, 'html');
}
</script>