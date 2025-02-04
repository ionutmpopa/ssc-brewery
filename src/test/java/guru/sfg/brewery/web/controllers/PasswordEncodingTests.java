package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jt on 6/16/20.
 */
public class PasswordEncodingTests {

    static final String PASSWORD = "password";
    static final String PASSWORD_TIGER = "tiger";
    static final String PASSWORD_GURU = "guru";

    @Test
    void testBcrypt() {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder(10);

        System.out.println(bcrypt.encode(PASSWORD));
        System.out.println(bcrypt.encode(PASSWORD_TIGER));

    }

    @Test
    void testSha256() {
        PasswordEncoder sha256 = new StandardPasswordEncoder();

        System.out.println(sha256.encode(PASSWORD));
        System.out.println(sha256.encode(PASSWORD));
        System.out.println(sha256.encode(PASSWORD_TIGER));
    }

    @Test
    void testLdap() {
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        System.out.println(ldap.encode(PASSWORD));
        System.out.println(ldap.encode(PASSWORD));

        String encodedPwd = ldap.encode(PASSWORD);
        String encodedGuruPwd = ldap.encode(PASSWORD_GURU);

        System.out.println(ldap.encode(PASSWORD_GURU));

        assertTrue(ldap.matches(PASSWORD, encodedPwd ));
        assertTrue(ldap.matches(PASSWORD_GURU, encodedGuruPwd ));

    }

    @Test
    void testNoOp() {
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();

        System.out.println(noOp.encode(PASSWORD));
    }

    @Test
    void hashingExample() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

        String salted = PASSWORD + "ThisIsMySALTVALUE";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));
    }
}
