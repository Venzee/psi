<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.add').click(function(){
				parent.dialog({
					title: '新增商品',
					label: ['名称','简称','品牌','类型','单位','条码','可销售季节','搜索编码',{style: 'high', name:'备注'}],
					data: {url:'inventory/goods/add'},
					source: [
						'<input type="text" class="text_500 not_null form_value" name="name" />',
						'<input type="text" class="text_500 not_null form_value" name="shortName" />',
						'<select class="text_150 form_value" name="sortId"><option value="1">请选择</option></select>',
						'<select class="text_150 form_value" name="brandId"><option value="1">请选择</option></select>',
						'<input type="text" class="text_500 not_null form_value" name="unit" />',
						'<input type="text" class="text_500 not_null form_value" name="barcode" />',
						'<input type="text" class="text_500 not_null form_value" name="seasons" />',
						'<input type="text" class="text_500 not_null form_value" name="code" />',
						'<textarea class="text_500 not_null form_value" name="remark"></textarea>'
					]
				});
			});
			
			function checked(){
				var isCheckAll = true;
				$.each($('.table').find('.checkbox'), function(i,n){
					if($(this).attr('class') == 'checkbox'){
						isCheckAll = false;
					}
				});
				return isCheckAll;
			}
			$('.check_all').click(function(){
				if($(this).text() == '全选'){
					$('.table').find('.checkbox').addClass('checked');
					$(this).text('不全选');
				}else{
					$('.table').find('.checkbox').removeClass('checked');
					$(this).text('全选');
				}
			});
			$('.check_invert').click(function(){
				$('.table').find('.checkbox').toggleClass('checked');
				if(checked()){
					$('.check_all').text('不全选');
				}else{
					$('.check_all').text('全选');
				}
			});
			$('.source_line').click(function(){
				$(this).find('.checkbox').toggleClass('checked');
				if(checked()){
					$('.check_all').text('不全选');
				}else{
					$('.check_all').text('全选');
				}
			});
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
		<div class="table" id="sortTable">
			<div class="head">
				<div class="title">
					<div class="title_name">商品表</div>
					<div class="operation">
						<div class="delete">删除</div>
						<div class="edit">编辑</div>
						<div class="add">新增</div>
					</div>
				</div>
				<div class="source_head">
					<dl>
						<dd class="text_5p">选项</dd>
						<dd class="text_5p">编号</dd>
						<dd class="text_35p">商品名称</dd>
						<dd class="text_20p">商品分类</dd>
						<dd class="text_35p">备注</dd>
					</dl>
				</div>
			</div>
			<div class="source">
				<#list goodsList as goods>
					<#if goods_index % 2 = 0>
						<dl class="source_line odd">
							<dd class="text_5p"><span id="${goods.goods.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${goods_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_35p">${goods.goods.name}</dd>
							<dd class="text_20p">${goods.sortName}</dd>
							<dd class="text_35p">${goods.goods.remark}</dd>
						</dl>
					</#if>
					<#if goods_index % 2 = 1>
						<dl class="source_line">
							<dd class="text_5p"><span id="${goods.goods.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${goods_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_35p">${goods.goods.name}</dd>
							<dd class="text_20p">${goods.sortName}</dd>
							<dd class="text_35p">${goods.goods.remark}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="foot">
				<#if (goodsList?size>1) >
					<div class="btn">
						<div class="check_all">全选</div>
						<div class="check_invert">反选</div>
					</div>
				</#if>
				<div class="operation">
					<#include "comm/page.ftl">
				</div>
			</div>
		</div>
	</body>
</html>
