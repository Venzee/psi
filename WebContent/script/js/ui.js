(function($) {
	$.fn.dg = function(settings) {
		//var config = $.extend(def, settings);
	};
	
	$.dg = function(settings){
		
	};
	
	$.dgform = function(settings){
		var config = initConfig(settings);
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
		var html = '<div class="ui-table ui-form ui-dialog" id="dialog" style="width: '
				+ config.width
				+ 'px;">'
				+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name ui-form-title-name">'
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
		initComm(config, html);
		/* 提交 */
		config.target.find('.btn-sub').on('click', function() {
			var datas = 'randomNum=' + Math.random();
			$.each(config.target.find('.form-value'), function(i, n) {
				datas = datas + "&" + $(this).attr('name') + "=" + $(this).val();
			});
			var params = $.extend({
				type : 'POST',
				url : 'add',
				data : datas,
				beforeSend : function() {
					config.target.find('.ui-dialog').fadeOut('fast', function() {
						$(this).remove();
					});
					$.showLoading(config.target);
				},
				success : function(msg) {
					if (msg == 'true') {
						var form = config.target.find('#mainFrame').contents().find('.pageForm');
						if(form != undefined && form.hasClass('pageForm')){
							form.submit();
						} else {
							var src = config.target.find('#mainFrame').attr('src');
							src = src.substring(0, src.indexOf('=')) + '=' + Math.random();
							config.target.find('#mainFrame').attr('src', src);
						}
					}
				},
				complete : function(){
					$.hideLoading(config.target);
					$.hideCover(config.target);
				} 
			}, config.data);
			$.ajax(params);
		});
	};
	
	$.dgtable = function(settings){
		//var config = initConfig(settings);
	};
	
	$.dgconfirm = function(settings){
		var config = initConfig(settings);
		switch (config.level) {
		case 'info':
			config.title = '提示';
			break;
		case 'warning':
			config.title = '警告';
			break;
		case 'error':
			config.title = '错误';
			break;
		}
		if(settings.width == undefined || settings.width == '' || config.width < 200){
			config.width = 300;
		}
		var html = '<div class="ui-table ui-tip ui-dialog" id="dialog" style="width: '
			+ config.width
			+ 'px;">'
			+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name ui-tip-title-name">'
			+ config.title
			+ '</div></div></div><div class="tip-body">'
			+ '<div class="tip-msg"><span class="tip-' + config.level + '">'
			+ config.msg
			+ '</span></div>'
			+ '<div class="clear"></div></div>'
			+ '<div class="ui-foot"><div class="ui-operation"><div class="ui-btn btn-close">取消</div><div class="ui-btn btn-sub">确定</div></div></div></div>';
		initComm(config, html);
		config.target.find('.btn-sub').on('click', function() {
			config.cover = false;
			dialogClose(config);
			config.callBack();
		});
		
	};
	
	$.dgtip = function(settings){
		var config = initConfig(settings);
		switch (config.level) {
		case 'info':
			config.title = '提示';
			break;
		case 'warning':
			config.title = '警告';
			break;
		case 'error':
			config.title = '错误';
			break;
		}
		if(settings.width == undefined || settings.width == '' || config.width < 200){
			config.width = 300;
		}
		var html = '<div class="ui-table ui-tip ui-dialog" id="dialog" style="width: '
			+ config.width
			+ 'px;">'
			+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name ui-tip-title-name">'
			+ config.title
			+ '</div>'
			+ '<div class="ui-operation"><div class="ui-btn btn-close">关闭</div></div></div></div><div class="tip-body">'
			+ '<div class="tip-msg"><span class="tip-' + config.level + '">'
			+ config.msg
			+ '</span></div>'
			+ '<div class="clear"></div></div></div>';
		
		initComm(config, html);
		if(config.autoClose){
			top.setTimeout(function(){dialogClose(config);}, config.time);
		}
	};
	
	/* 显示覆盖层 */
	$.showCover = function(obj) {
		var cover = '<div id="cover"></div>';
		obj.append(cover);
		obj.find('#cover').fadeIn('fast');
	};
	
	/* 隐藏覆盖层 */
	$.hideCover = function(obj) {
		obj.find('#cover').fadeOut('fast', function() {
			$(this).remove();
		});
	};
	
	/* 显示loading层 */
	$.showLoading = function(obj) {
		var left = (obj.width() - 32) / 2;
		var top = (obj.height() - 32) / 2;
		var loading = '<img id="load" style="left: ' + left + 'px; top: ' + top + 'px" src="style/image/loading.gif" />';
		obj.append(loading);
		obj.find('#load').fadeIn('fast');
	};
	
	/* 隐藏loading层 */
	$.hideLoading = function(obj) {
		obj.find('#load').fadeOut('fast', function() {
			$(this).remove();
		});
	};
	
	function initConfig(settings){
		return $.extend({
			width : 700,
			title : '标题',
			label : [],
			source : [],
			data : {},
			cover : true,
			autoOpen : true,
			autoClose : false,
			msg : '提示',
			level: 'info', //info,warning,error
			time : 1500,
			position : 'center',
			target : top.$('body'),
			type : 'form',
			callBack : function(){}
		}, settings);
	}
	
	/* 初始化公共数据 */
	function initComm(config, html){
		config.target.append(html);
		/* 定位 */
		autoPosition(config);
		config.target.find('.ui-dialog').slideDown('fast');
		/* 取消&关闭 */
		config.target.find('.btn-close').on('click', function() {
			dialogClose(config);
		});
		if (config.cover) {
			$.showCover(config.target);
		}
	};
	
	/* 自动定位 */
	function autoPosition(config){
		var left = (config.target.width() - config.width) / 2;
		var top = (config.target.height() - config.target.find('.ui-dialog').height()) / 2;
		switch (config.position) {
		case 'center':
			config.target.find('.ui-dialog').css({
				left : left,
				top : top
			});
			break;
		case 'center-top':
			config.target.find('.ui-dialog').css({
				left : left
			});
			break;
		case 'left-top':
			config.target.find('.ui-dialog').css({
				
			});
			break;
		case 'left-center':
			config.target.find('.ui-dialog').css({
				top : top
			});
			break;
		case '':
			config.target.find('.ui-dialog').css({
				
			});
			break;
		}
	}
	
	/* 关闭弹出层 */
	function dialogClose(config){
		if (config.cover) {
			$.hideCover(config.target);
		}
		config.target.find('.ui-dialog').fadeOut('fast', function() {
			$(this).remove();
		});
	}
})(jQuery);