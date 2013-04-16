(function($) {
	$.dialog = function(setting) {
		var config = $.extend({
			width : 700,
			title : '标题',
			label : [],
			source : [],
			data : {},
			cover : true,
			autoOpen : true,
			target : $('body'),
			type : 'form'
		}, setting);
		var html = '';
		if (config.type == 'form') {
			var sourceName = '';
			$.each(config.label, function(i, n) {
				if ($.isPlainObject(n)) {
					sourceName = sourceName + '<dd class="' + n.style + '">' + n.name + '</dd>';
				} else {
					sourceName = sourceName + '<dd>' + n + '</dd>';
				}
			});
			var sourceValue = '';
			$.each(config.source, function(i, n) {
				sourceValue = sourceValue + '<dd>' + n + '</dd>';
			});
			html = '<div class="ui-table ui-form dialog" id="dialog" style="width: '
					+ config.width
					+ 'px;">'
					+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name">'
					+ config.title
					+ '</div>'
					+ '<div class="ui-operation"><div class="ui-btn btn-close">关闭</div></div></div></div><div class="form-source">'
					+ '<dl class="form-source-name">'
					+ sourceName
					+ '</dl>'
					+ '<dl class="form-source-value">'
					+ sourceValue
					+ '</dl><div class="clear"></div></div>'
					+ '<div class="ui-foot"><div class="ui-operation"><div class="ui-btn btn-sub">提交</div></div></div></div>';
		}
		config.target.append(html);
		/* 居中 */
		var left = (config.target.width() - config.width) / 2;
		var top = (config.target.height() - config.target.find('.dialog').height()) / 2;
		config.target.find('.dialog').css({
			left : left,
			top : top
		});

		config.target.find('.dialog').slideDown();
		config.target.find('.btn-close').on('click', function() {
			if (config.cover) {
				$.hideCover(config.target);
			}
			$(this).parents('.dialog').slideUp(function() {
				$(this).remove();
			});
		});
		if (config.cover) {
			$.showCover(config.target);
		}
	};
	$.showCover = function(obj) {
		var cover = '<div id="cover"></div>';
		obj.append(cover);
		obj.find('#cover').fadeIn();
	};
	$.hideCover = function(obj) {
		obj.find('#cover').fadeOut(function() {
			$(this).remove();
		});
	};
	$.showLoading = function(obj) {
		var left = (obj.width() - 32) / 2;
		var top = (obj.height() - 32) / 2;
		var loading = '<img id="load" style="left: ' + left + 'px; top: ' + top + 'px" src="style/image/loading.gif" />';
		obj.append(loading);
		obj.find('#load').fadeIn();
	};
	$.hideLoading = function(obj) {
		obj.find('#load').fadeOut(function() {
			$(this).remove();
		});
	};
})(jQuery);
