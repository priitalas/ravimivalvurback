package ee.valiit.ravimivalvurback.business.medication.unit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medication.unit.Unit}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitRequest implements Serializable {
    private String unitName;
}