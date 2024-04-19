package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationMapper;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationPlanMapper medicationPlanMapper;
    private final MedicationTimeRepository medicationTimeRepository;
    private final MedicationRepository medicationRepository;


    public List<MedicationPlanInfo> findPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        List<MedicationPlanInfo> medicationPlanInfos = medicationPlanMapper.toMedicationPlanInfos(medicationPlans);
        ValidationService.validatePatientHaveMedicationPlan(medicationPlans);

        for (MedicationPlanInfo medicationPlanInfo : medicationPlanInfos) {
            MedicationTime medicationTime = medicationTimeRepository.getReferenceById(medicationPlanInfo.getMedicationPlanId());
            medicationPlanInfo.setQuantity(medicationTime.getQuantity());
            Medication medication = medicationRepository.findMedicationBy(medicationPlanInfo.getMedicationName());
            medicationPlanInfo.setMedicationUnitName(medication.getUnit().getName());
        }
            return medicationPlanInfos;
    }
}