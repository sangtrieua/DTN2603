-- Question 1: Thêm ít nhất 10 record vào mỗi table
USE DTN2603_testing_system;

-- 1. DEPARTMENT

INSERT INTO department (department_name)
VALUES
    ('Development'),
    ('Testing'),
    ('Project Management'),
    ('Customer Support');


-- 2. POSITION

INSERT INTO `position` (position_name)
VALUES
    ('TEST'),
    ('SCRUM MASTER'),
    ('PM'),
    ('DEV'),
    ('TEST');

-- 3. ACCOUNT

INSERT INTO account
    (email, username, fullname, department_id, position_id, create_date)
VALUES
    (
        'quang.nd@gmail.com',
        'quangnd',
        'Nguyễn Đình Quang',
        7,
        1,
        '2026-01-16 11:00:00'
    ),
    (
        'nam.nv@gmail.com',
        'namnv',
        'Nguyễn Văn Nam',
        6,
        4,
        '2026-01-17 13:30:00'
    ),
    (
        'hoa.pt@gmail.com',
        'hoapt',
        'Phạm Thị Hoa',
        9,
        3,
        '2026-01-18 14:00:00'
    ),
    (
        'minh.ht@gmail.com',
        'minhht',
        'Hoàng Tuấn Minh',
        10,
        6,
        '2026-01-19 14:30:00'
    );



-- 4. GROUP

INSERT INTO `group`
    (group_name, creator_id, create_date)
VALUES
    ('Frontend Developer', 6,  '2026-02-06 10:30:00'),
    ('Spring Boot',        7,  '2026-02-07 11:00:00'),
    ('Database Design',    8,  '2026-02-08 13:30:00'),
    ('Automation Testing', 9,  '2026-02-09 14:00:00'),
    ('English for IT',     10, '2026-02-10 14:30:00');



-- 5. GROUP_ACCOUNT

INSERT INTO group_account
    (group_id, account_id, join_date)
VALUES
    (6, 7,  '2026-02-16 11:00:00'),
    (7, 8,  '2026-02-17 13:30:00'),
    (8, 9,  '2026-02-18 14:00:00'),
    (9, 10, '2026-02-19 14:30:00'),
    (10, 2, '2026-02-20 15:00:00');


-- 6. TYPE_QUESTION

INSERT INTO type_question (type_name)
VALUES
    ('Essay'),
    ('Multiple-Choice'),
    ('Essay'),
    ('Multiple-Choice'),
    ('Essay');



-- 7. CATEGORY_QUESTION

INSERT INTO category_question (category_name)
VALUES
    ('Python'),
    ('C Sharp'),
    ('ReactJS'),
    ('NodeJS');



-- 8. QUESTION

INSERT INTO question
    (content, category_id, type_id, creator_id, create_date)
VALUES
    (
        'Python sử dụng từ khóa nào để khai báo hàm?',
        7,
        7,
        7,
        '2026-03-07 11:00:00'
    ),
    (
        'C Sharp được phát triển bởi công ty nào?',
        8,
        8,
        8,
        '2026-03-08 13:30:00'
    ),
    (
        'ReactJS là thư viện dùng để xây dựng thành phần nào?',
        9,
        9,
        9,
        '2026-03-09 14:00:00'
    ),
    (
        'Hãy trình bày khái niệm NodeJS.',
        10,
        10,
        10,
        '2026-03-10 14:30:00'
    );



-- 9. ANSWER


INSERT INTO answer
    (content, question_id, is_correct)
VALUES
    ('def',                  7, TRUE),
    ('function',             7, FALSE),
    ('method',               7, FALSE),

    ('Microsoft',            8, TRUE),
    ('Google',               8, FALSE),
    ('Oracle',               8, FALSE),

    ('Giao diện người dùng', 9, TRUE),
    ('Cơ sở dữ liệu',        9, FALSE),
    ('Hệ điều hành',         9, FALSE);



-- 10. EXAM

INSERT INTO exam
    (code, title, category_id, duration, creator_id, create_date)
VALUES
    (
        'SPRING01',
        'Kiểm tra Spring Boot cơ bản',
        6,
        60,
        6,
        '2026-04-06 10:30:00'
    ),
    (
        'PYTHON01',
        'Kiểm tra Python cơ bản',
        7,
        45,
        7,
        '2026-04-07 11:00:00'
    ),
    (
        'CSHARP01',
        'Kiểm tra C Sharp cơ bản',
        8,
        45,
        8,
        '2026-04-08 13:30:00'
    ),
    (
        'REACT01',
        'Kiểm tra ReactJS cơ bản',
        9,
        60,
        9,
        '2026-04-09 14:00:00'
    ),
    (
        'NODE01',
        'Kiểm tra NodeJS cơ bản',
        10,
        60,
        10,
        '2026-04-10 14:30:00'
    );


-- 11. EXAM_QUESTION


INSERT INTO exam_question
    (exam_id, question_id)
VALUES
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM  department;

-- Question 3: lấy ra id của phòng ban "Sale"

SELECT department_id AS "id cua phong ban Sale" 
FROM  department
WHERE department_name like "Sale";

-- Question 4: lấy ra thông tin account có full name dài nhất
 

 SELECT *
 FROM account
 where length(fullname) =
 (SELECT MAX(length(fullname)) 
 from account)
 ;
 
 -- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id= 3
 
SELECT *
 FROM account
 where length(fullname) =
 (SELECT MAX(length(fullname)) 
 from account 
 WHERE department_id=3) AND
 department_id  =3 ;
 
 -- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019 
 
	SELECT *
	FROM `group`
	WHERE create_date < '2026-02-06 10:00:00';
 
 -- Question 7: Lấy ra ID của question có >= 4 câu trả lời
 
 SELECT * from answer;
SELECT  question_id, count(1) AS 'so cau tra loi'
FROM answer
GROUP BY question_id
HAVING count(1)>=4  ;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019

	SELECT *  FROM exam;
SELECT *
FROM exam
WHERE  duration >=60 AND create_date   < '2026-04-04 09:30:00';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất

SELECT  * 
FROM `group`
ORDER BY create_date DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2

SELECT  *   from account;
SELECT department_id, count(1) as "so nhan vien"
FROM account
WHERE department_id =2
GROUP BY department_id;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"

SELECT  *   
FROM account
WHERE fullname like "D%o";

