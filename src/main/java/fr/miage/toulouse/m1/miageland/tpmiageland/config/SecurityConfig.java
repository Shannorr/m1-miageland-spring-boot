package fr.miage.toulouse.m1.miageland.tpmiageland.config;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthentificationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**",
                        "/api/attractions/ouverte",
                        "/api/attractions/ferme")
                .permitAll()

                .requestMatchers("/api/v1/demo-controller").hasAnyAuthority("USER", "GERANT")

                // Autoriser que par le gerant
                .requestMatchers(POST, "/api/v1/gerant/employes").hasAuthority( "GERANT")
                .requestMatchers(DELETE, "/api/v1/gerant/employes/**").hasAuthority( "GERANT")
                .requestMatchers( "/api/parcs/**").hasAuthority( "GERANT")
                .requestMatchers( "/api/attractions/**").hasAuthority( "GERANT")
                .requestMatchers(DELETE,"/api/billets/**").hasAuthority( "GERANT")
                .requestMatchers(POST,"/api/billets/**").hasAuthority( "GERANT")

                // VISITEUR ET GERANT
                .requestMatchers(DELETE, "/api/visiteur/**").hasAnyAuthority("VISITEUR", "GERANT")

                // VISITEUR ET GERANT ET EMPLOYE
                .requestMatchers(GET, "/api/billets/**").hasAnyAuthority("VISITEUR", "GERANT", "EMPLOYE")

                // EMPLOYE
                .requestMatchers(GET, "/api/employes/**").hasAnyAuthority("GERANT", "EMPLOYE")

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}