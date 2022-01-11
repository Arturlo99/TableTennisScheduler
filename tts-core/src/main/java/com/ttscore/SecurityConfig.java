package com.ttscore;

import com.ttscore.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
        daoAuth.setUserDetailsService(userDetailsServiceImpl);
        daoAuth.setPasswordEncoder(passwordEncoder());

        auth.authenticationProvider(daoAuth);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/tournaments/all").permitAll()
                .antMatchers("/tournaments/details/*").permitAll()
                .antMatchers("/tournaments/enroll").permitAll()
                .antMatchers("/create-event").hasRole("ADMIN")
                .antMatchers("/delete-event/*").hasRole("ADMIN")
                .antMatchers("/generate-tournament-matches").hasRole("ADMIN")
                .antMatchers("/update-match").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().cors().and().csrf().disable();
    }
}
