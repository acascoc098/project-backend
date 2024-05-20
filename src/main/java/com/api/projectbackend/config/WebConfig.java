package com.api.projectbackend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebConfig {
    @Autowired 
    DataSource dataSource;
    
    @Autowired
    public void configure(AuthenticationManagerBuilder amb) throws Exception {
      amb.jdbcAuthentication()
          .dataSource(dataSource)
          .usersByUsernameQuery("select username, password "+
              "from usuario where username = ?")
          .authoritiesByUsernameQuery("select u.username as 'authority' "+
              "from usuario u " +
              "where username = ?");
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }

    @Bean
      public SecurityFilterChain filter(HttpSecurity http) throws Exception {

              return http
                      .authorizeHttpRequests((requests) -> requests
                              //.requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/login", "/denegado")
                              .requestMatchers("barteca/**","/usuario/**", "/bar/**", "/reserva/**").permitAll()
                              //.authenticated()
                      ).exceptionHandling((exception)-> exception.
                              accessDeniedPage("/denegado") )
                      .formLogin((formLogin) -> formLogin
                              //.loginPage("/login")
                              .permitAll()
                      ).rememberMe(
                              Customizer.withDefaults()
                      ).logout((logout) -> logout
                              .invalidateHttpSession(true)
                              .logoutSuccessUrl("/")
                              // .deleteCookies("JSESSIONID") // no es necesario, JSESSIONID se hace por defecto
                              .permitAll()                                
                      ).csrf((protection) -> protection
                               .disable()
                      ).cors((protection)-> protection
                                .disable()
                      ).build();

      }

}
