package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.domain.medication.*;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImage;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageMapper;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;
    private final UnitRepository unitRepository;
    private final MedicationMapper medicationMapper;
    private final MedicationImageMapper medicationImageMapper;
    private final MedicationImageRepository medicationImageRepository;

    public void findPatientMedications(Integer patientId) {

    }

    public void addNewMedication(MedicationInfo medicationInfo) {
        boolean medicineAlreadyExists = medicationRepository.medicineAlreadyExists(medicationInfo.getMedicationName());
        ValidationService.validateMedicineNameAvailable(medicineAlreadyExists);
        Unit unit = unitRepository.getReferenceById(medicationInfo.getUnitId());
        Medication medication = medicationMapper.toMedication(medicationInfo);
        medication.setUnit(unit);
        medicationRepository.save(medication);
        addMedicationImage(medicationInfo, medication);
    }

    public void addMedicationImage(MedicationInfo medicationInfo, Medication medication) {

       MedicationImage medicationImage = medicationImageMapper.toMedicationImage(medicationInfo);
       medicationImage.setMedication(medication);
       medicationImageRepository.save(medicationImage);
    }
}
