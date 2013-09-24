<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>商品类目管理</title>
		<link rel="stylesheet" type="text/css" href="../../style/css/reset.css">
		<link rel="stylesheet" type="text/css" href="../../style/css/ui.css">
		<link rel="stylesheet" type="text/css" href="../../style/css/web.css">
		<script type="text/javascript" src="../../script/js/jquery.min.js"></script>
		<script type="text/javascript" src="../../script/js/jquery.form.min.js"></script>
		<script type="text/javascript" src="../../script/js/comm.js"></script>
		<script type="text/javascript" src="../../script/js/ui.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$('a.btn-add').on('click', function(){
					var hpId = $('#hpId').val();
					if(hpId === ''){
						hpId = 0;
					}
					$.dgform({
						url: 'inventory/sort/add',
						width: 300,
						title: '新增类目',
						label: ['类目名称'],
						source: ['<input type="text" class="w-130 not-null form-value" name="name" />',
							'<input type="hidden" class="form-value" name="parentId" value="' + hpId + '" />']
					});
				});
				$('a.btn-delete').on('click', function(){delSource('inventory/sort/del');});
				$('a.btn-edit').on('click', function(){
					editSource(function(id){
						alert(id)
					});
				});
			});
		</script>
	</head>
	<body>
		<input type="hidden" value="${sort.id }" id="hpId" />
		<div class="ui-table tb-70p" id="sortTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">商品类目</div>
					<div class="ui-operation">
						<#if sort.parentId != -1 && sort.parentId != 0>
							<a class="ui-btn" href="inventory/sort/list?parentId=0">返回顶部</a>
						</#if>
						<#if sort.parentId != -1>
							<a class="ui-btn" href="inventory/sort/list?parentId=${sort.parentId }">返回</a>
						</#if>
						<#if brandFlag == '' || brandFlag == 0>
							<#if sort.parentId == -1>
							<a class="ui-btn" href="inventory/sort/list?parentId=0&brandFlag=1&goodsFlag=${goodsFlag }">显示品牌</a>
							<#else>
							<a class="ui-btn" href="inventory/sort/list?parentId=${sort.id }&brandFlag=1&goodsFlag=${goodsFlag }">显示品牌</a>
							</#if>
						<#else>
							<#if sort.parentId == -1>
							<a class="ui-btn" href="inventory/sort/list?parentId=0&brandFlag=0&goodsFlag=${goodsFlag }">不显示品牌</a>
							<#else>
							<a class="ui-btn" href="inventory/sort/list?parentId=${sort.id }&brandFlag=0&goodsFlag=${goodsFlag }">不显示品牌</a>
							</#if>
						</#if>
						<#if goodsFlag == '' || goodsFlag == 0>
							<#if sort.parentId == -1>
							<a class="ui-btn" href="inventory/sort/list?parentId=0&brandFlag=${brandFlag }&goodsFlag=1">显示商品</a>
							<#else>
							<a class="ui-btn" href="inventory/sort/list?parentId=${sort.id }&brandFlag=${brandFlag }&goodsFlag=1">显示商品</a>
							</#if>
						<#else>
							<#if sort.parentId == -1>
							<a class="ui-btn" href="inventory/sort/list?parentId=0&brandFlag=${brandFlag }&goodsFlag=0">不显示商品</a>
							<#else>
							<a class="ui-btn" href="inventory/sort/list?parentId=${sort.id }&brandFlag=${brandFlag }&goodsFlag=0">不显示商品</a>
							</#if>
						</#if>
						<a href="javascript:;" class="ui-btn btn-add">新增</a>
						<a href="javascript:;" class="ui-btn btn-edit">编辑</a>
						<a href="javascript:;" class="ui-btn btn-delete">删除</a>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="w-50">选项</dd>
						<dd class="w-200">编号</dd>
						<dd class="w-500">名称</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list sortList as sort>
				<#if sort_index % 2 = 0>
				<dl class="table-source-line odd">
					<dd class="w-50"><span id="${sort.id }" class="checkbox"></span></dd>
					<dd class="w-200">${sort_index + 1 }</dd>
					<dd class="w-500"><a href="inventory/sort/list?parentId=${sort.id }">${sort.name }</a></dd>
				</dl>
				</#if>
				<#if sort_index % 2 = 1>
				<dl class="table-source-line">
					<dd class="w-50"><span id="${sort.id }" class="checkbox"></span></dd>
					<dd class="w-200">${sort_index + 1 }</dd>
					<dd class="w-500"><a href="inventory/sort/list?parentId=${sort.id }">${sort.name }</a></dd>
				</dl>
				</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (sortList?size > 1) >
				<div class="btn">
					<a href="javascript:;" class="ui-btn btn-check-all">全选</a>
					<a href="javascript:;" class="ui-btn btn-check-invert">反选</a>
				</div>
				</#if>
			</div>
		</div>
	</body>
</html>