-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ

SELECT * 
FROM account acc 
LEFT JOIN department dep on acc.department_id	=dep.department_id;


-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010


SELECT * 
FROM account WHERE create_date >'2010-12-10';

-- Question 3: Viết lệnh để lấy ra tất cả các developer

SELECT * FROM position ;
SELECT * 
FROM account acc 
JOIN position po on acc.position_id	=po.position_id
WHERE position_name like "DEV";

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT department_name, count(acc.account_id) as so_luong_nv
FROM account acc 
JOIN department dep on acc.department_id	=dep.department_id
GROUP BY dep.department_id
HAVING count(acc.account_id)>3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất



SELECT que.*, count(eq.exam_id) so_luong_dung
FROM question que
LEFT JOIN exam_question eq ON que.question_id=eq.question_id
GROUP BY que.question_id
HAVING count(eq.exam_id) = (SELECT max(so_luong)
							FROM (SELECT count(1) so_luong
								FROM question que
								LEFT JOIN exam_question eq ON que.question_id=eq.question_id
								GROUP BY que.question_id)
							bang_dem);


-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

SELECT ca.*, count(que.question_id) so_luong_dung_trong_category_question
FROM category_question ca
LEFT JOIN question que ON ca.category_id=que.category_id
GROUP BY ca.category_id;


-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT que.*, count(eq.exam_id) so_luong_dung
FROM question que
LEFT JOIN exam_question eq ON que.question_id=eq.question_id
GROUP BY que.question_id; 

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất




SELECT que.*, count(an.answer_id) so_luong
FROM question que
LEFT JOIN answer an ON que.question_id=an.question_id
GROUP BY que.question_id
HAVING so_luong = (SELECT max(so_luong)
						FROM (SELECT COUNT(1) so_luong
							FROM question que
							LEFT JOIN answer an ON que.question_id=an.question_id
							GROUP BY que.question_id)
						dem) ; 

 
-- Question 9: Thống kê số lượng account trong mỗi group

SELECT g.*, count(ga.group_id) so_luong_acc		
FROM `group` g
LEFT JOIN group_account ga ON g.group_id=ga.group_id
GROUP BY g.group_id;


-- Question 10: Tìm chức vụ có ít người nhất

SELECT po.*,count(account_id) so_luong_acc
FROM account acc
RIGHT JOIN position po on acc.position_id=po.position_id
GROUP BY po.position_id
HAVING so_luong_acc =(SELECT min(so_luong)
						FROM(SELECT count(account_id) so_luong
								FROM account acc
								RIGHT JOIN position po on acc.position_id=po.position_id
								GROUP BY po.position_id) 
							dem);


-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
 SELECT
    dep.department_id,
    dep.department_name,
    SUM(CASE WHEN po.position_name = 'DEV' THEN 1 ELSE 0 END) AS so_luong_dev,
	SUM(CASE WHEN po.position_name = 'TEST' THEN 1 ELSE 0 END) AS so_luong_test,
    SUM(CASE WHEN po.position_name = 'SCRUM MASTER' THEN 1 ELSE 0 END) AS so_luong_scrum_master,
    SUM(CASE WHEN po.position_name = 'PM' THEN 1 ELSE 0 END) AS so_luong_pm
FROM account acc 
RIGHT JOIN department dep on acc.department_id=dep.department_id
LEFT JOIN `position` po on acc.position_id=po.position_id
GROUP BY dep.department_id;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của  
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT que.*, tq.type_name as "loại câu hỏi",acc.fullname as"người tạo ra câu hỏi"
,an.content as"câu trả lời", (CASE WHEN an.is_correct = 1 THEN "đúng" ELSE "sai" END) as "đáp án"
FROM question que 
LEFT join type_question tq on que.type_id=tq.type_id
LEFT JOIN  account acc ON que.creator_id = acc.account_id
LEFT JOIN answer an ON que.question_id=an.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT tq.type_name,  COUNT(q.question_id) AS so_luong
FROM type_question AS tq
LEFT JOIN question AS q ON tq.type_id = q.type_id
GROUP BY tq.type_name;

-- Question 14:Lấy ra group không có account nào
-- Question 15: Lấy ra group không có account nào
SELECT g.group_id,g.group_name,count(ga.account_id) so_luong
FROM `group` g 
LEFT JOIN group_account ga ON g.group_id=ga.group_id
GROUP BY g.group_id
HAVING count(ga.account_id) =0;
-- Question 16: Lấy ra question không có answer nào

SELECT que.*,count(an.answer_id) soluong
FROM question que
LEFT JOIN answer an on que.question_id=an.question_id
GROUP BY que.question_id
HAVING soluong=0;