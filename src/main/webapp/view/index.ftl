<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="style/css/pss.css">
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/comm.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<script type="text/javascript">
		function autoTime(){
			$('#time').text(new Date().toLocaleString());
		}
		$(document).ready(function(){
			$('a.top-menu').on('mouseenter', function(){
				if(!$(this).hasClass('active')){
					$('a.top-menu').removeClass('active');
					$('div.megamenu').css('top', '-9999px').attr('active', false);
					$(this).addClass('active').next('div.megamenu').css('top', '46px').attr('active', true);
				}
			}).on('mouseleave', function(){
				if(!$(this).next('div.megamenu').attr('active')){
					$(this).removeClass('active');
				}
			}).next('div.megamenu').on('mouseleave', function(){
				$(this).removeClass('active').css('top', '-9999px').attr('active', false);
				if($(this).prev('a.top-menu').hasClass('active')){
					$(this).prev('a.top-menu').removeClass('active');
				}
			});
			
			setInterval('autoTime()', 1000);

		});
	</script>
</head>
<body class="frame_class">
	<div id="header">
		<div id="header-inner">
			<ul class="nav" id="nav">
				<li class="top-nav">
					<a href="javascript:;" title="销售" class="top-menu">销售</a>
				</li>
				<li class="top-nav">
					<a href="javascript:;" title="库存" class="top-menu">库存</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">调拨</h4>
							<ul class="nav-list">
								<li>
									<a target="mainFrame" href="receipt/all/list">仓库到仓库</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">仓库到门店</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">门店到门店</a>
								</li>
							</ul>
							<h4 class="menu-heading">其他出入库</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="receipt/all/list">报损</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">报溢</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">获赠</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">赠送</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">采购</h4>
							<ul class="nav-list">
								<li>
									<a target="mainFrame" href="receipt/all/list">进货</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">退货</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">订单</a>
								</li>
							</ul>
							<h4 class="menu-heading">库存状况</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="receipt/all/list">库存查询</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">批次库存</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">库存报警</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="top-nav">
					<a href="javascript:;" title="单据" class="top-menu">单据</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">销售类</h4>
							<ul class="nav-list">
								<li>
									<a target="mainFrame" href="receipt/all/list">零售单据</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">批发单据</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">保修单据</a>
								</li>
							</ul>
							<h4 class="menu-heading">库存类</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="receipt/all/list">出入库单据</a>
								</li>
								<li>
									<a target="mainFrame" href="receipt/all/list">调拨单据</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">其他</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="receipt/all/list">其他单据</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="top-nav">
					<a href="javascript:;" title="基础设置" class="top-menu">基础设置</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">商品信息</h4>
							<ul class="nav-list">
								<li>
									<a target="mainFrame" href="inventory/brand/list">品牌</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/sort/list">类型</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/goods/list">商品</a>
								</li>
							</ul>
							<h4 class="menu-heading">往来单位</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="inventory/brand/list">供应商</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/sort/list">代理商</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/goods/list">客户</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">人力资源</h4>
							<ul class="nav-list">
								<li>
									<a target="mainFrame" href="inventory/brand/list">分公司</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/sort/list">部门</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/goods/list">员工</a>
								</li>
							</ul>
							<h4 class="menu-heading">用户管理</h4>
							<ul class="nav-list last">
								<li>
									<a target="mainFrame" href="inventory/sort/list">用户组</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/sort/list">权限</a>
								</li>
								<li>
									<a target="mainFrame" href="inventory/brand/list">用户</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="top-nav">
					<a href="javascript:;" title="系统设置" class="top-menu">系统设置</a>
				</li>
			</ul>
		</div>
		<div id="panel">
			<div id="user">
				<div>欢迎您：${sessionUser.companyName} ${sessionUser.groupName} ${sessionUser.username} <#if (sessionUser.employeeName != '' || sessionUser.departmentName != '')>
					(${sessionUser.departmentName} ${sessionUser.employeeName}) 
				</#if> <a id="logout" href="javascript:;">退出</a></div>
				<div>当前时间：<span id="time"></span></div>
			</div>
		</div>
	</div>
	
    <div id="menu-navi"><span id="navi-title">您当前位置：首页</span></div>
	<div id="mainFrameContainer">
		<iframe src="receipt/all/list" name="mainFrame" id="mainFrame" frameborder="no" scrolling="yes" hidefocus></iframe>
	</div>
</body>
</html>