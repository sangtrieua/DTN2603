package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.IDepartmentRepository;
import backend.repository.IPositionRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IAccountService;
import backend.service.ImportFileCSV;
import common.StringCommon;
import context.AccountContext;
import entity.Account;
import entity.Department;
import entity.Postion;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class AccountServiceImpl implements IAccountService, ImportFileCSV<Account, AccountContext> {
    IAccountRepository accountRepository;
    IDepartmentRepository departmentRepository;
    IPositionRepository positionRepository;
    public AccountServiceImpl() {
        accountRepository = new AccountRepositoryImpl();
        departmentRepository = new DepartmentRepositoryImpl();
        positionRepository = new PositionRepositoryImpl();
    }

    @Override
    public List<Account> getAccountS() {
        return accountRepository.getAccounts();
    }

    @Override
    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        return accountRepository.kiemTraTonTaiAccountId(accountId);
    }

    @Override
    public boolean suaUsernameTheoId(Integer accountId, String userName) {
        return accountRepository.suaUsernameTheoId(accountId,userName);
    }

    @Override
    public boolean xoaAccountTheoId(Integer accountId) {
        return accountRepository.xoaAccountTheoId(accountId);
    }



    @Override
    public boolean themAccount(Account account) {
        return accountRepository.themAccount(account);
    }

    @Override
    public boolean checkTonTaiEmail(String email) {
        return accountRepository.checkTonTaiEmail(email);
    }

    @Override
    public boolean checkTonTaiUserNameThem(String userName) {
        return accountRepository.checkTonTaiUserNameThem(userName);
    }

    @Override
    public boolean checkTonTaiUserNameSua(Integer accountId, String userName) {
        return accountRepository.checkTonTaiUserNameSua(accountId,userName);
    }

    @Override
    public String importCSV(String url) {

        List<Account> accounts=accountRepository.getAccounts();
        List<Department> departments=departmentRepository.getDepartments();
        List<Postion> postions=positionRepository.getPostions();
        Set<String> setUserName=accounts.stream().map(Account::getUserName).collect(Collectors.toSet());
        Set<String> setEmail=accounts.stream().map(Account::getEmail).collect(Collectors.toSet());
        Map<Integer,Department> mapByDepartmentId=departments.stream().collect(Collectors.toMap(department->
                department.getDepartmentId(),department->department));
        Map<Integer,Postion> mapByPostionId=postions.stream().collect(Collectors.toMap(postion->
                postion.getPostionId(),postion->postion));

        AccountContext accountContext=new AccountContext(setUserName,setEmail,mapByDepartmentId,mapByPostionId);
        String pathErrorsFile="D:\\FITHOU_23\\VTI Academy\\java_core\\csv\\input_account_error.csv";
        return this.importCSV(url,accountContext,pathErrorsFile);
    }



    @Override
    public void validation(String line, List<Account> entities, List<String> listErrors, AccountContext context) {
        List<String> genders= Arrays.asList("nam","nữ","chưa xác định");
        String[] values=line.split(",");
        List<String> errors=new ArrayList<>();// list lỗi của dòg này

        String email=values[0];
        if(email.length()<6 || email.length()>100) {
            errors.add("Email có độ dài từ 6 đến 100 kí tự");
        }else if (!email.matches(StringCommon.EMAIL_REGEX)) {
            errors.add("Email sai định dạng");
        }
        else {
            if(context.getSetEmail().contains(email)) {
                errors.add("Email đã tồn tại");
            }
        }
        String userName=values[1];
        if(userName.length()<6 || userName.length()>100) {
            errors.add("Username có độ dài từ 6 đến 100 kí tự");
        }
        else {
            if(context.getSetUsername().contains(userName))  {
                errors.add("Username đã tồn tại");
            }
        }
        String fullName=values[2];
        if(fullName.length()<6 || fullName.length()>100) {
            errors.add("FullName có độ dài từ 6 đến 100 kí tự");
        }
        int departmentId=0;
        Department department=new  Department();
        if(!values[3].matches(StringCommon.NUMBER_REGEX)) {
            errors.add("departmentId phải là số");
        }
        else {
            departmentId=Integer.parseInt(values[3]);
            if (departmentId <= 0 ) {
                errors.add("departmentId phải là số >0");
            }
        }
        if(!context.getMapByDepartmentId().containsKey(departmentId)) {
            errors.add("departmentId không tồn tại");
        }
        else {
            department=context.getMapByDepartmentId().get(departmentId);
        }

        int positionId =0;
        Postion postion=new Postion();
        if(!values[4].matches(StringCommon.NUMBER_REGEX)) {
            errors.add("postiontId phải là số");
        }
        else {
            positionId =Integer.parseInt(values[4]);
            if (positionId <= 0 ) {
                errors.add("postiontId phải là số >0");
            }
        }
        if(!context.getMapByPostionId().containsKey(positionId)) {
            errors.add("positionId không tồn tại");
        }
        else {
            postion=context.getMapByPostionId().get(positionId);
        }
        String gender=values[5];
        if(!genders.contains(gender)) {
            errors.add("Gender chỉ có 3 giá trị : nam , nữ, không xác định");
        }
        if (errors.isEmpty()) {
            Account account=new Account(email,userName,fullName,department,postion,gender);
            context.getSetEmail().add(email);
            context.getSetUsername().add(userName);
            context.getMapByDepartmentId().put(departmentId,department);
            context.getMapByPostionId().put(positionId,postion);
            entities.add(account);
        }
        else {
            String error=String.join(" - ",errors);
            line=line+", "+error;
            listErrors.add(line);
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
    accountRepository.themListAccount(entities);
    }

    @Override
    public void exportErrors(String header, List<String> listErrors, String pathErrorFile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathErrorFile));
            bw.write(header + "error_message");
            bw.newLine();
            for (String error : listErrors) {
                bw.write(error);
                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
