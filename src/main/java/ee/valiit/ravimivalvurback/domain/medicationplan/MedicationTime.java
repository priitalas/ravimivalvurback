package ee.valiit.ravimivalvurback.domain.medicationplan;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "medication_time", schema = "ravim")
public class MedicationTime {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medication_plan_id", nullable = false)
    private MedicationPlan medicationPlan;

    @NotNull
    @Column(name = "slot_start", nullable = false)
    private LocalTime slotStart;

    @NotNull
    @Column(name = "slot_end", nullable = false)
    private LocalTime slotEnd;

    @NotNull
    @Column(name = "quantity", nullable = false, precision = 2, scale = 100)
    private BigDecimal quantity;

}