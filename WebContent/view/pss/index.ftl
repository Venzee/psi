<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="style/css/pss.css">
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/comm.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			/* 菜单控制 */
			$('#menuList dt.menu-title').on('click', function() {
				if ($(this).hasClass('active')) {
					$(this).nextAll('dd.menu-item').slideUp();
					$(this).next('dt.top-line').slideUp('fast');
					$('#menuList dt.menu-title').removeClass('active');
				}else{
					$('#menuList dt.top-line').slideUp('fast');
					$('#menuList dd.menu-item').slideUp('fast');
					$('#menuList dt.menu-title').removeClass('active');
					$(this).next('dt.top-line').slideDown('fast');
					$(this).addClass('active').nextAll('dd.menu-item').slideDown('fast');
				}
			});
			$('dd.menu-item').find('span').on('click', function(){
				if (!$(this).hasClass('active')) {
					$.showCover();
					$.showLoading();
					$('dd.menu-item').find('span').removeClass('active');
					$(this).addClass('active');
					var title = $(this).parents('dl').find('dt.menu-title').text() + ' >> ' + $(this).text();
					$('#navi-title').text(title);
					var url = $(this).attr('title') + '?randomNum=' + Math.random();
					$('#mainFrame').attr('src', url);
					if ($('#mainFrame').get(0).attachEvent){  
					    $('#mainFrame').get(0).attachEvent("onload", function(){  
					        $.hideLoading();
							$.hideCover();
					    });  
					} else {  
					    $('#mainFrame').get(0).onload = function(){  
					        $.hideLoading();
							$.hideCover();
					    };  
					} 
					
				}
			});
		});
	</script>
</head>
<body class="frame_class">
	<div id="head">
		<div id="panel">
			<div id="user">
				<div>欢迎您：管理员 Venzee</div>
				<div>当前时间：2013年3月25日13:09:57</div>
			</div>
		</div>
	</div>
	<div id="menu">
    	<div id="menuList">
    		<dl class="menu-items">
    			<dt class="menu-title">仓库中心</dt>
    			<dt class="top-line"></dt>
   				<dd class="menu-item"><span title="inventory/brand/list">品牌管理</span></dd>
   				<dd class="menu-item"><span title="inventory/sort/list">商品类型</span></dd>
              	<dd class="menu-item"><span title="inventory/goods/list">商品管理</span></dd>
            </dl>
			<dl class="menu-items">
    			<dt class="menu-title">单据中心</dt>
    			<dt class="top-line"></dt>
           		<dd class="menu-item"><span title="receipt/all/list">单据汇总</span></dd>
           		<dd class="menu-item"><span title="receipt/all/list">销售单据</span></dd>
           		<dd class="menu-item"><span title="receipt/all/list">进货单据</span></dd>
           	</dl>
           	<dl class="menu-items">
                <dt class="menu-title">用户中心</dt>
                <dt class="top-line"></dt>
           	</dl>
           	<dl class="menu-items">
                <dt class="menu-title">客户中心</dt>
                <dt class="top-line"></dt>
                <dd class="menu-item"><span title="org/all/list">客户管理</span></dd>
                <dd class="menu-item"><span title="relation/all/list">往来单位</span></dd>
           	</dl>
           	<dl class="menu-items">
                <dt class="menu-title">系统设置</dt>
                <dt class="top-line"></dt>
           		<dd class="menu-item"><span title="sys/menu/list">菜单管理</span></dd>
           		<dd class="menu-item"><span title="org/industry/list">行业管理</span></dd>
           	</dl>
	    </div>
    </div>
    <div id="menu-navi"><span id="navi-title">首页</span></div>
	<div id="mainFrameContainer">
		<iframe src="" name="mainFrame" id="mainFrame" frameborder="no" scrolling="yes" hidefocus></iframe>
	</div>
</body>
</html>