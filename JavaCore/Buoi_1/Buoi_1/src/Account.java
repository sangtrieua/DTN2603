import java.util.Date;

public class Account {
    int accountId;
    String email;
    String username;
    String fullName;
    Date createDate;
    Department department;
    Position position;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                ", department=" + department.toString() +
                ", position=" + position.toString() +
                '}';
    }
}
