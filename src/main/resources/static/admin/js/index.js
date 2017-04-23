//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"

});

var validator;
/**
 * 后台管理js
 */
 $(function() {
	getAdminInfo();
	getDataTotal();
	getCount();
	
	validator = $("#updateForm").validate();
	//$('#error').hide();
 });

 /**
  * 获取管理员信息
  * @returns
  */
function getAdminInfo() {
 	$.get("getAdminInfo", function(result) {
		$('#nickname').text('欢迎您,' + result.object.nickname);
		$('input[name="username"]').val(result.object.username);
		$('input[name="nickname"]').val(result.object.nickname);
 	});
 }

/**
 * 修改管理员信息
 * @returns
 */
function updateAdmin() {
	if (validator.form()) {
		if ($('input[name="newPassword"]').val() != "") {
			$('input[name="newPassword"]').val($.md5($('input[name="newPassword"]').val()));
		}
		if ($('input[name="password"]').val() != "") {
			$('input[name="password"]').val($.md5($('input[name="password"]').val()));
		}
		$.post("updateAdmin", $("#updateForm").serialize(), function(result) {
			if (result.what == 200) {
				window.location = "/admin";
			} else {
				$('#error').text(result.object);
				$('#error').show();
			}
		});
	}
}

/**
 * 获取数据总数
 */
function getDataTotal() {
 	$.get("getDataTotal", function(result) {
		$('#championTotal').html(result.object.champion);
		$('#itemTotal').html(result.object.item);
		$('#spellTotal').html(result.object.spell);
 	});
}

function getCount() {
	$.get("getCount", function(result) {
		var today = result.object.today;
		var sevenDay = result.object.sevenDay;
		var total = result.object.total;
		$('#todayCount').text(today);
		$('#totalCount').text(total);

		Morris.Line({
	        element: 'morris-one-line-chart',
	        data: sevenDay,
	        xkey: 'date',
	        ykeys: ['api_nums'],
	        resize: true,
	        lineWidth: 4,
	        labels: ['date'],
	        lineColors: ['#1ab394'],
	        xLabelFormat: function(x) {
	        	var now = new Date(x);
	        	var month = now.getMonth() + 1;     
	        	var date = now.getDate();
	        	return addZero(month) + "-" + addZero(date);
	        },
	        pointSize:5
	    });
	});
}
 /**
  * 打开sweetAlert
  * @param {} name
  */
function openAlert(id) {
	swal({
  		title: "您确定更新数据吗?",
  		text: "可能会使数据丢失!",
  		type: "warning",
  		showCancelButton: true,
  		confirmButtonColor: "#DD6B55",
  		confirmButtonText: "确认",
  		cancelButtonText: "取消",
  		closeOnConfirm: false
	}, function(isConfirm){
		if (isConfirm) {
			$('.confirm').attr('disabled', true);
			$('.confirm').html('更新中...');
			if (id == 1) {
				updateChampionData();
			} else if (id == 2) {
				updateItemData();
			} else if (id == 3) {
				updateSpellData();
			}
		}
	});
}

/**
 * 更新英雄数据
 */
function updateChampionData() {
	$.get("setChampionData", function(result) {
		$('.confirm').attr('disabled', false);
		if (result.what == 200) {
			swal("已更新!", "数据已更新", "success");
		} else {
			swal("更新失败!", "服务器发成未知错误", "error");
		}
		getDataTotal();
	});
}

/**
 * 更新装备数据
 */
function updateItemData() {
	$.get("setItemData", function(result) {
		$('.confirm').attr('disabled', false);
		if (result.what == 200) {
			swal("已更新!", "数据已更新", "success");
		} else {
			swal("更新失败!", "服务器发成未知错误", "error");
		}
		getDataTotal();
	});
}

/**
 * 更新召唤师技能数据
 */
function updateSpellData() {
	$.get("setSummonerSpellData", function(result) {
		$('.confirm').attr('disabled', false);
		if (result.what == 200) {
			swal("已更新!", "数据已更新", "success");
		} else {
			swal("更新失败!", "服务器发成未知错误", "error");
		}
		getDataTotal();
	});
}

/**
 * 格式化数据
 * @param data
 * @returns
 */
function parseChartData(data) {
	var allData = [];
	var row;
	for (var i = 0; i < data.length; i++) {
		row = {};
		row.date = formatTime(data[i].date);
		row.api_nums = data[i].api_nums;
		allData.push(row);
	}
	return allData;
}

/**
 * 格式化时间字符串 2016-11-11格式化为11-11
 * @returns
 */
function formatTime(time) {
	var now = new Date(time);
	var month = now.getMonth() + 1;     
	var date = now.getDate();
	return addZero(month) + "-" + addZero(date);
}

function addZero(m) { 
	return m<10?'0'+m:m;
}