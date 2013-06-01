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
				async: {
					enable: true,
					url: 'child',
					autoParam:['id=parentId']
				},
				data: {
					simpleData: {
						enable: true,
						pIdKey: 'parentId',
						rootPId: 0
					}
				},
				view: {
					addHoverDom: addHoverDom,
					removeHoverDom: removeHoverDom,
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
				},
				callback: {
					beforeExpand: beforeExpand,
					onAsyncSuccess: onAsyncSuccess,
					onAsyncError: onAsyncError
				}
			};
			
			function addHoverDom(treeId, treeNode) {
				var sObj = $("#" + treeNode.tId + "_span");
				if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) return;
				var addStr = '<span class="button add" id="addBtn_' + treeNode.id + '" title="新增类目" onfocus="this.blur();"></span>';
				sObj.after(addStr);
				var btn = $("#addBtn_" + treeNode.id);
				if (btn) btn.bind("click", function(){
					var zTree = $.fn.zTree.getZTreeObj("sortTree");
					$.dgform({
						url: 'addre',
						width: 300,
						title: '新增类目',
						label: ['类目名称'],
						source: ['<input type="text" class="text-130 not-null form-value" name="name" />',
							'<input type="hidden" class="form-value" name="parentId" value="' + treeNode.id + '" />'],
						sucSub: function(data){
							zTree.addNodes(treeNode, {id:data.id, parentId:treeNode.id, name:data.name });
						}
					});
					return false;
				});
			};
			
			function removeHoverDom(treeId, treeNode) {
				$("#addBtn_" + treeNode.id).unbind().remove();
			};
			
			function beforeExpand(treeId, treeNode) {
				if (!treeNode.isAjaxing) {
					startTime = new Date();
					treeNode.times = 1;
					ajaxGetNodes(treeNode, "refresh");
					return true;
				} else {
					alert("zTree 正在下载数据中，请稍后展开节点。。。");
					return false;
				}
			}
			function onAsyncSuccess(event, treeId, treeNode, msg) {
				
			}
			
			function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
				alert("异步获取数据出现异常。");
				treeNode.icon = "";
				zTree.updateNode(treeNode);
			}
			
			function ajaxGetNodes(treeNode, reloadType) {
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
				if (reloadType == "refresh") {
					treeNode.icon = "../../../css/zTreeStyle/img/loading.gif";
					zTree.updateNode(treeNode);
				}
				zTree.reAsyncChildNodes(treeNode, reloadType, true);
			}
			
			var zNodes = ${sortList };

			$.fn.zTree.init($("#sortTree"), setting, zNodes);
			
			$('div.btn-add').on('click', function(){
				$.dgform({
					url: 'add',
					width: 300,
					title: '新增类目',
					label: ['类目名称'],
					source: ['<input type="text" class="text-130 not-null form-value" name="name" />',
						'<input type="hidden" class="form-value" name="parentId" />']
				});
			});
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