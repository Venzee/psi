<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../../style/css/pss.css">
	<script type="text/javascript" src="../../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.todo-done').bind('click', function(){
				//$(this).find('.todo-icon').toggleClass('todo-icon-active');
				var topId = $(this).attr('id');
				$.ajax({
					type: 'POST',
					url: '../select',
					data: 'randomNum=' + Math.random() + '&topId=' + topId,
					dataType: 'json',
					success: function(data){
						$('.holder').append('<div class="todo"><div class="todo-head"><input class="todo-search-field" type="text" value=""/></div><dl></dl></div>');
						$.each(data,function(i){
							$('.todo:last').find('dl').append('<dd class="todo-done" id="'+ data[i].sort.id +'">'
									+'<div class="todo-icon"></div>'
									+'<div class="todo-content">'
										+'<div class="todo-name">'+ data[i].sort.name +'</div>'
										+'<div class="todo-remark">'+ data[i].sort.remark +'</div>'
									+'</div>'
								+'</dd>');
						});
						
					}
				});
			});
		});
	</script>
	<body>
		<div class="search">
			<form action="select" method="post" class="searchForm">
				<input type="hidden" name="topId" value="${topId}" />
			</form>
		</div>
		<div class="holder">
			<div class="todo">
				<div class="todo-head">
					<input class="todo-search-field" type="text" value=""/>
				</div>
				<dl>
					<#list sortList as sort>
					<dd class="todo-done" id="${sort.sort.id}">
						<div class="todo-icon"></div>
						<div class="todo-content">
							<div class="todo-name">${sort.sort.name}</div>
							<div class="todo-remark">${sort.sort.remark}</div>
						</div>
					</dd>
					</#list>
				</dl>
			</div>
		</div>
		<div class="table form dialog" id="sortDialog">
			<div class="head">
				<div class="title">
					<div class="title_name">表单标题</div>
					<div class="operation">
						<div class="close">关闭</div>					
					</div>
				</div>
			</div>
			<div class="form_source">
				<dl class="source_name">
					<dd>分类名称:</dd>
					<dd>父级分类:</dd>
					<dd class="high">备注:</dd>
				</dl>
				<dl class="source_value">
					<dd><input type="text" class="text_500 not_null form_value" name="name" /></dd>
					<dd>
						<input type="hidden" class="form_value" name="id" value="0" />
						<select class="text_150 form_value" name="topId">
							<option value="1">分类1</option>
							<option value="2">分类2</option>
							<option value="3">分类3</option>
						</select>
						<select class="text_150 form_value" name="level">
							<option value="1">分类1</option>
							<option value="1">分类2</option>
							<option value="1">分类3</option>
						</select>
					</dd>
					<dd><textarea class="text_500 not_null form_value" name="remark"></textarea></dd>
				</dl>
				<div class="clear"></div>
			</div>
			<div class="foot">
				<div class="operation">
					<div class="sub">提交</div>
				</div>
			</div>
		</div>
	</body>
</html>
