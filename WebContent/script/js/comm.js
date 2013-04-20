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
	$.each($('.ui-table').find('.checkbox'), function(i, n) {
		if ($(this).hasClass('checked')) {
			checkedStr = checkedStr + $(this).attr('id') + ',';
		}
	});
	checkedStr = checkedStr.substring(0, checkedStr.length - 1);
	return checkedStr;
}

function getCheckedArray(){
	return getCheckedStr().split(',');
}

function checked() {
	var isCheckAll = true;
	$.each($('.ui-table').find('.checkbox'), function(i, n) {
		if ($(this).attr('class') == 'checkbox') {
			isCheckAll = false;
		}
	});
	return isCheckAll;
}

$(document).ready(function() {
	$('.btn-edit').click(function(){
		var idArray = getCheckedArray(), size;
		if(idArray == '' || idArray == null){
			size = 0;
		}else{
			size = idArray.length;
		}
		switch(size){
		default:
			$.dialog({
				target: parent.$('body'),
				level : 'info',
				type : 'tip',
				autoClose : true,
				msg : '一次只能编辑一条数据！'
			});
			break;
		case 0:
			$.dialog({
				target: parent.$('body'),
				level : 'info',
				type : 'tip',
				autoClose : true,
				msg : '请选择需要编辑的数据！'
			});
			break;
		case 1:
			editSource();
			break;
		}
	});
	$('.btn-delete').click(function(){
		var idStr = getCheckedStr();
		if(idStr == null || idStr == ''){
			$.dialog({
				target: parent.$('body'),
				level : 'info',
				type : 'tip',
				autoClose : true,
				msg : '请选择需要删除的数据！'
			});
		}else{
			$.dialog({
				target: parent.$('body'),
				level : 'warning',
				width : 300,
				type : 'confirm',
				msg : '确定删除选中的数据？',
				callBack : function(){
					$.ajax({
						type : 'POST',
						url : 'del',
						data : 'randomNum=' + Math.random() + '&idStr=' + idStr,
						timeout: 30000,
						beforeSend : function(){
							$.showLoading(parent.$('body'));
						},
						error : function(){
							$.hideLoading(parent.$('body'));
							$.dialog({
								target: parent.$('body'),
								level : 'error',
								type : 'tip',
								msg : '系统异常，请联系管理员！'
							});
						},
						success : function(msg){
							$.hideLoading(parent.$('body'));
							if(msg == 'true'){
								$.dialog({
									target: parent.$('body'),
									level : 'info',
									type : 'tip',
									autoClose : true,
									msg : '删除成功！'
								});
								var form = parent.$('body').find('#mainFrame').contents().find('.pageForm');
								if(form != undefined && form.hasClass('pageForm')){
									form.submit();
								} else {
									var src = parent.$('body').find('#mainFrame').attr('src');
									src = src.substring(0, src.indexOf('=')) + '=' + Math.random();
									parent.$('body').find('#mainFrame').attr('src', src);
								}
							}else{
								$.dialog({
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
	});
	$('.btn-check-all').click(function() {
		if ($(this).text() == '全选') {
			$('.ui-table').find('.checkbox').addClass('checked');
			$(this).text('不全选');
		} else {
			$('.ui-table').find('.checkbox').removeClass('checked');
			$(this).text('全选');
		}
	});
	$('.btn-check-invert').click(function() {
		$('.ui-table').find('.checkbox').toggleClass('checked');
		if (checked()) {
			$('.btn-check-all').text('不全选');
		} else {
			$('.btn-check-all').text('全选');
		}
	});
	$('.table-source-line').click(function() {
		$(this).find('.checkbox').toggleClass('checked');
		if (checked()) {
			$('.btn-check-all').text('不全选');
		} else {
			$('.btn-check-all').text('全选');
		}
	});
});
