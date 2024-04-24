package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.business.medication.dto.MedicationsInfo;
import ee.valiit.ravimivalvurback.domain.medication.Medication;
import ee.valiit.ravimivalvurback.domain.medication.MedicationMapper;
import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImage;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageMapper;
import ee.valiit.ravimivalvurback.domain.medication.medicationimage.MedicationImageRepository;
import ee.valiit.ravimivalvurback.domain.medication.unit.Unit;
import ee.valiit.ravimivalvurback.domain.medication.unit.UnitRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;
    private final UnitRepository unitRepository;
    private final MedicationMapper medicationMapper;
    private final MedicationImageMapper medicationImageMapper;
    private final MedicationImageRepository medicationImageRepository;

    public Integer addNewMedication(MedicationInfo medicationInfo) {
        boolean medicineAlreadyExists = medicationRepository.medicineAlreadyExists(medicationInfo.getMedicationName());
        ValidationService.validateMedicineNameAvailable(medicineAlreadyExists);
        Unit unit = unitRepository.getReferenceById(medicationInfo.getUnitId());
        Medication medication = medicationMapper.toMedication(medicationInfo);
        medication.setUnit(unit);
        medicationRepository.save(medication);
        addMedicationImage(medicationInfo, medication);
        return medication.getId();
    }

    public void addMedicationImage(MedicationInfo medicationInfo, Medication medication) {
       MedicationImage medicationImage = medicationImageMapper.toMedicationImage(medicationInfo);
       medicationImage.setMedication(medication);
       medicationImageRepository.save(medicationImage);
    }

    public List<MedicationsInfo> getAllActiveMedications() {
        List<Medication> medications = medicationRepository.findMedicationsBy("A");
        return medicationMapper.toMedicationsInfos(medications);
    }

//    public MedicationInfo getExtendedMedicationInfo(Integer medicationId) {
//        Medication medication = medicationRepository.getReferenceById(medicationId);
//        MedicationInfo medicationInfo = new MedicationInfo();
//        medicationInfo.setMedicationName(medication.getName());
//        medicationInfo.setNote(medication.getNote());
//        medicationInfo.setDescription(medication.getDescription());
//
//        MedicationInfo medicationInfo1 = medicationMapper.toMedicationInfo(medication);
//        return medicationInfo;
//    }
}
