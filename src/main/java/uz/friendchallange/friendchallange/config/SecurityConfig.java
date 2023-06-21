package uz.friendchallange.friendchallange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        (request) ->
                                request
                                        .requestMatchers(HttpMethod.POST, "/account")
                                        .permitAll()
                                        .requestMatchers("/register")
                                        .permitAll()

                                        .requestMatchers(
                                                "/profile",
                                                "/question/**",
                                                "/create"
                                        ).authenticated()
                                        .anyRequest()
                                        .authenticated()
                );
        http.formLogin(form -> {
            form.loginPage("/login")
                    .defaultSuccessUrl("/profile")
                    .permitAll();
        });
        http.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/"));
        http.httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
