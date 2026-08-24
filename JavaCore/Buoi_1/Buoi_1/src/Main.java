import java.security.spec.RSAOtherPrimeInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date now = new Date();

        // ==================== QUESTION 2 ====================
        // 1. Khởi tạo 3 Department
        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName = "Sale";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName = "Development";

        // 2. Khởi tạo 3 Position
        Position position1 = new Position();
        position1.positionId = 1;
        position1.positionName = PositionName.DEV;

        Position position2 = new Position();
        position2.positionId = 2;
        position2.positionName = PositionName.TEST;

        Position position3 = new Position();
        position3.positionId = 3;
        position3.positionName = PositionName.PM;

        // 3. Khởi tạo 3 Account
        Account account1 = new Account();
        account1.accountId = 1;
        account1.email = "sang@gmail.com";
        account1.username = "sang";
        account1.fullName = "Trieu Quang Sang";
        account1.department = department3;
        account1.position = position1;
        account1.createDate = now;

        Account account2 = new Account();
        account2.accountId = 2;
        account2.email = "an@gmail.com";
        account2.username = "an";
        account2.fullName = "Nguyen Van An";
        account2.department = department1;
        account2.position = position2;
        account2.createDate = now;

        Account account3 = new Account();
        account3.accountId = 3;
        account3.email = "binh@gmail.com";
        account3.username = "binh";
        account3.fullName = "Tran Van Binh";
        account3.department = department2;
        account3.position = position3;
        account3.createDate = now;

        // 4. Khởi tạo 3 Group
        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Java Fresher";
        group1.creator = account1;
        group1.createDate = now;

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "SQL Fresher";
        group2.creator = account2;
        group2.createDate = now;

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Testing System";
        group3.creator = account3;
        group3.createDate = now;

        // 5. Khởi tạo 3 GroupAccount
        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = group1;
        groupAccount1.account = account2;
        groupAccount1.joinDate = now;

        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = now;

        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.group = group3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = now;

        // 6. Khởi tạo 3 TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.typeId = 1;
        typeQuestion1.typeName = TypeName.ESSAY;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.typeId = 2;
        typeQuestion2.typeName = TypeName.MULTIPLE_CHOICE;

        TypeQuestion typeQuestion3 = new TypeQuestion();
        typeQuestion3.typeId = 3;
        typeQuestion3.typeName = TypeName.ESSAY;

        // 7. Khởi tạo 3 CategoryQuestion
        CategoryQuestion category1 = new CategoryQuestion();
        category1.categoryId = 1;
        category1.categoryName = "Java";

        CategoryQuestion category2 = new CategoryQuestion();
        category2.categoryId = 2;
        category2.categoryName = "SQL";

        CategoryQuestion category3 = new CategoryQuestion();
        category3.categoryId = 3;
        category3.categoryName = ".NET";

        // 8. Khởi tạo 3 Question
        Question question1 = new Question();
        question1.questionId = 1;
        question1.content = "Java la gi?";
        question1.type = typeQuestion1;
        question1.category = category1;
        question1.creator = account1;
        question1.createDate = now;

        Question question2 = new Question();
        question2.questionId = 2;
        question2.content = "Primary Key la gi?";
        question2.type = typeQuestion2;
        question2.category = category2;
        question2.creator = account2;
        question2.createDate = now;

        Question question3 = new Question();
        question3.questionId = 3;
        question3.content = "ASP.NET Core la gi?";
        question3.type = typeQuestion3;
        question3.category = category3;
        question3.creator = account3;
        question3.createDate = now;

        // 9. Khởi tạo 3 Answer
        Answer answer1 = new Answer();
        answer1.answerId = 1;
        answer1.content = "Java la ngon ngu lap trinh huong doi tu.";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.answerId = 2;
        answer2.content = "Primary Key dung de dinh danh duy nhat mot ban ghi.";
        answer2.question = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.answerId = 3;
        answer3.content = "ASP.NET Core la mot he quan tri co so du lieu.";
        answer3.question = question3;
        answer3.isCorrect = false;

        // 10. Khởi tạo 3 Exam
        Exam exam1 = new Exam();
        exam1.examId = 1;
        exam1.code = "JAVA01";
        exam1.title = "De thi Java Core";
        exam1.category = category1;
        exam1.duration = 60;
        exam1.creator = account1;
        exam1.createDate = now;

        Exam exam2 = new Exam();
        exam2.examId = 2;
        exam2.code = "SQL01";
        exam2.title = "De thi SQL";
        exam2.category = category2;
        exam2.duration = 45;
        exam2.creator = account2;
        exam2.createDate = now;

        Exam exam3 = new Exam();
        exam3.examId = 3;
        exam3.code = "NET01";
        exam3.title = "De thi .NET";
        exam3.category = category3;
        exam3.duration = 90;
        exam3.creator = account3;
        exam3.createDate = now;

        // 11. Khởi tạo 3 ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.exam = exam1;
        examQuestion1.question = question1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.exam = exam2;
        examQuestion2.question = question2;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.exam = exam3;
        examQuestion3.question = question3;

        // ==================== QUESTION 3 ====================
        System.out.println("===== DEPARTMENT =====");
        System.out.println(department1.departmentName);
        System.out.println(department2.departmentName);
        System.out.println(department3.departmentName);

        System.out.println("\n===== POSITION =====");
        System.out.println(position1.positionName);
        System.out.println(position2.positionName);
        System.out.println(position3.positionName);

        System.out.println("\n===== ACCOUNT =====");
        System.out.println(account1.fullName);
        System.out.println(account2.fullName);
        System.out.println(account3.fullName);

        System.out.println("\n===== GROUP =====");
        System.out.println(group1.groupName);
        System.out.println(group2.groupName);
        System.out.println(group3.groupName);

        System.out.println("\n===== GROUP ACCOUNT =====");
        System.out.println(groupAccount1.account.fullName + " - " + groupAccount1.group.groupName);
        System.out.println(groupAccount2.account.fullName + " - " + groupAccount2.group.groupName);
        System.out.println(groupAccount3.account.fullName + " - " + groupAccount3.group.groupName);

        System.out.println("\n===== TYPE QUESTION =====");
        System.out.println(typeQuestion1.typeName);
        System.out.println(typeQuestion2.typeName);
        System.out.println(typeQuestion3.typeName);

        System.out.println("\n===== CATEGORY QUESTION =====");
        System.out.println(category1.categoryName);
        System.out.println(category2.categoryName);
        System.out.println(category3.categoryName);

        System.out.println("\n===== QUESTION =====");
        System.out.println(question1.content);
        System.out.println(question2.content);
        System.out.println(question3.content);

        System.out.println("\n===== ANSWER =====");
        System.out.println(answer1.content + " - " + answer1.isCorrect);
        System.out.println(answer2.content + " - " + answer2.isCorrect);
        System.out.println(answer3.content + " - " + answer3.isCorrect);

        System.out.println("\n===== EXAM =====");
        System.out.println(exam1.title + " - " + exam1.duration + " phut");
        System.out.println(exam2.title + " - " + exam2.duration + " phut");
        System.out.println(exam3.title + " - " + exam3.duration + " phut");

        System.out.println("\n===== EXAM QUESTION =====");
        System.out.println(examQuestion1.exam.code + " - " + examQuestion1.question.content);
        System.out.println(examQuestion2.exam.code + " - " + examQuestion2.question.content);
        System.out.println(examQuestion3.exam.code + " - " + examQuestion3.question.content);


        // ==================== BTVN BUOI_2 ====================
//        Exercise 1: Flow Control - Tiếp tục bài tập Day 01
//        IF
//        Question 1:
//        Kiểm tra account thứ 2
//        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
        System.out.println("IF: Question1");
        if (account2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account2.department.departmentName);
        }


//        Question 2:
//        Kiểm tra account thứ 2
//        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
        System.out.println("IF: Question2");
        GroupAccount groupAccount[] = {groupAccount1, groupAccount2, groupAccount3};
        int countIfQ2 = 0;
        String groupName = "";
        for (GroupAccount group : groupAccount) {
            if (group.account == account2) {
                countIfQ2++;
                if (!groupName.isEmpty()) groupName += ", ";
                groupName += group.group.groupName;
            }
        }

        if (countIfQ2 == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (countIfQ2 <= 2) {
            System.out.println("Group của nhân viên này là: " + groupName);
        } else if (countIfQ2 == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

//        Question 3:
//        Sử dụng toán tử ternary để làm Question 1
        System.out.println("IF: Question3");
        System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là " + account2.department.departmentName);

//        Question 4:
//        Sử dụng toán tử ternary để làm yêu cầu sau:
//        Kiểm tra Position của account thứ 1
//        Nếu Position = Dev thì in ra text "Đây là Developer"
//        Nếu không phải thì in ra text "Người này không phải là Developer"
        System.out.println("IF: Question4");
        System.out.println(account1.position.positionName == PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");
//        SWITCH CASE
//        Question 5:
//        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//        Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//        Còn lại in ra "Nhóm có nhiều thành viên"

        System.out.println("SWITCH CASE: Question5");
        int countQ5 = 0;
        for (GroupAccount group : groupAccount) {
            if (group.group == group1) countQ5++;
        }
        switch (countQ5) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
//        Question 6:
//        Sử dụng switch case để làm lại Question 2

        System.out.println("SWITCH CASE: Question6");
        int countIfQ5 = 0;
        String groupNameQ5 = "";
        for (GroupAccount group : groupAccount) {
            if (group.account == account2) {
                countIfQ5++;
                if (!groupName.isEmpty()) groupNameQ5 += ", ";
                groupNameQ5 += group.group.groupName;
            }
        }
        switch (countIfQ5) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1, 2:
                System.out.println("Group của nhân viên này là: " + groupNameQ5);
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

//        Question 7:
//        Sử dụng switch case để làm lại Question 4
        System.out.println("SWITCH CASE: Question7");
        switch (account1.position.positionName) {
            case DEV:
                System.out.println("Đây là Developer");
                break;

            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
//        FOREACH
//        Question 8:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        System.out.println("SWITCH CASE: Question8");
            Account listAccount[]={account1,account2,account3};
        System.out.println("DANH SÁCH CÁC ACCOUNT");
        System.out.println("+=====+====================+====================+===============+");
        System.out.printf("|%-5s|%-20s|%-20s|%-15s|\n","ID","Email","Fullname","DepartmentName");
        System.out.println("+=====+====================+====================+===============+");
        System.out.println("SWITCH CASE: Question6");
            for(Account account : listAccount) {
                System.out.printf("|%-5s|%-20s|%-20s|%-15s|\n",account.accountId,account.email,account.fullName,account.department.departmentName);
            }
        System.out.println("+=====+====================+====================+===============+");
//        Question 9:
//        In ra thông tin các phòng ban bao gồm: id và name

        System.out.println("SWITCH CASE: Question9");
        Department listDeparmet[]={department1,department2,department3};
        System.out.println("DANH SÁCH CÁC DEPARTMENT");
        System.out.println("+=====+====================+");
        System.out.printf("|%-5s|%-20s|\n","ID","DepartmentName");
        System.out.println("+=====+====================+");
        for(Department department : listDeparmet) {
            System.out.printf("|%-5s|%-20s|\n",department.departmentId,department.departmentName);
        }
        System.out.println("+=====+====================+");
//                FOR
//        Question 10:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//        họ theo định dạng như sau:
//        Thông tin account thứ 1 là:
//        Email: NguyenVanA@gmail.com
//        Full name: Nguyễn Văn A
//        Phòng ban: Sale
//        Thông tin account thứ 2 là:
//        Email: NguyenVanB@gmail.com
//        Full name: Nguyễn Văn B
//        Phòng ban: Marketting

        System.out.println("FOR: Question10");
        for (int i = 0; i < listAccount.length; i++) {
            System.out.println("Thông tin account thứ "+(i+1)+" là:");
            System.out.println("Email: "+listAccount[i].email);
            System.out.println("Full name: "+listAccount[i].fullName);
            System.out.println("Phòng ban: "+listAccount[i].department.departmentName);
            System.out.println("========================================");
        }

//        Question 11:
//        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//        Thông tin department thứ 1 là:
//        Id: 1
//        Name: Sale
//        Thông tin department thứ 2 là:
//        Id: 2
//        Name: Marketing
        System.out.println("FOR: Question11");
        for (int i = 0; i < listDeparmet.length; i++) {
            System.out.println("Thông tin department thứ "+(i+1)+" là:");
            System.out.println("ID: "+listDeparmet[i].departmentId);
            System.out.println("Name : "+listDeparmet[i].departmentName);
        }
//        Question 12:
//        Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        System.out.println("FOR: Question12");
        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ "+(i+1)+" là:");
            System.out.println("ID: "+listDeparmet[i].departmentId);
            System.out.println("Name : "+listDeparmet[i].departmentName);
        }
//        Question 13:
//        In ra thông tin tất cả các account ngoại trừ account thứ 2
        System.out.println("FOR: Question13");
        for (int i = 0; i < listAccount.length; i++) {
            if (listAccount[i]==account2) {continue;}
            System.out.println("Thông tin account thứ "+(i+1)+" là:");
            System.out.println("Email: "+listAccount[i].email);
            System.out.println("Full name: "+listAccount[i].fullName);
            System.out.println("Phòng ban: "+listAccount[i].department.departmentName);
            System.out.println("========================================");
        }

//        Question 14:
//        In ra thông tin tất cả các account có id < 4
        System.out.println("FOR: Question14");
        for (int i = 0; i < listAccount.length; i++) {
            if (listAccount[i].accountId>=4) {continue;}
            System.out.println("Thông tin account thứ "+(i+1)+" là:");
            System.out.println("Email: "+listAccount[i].email);
            System.out.println("Full name: "+listAccount[i].fullName);
            System.out.println("Phòng ban: "+listAccount[i].department.departmentName);
            System.out.println("========================================");
        }

//        Question 15:
//        In ra các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("FOR: Question15");
        for (int i = 0; i <= 20; i++) {
            if(i%2==1) {continue;}
            System.out.println(i);
        }
//        WHILE
//        Question 16:
//        Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
//        lệnh break, continue
        System.out.println("While: Question16.1");
        System.out.println("========================================");
        int dem1=0;
        while (true) {
            if (dem1 >= listAccount.length) {
                break;
            }
            System.out.println("Thông tin account thứ "+(dem1+1)+" là:");
            System.out.println("Email: "+listAccount[dem1].email);
            System.out.println("Full name: "+listAccount[dem1].fullName);
            System.out.println("Phòng ban: "+listAccount[dem1].department.departmentName);
            System.out.println("========================================");
            dem1++;
        }
        System.out.println("\n========================================");
        System.out.println("While: Question16.2");
        System.out.println("========================================");
        int dem2=0;
        while (true) {
            if (dem2 >= listDeparmet.length) {
                break;
            }
            System.out.println("Thông tin department thứ "+(dem2+1)+" là:");
            System.out.println("ID: "+listDeparmet[dem2].departmentId);
            System.out.println("Name : "+listDeparmet[dem2].departmentName);
            dem2++;
        }

        System.out.println("\n========================================");
        System.out.println("While: Question16.3");
        System.out.println("========================================");
        int dem3=0;
        while (true) {
            if (dem3 >= listDeparmet.length || dem3 >= 2) {
                break;
            }
            System.out.println("Thông tin department thứ "+(dem3+1)+" là:");
            System.out.println("ID: "+listDeparmet[dem3].departmentId);
            System.out.println("Name : "+listDeparmet[dem3].departmentName);

            dem3++;
        }

  //      Question 13:
//        In ra thông tin tất cả các account ngoại trừ account thứ 2
        System.out.println("\n========================================");
        System.out.println("While: Question16.4");
        System.out.println("========================================");
        int dem4=0;
        while (true) {

            if (dem4 >= listAccount.length) {
                break;
            }
            if (listAccount[dem4]==account2) {dem4++;continue;}
            System.out.println("Thông tin account thứ "+(dem4+1)+" là:");
            System.out.println("Email: "+listAccount[dem4].email);
            System.out.println("Full name: "+listAccount[dem4].fullName);
            System.out.println("Phòng ban: "+listAccount[dem4].department.departmentName);
            System.out.println("========================================");
            dem4++;

        }

//        Question 14:
//        In ra thông tin tất cả các account có id < 4
        System.out.println("\n========================================");
        System.out.println("While: Question16.5");
        System.out.println("========================================");
        int dem5=0;
        while (true) {
            if (dem5 >= listAccount.length) {
                break;
            }
            if (listAccount[dem5].accountId>=4) {dem5++; continue;}
            System.out.println("Thông tin account thứ "+(dem5+1)+" là:");
            System.out.println("Email: "+listAccount[dem5].email);
            System.out.println("Full name: "+listAccount[dem5].fullName);
            System.out.println("Phòng ban: "+listAccount[dem5].department.departmentName);
            System.out.println("========================================");
            dem5++;
        }

//        Question 15:
//        In ra các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("FOR: Question15");
        int dem6=0;
        while (dem6<=20) {
            if(dem6%2==1) {dem6++;continue;}
            System.out.println(dem6);
            dem6++;
        }
//                DO-WHILE
//        Question 17:
//        Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
//        lệnh break, continue
//
        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.1");
        System.out.println("========================================");

        int dem7 = -1;

        do {
            dem7++;

            if (dem7 >= listAccount.length) {
                break;
            }

            System.out.println(
                    "Thông tin account thứ " + (dem7 + 1) + " là:"
            );
            System.out.println(
                    "Email: " + listAccount[dem7].email
            );
            System.out.println(
                    "Full name: " + listAccount[dem7].fullName
            );
            System.out.println(
                    "Phòng ban: "
                            + listAccount[dem7].department.departmentName
            );
            System.out.println("========================================");

        } while (true);
        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.2");
        System.out.println("========================================");

        int dem8 = -1;

        do {
            dem8++;

            if (dem8 >= listDeparmet.length) {
                break;
            }

            System.out.println(
                    "Thông tin department thứ " + (dem8 + 1) + " là:"
            );
            System.out.println(
                    "ID: " + listDeparmet[dem8].departmentId
            );
            System.out.println(
                    "Name: " + listDeparmet[dem8].departmentName
            );

        } while (true);

        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.3");
        System.out.println("========================================");

        int dem9 = -1;

        do {
            dem9++;

            if (dem9 >= listDeparmet.length || dem9 >= 2) {
                break;
            }

            System.out.println(
                    "Thông tin department thứ " + (dem9 + 1) + " là:"
            );
            System.out.println(
                    "ID: " + listDeparmet[dem9].departmentId
            );
            System.out.println(
                    "Name: " + listDeparmet[dem9].departmentName
            );

        } while (true);


        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.4");
        System.out.println("========================================");

        int dem10 = -1;

        do {
            dem10++;

            if (dem10 >= listAccount.length) {
                break;
            }

            if (listAccount[dem10] == account2) {
                continue;
            }

            System.out.println(
                    "Thông tin account thứ " + (dem10 + 1) + " là:"
            );
            System.out.println(
                    "Email: " + listAccount[dem10].email
            );
            System.out.println(
                    "Full name: " + listAccount[dem10].fullName
            );
            System.out.println(
                    "Phòng ban: "
                            + listAccount[dem10].department.departmentName
            );
            System.out.println("========================================");

        } while (true);

        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.5");
        System.out.println("========================================");

        int dem11 = -1;

        do {
            dem11++;

            if (dem11 >= listAccount.length) {
                break;
            }

            if (listAccount[dem11].accountId >= 4) {
                continue;
            }

            System.out.println(
                    "Thông tin account thứ " + (dem11 + 1) + " là:"
            );
            System.out.println(
                    "Email: " + listAccount[dem11].email
            );
            System.out.println(
                    "Full name: " + listAccount[dem11].fullName
            );
            System.out.println(
                    "Phòng ban: "
                            + listAccount[dem11].department.departmentName
            );
            System.out.println("========================================");

        } while (true);
        System.out.println("\n========================================");
        System.out.println("DO-WHILE: Question 17.6");
        System.out.println("========================================");

        int dem12 = -1;

        do {
            dem12++;

            if (dem12 > 20) {
                break;
            }

            if (dem12 % 2 == 1) {
                continue;
            }

            System.out.println(dem12);

        } while (true);

//        Exercise 2: System out printf
//        Question 1:
//        Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//        nguyên đó
        System.out.println("\n========================================");
        System.out.println("Exercise 2: System out printf");
        System.out.println("DO-WHILE: Question 1");
        System.out.println("========================================");
        int soNguyen=5;
        System.out.printf("%d",soNguyen);
//        Question 2:
//        Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//        ra số nguyên đó thành định dạng như sau: 100,000,000
        int number = 100_000_000;

        System.out.printf(Locale.US, "%,d%n", number);
//        Question 3:
//        Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//        thực đó chỉ bao gồm 4 số đằng sau
        double soThuc = 5.567098;

        System.out.printf("%.4f%n", soThuc);
//        Question 4:
//        Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//        dạng như sau:
//        Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//        Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
        String fullName = "Nguyễn Văn A";

        System.out.printf(
                "Tên tôi là \"%s\" và tôi đang độc thân.%n", fullName);
//                Question 5:
//        Lấy thời gian bây giờ và in ra theo định dạng sau:
//        24/04/2020 11h:16p:20s
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH'h':mm'p':ss's'");

        String formattedDate = sdf.format(date);

        System.out.printf("%s%n", formattedDate);
//        Question 6:
//        In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//        table (giống trong Database)

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(
                "+-----+------------------------+---------------+"
                        + "----------------------+---------------+"
                        + "----------------+------------+"
        );

        System.out.printf(
                "| %-3s | %-22s | %-13s | %-20s | %-13s | %-14s | %-10s |%n",
                "ID",
                "Email",
                "Username",
                "Full name",
                "Department",
                "Position",
                "Create date"
        );

        System.out.println(
                "+-----+------------------------+---------------+"
                        + "----------------------+---------------+"
                        + "----------------+------------+"
        );

        for (Account account : listAccount) {
            String departmentName =
                    account.department == null
                            ? "Chưa có"
                            : account.department.departmentName;

            String positionName =
                    account.position == null
                            ? "Chưa có"
                            : account.position.positionName.toString();

            String createDate =
                    account.createDate == null
                            ? "Chưa có"
                            : dateFormat.format(account.createDate);

            System.out.printf(
                    "| %-3d | %-22s | %-13s | %-20s | %-13s | %-14s | %-10s |%n",
                    account.accountId,
                    account.email,
                    account.username,
                    account.fullName,
                    departmentName,
                    positionName,
                    createDate
            );
        }

        System.out.println(
                "+-----+------------------------+---------------+"
                        + "----------------------+---------------+"
                        + "----------------+------------+"
        );
//        Exercise 3: Date Format
//        Question 1:
//        In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//        dạng vietnamese
        Locale localeVN = new Locale("vi", "VN");

        DateFormat dateFormatVN =
                DateFormat.getDateInstance(
                        DateFormat.DEFAULT,
                        localeVN
                );

        String createDateVN =
                dateFormatVN.format(exam1.createDate);

        System.out.println("Thông tin Exam thứ 1:");
        System.out.println("ID: " + exam1.examId);
        System.out.println("Code: " + exam1.code);
        System.out.println("Title: " + exam1.title);
        System.out.println("Duration: " + exam1.duration + " phút");
        System.out.println("Create date: " + createDateVN);

//        Question 2:
//        In ra thông tin: Exam đã tạo ngày nào theo định dạng
//        Năm – tháng – ngày – giờ – phút – giây
        SimpleDateFormat question2Format =
                new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        String question2Date =
                question2Format.format(exam1.createDate);

        System.out.println(
                "Exam đã được tạo vào: " + question2Date
        );
//        Question 3:
//        Chỉ in ra năm của create date property trong Question 2
        SimpleDateFormat yearFormat =
                new SimpleDateFormat("yyyy");

        String year = yearFormat.format(exam1.createDate);

        System.out.println("Năm tạo Exam: " + year);
//        Question 4:
//        Chỉ in ra tháng và năm của create date property trong Question 2
        SimpleDateFormat monthYearFormat =
                new SimpleDateFormat("MM-yyyy");

        String monthYear =
                monthYearFormat.format(exam1.createDate);

        System.out.println("Tháng và năm tạo Exam: " + monthYear);
//        Question 5:
//        Chỉ in ra "MM-DD" của create date trong Question 2
        SimpleDateFormat monthDayFormat =
                new SimpleDateFormat("MM-dd");

        String monthDay =
                monthDayFormat.format(exam1.createDate);

        System.out.println("Tháng và ngày tạo Exam: " + monthDay);
//        Exercise 4: Random Number
//        Question 1:
//        In ngẫu nhiên ra 1 số nguyên
        Random random = new Random();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int randomInteger = random.nextInt();

        System.out.println(
                "Số nguyên ngẫu nhiên: " + randomInteger
        );
//        Question 2:
//        In ngẫu nhiên ra 1 số thực
        double randomDouble = random.nextDouble();

        System.out.println(
                "Số thực ngẫu nhiên: " + randomDouble
        );
//        Question 3:
//        Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
        String[] studentNames = {
                "Sáng",
                "An",
                "Bình",
                "Cường",
                "Dũng"
        };

        int randomIndex =
                random.nextInt(studentNames.length);

        System.out.println(
                "Bạn được chọn: " + studentNames[randomIndex]
        );
//        Question 4:
//        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
        LocalDate startDateQuestion4 =
                LocalDate.of(1995, 7, 24);

        LocalDate endDateQuestion4 =
                LocalDate.of(1995, 12, 20);

        LocalDate randomDateQuestion4 =
                getRandomDate(
                        startDateQuestion4,
                        endDateQuestion4,
                        random
                );

        System.out.println(
                "Ngày ngẫu nhiên từ 24-07-1995"
                        + " đến 20-12-1995: "
                        + randomDateQuestion4.format(formatter)
        );
//        Question 5:
//        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
        LocalDate today = LocalDate.now();
        LocalDate oneYearAgo = today.minusYears(1);

        LocalDate randomDateQuestion5 =
                getRandomDate(
                        oneYearAgo,
                        today,
                        random
                );

        System.out.println(
                "Ngày ngẫu nhiên trong một năm trở lại đây: "
                        + randomDateQuestion5.format(formatter)
        );


//        Question 6:
//        Lấy ngẫu nhiên 1 ngày trong quá khứ.
        LocalDate startPastDate =
                LocalDate.of(1970, 1, 1);

        LocalDate yesterday =
                LocalDate.now().minusDays(1);

        LocalDate randomDateQuestion6 =
                getRandomDate(
                        startPastDate,
                        yesterday,
                        random
                );

        System.out.println(
                "Ngày ngẫu nhiên trong quá khứ: "
                        + randomDateQuestion6.format(formatter)
        );
//        Question 7:
//        Lấy ngẫu nhiên 1 số có 3 chữ số.
        int randomThreeDigitNumber =
                random.nextInt(900) + 100;

        System.out.println(
                "Số ngẫu nhiên có 3 chữ số: "
                        + randomThreeDigitNumber
        );

//        Exercise 5: Input from console

//        Question 1:
//        Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình.

        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        System.out.println("Nhập số thứ nhất ");
        do{
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                scanner.nextLine();
                break;

            }
            System.out.println("Nhập số thứ nhất là số nguyên ");
            scanner.nextLine();}
        while (true);
        System.out.println("Nhập số thứ hai ");
        do{
            if (scanner.hasNextInt()) {
                b = scanner.nextInt();
                scanner.nextLine();
                break;

            }
            System.out.println("Nhập số thứ hai là số nguyên ");
            scanner.nextLine();}
        while (true);
        System.out.println("Nhập số thứ ba ");
        do{
            if (scanner.hasNextInt()) {
                c = scanner.nextInt();
                scanner.nextLine();
                break;

            }
            System.out.println("Nhập số thứ nhất là số nguyên ");
            scanner.nextLine();}
        while (true);

        System.out.println("3 số vừa nhập là :"+a+", "+b+", "+c);

//                Question 2:
//        Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình.
        float a2,b2;
        System.out.println("Nhập số thực thứ nhất ");
        do{
            if (scanner.hasNextFloat()) {
                a2 = scanner.nextFloat();
                scanner.nextLine();
                break;

            }
            System.out.println("Nhập số thứ nhất là số thực ");
            scanner.nextLine();}
        while (true);
        System.out.println("Nhập số thực thứ hai ");
        do{
            if (scanner.hasNextFloat()) {
                b2 = scanner.nextFloat();
                scanner.nextLine();
                break;

            }
            System.out.println("Nhập số thứ hai là số thực ");
            scanner.nextLine();}
        while (true);

        System.out.println("2 số vừa nhập là :"+a2+", "+b2);
//                Question 3:
//        Viết lệnh cho phép người dùng nhập họ và tên.
        String fullname;
        System.out.println("Nhập họ và tên");
        fullname = scanner.nextLine();
        System.out.println("Tên vừa nhập là :"+fullname);
//        Question 4:
//        Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ.
//
//
//                Question 5:
//        Viết lệnh cho phép người dùng tạo account (viết thành method)
//        Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//        chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM.
        Position listPosition[] = {position1,position2,position3};
        Account account=new Account();
        nhapAccount(listAccount,account,listDeparmet,listPosition);
        System.out.println(account.toString());

//                Question 6:
//        Viết lệnh cho phép người dùng tạo department (viết thành method)
//
//
//        Question 7:
//        Nhập số chẵn từ console
//
//
//        Question 8:
//        Viết chương trình thực hiện theo flow sau:
//        Bước 1:
//        Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
//        Bước 2:
//        Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//        Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
//                department
//        Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
//        lại" và quay trở lại bước 1
//        Question 9:
//        Viết method cho phép người dùng thêm group vào account theo flow sau:
//        Bước 1: In ra tên các usernames của user cho người dùng xem
//        Bước 2: Yêu cầu người dùng nhập vào username của account
//        Bước 3: In ra tên các group cho người dùng xem
//        Bước 4: Yêu cầu người dùng nhập vào tên của group
//        Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account        vào group đó .
//
//
//                Question 10: Tiếp tục Question 8 và Question 9
//        Bổ sung thêm vào bước 2 của Question 8 như sau:
//        Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
//                account
//        Bổ sung thêm Bước 3 của Question 8 như sau:
//        Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi   người dùng "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để kết thúc chương trình).
//
//
//        Question 11: Tiếp tục Question 10
//        Bổ sung thêm vào bước 2 của Question 8 như sau:
//        Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//        Bước 1: In ra tên các usernames của user cho người dùng xem
//        Bước 2: Yêu cầu người dùng nhập vào username của account
//        Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//        Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên
//
//
//        Exercise 6: Method
//        Question 1:
//        Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
//
//
//        Question 2:
//        Tạo method để in thông tin các account
//
//
//        Question 3:
//        Tạo method để in ra các số nguyên dương nhỏ hơn 10
//


    }
    public static LocalDate getRandomDate(
            LocalDate startDate,
            LocalDate endDate,
            Random random) {

        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();

        long numberOfDays =
                endDay - startDay + 1;

        long randomDay =
                startDay
                        + (long) (
                        random.nextDouble() * numberOfDays
                );

        return LocalDate.ofEpochDay(randomDay);
//
    }
    public static void nhapAccount(Account[] accounts,Account account,Department[] departments,Position[] positions) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin của account");
        account.accountId=accounts.length+1;
        System.out.println("========================");
        System.out.println("Nhập email: ");
        account.email=sc.nextLine();
        System.out.println("Nhập username: ");
        account.username=sc.nextLine();

        int checkDep;
        while (true) {
            System.out.println("Nhập id của department: ");
            if (!sc.hasNextInt()) {
                System.out.println("Nhập id của department phải là số nguyên : ");
                sc.nextLine();
                continue;
            }
            checkDep = sc.nextInt();
            sc.nextLine();
            Department foundDepartment =
                    findDepartmentById(departments, checkDep);
            if(foundDepartment==null) {
                System.out.println("ID của department chưa tồn tại : ");
                continue;
            }
            account.department=foundDepartment;
            break;
        }

        int option ;

        while (true){
            System.out.println("NHập postion: ");
            System.out.println("NHập 1 để chọn là: DEV: ");
            System.out.println("NHập 2 để chọn là: TEST: ");
            System.out.println("NHập 3 để chọn là: SCRUM_MASTER: ");
            System.out.println("NHập 4 để chọn là: PM: ");
            if(!sc.hasNextInt()){
                System.out.println("hãy nhập số nguyên và từ 1-4:");
                sc.nextLine();
                continue;
            }
            option = sc.nextInt();
            sc.nextLine();
            if(option<1 || option>4){
                System.out.println("hãy nhập số nguyên và từ 1-4:");

                continue;
            }
            PositionName positionName;
            switch (option){
                case 1: positionName=PositionName.DEV; break;
                case 2: positionName=PositionName.TEST; break;
                case 3 :positionName=PositionName.SCRUM_MASTER; break;
                case 4: positionName=PositionName.PM; break;
                default: continue;
            }
            Position position=findPositionByName(positions, positionName);
            if(position==null){
                System.out.println(
                        "Position này chưa tồn tại trong danh sách!"
                );

                continue;
            }
            account.position = position;
            break;
        }
        account.createDate = new Date();
        System.out.println("Tạo tài khoản thành công");
    }
    public static Department findDepartmentById(Department[] departments,int id) {
        Department dep = null;
        for (Department department : departments) {
            if (department.departmentId == id) {dep=department; break;}
        }
        return dep;
    }
    public static Position findPositionByName(Position[] positions,PositionName name) {
        Position po = null;
        for (Position position : positions) {
            if (position.positionName.equals(name)) {po=position; break;}
        }
        return po;
    }


}