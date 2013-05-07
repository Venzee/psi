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
			$('form.pageForm').attr('action', 'inventory/sort/list');
			$('div.btn-add').on('click', function(){
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
						$.dgform({
							url : 'add',
							title: '新增商品类型',
							label: ['名称','是否父级类别','所属类别'],
							source: [
								'<input type="text" class="text_500 not_null form-value" name="name" />',
								'<div class="radio-group"><input type="hidden" class="radio-value" name="parent" value="true" /><span id="true" class="radio checked">是</span><span id="false" class="radio">否</span></lable></div>',
								'<select class="text_150 form-value" name="parentId">' + sorts + '</select>'
							]
						});
					}
				});
			});
			$('div.btn-edit').on('click', function(){editSource('inventory/sort/edit');});
			$('div.btn-delete').on('click', function(){delSource('inventory/sort/del');});
			var setting = {
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
					onClick: onClick
				}
			};
	
			var zNodes =[
				{ id:1, pId:0, name:"随意拖拽 1"},
				{ id:11, pId:1, name:"随意拖拽 1-1",dropInner:false, dropRoot:false},
				{ id:12, pId:1, name:"随意拖拽 1-2",dropInner:false, dropRoot:false},
				{ id:121, pId:1, name:"随意拖拽 1-2-1",dropInner:false, dropRoot:false},
				{ id:122, pId:1, name:"随意拖拽 1-2-2",dropInner:false, dropRoot:false},
				{ id:123, pId:1, name:"随意拖拽 1-2-3" ,dropInner:false, dropRoot:false},
				{ id:2, pId:0, name:"子节点移走 2"},
				{ id:21, pId:2, name:"我不想成为父节点 2-1", dropInner:false, dropRoot:false},
				{ id:22, pId:2, name:"我不要成为根节点 2-2", dropInner:false, dropRoot:false},
			];
	
			function onClick(e,treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
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
	
			var log, className = "dark", curDragNodes, autoExpandNode;
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
				var zTree = $.fn.zTree.getZTreeObj("sortTree");
				zTree.setting.edit.drag.autoExpandTrigger = true;
			}
			
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
		<!-- 
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
			-->
	</body>
</html>
