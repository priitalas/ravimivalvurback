package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationPlanMapper medicationPlanMapper;
    private final MedicationTimeRepository medicationTimeRepository;


    public List<MedicationPlanInfo> findPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        List<MedicationPlanInfo> medicationPlanInfos = medicationPlanMapper.toMedicationPlanInfos(medicationPlans);

        for (MedicationPlanInfo medicationPlanInfo : medicationPlanInfos) {
            MedicationTime medicationTime = medicationTimeRepository.getReferenceById(medicationPlanInfo.getMedicationPlanId());
            medicationPlanInfo.setQuantity(medicationTime.getQuantity());
        }
            return medicationPlanInfos;
    }
}