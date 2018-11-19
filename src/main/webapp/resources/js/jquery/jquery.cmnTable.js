/**
 *
 */
$.fn.rowspan = function(colIdx, isStats) {
	return this.each(function() {
		var that;
		$('tr', this).each(function(row) {
			$('td:eq(' + colIdx + ')', this).filter(":visible").each( function(col) {
				if( $(this).html() == $(that).html() && (!isStats || isStats && $(this).prev().html() == $(that).prev().html())) {
					rowspan = $(that).attr("rowspan")||1;
					rowspan = Number(rowspan) + 1;
					$(that).attr("rowspan", rowspan);

					$(this).hide();
				} else {
					that = this;
				}

				that = ( that == null ) ? this : that;
			});
		});

	});

}

$.fn.colspan = function(rowIdx) {
	return this.each(function() {
		var that;
		$('tr', this).filter(":eq(" + rowIdx + ")").each(function(row) {
			$(this).find('th').filter(':visible').each(function(col) {
				if( $(this).html() == $(that).html()) {
					colspan = $(that).attr("colspan") || 1;
					colspan = Number(colspan) + 1;

					$(that).attr("colspan", colspan);
					$(this).hide();
				} else {
					that = this;
				}

				that = (that == null)? this : that;
			});
		});
	});
}