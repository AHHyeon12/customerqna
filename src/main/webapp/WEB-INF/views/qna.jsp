<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 30px;
}

.board-container {
	max-width: 800px;
	margin: 0 auto;
}

.card {
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 8px;
	margin-bottom: 15px;
	padding: 15px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.card h2 {
	margin: 0;
	font-size: 1.5em;
}

.card p {
	margin: 5px 0;
	color: #555;
}

.card .metadata {
	font-size: 0.9em;
	color: #888;
}

.add-article-btn {
	display: block;
	width: 150px;
	margin: 20px auto;
	padding: 10px;
	text-align: center;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

.add-article-btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<form method="post">
		<p><a href="qna">전체글 보기</a></p>
		<input type="text" name="searching">
		<button type="submit">검색하기</button>
	</form>
	<div class="board-container">
		<c:choose>
			<c:when test="${not empty qnaList}">
				<c:forEach var="qna" items="${qnaList}">
					<div>
						<h3>
							<a href="qna/${qna.articleId}">${qna.title}</a>
						</h3>
						<p>${qna.content}</p>
						<p>작성자: ${qna.username}</p>
						<p>조회수: ${qna.views}</p>
						<hr />
					</div>
				</c:forEach>
				
				<nav>
			<c:forEach var="num" begin="0" end="${ totalPages - 1 }">
				<c:url var="pages" value="/qna">
					<c:param name="page">${ num }</c:param>
					<c:param name="size">${ size }</c:param>
				</c:url>
				<a href="${ pages }">${ num+1 }</a>
			</c:forEach>
		</nav>
			</c:when>

			<c:otherwise>
				<p>검색 결과가 없습니다.</p>
			</c:otherwise>
		</c:choose>

		


		<a href="/addArticle" class="add-article-btn">글 추가하기</a>
	</div>
</body>
</html>
