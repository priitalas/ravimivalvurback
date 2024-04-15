package ee.valiit.ravimivalvurback.domain.medication.medicationimage;

import ee.valiit.ravimivalvurback.domain.medication.Medication;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

}