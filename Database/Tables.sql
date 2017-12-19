CREATE TABLE user (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL,
password VARCHAR(50),
score INT(6) DEFAULT 0,
timestamp LONG
)

CREATE TABLE category (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
timestamp LONG
)

CREATE TABLE question (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
category_id INT(6),
question TEXT,
c_anwser TEXT,
w_answer TEXT,
w_answer2 TEXT,
w_answer3 TEXT,
)