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


	// 좌측메뉴 접기/펴기
	$('.sidebar-menu a').click(function () {

		$('ul.treeview-menu li').removeClass("active");

		var menu_toggle = $(this).siblings('ul.treeview-menu');
		var status = menu_toggle.css("display");
		if(status == "none"){
			menu_toggle.toggle(200).parent("li").addClass("open");
		}
		else {
			menu_toggle.toggle(200).parent("li").removeClass("open");
		}

	});


	// scrollspy
	var scrollTarget = $(".scrollspy-body").attr("date-target");
	var scrollOffset = $(".scrollspy-body .box:first-child").height();
	var scrollOffset = scrollOffset + 60;
	$(".scrollspy-body").attr('data-offset', scrollOffset);


	//툴팁
	$('[data-toggle="tooltip"]').tooltip();


	//메세지
	$('.alert').alert();



});



