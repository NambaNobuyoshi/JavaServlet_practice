<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--メモの一覧画面 --%>
<!--タグライブラリーの設定 -->
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width = device-width initialscale = 1">
	<link href = "<%= request.getContextPath()%>/memoapp/css/style.css" rel = "stylesheet">
	<title>メモ一覧画面</title>
</head>
<body>
	<h1>一覧画面</h1>
	
	<!-- 一覧 -->
	<c:forEach var="memo" items="${memoList}">
		<div id ="listBlock">
			<p>タイトル：${memo.getTitle()}</p>
			<div class = "rightBlock">
				<%--詳細画面へ遷移 --%>
				<form action = "<%= request.getContextPath()%>/FindById" method= "post">
					<input type = "hidden" name="id" value = "${memo.getId()}">
					<input type ="submit" value = "詳細" class = "submitInList">
				</form>
			</div>
			
		</div>
	</c:forEach>
	
	<%--登録画面へ遷移 --%>
	<form action ="<%= request.getContextPath()%>/memoapp/insert.jsp" method = "post">
		<input type = "submit" value = "新規登録" class ="submitInList leftMargin">
	</form>

</body>
</html>