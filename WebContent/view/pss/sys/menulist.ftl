<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			$('div.btn-edit').on('click', editSource('organization/industry/edit'));
			$('div.btn-delete').on('click', delSource('organization/industry/del'));
		});
	</script>
	<body>
		<div class="ui-table" id="sortTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">行业信息</div>
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
						<dd class="text_55p">备注</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list industryList as industry>
					<#if industry_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="text_5p"><span id="${industry.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${industry_index + 1}</dd>
							<dd class="text_35p">${industry.name}</dd>
							<dd class="text_55p">${industry.description}</dd>
						</dl>
					</#if>
					<#if industry_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="text_5p"><span id="${industry.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${industry_index + 1}</dd>
							<dd class="text_35p">${industry.name}</dd>
							<dd class="text_55p">${industry.description}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (industryList?size>1) >
					<div class="btn">
						<div class="ui-btn btn-check-all">全选</div>
						<div class="ui-btn btn-check-invert">反选</div>
					</div>
				</#if>
			</div>
		</div>
	</body>
</html>
