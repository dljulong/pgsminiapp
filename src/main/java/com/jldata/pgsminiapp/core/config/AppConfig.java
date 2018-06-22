package com.jldata.pgsminiapp.core.config;


import com.jldata.pgsminiapp.core.bcrypt.BCryptPasswordEncoder;
import com.jldata.pgsminiapp.core.bcrypt.PasswordEncoder;
import com.jldata.pgsminiapp.core.exception.ExceptionHandle;
import com.jldata.pgsminiapp.core.jdbc.JdbcPageKit;
import com.jldata.pgsminiapp.core.jwt.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Administrator on 2018/4/23/023.
 */
@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JdbcPageKit jdbcPageKit(){
        return new JdbcPageKit();
    }
    @Bean
    public JwtTokenUtil jwtTokenUtil(){
        return new JwtTokenUtil();
    }

    @Bean
    ExceptionHandle exceptionHandle() {
        return new ExceptionHandle();
    }
}
