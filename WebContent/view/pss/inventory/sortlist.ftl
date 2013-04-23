<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.btn-add').click(function(){
				var sorts = '';
				$.ajax({
					type : 'POST',
					url : 'ajaxlist',
					data : 'randomNum=' + Math.random(),
					dataType: 'json',
					success : function(data) {
						$.each(data, function(i,n){
							sorts = sorts + '<option value="' + n.id + '">' + n.name + '</option>'
						});
						$.dialog({
							title: '新增商品类型',
							label: ['名称','是否父级类别','所属类别'],
							source: [
								'<input type="text" class="text_500 not_null form-value" name="name" />',
								'<select class="text_150 form-value" name="parent"><option value="true">是</option><option value="false">否</option></select>',
								'<select class="text_150 form-value" name="parentId">' + sorts + '</select>'
							]
						});
					}
				});
			});
		});
	</script>
	<body>
		<div class="ui-table" id="sortTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">商品类型表</div>
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
						<dd class="text_45p">类型名称</dd>
						<dd class="text_45p">父级分类</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list sortList as source>
					<#if source_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="text_5p"><span id="${source.sort.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${source_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_45p">
								${source.sort.parent ? string('<a href="javascript:;">${source.sort.name}</a>', '${source.sort.name}')}
							</dd>
							<dd class="text_45p">${source.parentName}</dd>
						</dl>
					</#if>
					<#if source_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="text_5p"><span id="${source.sort.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${source_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_45p">
								${source.sort.parent ? string('<a href="javascript:;">${source.sort.name}</a>', '${source.sort.name}')}
							</dd>
							<dd class="text_45p">${source.parentName}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (sortList?size>1) >
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
