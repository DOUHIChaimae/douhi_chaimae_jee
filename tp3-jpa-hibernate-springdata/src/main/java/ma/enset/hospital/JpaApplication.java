package ma.enset.hospital;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 100; i++) {
			patientRepository.save(new Patient(null, "douhi", new Date(), Math.random() < 0.5, (int) (Math.random() * 100)));
		}
		Page<Patient> patients = patientRepository.findAll(PageRequest.of(1, 5));
		System.out.println("total pages : " + patients.getTotalPages());
		System.out.println(patients.getTotalElements());
		System.out.println(patients.getNumber());
		List<Patient> content = patients.getContent();
		Page<Patient> bySickness = patientRepository.findByIsSick(true, PageRequest.of(0, 5));
		List<Patient> patientList =patientRepository.searchPatients("l%",200);
		patientList.forEach(
				p -> {
					System.out.println("======================================");
					System.out.println(p.getId());
					System.out.println(p.getName());
					System.out.println(p.getBirthday());
					System.out.println(p.getScore());
					System.out.println(p.getIsSick());
				}
		);
		System.out.println("***************************");
		Patient patient = patientRepository.findById(3L).orElse(null);
		if (patient != null) {
			System.out.println(patient.getName());
			System.out.println(patient.getBirthday());
			System.out.println(patient.getIsSick());
		}
		patient.setScore(8754);
		patientRepository.save(patient);
		//patientRepository.deleteById(1L);
	}
}