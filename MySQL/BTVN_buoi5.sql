-- Question 1: View danh sách nhân viên thuộc phòng Sale

CREATE OR REPLACE VIEW v_account_sale AS
SELECT
    a.account_id,
    a.email,
    a.username,
    a.fullname,
    a.create_date,
    d.department_name
FROM account AS a
JOIN department AS d
    ON a.department_id = d.department_id
WHERE UPPER(d.department_name) = 'SALE';

-- Question 2: View account tham gia nhiều group nhất
CREATE OR REPLACE VIEW v_account_most_groups AS
WITH account_group_count AS (
    SELECT
        a.account_id,
        a.email,
        a.username,
        a.fullname,
        COUNT(ga.group_id) AS total_group
    FROM account AS a
    JOIN group_account AS ga
        ON a.account_id = ga.account_id
    GROUP BY
        a.account_id,
        a.email,
        a.username,
        a.fullname
)
SELECT *
FROM account_group_count
WHERE total_group = (
    SELECT MAX(total_group)
    FROM account_group_count
);

-- Question 3: View câu hỏi có nội dung quá 300 từ và xóa chúng

-- Question 4: View phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW v_department_most_accounts AS
WITH department_count AS (
    SELECT
        d.department_id,
        d.department_name,
        COUNT(a.account_id) AS total_account
    FROM department AS d
    LEFT JOIN account AS a
        ON d.department_id = a.department_id
    GROUP BY
        d.department_id,
        d.department_name
)
SELECT *
FROM department_count
WHERE total_account = (
    SELECT MAX(total_account)
    FROM department_count
);
-- Question 5: View các câu hỏi do user họ Nguyễn tạo

CREATE OR REPLACE VIEW v_question_created_by_nguyen AS
SELECT
    q.question_id,
    q.content AS question_content,
    q.category_id,
    q.type_id,
    q.create_date,
    a.account_id AS creator_id,
    a.fullname AS creator_name,
    a.email AS creator_email
FROM question AS q
JOIN account AS a
    ON q.creator_id = a.account_id
WHERE a.fullname LIKE 'Nguyễn %';