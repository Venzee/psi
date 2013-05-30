<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品类目管理</title>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<link rel="stylesheet" type="text/css" href="../../style/css/sort.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#sort-list').on('click', 'div.cc-tree-gname', function(event){
				var othis = $(event.target);
				if(othis.hasClass('selected')) {
					othis.removeClass('selected').next('ul.cc-tree-gcont').slideUp('fast');
				}else{
					$('ul.cc-tree-gcont').slideUp('fast').prev('div.cc-tree-gname').removeClass('selected');
					othis.addClass('selected').next('ul.cc-tree-gcont').slideDown('fast');
				}
				$('li.cc-tree-item').removeClass('cc-selected');
			}).on('click', 'li.cc-cbox-item', function(event){
				getSource($(event.target));
			}).on('click', 'li.cc-tree-item', function(event){
				getSource($(event.target));
			}).on('click', 'div.btn-add', function(event){
				addSource($(event.target));
			});

			

			function getSource(obj){
				var index = obj.parents('li.cc-list-item').index(), id = obj.attr('id'), role = obj.attr('role');
				if(!obj.hasClass('cc-selected')) {
					if(index === 0){
						obj.parents('li.cc-list-item').find('li.cc-tree-item').removeClass('cc-selected');
					}else{
						obj.parents('li.cc-list-item').find('li.cc-cbox-item').removeClass('cc-selected');
					}
					obj.addClass('cc-selected');
					$('#sort-list').find('li.cc-list-item:gt(' + index + ')').remove();
					if (obj.hasClass('cc-hasChild-item')) {
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
												str += '<li role="' + datas[i].role + '" title="' + data[j].name + '" id="' + data[j].id + '" class="cc-cbox-item cc-hasChild-item">' + data[j].name + '</li>';
											}else{
												str += '<li role="' + datas[i].role + '" title="' + data[j].name + '" id="' + data[j].id + '" class="cc-cbox-item">' + data[j].name + '</li>';
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
			};
		});
	</script>
	<body>
		<div class="dialog-box" id="choose">
			<div class="operation-box">
				<button class="operation-btn operation-add">增</button>
				<button class="operation-btn operation-edit">改</button>
				<button class="operation-btn operation-delete">删</button>
			</div>
		</div>
		<div class="search-panel">
			<div class="search-source">
				<label for="keyword">请输入要搜索的类目：</label>
				<input type="text" class="text-650" id="keyword"/>
				<div class="ui-operation" style="*margin-top: -30px;">
					<div class="ui-btn btn-search">搜索</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
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
											<div title="${source.sort.name }" id="${source.sort.id }" class="cc-tree-gname">${source.sort.name }</div>
											<ul class="cc-tree-gcont">
											<#list source.childList as childSort>
												<#if childSort.hasChild == true>
													<li role="${source.role }" title="${childSort.name }" id="${childSort.id }" class="cc-tree-item cc-hasChild-item">${childSort.name }</li>
												</#if>
												<#if childSort.hasChild == false>
													<li role="${source.role }" title="${childSort.name }" id="${childSort.id }" class="cc-tree-item">${childSort.name }</li>
												</#if>
											</#list>
											</ul>
										</li>
									</#list>
									</ul>
								</div>
								<div class="cc-cbox-operation ui-foot">
									<div class="ui-operation">
										<div class="ui-btn btn-add">选择</div>
									</div>
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
								3C数码配件
								<em>&gt;&gt;</em>
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
					<ul class="cc-item-out">
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
		<div class="bottom-panel ui-foot">
			
		</div>
	</body>
</html>