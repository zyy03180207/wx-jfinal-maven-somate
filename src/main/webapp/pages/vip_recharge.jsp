<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<button style="width: 100px;height: 100px;" onclick="aaa();">测试</button>
<script type="text/javascript" src="js/jweixin-1.2.0.js"></script>
<script type="text/javascript">
wx.config({
    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '2131312312312312', // 必填，公众号的唯一标识
    timestamp: '321312312312312',  // 必填，生成签名的时间戳
    nonceStr: '2313131321', // 必填，生成签名的随机串
    signature: '32132112312',// 必填，签名，见附录1
    jsApiList: ['onMenuShareAppMessage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});

wx.ready(function(){
	alert("success");
});

wx.ready(function(){
	alert("fail");
});

function aaa() {
	wx.onMenuShareTimeline({
	    title: '', // 分享标题
	    link: '', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
	    imgUrl: '', // 分享图标
	    success: function () { 
	        // 用户确认分享后执行的回调函数
	        alert("sss");
	    },
	    cancel: function () { 
	        // 用户取消分享后执行的回调函数
	    	alert("sss111");
	    }
	});
}

</script>
</body>
</html>