package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import ee.valiit.ravimivalvurback.util.StringConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationPlanMapper medicationPlanMapper;
    private final MedicationTimeRepository medicationTimeRepository;
    private final MedicationRepository medicationRepository;
    private final MedicationImageRepository medicationImageRepository;
    private final LogbookRepository logbookRepository;




    public List<PatientMedicationPlan> findTodaysPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);


        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanMapper.toPatientMedicationPlans(medicationPlans);

        for (PatientMedicationPlan patientMedicationPlan : patientMedicationPlans) {

            byte[] imageData = medicationImageRepository.getMedicationImageBy(patientMedicationPlan.getMedicationId()).getData();
            patientMedicationPlan.setMedicationImageData(StringConverter.bytesToString(imageData));
            LocalTime timeNow = LocalTime.now();
            Optional<MedicationTime> optionalMedicationTime = medicationTimeRepository.findOptionalMedicationTime(patientMedicationPlan.getMedicationPlanId(), timeNow, timeNow);
            if (optionalMedicationTime.isPresent()) {
                LocalDateTime utcNow = LocalDateTime.now(ZoneOffset.UTC);
                boolean medicationedTimeInLogbookExists = logbookRepository.medicationTimeInLogbookExists(1, 1, LocalDate.now());

            } else {

            }
        }

        // @Mapping(source = "", target = "quantity")

        return patientMedicationPlans;
    }



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
