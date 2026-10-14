package org.example.btvnbuoi2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupAccountForm {
    private String groupName;
    private String accountUserName;
    public void checkNull(){
        if (this.groupName == null  || groupName.isBlank()){
            throw new RuntimeException("Không để trống groupName");
        }
        if (this.accountUserName == null  || accountUserName.isBlank()){
            throw new RuntimeException("Không để trống accountUserName");
        }

    }
}
