package ma.enset.tp4patientsmvc;

import ma.enset.tp4patientsmvc.entities.Patient;
import ma.enset.tp4patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Tp4PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp4PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "douhi", new Date(), false, 1109));
            patientRepository.save(new Patient(null, "toto", new Date(), true, 4000));
            patientRepository.save(new Patient(null, "fifi", new Date(), false, 1996));
            patientRepository.save(new Patient(null, "lolo", new Date(), true, 190));
            patientRepository.save(new Patient(null, "nono", new Date(), false, 911));
			patientRepository.findAll().forEach(
                patient -> System.out.println(patient.getName())
            );

        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

