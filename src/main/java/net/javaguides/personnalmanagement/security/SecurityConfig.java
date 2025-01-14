package net.javaguides.personnalmanagement.security;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import net.javaguides.personnalmanagement.Services.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    private String secretKey ;

   private UserDetailsServiceImpl userDetailsService;

   @Autowired
   public SecurityConfig(@Value("${jwt.secret}") String secretKey , UserDetailsServiceImpl userDetailsService) {
       this.secretKey = secretKey;
       this.userDetailsService = userDetailsService;

   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers("/login").permitAll()
                       /*.requestMatchers("/Mediatheque/Document/**").permitAll() // Autoriser l'accès sans authentification
                       .requestMatchers("/Mediatheque/abo/**").permitAll()
                       .requestMatchers("/api/microfilms/**").permitAll()
                       .requestMatchers("/Journal/**").permitAll()
                       .requestMatchers("/api/emprunts/**").permitAll()
                       .requestMatchers("/dashboard-admin/**").hasRole("ADMIN")
                       .requestMatchers("/dashboard-lecteur/**").hasRole("LECTEUR")
                       .requestMatchers("/dashboard-employe/**").hasRole("EMPLOYEE")
                       .requestMatchers("/livre/**").permitAll()*/
                       .requestMatchers("/auth/**").authenticated()
                       .anyRequest().denyAll()
               )
               .oauth2ResourceServer(oa -> oa.jwt(Customizer.withDefaults()))
               .build();
   }

    @Bean
    public JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA512");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }

}



