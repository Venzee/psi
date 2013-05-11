<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="style/css/pss.css">
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/comm.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<style type="text/css">
		html,body {
			overflow: auto;
			overflow-x: hidden;
		}
		html {
			height: 100%;
		}
		#mainFrame{
			position: absolute;
			_position: relative;
		}
		.frame_class{padding:0;
			margin: 0;
			width: 100%;
			height: 100%;
			overflow: hidden;
		}
		#mainFrameContainer{
			position: absolute;
			top: 100px;
			left: 182px;
			bottom: 0;
			right: 0;
			overflow: hidden;
			z-index: 4;
		}
		#mainFrame{
			width: 100%;
			_width: expression(document.body.offsetWidth - 182 + 'px');
			height: 100%;
			*height: expression(document.body.offsetHeight - 100 + 'px');
			z-index: 5;
		}
	</style>
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
	<script type="text/javascript">
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
				$.showCover();
				$.showLoading();
				$('.menu-item span').removeClass('active');
				$(this).addClass('active');
				var title = $(this).parents('dl').find('.menu-title').text() + ' >> ' + $(this).text();
				$('#navi-title').text(title);
				var url = $(this).attr('title') + '?randomNum=' + Math.random();
				$('#mainFrame').attr('src', url);
				$.hideLoading();
				$.hideCover();
			}
		});
	</script>
</body>
</html>