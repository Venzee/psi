<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../../style/css/pss.css">
	<script type="text/javascript" src="../../script/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.pageNum').click(function(){
				$('#currPage').val($(this).text());
				$('.pageForm').submit();
			});
			$('.pre').click(function(){
				var pageNum = parseInt($('.page .active').text()) - 1;
				$('#currPage').val(pageNum);
				$('.pageForm').submit();
			});
			$('.next').click(function(){
				var pageNum = parseInt($('.page .active').text()) + 1;
				$('#currPage').val(pageNum);
				$('.pageForm').submit();
			});
		});
	</script>
	<body>
		<form action="list" method="post" class="pageForm">
			<input type="hidden" id="currPage" name="currPage" value="${page.currPage }" />
		</form>
		<dl class="page">
			<dd class="page_num">当前页&nbsp;：${page.currPage}&nbsp;/&nbsp;${page.totalPage}</dd>
			<dd class="record_count">总记录：${page.count}&nbsp;条</dd>
			<#if page.totalPage gt 0 >
				<#list 1..page.totalPage as i>
					<#if i == page.currPage>
						<dd class="pageNum active">${i}</dd>
					<#else>
						<dd class="pageNum">${i}</dd>
					</#if>
				</#list>
				<#if page.currPage != 1>
					<dd class="pre">上一页</dd>
				</#if>
				<#if page.currPage lt page.totalPage>
					<dd class="next">下一页</dd>
				</#if>
			</#if>
		</dl>
	</body>
</html>
