<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>客户管理</title>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('form.pageForm').attr('action', 'organization/all/list');
			$('div.btn-add').on('click', function(){
				
			});
			$('div.btn-edit').on('click', function(){editSource('inventory/brand/edit');});
			$('div.btn-delete').on('click', function(){delSource('inventory/brand/del');});
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
		<div class="ui-table" id="organizationTable">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">客户列表</div>
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
						<dd class="text-35p">客户名称</dd>
						<dd class="text-55p">所属行业</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<#list organizationList as org>
					<#if org_index % 2 = 0>
						<dl class="table-source-line odd">
							<dd class="text-5p"><span id="${org.id}" class="checkbox"></span></dd>
							<dd class="text-5p">${org_index + 1}</dd>
							<dd class="text-35p">${org.name}</dd>
							<dd class="text-55p">${org.industryName}</dd>
						</dl>
					</#if>
					<#if org_index % 2 = 1>
						<dl class="table-source-line">
							<dd class="text-5p"><span id="${org.id}" class="checkbox"></span></dd>
							<dd class="text-5p">${org_index + 1}</dd>
							<dd class="text-35p">${org.name}</dd>
							<dd class="text-55p">${org.industryName}</dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="ui-foot">
				<#if (organizationList?size>1) >
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
