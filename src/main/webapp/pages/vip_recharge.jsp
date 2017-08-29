<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>张阳阳救助中心</title>
</head>
<body>
<h2>请为张阳阳捐献一点爱心吧！！！！！！！</h2>
<input type="button" style="width: 100px;height: 100px;" onclick="aaa();" value="捐献爱心">
<script type="text/javascript" src="../js/jweixin-1.2.0.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '<%=request.getAttribute("appId")%>', // 必填，公众号的唯一标识
    timestamp: '<%=request.getAttribute("timestamp")%>',  // 必填，生成签名的时间戳
    nonceStr: '<%=request.getAttribute("nonceStr")%>', // 必填，生成签名的随机串
    signature: '<%=request.getAttribute("signature")%>',// 必填，签名，见附录1
    jsApiList: ['chooseWXPay','onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
var openId = '<%=request.getAttribute("openId")%>';
function aaa() {
	
	$.ajax({  
        type:"POST",  
        url:"topay",  
        data:{'openId':openId},  
        dataType:"json",  
        success:function(data){  
     	 wx.chooseWXPay({
     	    timestamp: data.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
     	    nonceStr: data.nonceStr, // 支付签名随机串，不长于 32 位
     	    package: data.package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
     	    signType: data.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
     	    paySign: data.paySign, // 支付签名
     	    success: function (res) {
     	        // 支付成功后的回调函数
     	        alert("支付成功");
     	    }
     	});
        }
    });  
}

</script>
</body>
</html>