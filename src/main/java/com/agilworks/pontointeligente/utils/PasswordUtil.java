package com.agilworks.pontointeligente.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final Logger log = LoggerFactory.getLogger(PasswordUtil.class);

    public PasswordUtil() {}

    /**
     * Gera um hash utilizando o BCrypt.
     *
     * @param senha
     * @return String
     */
    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }

        log.info("Gerando hash com bcrypt");

        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

        return senha;
    }
}
