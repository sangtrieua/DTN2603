-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước


DELIMITER $$
CREATE trigger trq_1
BEFORE INSERT on group_account
for each row 
	BEGIN
		IF ( SELECT create_date from `group`
			where group_id=new.group_id ) < date_sub(now(), INTERVAL  1  YEAR) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Group này đã được tạo 1 năm trước không thể nhập vào";
        END IF;
    END $$

DELIMITER ;

INSERT INTO group_account(group_id,account_id)
			VALUEs		(10,2);



-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"

DROP trigger if exists tr_q_2;
DELIMITER $$
CREATE trigger tr_q_2
BEFORE INSERT on account
for each row 
	BEGIN
		IF EXISTS (
        SELECT 1
        FROM department
        WHERE department_id = NEW.department_id
          AND department_name = 'Sale'
    ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Department ""Sale"" cannot add more user";
         
        END IF;
    END $$

DELIMITER ;

INSERT INTO account (email, username, fullname,department_id,position_id,gender)
	VALUES			('duc.ccccccm@gmail.com',"teswwwtttt","tenday",2,1,"nam");


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DELIMITER $$
CREATE trigger tr_q_3
BEFORE INSERT on group_account
for each row 
	BEGIN
		IF ( (SELECT count(1) 
				from group_account
				where group_id =new.group_id
				Group by group_id) >=5 ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Không thể thêm vào group này nữa (đã có 5 người)";
         
        END IF;
    END $$

DELIMITER ;
INSERT INTO group_account(group_id,account_id)
			VALUEs		(1,10);
           
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

SELECT exam_id,count(1)
FROM exam_question
GROUP BY exam_id;
drop trigger if EXISTS tr_q_4
DELIMITER $$
CREATE trigger tr_q_4
BEFORE INSERT on exam_question
for each row 
	BEGIN
		IF ( (SELECT count(1)
				FROM exam_question
                WHERE exam_id=new.exam_id
				GROUP BY exam_id) >=5 ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Không thể thêm question vào exam này nữa (đã có 5 question)";
         
        END IF;
    END $$

DELIMITER ;

INSERT INTO exam_question(exam_id,question_id)
VALUES					(1,11);


-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó




DROP trigger if exists tr_q_5
DELIMITER $$
CREATE trigger tr_q_5
BEFORE DELETE on account
for each row 
	BEGIN
		IF ( OLD.email = 'admin@gmail.com') THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Không thể xóa admin";
         
        END IF;
    END $$

DELIMITER ;

DELETE from account where account_id =13;


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
SELECT * FROM dtn2603_testing_system.account;

DROP trigger if exists tr_q_6;
DELIMITER $$
CREATE trigger tr_q_6
BEFORE INSERT on account
for each row 
	BEGIN
		IF ( new.department_id is null) THEN
			INSERT INTO department (department_name)
			SELECT"waiting Department"
            where not exists (SELECT 1 FROM department where department_name like"waiting Department");
            SET new.department_id = (SELECT department_id FROM department where department_name like"waiting Department");
         
        END IF;
    END $$

DELIMITER ;
	INSERT INTO account (email,username,fullname,position_id)
    VALUES				('linh.ddlh@gmail.com','linh.ddlh','question7',1);
SELECT * FROM dtn2603_testing_system.account;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.

SELECT  count(1) 
from answer 
GROUP BY question_id;

SELECT question_id,is_correct, count(1)
FROM answer
where is_correct=1
GROUP BY question_id,is_correct;

DROP trigger if exists tr_q_7;
DELIMITER $$
CREATE trigger tr_q_7
BEFORE INSERT on answer
for each row 
	BEGIN
		IF ((SELECT count(1) 
			from answer 
            where question_id=new.question_id
			GROUP BY question_id		)	>=4
            or
            (SELECT  count(1)
			FROM answer
            where question_id=new.question_id and is_correct=1 AND new.is_correct =1
			GROUP BY question_id,is_correct		) 	>=2
			)THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="bài thi chỉ cho phép tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng";
         
        END IF;
    END $$

DELIMITER ;

INSERT INTO answer(content,question_id,is_correct)
VALUES				("test queston 7",4,1);

INSERT INTO answer(content,question_id,is_correct)
VALUES				("test queston 7",3,1);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP trigger if exists tr_q_8;
DELIMITER $$
CREATE trigger tr_q_8
BEFORE INSERT on account
for each row 
	BEGIN
		IF (new.gender like "nam")THEN 
			set new.gender="M";
		ELSEIF (new.gender like "nữ") THEN
			set new.gender="F";
		ELSEIF (new.gender like "chưa xác định") THEN
			set new.gender="U";
		ELSE 
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="vui lòng nhập gender :nam, nữ, chưa xác định";
        END IF;
    END $$

DELIMITER ;

INSERT INTO account(email,username,fullname,department_id,position_id,gender)
			VALUEs('trung1.lh@gmail.com','trung.lh1','trung.lh1',1,2,'nam'),
            ('trung2.lh@gmail.com','trung.lh2','trung.lh2',1,3,'nữ'),
            ('trung3.lh@gmail.com','trung.lh3','trung.lh2',4,2,'chưa xác định');


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DROP trigger if exists tr_q_9;
DELIMITER $$
CREATE trigger tr_q_9
BEFORE DELETE on exam
for each row 
	BEGIN
		IF (OLD.create_date>date_sub(now(),INTERVAL  2  DAY ))then
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="Bài thi này vừa tạo từ";
        END IF;
    END $$

DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào

DROP trigger if exists tr_q_10_de;
DELIMITER $$
CREATE trigger tr_q_10_de
BEFORE DELETE on question
for each row 
	BEGIN
		IF EXISTS (SELECT 1 from exam_question where question_id=old.question_id ) then
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="câu hỏi này đã nằm trong exam không thể xóa";
        END IF;
    END $$

DELIMITER ;

DELETE FROM question where question_id=1;

DROP trigger if exists tr_q_10_up;
DELIMITER $$
CREATE trigger tr_q_10_up
BEFORE UPDATE on question
for each row 
	BEGIN
		IF EXISTS (SELECT 1 from exam_question where question_id=old.question_id ) then
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT="câu hỏi này đã được dùng trong exam không thể sửa";
        END IF;
    END $$

DELIMITER ;

UPDATE question
SET content="thu question 10"
where question_id=1;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT * ,
case
	when duration <=30  then "Short time"
    when duration <=60 THEN "Medium time"
    ELSE "Long time" END
 thoi_luong
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT g.*,count(acc.account_id) so_luong_acc,
case 
	when count(acc.account_id) <=5 then 'few'
    when count(acc.account_id) <=20 then 'normal'
    ELSE 'higher'
end the_number_user_amount
FROM `group` g 
LEFT join group_account ga on  ga.group_id=g.group_id
LEFT join account acc on acc.account_id=ga.account_id
GROUP BY g.group_id ;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT dep.*, 
CASE 
	WHEN count(acc.account_id) =0 then "Không có User"
    ELSE count(acc.account_id) 
END so_luong_acc
FROM department dep 
LEFT join account acc on dep.department_id=acc.department_id
GROUP BY dep.department_id


