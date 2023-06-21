package fr.miage.toulouse.m1.miageland.tpmiageland;

import fr.miage.toulouse.m1.miageland.tpmiageland.auth.AuthenticationService;
import fr.miage.toulouse.m1.miageland.tpmiageland.auth.RegisterRequest;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpMiagelandApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpMiagelandApplication.class, args);
	}


	/**
	 * Créer le gerant pour le premier lancement
	 *
	 */
//		@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	) {
//		return args -> {
//			var gerant = RegisterRequest.builder()
//					.nom("gerant")
//					.prenom("gerant")
//					.adresseMail("gerant@mail.com")
//					.password("gerant")
//					.role(Role.GERANT)
//					.build();
//			System.out.println("Admin token: " + service.register(gerant).getToken());
//
//		};
//	}
}
