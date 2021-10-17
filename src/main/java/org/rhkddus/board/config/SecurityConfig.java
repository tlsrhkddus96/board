package org.rhkddus.board.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //사용자 계정 user1
        auth.inMemoryAuthentication().withUser("user1")
                //1111 패스워드 인코딩 결과
                .password("$2a$10$qHukhp1k2.Ahq457DVXonOhLdLW1S/iE3lcpPVixpYep3MkIt0sbm")
                .roles("USER");

    }




}
