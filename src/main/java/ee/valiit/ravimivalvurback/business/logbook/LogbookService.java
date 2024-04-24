package ee.valiit.ravimivalvurback.business.logbook;

import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@AllArgsConstructor
public class LogbookService {
    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationTimeRepository medicationTimeRepository;
    private final LogbookRepository logbookRepository;


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
}
