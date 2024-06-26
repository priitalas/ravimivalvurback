package ee.valiit.ravimivalvurback.domain.medication;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medication_image", schema = "ravim")
public class MedicationImage {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medical_id", nullable = false)
    private Medication medical;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

}