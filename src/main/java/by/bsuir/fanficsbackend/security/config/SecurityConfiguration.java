package by.bsuir.fanficsbackend.security.config;

import by.bsuir.fanficsbackend.security.Permission;
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
                .antMatchers(HttpMethod.OPTIONS,"/login").permitAll()
                .antMatchers(HttpMethod.GET,"/login").permitAll()
                .antMatchers(HttpMethod.GET,"/tags").permitAll()
                .antMatchers(HttpMethod.GET,"/tags/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/categories").permitAll()
                .antMatchers(HttpMethod.GET,"/categories/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/fandoms").permitAll()
                .antMatchers(HttpMethod.GET,"/fandoms/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/genres").permitAll()
                .antMatchers(HttpMethod.GET,"/genres/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .antMatchers(HttpMethod.POST, "/books").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.PATCH, "/books").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.PATCH, "/books/{id}").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.OPTIONS, "/books").permitAll()
                .antMatchers(HttpMethod.GET, "/books/recent").permitAll()
                .antMatchers(HttpMethod.GET, "/books/search").permitAll()
                .antMatchers(HttpMethod.GET, "/books/{id}").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/books/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/books/{id}").hasAuthority(DELETE.getPermission())
                .antMatchers(HttpMethod.POST, "book/{id}/like").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.POST, "book/{id}/dislike").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.OPTIONS, "book/{id}/like").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "book/{id}/dislike").permitAll()

                .antMatchers(HttpMethod.GET, "/comments").permitAll()
                .antMatchers(HttpMethod.POST, "/comments").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.OPTIONS, "/comments").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/book/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/{id}").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/comments/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/comments/{id}").hasAuthority(DELETE.getPermission())

                .antMatchers(HttpMethod.GET, "/chapters").permitAll()
                .antMatchers(HttpMethod.POST, "/chapters").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.PATCH, "/chapters").hasAuthority(READ.getPermission())
                .antMatchers(HttpMethod.OPTIONS, "/chapters").permitAll()
                .antMatchers(HttpMethod.GET, "/chapters/book/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/chapters/{id}").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/chapters/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/chapters/{id}").hasAuthority(DELETE.getPermission())

                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/{id}").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users/{id}").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/users/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users/{id}").hasAuthority(DELETE.getPermission())
                .antMatchers(HttpMethod.OPTIONS, "/users/{id}/block").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/users/{id}/unlock").permitAll()
                .antMatchers(HttpMethod.POST, "/users/{id}/block").hasAuthority(WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/users/{id}/unlock").hasAuthority(WRITE.getPermission())

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
