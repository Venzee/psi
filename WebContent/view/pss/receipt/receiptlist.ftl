<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<base href="${request.contextPath + '/' }" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>单据管理</title>
	<link rel="stylesheet" type="text/css" href="style/css/pss.css">
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/comm.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			$('div.btn-view').click(function(){
				
			});
		});
	</script>
	<body>
		<div class="ui-table">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-table-title-name">单据信息</div>
					<div class="ui-operation">
						<div class="ui-btn btn-view">查看</div>
					</div>
				</div>
				<div class="table-source-head">
					<dl>
						<dd class="text_5p">选项</dd>
						<dd class="text_5p">编号</dd>
						<dd class="text_25p">流水号</dd>
						<dd class="text_25p">往来单位</dd>
						<dd class="text_20p">创建时间</dd>
						<dd class="text_10p">单据类型</dd>
						<dd class="text_10p">单据状态</dd>
					</dl>
				</div>
			</div>
			<div class="table-source">
				<dl class="table-source-line odd">
					<dd class="text_5p"><span id="" class="checkbox"></span></dd>
					<dd class="text_5p">1</dd>
					<dd class="text_25p">VS-XS-1304060000001</dd>
					<dd class="text_25p">联想科技</dd>
					<dd class="text_20p">2013年4月6日12:56:57</dd>
					<dd class="text_10p">进货单</dd>
					<dd class="text_10p">未审核</dd>
				</dl>
				<dl class="table-source-line">
					<dd class="text_5p"><span id="" class="checkbox"></span></dd>
					<dd class="text_5p">2</dd>
					<dd class="text_25p">VS-XS-1304060000002</dd>
					<dd class="text_25p">联想科技</dd>
					<dd class="text_20p">2013年4月6日12:56:57</dd>
					<dd class="text_10p">进货单</dd>
					<dd class="text_10p">未审核</dd>
				</dl>
			</div>
			<div class="ui-foot">
					<div class="btn">
						<div class="ui-btn btn-check-all">全选</div>
						<div class="ui-btn btn-check-invert">反选</div>
					</div>
				<div class="ui-operation">
					<#include "comm/page.ftl">
				</div>
			</div>
		</div>
	</body>
</html>
