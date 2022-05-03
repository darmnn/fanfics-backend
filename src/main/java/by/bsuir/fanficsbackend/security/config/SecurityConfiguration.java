package by.bsuir.fanficsbackend.security.config;

import by.bsuir.fanficsbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static by.bsuir.fanficsbackend.security.Permission.*;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private JwtConfiguration jwtConfig;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.GET,"/tags").permitAll()
                .antMatchers(HttpMethod.GET,"/tags/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/categories").permitAll()
                .antMatchers(HttpMethod.GET,"/categories/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/fandoms").permitAll()
                .antMatchers(HttpMethod.GET,"/fandoms/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/genres").permitAll()
                .antMatchers(HttpMethod.GET,"/genres/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .antMatchers(HttpMethod.GET, "/books/recent").permitAll()
                .antMatchers(HttpMethod.GET, "/books/search").permitAll()
                .antMatchers(HttpMethod.GET, "/books/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/comments").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/book/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/chapters").permitAll()
                .antMatchers(HttpMethod.GET, "/chapters/book/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/chapters/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/{id}").permitAll()

                .anyRequest()
                .authenticated()
                .and().apply(jwtConfig);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
