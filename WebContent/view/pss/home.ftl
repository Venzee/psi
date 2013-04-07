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
		});
	</script>
	<body>
		<#include "comm/dialog.ftl">
		<div id="top">
			<div id="panel">
				<div id="user">
					<div>欢迎您：管理员 Venzee</div>
					<div>当前时间：2013年3月25日13:09:57</div>
				</div>
			</div>
			<div id="menu">
				<div id="main">
					<dl>
						<dd class="active">基本设置</dd>
						<dd>财务</dd>
						<dd>人事</dd>
						<dd class="last">库存</dd>
					</dl>
				</div>
				<div id="second">
					<dl>
						<dd><a href="pss/inventory/sort/list" target="mainFrame">商品类型管理</a></dd>
						<dd><a href="pss/inventory/goods/list" target="mainFrame">商品管理</a></dd>
						<dd><a href="pss/inventory/brand/list" target="mainFrame">品牌管理</a></dd>
						<dd><a href="pss/receipt/list" target="mainFrame">单据管理</a></dd>
						<dd class="last"><a href="customer/organization/industry/list" target="mainFrame">行业管理</a></dd>
					</dl>
				</div>
			</div>
		</div>
		<div id="fastnavi">
			<div id="title"><div id="title_in"><div id="naviButton">快速导航</div></div></div>
			<div id="navi">
				这是内容这是内容这是内容这是内容
			</div>
		</div>
		<div id="content">
			<iframe frameborder="0" scrolling="no" width="100%" onload="frameAutoSize(this)" height="100%" src="pss/inventory/sort/select/init?topId=0" id="mainFrame" name="mainFrame"></iframe>
		</div>
	</body>
</html>
