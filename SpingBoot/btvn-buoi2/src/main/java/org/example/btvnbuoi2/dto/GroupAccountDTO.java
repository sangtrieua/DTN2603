package org.example.btvnbuoi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.btvnbuoi2.entity.Account;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupAccountDTO {
    private String groupName;
    private String accountUserName;
}
