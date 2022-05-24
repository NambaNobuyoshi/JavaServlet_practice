<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--メモの詳細を表示する画面 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%=request.getContextPath()%>/memoapp/css/style.css" rel = "stylesheet">
	<title>メモ詳細画面</title>
</head>
<body>
	<h1>詳細画面</h1>
	
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
		<%--編集画面へ遷移 --%>
		<form action ="<%=request.getContextPath() %>/ToUpdate" method = "post" >
			<input type ="submit" value = "編集する" class= "submit">
			<input type ="hidden" name = "id" value = "${memo.id}">
			<input type ="hidden" name = "title" value = "${memo.title}">
			<input type ="hidden" name = "content" value = "${memo.content}">
		</form>
		<%--削除確認画面へ遷移 --%>
		<form action ="<%=request.getContextPath() %>/ToDeleteCheck" method = "post" >
			<input type ="submit" value = "削除する" class = "submit">
			<input type ="hidden" name = "id" value = "${memo.id}">
			<input type ="hidden" name = "title" value = "${memo.title}">
			<input type ="hidden" name = "content" value = "${memo.content}">
		</form>
		<%--一覧画面へ戻る --%>
		<form action ="<%=request.getContextPath() %>/SelectAll" method = "get" >
			<input type ="submit" value = "戻る" class = "submit">
		</form>
	</div>
	
</body>
</html>