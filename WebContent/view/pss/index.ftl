<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="style/css/pss.css">
<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="script/js/comm.js"></script>
<script type="text/javascript" src="script/js/ui.js"></script>
</head>
	<body>
        <div id="popupmenu" style="display: none;">
        	<iframe allowtransparency="true" src="#" scrolling="auto" width="100%" height="100%" frameborder="0"></iframe>
        </div>
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
	    		<!-- <div id="menu-head">进销存首页</div> -->
	    		<dl class="menu-items">
	    			<dt class="menu-title">仓库中心</dt>
	    			<dt class="top-line"></dt>
	   				<dd class="menu-item"><span id="A00" title="inventory/brand/list">品牌管理</span></dd>
	   				<dd class="menu-item"><span id="A01" title="inventory/sort/list">商品类型</span></dd>
                  	<dd class="menu-item"><span id="A02" title="inventory/goods/list">商品管理</span></dd>
                </dl>
				<dl class="menu-items">
	    			<dt class="menu-title">单据中心</dt>
	    			<dt class="top-line"></dt>
               		<dd class="menu-item"><span id="B00" title="receipt/list">单据管理</span></dd>
               	</dl>
            	<dl class="menu-items">
                    <dt class="menu-title">基础设置</dt>
                    <dt class="top-line"></dt>
               		<dd class="menu-item"><span id="C00" title="organization/industry/list">行业管理</span></dd>
               	</dl>
		    </div>
	    </div>
	    <div id="menu-navi"><span id="navi-title">首页</span></div>
	    <div id="content">
        	<iframe id="mainFrame" name="mainFrame" src="" frameborder="0" ></iframe>
        </div>
        <script type="text/javascript">
		function autoSize(){
			var maxWidth = Math.max(
				$(document).innerWidth(), $(document).outerWidth()
			);
			$('#menu').height(($(document).innerHeight() - 65));
			$('#menu-navi').width((maxWidth - 190));
			$('#mainFrame').css({width: (maxWidth - 232), height: ($(document).innerHeight() - 120)});
		}
		function autoSize2(){
			var maxWidth = Math.max(
				document.documentElement["clientWidth"],
				document.body["scrollWidth"], document.documentElement["scrollWidth"],
				document.body["offsetWidth"], document.documentElement["offsetWidth"]
			);
			document.getElementById("menu").style.height = (document.documentElement["clientHeight"] - 65) +'px';
			document.getElementById("menu-navi").style.width = (maxWidth - 200) +'px';
			document.getElementById("content").style.width = (maxWidth - 232) +'px';
			document.getElementById("content").style.height = (document.documentElement["clientHeight"] - 120) +'px';
			document.getElementById("mainFrame").style.width = (maxWidth - 232) +'px';
			document.getElementById("mainFrame").style.height = (document.documentElement["clientHeight"] - 120) +'px';
		}
		$(window).bind({
			load: function(){autoSize2();},
			resize: function(){autoSize2();}
		});
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
				$.showCover($('body'));
				$.showLoading($('body'));
				$('.menu-item span').removeClass('active');
				$(this).addClass('active');
				var title = $(this).parents('dl').find('.menu-title').text() + ' >> ' + $(this).text();
				$('#navi-title').text(title);
				var url = $(this).attr('title') + '?randomNum=' + Math.random();
				$('#mainFrame').attr('src', url);
				$.hideLoading($('body'));
				$.hideCover($('body'));
			}
		});
		</script>
	</body>
</html>