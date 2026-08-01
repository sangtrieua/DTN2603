CREATE DATABASE DTN2603_testing_system;
USE DTN2603_testing_system;

-- Department
CREATE TABLE department(
    department_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) UNIQUE NOT NULL
);

-- Position
CREATE TABLE `position`(
    position_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name ENUM('DEV','TEST','SCRUM MASTER','PM') NOT NULL
);

-- Account
CREATE TABLE account(
    account_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    department_id TINYINT UNSIGNED NOT NULL,
    position_id TINYINT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT  NOW(),

    CONSTRAINT fk_account_department
        FOREIGN KEY (department_id)
        REFERENCES department(department_id),

    CONSTRAINT fk_account_position
        FOREIGN KEY (position_id)
        REFERENCES `position`(position_id)
);

-- Group
CREATE TABLE `group`(
    group_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name VARCHAR(100) UNIQUE NOT NULL,
    creator_id TINYINT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT  NOW(),

    CONSTRAINT fk_group_account
        FOREIGN KEY (creator_id)
        REFERENCES account(account_id)
);

-- GroupAccount
CREATE TABLE group_account(
    group_id TINYINT UNSIGNED NOT NULL,
    account_id TINYINT UNSIGNED NOT NULL,
    join_date DATETIME NOT NULL,

    PRIMARY KEY(group_id, account_id),

    CONSTRAINT fk_groupaccount_group
        FOREIGN KEY(group_id)
        REFERENCES `group`(group_id),

    CONSTRAINT fk_groupaccount_account
        FOREIGN KEY(account_id)
        REFERENCES account(account_id)
);

-- TypeQuestion
CREATE TABLE type_question(
    type_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name ENUM('Essay','Multiple-Choice') NOT NULL
);

-- CategoryQuestion
CREATE TABLE category_question(
    category_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) UNIQUE NOT NULL
);

-- Question
CREATE TABLE question(
    question_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    category_id TINYINT UNSIGNED NOT NULL,
    type_id TINYINT UNSIGNED NOT NULL,
    creator_id TINYINT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT  NOW(),

    CONSTRAINT fk_question_category
        FOREIGN KEY(category_id)
        REFERENCES category_question(category_id),

    CONSTRAINT fk_question_type
        FOREIGN KEY(type_id)
        REFERENCES type_question(type_id),

    CONSTRAINT fk_question_account
        FOREIGN KEY(creator_id)
        REFERENCES account(account_id)
);

-- Answer
CREATE TABLE answer(
    answer_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    question_id TINYINT UNSIGNED NOT NULL,
    is_correct BOOLEAN NOT NULL,

    CONSTRAINT fk_answer_question
        FOREIGN KEY(question_id)
        REFERENCES question(question_id)
);

-- Exam
CREATE TABLE exam(
    exam_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    title VARCHAR(100) NOT NULL,
    category_id TINYINT UNSIGNED NOT NULL,
    duration TINYINT UNSIGNED NOT NULL,
    creator_id TINYINT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT  NOW(),

    CONSTRAINT fk_exam_category
        FOREIGN KEY(category_id)
        REFERENCES category_question(category_id),

    CONSTRAINT fk_exam_account
        FOREIGN KEY(creator_id)
        REFERENCES account(account_id)
);

-- ExamQuestion
CREATE TABLE exam_question(
    exam_id TINYINT UNSIGNED NOT NULL,
    question_id TINYINT UNSIGNED NOT NULL,

    PRIMARY KEY(exam_id, question_id),

    CONSTRAINT fk_examquestion_exam
        FOREIGN KEY(exam_id)
        REFERENCES exam(exam_id),

    CONSTRAINT fk_examquestion_question
        FOREIGN KEY(question_id)
        REFERENCES question(question_id)
);