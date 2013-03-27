<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			parent.changeFrmHeight($('body').width(), $('#sortTable').height());
			$('#sortForm').hide();
			
			$('.add').click(function(){
				parent.$('#modal').fadeIn();
				parent.$('body').prepend($('#sortForm'));
				parent.$('#sortForm').slideDown().css('position', 'absolute').css('z-index', '1001')
					.css('top', (parent.$('body').height() - parent.$('#sortForm').height())/2)
					.css('left', (parent.$('body').width() - parent.$('#sortForm').width())/2)
					.find('.close').click(function(){
						parent.$('#sortForm').slideUp();
						parent.$('#modal').fadeOut();
					});
				parent.$('#sortForm .sub').click(function(){
					$.each(parent.$('body .not_null'), function(i,n){
						if($(this).val() == null || $(this).val() == ''){
							$(this).addClass('error');
						}else{
							$(this).removeClass('error');
						}
					});
				});
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
		<div class="table" id="sortTable">
			<div class="head">
				<div class="title">
					<div class="title_name">商品类型表</div>
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
				<dl class="source_line odd">
					<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="1" /></dd>
					<dd class="text_5p">1</dd>
					<dd class="text_35p">分类名称</dd>
					<dd class="text_20p">父级分类</dd>
					<dd class="text_35p">备注</dd>
				</dl>
				<dl class="source_line">
					<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="2" /></dd>
					<dd class="text_5p">2</dd>
					<dd class="text_35p">分类名称</dd>
					<dd class="text_20p">父级分类</dd>
					<dd class="text_35p">备注</dd>
				</dl>
				<dl class="source_line odd">
					<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="3" /></dd>
					<dd class="text_5p">3</dd>
					<dd class="text_35p">分类名称</dd>
					<dd class="text_20p">父级分类</dd>
					<dd class="text_35p">备注</dd>
				</dl>
				<dl class="source_line">
					<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="4" /></dd>
					<dd class="text_5p">4</dd>
					<dd class="text_35p">分类名称</dd>
					<dd class="text_20p">父级分类</dd>
					<dd class="text_35p">备注</dd>
				</dl>
				<dl class="source_line odd">
					<dd class="text_5p"><span class="checkbox"></span><input type="hidden" value="5" /></dd>
					<dd class="text_5p">5</dd>
					<dd class="text_35p">分类名称</dd>
					<dd class="text_20p">父级分类</dd>
					<dd class="text_35p">备注</dd>
				</dl>
			</div>
			<div class="foot">
				<div class="left">
					<div class="check_all">全选</div>
					<div class="check_invert">反选</div>
					<dl class="page">
						<dd>上一页</dd>
						<dd>1</dd>
						<dd class="active">2</dd>
						<dd>3</dd>
						<dd>4</dd>
						<dd>5</dd>
						<dd>6</dd>
						<dd>7</dd>
						<dd>8</dd>
						<dd>下一页</dd>
					</dl>
				</div>
				<div class="right">
					<div class="delete">删除</div>
					<div class="edit">编辑</div>
					<div class="add">新增</div>
				</div>
			</div>
		</div>
		<div class="table form" id="sortForm">
			<div class="head">
				<div class="title">
					<div class="title_name">表单标题</div>
					<div class="close">关闭</div>
				</div>
			</div>
			<div class="form_source">
				<dl class="source_name">
					<dd>分类名称:</dd>
					<dd>父级分类:</dd>
					<dd class="high">备注:</dd>
				</dl>
				<dl class="source_value">
					<dd><input type="text" class="text_500 not_null" name="" /></dd>
					<dd>
						<select class="text_150">
							<option>分类1</option>
							<option>分类2</option>
							<option>分类3</option>
						</select>
						<select class="text_150">
							<option>分类1</option>
							<option>分类2</option>
							<option>分类3</option>
						</select>
						<select class="text_150">
							<option>分类1</option>
							<option>分类2</option>
							<option>分类3</option>
						</select>
					</dd>
					<dd><textarea class="text_500 not_null"></textarea></dd>
				</dl>
				<div class="clear"></div>
			</div>
			<div class="foot">
				<div class="right">
					<div class="sub">提交</div>
				</div>
			</div>
		</div>
	</body>
</html>
