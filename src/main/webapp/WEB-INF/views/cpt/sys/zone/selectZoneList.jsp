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

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<div class="col-box-30 detail-col no-padding-right">
	<div class="box">
		<div class="box-body no-padding tree-box">
			<table class="table table-vertical table-layout-fixed">
				<caption>존 트리 목록 테이블</caption>
				<tbody>
				<tr>
					<td class="alignL no-padding">
						<div class="tree-resource" id="tree" style="max-height: 600px"></div>
					</td>
				</tr>
				<menu:authorize>
				<tr id="addBtnDiv">
					<td>
						<div class="pull-right">
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
		<div class="col-box-100 detail-col tree_content_area"></div>
	</div>
</div>

<script type="text/javascript">

	$(function() {
		$("#tree").dynatree({
			persist : true,
			minExpandLevel : 1,
			clickFolderMode : 1,
			autoFocus: false,
			onActivate : function(node) {

				controlAddBtn(node);
				loadSelectDetail(node.data.key);
			},
			initAjax : {
				url : 'selectZoneAndPoolListTree.do'
			},
			onLazyRead: function(node){
				var level = node.getLevel();
				var key = node.data.key;

				if( level == 2 ) { //존일 경우
					node.appendAjax({ url: 'selectNetTree.do', data : {'zoneId' : key}, debugLazyDelay: 750 });
				}
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



	function doInsertForm() {
		var activeNode = $("#tree").dynatree("getActiveNode");
		if (activeNode == null) {
			return;
		}

		var level = activeNode.getLevel();
		var cmnIds = activeNode.data.key.split(",");
		var cmnId = cmnIds.pop();

		$.ncmsLoding.start($('.tree_content_area'));
		if( level == 1 ) {
			$.get('insertRegion.do', loadSuccessHandler, 'html');
		} else if(level == 2 ) {
			$.get('insertZone.do', {"regionId" : cmnId }, loadSuccessHandler, 'html');
		} else if(level == 3 ) {
			$.get('insertNet.do', {"zoneId" : cmnId }, loadSuccessHandler, 'html');
		}
	}

	function controlAddBtn(node) {

		if( node.getLevel() == 1 && node.data.key == "9999" ||
				node.getLevel() == 2 && node.getParent().data.key == "9999" ) {
			$("#addBtnDiv").hide();
		} else {
			if( node.getLevel() > 3 ) {
				$("#addBtnDiv").hide();
			} else {
				$("#addBtnDiv").show();

			}
		}
	}

	function loadSelectDetail(key) {

		var node = $("#tree").dynatree("getActiveNode");
		var level = node.getLevel();

		if (key != null) {

			$.ncmsLoding.start($('.tree_content_area'));

			//,로 구분되어 잇는 키를 ,로 split 하여 마지막 항목을 ID로 한다.
			var cmnIds = key.split(",");
			var id = cmnIds.pop();

			//오류 목록 처리
			if( level == 1 && node.data.key == "9999") {
				loadSuccessHandler("");
			} else if( level == 2 && node.getParent().data.key == "9999" ) {
				$.get('selectPool.do', {'rsrcPoolId' : id }, loadSuccessHandler, 'html');

			//정상 항목 처리
			} else if( level == 1 ) {
				loadSuccessHandler("");
			} else if( level == 2 ) { //센터일 경우
				//미할당 목록의 경우
				if( node.getParent().data.key == "9999" ) {
					$.get('selectPool.do', {'rsrcPoolId' : id }, loadSuccessHandler, 'html');
				} else {
					$.get('selectRegion.do', {'regionId' : id}, loadSuccessHandler, 'html');
				}

			} else if( level == 3 ) { //존일 경우
				$.get('selectZone.do', {'zoneId' : id}, loadSuccessHandler, 'html');
			} else if( level == 4 ) { //망일 경우
				$.get('selectNet.do', {'netId' : id }, loadSuccessHandler, 'html');
			} else if( level == 5 ) { //자원풀일 경우
				$.get('selectPool.do', {'rsrcPoolId' : id }, loadSuccessHandler, 'html');
			}

		}
	}

	function loadSuccessHandler(data) {
		$.ncmsLoding.remove();
		$('.tree_content_area').html(data);
	}

	function submitSuccessHandler(result) {
		alert_message(result.messageList, function() {
			if (result.success) {

				if( result.procType == "zoneNetupdate" ||
						result.procType == "regionDelete" ||
						result.procType == "zoneDelete" ||
						result.procType == "zoneNetDelete" ) {

					$("#tree").dynatree("getTree").activateKey(
							$("#tree").dynatree("getActiveNode").getParent().data.key
					);

					$("#tree").dynatree("getActiveNode").expand(true);

				}

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
</script>