package com.sdi.demoresource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(
                j -> j.jwt().jwkSetUri("http://localhost:8080/oauth2/jwks")
        ).authorizeHttpRequests()
                .anyRequest().authenticated()
                .and().build();
    }

}

// http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://127.0.0.1:3000/authorized&code_challenge=35gU2j6YepLP7kEQJmJaAq-DJo8uToJ97nEdVtvGO7E&code_challenge_method=S256
// http://localhost:8080/oauth2/token?client_id=client&redirect_uri=http://localhost:3000/authorized&grant_type=authorization_code&code=veamlgrk9aeesjjIimgFUCMXvoCGcjQLIeI_i-3F8s5lAzCwbvMwj92km8TsrgXQ-GZWyvuqb9l_0Epc1_KD7-HcqYDmEGvedQMlgKom83o3uguQqFBg1iyZGVs6scbR&code_verifier=QYPAZ5NU8qvtlQerXrUYR-T5AGCjCF47vN-KsaI2A8
// antes del hash: QYPAZ5NU8qvtlQerXrUYR-T5AGCjCF47vN-KsaI2A8
// luego del hash: 35gU2j6YepLP7kEQJmJaAq-DJo8uToJ97nEdVtvGO7E

