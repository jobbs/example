// jQuery Alert Dialogs Plugin
//
// Version 1.1
//
// Cory S.N. LaViska
// A Beautiful Site (http://abeautifulsite.net/)
// 14 May 2009
//
// Website: http://abeautifulsite.net/blog/2008/12/jquery-alert-dialogs/
//
// Usage:
//		jAlert( message, [callback] )
//		jConfirm( message, [callback] )
//		jPrompt( message, [value, title, callback] )
//
// History:
//
//		1.00 - Released (29 December 2008)
//
//		1.01 - Fixed bug where unbinding would destroy all resize events
//
// License:
//
// This plugin is dual-licensed under the GNU General Public License and the MIT License and
// is copyright 2008 A Beautiful Site, LLC.
//
(function($) {

	$.alerts = {

		// These properties can be read/written by accessing $.alerts.propertyName from your scripts at any time

		verticalOffset: -75,                // vertical offset of the dialog from center screen, in pixels
		horizontalOffset: 0,                // horizontal offset of the dialog from center screen, in pixels/
		repositionOnResize: true,           // re-centers the dialog on window resize
		overlayOpacity: .01,                // transparency level of overlay
		overlayColor: '#FFF',               // base color of overlay
		draggable: true,                    // make the dialogs draggable (requires UI Draggables plugin)
		okButton: '&nbsp;확인&nbsp;',         // text for the OK button
		yesButton: '&nbsp;예&nbsp;',         // text for the YES button
		noButton: '&nbsp;아니오&nbsp;',         // text for the NO button
		cancelButton: '&nbsp;취소&nbsp;', // text for the Cancel button
		dialogClass: null,                  // if specified, this class will be applied to all dialogs
		dialogSize: "default",

		// Public methods

		alert: function(message, callback, title, target) {
			$.alerts._show((title!=undefined?title:'경고'), message, null, 'alert', function(result) {
				if( callback ) callback(result);
			});
		},

		confirm: function(message, callback, title) {
			$.alerts._show((title!=undefined?title:'확인'), message, null, 'confirm', function(result) {
				if( callback ) callback(result);
			});
		},

		confirmForCancel: function(message, callback, title, cancelYn) {
			$.alerts._show((title!=undefined?title:'확인'), message, null, (!cancelYn ?'confirmForYesNo':'confirmForCancel'), function(result) {
				if( callback ) {
					callback(result);
				}
			});
		},

		prompt: function(message, value, callback) {
			$.alerts._show('Prompt', message, value, 'prompt', function(result) {
				if( callback ) callback(result);
			});
		},

		info: function(message, callback, title) {
			$.alerts._show((title!=undefined?title:'정보'), message, null, 'info', function(result) {
				if( callback ) callback(result);
			});
		},

		_show: function(title, msg, value, type, callback) {

			$.alerts._hide();
			$.alerts._overlay('show');

			$("body").append(
			  '<div class="modal message fade in" id="popup_container" role="dialog" tabindex="-1" style="display:block">' +
			  	'<div class="modal-dialog" id="alert-modal-dialog">' +
			  		'<div class="modal-content">' +
			  			'<div class="modal-body"><h3 id="modalLabel"></h3><p id="modalBody"></p></div>' +
			  			'<div class="modal-footer" id="modalFooter"></div>' +
			  		'</div>' +
			  	'</div>' +
			  '</div>');

			$("body").addClass("modal-open");

			$("body").append('<div class="modal-backdrop fade in"></div>');

			if( $.alerts.dialogClass ) $("#popup_container").addClass($.alerts.dialogClass);

			// IE6 Fix
			var pos = ($.browser.msie && parseInt($.browser.version) <= 6 ) ? 'absolute' : 'fixed';

			$("#modalBody").text(msg);
			$("#modalBody").html( $("#modalBody").text().replace(/\n/g, '<br />') );

			var html_org = $("#modalBody").html();
			var html_calc = "<span id='html_cal' style='display:none'>" + $("#modalBody").html() + "</span>";

			//Text 내용의 넓이 체크
			$("body").append(html_calc);
			var width = $("#html_cal").width() + 34;

			if( $.alerts.dialogSize == "small" ) {
				if( width >= 300 ) width = 300;
			} else {
				if( width >= 600 ) width = 600;
			}

			if( width <= 260 ) width = 260;

			$("#alert-modal-dialog").css("width", width);
			$("#html_cal").remove();


			$("#popup_container").css({
				minWidth: $("#popup_container").outerWidth(),
				maxWidth: $("#popup_container").outerWidth()
			});

			$("#button_close").click(function() {
				$.alerts._hide();
			});

			switch( type ) {
				case 'alert':
					$("#popup_container").addClass("alert-message");
					$("#modalLabel").html('<i class="fa fa-exclamation-triangle"></i>' + title);
					$("#modalFooter").append('<button type="button" class="btn btn-blue" id="button_ok" data-dismiss="modal">' + $.alerts.okButton + '</button>');
					$("#button_ok").click( function() {
						$.alerts._hide();
						callback(true);
					});
					$("#button_ok").focus().keypress( function(e) {
						if( e.keyCode == 13 || e.keyCode == 27 ) $("#button_ok").trigger('click');
					});
				break;
				case 'confirm':
					$("#modalLabel").html('<i class="fa fa-check"></i>' + title);
					$("#modalFooter").append(
							'<button type="button" class="btn btn-default" id="button_cancel" data-dismiss="modal">' + $.alerts.cancelButton + '</button> ' +
							'<button type="button" class="btn btn-blue" id="button_ok" data-dismiss="modal">' + $.alerts.okButton + '</button> '

						);
					$("#button_ok").click( function() {
						$.alerts._hide();
						if( callback ) callback(true);
					});
					$("#button_cancel").click( function() {
						$.alerts._hide();
					});
					$("#button_ok").focus();
					$("#button_ok, #button_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#button_ok").trigger('click');
						if( e.keyCode == 27 ) $("#button_cancel").trigger('click');
					});
				break;

				case 'confirmForCancel':
					$("#modalLabel").html('<i class="fa fa-check"></i>' + title);
					$("#modalFooter").append(
							'<button type="button" class="btn btn-blue" id="button_yes" data-dismiss="modal">' + $.alerts.yesButton + '</button> ' +
							'<button type="button" class="btn btn-dark" id="button_no" data-dismiss="modal">' + $.alerts.noButton + '</button> ' +
							'<button type="button" class="btn btn-default" id="button_cancel" data-dismiss="modal">' + $.alerts.cancelButton + '</button> '
						);

					$("#button_yes").click( function() {
						$.alerts._hide();
						if( callback ) callback(true);
					});

					$("#button_no").click( function() {
						$.alerts._hide();
						if( callback ) callback(false);
					});

					$("#button_cancel").click( function() {
						$.alerts._hide();
					});

					$("#button_ok").focus();
					$("#button_ok, #button_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#button_ok").trigger('click');
						if( e.keyCode == 27 ) $("#button_cancel").trigger('click');
					});
				break;

				case 'confirmForYesNo':
					$("#modalLabel").html('<i class="fa fa-check"></i>' + title);
					$("#modalFooter").append(
							'<button type="button" class="btn btn-blue" id="button_yes" data-dismiss="modal">' + $.alerts.yesButton + '</button> ' +
							'<button type="button" class="btn btn-dark" id="button_no" data-dismiss="modal">' + $.alerts.noButton + '</button> '
						);

					$("#button_yes").click( function() {
						$.alerts._hide();
						if( callback ) callback(true);
					});

					$("#button_no").click( function() {
						$.alerts._hide();
						if( callback ) callback(false);
					});

					$("#button_ok").focus();
					$("#button_ok, #button_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#button_ok").trigger('click');
						if( e.keyCode == 27 ) $("#button_cancel").trigger('click');
					});
				break;

				case 'prompt':
					$("#modalBody").append('<input type="text" size="30" id="popup_prompt" />');
					$("#modalFooter").append(
							'<button type="button" class="btn btn-default" id="button_cancel" data-dismiss="modal">' + $.alerts.cancelButton + '</button> ' +
							'<button type="button" class="btn btn-blue" id="button_ok" data-dismiss="modal">' + $.alerts.okButton + '</button> '

						);
					$("#popup_prompt").width( $("#modalBody").width() );
					$("#button_ok").click( function() {
						var val = $("#popup_prompt").val();
						$.alerts._hide();
						if( callback ) callback( val );
					});
					$("#button_cancel").click( function() {
						$.alerts._hide();
					});
					$("#popup_prompt, #button_ok, #button_cancel").keypress( function(e) {
						if( e.keyCode == 13 ) $("#button_ok").trigger('click');
						if( e.keyCode == 27 ) $("#button_cancel").trigger('click');
					});
					if( value ) $("#popup_prompt").val(value);
					$("#popup_prompt").focus().select();
				break;
				case 'info':
					$("#popup_container").addClass("info-message");
					$("#modalLabel").html('<i class="fa fa-info-circle" style="margin-right:5px"></i>' + title);
					$("#modalFooter").append('<button type="button" class="btn btn-blue" id="button_ok" data-dismiss="modal">' + $.alerts.okButton + '</button>');
					$("#button_ok").click( function() {
						$.alerts._hide();
						callback(true);
					});
					$("#button_ok").focus().keypress( function(e) {
						if( e.keyCode == 13 || e.keyCode == 27 ) $("#button_ok").trigger('click');
					});
				break;
			}

			// Make draggable
			if( $.alerts.draggable ) {
				try {
					$("#popup_container").draggable({ handle: $("#modalHeader") });
					$("#modalHeader").css({ cursor: 'move' });
				} catch(e) { /* requires jQuery UI draggables */ }
			}
		},

		_hide: function() {
			$("#popup_container").remove();
			$("body").removeClass("modal-open");
			$(".modal-backdrop").remove();
			$.alerts._overlay('hide');
			$.alerts._maintainPosition(false);
		},

		_overlay: function(status) {
			switch( status ) {
				case 'show':
					$.alerts._overlay('hide');
				break;
				case 'hide':
					$("#popup_overlay").remove();
				break;
			}
		},

		_reposition: function() {
			var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
			var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
			if( top < 0 ) top = 0;
			if( left < 0 ) left = 0;

			// IE6 fix
			if( $.browser.msie && parseInt($.browser.version) <= 6 ) top = top + $(window).scrollTop();

			$("#popup_container").css({
				top: top + 'px',
				left: left + 'px'
			});
			$("#popup_overlay").height( $(document).height() );
		},

		_maintainPosition: function(status) {
			if( $.alerts.repositionOnResize ) {
				switch(status) {
					case true:
						$(window).bind('resize', $.alerts._reposition);
					break;
					case false:
						$(window).unbind('resize', $.alerts._reposition);
					break;
				}
			}
		}

	}

	// Shortuct functions
	jAlert = function(message, callback, title, target) {
		$.alerts.alert(message, callback, title, target);
	}

	jConfirm = function(message, callback, title) {
		$.alerts.confirm(message, callback, title);
	};

	jConfirmForCancel = function(message, callback, title, cancelYn) {
		$.alerts.confirmForCancel(message, callback, title, cancelYn);
	};

	jPrompt = function(message, value, title, callback) {
		$.alerts.prompt(message, value, title, callback);
	};

	jInfo = function(message, callback, title) {
		$.alerts.info(message, callback, title);
	};

})(jQuery);