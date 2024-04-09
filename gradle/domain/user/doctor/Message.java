package ee.valiit.ravimivalvurback.domain.user.doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "message", schema = "ravim")
public class Message {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;

    @NotNull
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;

    @Size(max = 1000)
    @NotNull
    @Column(name = "text", nullable = false, length = 1000)
    private String text;

    @NotNull
    @Column(name = "direction", nullable = false, length = Integer.MAX_VALUE)
    private String direction;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}