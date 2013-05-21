<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品类目管理</title>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('div.btn-add').on('click', function(){
				
			});

			$('div.btn-edit').on('click', function(){
				
			});

			$('div.btn-delete').on('click', function(){delSource('inventory/sort/del');});

			$('div.cc-tree-gname').on('click', function(){
				if($(this).hasClass('selected')) {
					$(this).removeClass('selected').next('ul.cc-tree-gcont').slideUp('fast');
				}else{
					$('ul.cc-tree-gcont').slideUp('fast').prev('div.cc-tree-gname').removeClass('selected');
					$(this).addClass('selected').next('ul.cc-tree-gcont').slideDown('fast');
				}
				$('li.cc-tree-item').removeClass('cc-selected');
			});
			$('#sort-list').on('click', function(event){
				var othis = $(event.target), index = othis.parents('li.cc-list-item').index(), id = othis.attr('id'), role = othis.attr('role');
				if(othis.hasClass('cc-cbox-item') || othis.hasClass('cc-tree-item')){
					if(!othis.hasClass('cc-selected')) {
						if(index === 0){
							othis.parents('li.cc-list-item').find('li.cc-tree-item').removeClass('cc-selected');
						}else{
							othis.parents('li.cc-list-item').find('li.cc-cbox-item').removeClass('cc-selected');
						}
						othis.addClass('cc-selected');
						$('#sort-list').find('li.cc-list-item:gt(' + index + ')').remove();
						if (othis.hasClass('cc-hasChild-item')) {
							var str = $('body').data('childList' + id); // 获取缓存数据
							if(str === undefined || str === '' || str === null){
								$.ajax({
									url: "childlist",
									type: 'post',
									data: 'parentId=' + id + '&role=' + role +'&randomNum=' + Math.random(),
									dataType: 'json',
									beforeSend: function(){
										$('div.cc-loading').css('display', 'block');
									},
									success: function(datas) {
										str = '<li class="cc-list-item"><div class="cc-cbox-filter"><label>输入名称/拼音首字母</label><input style="width: 176px;"></div><div class="cc-cbox"><ul class="cc-cbox-cont">';
										for (var i in datas) {
											str += '<li class="cc-cbox-group"><div class="cc-cbox-gname">' + datas[i].code + '</div><ul class="cc-cbox-gcont">';
											var data = datas[i].childList;
											for (var j in data) {
												if(data[j].hasChild){
													str += '<li role="' + datas[i].role + '" id="' + data[j].id + '" class="cc-cbox-item cc-hasChild-item">' + data[j].name + '</li>';
												}else{
													str += '<li role="' + datas[i].role + '" id="' + data[j].id + '" class="cc-cbox-item">' + data[j].name + '</li>';
												}
											}
											str += '</ul></li>';
										};
										str += '</ul></div></li>';
										$('body').data('childList' + id, str); // 缓存数据
										$('#sort-list').append(str);
										$('div.cc-loading').css('display', 'none');
									}
								});
							}else{
								$('#sort-list').append(str);
							}
						};
					}
				}
			});
		});
	</script>
	<style type="text/css">
		body {
			font-size: 12px;
		}

		ol li,ul li {
			list-style: none;
		}

		.search-result .trigger-exit i,.category-search .search-hint i,.cateBtn,.cateBtn button,.cc-cbox-filter input,.cc-tree-gname,.cc-hasChild-item,.cate-path .up,.cc-nav,.b_inputAttention .attention,.cate-tip i,.catePublish
			{
			background: url(http://img02.taobaocdn.com/tps/i2/T13PGlXfdfXXXXXXXX-261-188.png) no-repeat -999em -999em transparent
		}

		.cate-container {
			width: 950px;
			overflow: hidden;
			position: relative;
			border: 1px solid #d5e4fa;
			background-color: #F5F9FF
		}

		.cate-main {
			float: left;
			padding-top: 10px;
			border-right: 1px solid #d5e4fa;
			width: 725px
		}

		.cate-aside {
			overflow: hidden
		}

		.cc-loading {
			background: rgba(255, 255, 255, .8);
			background: #fff\9;
			filter: alpha(opacity = 80);
			border: 1px none snow;
			height: 298px;
			left: 1px;
			position: absolute;
			top: 1px;
			width: 948px;
			display: none;
			z-index: 13
		}

		.cc-loading-content {
			position: relative;
			width: 150px;
			height: 21px;
			margin: 130px auto
		}

		.cc-loading-icon {
			float: left;
			margin-right: 5px
		}

		.cc-loading-text {
			font-size: 12px;
			display: block;
			float: left;
			margin-left: 5px;
			padding-top: 0;
			color: #f60
		}

		.loading .cc-loading {
			display: block
		}

		.cate-container {
			height: 300px;
			overflow: hidden
		}

		.search-result {
			background-color: #F5F9FF;
			height: 298px;
			position: relative;
			top: -300px;
			left: 0;
			z-index: 12
		}

		.search-result .result-note {
			height: 26px;
			line-height: 26px;
			margin: 0 25px
		}

		.search-result .result-note em {
			color: #f60;
			margin: 0 3px
		}

		.search-result .result-note .note {
			color: #aaa;
			margin-left: 5px
		}

		.search-result .trigger-exit {
			position: absolute;
			right: 25px;
			top: 2px;
			background-color: #9D9D9D;
			color: #fff;
			line-height: normal;
			margin-top: 2px;
			padding: 4px 4px 2px;
			height: 14px;
			line-height: 14px
		}

		.search-result .trigger-exit i {
			background-position: -252px -62px;
			width: 9px;
			height: 9px;
			margin-right: 10px;
			font-size: 0;
			line-height: 0;
			display: inline-block;
			*display: inline;
			*zoom: 1
		}

		.search-result .result-list {
			background-color: #fff;
			border: 1px solid #d5e4fa;
			height: 265px;
			overflow-x: hidden;
			overflow-y: auto;
			padding: 4px 0;
			margin: 0 25px
		}

		.search-result .no-result li {
			text-align: center
		}

		.search-result .no-result a {
			display: none
		}

		.search-result .result-list ol {
			margin-bottom: 4px
		}

		.search-result .result-list li {
			padding: 1px 0 2px;
			border: 1px solid #FFF;
			cursor: pointer;
			padding-left: 15px
		}

		.search-result li .lidx {
			margin-right: 10px;
			text-align: right;
			display: inline-block;
			width: 20px
		}

		.search-result li .rtcount {
			color: #AAA;
			margin-left: 3px
		}

		.search-result li.selected {
			border: 1px solid #9CD7FC;
			border-width: 1px 0;
			background-color: #DFF1FB;
			color: #404040
		}

		.search-result .result-list a {
			display: none;
			margin-left: 15px;
			border: 1px solid #C4D8F3;
			padding: 2px 2px 4px 8px
		}

		.search-result .result-list i {
			position: relative;
			width: 0;
			height: 0;
			margin-left: 10px;
			border-width: 4px 4px;
			border-style: solid;
			font-size: 0;
			line-height: 0;
			display: inline-block;
			*display: inline;
			*zoom: 1
		}

		.search-result .trigger-close i {
			right: 5px;
			top: -2px;
			border-color: #FFF #FFF #00E #FFF
		}

		.search-result .trigger-close:hover i {
			border-color: #FFF #FFF #F60 #FFF !important
		}

		.search-result .trigger-expand i {
			right: 5px;
			top: 2px;
			*right: 0;
			border-color: #00E #FFF #FFF #FFF
		}

		.search-result .trigger-expand:hover i {
			border-color: #F60 #FFF #FFF #FFF !important
		}

		.search-result .flex-display .trigger-expand {
			display: inline-block
		}

		.search-result li.hidden {
			display: none
		}

		.search-result .expand .trigger-expand {
			display: none
		}

		.search-result .expand .trigger-close {
			display: inline-block
		}

		.search-result .expand li.hidden {
			display: list-item
		}

		#cate-cascading {
			padding: 0 24px;
			height: 290px;
			position: relative;
			z-index: 11
		}

		.cc-nav {
			visibility: hidden;
			position: absolute;
			top: 50%;
			margin-top: -41px;
			height: 80px;
			width: 24px;
			display: inline-block;
			line-height: 99em;
			overflow: hidden
		}

		#cate-cascading .cc-prev {
			left: 0;
			background-position: 0 -60px
		}

		#cate-cascading .cc-next {
			right: 0;
			background-position: -24px -60px
		}

		.cc-listwrap {
			border-left: 1px solid #d5e4fa;
			border-right: 1px solid #d5e4fa;
			border-top: 1px solid #d5e4fa;
			position: relative;
			overflow: hidden
		}

		.cc-list {
			width: 2000em;
			position: absolute;
			left: 0;
			top: 0
		}

		.cc-listwrap,.cc-list,.cc-list-item,.cc-tree,.cc-cbox {
			height: 100%
		}

		.cc-tree,.cc-cbox {
			overflow-x: hidden;
			overflow-y: auto;
			position: relative;
			left: 0;
			top: 0
		}

		.cc-list-item {
			float: left;
			width: 223px;
			border-right: 2px solid #d5e4fa;
			background: #fff
		}

		.cc-listbox {
			padding: 3px
		}

		.cc-tree-cont,.cc-cbox-cont {
			padding: 0 3px;
			margin-top: 30px
		}

		.cc-cbox-group {
			position: relative;
			*zoom: 1
		}

		.cc-cbox-gname {
			float: left;
			background: none repeat scroll 0 0 #AAA;
			color: #FFF;
			display: inline-block;
			font-style: normal;
			height: 13px;
			line-height: 13px;
			text-align: center;
			text-transform: uppercase;
			width: 13px;
			position: absolute;
			margin-left: 16px;
			margin-top: 5px;
			overflow: hidden
		}

		.cc-tree-group {
			padding: 3px 0;
			border-bottom: 1px dashed #ccc;
			zoom: 1
		}

		.cc-tree .cc-tree-last {
			border: 0
		}

		.cc-tree-gname {
			color: #36c;
			background-position: right -107px;
			display: inline-block;
			*display: inline;
			*zoom: 1;
			margin: 2px 0;
			cursor: default
		}

		.cc-tree-gname.selected {
			background-position: right -123px
		}

		.cc-cbox-item,.cc-tree-item,.cc-listbox-item {
			background-color: #FFF;
			border: 1px solid #FFF;
			height: 20px;
			line-height: 20px;
			overflow: hidden;
			cursor: pointer;
			padding-left: 41px
		}

		.cc-cbox-item {
			padding-right: 16px
		}

		.cc-tree-gname,.cc-tree-item,.cc-listbox-item {
			padding: 0 16px 0 14px
		}

		.cc-tree-gcont {
			display: none
		}

		li.cc-selected {
			border: 1px solid #9cd7fc;
			background-color: #dff1fb
		}

		li.cc-hasChild-item {
			background-position: right -137px
		}

		.cc-cbox-filter {
			padding: 2px 3px;
			*padding: 1px 3px;
			background: #f5f9ff;
			position: absolute;
			top: 0;
			z-index: 10
		}

		.cc-cbox-filter label {
			color: #AAA;
			padding-left: 29px;
			position: absolute;
			line-height: 24px;
		}

		.cc-cbox-filter input {
			background-color: #fff;
			background-position: -239px -89px;
			border: 1px solid #D9E5F6;
			height: 20px;
			padding-left: 23px;
			width: 176px
		}

		.cc-cbox-hit {
			color: red
		}

		.search-mode .cc-tree-group {
			border-bottom-width: 0;
			padding: 0 3px
		}

		.search-mode .cc-tree-gcont {
			display: block
		}

		.search-mode .cc-tree-gname {
			padding: 0;
			display: none;
			margin: 0
		}

		.search-mode .cc-cbox-gname {
			display: none
		}

		.cate-aside {
			padding: 5px 15px 0 25px;
			background-color: #fff;
			height: 295px;
			position: relative;
			_width: 180px
		}

	</style>
<body>
	<div class="cate-container">
		<div class="cate-main">
			<div id="cate-cascading">
				<a href="#" class="cc-prev cc-nav" title="上一级" id="J_LinkPrev"><span>上一级</span></a>
				<div class="cc-listwrap">
					<ol id="sort-list" class="cc-list">
						<li class="cc-list-item">
							<div class="cc-cbox-filter"><label>输入名称/拼音首字母</label><input style="width: 176px;"></div>
							<div class="cc-tree">
								<ul class="cc-tree-cont">
								<#list sortList as source>
									<li class="cc-tree-group">
										<div class="cc-tree-gname">${source.sort.name }</div>
										<ul class="cc-tree-gcont">
										<#list source.childList as childSort>
											<#if childSort.hasChild == true>
												<li role="${source.role }" id="${childSort.id }" class="cc-tree-item cc-hasChild-item">${childSort.name }</li>
											</#if>
											<#if childSort.hasChild == false>
												<li role="${source.role }" id="${childSort.id }" class="cc-tree-item">${childSort.name }</li>
											</#if>
										</#list>
										</ul>
									</li>
								</#list>
								</ul>
							</div>
						</li>
					</ol>
				</div>
				<a href="#" class="cc-next cc-nav" title="下一级" id="J_LinkNext"><span>下一级</span></a>
			</div>
			<div id="J_SearchResult" class="search-result" style="display: none;">
				<div class="result-note">
					<strong>匹配到 <em class="J_RecordCount">0</em>个类目</strong> 
					<span class="note">(双击直接发布，括号中为该类目下相关宝贝的数量)</span>
					<a class="J_TriggerExit trigger-exit" href="#exit"> <i></i>关闭，返回类目</a>
				</div>
				<div class="result-list flex-display expand">
					<ol>
						<li class="selected" data-sid="50024147" data-issued="0" data-bookcate="0">
							<span class="lidx">1.</span>
							3C数码配件 <em>&gt;&gt;</em>
							笔记本电脑配件
							<em>&gt;&gt;</em>
							笔记本零部件
							<span class="rtcount">(76557)</span>
						</li>
						<li class="" data-sid="50012585" data-issued="1" data-bookcate="0">
							<span class="lidx">2.</span>
							3C数码配件
							<em>&gt;&gt;</em>
							笔记本电脑配件
							<em>&gt;&gt;</em>
							笔记本电源
							<span class="rtcount">(41896)</span>
						</li>
					</ol>
					<a class="J_FlexTrigger trigger-expand" href="#expand" data-spm-anchor-id="686.1000923.1000796.4">展开更多 <i></i></a>
					<a class="J_FlexTrigger trigger-close" href="#close" data-spm-anchor-id="686.1000923.1000796.5">收起更多<i></i></a>
				</div>
			</div>
			<div class="cc-loading">
				<div class="cc-loading-content">
					<div class="cc-loading-icon">
						<img src="http://img03.taobaocdn.com/tps/i3/T1jBamXj4fXXXXXXXX-16-16.gif"></div>
					<span class="cc-loading-text">加载中，请稍候...</span>
				</div>
			</div>
		</div>
		<div class="cate-aside">
			<div class="cc-tree">
				<ul>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
					<li>电脑硬件</li>
					<li>电脑软件</li>
					<li>电脑外设</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>