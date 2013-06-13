(function($) {
	$.fn.extend({
		
		aiMegamenu: function(){

	         return this.each(function(){

	           var $thisNav = $(this);
	           setMegamenu();

	           // check if fonts are loaded
	           var wid = $('#nav').width(),
	               interval = 300,
	               times = 10,
	               currWid = wid,
	               counter = 0;

	           var timer = setInterval(function(){
	                currWid = $('#nav').width();
	                if (currWid != wid){
	                  setMegamenu();
	                }
	                else if (counter >=times-1)
	                {
	                    clearInterval(timer);
	                }
	                counter++;
	              }, interval);

	            // set megamenu position
	            function setMegamenu(){
	                var $navWrapper = $thisNav.closest('.hp-center'),
	                    pageWidth = $navWrapper.width();
	                    
	                $navWrapper.css({position: 'relative'});

	                $thisNav.children().each(function(){
	                  var $thisMegaMenu = $(this).find('.megamenu'),
	                      menuWidth = $thisMegaMenu.outerWidth(),
	                      thisWidth = $(this).width();
	                   if ($(this).position().left + menuWidth > pageWidth){

	                     $(this).hover(
	                       function(){
	                          $thisMegaMenu.css({marginTop: 0, marginLeft: -(menuWidth - thisWidth)})
	                       },

	                        function(){
	                          $thisMegaMenu.removeAttr('style');
	                        }
	                      );

	                     }
	                     else{
	                       $(this).hover(
	                         function(){
	                           $thisMegaMenu.css({margin: 'auto'});
	                         },
	                         function(){
	                           $thisMegaMenu.removeAttr('style');
	                         }
	                       );

	                     }
	                 });

	                 $navWrapper.removeAttr('style');
	                 clearInterval(timer);
	              }

	           });

	         }
	});
	
	var odg = null;
	$.fn.dg = function(settings) {
		var config = initConfig(settings);
		var html = '<div class="ui-table ui-tip ui-dialog" id="dg" style="width: ' + config.width + 'px;">'
			+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name ui-tip-title-name">' + config.title + '</div>'
			+ '<div class="ui-operation"><div class="ui-btn btn-close">关闭</div></div></div></div><div class="source">'
			+ $(this).html()
			+ '</div></div>';
		tissueDG(config, html);
		//$(this).appendTo('div.form-source');
	};
	
	$.dg = function(settings){
		
	};
	
	$.dgframe = function(settings){
		var config = initConfig(settings);
		var html = '<div class="ui-table ui-tip ui-dialog" id="dg" style="width: '
			+ config.width
			+ 'px;">'
			+ '<div class="ui-head"><div class="ui-title"><div class="ui-title-name ui-tip-title-name">'
			+ config.title
			+ '</div>'
			+ '<div class="ui-operation"><div class="ui-btn btn-close">关闭</div></div></div></div>'
			+ '<iframe src=""></iframe>'
			+ '</div></div>';
		tissueDG(config, html);
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
		var html = '<div class="ui-table ui-form ui-dialog" id="dg" style="width: '
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
		tissueDG(config, html);
		/* 提交 */
		odg.find('div.btn-sub').on('click', function() {
			if(null !== config.onSub && $.isFunction(config.onSub)){
				config.onSub();
			}
			var datas = 'randomNum=' + Math.random();
			$.each(odg.find('dd').find('.form-value'), function(i, n) {
				datas = datas + '&' + $(this).attr('name') + '=' + $(this).val();
				odg.data($(this).attr('name'), $(this).val()); // 缓存数据
			});
			$.ajax({
				type : 'POST',
				url : config.url,
				data : datas,
				beforeSend : function() {
					odg.fadeOut('fast');
					$.showLoading(config.target);
				},
				success : function(data) {
					if(null !== config.sucSub && $.isFunction(config.sucSub)){
						config.sucSub(data);
					}else{
						if (data === 'true' || data === true) {
							var form = config.target.find('#mainFrame').contents().find('form.pageForm');
							if(form !== undefined && form.hasClass('pageForm')){
								form.submit();
							} else {
								var src = config.target.find('#mainFrame').attr('src');
								src = src.substring(0, src.indexOf('=')) + '=' + Math.random();
								config.target.find('#mainFrame').attr('src', src);
							}
						}
					}
				},
				complete : function(){
					odg.remove();
					$.hideLoading(config.target);
					$.hideCover(config.target);
				} 
			});
		});
	};
	
	$.dgtable = function(settings){
		var config = initConfig(settings);
		
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
		if(settings.width === undefined || settings.width === '' || config.width < 200){
			config.width = 300;
		}
		var html = '<div class="ui-table ui-tip ui-dialog" id="dg" style="width: '
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
		tissueDG(config, html);
		odg.find('div.btn-sub').on('click', function() {
			config.cover = false;
			dialogClose(config);
			if(null !== config.onSub && $.isFunction(config.onSub)){
				config.onSub();
			}
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
		if(settings.width === undefined || settings.width === '' || config.width < 200){
			config.width = 300;
		}
		var html = '<div class="ui-table ui-tip ui-dialog" id="dg" style="width: '
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
		
		tissueDG(config, html);
		if(config.autoClose){
			top.setTimeout(function(){dialogClose(config);}, config.time);
		}
	};
	
	/* 获取缓存的FORM-SOURCE-VALUE */
	$.getODGSourceVal = function(key){
		return odg.data(key);
	};
	
	$.dgClose = function(){
		odg.remove();
	};
	
	/* 显示覆盖层 */
	$.showCover = function(obj) {
		obj = initObj(obj);
		var cover = '<div id="cover"></div>';
		obj.append(cover);
		obj.find('#cover').fadeIn('fast');
	};
	
	/* 隐藏覆盖层 */
	$.hideCover = function(obj) {
		obj = initObj(obj);
		obj.find('#cover').fadeOut('fast', function() {
			$(this).remove();
		});
	};
	
	/* 显示loading层 */
	$.showLoading = function(obj) {
		obj = initObj(obj);
		var left = (obj.width() - 32) / 2;
		var top = (obj.height() - 32) / 2;
		var loading = '<img id="load" style="left: ' + left + 'px; top: ' + top + 'px" src="style/image/loading.gif" />';
		obj.append(loading);
		obj.find('#load').fadeIn('fast');
	};
	
	/* 隐藏loading层 */
	$.hideLoading = function(obj) {
		obj = initObj(obj);
		obj.find('#load').fadeOut('fast', function() {
			$(this).remove();
		});
	};
	
	/* 初始化TARGET OBJECT */
	function initObj(obj){
		if(obj === null || obj === '' || obj === undefined){
			obj = top.$('body');
		}
		return obj;
	}
	
	/* 初始化配置 */
	function initConfig(settings){
		return $.extend({
			width : 700,
			title : '标题',
			label : [],
			source : [],
			data : {},
			cover : true, // 是否显示遮罩层
			autoOpen : true, // 自动打开
			autoClose : false, // 自动关闭
			msg : '提示', // $.dgconfirm & $.dgtip提示语句
			level: 'info', //$.dgconfirm & $.dgtip 提示级别 info,warning,error
			time : 1500, // 当自动关闭为true时此选项生效（毫秒）
			position : 'center', // 定位
			target : top.$('body'), // 
			url : '',
			onOpen : null,
			onSub : null,
			sucSub : null,
			onClose : null
		}, settings);
	}
	
	/* 组织公共数据 */
	function tissueDG(config, html){
		config.target.append(html);
		if(null !== config.onOpen && $.isFunction(config.onOpen)){
			config.onOpen();
		}
		odg = config.target.find('#dg');
		/* 定位 */
		autoPosition(config);
		/* 显示，绑定取消&关闭事件 */
		odg.slideDown('fast').find('div.btn-close').on('click', function() {
			dialogClose(config);
			if(null !== config.onClose && $.isFunction(config.onClose)){
				config.onClose();
			}
		});
		if (config.cover) {
			$.showCover(config.target);
		}
	};
	
	/* 自动定位 */
	function autoPosition(config){
		var left = (config.target.width() - config.width) / 2;
		var top = (config.target.height() - odg.height()) / 2;
		switch (config.position) {
		case 'center':
			odg.css({
				left : left,
				top : top
			});
			break;
		case 'center-top':
			odg.css({
				left : left
			});
			break;
		case 'left-top':
			break;
		case 'left-center':
			odg.css({
				top : top
			});
			break;
		case 'follow':
			left = event.clientX;
			top = event.clientY;
			odg.css({
				left : left,
				top : top
			});
			break;
		}
	}
	
	/* 关闭弹出层 */
	function dialogClose(config){
		if (config.cover) {
			$.hideCover(config.target);
		}
		odg.fadeOut('fast', function() {
			odg.remove();
		});
	}
})(jQuery);