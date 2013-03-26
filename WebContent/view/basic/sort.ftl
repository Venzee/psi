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
					})
			})
		});
	</script>
	<body>
		<div class="table" id="sortTable">
			<div class="head">
				<div class="title">
					<div class="title_name">表格标题</div>
				</div>
				<div class="source_head">
					<dl>
						<dd class="text_5p">选项</dd>
						<dd class="text_5p">编号</dd>
						<dd class="text_35p">名称</dd>
						<dd class="text_35p">描述</dd>
						<dd class="text_10p">摘要</dd>
						<dd class="text_10p">操作</dd>
					</dl>
				</div>
			</div>
			<div class="source">
				<dl class="source_line odd">
					<dd class="text_5p"><input type="checkbox" name="" /></dd>
					<dd class="text_5p">1</dd>
					<dd class="text_35p">名称</dd>
					<dd class="text_35p">描述</dd>
					<dd class="text_10p">摘要</dd>
					<dd class="text_10p">操作</dd>
				</dl>
				<dl class="source_line">
					<dd class="text_5p"><input type="checkbox" name="" /></dd>
					<dd class="text_5p">2</dd>
					<dd class="text_35p">名称</dd>
					<dd class="text_35p">描述</dd>
					<dd class="text_10p">摘要</dd>
					<dd class="text_10p">操作</dd>
				</dl>
				<dl class="source_line odd">
					<dd class="text_5p"><input type="checkbox" name="" /></dd>
					<dd class="text_5p">3</dd>
					<dd class="text_35p">名称</dd>
					<dd class="text_35p">描述</dd>
					<dd class="text_10p">摘要</dd>
					<dd class="text_10p">操作</dd>
				</dl>
				<dl class="source_line">
					<dd class="text_5p"><input type="checkbox" name="" /></dd>
					<dd class="text_5p">4</dd>
					<dd class="text_35p">名称</dd>
					<dd class="text_35p">描述</dd>
					<dd class="text_10p">摘要</dd>
					<dd class="text_10p">操作</dd>
				</dl>
				<dl class="source_line odd">
					<dd class="text_5p"><input type="checkbox" name="" /></dd>
					<dd class="text_5p">5</dd>
					<dd class="text_35p">名称</dd>
					<dd class="text_35p">描述</dd>
					<dd class="text_10p">摘要</dd>
					<dd class="text_10p">操作</dd>
				</dl>
			</div>
			<div class="foot">
				<div class="delete">删除</div>
				<div class="edit">编辑</div>
				<div class="add">新增</div>
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
					<dd>用户名:</dd>
					<dd>密码:</dd>
					<dd class="high">描述:</dd>
					<dd>摘要:</dd>
					<dd>摘要:</dd>
					<dd class="img_120">图片:</dd>
				</dl>
				<dl class="source_value">
					<dd><input type="text" class="text_35p" name="" /></dd>
					<dd><input type="text" class="text_35p" name="" /></dd>
					<dd><textarea class="text_35p"></textarea></dd>
					<dd><input type="text" class="text_35p" name="" /></dd>
					<dd><input type="text" class="text_35p" name="" /></dd>
					<dd><img src="" class="text_150 img_150" /></dd>
				</dl>
				<div class="clear"></div>
			</div>
			<div class="foot"></div>
		</div>
	</body>
</html>
