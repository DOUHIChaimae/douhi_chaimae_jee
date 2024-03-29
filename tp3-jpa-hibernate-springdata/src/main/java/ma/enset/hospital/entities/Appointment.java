package ma.enset.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @OneToOne(mappedBy = "appointment")
    private Consultation consultation;
}
