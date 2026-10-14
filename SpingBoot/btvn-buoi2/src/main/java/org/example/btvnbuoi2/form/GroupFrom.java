package org.example.btvnbuoi2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupFrom {
    private String name;
    private String accountCreatorUserName;
    public void checkNull(){
        if (this.name == null  || name.isBlank()){
            throw new RuntimeException("Không để trống groupName");
        }
        if (this.accountCreatorUserName == null || accountCreatorUserName.isBlank()){
            throw new RuntimeException("Không để trống accountCreatorUserName");
        }

    }
}
