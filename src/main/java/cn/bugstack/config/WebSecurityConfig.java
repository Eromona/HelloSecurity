package cn.bugstack.config;

import cn.bugstack.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize.anyRequest().authenticated())
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    //基于数据库的用户验证
    //@Bean
    public UserDetailsService dbUserDetailsService() {
        return new CustomUserDetailsService();
    }

    //基于内存的
    @Bean
    public UserDetailsService inMemoryDetailService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(new User("test", passwordEncoder.encode("123456"), new ArrayList<>()));
        return manager;
    }

}
