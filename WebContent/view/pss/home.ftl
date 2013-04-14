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
		function iframeAutoHeight(){
			if($("#frame iframe").contents().find('body').height() > $('#frame').height()){
				$('#frame').css('padding-right', '0');
			}else{
				$('#frame').css('padding', '0 15px');
			}
			$('#frame iframe').height($('#frame').height());
		}
		$(document).ready(function(){
			$('#menu').height($(document).height() - $('#head').height() -1);
			$('#main').width($(document).width() - $('#menu').width());
			$('#main').height($(document).height() - $('#head').height() -1);
			$('#frame').height($('#main').height() - $('#menu-navi').height() - 40);
			$('#title_in').bind({
				mouseover:function(){
					$('#navi').show('fast');
					$('#navi').bind({
						mouseout:function(){$(this).hide('fast');}
					})
				}
			})
			$(window).scroll(function(){
				if($(window).scrollTop() > $('#top').height()){
					$('#fastnavi').css('margin-top', $(window).scrollTop() - $('#top').height());
				}else{
					$('#fastnavi').css('margin-top', 0);
				}
			})
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
					var title = $(this).parents('dl').find('.menu-title').text() + ' >> ' + $(this).text();
					$('#navi-title').text(title);
					var url = $(this).attr('title') + '?randomNum=' + Math.random();
					$('#mainFrame').attr('src', url);
				}
			});
		});
	</script>
	<body>
		<div id="head">
			<div id="panel">
				<div id="user">
					<div>欢迎您：管理员 Venzee</div>
					<div>当前时间：2013年3月25日13:09:57</div>
				</div>
			</div>
		</div>		
	    <div id="content">
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
		    <div id="main">
		    	<div id="menu-navi"><div id="navi-title">首页</div></div>
			    <div id="frame">
					<iframe onload="iframeAutoHeight()" frameborder="0" scrolling="yes" width="100%" src="pss/inventory/sort/select/init?topId=0" id="mainFrame" name="mainFrame"></iframe>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</body>
</html>
