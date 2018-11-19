//$(document).ready(function () {
//	function resizeWrapper() {
//    	var windowHeight = $( window ).height() - 85;
//		$(".wrapper").css({"height": windowHeight });
//    }
//	resizeWrapper();
//
//	$(window).resize(function() {
//		resizeWrapper();
//	});
//});

$(function(){

	// 트리메뉴
	$('.tree-toggle').click(function () {
		var tree_toggle = $(this);
		$(this).parent().children('ul.tree').toggle(200);
		if(tree_toggle.hasClass("tree-close")){
			tree_toggle.removeClass("tree-close");
		}
		else {
			tree_toggle.addClass("tree-close");
		}

	});
	$('.tree-close-all').click(function () {
		var tree_target = $(this).attr("data-target");
		$(tree_target + ' .tree-toggle').addClass("tree-close").parent().children('ul.tree').toggle(false);
	});
	$('.tree-open-all').click(function () {
		var tree_target = $(this).attr("data-target");
		$(tree_target + ' .tree-toggle').removeClass("tree-close").parent().children('ul.tree').toggle(true);
	});


	// 일반메뉴
	$('.sidebar-menu a').click(function () {

		var menu_toggle = $(this).siblings('ul.treeview-menu');
		var status = menu_toggle.css("display");
		if(status == "none"){
			menu_toggle.toggle(200).parent("li").addClass("open");
		}
		else {
			menu_toggle.toggle(200).parent("li").removeClass("open");
		}
	});

	// 일반메뉴
	$("button[data-toggle='collapse']").click(function () {
		$(this).toggleClass("collapsed");
	});


	// scrollspy
//	var scrollTarget = $(".scrollspy-body").attr("date-target");
//	var scrollOffset = $(".scrollspy-body .box:first-child").height();
//	var scrollOffset = scrollOffset + 60;
//	$(".scrollspy-body").attr('data-offset', scrollOffset);


	//툴팁
	$('[data-toggle="tooltip"]').tooltip();


	//메세지
	$('.alert').alert();



	//체크박스 컴포넌트
	$(".input-group-check input[type='checkbox']").each(function(index){
		var inputID = $(this).attr("id");
		var label = $(this).siblings("label[for=" + inputID + "]");
		var ipText = label.next("input[type='text']");
		$(this).wrap("<span>").after(label);
		if(ipText.length > 0){
			label.after(ipText);
		}
	});


	//라디오 컴포넌트
	$(".input-group-radio input[type='radio']").each(function(index){
		var radio = $(this);
		var label = $(this).next("label");
		var ipText = label.next("input[type='text']");

		var radioID = radio.attr("id").replace('.', '-');
		var labelFor = label.attr("for").replace('.', '-');

		if(radioID == labelFor){
			radio.wrap("<span>").after(label);
			if(ipText.length > 0){
				label.after(ipText);
			}
		}
	});

	$(".dropdown-menu .notClose").click(function(e){
		//debugger;
		e.stopPropagation();
	});

	$(".table-layout-fixed > thead > tr > th:not(.notellipsis)").addClass("ellipsis");
	$(".table-layout-fixed > tbody > tr > td:not(.notellipsis)").addClass("ellipsis");


});



