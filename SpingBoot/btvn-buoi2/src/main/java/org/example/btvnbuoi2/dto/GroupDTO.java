package org.example.btvnbuoi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.btvnbuoi2.entity.Account;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {
    private Integer id;
    private String name;
    private String accountUserName;
    private Date createDate;
}
