<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../../../style/css/pss.css">
	<script type="text/javascript" src="../../../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.list-item').bind('click', function(){
				$(this).find('.item-icon').toggleClass('item-icon-active');
				var topId = $(this).attr('id');
				$.ajax({
					type: 'POST',
					url: '../select',
					data: 'randomNum=' + Math.random() + '&topId=' + topId,
					dataType: 'json',
					success: function(data){
						if(data.length > 0){
							$('.holder').append('<div class="list"><div class="list-head"><input class="todo-search-field" type="text" value=""/></div><dl></dl></div>');
							$.each(data,function(i){
								$('.list:last').find('dl').append('<dd class="list-item" id="'+ data[i].sort.id +'">'
											+'<div class="item-icon"></div>'
											+'<div class="item-value">'+'#'+ (i+1) + '&nbsp;--&nbsp;' + data[i].sort.name +'</div>'
									+'</dd>');
							});
						}
					}
				});
			});
		});
	</script>
	<body style="height:500px;">
		<div class="search">
			<form action="select" method="post" class="searchForm">
				<input type="hidden" name="topId" value="${topId}" />
			</form>
		</div>
		<div class="holder">
			<div class="list">
				<div class="list-head">
					<input class="todo-search-field" type="text" value=""/>
				</div>
				<dl>
					<#list sortList as sort>
					<dd class="list-item" id="${sort.sort.id}">
						<div class="item-icon"></div>
						<div class="item-value">#${sort_index + 1}&nbsp;--&nbsp;${sort.sort.name}</div>
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
