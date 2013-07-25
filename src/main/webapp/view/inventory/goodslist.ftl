<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品管理</title>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery.min.js"></script>
	<script type="text/javascript" src="../../script/js/jquery.form.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('form.pageForm').attr('action', 'inventory/goods/list');
			$('div.btn-add').on('click', function(){
				$.dgform({
					url: 'add',
					title: '新增商品',
					label: ['名称','简称','品牌','类型','单位','条码','可销售季节','搜索编码',{style: 'high', name:'备注'}],
					source: [
						'<input type="text" class="text-500 not-null form-value" name="name" />',
						'<input type="text" class="text-500 not-null form-value" name="shortName" />',
						'<select class="text-150 form-value" name="sortId"><option value="1">请选择</option></select>',
						'<select class="text-150 form-value" name="brandId"><option value="1">请选择</option></select>',
						'<input type="text" class="text-500 not-null form-value" name="unit" />',
						'<input type="text" class="text-500 not-null form-value" name="barcode" />',
						'<input type="text" class="text-500 not-null form-value" name="seasons" />',
						'<input type="text" class="text-500 not-null form-value" name="code" />',
						'<textarea class="text-500 not-null form-value" name="remark"></textarea>'
					]
				});
			});
			$('div.btn-edit').on('click', function(){editSource('inventory/goods/edit');});
			$('div.btn-delete').on('click', function(){delSource('inventory/goods/del');});
		});
	</script>
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
					<div class="ui-title-name ui-table-title-name">商品表</div>
					<div class="ui-operation">
						<div class="ui-btn btn-delete">删除</div>
						<div class="ui-btn btn-edit">编辑</div>
						<div class="ui-btn btn-add">新增</div>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="text-5p">选项</dd>
						<dd class="text-5p">编号</dd>
						<dd class="text-35p">商品名称</dd>
						<dd class="text-20p">商品分类</dd>
						<dd class="text-35p">备注</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list goodsList as goods>
					<#if goods_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="text-5p"><span id="${goods.goods.id}" class="checkbox"></span></dd>
							<dd class="text-5p">${goods_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text-35p">${goods.goods.name}</dd>
							<dd class="text-20p">${goods.sortName}</dd>
							<dd class="text-35p">${goods.goods.remark}</dd>
						</dl>
					</#if>
					<#if goods_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="text-5p"><span id="${goods.goods.id}" class="checkbox"></span></dd>
							<dd class="text-5p">${goods_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text-35p">${goods.goods.name}</dd>
							<dd class="text-20p">${goods.sortName}</dd>
							<dd class="text-35p">${goods.goods.remark}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (goodsList?size>1) >
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
