-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó.
DELIMITER $$	

CREATE PROCEDURE q1 (in dep_name VARCHAR(20))
BEGIN
		SELECT * 	
		FROM account acc
		JOIN department dep on acc.department_id=dep.department_id
		where department_name like concat("%",dep_name,"%") ;
END $$

DELIMITER ;

call q1('Technical')


-- Question 2: Tạo store để in ra số lượng account trong mỗi group.

DELIMITER $$	

CREATE PROCEDURE q2 (in g_name VARCHAR(20),out  soluong int)
BEGIN
		SELECT  count(acc.account_id)  into soluong 
		FROM account acc
		LEFT JOIN group_account ga on acc.account_id=ga.account_id
        RIGHT JOIN `group` g on ga.group_id=g.group_id
        where g.group_name like concat("%",g_name,"%")
		GROUP BY g.group_id;
END $$

DELIMITER ;
set @soluong_acc=0;
SET @group_name='Automation Testing';
call q2(@group_name,@soluong_acc);
SELECT concat("số lượng account của group : ",@group_name,concat(" là: ",@soluong_acc,"."));

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại

-- thốngn kê theo 2 loại
DELIMITER $$	

CREATE PROCEDURE q3 ()
	BEGIN
		SELECT  tq.type_name,count(q.type_id) so_luong
		FROM type_question tq
		LEFT JOIN question q on tq.type_id=q.type_id
		GROUP BY tq.type_name;
	END $$
DELIMITER ;
		
CALL q3;
-- thống kê theo id
DELIMITER $$	

CREATE PROCEDURE q3_1 ()
	BEGIN
		SELECT  tq.*,count(q.type_id) so_luong
		FROM type_question tq
		LEFT JOIN question q on tq.type_id=q.type_id
		GROUP BY tq.type_id;
	END $$
DELIMITER ;
		
CALL q3_1;

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất.

-- trường hợp để dùng bài 5
-- để limt 1 để dùng được
drop PROCEDURE q4_1;
DELIMITER $$	

CREATE PROCEDURE q4_1 (out id int)
	BEGIN
		WITH cte as(
			SELECT  tq.type_id type_id,count(q.question_id) so_luong
			FROM type_question tq
			LEFT JOIN question q on tq.type_id=q.type_id 
            GROUP BY tq.type_id
					)
		SELECT type_id into id
			FROM cte
			where so_luong = (SELECT max(so_luong)
								FROM cte
                            )
			LIMIT 1;
	END $$
DELIMITER ;


call q4_1(@id_nhieunhat);
SELECT @id_nhieunhat;
-- trường hợp có nhiều type
drop procedure q4;
DELIMITER $$	

CREATE PROCEDURE q4 ()
	BEGIN
		WITH cte as(
			SELECT  tq.type_id type_id,count(q.question_id) so_luong
			FROM type_question tq
			LEFT JOIN question q on tq.type_id=q.type_id 
            GROUP BY tq.type_id
					)
		SELECT type_id ,so_luong
			FROM cte
			where so_luong = (SELECT max(so_luong)
								FROM cte
								
                            );
	END $$
DELIMITER ;

CALL q4;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question.

-- không được vì nếu trong trường hợp có nhiều id cùng nhiều nhất khoogn out được

-- dùng q4_1
SELECT type_name as ten_dung_nhieu
FROM type_question 
WHERE type_id=@id_nhieunhat;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào.

DROP PROCEDURE IF EXISTS q6;

DELIMITER $$

CREATE PROCEDURE q6(IN p_search VARCHAR(100))
BEGIN
    SELECT
        'GROUP' AS loai,
        g.group_id AS id,
        g.group_name AS ten
    FROM `group` AS g
    WHERE g.group_name LIKE CONCAT('%', p_search, '%')

    UNION ALL

    SELECT
        'USER' AS loai,
        a.account_id AS id,
        a.username AS ten
    FROM account AS a
    WHERE a.username LIKE CONCAT('%', p_search, '%');
END $$

DELIMITER ;

CALL q6('duccm');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công


DELIMITER $$

CREATE PROCEDURE q7(
    IN p_fullname VARCHAR(100),
    IN p_email VARCHAR(100)
)
BEGIN
    DECLARE v_username VARCHAR(100);
    DECLARE v_position_id TINYINT UNSIGNED;
    DECLARE v_department_id TINYINT UNSIGNED;

    SET v_username = SUBSTRING_INDEX(p_email, '@', 1);

    SELECT position_id
    INTO v_position_id
    FROM `position`
    WHERE position_name = 'DEV'
    LIMIT 1;

    SELECT department_id
    INTO v_department_id
    FROM department
    WHERE department_name = 'Phòng chờ'
    LIMIT 1;

    -- Thêm tài khoản
    INSERT INTO account (
        email,
        username,
        fullname,
        department_id,
        position_id,
        create_date
    )
    VALUES (
        p_email,
        v_username,
        p_fullname,
        v_department_id,
        v_position_id,
        NOW()
    );

    SELECT
        'Tạo tài khoản thành công' AS thong_bao,
        LAST_INSERT_ID() AS account_id,
        p_fullname AS fullname,
        p_email AS email,
        v_username AS username,
        v_position_id AS position_id,
        v_department_id AS department_id;
END $$

DELIMITER ;
INSERT IGNORE INTO department(department_name)
VALUES ('Phòng chờ');

CALL q7(
    'Triệu Quang Sáng',
    'sangtrieu@gmail.com'
);
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất



DELIMITER $$

CREATE PROCEDURE q8(IN p_type_name VARCHAR(50))
BEGIN
        WITH question_length AS (
            SELECT
                q.question_id,
                q.content,
                tq.type_name,
                CHAR_LENGTH(q.content) AS content_length
            FROM question AS q
            JOIN type_question AS tq
                ON q.type_id = tq.type_id
            WHERE tq.type_name = p_type_name
        )
        SELECT
            question_id,
            content,
            type_name,
            content_length
        FROM question_length
        WHERE content_length = (
            SELECT MAX(content_length)
            FROM question_length
        );
END $$

DELIMITER ;

CALL q8('Essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID


DELIMITER $$

CREATE PROCEDURE q9(IN p_exam_id INT)
BEGIN

    DELETE FROM exam_question
    WHERE exam_id = p_exam_id;

    DELETE FROM exam
    WHERE exam_id = p_exam_id;

    SELECT 'Xóa exam thành công' AS thong_bao;
END $$

DELIMITER ;

CALL q9(5);
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
