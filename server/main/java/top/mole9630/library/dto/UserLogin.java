package top.mole9630.library.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    private String phone;
    private String password;
    private String phoneCAPTCHA;
}
