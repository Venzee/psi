(function($, undefined) {
	var modalHtml = '<div id="modal"><img id="load" src="style/image/loading.gif" /></div>';
	$.fn.dialog = function(){
		var config = $.extend({
			width : 700,
			title : '标题',
			label : [],
			source : [],
			data : {},
			modal : true,
			autoOpen : true,
			type: 'form'
		}, setting);
		
		var sourceName = '';
		$.each(config.label, function(i, n) {
			if ($.isPlainObject(n)) {
				sourceName = sourceName + '<dd class=' + n.style + '>' + n.name + '</dd>';
			} else {
				sourceName = sourceName + '<dd>' + n + '</dd>';
			}
		});
		var sourceValue = '';
		$.each(config.source, function(i, n) {
			sourceValue = sourceValue + '<dd>' + n + '</dd>';
		});
		
		var left = ($(document).width() - obj.outerWidth()) / 2;
		var top = ($(document).height() - obj.outerHeight()) / 2;
		
		var formHtml = '<div class="ui-table ui-form dialog" id="dialog" style="display: blodk; width: ' + config.width + 'px; left: ' + left + 'px; top: ' + top + 'px">'
			+'<div class="ui-head"><div class="ui-title"><div class="ui-title-name">' + config.title + '</div>'
			+'<div class="ui-operation"><div class="ui-btn btn-close">关闭</div></div></div></div><div class="form-source">'
			+'<dl class="form-source-name">' + sourceName + '</dl>'
			+'<dl class="form-source-value">' + sourceValue + '</dl><div class="clear"></div></div>'
			+'<div class="ui-foot"><div class="ui-operation"><div class="ui-btn btn-sub">提交</div></div></div></div>';
		parent.$('body').append(formHtml);
	};
})(jQuery);
