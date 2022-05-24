<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--メモ編集画面(更新画面) --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%= request.getContextPath()%>/memoapp/css/style.css" rel = "stylesheet">
	<title>メモ編集画面</title>
</head>
<body>
	<h1>編集画面</h1>
	
	<!-- 現在のタイトル、内容を初期表示する -->
	<!-- タイトル入力 -->
	<p class = "leftMargin">タイトル</p>
	<form action ="<%= request.getContextPath()%>/ToUpdateCheck" method ="post" id ="update">
		<input type ="text" name = "title" value = "${memo.title}" class ="textInput">

	<!-- 内容入力 -->
	<p class = "leftMargin">内容</p>
		<textarea name = "content" rows = "6" class ="textInput">${memo.content}</textarea>
	</form>
	
	<!-- 各種ボタン -->
	<div class = "flexButton">
		<%-- 編集内容確認画面へ遷移--%>
		<form action ="<%= request.getContextPath()%>/ToUpdateCheck" method = "post" id = "update">
			<input type = "submit" value = "編集を確定する" class = "submit" form = "update">
			<input type ="hidden" name = "id" value = "${memo.id}" form = "update">
		</form>
		<%-- 詳細画面に戻る。IDだけ渡す。--%> 
		<form action = "<%= request.getContextPath()%>/FindById" method= "post">
			<input type = "submit" value = "やめる" class = "submit">
			<input type ="hidden" name = "id" value = "${memo.id}">
		</form>
	</div>
</body>
</html>