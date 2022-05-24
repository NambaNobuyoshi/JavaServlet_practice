<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--削除確認画面 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%= request.getContextPath()%>/memoapp/css/style.css" rel ="stylesheet">
	<title>確認画面</title>
</head>
<body>
	<h1>内容確認</h1>
	
	<p class = "leftMargin">以下の内容を削除します。</p>
	<!-- タイトル -->
	<div class = "flexBlock">
		<p class ="width20">タイトル</p>
		<p>${memo.title}</p>
		<form action="" method = "post">
			<input type = "hidden" name="title" value ="${memo.title}">
		</form>
	</div>
	
	<!-- 内容 -->
	<div class ="flexBlock">
		<p class = "width20">内容</p>
		<p>${memo.content}</p>
		<form action="" method = "post">
			<input type = "hidden" name="content" value ="${memo.content}">
		</form>
	</div>
	
	<!-- 各種ボタン -->
	<div class = "flexButton">
		<%--論理削除を実行する --%>
		<form action ="<%=request.getContextPath() %>/Delete" method = "post">
			<input type = "submit" value = "削除する" class = "submit">
			<input type = "hidden" name="id" value ="${memo.id}">
		</form>
		<%--削除は行わずに、詳細画面へ遷移 --%>
		<form action ="<%=request.getContextPath() %>/FindById" method = "post">
			<input type = "submit" value = "やめる" class = "submit">
			<input type = "hidden" name="id" value ="${memo.id}">
		</form>
	</div>
	
</body>
</html>