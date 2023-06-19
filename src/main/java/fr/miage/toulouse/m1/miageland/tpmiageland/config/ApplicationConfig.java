package fr.miage.toulouse.m1.miageland.tpmiageland.config;

import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PersonneRepository personneRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> personneRepository.findByAdresseMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}
