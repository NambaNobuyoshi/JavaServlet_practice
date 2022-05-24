<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--メモの登録画面 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%= request.getContextPath()%>/memoapp/css/style.css" rel ="stylesheet">
	<title>メモ入力画面</title>
</head>
<body>
	<h1>入力画面</h1>
	
	<!-- タイトル入力 -->
	<p class = "leftMargin">タイトル</p>
	<form action ="<%=request.getContextPath() %>/ToInsertCheck" method ="post" id = "insert">
		<input type ="text" name = "title" class ="textInput" value = "${memo.title}">

	<!-- 内容入力 -->
	<p class = "leftMargin">内容</p>
		<textarea name = "content"  rows = "6" class ="textInput">${memo.content}</textarea>
	</form>
	
	<!-- 各種ボタン -->
	<div class = "flexButton">
		<%--登録確認画面へ --%>
		<form action ="<%=request.getContextPath() %>/ToInsertCheck" method = "post" id = "insert">
			<input type = "submit" value = "登録する" class = "submit" form = "insert">
		</form>
		<%--一覧画面へ遷移 --%>
		<form action ="<%=request.getContextPath() %>/SelectAll" method = "get">
			<input type = "submit" value = "やめる" class = "submit">
		</form>
	</div>
</body>
</html>