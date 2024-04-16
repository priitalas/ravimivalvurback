package ee.valiit.ravimivalvurback.business.medication.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medication.unit.Unit}
 */
@Value
public class UnitInfo implements Serializable {
    Integer unitId;
    String unitName;
}