<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>欢迎使用，请登录：</title>
		<link rel="stylesheet" type="text/css" href="style/css/reset.css">
		<link rel="stylesheet" type="text/css" href="style/css/ui.css">
		<link rel="stylesheet" type="text/css" href="style/css/web.css">
		<script type="text/javascript" src="script/js/jquery.min.js"></script>
		<script type="text/javascript" src="script/js/jquery.form.min.js"></script>
		<script type="text/javascript" src="script/js/comm.js"></script>
		<script type="text/javascript" src="script/js/ui.js"></script>
		<script type="text/javascript">
		$(function(){
			var s_name = $('#login-box').find('dl.form-source-name').find('dd'),
				s_val = $('#login-box').find('dd').find('input.form-value');
			$('#btn-sub').on('click', function(){
				var tip = '';
				$.each(s_val, function(){
					if($(this).hasClass('not-null')){
						if($(this).val() != null && $(this).val() != ''){
							$(this).removeClass('error').addClass('done');
						}else{
							$(this).removeClass('done').addClass('error');
							tip = tip + s_name.eq($(this).parents('dd').index()).text().replace('：', '') + '、';
						}
					}
				});
				if(tip != ''){
					tip = tip.substring(0, tip.length - 1) + '不能为空！';
					$('#tip').text(tip).slideDown();
				}else{
					$('#tip').text('').slideUp();
					$.showCover();
					$.showLoading();
					$('#login-form').ajaxSubmit({
						dataType : 'json',
						error : function(){
							$.hideLoading();
							$.hideCover();
							$.dgtip({
								level : 'error',
								msg : '登录失败，请联系服务提供商！'
							});
						},
						success : function(data){
							if(data !== null && data !== ''){
								switch(data){
									case 1:
										tip = '用户名不能为空！';
										s_val.eq(0).removeClass('done').addClass('error').focus();
										s_val.eq(1).removeClass('done').val('');
										s_val.eq(2).removeClass('done').val('');
										break;
									case 2:
										tip = '密码不能为空！';
										s_val.eq(1).removeClass('done').addClass('error').focus();
										s_val.eq(2).removeClass('done').val('');
										break;
									case 3:
										tip = '验证码不能为空！';
										s_val.eq(2).removeClass('done').addClass('error').focus();
										break;
									case 4:
										tip = '验证码错误！';
										s_val.eq(2).removeClass('done').addClass('error').val('').focus();
										break;
									case 5:
										tip = '用户名不存在！';
										s_val.eq(0).removeClass('done').addClass('error').select().focus();
										s_val.eq(1).removeClass('done').val('');
										s_val.eq(2).removeClass('done').val('');
										break;
									case 6:
										tip = '密码错误！';
										s_val.eq(1).removeClass('done').addClass('error').val('').focus();
										s_val.eq(2).removeClass('done').val('');
										break;
									case 7:
										break;
									case 8:
										break;
									case 9:
										tip = '系统不允许两个用户同时在线！';
										break;
								}
								if(tip != ''){
									$.hideLoading();
									$.hideCover();
									$('#tip').text(tip).slideDown();
								}else{
									window.location.reload();
								}
							}
						}
					});
				}
			});
		});
		</script>
	</head>
	<body>
		<div id="login-box">
			<div id="login-box-holder">
				<div id="navi">欢迎使用，请登录：</div>
				<form method="post" action="login" id="login-form">
					<div class="form-holder">
						<div id="tip"></div>
						<div class="form-source">
							<dl class="form-source-name">
								<dd>用户名：</dd>
								<dd>密码：</dd>
								<dd>验证码：</dd>
							</dl>
							<dl class="form-source-value">
								<dd><input type="text" class="w-300 not-null form-value" name="username" value="${username }" /></dd>
								<dd><input type="password" class="w-300 not-null form-value" name="password" /></dd>
								<dd><input type="text" class="w-100 not-null form-value" id="kaptcha" name="kaptcha" /></dd>
							</dl>
							<div class="clear"></div>
						</div>
						<div class="form-holder-foot">
							<a href="javascript:;" id="btn-sub">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>