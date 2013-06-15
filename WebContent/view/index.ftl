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
		color: #000;
	}
	#nav .megamenu {
		margin: -999999px 0 0 -999999px;
		padding: 20px 0 10px 20px;
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
		margin: 0 30px 0 0;
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
					<a href="/content/showcase.html" title="Showcase" class="top-menu">销售</a>
				</li>
				<li>
					<a href="/content/resources.html" title="Resources" class="top-menu">库存</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">调拨</h4>
							<ul class="nav-list">
								<li>
									<a href="receipt/all/list">仓库到仓库</a>
								</li>
								<li>
									<a href="receipt/all/list">仓库到门店</a>
								</li>
								<li>
									<a href="receipt/all/list">门店到门店</a>
								</li>
							</ul>
							<h4 class="menu-heading">其他出入库</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list">报损</a>
								</li>
								<li>
									<a href="receipt/all/list">报溢</a>
								</li>
								<li>
									<a href="receipt/all/list">获赠</a>
								</li>
								<li>
									<a href="receipt/all/list">赠送</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">采购</h4>
							<ul class="nav-list">
								<li>
									<a href="receipt/all/list">进货</a>
								</li>
								<li>
									<a href="receipt/all/list">退货</a>
								</li>
								<li>
									<a href="receipt/all/list">订单</a>
								</li>
							</ul>
							<h4 class="menu-heading">库存状况</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list">库存查询</a>
								</li>
								<li>
									<a href="receipt/all/list">批次库存</a>
								</li>
								<li>
									<a href="receipt/all/list">库存报警</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" class="top-menu">单据</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">销售类</h4>
							<ul class="nav-list">
								<li>
									<a href="receipt/all/list">零售单据</a>
								</li>
								<li>
									<a href="receipt/all/list">批发单据</a>
								</li>
								<li>
									<a href="receipt/all/list">保修单据</a>
								</li>
							</ul>
							<h4 class="menu-heading">库存类</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list">出入库单据</a>
								</li>
								<li>
									<a href="receipt/all/list">调拨单据</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">其他</h4>
							<ul class="nav-list last">
								<li>
									<a href="receipt/all/list">其他单据</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" class="top-menu">基础设置</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">商品信息</h4>
							<ul class="nav-list">
								<li>
									<a href="inventory/brand/list">品牌</a>
								</li>
								<li>
									<a href="inventory/sort/list">类型</a>
								</li>
								<li>
									<a href="inventory/goods/list">商品</a>
								</li>
							</ul>
							<h4 class="menu-heading">往来单位</h4>
							<ul class="nav-list last">
								<li>
									<a href="inventory/brand/list">供应商</a>
								</li>
								<li>
									<a href="inventory/sort/list">代理商</a>
								</li>
								<li>
									<a href="inventory/goods/list">客户</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">人力资源</h4>
							<ul class="nav-list">
								<li>
									<a href="inventory/brand/list">分公司</a>
								</li>
								<li>
									<a href="inventory/sort/list">部门</a>
								</li>
								<li>
									<a href="inventory/goods/list">员工</a>
								</li>
							</ul>
							<h4 class="menu-heading">用户管理</h4>
							<ul class="nav-list last">
								<li>
									<a href="inventory/sort/list">用户组</a>
								</li>
								<li>
									<a href="inventory/sort/list">权限</a>
								</li>
								<li>
									<a href="inventory/brand/list">用户</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" title="My Apps" class="top-menu">系统设置</a>
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