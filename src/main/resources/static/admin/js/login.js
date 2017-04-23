/**
 * 	后台登录js
 */
$(function() {
	$('#error').hide();
	
	$('input[name="username"]').focus(function() {
		$('#error').hide();
	});
	
	$('input[name="password"]').focus(function() {
		$('#error').hide();
	});
	
	$('#login').click(function() {
		var username = $('input[name="username"]').val();
		var password = $.md5($('input[name="password"]').val());
		$.post("admin/login", {username: username, password: password}, function(result) {
			if (result.what == 200) {
				window.location = "admin/index";
			} else {
				$('#error').show();
			}
		});
		return false;
	});
});
