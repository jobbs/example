(function($) {

	var spinner;
	var target;

	var opts = {
		  lines: 13 // The number of lines to draw
		, length: 1 // The length of each line
		, width: 10 // The line thickness
		, radius: 20 // The radius of the inner circle
		, scale: 1 // Scales overall size of the spinner
		, corners: 1 // Corner roundness (0..1)
		, color: '#000' // #rgb or #rrggbb or array of colors
		, opacity: 0.15 // Opacity of the lines
		, rotate: 0 // The rotation offset
		, direction: 1 // 1: clockwise, -1: counterclockwise
		, speed: 1 // Rounds per second
		, trail: 60 // Afterglow percentage
		, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
		, zIndex: 2e9 // The z-index (defaults to 2000000000)
		, className: 'spinner' // The CSS class to assign to the spinner
		, top: '50%' // Top position relative to parent
		, left: '50%' // Left position relative to parent
		, shadow: false // Whether to render a shadow
		, hwaccel: false // Whether to use hardware acceleration
		, position: 'absolute' // Element positioning 'absolute', 'relative'
	};

	$.ncmsLoding = {

			/**
		 * 로딩바 시작(전체 화면)
		 */
		startFullScreen : function() {
			$("body").append('<div class="loading black"></div>');
			opts.position = "absolute";
			new Spinner(opts).spin($(".loading")[0]);
		},

		/**
		 * 로딩바 시작(적용을 원하는 부분)
		 * @param code
		 */
		start : function(obj) {
			$(obj).append('<div class="loading black"></div>');
			opts.position = "relative";
			new Spinner(opts).spin($(".loading")[0]);

		},

		/**
		 * 로딩바 삭제
		 * @param val
		 */
		remove : function() {
			$(".loading").remove();
		}
	};
})(jQuery);