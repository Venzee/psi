(function($, undefined) {
	$.fn.extend({
		dialog : function(setting) {
			var obj = this;
			var config = {
				width : 700,
				title : '标题',
				label : [],
				source : [],
				data : {},
				modal : true
			};
			config = $.extend(config, setting);
			obj.width(config.width);
			var titleName = obj.find('.title_name');
			titleName.text(config.title);
			var sourceName = obj.find('.source_name');
			$.each(config.label, function(i, n) {
				var element;
				if ($.isPlainObject(n)) {
					element = '<dd class=' + n.style + '>' + n.name + '</dd>';
				} else {
					element = '<dd>' + n + '</dd>';
				}
				sourceName.append(element);
			});
			var sourceValue = obj.find('.source_value');
			$.each(config.source, function(i, n) {
				sourceValue.append('<dd>' + n + '</dd>');
			});
			var left = ($(document).width() - obj.outerWidth()) / 2;
			var top = ($(document).height() - obj.outerHeight()) / 2;
			this.css({
				left : left,
				top : top
			});
			if (config.modal) {
				obj.modal.open();
			}
			obj.slideDown();
			obj.find('.close').click(function() {
				obj.modal.close();
				obj.slideUp();
				obj.clear(sourceName);
				obj.clear(sourceValue);
			});
			obj.find('.sub').click(
					function() {
						var datas = 'randomNum=' + Math.random();
						$.each($('#dialog .form_value'), function(i, n) {
							datas = datas + "&" + $(this).attr('name') + "="
									+ $(this).val();
						});
						var delf = {
							type : 'POST',
							url : 'add',
							data : datas,
							beforeSend : function() {
							},
							success : function(msg) {
								if (msg == 'true') {
									obj.modal.close();
									obj.slideUp();
									obj.clear(sourceName);
									obj.clear(sourceValue);
									$(document).find('#mainFrame').contents()
											.find('.pageForm').submit();
								}
							}
						};
						delf = $.extend(delf, config.data);
						$.ajax(delf);
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

/*
 * digitClocker @author: zhoucl @date : 03/11/2011
 */
(function($, undefined) {
	$.extend($.fn, {
		digitclocker : function(settings) {
			var params = $.extend({
				baseURL : '../js/jquery/custom_plugins/',
				imgPath : 'digits/'
			}, settings);

			for ( var i = 1; i < 9; i++) {
				if (i % 3 == 0)
					$(this).append(
							"<img alt='0' src='" + params.baseURL
									+ params.imgPath + "colon.gif'>");
				else
					$(this).append(
							"<img class='clockImage' alt='0' src='"
									+ params.baseURL + params.imgPath
									+ "0.gif'>");
			}

			new DigitClock(params, $(this));
		}
	});

	setInterval(function() {
		DigitClock.reDraw();
	}, 1000);

	DigitClock = function(params, container) {
		this.params = params;
		this.container = container;

		DigitClock.clocks.push(this);
		DigitClock.reDraw();
	}

	DigitClock.clocks = [];

	DigitClock.reDraw = function() {
		var d = new Date();
		for ( var i = 0; i < this.clocks.length; i++) {
			this.clocks[i]
					.setTime(d.getHours(), d.getMinutes(), d.getSeconds());
		}
	}

	DigitClock.preZero = function(n, pos) {
		return ("0"._digitClockRepeat(pos - 1) + n).slice(-pos);
	}

	DigitClock.prototype = {
		setTime : function(h, i, s) {
			this.setImage(DigitClock.preZero(h, 2) + DigitClock.preZero(i, 2)
					+ DigitClock.preZero(s, 2))
		},

		setImage : function(s) {
			s = s.split("");
			var baseURL = this.params.baseURL;
			var imgPath = this.params.imgPath;
			var i = 0;
			$(".clockImage", this.container).each(function() {
				$(this).attr("src", baseURL + imgPath + s[i++] + ".gif");
			});
		}
	}

	String.prototype._digitClockRepeat = function(n) {
		return new Array(n + 1).join(this);
	}
})(jQuery);
