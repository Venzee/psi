<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="style/css/pss.css">
	<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="script/js/ui.js"></script>
	<script type="text/javascript">
		function dialog(setting){
			$('#dialog').dialog(setting);
		}
		$(document).ready(function(){
			
		});
	</script>
	<body>
		<div id="modal">
			<img id="load" src="style/image/loading.gif" />
		</div>
		<div class="table form dialog" id="dialog">
			<div class="head">
				<div class="title">
					<div class="title_name"></div>
					<div class="operation">
						<div class="close">关闭</div>					
					</div>
				</div>
			</div>
			<div class="form_source">
				<dl class="source_name"></dl>
				<dl class="source_value"></dl>
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
