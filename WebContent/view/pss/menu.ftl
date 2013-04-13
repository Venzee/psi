<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/appindex.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
</head>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	overflow: auto;
	font-size: 14px;
	background: #E9F1F5;
}

a {
	text-decoration: none;
	color: #000;
}
#menuList {
	cursor: pointer;
	text-align: center;
}

#menuList .main-menu-title {
	height: 30px;
	line-height: 30px;
	font-weight: bold;
	background: url("../images/app/main-menu-bg.gif") top left no-repeat;
}

#menuList .second-menu-title {
	height: 28px;
	line-height: 28px;
	background: url("../images/app/second-menu-bg.gif") top left no-repeat;
}

#menuList .open {
	background: url("../images/app/second-menu-open-bg.gif") top left no-repeat;
}

#menuList .menu-item {
	display: none;
}

.item span {
	display: block;
	width: 158px;
	height: 26px;
	font-size: 12px;
	line-height: 26px;
	background: url("../images/app/menu-item-bg.gif") top left no-repeat;
}

.item span:hover {
	color: #8dc6eb;
}

.item span.active {
	color: #2475b9;
}

.item span.active:hover {
	color: #2475b9;
	cursor: text;
}

.main-line {
	display: none;
	height: 5px;
	background: url("../images/app/main-line-bg.gif") top left no-repeat
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		/* 菜单控制 */
		$('#menuList .menu-title').click(function() {
			if ($(this).nextAll('.menu-item').css('display') != 'block') {
				$('.second-menu-title').removeClass('open');
				if($(this).hasClass('main-menu-title')){
					$('.main-line').slideUp();
					$('#menuList .menu-item').slideUp();
					$(this).next('.main-line').slideDown('fast');
				}else{
					$('#menuList .item').slideUp();
					$(this).toggleClass('open');
				}
				$(this).nextAll('.menu-item').slideDown('fast');
			}else{
				$(this).nextAll('.menu-item').slideUp();
				if($(this).hasClass('main-menu-title')){
					$('.main-line').slideUp();
				}else{
					$(this).removeClass('open');
				}
			}
		});
		$('.item span').click(function(){
			if (!$(this).hasClass('active')) {
				showTopModal();
				$('.item span').removeClass('active');
				$(this).addClass('active');
				var url = $(this).attr('title') + '?randomNum=' + Math.random();
				$('#mainFrame').attr('src', url);
			}
		});
	});
</script>
<body>
	<div id="menu">
    	<div id="menuList">
    		<dl class="main-menu">
    			<dt class="menu-title main-menu-title">进货管理</dt>
    			<dt class="main-line"></dt>
   				<dd class="menu-item">
   					<dl>
	   					<dt class="menu-title second-menu-title">进货单据</dt>
	                  	<dd class="menu-item item"><span id="A00" title="purOrder!init.action">进货订单</span></dd>
	                  	<dd class="menu-item item"><span id="A01" title="purOrder!initPurchase.action">进货单</span></dd>
	                  	<dd class="menu-item item"><span id="A02" title="purOrder!initOrdReturn.action">进货退货单</span></dd>
                  	</dl>
   				</dd>
   				<dd class="menu-item">
   					<dl>
		    			<dt class="menu-title second-menu-title">进货统计</dt>
	               		<dd class="menu-item item"><span id="A10" title="invetoryBill!init.action">进货订单查询</span></dd>
	                   	<dd class="menu-item item"><span id="A11" title="invetoryBill!initOrderStat.action">进货订单统计</span></dd>
	                   	<dd class="menu-item item"><span id="A12" title="invetoryBill!initPurRecStat.action">进货单统计</span></dd>
	                   	<dd class="menu-item item"><span id="A13" title="invetoryBill!initReturnStat.action">进货退货单统计</span></dd>
	                   	<dd class="menu-item item"><span id="A14" title="invetoryBill!initPurchaseStat.action">商品进货统计</span></dd>
	                   	<dd class="menu-item item"><span id="A15" title="invetoryBill!initSupPurSta.action">供应商进货统计</span></dd>
                   	</dl>
            	</dd>
                <dd class="menu-item">
                	<dl>
	                    <dt class="menu-title second-menu-title">进货分析</dt>
	               		<dd class="menu-item item"><span id="A20" title="invetoryBill!initPriceAnal.action">进价分析</span></dd>
	                   	<dd class="menu-item item"><span id="A21" title="invetoryBill!initPurAnalysis.action">商品进货分析</span></dd>
                   	</dl>
                </dd>
   			</dl>
	    </div>
    </div>
</body>
</html>
