<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<style type="text/css">
	html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td {
		margin: 0;
		padding: 0;
		font: 14px "微软雅黑";
	}
	#header {
		height: 115px;
	}
	#header_inner {
		height: 60px;
		font-weight: bold;
		background: #ECF0F1;
		background: -moz-linear-gradient(top, #ECF0F1 0%, #BDC3C7 100%);
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #ECF0F1), color-stop(100%, #BDC3C7));
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ECF0F1', endColorstr='#BDC3C7', GradientType=0);
	}
	ul {
		list-style: none;
	}
	#logo {
		height: 60px;
	}
	#logo img {
		height: 40px;
		width: 227px;
		margin: 10px;
	}
	#nav {
		height: 60px;
		float: right;
		margin: 0 10px 0 0;
	}
	#nav > li {
		display: inline-block;
		*display: inline;
		height: 60px;
	}
	a.top-menu {
		display: block;
		color: #5e5e5e;
		height: 30px;
		line-height: 30px;
		border-left: 1px solid gray;
		margin: 15px 0;
		font-size: 16px;
		font-weight: bold;
		padding: 0 30px;
		text-decoration: none;
	}
	a.top-menu:hover {
		color: #fff;
	}
	#nav .megamenu {
		margin: -999999px 0 0 -999999px;
		padding: 20px 15px 10px 20px;
		border: 1px solid #dcdcdc;
		border-top: 2px solid #3a98b0;
		position: absolute;
		background: #fff;
		-moz-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		-webkit-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		-o-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
	}
	div.nav-child {
		float: left;
		margin: 0 20px 0 0;
	}
	h4.menu-heading a{
		color: #000;
		margin: 0 0 4px;
		text-decoration: none;
	}
	ul.nav-list {
		padding: 0 0 5px;
		margin: 0 0 11px;
		border-bottom: 1px solid #e5e5e5;
	}
	ul.nav-list.last {
		border-bottom: none;
	}
	ul.nav-list li a{
		color: #3a98b0;
		font-size: 12px;
		text-decoration: none;
	}
	ul.nav-list li a:hover{
		text-decoration: underline;
	}
	#panel {
		height: 55px;
		background: #f3f3f3;
	}
	#panel .attachment {
		float: right;
	}
	#panel .signup,#panel form {
		display: inline-block;
		*display: inline;
	}
</style>
</head>
<body class="PageMain">
	<div id="header">
		<div id="header_inner">
			<a href="/content/home.html" id="logo">
				<img src="/content/typo3conf/ext/palm_template/html/../img/structure/logo24.png" alt="Palm Developer Center"/>
			</a>
			<ul class="hp-nav" id="nav">
				<li>
					<a href="/content/showcase.html" title="Showcase" target="_top" class="top-menu">销售</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/showcase/why_webos.html" target="_top">Why webOS</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/showcase/why_webos.html" target="_top">The Opportunity</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item2" target="_top">Innovative Platform</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item3" target="_top">Cross-Platform</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item5" target="_top">Vibrant Community</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/showcase.html" target="_top">Showcase</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/showcase/app_showcase.html" target="_top">App Showcase</a>
								</li>
								<li>
									<a href="/content/showcase/developer_voices.html" target="_top">Developer Voices</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" target="_top" class="top-menu">采购</a>
				</li>
				<li>
					<a href="/content/resources.html" title="Resources" target="_top" class="top-menu">库存</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">调拨</h4>
							<ul class="nav-list">
								<li>
									<a href="/content/resources/develop/faq.html" target="_top">Developer Program FAQ</a>
								</li>
								<li>
									<a href="/content/resources/develop/pdk_technical_faq.html" target="_top">PDK Technical FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/distribution_international_e_commerce.html" target="_top">International e-commerce FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/where_can_i_distribute_my_apps.html" target="_top">Countries List</a>
								</li>
							</ul>
							<h4 class="menu-heading">调配</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/resources/develop/faq.html" target="_top">Developer Program FAQ</a>
								</li>
								<li>
									<a href="/content/resources/develop/pdk_technical_faq.html" target="_top">PDK Technical FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/distribution_international_e_commerce.html" target="_top">International e-commerce FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/where_can_i_distribute_my_apps.html" target="_top">Countries List</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" target="_top" class="top-menu">单据</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">销售类</h4>
							<ul class="nav-list">
								<li>
									<a href="receipt/all/list">零售单据</a>
								</li>
								<li>
									<a href="receipt/all/list" target="_top">批发单据</a>
								</li>
								<li>
									<a href="receipt/all/list" target="_top">保修单据</a>
								</li>
							</ul>
							<h4 class="menu-heading">库存类</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list">出入库单据</a>
								</li>
								<li>
									<a href="receipt/all/list" target="_top">调拨单据</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">其他</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list" target="_top">其他单据</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" target="_top" class="top-menu">基础设置</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">商品信息</h4>
							<ul class="nav-list last">
								<li>
									<a href="inventory/brand/list">品牌管理</a>
								</li>
								<li>
									<a href="inventory/sort/list" target="_top">商品类型</a>
								</li>
								<li>
									<a href="inventory/goods/list" target="_top">商品管理</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" target="_top" class="top-menu">系统设置</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">用户</h4>
							<ul class="nav-list last">
								<li>
									<a href="inventory/brand/list">用户管理</a>
								</li>
								<li>
									<a href="inventory/sort/list" target="_top">权限配置</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div id="panel">
			<div class="attachment">
				<div class="signup">
					<a class="account-text ctx-first" href="/index.php?option=com_user&amp;view=login&amp;login">Sign In</a>
					<a class="account-text" href="/index.php?option=com_user&amp;view=login&amp;signup">Sign Up</a>
				</div>
				<form class="hp-search" action="http://www.palm.com/us/search/developer.html" method="get">
					<fieldset>
						<legend>
							<span>Search Form</span>
						</legend>
						<button class="sifr ext-sifr-search" type="submit">
							<span>Search</span>
						</button>
						<input class="search-txt" name="search" placeholder="Just Search">
							<input type="hidden" value="all" id="basic-search-collection">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<div id="main">

	</div>
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/comm.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#header_inner').find('.hp-nav').aiMegamenu();
		});
	</script>
</body>
</html>