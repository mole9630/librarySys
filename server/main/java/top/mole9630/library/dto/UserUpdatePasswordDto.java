package top.mole9630.library.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdatePasswordDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
}
