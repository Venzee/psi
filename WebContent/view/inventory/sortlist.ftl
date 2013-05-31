<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品类目管理</title>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<link rel="stylesheet" type="text/css" href="../../style/zTreeStyle/zTreeStyle.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../../script/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="../../script/js/comm.js"></script>
	<script type="text/javascript" src="../../script/js/ui.js"></script>
	<script type="text/javascript">
		$(function(){
			var setting = {
				data: {
					simpleData: {
						enable: true,
						pIdKey: 'parentId',
						rootPId: 0
					}
				},
				view: {
					selectedMulti: false
				},
				edit: {
					enable: true,
					showRemoveBtn: true,
					removeTitle: "删除类目",
					showRenameBtn: true,
					renameTitle: "编辑类目名称"
				},
				check: {
					enable: true
				}
			};

			var zNodes = ${sortList};

			$.fn.zTree.init($("#sortTree"), setting, zNodes);
		});
	</script>
	<body>
		<div class="ui-table ui-form" id="sortForm">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name ui-title-name ui-table-title-name">商品类目列表</div>
				</div>
			</div>
			<div class="form-source">
				<ul id="sortTree" class="ztree"></ul>
			</div>
			<div class="ui-foot">
				<div class="ui-operation">
					<div class="ui-btn btn-delete">删除</div>
					<div class="ui-btn btn-edit">编辑</div>
					<div class="ui-btn btn-add">新增</div>
				</div>
			</div>
		</div>
	</body>
</html>