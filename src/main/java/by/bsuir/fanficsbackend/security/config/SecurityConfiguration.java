package by.bsuir.fanficsbackend.security.config;

import by.bsuir.fanficsbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .csrf().disable()
//                .authorizeRequests()
//
//                .antMatchers("/auth/login").permitAll()
//                .antMatchers("/auth/refresh").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/tags/{id}").hasAuthority(READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/tags").hasAuthority(WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/tags/{id}").hasAuthority(DELETE.getPermission())
//
//                .antMatchers(HttpMethod.GET, "/certificates/{id}").hasAuthority(READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/certificates").hasAuthority(WRITE.getPermission())
//                .antMatchers(HttpMethod.PATCH, "/certificates/{id}").hasAuthority(UPDATE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/certificates/{id}").hasAuthority(DELETE.getPermission())
//
//                .antMatchers(HttpMethod.GET, "/info/{userId}").hasAuthority(READ.getPermission())
//
//                .antMatchers(HttpMethod.GET, "/orders/{id}").hasAuthority(READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/orders").hasAuthority(WRITE.getPermission())
//
//                .antMatchers(HttpMethod.GET, "users/{id}").hasAuthority(READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/users").permitAll()
//
//                .anyRequest()
//                .authenticated()
//                .and().apply(jwtConfig);
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
