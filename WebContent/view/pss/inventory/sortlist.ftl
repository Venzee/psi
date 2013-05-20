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

			$('li.cc-tree-item').on('click', function(){
				if(!$(this).hasClass('cc-selected')) {
					$('li.cc-tree-item').removeClass('cc-selected');
					$(this).addClass('cc-selected');
					if ($(this).hasClass('cc-hasChild-item')) {
						$.ajax({
							url: "childlist",
							type: 'post',
							data: 'parentId=' + $(this).attr('id') + '&randomNum=' + Math.random(),
							dataType: 'json',
							success: function(datas) {
								var str = '<li class="cc-list-item"><div class="cc-cbox-filter"><label>输入名称/拼音首字母</label><input style="width: 176px;"></div><div class="cc-cbox"><ul class="cc-cbox-cont">';
								for (var data in datas) {
									
									str += '<li class="cc-cbox-group"><div class="cc-cbox-gname">' + data.code + '</div><ul class="cc-cbox-gcont">';
									for (var sort in data.childList) {
										str += '<li id="' + sort.id + '" class="cc-cbox-item cc-hasChild-item">' + sort.name + '</li>'
									}
									str += '</ul></li>';
											
								};
								str += + '</ul></div></li>';
								alert(str);
							}
						});
					};
				}
			});
		});
	</script>
	<style type="text/css">
		.cate-container {
			height: 300px;
			overflow: hidden;
		}
		.cate-container {
			width: 950px;
			overflow: hidden;
			position: relative;
			border: 1px solid #d5e4fa;
			background-color: #F5F9FF;
		}
		.cate-main {
			float: left;
			padding-top: 10px;
			border-right: 1px solid #d5e4fa;
			width: 725px;
		}
		#cate-cascading {
			padding: 0 24px;
			height: 290px;
			position: relative;
			z-index: 11;
		}
		.search-result {
			background-color: #F5F9FF;
			height: 298px;
			position: relative;
			top: -300px;
			left: 0;
			z-index: 12;
		}
		#cate-cascading .cc-prev {
			left: 0;
			background-position: 0 -60px;
		}
		a:link, a:visited {
			color: #36c;
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
			overflow: hidden;
		}
		.cc-listwrap, .cc-list, .cc-list-item, .cc-tree, .cc-cbox {
			height: 100%;
		}
		.cc-listwrap {
			border-left: 1px solid #d5e4fa;
			border-right: 1px solid #d5e4fa;
			border-top: 1px solid #d5e4fa;
			position: relative;
			overflow: hidden;
		}
		.cc-list {
			width: 2000em;
			position: absolute;
			left: 0;
			top: 0;
		}
		ul, ol {
			list-style: none;
		}
		.cc-list-item {
			float: left;
			width: 223px;
			border-right: 2px solid #d5e4fa;
			background: #fff;
		}
		.cc-tree-gcont {
			display: none;
		}
		.cc-cbox-filter {
			padding: 2px 3px;
			background: #f5f9ff;
			position: absolute;
			top: 0;
			z-index: 10;
		}
		.cc-cbox-filter label {
			color: #AAA;
			padding-left: 29px;
			position: absolute;
			top: 3px;
		}
		.cc-cbox-filter input {
			background-color: #fff;
			background-position: -239px -89px;
			border: 1px solid #D9E5F6;
			height: 20px;
			padding-left: 23px;
			width: 176px;
		}
		.cc-tree, .cc-cbox {
			overflow-x: hidden;
			overflow-y: auto;
			position: relative;
			left: 0;
			top: 0;
		}
		.cc-tree-cont, .cc-cbox-cont {
			padding: 0 3px;
			margin-top: 30px;
		}
		.cc-tree-group {
			padding: 3px 0;
			border-bottom: 1px dashed #ccc;
			zoom: 1;
		}
		.cc-tree-gname, .cc-tree-item {
			padding: 0 16px 0 14px;
		}
		.cc-tree-gname {
			color: #36c;
			width: 100%;
			background-position: right -107px;
			display: inline-block;
			margin: 2px 0;
			cursor: pointer;
		}
		.cc-cbox-item, .cc-tree-item {
			background-color: #FFF;
			border: 1px solid #FFF;
			height: 20px;
			line-height: 20px;
			overflow: hidden;
			cursor: pointer;
			padding-left: 41px;
		}
		.cc-cbox-item:hover, .cc-tree-item:hover {
			border: 1px solid #dcdcdc;
			background-color: #f3f3f3;
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
			overflow: hidden;
		}
		li.cc-selected, li.cc-selected:hover {
			border: 1px solid #82bce0;
			background-color: #dff1fb;
		}
		.cc-cbox-item {
			padding-right: 16px;
		}
	</style>
<body>
	<div class="cate-container">
		<div class="cate-main">
			<div id="cate-cascading">
				<a href="#" class="cc-prev cc-nav" title="上一级" id="J_LinkPrev">
					<span>上一级</span>
				</a>
				<div class="cc-listwrap">
					<ol id="sort-list" class="cc-list">
						<li class="cc-list-item">
							<div class="cc-cbox-filter">
								<label>输入名称/拼音首字母</label>
								<input style="width: 176px;"></div>
							<div class="cc-tree">
								<ul class="cc-tree-cont">
									<#list sortList as source>
										<li class="cc-tree-group">
											<div class="cc-tree-gname">${source.sort.name }</div>
											<ul class="cc-tree-gcont expanded">
												<#list source.childList as childSort>
													<li id="${childSort.id }" class="cc-tree-item cc-hasChild-item">${childSort.name }</li>
												</#list>
											</ul>
										</li>
									</#list>
								</ul>
							</div>
						</li>
						<li class="cc-list-item">
							<div class="cc-cbox-filter">
								<label>输入名称/拼音首字母</label>
								<input style="width: 176px;"></div>
							<div class="cc-cbox">
								<ul class="cc-cbox-cont">
									<li class="cc-cbox-group">
										<div class="cc-cbox-gname">a</div>
										<ul class="cc-cbox-gcont">
											<li class="cc-cbox-item cc-hasChild-item">Acer/宏碁</li>
											<li class="cc-cbox-item cc-hasChild-item">Apple/苹果</li>
											<li class="cc-cbox-item cc-hasChild-item">Asus/华硕</li>
										</ul>
									</li>
									<li class="cc-cbox-group ">
										<div class="cc-cbox-gname">b</div>
										<ul class="cc-cbox-gcont">
											<li class="cc-cbox-item cc-hasChild-item">Benq/明基</li>
										</ul>
									</li>
								</ul>
							</div>
						</li>
						<li class="cc-list-item">
							<div class="cc-cbox-filter">
								<label>输入名称/拼音首字母</label>
								<input style="width: 176px;"></div>
							<div class="cc-cbox">
								<ul class="cc-cbox-cont">
									<li class="cc-cbox-group">
										<div class="cc-cbox-gname">a</div>
										<ul class="cc-cbox-gcont">
											<li class="cc-cbox-item cc-hasChild-item">A53</li>
										</ul>
									</li>
									<li class="cc-cbox-group">
										<div class="cc-cbox-gname">r</div>
										<ul class="cc-cbox-gcont">
											<li class="cc-cbox-item cc-hasChild-item">R43</li>
											<li class="cc-cbox-item cc-hasChild-item">R47</li>
											<li class="cc-cbox-item cc-hasChild-item">R48</li>
											<li class="cc-cbox-item cc-hasChild-item">R4B</li>
										</ul>
									</li>
								</ul>
							</div>
						</li>
					</ol>
				</div>
				<a href="#" class="cc-next cc-nav" title="下一级" id="J_LinkNext">
					<span>下一级</span>
				</a>
			</div>
			<div id="J_SearchResult" class="search-result" style="display: none;">
				<div class="result-note"> <strong>匹配到 <em class="J_RecordCount">0</em>个类目</strong> 
					<span class="note">(双击直接发布，括号中为该类目下相关宝贝的数量)</span>
					<a class="J_TriggerExit trigger-exit" href="#exit"> <i></i>
						关闭，返回类目
					</a>
				</div>
				<div class="result-list">
					<ol></ol>
					<a class="J_FlexTrigger trigger-expand" href="#expand">
						展开更多 <i></i>
					</a>
					<a class="J_FlexTrigger trigger-close" href="#close">
						收起更多
						<i></i>
					</a>
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
	</div>
</body>
</html>