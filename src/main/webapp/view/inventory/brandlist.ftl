<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>品牌管理</title>
		<#assign basePath = request.contextPath>
		<base href="${basePath }/">
		<link rel="stylesheet" type="text/css" href="style/css/reset.css">
		<link rel="stylesheet" type="text/css" href="style/css/ui.css">
		<link rel="stylesheet" type="text/css" href="style/css/web.css">
		<script type="text/javascript" src="script/js/jquery.min.js"></script>
		<script type="text/javascript" src="script/js/jquery.form.min.js"></script>
		<script type="text/javascript" src="script/js/comm.js"></script>
		<script type="text/javascript" src="script/js/ui.js"></script>
		<script type="text/javascript">
			$(function(){
				$('form.pageForm').attr('action', 'inventory/brand/list');
				$('div.btn-add').on('click', function(){
					var industrys = '';
					/*$.ajax({
						type : 'POST',
						url : '../../organization/industry/ajaxlist',
						data : 'randomNum=' + Math.random(),
						dataType: 'json',
						success : function(data) {
							$.each(data, function(i,n){
								industrys = industrys + '<option value="' + n.id + '">' + n.name + '</option>'
							});*/
							$.dgform({
								url: 'inventory/brand/add',
								title: '新增品牌',
								label: ['品牌名称','英文名称',{style: 'high', name:'备注'},{style: 'img-150', name:'Logo'}],
								source: ['<input type="text" class="w-500 not-null form-value" name="name" />',
									'<input type="text" class="w-500 form-value" name="englishName" />',
									'<textarea class="w-500 not-null form-value" name="remark"></textarea>',
									'<img class="img-150"/>']
							});
						/*}
					});*/
				});
				$('div.btn-edit').on('click', function(){
					editSource('inventory/brand/edit');
				});
				$('div.btn-delete').on('click', function(){
					delSource('inventory/brand/del');
				});
			});
		</script>
	</head>
	<body>
		<!--<div class="search">
			<form action="list" method="post" class="searchForm">
				<dl class="search_line">
					<dd>类型名称：<input type="text" name="sort.name"/></dd>
					<dd>备注：<input type="text" name="sort.remark"/></dd>
				</dl>
				<div class="search_btn">查询</div>
			</form>
		</div> -->
		<div class="ui-table" id="sortTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">品牌信息</div>
					<div class="ui-operation">
						<div class="ui-btn btn-delete">删除</div>
						<div class="ui-btn btn-edit">编辑</div>
						<div class="ui-btn btn-add">新增</div>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="w-50">选项</dd>
						<dd class="w-200">编号</dd>
						<dd class="w-500">品牌名称</dd>
						<dd class="w-250">所属类目</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list brandList as brand>
					<#if brand_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="w-50"><span id="${brand.brand.id}" class="checkbox"></span></dd>
							<dd class="w-200">${brand_index + 1}</dd>
							<dd class="w-500">${brand.brand.name}</dd>
							<dd class="w-250">${brand.industryName}</dd>
						</dl>
					</#if>
					<#if brand_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="w-50"><span id="${brand.brand.id}" class="checkbox"></span></dd>
							<dd class="w-200">${brand_index + 1}</dd>
							<dd class="w-500">${brand.brand.name}</dd>
							<dd class="w-250">${brand.industryName}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (brandList?size>1) >
					<div class="btn">
						<div class="ui-btn btn-check-all">全选</div>
						<div class="ui-btn btn-check-invert">反选</div>
					</div>
				</#if>
				<div class="ui-operation">
					<#include "comm/page.ftl">
				</div>
			</div>
		</div>
	</body>
</html>
