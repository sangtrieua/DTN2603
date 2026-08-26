import java.security.spec.RSAOtherPrimeInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

//        // ==================== QUESTION 3 ====================
//        System.out.println("===== DEPARTMENT =====");
//        System.out.println(department1.departmentName);
//        System.out.println(department2.departmentName);
//        System.out.println(department3.departmentName);
//
//        System.out.println("\n===== POSITION =====");
//        System.out.println(position1.positionName);
//        System.out.println(position2.positionName);
//        System.out.println(position3.positionName);
//
//        System.out.println("\n===== ACCOUNT =====");
//        System.out.println(account1.fullName);
//        System.out.println(account2.fullName);
//        System.out.println(account3.fullName);
//
//        System.out.println("\n===== GROUP =====");
//        System.out.println(group1.groupName);
//        System.out.println(group2.groupName);
//        System.out.println(group3.groupName);
//
//        System.out.println("\n===== GROUP ACCOUNT =====");
//        System.out.println(groupAccount1.account.fullName + " - " + groupAccount1.group.groupName);
//        System.out.println(groupAccount2.account.fullName + " - " + groupAccount2.group.groupName);
//        System.out.println(groupAccount3.account.fullName + " - " + groupAccount3.group.groupName);
//
//        System.out.println("\n===== TYPE QUESTION =====");
//        System.out.println(typeQuestion1.typeName);
//        System.out.println(typeQuestion2.typeName);
//        System.out.println(typeQuestion3.typeName);
//
//        System.out.println("\n===== CATEGORY QUESTION =====");
//        System.out.println(category1.categoryName);
//        System.out.println(category2.categoryName);
//        System.out.println(category3.categoryName);
//
//        System.out.println("\n===== QUESTION =====");
//        System.out.println(question1.content);
//        System.out.println(question2.content);
//        System.out.println(question3.content);
//
//        System.out.println("\n===== ANSWER =====");
//        System.out.println(answer1.content + " - " + answer1.isCorrect);
//        System.out.println(answer2.content + " - " + answer2.isCorrect);
//        System.out.println(answer3.content + " - " + answer3.isCorrect);
//
//        System.out.println("\n===== EXAM =====");
//        System.out.println(exam1.title + " - " + exam1.duration + " phut");
//        System.out.println(exam2.title + " - " + exam2.duration + " phut");
//        System.out.println(exam3.title + " - " + exam3.duration + " phut");
//
//        System.out.println("\n===== EXAM QUESTION =====");
//        System.out.println(examQuestion1.exam.code + " - " + examQuestion1.question.content);
//        System.out.println(examQuestion2.exam.code + " - " + examQuestion2.question.content);
//        System.out.println(examQuestion3.exam.code + " - " + examQuestion3.question.content);

        BTVN_Buoi3 btvnBuoi3 = new BTVN_Buoi3();
        System.out.println("Thương 2 số là: "+btvnBuoi3.exercise1Question4() );

    }


}