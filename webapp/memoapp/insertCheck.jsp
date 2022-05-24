<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--登録内容確認画面 --%>
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
	
	<p class = "leftMargin">以下の内容で登録します。</p>
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
		<%--登録を行う。INSERT文の発行 --%>
		<form action ="<%= request.getContextPath()%>/Insert" method = "post">
			<input type = "submit" value = "登録する" class = "submit">
			<input type = "hidden" name="title" value ="${memo.title}">
			<input type = "hidden" name="content" value ="${memo.content}">
		</form>
		<%--登録画面へ戻る(値を渡す) --%>
		<form action ="<%= request.getContextPath()%>/ToInsert" method = "post">
			<input type = "submit" value = "やめる" class = "submit">
			<input type = "hidden" name="title" value ="${memo.title}">
			<input type = "hidden" name="content" value ="${memo.content}">
		</form>
	</div>

</body>
</html>