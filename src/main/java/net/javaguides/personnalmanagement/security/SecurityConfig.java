package net.javaguides.personnalmanagement.security;

import net.javaguides.personnalmanagement.Services.MyAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final MyAgentService agentService;

    public SecurityConfig(MyAgentService agentService) {
        this.agentService = agentService;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return agentService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(agentService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                    httpForm.successHandler((request, response, authentication) -> {
                        String role = authentication.getAuthorities().iterator().next().getAuthority();
                        if (role.equals("ROLE_DCP")) {
                            response.sendRedirect("/DCP/dashboard");
                        } else if (role.equals("ROLE_SCF")) {
                            response.sendRedirect("/SCF/dashboard");
                        } else if (role.equals("ROLE_EMPLOYE_AR")) {
                            response.sendRedirect("/employeAR/home");
                        } else if (role.equals("ROLE_AGENT")) {
                            response.sendRedirect("/agents/home");
                        } else if (role.equals("ROLE_RESPONSABLE_UNITE")) {
                            response.sendRedirect("/responsableUnite/dashboard");
                        } else {
                            response.sendRedirect("/login?error=role_not_supported");
                        }
                    });
                })
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/login", "/req/login", "/css/**", "/js/**", "/default").permitAll()
                        .requestMatchers("/DCP/**").hasRole("DCP")
                        .requestMatchers("/SCF/**").hasRole("SCF")
                        .requestMatchers("/employeAR/**").hasRole("EMPLOYE_AR")
                        .requestMatchers("/agents/**").hasRole("AGENT")
                        .requestMatchers("/responsableUnite/**").hasRole("RESPONSABLE_UNITE")
                        .anyRequest().authenticated()
                )
                .logout(httpLogout -> {
                    httpLogout.logoutUrl("/logout");
                    httpLogout.logoutSuccessUrl("/login?logout");
                    httpLogout.permitAll();
                })
                .build();
    }



}