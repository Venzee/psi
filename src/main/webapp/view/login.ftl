<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="style/css/pss.css">
<script type="text/javascript" src="script/js/jquery.min.js"></script>
<script type="text/javascript" src="script/js/comm.js"></script>
<script type="text/javascript" src="script/js/ui.js"></script>
<style type="text/css">
	#login-box {
		width: 979px;
		margin: 0 auto;
	}
	#head {
		height: 80px;
	}
	#navi {
		width: 937px;
		height: 50px;
		line-height: 50px;
		border-left: 1px solid #dcdcdc;
		border-right: 1px solid #dcdcdc;
		border-top: 1px solid #dcdcdc;
		color: #808080;
		padding-left: 40px;
		text-align: left;
		font-size: 18px;
		font-weight: bold;
		background: #f3f3f3;
	}
	#register-link {
		color: #808080;
		float: right;
		*margin-top: -50px;
		margin-right: 30px;
	}
	#tip {
		height: 30px;
		line-height: 30px;
		padding: 0 40px;
		margin: 0 20px;
		border: 2px solid #e60000;
		display: none;
	}
	.step {
		border-left: 1px solid #dcdcdc;
		border-right: 1px solid #dcdcdc;
		border-bottom: 1px solid #dcdcdc;
		background: #fff;
		padding-top: 20px;
		height: 400px;
	}
	.step-foot {
		width: 100%;
		height: 30px;
		line-height: 30px;
	}
	.step-foot .ui-btn {
		margin: 3px 20px;
	}
	.step-foot #btn-sub {
		float: right;
	}
</style>
<script type="text/javascript">
$(function(){
	var tip = $('#tip').text();
	if(tip !== null && tip !== ''){
		$('#tip').slideDown();
	}
	$('#btn-sub').on('click', function(){
		$.each($('#tab').find('dd').find('.form-value'), function(){
			if($(this).hasClass('not-null') && $(this).val() != null && $(this).val() != ''){
				$(this).addClass('done');
			}
		});
		$('#login-form').submit();
	});
});
</script>
</head>
<body>
	<div id="login-box">
		<div id="head"></div>
		<div id="navi">欢迎使用，请登录：<a id="register-link" href="register">注册</a></div>
		<form method="post" action="login" id="login-form">
			<div class="step">
				<div id="tip">${tip }</div>
				<div class="form-source">
					<dl class="form-source-name">
						<dd>用户名：</dd>
						<dd>密码：</dd>
						<dd>验证码：</dd>
					</dl>
					<dl class="form-source-value">
						<dd><input type="text" class="text-500 not-null form-value" name="username" /></dd>
						<dd><input type="text" class="text-500 not-null form-value" name="password" /></dd>
						<dd><input type="text" class="text-300 not-null" id="kaptcha" name="kaptcha" /></dd>
					</dl>
					<div class="clear"></div>
				</div>
				<div class="step-foot"><div class="ui-btn" id="btn-sub">登陆</div></div>
			</div>
		</form>
	</div>
</body>
</html>