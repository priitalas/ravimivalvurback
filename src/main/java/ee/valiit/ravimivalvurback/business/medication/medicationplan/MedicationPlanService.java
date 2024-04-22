package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.DoctorPatientMedicationPlan;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImage;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import ee.valiit.ravimivalvurback.util.StringConverter;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;

import java.time.*;
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


    public List<DoctorPatientMedicationPlan> findDoctorPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        List<DoctorPatientMedicationPlan> doctorPatientMedicationPlans = medicationPlanMapper.toDoctorPatientMedicationPlans(medicationPlans);

        for (DoctorPatientMedicationPlan doctorPatientMedicationPlan : doctorPatientMedicationPlans) {
            MedicationTime medicationTime = medicationTimeRepository.getReferenceById(doctorPatientMedicationPlan.getMedicationPlanId());
            doctorPatientMedicationPlan.setQuantity(medicationTime.getQuantity());
            Medication medication = medicationRepository.findMedicationBy(doctorPatientMedicationPlan.getMedicationName());
            doctorPatientMedicationPlan.setMedicationUnitName(medication.getUnit().getName());
        }
        return doctorPatientMedicationPlans;
    }

    public List<PatientMedicationPlan> findPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);


        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanMapper.toPatientMedicationPlans(medicationPlans);

        for (PatientMedicationPlan patientMedicationPlan : patientMedicationPlans) {

            byte[] imageData = medicationImageRepository.getMedicationImageBy(patientMedicationPlan.getMedicationId()).getData();
            patientMedicationPlan.setMedicationImageData(StringConverter.bytesToString(imageData));
            LocalTime timeNow = LocalTime.now();
            Optional<MedicationTime> optionalMedicationTime = medicationTimeRepository.findOptionalMedicationTime(patientMedicationPlan.getMedicationPlanId(), timeNow, timeNow);
            if (optionalMedicationTime.isPresent()) {
                LocalDateTime utcNow = LocalDateTime.now(ZoneOffset.UTC);
                boolean medicationedTimeInLogbookExists = logbookRepository.medicationTimeInLogbookExists(me, medicationTimeId, utcNow.toLocalDate(), utcNow.toLocalTime());

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
