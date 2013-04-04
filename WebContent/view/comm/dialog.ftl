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
		<div class="ui-table ui-form dialog" id="dialog">
			<div class="ui-head">
				<div class="ui-title">
					<div class="ui-title-name"></div>
					<div class="ui-operation">
						<div class="ui-btn btn-close">关闭</div>					
					</div>
				</div>
			</div>
			<div class="form-source">
				<dl class="form-source-name"></dl>
				<dl class="form-source-value"></dl>
				<div class="clear"></div>
			</div>
			<div class="ui-foot">
				<div class="ui-operation">
					<div class="ui-btn btn-sub">提交</div>
				</div>
			</div>
		</div>
	</body>
</html>
