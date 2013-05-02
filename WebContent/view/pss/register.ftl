<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath + '/' }" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="style/css/pss.css">
<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="script/js/comm.js"></script>
<script type="text/javascript" src="script/js/ui.js"></script>
<style type="text/css">
	body,div,ul,li {
		margin: 0;
		padding: 0;
		font: 14px "微软雅黑";
	}
	body {
		background-color: #eee;
	}
	#register-box {
		width: 985px;
		margin: 0 auto;
	}
	#head {
		height: 80px;
	}
	#navi {
		border-left: 1px solid #dcdcdc;
		border-top: 1px solid #dcdcdc;
	}
	#navi ul {
		height: 50px;
		list-style: none;
		background: #f3f3f3;
	}
	#navi ul li {
		color: #808080;
		float: left;
		width: 245px;
		height: 50px;
		line-height: 50px;
		text-align: center;
		cursor: pointer;
		font-weight: bold;
		border-right: 1px solid #dcdcdc;
	}
	#navi ul li.active {
		color: #000;
		background: #fff;
	}
	.step {
		border: 1px solid #dcdcdc;
	}
	.step {
		display: none;
		background: #fff;
		height: 400px;
	}
	.step.active {
		display: block;
	}
	.clear {
		clear: both;
	}
</style>
<script type="text/javascript">
$(function(){
	$('#navi').find('li').on('click', function(){
		$('#navi').find('li').removeClass('active');
		$(this).addClass('active');
		var index = $(this).index();
		$('#tab').find('div.step').removeClass('active');
		$('#tab').find('div.step:eq('+index+')').addClass('active');
	});
});
</script>
</head>
<body>
	<div id="register-box">
		<div id="head"></div>
		<div id="tab">
			<div id="navi">
				<ul>
					<li class="active">第一步</li>
					<li>第二步</li>
					<li>完成注册</li>
				</ul>
				<div class="clear"></div>
			</div>
			<div class="step active">
				<div class="form-source">
					<dl class="form-source-name">
						<dd>公司名称：</dd>
						<dd>公司电话：</dd>
						<dd>公司传真：</dd>
						<dd>公司联系人：</dd>
						<dd>公司邮箱：</dd>
						<dd>公司地址：</dd>
						<dd>行业：</dd>
					</dl>
					<dl class="form-source-value">
						<dd><input type="text" class="text_500 not_null form-value" name="name" /></dd>
						<dd><input type="text" class="text_500 not_null form-value" name="contact" /></dd>
						<dd><input type="text" class="text_500 not_null form-value" name="phone" /></dd>
						<dd><input type="text" class="text_500 form-value" name="fax" /></dd>
						<dd><input type="text" class="text_500 form-value" name="email" /></dd>
						<dd><input type="text" class="text_500 form-value" name="address" /></dd>
						<dd><select class="text_150 not_null form-value" name="industryId"></select></dd>
					</dl>
					<div class="clear">
				</div>
			</div>
			<div class="step">
				<div class="form-source">
					<dl class="form-source-name">
						<dd>用户名：</dd>
						<dd>密码：</dd>
						<dd>确认密码：</dd>
					</dl>
					<dl class="form-source-value">
						<dd><input type="text" class="text_500 not_null form-value" name="username" /></dd>
						<dd><input type="text" class="text_500 not_null form-value" name="password" /></dd>
						<dd><input type="text" class="text_500 not_null form-value" id="re-password" /></dd>
					</dl>
					<div class="clear">
				</div>
			</div>
			<div class="step">
				
			</div>
		</div>
	</div>
</body>
</html>