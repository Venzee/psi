<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.add').click(function(){
				parent.showModal();
				parent.$('body').prepend($('#sortDialog'));
				var left = (parent.$('body').width() - parent.$('#sortDialog').width()) / 2;
				var top = $('body').height() - parent.$('#sortDialog').height() / 2;
				parent.$('#sortDialog').slideDown().css({top:top,left:left})
					.find('.close').click(function(){
						parent.$('#sortDialog').slideUp();
						parent.$('#sortDialog .form_value').val('');
						parent.hideModal();
					});
				parent.$('#sortDialog .sub').click(function(){
					var datas = 'randomNum=' + Math.random();
					$.each(parent.$('#sortDialog .form_value'),function(i,n){
						datas = datas + "&" + $(this).attr('name') + "=" + $(this).val();
					});
					$.ajax({
						type: 'POST',
						url: 'add',
						data: datas,
						beforeSend: function(){
							parent.$('#sortDialog .form_value').val('');
							parent.$('#sortDialog').slideUp();
							parent.loading();
						},
						success: function(msg){
							if(msg == 'true'){
								parent.$('#sortDialog').remove();
								parent.hideModal();
								$('.pageForm').submit();
							}
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
				var checkedbox = $('.table').find('.checked');
				var size = checkedbox.size();
				switch(size){
				default:
					alert("一次只能编辑一个哦,亲！");
					break;
				case 0:
					alert("请选择要编辑的内容,亲！");
					break;
				case 1:
					var id = checkedbox.attr('id');
					$.ajax({
						type: 'POST',
						url: 'info',
						data: 'randomNum=' + Math.random() + '&id=' + id,
						dataType: 'json',
						success: function(data){
							$('.add').click();
							$.each(data,function(i){
								$.each(parent.$('#sortDialog .form_value'),function(){
									if(i == $(this).attr('name')){
										$(this).val(data[i]);
									}
								});
							});
						}
					});
					break;
				}
			});
			$('.delete').click(function(){
				var checkedbox = $('.table').find('.checked');
				var size = checkedbox.size();
				var id = '';
				var now = 0;
				$.each(checkedbox, function(){
					now++;
					if(now < size){
						id = id + $(this).attr('id') + ',';
					}else{
						id = id + $(this).attr('id');
					}
				});
				if(id == ''){
					alert('请选择要删除的记录哦，亲！');
				}else{
					$.ajax({
						type: 'POST',
						url: 'del',
						data: 'randomNum=' + Math.random() + '&id=' + id,
						beforeSend: function(){
							parent.showModal();
							parent.loading();
						},
						success: function(msg){
							if(msg == 'true'){
								parent.hideModal();
								$('.pageForm').submit();
							}
						}
					});
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
						<dd class="text_35p">类型名称</dd>
						<dd class="text_20p">父级分类</dd>
						<dd class="text_35p">备注</dd>
					</dl>
				</div>
			</div>
			<div class="source">
				<#list sortList as sort>
					<#if sort_index % 2 = 0>
						<dl class="source_line odd">
							<dd class="text_5p"><span id="${sort.sort.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${sort_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_35p">${sort.sort.name}</dd>
							<dd class="text_20p">${sort.topName}</dd>
							<dd class="text_35p">${sort.sort.remark}</dd>
						</dl>
					</#if>
					<#if sort_index % 2 = 1>
						<dl class="source_line">
							<dd class="text_5p"><span id="${sort.sort.id}" class="checkbox"></span></dd>
							<dd class="text_5p">${sort_index + 1 + (page.currPage - 1) * page.pageRecord}</dd>
							<dd class="text_35p">${sort.sort.name}</dd>
							<dd class="text_20p">${sort.topName}</dd>
							<dd class="text_35p">${sort.sort.remark}</dd>
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
					<#include "comm/page.ftl">
				</div>
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
