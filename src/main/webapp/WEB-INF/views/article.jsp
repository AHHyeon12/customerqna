<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 조회 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        article {
            margin-top: 20px;
        }
        header h3 {
            margin: 0;
            font-size: 2em;
            color: #333;
        }
        header h4, header p {
            margin: 5px 0;
            color: #777;
        }
        p {
            line-height: 1.6;
            color: #555;
        }
        footer {
            margin-top: 20px;
            font-size: 0.9em;
            color: #888;
            text-align: right;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <article>
            <header>
                <h3>제목: ${qna.title}</h3>
                <h4>작성자: ${qna.username}</h4>
                <p>조회수: ${qna.views}</p>
            </header>

            <p><strong>내용:</strong></p>
            <p>${qna.content}</p>

            <footer>
                <p>작성일: ${qna.createdAt}</p>
            </footer>
        </article>

        <a href="/qna" class="back-btn">목록으로 돌아가기</a>
    </div>

</body>
</html>
