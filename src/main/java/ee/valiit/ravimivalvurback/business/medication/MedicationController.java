package ee.valiit.ravimivalvurback.business.medication;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;

    // todo: teeme hiljem
    @GetMapping("/medications")
    public void findPatientMedications(@RequestParam Integer patientId) {
        medicationService.findPatientMedications(patientId);
    }


    // todo: kontroller medication lisamiseks
    // todo: Vaja mõelda rada /medication
    // todo: POST
    // todo: medicationService alla lahendus/implementatsioon
    // todo: unitId on foreign key, seda ei saa lisamisel, muutmisel mäpperiga mäppida
    // todo: enne kui midagi üldse tegema hakkad, siis leia ülesse 'unit' objekt  (reposityry kaudu unitId järgi)
    // todo: nyyd saab hakata ette valmistama 'medication' rida. Selleks on vaja uut medication entity objekti
    // todo: info tuleb sisse JSONina. Selleks on vaja DTO klassi sama struktuuriga nagu sissetulev JSON
    // todo: DTOst on vaja teha entity objekt. Mõistlik oleks see teha mapperi abil.
    // todo: kui objekt valmist, siis panna sellele külge ka varasemalt leitud unit objekt (foreign key)
    // todo: Kui kõik vajalik info olemas, siis saab selle 'medication' rea ära salvestada.'
    // todo: Nyyd saab hakata tegelema medication_image info ettevalmistamisega
    // todo: vaja luua uus entity objekt medicationImage, kas käsitsi v'õi mapperiga
    // todo: peale mappimist on vaja külge panna ka medication objekt (foreing key)
    // todo: salvesta see rida andmebaasi
    // todo: FINITO

}
