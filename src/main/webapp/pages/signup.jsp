<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>活动报名</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!--标准mui.css-->
		<link rel="stylesheet" href="../css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="../css/app.css"/>
		<link href="../css/mui.picker.css" rel="stylesheet" />
		<link href="../css/mui.poppicker.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="../css/mui.picker.min.css" />
	</head>
	<body>
		<div class="mui-content">
			<div>
				<div id="slider" class="mui-slider">
				<div class="mui-slider-group mui-slider-loop">
					<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="#">
							<img src="../images/yuantiao.jpg">
							<p class="mui-slider-title">静静看这世界</p>
						</a>
					</div>
					<div class="mui-slider-item">
						<a href="#">
							<img src="../images/shuijiao.jpg">
							<p class="mui-slider-title">幸福就是可以一起睡觉</p>
						</a>
					</div>
					<div class="mui-slider-item">
						<a href="#">
							<img src="../images/muwu.jpg">
							<p class="mui-slider-title">想要一间这样的木屋，静静的喝咖啡</p>
						</a>
					</div>
					<div class="mui-slider-item">
						<a href="#">
							<img src="../images/cbd.jpg">
							<p class="mui-slider-title">Color of SIP CBD</p>
						</a>
					</div>
					<div class="mui-slider-item">
						<a href="#">
							<img src="../images/yuantiao.jpg">
							<p class="mui-slider-title">静静看这世界</p>
						</a>
					</div>
					<!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="#">
							<img src="../images/shuijiao.jpg">
							<p class="mui-slider-title">幸福就是可以一起睡觉</p>
						</a>
					</div>
				</div>
				<div class="mui-slider-indicator mui-text-right">
					<div class="mui-indicator mui-active"></div>
					<div class="mui-indicator"></div>
					<div class="mui-indicator"></div>
					<div class="mui-indicator"></div>
				</div>
			</div>
				<ul class="mui-table-view" >
					<li class="mui-table-view-cell mui-collapse">
						<a class="mui-navigate-right" href="#">基本资料（必选）</a>
						<div class="mui-collapse-content">
							<form class="mui-input-group">
								<div class="mui-input-row">
									<label>手机</label>
									<input type="text" placeholder="手机号码不公开">
								</div>
								<div id="sexdiv" class="mui-input-row">
									<label>性别</label>
									<input id="sexTv" type="text" class="mui-input" value="" placeholder="点击选择性别" readonly>
								</div>
								<div id="birthBt" class="mui-input-row" data-options='{"type":"date","beginYear":1900,"endYear":2017}'>
									<label>生日</label>
									<input id="birthTv" type="text" class="mui-input" value="" placeholder="点击选择生日" readonly>
								</div>
								<div id="homeBt" class="mui-input-row">
									<label>家乡</label>
									<input id="homeTv" type="text" class="mui-input" value="" placeholder="点击选择家乡" readonly>
								</div>
								<div id="cityBt" class="mui-input-row">
									<label>所在城市</label>
									<input id="cityTv" type="text" class="mui-input" value="" placeholder="点击选择所在城市" readonly>
								</div>
								<div class="mui-input-row">
									<label>微信号</label>
									<input type="text" class="mui-input-clear" placeholder="微信号仅好友可见">
								</div>
								<div id="programBt" class="mui-input-row">
									<label>编程语言</label>
									<input id="programTv" class="mui-input-clear" type="text" placeholder="点击选择编程语言" readonly>
								</div>
								<div class="mui-input-row mui-plus-visible">
									<label>Input</label>
									<input type="text"  placeholder="语音输入">
								</div>
							</form>
						</div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
						<a class="mui-navigate-right" href="#">匹配倾向（必选）</a>
						<div class="mui-collapse-content">
							<form class="mui-input-group">
								<div id="sexpBt" class="mui-input-row">
									<label>性别匹配</label>
									<input id="sexpTv" type="text" class="mui-input" placeholder="点击选择性别匹配" readonly>
								</div>
								<div id="citypBt" class="mui-input-row">
									<label>地域匹配</label>
									<input id="citypTv" type="text" class="mui-input" placeholder="点击选择地域匹配" readonly>
								</div>
								<div id="agepBt" class="mui-input-row">
									<label>年龄匹配</label>
									<input id="agepTv" type="text" class="mui-input" placeholder="点击选择年龄匹配" readonly>
								</div>
								<div class="mui-input-row mui-plus-visible">
									<label>Input</label>
									<input type="text" class="mui-input-speech mui-input-clear" placeholder="语音输入">
								</div>
							</form>
						</div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
						<a class="mui-navigate-right" href="#">详细资料（必选）</a>
						<div class="mui-collapse-content">
							<form class="mui-input-group">
								<div class="mui-input-row">
									<label>Input</label>
									<input type="text" placeholder="普通输入框">
								</div>
								<div class="mui-input-row">
									<label>Input</label>
									<input type="text" class="mui-input-clear" placeholder="带清除按钮的输入框">
								</div>
		
								<div class="mui-input-row mui-plus-visible">
									<label>Input</label>
									<input type="text" class="mui-input-speech mui-input-clear" placeholder="语音输入">
								</div>
							</form>
						</div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
						<a class="mui-navigate-right" href="#">详细资料（选填）</a>
						<div class="mui-collapse-content">
							<form class="mui-input-group">
								<div class="mui-input-row">
									<label>Input</label>
									<input type="text" placeholder="普通输入框">
								</div>
								<div class="mui-input-row">
									<label>Input</label>
									<input type="text" class="mui-input-clear" placeholder="带清除按钮的输入框">
								</div>
		
								<div class="mui-input-row mui-plus-visible">
									<label>Input</label>
									<input type="text" class="mui-input-speech mui-input-clear" placeholder="语音输入">
								</div>
							</form>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<script src="../js/mui.min.js"></script>
		<!--<script src="../js/mui.picker.min.js"></script>-->
		<script src="../js/mui.picker.js"></script>
		<script src="../js/mui.poppicker.js"></script>
		<script src="../js/city.data.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/city.data-3.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/mui.picker.min.js"></script>
		<script>
			(function($, doc) {
				$.init();
				$.ready(function() {
					//普通示例
					var userPicker = new $.PopPicker();
					userPicker.setData([{
						value: 'man',
						text: '男'
					}, {
						value: 'woman',
						text: '女'
					}]);
					var programPicker = new $.PopPicker();
					programPicker.setData([{
						value: 'java',
						text: 'Java语言'
					}, {
						value: 'android',
						text: 'Android'
					}, {
						value: 'ios',
						text: 'IOS'
					}, {
						value: 'JavaScript',
						text: 'JavaScript'
					}, {
						value: 'Html',
						text: 'Html'
					}, {
						value: 'android',
						text: 'Android'
					}]);
					var sexPicker = new $.PopPicker();
					sexPicker.setData([{
						value: 'y',
						text: '只接受异性'
					}, {
						value: 't',
						text: '只接受同性'
					}, {
						value: 'w',
						text: '无所畏惧'
					}]);
					var agePicker = new $.PopPicker();
					agePicker.setData([{
						value: 'd',
						text: '只接受比自己大的'
					}, {
						value: 'x',
						text: '只接受比自己小的'
					}, {
						value: 'w',
						text: '无所畏惧'
					}]);
					var citypPicker = new $.PopPicker();
					citypPicker.setData([{
						value: 'd',
						text: '只接受同城'
					}, {
						value: 'x',
						text: '只接受异地'
					}, {
						value: 'w',
						text: '无所畏惧'
					}]);
					var sexTv = doc.getElementById("sexTv");
					var showUserPickerButton = doc.getElementById('sexdiv');
					showUserPickerButton.addEventListener('tap', function(event) {
						document.activeElement.blur();
						userPicker.show(function(items) {
							sexTv.value = items[0].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var programTv = doc.getElementById("programTv");
					var programBt = doc.getElementById('programBt');
					programBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						programPicker.show(function(items) {
							programTv.value = programTv.value != '' ? programTv.value + "," + items[0].text : items[0].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var sexpTv = doc.getElementById("sexpTv");
					var sexpBt = doc.getElementById('sexpBt');
					sexpBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						sexPicker.show(function(items) {
							sexpTv.value = items[0].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var agepTv = doc.getElementById("agepTv");
					var agepBt = doc.getElementById('agepBt');
					agepBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						agePicker.show(function(items) {
							agepTv.value = items[0].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var citypTv = doc.getElementById("citypTv");
					var citypBt = doc.getElementById('citypBt');
					citypBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						citypPicker.show(function(items) {
							citypTv.value = items[0].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					//-----------------------------------------
					//级联示例
					cityPicker = new $.PopPicker({
							layer: 2
						});
					cityPicker.setData(cityData);
					var cityBt = document.getElementById("cityBt");
					var cityTv = document.getElementById("cityTv");
					cityBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						cityPicker.show(function(items) {
							cityTv.value = items[0].text + " " + items[1].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var homeBt = document.getElementById("homeBt");
					var homeTv = document.getElementById("homeTv");
					homeBt.addEventListener('tap', function(event) {
						document.activeElement.blur();
						cityPicker.show(function(items) {
							homeTv.value = items[0].text + " " + items[1].text;
							//返回 false 可以阻止选择框的关闭
							//return false;
						});
					}, false);
					var slider = mui("#slider");
					slider.slider({
						interval: 3000
					});
					var birthBt = doc.getElementById("birthBt");
					var birthTv = doc.getElementById("birthTv");
					birthBt.addEventListener('tap', function() {
						document.activeElement.blur();
						var optionsJson = this.getAttribute('data-options') || '{}';
						var options = JSON.parse(optionsJson);
						var id = this.getAttribute('id');
						var picker = new $.DtPicker(options);
						picker.show(function(rs) {
							birthTv.value = rs.text;
							picker.dispose();
						});
					}, false);
				});
			})(mui, document);
		</script>
	</body>
</html>