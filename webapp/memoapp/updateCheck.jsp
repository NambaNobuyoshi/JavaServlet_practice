<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--編集内容確認画面 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%= request.getContextPath()%>/memoapp/css/style.css" rel ="stylesheet">
	<title>確認画面</title>
</head>
<body>
	<h1>入力内容確認</h1>
	
	<p class = "leftMargin">以下の内容で更新します。</p>
	<!-- タイトル -->
	<div class = "flexBlock">
		<p class ="width20">タイトル</p>
		<p>${memo.title}</p>
	</div>
	
	<!-- 内容 -->
	<div class ="flexBlock">
		<p class = "width20">内容</p>
		<p>${memo.content}</p>
	</div>
	
	<!-- 各種ボタン -->
	<div class = "flexButton">
		<%--UPDATE文を発行する。更新後、詳細画面へ戻る --%>
		<form action ="<%= request.getContextPath()%>/Update" method = "post">
			<input type = "submit" value = "更新する" class = "submit">
			<input type = "hidden" name="id" value ="${memo.id}">
			<input type = "hidden" name="title" value ="${memo.title}">
			<input type = "hidden" name="content" value ="${memo.content}">
		</form>
		<%--編集画面へ戻る --%>
		<form action = "<%= request.getContextPath()%>/ToUpdate" method= "post">
			<input type = "submit" value = "やめる" class = "submit">
			<input type = "hidden" name="id" value ="${memo.id}">
			<input type = "hidden" name="title" value ="${memo.title}">
			<input type = "hidden" name="content" value ="${memo.content}">
		</form>
	</div>
</body>
</html>