
function refreshCaptcha() {
	var captcha = document.getElementById("img_captcha");
	captcha.src = "image.jsp?"+Math.random();
}


//回车登录
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		submitform();
	}
});

function submitform(){
	$("#errormsg").text("");
	if($("#userName").val() == ""){
		$("#errormsg").text("请输入用户名！");
		return false;
	}
	if($("#password").val() == ""){
		$("#errormsg").text("请输入密码！");
		return false;
	}
	if($("#captcha").val() == ""){
		$("#errormsg").text("请输入验证码！");
		return false;
	}
	var form = document.getElementById('form');
	form.submit();
}


