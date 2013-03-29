<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.add').click(function(){
				parent.$('#modal').fadeIn();
				parent.$('body').prepend($('#sortForm'));
				var left = (parent.$('body').width() - parent.$('#sortForm').width()) / 2;
				var top = $('body').height() - parent.$('#sortForm').height() / 2;
				parent.$('#sortForm').slideDown().css({top:top,left:left})
					.find('.close').click(function(){
						parent.$('#sortForm').slideUp();
						parent.$('#modal').fadeOut();
						parent.$('#sortForm .form_value').val('');
					});
				parent.$('#sortForm .sub').click(function(){
					var datas = 'randomNum=' + Math.random();
					$.each(parent.$('#sortForm .form_value'),function(i,n){
						datas = datas + "&" + $(this).attr('name') + "=" + $(this).val();
					});
					$.ajax({
						type: 'POST',
						url: 'add',
						data: datas,
						beforeSend: function(){
							parent.$('#sortForm .form_value').val('');
							parent.$('#sortForm').slideUp();
							parent.loading();
						},
						success: function(){
							parent.$('#sortForm').remove();
							parent.$('#modal').fadeOut();
							$('#hideForm').submit();
						}
					});
				});
			});
			function validForm(){
				var valid = false;
				$.each(parent.$('body .not_null'), function(i,n){
					if($(this).val() == null || $(this).val() == ''){
						$(this).addClass('error');
					}else{
						$(this).removeClass('error');
					}
				});
				return valid;
			}
			$('.edit').click(function(){
				var checks = $('.table').find('.checked');
				var size = checks.size();
				switch(size){
				case 0:
					alert("请选择要编辑的内容,亲！");
					break;
				case 1:
					$.each(checks.parents('dl').find('input'), function(i,n){
						var val = $(this).val();
						var name = $(this).attr('name');
						$.each($('#sortForm .form_value'),function(i,n){
							if(name == $(this).attr('name')){
								$(this).val(val);
							}
						});
					});
					$('.add').click();
					break;
				default:
					alert("一次只能编辑一个哦,亲！");
					break;
				}
				
			});
			$('.delete').click(function(){
				var ids = '';
				var size = $('.table').find('.checked').size();
				var now = 0;
				$.each($('.table').find('.checked'), function(i,n){
					if($(this).attr('class') != 'checkbox'){
						now++;
						if(now < size){
							ids = ids + $(this).next().val() + ',';
						}else{
							ids = ids + $(this).next().val();
						}
					}
				});
				if(ids == ''){
					alert('请选择要删除的记录哦，亲！');
				}
			});
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
			function checked(){
				var isCheckAll = true;
				$.each($('.table').find('.checkbox'), function(i,n){
					if($(this).attr('class') == 'checkbox'){
						isCheckAll = false;
					}
				});
				return isCheckAll;
			}
		});
	</script>
	<body>
		<form action="list" method="post" id="hideForm"></form>
		<div class="table" id="sortTable">
			<div class="head">
				<div class="title">
					<div class="title_name">商品类型表</div>
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
						<dd class="text_35p">分类名称</dd>
						<dd class="text_20p">父级分类</dd>
						<dd class="text_35p">备注</dd>
					</dl>
				</div>
			</div>
			<div class="source">
				<#list sortList as sort>
					<#if sort_index % 2 = 0>
						<dl class="source_line odd">
							<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="${sort.sort.id}" name="id" /></dd>
							<dd class="text_5p">${sort_index + 1}<input type="hidden" value="${sort.sort.level}" name="level" /></dd>
							<dd class="text_35p">${sort.sort.name}<input type="hidden" value="${sort.sort.name}" name="name" /></dd>
							<dd class="text_20p">${sort.topName}<input type="hidden" value="${sort.sort.topId}" name="topId" /></dd>
							<dd class="text_35p">${sort.sort.remark}<input type="hidden" value="${sort.sort.remark}" name="remark" /></dd>
						</dl>
					</#if>
					<#if sort_index % 2 = 1>
						<dl class="source_line">
							<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="${sort.sort.id}" name="id" /></dd>
							<dd class="text_5p">${sort_index + 1}<input type="hidden" value="${sort.sort.level}" name="level" /></dd>
							<dd class="text_35p">${sort.sort.name}<input type="hidden" value="${sort.sort.name}" name="name" /></dd>
							<dd class="text_20p">${sort.topName}<input type="hidden" value="${sort.sort.topId}" name="topId" /></dd>
							<dd class="text_35p">${sort.sort.remark}<input type="hidden" value="${sort.sort.remark}" name="remark" /></dd>
						</dl>
					</#if>
				</#list>
			</div>
			<div class="foot">
				<#if (sortList?size>1) >
					<div class="btn">
						<div class="check_all">全选</div>
						<div class="check_invert">反选</div>
					</div>
				</#if>
				<div class="operation">
					<dl class="page">
						<dd class="page_num">当前页&nbsp;：${page.currPage}&nbsp;/&nbsp;${page.totalPage}</dd>
						<dd class="record_count">总记录：${page.count}</dd>
						<dd>1</dd>
						<dd class="active">2</dd>
						<dd>3</dd>
						<dd>4</dd>
						<dd>5</dd>
						<dd>6</dd>
						<dd>7</dd>
						<dd>8</dd>
						<dd>上一页</dd>
						<dd>下一页</dd>
					</dl>
				</div>
			</div>
		</div>
		<div class="table form dialog" id="sortForm">
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
