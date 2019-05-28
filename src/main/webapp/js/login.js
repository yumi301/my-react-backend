/**
 * 判断输入框是否为空
 */
function isnull(val) {
	if (val == null || val == undefined || val == '') {
		alert("输入为空");
	}
}

window._onclick_login = function() {
	var name = document.getElementById("username").value;
	var psw = document.getElementById("password").value;
	if (!name) {
		alert("请输入用户名！");
	}
	else if (!psw) {
		alert("请输入密码！");
	}
	else {
		ajax({
			    url : "/login/check",
			    method : "POST",
			    data : {
				    username : name,
				    password : psw
			    },
			    success:function(data, xmlhttp){
			    	var token = xmlhttp.getResponseHeader("Authorization");
			    	window.location.href = "/index/default?Authorization="+token;
			    },
			    error:function(){
			    	alert("用户名或密码错误！测试账户：Jack/jack-password");
			    }
		    });
	}
	
	return false;
}

/* 封装ajax函数
 * @param {string}opt.method http连接的方式，包括POST和GET两种方式
 * @param {string}opt.url 发送请求的url
 * @param {boolean}opt.async 是否为异步请求，true为异步的，false为同步的
 * @param {object}opt.data 发送的参数，格式为对象类型
 * @param {function}opt.success ajax发送并接收成功调用的回调函数
 * @param {function}opt.error ajax发送失败调用的回调函数
 */
function ajax(opt) {
	opt = opt || {};
	opt.method = opt.method.toUpperCase() || 'POST';
	opt.url = opt.url || '';
	opt.async = opt.async || true;
	opt.data = opt.data || null;
	opt.success = opt.success || function() {
	};
	var xmlHttp = null;
	if (XMLHttpRequest) {// 根据浏览器设置请求方式
		xmlHttp = new XMLHttpRequest();
	}
	else {
		xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
	}
	var params = [];
	for (var key in opt.data) {
		params.push(key + '=' + opt.data[key]);
	}
	var postData = params.join('&');
	if (opt.method.toUpperCase() === 'POST') {
		xmlHttp.open(opt.method, opt.url, opt.async);
		// 用来判断ajax请求
		xmlHttp.setRequestHeader("x-requested-with", "XMLHttpRequest");
		xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
		if (opt.data == null) {
			xmlHttp.send();
		}
		else {
			// xmlHttp.setRequestHeader('Content-Length', postData.length);
			xmlHttp.send(postData);
		}

	}
	else if (opt.method.toUpperCase() === 'GET') {
		if (opt.data == null) {
			xmlHttp.open(opt.method, opt.url, opt.async);
		}
		else {
			xmlHttp.open(opt.method, opt.url + '?' + postData, opt.async);
		}
		// 用来判断ajax请求
		xmlHttp.setRequestHeader("x-requested-with", "XMLHttpRequest");
		xmlHttp.send(null);
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if(xmlHttp.status == 200){
				opt.success(xmlHttp.responseText, xmlHttp);
			}else{
				opt.error(xmlHttp.responseText, xmlHttp);
			}
		} 
	};
}
