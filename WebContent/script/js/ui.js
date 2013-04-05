(function($, undefined) {
	$.fn.extend({
		dialog : function(setting) {
			var obj = this;
			var config = $.extend({
				width : 700,
				title : '标题',
				label : [],
				source : [],
				data : {},
				modal : true,
				autoOpen : true
			}, setting);
			obj.width(config.width);
			var titleName = obj.find('.ui-title-name');
			titleName.text(config.title);
			var sourceName = obj.find('.form-source-name');
			$.each(config.label, function(i, n) {
				var element;
				if ($.isPlainObject(n)) {
					element = '<dd class=' + n.style + '>' + n.name + '</dd>';
				} else {
					element = '<dd>' + n + '</dd>';
				}
				sourceName.append(element);
			});
			var sourceValue = obj.find('.form-source-value');
			$.each(config.source, function(i, n) {
				sourceValue.append('<dd>' + n + '</dd>');
			});
			var left = ($(document).width() - obj.outerWidth()) / 2;
			var top = ($(document).height() - obj.outerHeight()) / 2;
			obj.css({
				left : left,
				top : top
			});
			if(config.modal){
				obj.modal.open();
			}
			if (config.autoOpen) {
				obj.slideDown();
			}
			obj.find('.btn-close').click(function() {
				if(config.modal){
					obj.modal.close();
				}
				$.each(sourceName.find('dd'), function() {
					$(this).slideUp();
				});
				$.each(sourceValue.find('dd'), function() {
					$(this).slideUp();
				});
				obj.slideUp(function(){
					obj.clear(sourceName);
					obj.clear(sourceValue);
				});
			});
			obj.find('.btn-sub').click(function() {
				var datas = 'randomNum=' + Math.random();
				$.each($('#dialog .form-value'), function(i, n) {
					datas = datas + "&" + $(this).attr('name') + "="
							+ $(this).val();
				});
				var params = $.extend({
					type : 'POST',
					url : 'add',
					data : datas,
					beforeSend : function() {
					},
					success : function(msg) {
						if (msg == 'true') {
							$(document).find('#mainFrame').contents().find('.pageForm').submit();
						}
					},
					complete : function(){
						obj.modal.close();
						obj.slideUp();
						obj.clear(sourceName);
						obj.clear(sourceValue);
					} 
				}, config.data);
				$.ajax(params);
			});
		},
		loading : {
			open : function() {
				var left = ($(window).width() - $('#load').outerWidth()) / 2;
				var top = ($(window).height() - $('#load').outerHeight()) / 2;
				$('#load').css({
					left : left,
					top : top
				});
				$('#load').fadeIn();
			},
			close : function() {
				$('#load').fadeOut();
			}
		},
		modal : {
			open : function() {
				$('#modal').fadeIn();
			},
			close : function() {
				$('#modal').fadeOut();
			}
		},
		clear : function(target) {
			target.html('');
		}
	});
})(jQuery);
