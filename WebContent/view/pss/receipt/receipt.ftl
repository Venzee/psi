<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
</head>
<style type="text/css">
	body,div,dl,dd{
		margin: 0;
		padding: 0;
	}
	.clear{
		height: 1px;
		clear: both;
		float: none;
	}
	.text-5p{
		width: 5%;
	}
	.text-10p{
		width: 9.8%;
	}
	.text-15p{
		width: 15%;
	}
	.text-20p{
		width: 20%;
	}
	.text-25p{
		width: 25%;
	}
	.text-30p{
		width: 30%;
	}
	.text-35p{
		width: 35%;
	}
	.text-40p{
		width: 40%;
	}
	.text-45p{
		width: 45%;
	}
	.text-50p{
		width: 50%;
	}
	.text-55p{
		width: 55%;
	}
	.text-60p{
		width: 60%;
	}
	.receipt{
		width: 960px;
		height: 400px;
		margin: 0 auto;
	}
	.receipt-head{
		width: 100%;
	}
	.receipt-info{
		width: 600px;
		float: left;
	}
	.receipt-info div{
		width: 100%;
		text-align: left;
		margin: 2px 0;
	}
	.info-name{		
		font-size: 28px;
		font-weight: bold;		
	}
	.info-address{
		
	}
	.info-contact{
		
	}
	.receipt-serial{
		width: 360px;
		float: right;
		padding-top: 20px;
		text-align: center;
	}
	.receipt-type{
		font-size: 22px;
	}
	.receipt-code{
		width: 100%;
		height: 20px;
		font-size: 14px;
		font-weight: bold;
	}
	.receipt-recipient{
		
	}
	.receipt-recipient dl{
		height: 22px;
	}
	.receipt-recipient dl dd{
		width: 50%;
		float: left;
		line-height: 22px;
	}
	.recipient-date{
		text-align: right;
	}
	.receipt-source{
		width: 100%;
		border: 1px solid #808080;
	}
	.receipt-source dl{
		width: 100%;		
		border-bottom: 1px solid #808080;
	}
	.receipt-source dl dd{
		float: left;
		text-align: center;
	}
	.receipt-source dl dd{
		border-right: 1px solid #808080;
	}
	.receipt-source dl dd.last{
		border-right: none;
	}
	.source-head dl{
		height: 25px;
		background: #dcdcdc;
	}
	.source-head dl dd{
		font-weight: bold;
		line-height: 25px;
		border-bottom: 1px solid #808080;
	}
	.source-row dl{
		height: 22px;
	}
	.source-row dl dd{
		line-height: 22px;
	}
	.source-row .row{
		
	}
	.source-count{
		height: 22px;
		line-height: 22px;
		text-align: right;
		font-weight: bold;
		margin-right: 10px;
	}
	.receipt-tip{
		width: 14px;
		height: 100%;
		float: right;
		font-size: 10px;
		text-align: center;
		layout-flow: vertical-ideographic;
	}
	.receipt-foot dl{
		height: 25px;
	}
	.receipt-foot dl dd{
		width: 30%;
		float: left;
		line-height: 25px;
	}
</style>

<body>
	<div class="receipt">
		<div class="receipt-head">
			<div class="receipt-info">
				<div class="info-name">某某公司</div>
				<div class="info-address">深圳市某某某地区某某路某某号某某栋</div>
				<div class="info-contact">电话：0755-00000000 传真：0755-8888888</div>
			</div>
			<div class="receipt-serial">
				<div class="receipt-type">送货单</div>
				<div class="receipt-code">RE-JH-130406222288888</div>
			</div>
			<div class="clear"></div>
			<div class="receipt-recipient">
				<dl>
					<dd>单位名称：</dd>
					<dd class="recipient-date">日期：2013年4月8日10:57:39</dd>
				</dl>
			</div>
		</div>
		<div class="receipt-source">
			<div class="source-head">
				<dl>
					<dd class="text-5p">序号</dd>
					<dd class="text-25p">名称</dd>
					<dd class="text-10p">数量</dd>
					<dd class="text-5p">单位</dd>
					<dd class="text-10p">单价(元)</dd>
					<dd class="text-10p">总价(元)</dd>
					<dd class="text-25p">备注</dd>
					<dd class="last text-10p">操作</dd>
				</dl>
			</div>
			<div class="source-row">
				<#list 1..10 as i>
				<dl class="row">
					<dd class="text-5p">${i}</dd>
					<dd class="text-25p">名称</dd>
					<dd class="text-10p">数量</dd>
					<dd class="text-5p">单位</dd>
					<dd class="text-10p">单价</dd>
					<dd class="text-10p">总价</dd>
					<dd class="text-25p">备注</dd>
					<dd class="last text-10p">操作</dd>
				</dl>
				</#list>
			</div>
			<div class="source-count">合计：壹仟贰佰叁拾元整 / 1230.00元</div>
		</div>
		<!-- <div class="receipt-tip">第1联 - 某某联 第2联 - 某某联 第3联 - 某某联</div> -->
		<div class="receipt-foot">
			<dl>
				<dd>经手人：</dd>
				<dd>审核人：</dd>
				<dd>创建人：</dd>
			</dl>
		</div>
	</div>
</body>
</html>