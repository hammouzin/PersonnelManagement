package net.javaguides.personnalmanagement.Controllers;

import lombok.AllArgsConstructor;
import net.javaguides.personnalmanagement.Dtos.User.UserLoginRequest;
import net.javaguides.personnalmanagement.Services.User.AccountServiceimpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
@AllArgsConstructor
public class SecurityController {
    private AuthenticationManager authenticationManager;
    private JwtEncoder jwtEncoder;
    private AccountServiceimpl accountService;
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public Map<String , String> login(@RequestBody UserLoginRequest userLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequest.email() , userLoginRequest.password())
        );

        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER");


        Instant instant = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(10 , ChronoUnit.MINUTES))
                .subject(userLoginRequest.email())
                .claim("scope" , role)
                .build();
        System.out.println(role);

        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS256).build(),
                jwtClaimsSet
        );

        System.out.println("Email: " + userLoginRequest.email());
        System.out.println("Password: " + userLoginRequest.password());
        System.out.println("Role: " + role);

        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();

        return Map.of("access_token", jwt , "role" , role);

    }




}
