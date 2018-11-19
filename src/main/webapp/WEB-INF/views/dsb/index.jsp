<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<sec:authentication property="principal" var="user" />

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<aside class="left-side" id="left-side" style="min-height: 700px">
	<section class="sidebar" style="overflow: hidden; padding-bottom: 20px;">

		<c:if test="${mainRsrcView}">
			<!-- box -->
			<div class="box treemenu-box">
				<div class="box-header">
					<h3 class="box-title">
						<i class="ci ci-boxes"></i>자원풀 구성정보
					</h3>
					<div class="box-tools pull-right">
						<!-- 					<button class="btn btn-sm">
						<i class="fa fa-arrows-alt" data-placement="bottom" data-toggle="tooltip" title="펼쳐보기"></i>
					</button> -->
						<!-- 					<button class="btn btn-sm" data-toggle="collapse" data-target=".pool_tree-resource"> -->
						<!-- 						<i class="fa fa-chevron-up" data-placement="bottom" data-toggle="tooltip" title="접어두기"></i> -->
						<!-- 					</button> -->
					</div>
				</div>
				<!-- /box-header -->

				<table class="table table-vertical table-layout-fixed">
					<caption>자원풀 구성정보</caption>
					<tbody>
						<tr>
							<td class="alignL" style="display: inline-block; overflow: auto; width: 100%;">
								<div class="pool_tree-resource tree-resource collapse in" id="pool_tree-resource">
									<div class="tree-box" id="tree"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="box-footer">
					<div class="btn-group">
						<button class="btn btn-default tree-open-all" data-target="#tree-resource" onclick="fn_allOpen()">모두열기</button>
						<button class="btn btn-default tree-close-all" data-target="#tree-resource" onclick="fn_allClose()">모두닫기</button>
					</div>
				</div>
				<!-- /box-footer -->
			</div>
			<!-- /box -->
		</c:if>
		<c:if test="${mainIncView }">
			<!-- box -->
			<div class="box treemenu-box">
				<div class="box-header">
					<h3 class="box-title">
						<i class="ci ci-boxes"></i>기관별 구성정보

					</h3>
					<div class="box-tools pull-right">
						<!-- <button class="btn btn-sm">
						<i class="fa fa-arrows-alt" data-toggle="tooltip" title="펼쳐보기"></i>
					</button> -->
						<!-- 					<button class="btn btn-sm" data-toggle="collapse" data-target=".tree-organ"> -->
						<!-- 						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i> -->
						<!-- 					</button> -->
					</div>
				</div>
				<!-- /box-header -->

				<table class="table table-vertical table-layout-fixed">
					<caption>기관별 구성정보</caption>
					<tbody>
						<tr>
							<td class="alignL" style="display: inline-block; overflow: auto; height: 200px; width: 100%;">
								<div class="tree-resource tree-organ collapse in" id="organ_tree-resource">
									<div class="tree-box" id="tree_inc"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>

			</div>
		</c:if>
		<!-- /box -->
	</section>
</aside>

<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
<aside class="right-side infobar-collapse" style="height: calc(100% - 32px);">
	<div class="tree_content_area"></div>
</aside>
<script type="text/javascript">
	var param="vrlzSwTyCd=${param.vrlzSwTyCd}&vmCompId=${param.vmCompId}&strtDt=${param.strtDt}&endDt=${param.endDt}&pmCompId=${param.pmCompId}&vmNm=${param.vmNm}&institutionNm=${param.institutionNm}&jobNm=${param.jobNm}&podId=${param.podId}&podNm=${param.podNm}&strtDtPod=${param.strtDtPod}&endDtPod=${param.endDtPod}&institutionNmPod=${param.institutionNmPod}&servcNm=${param.servcNm}";
	$(function() {

		<c:if test = "${mainRsrcView}">
		//var keydata;
		$("#tree")
				.dynatree(
						{
							persist : true,
							minExpandLevel : 2,
							clickFolderMode : 1,
							debugLevel: 1,
							onActivate : function(node) {
								//keydata = node.data.key;
								if($('#tree_inc').length>0) {
									if ($('#tree_inc').dynatree("getActiveNode")!=null) $('#tree_inc').dynatree("getActiveNode").deactivate();
								}
								loadSelectDetail(node.data.key);
							},
							initAjax : {
								url : '<c:url value="/cmn/component/dsb/selectRegionToPmTree.do?pmTree=main"/>'

							},
							onPostInit : function(isReloading, isError) {
								if(isError){
									$("#tree_inc").html("<div class=alignC>자원풀 구성정보가 없습니다.</div>");
								}
								this.activateKey(this.persistence.activeKey);
								this.reactivate(true);
							},
							onDblClick : function() {
								this.activeNode.toggleExpand();
							}

						});
		</c:if>

		<c:if test = "${mainIncView}">

		$("#tree_inc")
				.dynatree(
						{
							persist : true,
							minExpandLevel : 1,
							clickFolderMode : 1,
							debugLevel: 1,
							onActivate : function(node) {
								//keydata = node.data.key;
								if($('#tree').length>0) {
									if ($('#tree').dynatree("getActiveNode")!=null) $('#tree').dynatree("getActiveNode").deactivate();
								}
								loadSelectDetail_inc(node.data.key,node.data.gubun);
							},
							initAjax : {
								url : '<c:url value="/cmn/component/dsb/selectInstitutionToVmTree.do?vmTree=main"/>'
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
							}
						});

		</c:if>

		if ($(".treemenu-box").size() > 1) {
			$(".treemenu-box").css("height", "50%");
		} else {
			$(".treemenu-box").css("height", "100%");
		}

		fn_inition();

		treeResize();

	});

	function fn_inition() {

		var cookiedata = document.cookie;
		var dynSelect = $.cookie("dynatree-active");

		<c:choose>
			<c:when test = "${mainRsrcView}">
				if (dynSelect == '') {
					$.get(
									'<c:url value="/cmn/component/dsb/selectPmIdxList.do"/>'+"?"+param,
									{
										'id' : 'NIRS'
									}, loadSuccessHandler, 'html');
				}
			</c:when>
			<c:otherwise>
				//var activeNode = $("#tree").dynatree("getActiveNode");
				if (dynSelect == '') {
					$.get(
									'<c:url value="/cmn/component/dsb/selectVmIdxList.do"/>'+"?"+param,
									{
										'id' : 'NIRS'
									}, loadSuccessHandler, 'html');
				}
			</c:otherwise>
		</c:choose>
		// var aa=$("#tree").dynatree("getActiveNode")
		// alert($("#tree").dynatree("getSelectedNodes"));
		//var aa=$("#tree").dynatree("getTree").activateKey( $("#tree").dynatree("getActiveNode") );
		//var aa= $("#tree").dynatree("getTree").activateKey( $("#tree").dynatree("getActiveNode").getParent().data.key );
		//alert("aa"+aa.data.key);

	}
	//우측 리스트 화면 호출
	function loadSelectDetail(key) {
		var url = '<c:url value="/cmn/component/dsb/selectPmIdxList.do"/>'+"?"+param;
		var id = null;
		var vmPod = null;
		if (key) {
			id = key;
			var clstr = id.split(',');
			if(clstr.length >= 5 ){
				if(!$.isNumeric(clstr[4])) vmPod="pod";
				else vmPod="vm";
			}else{
				vmPod="vm";
			}

		} else {
			var node = $("#tree").dynatree("getActiveNode");
			if (node != null)
				id = node.data.key;
		}

		if (id != null) {
			$.ncmsLoding.startFullScreen();
			$.get(url, {
				'id' : id,
				'vmPod' : vmPod
			}, loadSuccessHandler, 'html').always(function(){$.ncmsLoding.remove();});
		}
	}

	//우측 리스트 화면 호출
	function loadSelectDetail_inc(key, gubun) {
		var url = '<c:url value="/cmn/component/dsb/selectVmIdxList.do"/>'+"?"+param;
		var id = null;
		var vmPod = null;
		if(gubun == "WX") vmPod="pod";
		else vmPod="vm";
		//console.log("gubun=>"+gubun);
		if (key) {
			id = key;
			console.log("id=>"+id);
		} else {
			var node = $("#tree_inc").dynatree("getActiveNode");
			if (node != null)
				id = node.data.key;
				console.log("id=>"+id);
		}

		if (id != null) {
			$.ncmsLoding.startFullScreen();
			$.get(url, {
				'id' : id,
				'vmPod': vmPod
			}, loadSuccessHandler, 'html').always(function(){$.ncmsLoding.remove();});
		}
	}

	function loadSuccessHandler(data) {
		$('.tree_content_area').html(data);
	}

	/**
	 * 메뉴 등록 폼 호출
	 */
	function doInsertForm() {
		var activeNode = $("#tree").dynatree("getActiveNode");
		if (activeNode == null) {
			return;
		}
		$.get('${insertUrl}', {
			'parentSeq' : activeNode.data.key
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

	function fn_allOpen() {
		$("#tree").dynatree("getRoot").visit(function(node) {
			node.expand(true);
		});
	}
	function fn_allClose() {
		$("#tree").dynatree("getRoot").visit(function(node) {
			node.expand(false);
		});
	}

	function fn_allOpen_inc() {
		$("#tree_inc").dynatree("getRoot").visit(function(node) {
			node.expand(true);
		});
	}
	function fn_allClose_inc() {
		$("#tree_inc").dynatree("getRoot").visit(function(node) {
			node.expand(false);
		});
	}

	function treeResize() {
		$("section.sidebar > .treemenu-box").each(function() {
			var boxHeight = $(this).height();
			var boxHeader = $(this).children(".box-header").height();
			var boxFooter = $(this).children(".box-footer").height();

			if (boxFooter == null)
				boxFooter = 0;

			var tableHeight = boxHeight - (boxHeader + boxFooter) - 5;

			$(this).find("table * td").css("height", tableHeight + "px");

		});
	}

	$(window).resize(treeResize);
	function fn_loadDetail() {
		var node = $("#tree").dynatree("getActiveNode");
		if (node != null) {
			if(window.console) console.log(new Date().toISOString() + ' tree.key:' + node.data.key);
			loadSelectDetail();
			return;
		}
		node = $("#tree_inc").dynatree("getActiveNode");
		if (node != null) {
			if(window.console) console.log(new Date().toISOString() + ' tree_inc.key:' + node.data.key);
			loadSelectDetail_inc();
			return;
		}
		if (node == null) {
			fn_inition();
		}
	}

	// 현재 선택된 자원풀(부처업무) 트리의 노드에 따른 대시보드의 자원정보(오른쪽) 새로고침
	if (timer !=null) window.clearInterval(timer);
	var timer;
	sec = new Date().getSeconds();
	sec = sec >30 ? 90-sec : 30-sec;
	window.setTimeout(function() {
	timer = window.setInterval(function() {
					//if(window.console) console.log(new Date().getHours() + ':' + new Date().getMinutes() + ':' + new Date().getSeconds());
					var dt = new Date();
					if (dt.getMinutes()%10 == 2 || dt.getMinutes()%10 == 7) {
						fn_loadDetail();
					}
				 }, 1000*60*1 );
	}, sec*1000 );
</script>