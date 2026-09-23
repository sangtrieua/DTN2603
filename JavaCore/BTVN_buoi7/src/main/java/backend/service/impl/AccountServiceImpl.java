package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.IDepartmentRepository;
import backend.repository.IPositionRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IAccountService;
import common.StringCommon;
import entity.Account;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements IAccountService {
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

        File file = new File(url);
        if (!file.exists()) {
            return "File không tồn tại!!";
        }
        List<Account> accounts=new ArrayList<>();

        List<String> listErrors=new ArrayList<>();
        String header="";
        try(BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            header=br.readLine();
            while ((line = br.readLine()) != null) {
                String message =this.validationAccount(line,accounts);
                if(Objects.nonNull(message)){
                    listErrors.add(message);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

//        for (Account account : accounts) {
//            accountRepository.themAccount(account);
//
//        }
        boolean b=accountRepository.themListAccount(accounts);

        if(!listErrors.isEmpty()){
            try {


            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\FITHOU_23\\VTI Academy\\java_core\\csv\\input_account_error.csv"));
            bw.write(header+", error_message");
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
        return listErrors.isEmpty() ? "Import thành công" : "Đã xuất ra file lỗi input_account_error.csv";
    }

    private String validationAccount(String line, List<Account> accounts) {
        List<String> genders= Arrays.asList("nam","nữ","chưa xác định");
        String[] values=line.split(",");
        List<String> errors=new ArrayList<>();

        String email=values[0];
        if(email.length()<6 || email.length()>100) {
            errors.add("Email có độ dài từ 6 đến 100 kí tự");
        }else if (!email.matches(StringCommon.EMAIL_REGEX)) {
            errors.add("Email sai định dạng");
        }
        else {
            if(this.checkTonTaiEmail(email)) {
                errors.add("Email đã tồn tại");
            }
        }
        String userName=values[1];
        if(userName.length()<6 || userName.length()>100) {
            errors.add("Username có độ dài từ 6 đến 100 kí tự");
        }
        else {
            if(this.checkTonTaiUserNameThem(userName)) {
                errors.add("Username đã tồn tại");
            }
        }
        String fullName=values[2];
        if(fullName.length()<6 || fullName.length()>100) {
            errors.add("FullName có độ dài từ 6 đến 100 kí tự");
        }
        int departmentId=0;
        if(!values[3].matches(StringCommon.NUMBER_REGEX)) {
            errors.add("departmentId phải là số");
        }
        else {
            departmentId=Integer.parseInt(values[3]);
        }
        if(!this.departmentRepository.kiemTraTonTaiDepartmentId(departmentId)) {
            errors.add("departmentId không tồn tại");
            if (departmentId <= 0 ) {
                errors.add("departmentId phải là số >0");
            }
        }
        int positionId =0;
        if(!values[4].matches(StringCommon.NUMBER_REGEX)) {
            errors.add("postiontId phải là số");
        }
        else {
            positionId =Integer.parseInt(values[4]);
            if (positionId <= 0 ) {
                errors.add("postiontId phải là số >0");
            }
        }
        if(!this.positionRepository.kiemTraTonTaiPostionId(positionId)) {
            errors.add("positionId không tồn tại");
        }
        String gender=values[5];
        if(!genders.contains(gender)) {
            errors.add("Gender chỉ có 3 giá trị : nam , nữ, không xác định");
        }
        if (errors.isEmpty()) {
            Account account=new Account(email,userName,fullName,departmentId,positionId,gender);
            accounts.add(account);
            return null;
        }
        else {
            String error=String.join(" - ",errors);
            line=line+", "+error;
        }
        return line;
    }
}
