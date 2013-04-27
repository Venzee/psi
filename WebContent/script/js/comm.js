function frameAutoSize(oIframe) {
	try {
		var oWin = oIframe.name ? window.frames[oIframe.name] : oIframe.contentWindow;
		oIframe.style.height = oWin.document.body.scrollHeight + "px";
		oIframe.style.width = oWin.document.body.width + "px";
	} catch (e) {
	}
}

function getChildFrame(selector) {
	return $("#ui-iframe").contents().find(selector);
};

function getCheckedStr(){
	var checkedStr = '';
	$.each($('div.ui-table').find('span.checkbox'), function(i, n) {
		if ($(this).hasClass('checked')) {
			checkedStr = checkedStr + $(this).attr('id') + ',';
		}
	});
	checkedStr = checkedStr.substring(0, checkedStr.length - 1);
	return checkedStr;
}

function getCheckedArray(){
	var checkedStr = getCheckedStr();
	if('' === checkedStr){
		return null;
	}
	return checkedStr.split(',');
}

function checked() {
	var isCheckAll = true;
	$.each($('div.ui-table').find('span.checkbox'), function(i, n) {
		if (!$(this).hasClass('checked')) {
			isCheckAll = false;
		}
	});
	return isCheckAll;
}

function editSource(url, callBack){
	var idArray = getCheckedArray(), size;
	if(idArray === null){
		size = 0;
	}else{
		size = idArray.length;
	}
	switch(size){
	default:
		$.dgtip({
			target: parent.$('body'),
			level : 'info',
			type : 'tip',
			autoClose : true,
			msg : '一次只能编辑一条数据！'
		});
		break;
	case 0:
		$.dgtip({
			target: parent.$('body'),
			level : 'info',
			type : 'tip',
			autoClose : true,
			msg : '请选择需要编辑的数据！'
		});
		break;
	case 1:
		callBack();
		break;
	}
}

function delSource(url){
	var idStr = getCheckedStr();
	if(idStr === null || idStr === ''){
		$.dgtip({
			target: parent.$('body'),
			level : 'info',
			type : 'tip',
			autoClose : true,
			msg : '请选择需要删除的数据！'
		});
	}else{
		$.dgconfirm({
			target: parent.$('body'),
			level : 'warning',
			width : 300,
			type : 'confirm',
			msg : '确定删除选中的数据？',
			callBack : function(){
				$.ajax({
					type : 'POST',
					url : url,
					data : 'randomNum=' + Math.random() + '&idStr=' + idStr,
					timeout: 30000,
					beforeSend : function(){
						$.showLoading(parent.$('body'));
					},
					error : function(){
						$.hideLoading(parent.$('body'));
						$.dgtip({
							target: parent.$('body'),
							level : 'error',
							type : 'tip',
							msg : '系统异常，请联系管理员！'
						});
					},
					success : function(msg){
						$.hideLoading(parent.$('body'));
						if(msg === 'true'){
							$.dgtip({
								target: parent.$('body'),
								level : 'info',
								type : 'tip',
								autoClose : true,
								msg : '删除成功！'
							});
							var form = parent.$('body').find('#mainFrame').contents().find('form.pageForm');
							if(form !== undefined && form.hasClass('pageForm')){
								form.submit();
							} else {
								var src = parent.$('body').find('#mainFrame').attr('src');
								src = src.substring(0, src.indexOf('=')) + '=' + Math.random();
								parent.$('body').find('#mainFrame').attr('src', src);
							}
						}else{
							$.dgtip({
								target: parent.$('body'),
								level : 'error',
								type : 'tip',
								msg : '删除失败！'
							});
						}
					}
				});
			}
		});
	}
}

$(function(){
	$('div.btn-check-all').on('click', function(){
		if ($(this).text() === '全选') {
			$('div.ui-table').find('span.checkbox').addClass('checked');
			$(this).text('不全选');
		} else {
			$('div.ui-table').find('span.checkbox').removeClass('checked');
			$(this).text('全选');
		}
	});
	$('div.btn-check-invert').on('click', function(){
		$('div.ui-table').find('span.checkbox').toggleClass('checked');
		if (checked()) {
			$('div.btn-check-all').text('不全选');
		} else {
			$('div.btn-check-all').text('全选');
		}
	});
	$('dl.table-source-line').on('click', function(){
		$(this).find('span.checkbox').toggleClass('checked');
		if (checked()) {
			$('div.btn-check-all').text('不全选');
		} else {
			$('div.btn-check-all').text('全选');
		}
	});
});
