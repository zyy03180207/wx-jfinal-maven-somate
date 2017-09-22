<%@page import="com.program.somate.model.Fans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Fans fans = (Fans) request.getAttribute("userInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的页面</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link rel="stylesheet" href="../css/mui.min.css">
		<style type="text/css">
			html{height: 100%;background: #FFFFFF;}
			body{height: 100%;width: 100%;margin: 0px;padding: 0px;}
			.mui-table-view span.mui-pull-right {
				color: #999;
			}
		</style>
	</head>
	<body>
		<div class="mui-content" >
			<div style="position: relative;text-align: center;">
				<img src="../images/daohanglan.png" style="width: 100%;float: left;height: 250px;"/>
				<div style="float: left;margin-top: -200px;text-align: center;width: 100%;">
					<img src=<%=fans!=null?fans.getStr("headimgurl"):"../images/16154842.jpg" %> style="margin: 0 auto;height: 85px;width: 85px;border-radius: 100px;"/>
				</div>
				<div style="width: 100%;margin-top: -100px;float: left;">
					<span style="color: #FFFFFF;font-size: 20px;"><%=fans!=null?fans.getStr("nickname"):"Somate"%></span>
				</div>
			</div>
			<ul class="mui-table-view mui-grid-view mui-grid-9" style="float: left;">
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-home"></span>
		                    <div class="mui-media-body">资料</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-email"><span class="mui-badge">5</span></span>
		                    <div class="mui-media-body">新消息</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-chatbubble"></span>
		                    <div class="mui-media-body">聊天记录</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-location"></span>
		                    <div class="mui-media-body">分享推广</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-search"></span>
		                    <div class="mui-media-body">搜索</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-phone"></span>
		                    <div class="mui-media-body">我的会员</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-gear"></span>
		                    <div class="mui-media-body">个人设置</div></a></li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-info"></span>
		                    <div class="mui-media-body">关于我们</div></a></li>
		           <li class="mui-table-view-cell mui-media mui-col-xs-3 mui-col-sm-3"><a href="#">
		                    <span class="mui-icon mui-icon-more"></span>
		                    <div class="mui-media-body">更多</div></a></li>
		        </ul>
		</div>
	</body>
	<script src="../js/mui.min.js"></script>
</html>
