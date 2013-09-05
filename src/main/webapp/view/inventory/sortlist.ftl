<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>商品类目管理</title>
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
			$(document).ready(function(){
				
				$('div.btn-add').on('click', function(){
					var hpId = $('#hpId').val();
					if(hpId === ''){
						hpId = 0;
					}
					$.dgform({
						url: 'add',
						width: 300,
						title: '新增类目',
						label: ['类目名称'],
						source: ['<input type="text" class="text-130 not-null form-value" name="name" />',
							'<input type="hidden" class="form-value" name="parentId" value="' + hpId + '" />']
					});
				});
				$('div.btn-delete').on('click', function(){delSource('del');});
				$('div.btn-edit').on('click', function(){
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
						<div class="ui-btn btn-delete">删除</div>
						<div class="ui-btn btn-edit">编辑</div>
						<div class="ui-btn btn-add">新增</div>
						<#if goodsFlag == '' || goodsFlag == 0>
						<div class="ui-btn">
							<#if sort.parentId == -1>
							<a href="inventory/sort/list?parentId=0&brandFlag=${brandFlag }&goodsFlag=1">显示商品</a>
							<#else>
							<a href="inventory/sort/list?parentId=${sort.id }&brandFlag=${brandFlag }&goodsFlag=1">显示商品</a>
							</#if>
						</div>
						<#else>
						<div class="ui-btn">
							<#if sort.parentId == -1>
							<a href="inventory/sort/list?parentId=0&brandFlag=${brandFlag }&goodsFlag=0">不显示商品</a>
							<#else>
							<a href="inventory/sort/list?parentId=${sort.id }&brandFlag=${brandFlag }&goodsFlag=0">不显示商品</a>
							</#if>
						</div>
						</#if>
						<#if brandFlag == '' || brandFlag == 0>
						<div class="ui-btn">
							<#if sort.parentId == -1>
							<a href="inventory/sort/list?parentId=0&brandFlag=1&goodsFlag=${goodsFlag }">显示品牌</a>
							<#else>
							<a href="inventory/sort/list?parentId=${sort.id }&brandFlag=1&goodsFlag=${goodsFlag }">显示品牌</a>
							</#if>
						</div>
						<#else>
						<div class="ui-btn">
							<#if sort.parentId == -1>
							<a href="inventory/sort/list?parentId=0&brandFlag=0&goodsFlag=${goodsFlag }">不显示品牌</a>
							<#else>
							<a href="inventory/sort/list?parentId=${sort.id }&brandFlag=0&goodsFlag=${goodsFlag }">不显示品牌</a>
							</#if>
						</div>
						</#if>
						<#if sort.parentId != -1>
						<div class="ui-btn">
							<a href="inventory/sort/list?parentId=${sort.parentId }">返回</a>
						</div>
						</#if>
						<#if sort.parentId != -1 && sort.parentId != 0>
						<div class="ui-btn">
							<a href="inventory/sort/list?parentId=0">返回顶部</a>
						</div>
						</#if>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="text-5p">选项</dd>
						<dd class="text-5p">编号</dd>
						<dd class="text-55p">名称</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list sortList as sort>
				<#if sort_index % 2 = 0>
				<dl class="table-source-line odd">
					<dd class="text-5p"><span id="${sort.id }" class="checkbox"></span></dd>
					<dd class="text-5p">${sort_index + 1 }</dd>
					<dd class="text-55p"><a href="inventory/sort/list?parentId=${sort.id }">${sort.name }</a></dd>
				</dl>
				</#if>
				<#if sort_index % 2 = 1>
				<dl class="table-source-line">
					<dd class="text-5p"><span id="${sort.id }" class="checkbox"></span></dd>
					<dd class="text-5p">${sort_index + 1 }</dd>
					<dd class="text-55p"><a href="inventory/sort/list?parentId=${sort.id }">${sort.name }</a></dd>
				</dl>
				</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (sortList?size > 1) >
				<div class="btn">
					<div class="ui-btn btn-check-all">全选</div>
					<div class="ui-btn btn-check-invert">反选</div>
				</div>
				</#if>
			</div>
		</div>
	</body>
</html>