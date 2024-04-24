package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.AddedMedicationPlansInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.NewMedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import ee.valiit.ravimivalvurback.util.StringConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
    private final UserRepository userRepository;


    public List<PatientMedicationPlan> findPatientMedicationsToTakeNow(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        List<PatientMedicationPlan> patientMedicationPlans = createPatientMedicationPlans(medicationPlans);
        patientMedicationPlans = getOnlyMedicationsToTake(patientMedicationPlans);
        return patientMedicationPlans;
    }

    private List<PatientMedicationPlan> getOnlyMedicationsToTake(List<PatientMedicationPlan> patientMedicationPlans) {
        List<PatientMedicationPlan> onlyMedicationsToTake = new ArrayList<>();
        for (PatientMedicationPlan patientMedicationPlan : patientMedicationPlans) {
            if (patientMedicationPlan.getItsTimeToTakeMedication()) {
                onlyMedicationsToTake.add(patientMedicationPlan);
            }
        }
        return onlyMedicationsToTake;
    }


    private List<PatientMedicationPlan> createPatientMedicationPlans(List<MedicationPlan> medicationPlans) {
        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanMapper.toPatientMedicationPlans(medicationPlans);

        for (PatientMedicationPlan patientMedicationPlan : patientMedicationPlans) {

            byte[] imageData = medicationImageRepository.getMedicationImageBy(patientMedicationPlan.getMedicationId()).getData();
            patientMedicationPlan.setMedicationImageData(StringConverter.bytesToString(imageData));
            LocalTime timeNow = LocalTime.now();
            Optional<MedicationTime> optionalMedicationTime = medicationTimeRepository.findOptionalMedicationTime(patientMedicationPlan.getMedicationPlanId(), timeNow, timeNow);
            if (optionalMedicationTime.isPresent()) {
                MedicationTime medicationTime = optionalMedicationTime.get();
                BigDecimal quantity = medicationTime.getQuantity();
                Integer medicationTimeId = medicationTime.getId();
                LocalDate dateNow = LocalDate.now();
                boolean medicationTimeInLogbookExists = logbookRepository.medicationTimeInLogbookExists(patientMedicationPlan.getMedicationPlanId(), medicationTimeId, dateNow);
                patientMedicationPlan.setQuantity(quantity);
                patientMedicationPlan.setMedicationTimeId(medicationTimeId);
                patientMedicationPlan.setItsTimeToTakeMedication(!medicationTimeInLogbookExists);
            } else {
                patientMedicationPlan.setItsTimeToTakeMedication(false);
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
            // MedicationTime medicationTime = medicationTimeRepository.getReferenceById(medicationPlanInfo.getMedicationPlanId());
            Medication medication = medicationRepository.findMedicationBy(medicationPlanInfo.getMedicationName());
            medicationPlanInfo.setMedicationUnitName(medication.getUnit().getName());
        }
        return medicationPlanInfos;
    }

    public void logPatientTakesMedication(Integer medicationPlanId, Integer medicationTimeId) {
        MedicationPlan medicationPlan = medicationPlanRepository.getReferenceById(medicationPlanId);
        MedicationTime medicationTime = medicationTimeRepository.getReferenceById(medicationTimeId);
        Logbook logbook = new Logbook();
        logbook.setMedicationPlan(medicationPlan);
        logbook.setMedicationTime(medicationTime);
        logbook.setDate(LocalDate.now());
        logbook.setTime(LocalTime.now());
        logbookRepository.save(logbook);
    }

    public void addNewMedicationPlan(NewMedicationPlanInfo newMedicationPlanInfo) {
        Medication medication = medicationRepository.getReferenceById(newMedicationPlanInfo.getMedicationId());
        User user = userRepository.getReferenceById(newMedicationPlanInfo.getPatientId());
        MedicationPlan medicationPlan = medicationPlanMapper.toMedicationPlan(newMedicationPlanInfo);
        medicationPlan.setMedication(medication);
        medicationPlan.setPatient(user);
        medicationPlan.setFrequency(0);
        medicationPlanRepository.save(medicationPlan);
    }

    public List<AddedMedicationPlansInfo> findPatientMedicationPlansWithoutTimeslots(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findNewMedicationPlansBy(patientId);
        List<AddedMedicationPlansInfo> addedMedicationPlansInfos = medicationPlanMapper.toNewMedicationPlansInfos(medicationPlans);
        return addedMedicationPlansInfos;
    }
}
