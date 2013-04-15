<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="style/css/pss.css">
		<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="script/js/comm.js"></script>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			/* 菜单控制 */
			$('#menuList .menu-title').click(function() {
				if ($(this).hasClass('active')) {
					$(this).nextAll('.menu-item').slideUp();
					$(this).next('.top-line').slideUp('fast');
					$('#menuList .menu-title').removeClass('active');
				}else{
					$('#menuList .top-line').slideUp('fast');
					$('#menuList .menu-item').slideUp('fast');
					$('#menuList .menu-title').removeClass('active');
					$(this).next('.top-line').slideDown('fast');
					$(this).addClass('active').nextAll('.menu-item').slideDown('fast');
				}
			});
			$('.menu-item span').click(function(){
				if (!$(this).hasClass('active')) {
					$('.menu-item span').removeClass('active');
					$(this).addClass('active');
					//var title = $(this).parents('dl').find('.menu-title').text() + ' >> ' + $(this).text();
					//$('#navi-title').text(title);
					var url = $(this).attr('title') + '?randomNum=' + Math.random();
					self.parent.frames['mainFrame'].src = url;
					//$('#mainFrame').attr('src', url);
				}
			});
		});
	</script>
	<body>
	    <div id="menu">
	    	<div id="menuList">
	    		<!-- <div id="menu-head">进销存首页</div> -->
	    		<dl class="menu-items">
	    			<dt class="menu-title">仓库中心</dt>
	    			<dt class="top-line"></dt>
	   				<dd class="menu-item"><span id="A00" title="pss/inventory/brand/list">品牌管理</span></dd>
	   				<dd class="menu-item"><span id="A01" title="pss/inventory/sort/list">商品类型</span></dd>
                  	<dd class="menu-item"><span id="A02" title="pss/inventory/goods/list">商品管理</span></dd>
                </dl>
				<dl class="menu-items">
	    			<dt class="menu-title">单据中心</dt>
	    			<dt class="top-line"></dt>
               		<dd class="menu-item"><span id="B00" title="pss/receipt/list">单据管理</span></dd>
               	</dl>
            	<dl class="menu-items">
                    <dt class="menu-title">基础设置</dt>
                    <dt class="top-line"></dt>
               		<dd class="menu-item"><span id="C00" title="customer/organization/industry/list">行业管理</span></dd>
               	</dl>
		    </div>
	    </div>
	</body>
</html>
