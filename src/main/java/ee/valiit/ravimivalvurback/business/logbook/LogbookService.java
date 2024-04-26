package ee.valiit.ravimivalvurback.business.logbook;

import ee.valiit.ravimivalvurback.business.logbook.dto.LogbookInfo;
import ee.valiit.ravimivalvurback.domain.medicationplan.*;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LogbookService {
    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationTimeRepository medicationTimeRepository;
    private final LogbookRepository logbookRepository;
    private final LogbookMapper logbookMapper;


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

    public List<LogbookInfo> getPatientMedicationLogbook(Integer patientId) {
        List<Logbook> logbook = logbookRepository.findLogbookBy(patientId);
        ValidationService.validatePatientHasTakenAnyMedications(logbook);
        return logbookMapper.toLogbookInfos(logbook);
    }
}
