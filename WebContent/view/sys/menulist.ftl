<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>菜单管理</title>
	<link rel="stylesheet" type="text/css" href="../style/css/pss.css">
	<script type="text/javascript" src="../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../script/js/comm.js"></script>
	<script type="text/javascript" src="../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('div.btn-add').click(function(){
				$.dg({
					url : 'add',
					title: '新增菜单',
					label: ['名称',{style: 'high', name:'链接地址'}],
					source: [
						'<input type="text" class="text_500 not_null form-value" name="name" />',
						'<textarea class="text_500 not_null form-value" name="url"></textarea>'
					]
				});
			});
			
		});
	</script>
	<body>
		<div class="ui-table" id="sortTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">菜单信息</div>
					<div class="ui-operation">
						<div class="ui-btn btn-delete">删除</div>
						<div class="ui-btn btn-edit">编辑</div>
						<div class="ui-btn btn-add">新增</div>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="text_5p">选项</dd>
						<dd class="text_5p">编号</dd>
						<dd class="text_35p">菜单名称</dd>
						<dd class="text_35p">链接地址</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list menuList as menu>
					<#if menu_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="text_5p"><span id="${menu.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${menu_index + 1}</dd>
							<dd class="text_35p">${menu.name}</dd>
							<dd class="text_35p">${menu.url}</dd>
						</dl>
					</#if>
					<#if menu_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="text_5p"><span id="${menu.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${menu_index + 1}</dd>
							<dd class="text_35p">${menu.name}</dd>
							<dd class="text_35p">${menu.url}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (menuList?size>1) >
					<div class="btn">
						<div class="ui-btn btn-check-all">全选</div>
						<div class="ui-btn btn-check-invert">反选</div>
					</div>
				</#if>
			</div>
		</div>
	</body>
</html>
