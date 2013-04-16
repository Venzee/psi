function frameAutoSize(oIframe) {
	try {
		var oWin = oIframe.name ? window.frames[oIframe.name]
				: oIframe.contentWindow;
		oIframe.style.height = oWin.document.body.scrollHeight + "px";
		oIframe.style.width = oWin.document.body.width + "px";
	} catch (e) {
	}
}

function getChildFrame(selector) {
	return $("#ui-iframe").contents().find(selector);
};

$(document).ready(function() {
	function checked() {
		var isCheckAll = true;
		$.each($('.ui-table').find('.checkbox'), function(i, n) {
			if ($(this).attr('class') == 'checkbox') {
				isCheckAll = false;
			}
		});
		return isCheckAll;
	}
	$('.btn-check-all').click(function() {
		if ($(this).text() == '全选') {
			$('.ui-table').find('.checkbox').addClass('checked');
			$(this).text('不全选');
		} else {
			$('.ui-table').find('.checkbox').removeClass('checked');
			$(this).text('全选');
		}
	});
	$('.btn-check-invert').click(function() {
		$('.ui-table').find('.checkbox').toggleClass('checked');
		if (checked()) {
			$('.btn-check-all').text('不全选');
		} else {
			$('.btn-check-all').text('全选');
		}
	});
	$('.table-source-line').click(function() {
		$(this).find('.checkbox').toggleClass('checked');
		if (checked()) {
			$('.btn-check-all').text('不全选');
		} else {
			$('.btn-check-all').text('全选');
		}
	});
});
