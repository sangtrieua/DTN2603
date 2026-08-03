USE DTN2603_testing_system;
-- Question 3: Chuẩn bị data cho bài 3 Insert data vào 11 table, mỗi table có ít nhất 5 records.

-- 1. DEPARTMENT

INSERT INTO department (department_name)
VALUES
    ('Marketing'),
    ('Sale'),
    ('Security'),
    ('Human Resources'),
    ('Technical'),
    ('Finance');



-- 2. POSITION

INSERT INTO `position` (position_name)
VALUES
    ('DEV'),
    ('TEST'),
    ('SCRUM MASTER'),
    ('PM'),
    ('DEV');



-- 3. ACCOUNT

INSERT INTO account
    (email, username, fullname, department_id, position_id, create_date)
VALUES
    ('sang.tq@gmail.com',   'sangtq',   'Triệu Quang Sáng',  5, 1, '2026-01-10 08:00:00'),
    ('duc.cm@gmail.com',    'duccm',    'Cao Mạnh Đức',      5, 2, '2026-01-11 08:30:00'),
    ('hung.dv@gmail.com',   'hungdv',   'Đinh Văn Hưng',     3, 3, '2026-01-12 09:00:00'),
    ('linh.lh@gmail.com',   'linhlh',   'Lê Hồng Linh',      1, 4, '2026-01-13 09:30:00'),
    ('anh.btm@gmail.com',   'anhbtm',   'Bùi Thị Mai Anh',   4, 1, '2026-01-14 10:00:00'),
    ('trung.lh@gmail.com',  'trunglh',  'Lê Hải Trung',      2, 2, '2026-01-15 10:30:00');



-- 4. GROUP

INSERT INTO `group`
    (group_name, creator_id, create_date)
VALUES
    ('Java Fresher',       1, '2026-02-01 08:00:00'),
    ('MySQL Learning',     2, '2026-02-02 08:30:00'),
    ('Software Testing',   3, '2026-02-03 09:00:00'),
    ('Project Management', 4, '2026-02-04 09:30:00'),
    ('Backend Developer',  5, '2026-02-05 10:00:00');



-- 5. GROUP_ACCOUNT

INSERT INTO group_account
    (group_id, account_id, join_date)
VALUES
    (1, 1, '2026-02-10 08:00:00'),
    (1, 2, '2026-02-10 08:10:00'),
    (2, 3, '2026-02-11 09:00:00'),
    (3, 4, '2026-02-12 09:30:00'),
    (4, 5, '2026-02-13 10:00:00'),
    (5, 6, '2026-02-14 10:30:00'),
    (2, 1, '2026-02-15 11:00:00');



-- 6. TYPE_QUESTION

INSERT INTO type_question (type_name)
VALUES
    ('Essay'),
    ('Multiple-Choice'),
    ('Essay'),
    ('Multiple-Choice'),
    ('Multiple-Choice');



-- 7. CATEGORY_QUESTION

INSERT INTO category_question (category_name)
VALUES
    ('Java'),
    ('SQL'),
    ('HTML'),
    ('CSS'),
    ('JavaScript'),
    ('Spring Boot');



-- 8. QUESTION

INSERT INTO question
    (content, category_id, type_id, creator_id, create_date)
VALUES
    ('Java là ngôn ngữ lập trình gì?',               1, 2, 1, '2026-03-01 08:00:00'),
    ('Từ khóa nào được dùng để kế thừa trong Java?', 1, 2, 2, '2026-03-02 08:30:00'),
    ('Câu lệnh nào dùng để lấy dữ liệu trong SQL?',  2, 4, 3, '2026-03-03 09:00:00'),
    ('HTML là viết tắt của cụm từ nào?',              3, 4, 4, '2026-03-04 09:30:00'),
    ('Thuộc tính CSS nào dùng để đổi màu chữ?',       4, 5, 5, '2026-03-05 10:00:00'),
    ('Hãy trình bày khái niệm lập trình hướng đối tượng.', 1, 1, 6, '2026-03-06 10:30:00');



-- 9. ANSWER

INSERT INTO answer
    (content, question_id, is_correct)
VALUES
    ('Ngôn ngữ lập trình hướng đối tượng', 1, TRUE),
    ('Hệ quản trị cơ sở dữ liệu',           1, FALSE),
    ('Hệ điều hành',                        1, FALSE),

    ('extends',                             2, TRUE),
    ('implements',                          2, FALSE),
    ('import',                              2, FALSE),

    ('SELECT',                              3, TRUE),
    ('INSERT',                              3, FALSE),
    ('UPDATE',                              3, FALSE),

    ('HyperText Markup Language',           4, TRUE),
    ('HighText Machine Language',           4, FALSE),
    ('Hyper Transfer Markup Language',      4, FALSE),

    ('color',                               5, TRUE),
    ('background-color',                    5, FALSE),
    ('font-size',                           5, FALSE);



-- 10. EXAM

INSERT INTO exam
    (code, title, category_id, duration, creator_id, create_date)
VALUES
    ('JAVA01', 'Kiểm tra Java cơ bản',       1, 60, 1, '2026-04-01 08:00:00'),
    ('SQL01',  'Kiểm tra SQL cơ bản',        2, 45, 2, '2026-04-02 08:30:00'),
    ('HTML01', 'Kiểm tra HTML cơ bản',       3, 30, 3, '2026-04-03 09:00:00'),
    ('CSS01',  'Kiểm tra CSS cơ bản',        4, 30, 4, '2026-04-04 09:30:00'),
    ('JS01',   'Kiểm tra JavaScript cơ bản', 5, 60, 5, '2026-04-05 10:00:00');



-- 11. EXAM_QUESTION


INSERT INTO exam_question
    (exam_id, question_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 6),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 1);