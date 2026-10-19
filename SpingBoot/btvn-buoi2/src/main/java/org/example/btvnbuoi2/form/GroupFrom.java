package org.example.btvnbuoi2.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupFrom {
    @NotBlank
    @Length(min=6, max=100,message = "name phải có từ 6 đến 100 kí tự")
    private String name;

    @NotBlank
    @Length(min=6, max=100,message = "accountCreatorUserName phải có từ 6 đến 100 kí tự")
    private String accountCreatorUserName;

}
