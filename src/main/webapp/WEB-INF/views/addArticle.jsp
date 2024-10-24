<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 추가</title>
</head>
<body>
	<form method="post">
		<input type="text" name="title">
		<input type="text" name="content">
		<input type="text" name="username">
		<input type="text" name="password">
		<button type="submit">글 추가</button>
	</form>
	<button type="button" onclick="window.location='/qna'">뒤로가기</button>
</body>
</html>