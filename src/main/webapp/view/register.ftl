<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="style/css/pss.css">
<script type="text/javascript" src="script/js/jquery.min.js"></script>
<script type="text/javascript" src="script/js/comm.js"></script>
<script type="text/javascript" src="script/js/ui.js"></script>
<style type="text/css">
	#register-box {
		width: 979px;
		margin: 0 auto;
	}
	#head {
		height: 80px;
	}
	#navi {
		height: 50px;
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
		width: 325px;
		height: 50px;
		line-height: 50px;
		text-align: center;
		font-weight: bold;
		border-right: 1px solid #dcdcdc;
		border-bottom: 1px solid #dcdcdc;
	}
	#navi ul li.active {
		color: #000;
		background: #fff;
		border-bottom: none;
	}
	.step {
		display: none;
		border-left: 1px solid #dcdcdc;
		border-right: 1px solid #dcdcdc;
		border-bottom: 1px solid #dcdcdc;
		background: #fff;
		height: 400px;
	}
	.step.active {
		display: block;
	}
	.step-foot {
		width: 100%;
		height: 30px;
		line-height: 30px;
	}
	.step-foot .ui-btn {
		margin: 3px 20px;
	}
	.step-foot #btn-next,.step-foot #btn-sub {
		float: right;
	}
	.step-foot #btn-pre {
		float: left;
	}
</style>
<script type="text/javascript">
$(function(){
	$.ajax({
		type : 'POST',
		url : 'organization/industry/ajaxlist',
		data : 'randomNum=' + Math.random(),
		dataType: 'json',
		success : function(data) {
			var industrys = '';
			$.each(data, function(i,n){
				industrys = industrys + '<option value="' + n.id + '">' + n.name + '</option>'
			});
			$('#industry').append(industrys);
		}
	});
	$('#btn-next').on('click', function(){
		var steps = $('#register-form').find('div.step'), valid = true;
		$.each(steps, function(){
			if($(this).hasClass('active')){
				$.each($(this).find('dd').find('.form-value'), function(){
					if($(this).hasClass('not-null')){
						if($(this).val() != null && $(this).val() != ''){
							$(this).addClass('done');
						}else{
							valid = false;
						}
					}
				});
			}
		});
		if(valid){
			var index = $('#navi').find('li[class="active"]').removeClass('active').index() + 1;
			$('#navi').find('li:eq(' + index + ')').addClass('active');
			steps.removeClass('active');
			$(steps[index]).addClass('active');
		}
	});
	$('#btn-sub').on('click', function(){
		$.each($('#tab').find('dd').find('.form-value'), function(){
			if($(this).hasClass('not-null') && $(this).val() != null && $(this).val() != ''){
				$(this).addClass('done');
			}
		});
		$('#register-form').submit();
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
					<li class="active">第一步 > 基础信息</li>
					<li>第二步 > 管理员信息</li>
					<li>完成注册</li>
				</ul>
				<div class="clear"></div>
			</div>
			<form method="post" action="register/init" id="register-form">
				<div class="step active">
					<div class="form-source">
						<dl class="form-source-name">
							<dd>公司名称：</dd>
							<dd>联系人：</dd>
							<dd>联系电话：</dd>
							<dd>联系传真：</dd>
							<dd>联系邮箱：</dd>
							<dd>联系地址：</dd>
							<dd>经营行业：</dd>
						</dl>
						<dl class="form-source-value">
							<dd><input type="text" class="text-500 not-null form-value" name="name" /></dd>
							<dd><input type="text" class="text-500 not-null form-value" name="contact" /></dd>
							<dd><input type="text" class="text-500 not-null form-value" name="tel" /></dd>
							<dd><input type="text" class="text-500 form-value" name="fax" /></dd>
							<dd><input type="text" class="text-500 form-value" name="email" /></dd>
							<dd><input type="text" class="text-500 form-value" name="address" /></dd>
							<dd><select class="text-150 form-value" id="industry" name="industryId"></select></dd>
						</dl>
						<div class="clear"></div>
					</div>
					<div class="step-foot"><div class="ui-btn" id="btn-next">下一步</div></div>
				</div>
				<div class="step">
					<div class="form-source">
						<dl class="form-source-name">
							<dd>用户名：</dd>
							<dd>密码：</dd>
							<dd>确认密码：</dd>
						</dl>
						<dl class="form-source-value">
							<dd><input type="text" class="text-500 not-null form-value" name="username" /></dd>
							<dd><input type="text" class="text-500 not-null form-value" name="password" /></dd>
							<dd><input type="text" class="text-500 not-null" id="re-password" /></dd>
						</dl>
						<div class="clear"></div>
					</div>
					<div class="step-foot"><div class="ui-btn" id="btn-pre">上一步</div><div class="ui-btn" id="btn-sub">提交</div></div>
				</div>
				<div class="step">
					
				</div>
			</form>
		</div>
	</div>
</body>
</html>