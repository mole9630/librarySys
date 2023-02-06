package top.mole9630.library.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class UserGenerateMD5PasswordTest {
    @Test
    public void generateEncryptedPasswordTest() {
        String password = "123321";
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
    }
}
