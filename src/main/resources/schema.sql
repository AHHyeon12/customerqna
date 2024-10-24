CREATE TABLE if not exists customerqna(
article_id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(200) NOT NULL,
content TEXT NOT NULL,
username VARCHAR(20) NOT NULL,
password VARCHAR(64) NOT NULL,
views INT DEFAULT 0,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_secure bit DEFAULT 0,
is_deleted bit DEFAULT 0
);

Insert into customerqna (title, content, username, password, is_secure) 
VALUES ('title1', 'content1', 'username1', 'password1', 1);