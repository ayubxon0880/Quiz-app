package uz.friendchallange.friendchallange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(c->c.disable())
                .authorizeHttpRequests(
                        (request) ->
                                request
                                        .requestMatchers(HttpMethod.POST, "/account")
                                        .permitAll()
                                        .requestMatchers(
                                                "/profile",
                                                "/question"
                                        ).authenticated()
                                        .anyRequest()
                                        .permitAll()
                );

        System.out.println("login");
        http.formLogin(Customizer.withDefaults());
        http.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/"));
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
