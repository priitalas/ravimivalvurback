package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlanMapper;
import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlanRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationPlanMapper medicationPlanMapper;
    private final MedicationRepository medicationRepository;
    private final MedicationTimeRepository medicationTimeRepository;


    public void findPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        List<MedicationPlanInfo> medicationPlanInfos = medicationPlanMapper.toMedicationPlanInfos(medicationPlans);

        for (MedicationPlanInfo medicationPlanInfo : medicationPlanInfos)  {
            Medication medication = medicationRepository.findMedicationBy(m);
        }

       return medicationPlanInfos;
    }
}