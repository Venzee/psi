<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<script type="text/javascript" src="script/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="script/js/comm.js"></script>
<script type="text/javascript" src="script/js/ui.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
</script>
<style type="text/css">
	html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td {
		margin: 0;
		padding: 0;
		font: 14px "微软雅黑";
	}
	#header {
		height: 115px;
	}
	#header_inner {
		height: 60px;
		font-weight: bold;
		background: #ECF0F1;
		background: -moz-linear-gradient(top, #ECF0F1 0%, #BDC3C7 100%);
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #ECF0F1), color-stop(100%, #BDC3C7));
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ECF0F1', endColorstr='#BDC3C7', GradientType=0);
	}
	ul {
		list-style: none;
	}
	#logo {
		height: 60px;
	}
	#logo img {
		height: 40px;
		width: 227px;
		margin: 10px;
	}
	#nav {
		height: 60px;
		float: right;
		margin: 0 10px 0 0;
	}
	#nav > li {
		display: inline-block;
		*display: inline;
		height: 60px;
	}
	a.top-menu {
		display: block;
		color: #5e5e5e;
		height: 30px;
		line-height: 30px;
		border-left: 1px solid gray;
		margin: 15px 0;
		font-size: 16px;
		font-weight: bold;
		padding: 0 30px;
		text-decoration: none;
	}
	a.top-menu:hover {
		color: #fff;
	}
	#nav .megamenu {
		margin: -999999px 0 0 -999999px;
		padding: 20px 15px 10px;
		border: 1px solid #dcdcdc;
		border-top: 2px solid #3a98b0;
		position: absolute;
		background: #fff;
		-moz-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		-webkit-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		-o-box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
		box-shadow: rgba(0,0,0,0.3) 0 0 16px 0;
	}
	div.nav-child {
		float: left;
		margin: 0 36px 0 0;
	}
	h4.menu-heading a{
		color: #000;
		margin: 0 0 4px;
		text-decoration: none;
	}
	ul.nav-list {
		padding: 0 0 5px;
		margin: 0 0 11px;
		border-bottom: 1px solid #e5e5e5;
	}
	ul.nav-list.last {
		border-bottom: none;
	}
	ul.nav-list li a{
		font-size: 12px;
		text-decoration: none;
	}
	ul.nav-list li a:hover{
		text-decoration: underline;
	}
	#panel {
		height: 55px;
		background: #f3f3f3;
	}
	#panel .attachment {
		float: right;
	}
	#panel .attachment .signup,#panel .attachment form {
		display: inline-block;
		*display: inline;
	}
</style>
<script type="text/javascript">
$(function(){
	$('#header_inner').find('.hp-nav').aiMegamenu();
});
</script>
</head>
<body class="PageMain">
	<div id="header">
		<div id="header_inner">
			<a href="/content/home.html" id="logo">
				<img src="/content/typo3conf/ext/palm_template/html/../img/structure/logo24.png" alt="Palm Developer Center"/>
			</a>
			<ul class="hp-nav" id="nav">
				<li>
					<a href="/content/showcase.html" title="Showcase" target="_top" class="top-menu">销售</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/showcase/why_webos.html" target="_top">Why webOS</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/showcase/why_webos.html" target="_top">The Opportunity</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item2" target="_top">Innovative Platform</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item3" target="_top">Cross-Platform</a>
								</li>
								<li>
									<a href="/content/showcase/why_webos.html#item5" target="_top">Vibrant Community</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/showcase.html" target="_top">Showcase</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/showcase/app_showcase.html" target="_top">App Showcase</a>
								</li>
								<li>
									<a href="/content/showcase/developer_voices.html" target="_top">Developer Voices</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="https://developer.palm.com/index.php?option=com_appsubmission&amp;view=applist" title="My Apps" target="_top" class="top-menu">采购</a>
				</li>
				<li>
					<a href="/content/resources.html" title="Resources" target="_top" class="top-menu">库存</a>
					<div class="megamenu">
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/resources/design_resources.html" target="_top">Design</a>
							</h4>
							<ul class="nav-list">
								<li>
									<a href="/content/api/design/design-enyo.html">Enyo Design Guide</a>
								</li>
								<li>
									<a href="/content/resources/advanced_application_guidelines.html" target="_top">Advanced Application Guidelines</a>
								</li>
								<li>
									<a href="/content/resources/hp_webos_and_game_development.html" target="_top">webOS and Game Development</a>
								</li>
							</ul>
							<h4 class="menu-heading">
								<a href="/content/resources/development_resources.html" target="_top">Development</a>
							</h4>
							<ul class="nav-list">
								<li>
									<a href="/content/resources/develop/sdk_pdk_download.html" target="_top">Download the SDK</a>
								</li>
								<li>
									<a href="/content/api/dev-guide/enyo/enyo-basics-from-the-bottom-up.html">Enyo from the Ground Up</a>
								</li>
								<li>
									<a href="/content/api/dev-guide/enyo/tutorial.html">Enyo Tutorial</a>
								</li>
								<li>
									<a href="/content/resources/develop/third_party_tools.html" target="_top">Third-party Tools</a>
								</li>
								<li>
									<a href="/content/resources/develop/pdk_overview.html" target="_top">PDK Development</a>
								</li>
								<li>
									<a href="/content/resources/develop/developing_on_an_unactivated_device.html" target="_top">Unactivated Devices</a>
								</li>
								<li>
									<a href="/content/resources/footer/glossary.html" target="_top">Glossary</a>
								</li>
							</ul>
							<h4 class="menu-heading">
								<a href="/content/showcase/device_showcase.html" target="_top">Device Specs</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/showcase/device_showcase.html" target="_top">View All</a>
								</li>
							</ul>
						</div>
						<div class="nav-child">
							<h4 class="menu-heading">
								<a href="/content/resources/distribution_and_promotion_resources.html" target="_top">Distribution and Promotion</a>
							</h4>
							<ul class="nav-list">
								<li>
									<a href="/content/resources/distribute/developing_and_distributing_with_hp/developer_program_details.html" target="_top">Distributing with HP</a>
								</li>
								<li>
									<a href="/content/resources/distribute/application_content_criteria.html" target="_top">App Content Criteria</a>
								</li>
								<li>
									<a href="/content/resources/distribute/application_checklist.html" target="_top">App Submission Checklist</a>
								</li>
								<li>
									<a href="/content/resources/distribute/distribution_international_e_commerce.html" target="_top">International e-commerce FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/submitting_your_enyo_app.html" target="_top">Submit Your Enyo App</a>
								</li>
								<li>
									<a href="/content/resources/distribute/app_marketing_kit.html" target="_top">Market Your App</a>
								</li>
								<li>
									<a href="/content/resources/distribute/promo_codes.html" target="_top">Promo codes</a>
								</li>
								<li>
									<a href="/content/resources/develop/managing_in_app_purchase_items.html" target="_top">In-App Purchase</a>
								</li>
							</ul>
							<h4 class="menu-heading">FAQs</h4>
							<ul class="nav-list">
								<li>
									<a href="/content/resources/develop/faq.html" target="_top">Developer Program FAQ</a>
								</li>
								<li>
									<a href="/content/resources/develop/pdk_technical_faq.html" target="_top">PDK Technical FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/distribution_international_e_commerce.html" target="_top">International e-commerce FAQ</a>
								</li>
								<li>
									<a href="/content/resources/distribute/where_can_i_distribute_my_apps.html" target="_top">Countries List</a>
								</li>
							</ul>
							<h4 class="menu-heading">
								<a href="/content/resources/videos/videos.html" target="_top">Videos</a>
							</h4>
							<ul class="nav-list last">
								<li>
									<a href="/content/resources/videos/videos.html" target="_top">View All</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div id="panel">
			<div class="attachment">
				<div class="signup">
					<a class="account-text ctx-first" href="/index.php?option=com_user&amp;view=login&amp;login">Sign In</a>
					<a class="account-text" href="/index.php?option=com_user&amp;view=login&amp;signup">Sign Up</a>
				</div>
				<form class="hp-search" action="http://www.palm.com/us/search/developer.html" method="get">
					<fieldset>
						<legend>
							<span>Search Form</span>
						</legend>
						<button class="sifr ext-sifr-search" type="submit">
							<span>Search</span>
						</button>
						<input class="search-txt" name="search" placeholder="Just Search">
							<input type="hidden" value="all" id="basic-search-collection">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<div id="main"></div>
</body>
</html>