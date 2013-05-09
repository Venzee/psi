<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
					url: 'childlist',
					dataType: 'json',
					autoParam: ['id=parentId']
				},
				check: {
					enable: true
				},
				view: {
					dblClickExpand: false
				},
				edit: {
					drag: {
						autoExpandTrigger: true,
						prev: dropPrev,
						inner: dropInner,
						next: dropNext
					},
					showRemoveBtn : false,
					showRenameBtn : false,
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					beforeDrag: beforeDrag,
					beforeDrop: beforeDrop,
					beforeDragOpen: beforeDragOpen,
					onDrag: onDrag,
					onDrop: onDrop,
					onExpand: onExpand,
					onClick: onClick,
					beforeExpand: beforeExpand,
					onAsyncSuccess: onAsyncSuccess,
					onAsyncError: onAsyncError
				}
			};
	
			var zNodes = ${sortList};

			$.fn.zTree.init($("#sortTree"), setting, zNodes);
			var zTree = $.fn.zTree.getZTreeObj("sortTree");

			$('div.btn-add').on('click', function(){
				var nodes = zTree.getSelectedNodes(), treeNode;
				treeNode = nodes[0];
				if(treeNode === undefined){
					$.dgform({
						url : 'addre',
						title: '新增商品类别',
						label: ['类目名称'],
						source: [
							'<input type="text" class="text-500 not-null form-value" name="name" />'
						],
						data: {success: function(data){addSort(data);}}
					});
				}else{
					if (!treeNode.isParent) {
						treeNode = treeNode.getParentNode();
					}
					$.dgform({
						url : 'addre',
						title: '新增商品类目',
						label: ['名称','所属类目'],
						source: [
							'<input type="text" class="text-500 not-null form-value" name="name" />',
							'<input type="hidden" class="form-value" name="parentId" value="' + treeNode.id + '"/>',
							'<span class="from-text">' + treeNode.name + '</span>'
						],
						data: {
							dataType: 'json',
							success: function(data){addSort(data, treeNode);}
						}
					});
				}
			});

			$('div.btn-edit').on('click', function(){
				var nodes = zTree.getSelectedNodes(), size;
				if(nodes === null){
					size = 0;
				}else{
					size = nodes.length;
				}
				alert(size)
				editSource(size, function(){editSort(nodes[0]);});
			});

			$('div.btn-delete').on('click', function(){delSource('inventory/sort/del');});

			function addSort(data, treeNode){
				if (treeNode === undefined) {
					zTree.addNodes(treeNode, {id:(data.id), pId:0, name:data.name});
				}else{
					zTree.addNodes(treeNode, {id:(data.id), pId:data.parentId, name:data.name});
				}
			}

			function editSort(treeNode){
				$.dgform({
					url : 'add',
					title: '编辑商品类目',
					label: ['名称'],
					source: [
						'<input type="text" class="text-500 not-null form-value" name="name" value="' + treeNode.name + '"/>',
						'<input type="hidden" class="form-value" name="parentId" value="' + treeNode.parentId + '"/>',
						'<input type="hidden" class="form-value" name="id" value="' + treeNode.id + '"/>'
					],
					data: {
						success: function(data){}
					}
				});
			}

			function onClick(e,treeId, treeNode) {
				zTree.expandNode(treeNode);
			}
	
			function dropPrev(treeId, nodes, targetNode) {
				var pNode = targetNode.getParentNode();
				if (pNode && pNode.dropInner === false) {
					return false;
				} else {
					for (var i=0,l=curDragNodes.length; i<l; i++) {
						var curPNode = curDragNodes[i].getParentNode();
						if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
							return false;
						}
					}
				}
				return true;
			}

			function dropInner(treeId, nodes, targetNode) {
				if (targetNode && targetNode.dropInner === false) {
					return false;
				} else {
					for (var i=0,l=curDragNodes.length; i<l; i++) {
						if (!targetNode && curDragNodes[i].dropRoot === false) {
							return false;
						} else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {
							return false;
						}
					}
				}
				return true;
			}

			function dropNext(treeId, nodes, targetNode) {
				var pNode = targetNode.getParentNode();
				if (pNode && pNode.dropInner === false) {
					return false;
				} else {
					for (var i=0,l=curDragNodes.length; i<l; i++) {
						var curPNode = curDragNodes[i].getParentNode();
						if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
							return false;
						}
					}
				}
				return true;
			}
	
			var className = "dark", startTime = 0, endTime = 0, perCount = 100, perTime = 100, curDragNodes, autoExpandNode;

			function beforeDrag(treeId, treeNodes) {
				className = (className === "dark" ? "":"dark");
				for (var i=0,l=treeNodes.length; i<l; i++) {
					if (treeNodes[i].drag === false) {
						curDragNodes = null;
						return false;
					} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
						curDragNodes = null;
						return false;
					}
				}
				curDragNodes = treeNodes;
				return true;
			}
			
			function beforeDragOpen(treeId, treeNode) {
				autoExpandNode = treeNode;
				return true;
			}
			
			function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
				className = (className === "dark" ? "":"dark");
				return true;
			}
			
			function onDrag(event, treeId, treeNodes) {
				className = (className === "dark" ? "":"dark");
			}
			
			function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
				className = (className === "dark" ? "":"dark");
			}
			
			function onExpand(event, treeId, treeNode) {
				if (treeNode === autoExpandNode) {
					className = (className === "dark" ? "":"dark");
				}
			}
			
			function setTrigger() {
				zTree.setting.edit.drag.autoExpandTrigger = true;
			}

			function beforeExpand(treeId, treeNode) {
				if (!treeNode.isAjaxing) {
					startTime = new Date();
					treeNode.times = 1;
					ajaxGetNodes(treeNode, "refresh");
					return true;
				} else {
					$.dgtip({
						level : 'info',
						autoClose : true,
						msg : '正在下载数据中，请稍后！'
					});
					return false;
				}
			}

			function onAsyncSuccess(event, treeId, treeNode, msg) {
				if (!msg || msg.length == 0) {
					return;
				}
				var zTree = $.fn.zTree.getZTreeObj("sortTree"),
				totalCount = treeNode.count;
				if (treeNode.children.length < totalCount) {
					setTimeout(function() {ajaxGetNodes(treeNode);}, perTime);
				} else {
					treeNode.icon = "";
					zTree.updateNode(treeNode);
					zTree.selectNode(treeNode.children[0]);
					endTime = new Date();
					className = (className === "dark" ? "":"dark");
				}
			}

			function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
				$.dgtip({
					level : 'error',
					msg : '获取数据出现异常！'
				});
				treeNode.icon = "";
				zTree.updateNode(treeNode);
			}

			function ajaxGetNodes(treeNode, reloadType) {
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
				if (reloadType == "refresh") {
					treeNode.icon = "../../style/zTreeStyle/img/loading.gif";
					zTree.updateNode(treeNode);
				}
				zTree.reAsyncChildNodes(treeNode, reloadType, true);
			}
			
			
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
