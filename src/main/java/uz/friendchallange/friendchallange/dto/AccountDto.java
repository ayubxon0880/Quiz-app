package uz.friendchallange.friendchallange.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;
}
