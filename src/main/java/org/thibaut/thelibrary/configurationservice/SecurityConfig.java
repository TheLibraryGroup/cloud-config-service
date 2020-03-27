package org.thibaut.thelibrary.configurationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	public void configure( AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.passwordEncoder( NoOpPasswordEncoder.getInstance())
//				.withUser("admin").password("admin")
//				.authorities("ADMIN");
//	}

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
		        .passwordEncoder( NoOpPasswordEncoder.getInstance())
		        .withUser("confUser")
		        .password("confPassword")
		        .roles("SYSTEM");
    }

    @Override
    protected void configure( HttpSecurity http) throws Exception {
        http
		        .authorizeRequests().anyRequest().hasRole("SYSTEM").and()
		        .httpBasic().and()
		        .csrf().disable();
    }
}
