package ee.valiit.ravimivalvurback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
    USER_UNAVAILABLE("Sellise nimega kasutaja on juba registreeritud", 333),
    MEDICINE_UNAVAILABLE("Sellise nimega ravim on juba lisatud", 444),
    UNIT_UNAVAILABLE("Selline ühik on juba olemas", 555),
    NO_PATIENTS_FOUND("Teil ei ole veel ühtegi aktiivset patsienti", 666),
    NO_MEDICATIONPLAN_FOUND("Patsiendile ei ole veel ühtegi ravimit määratud", 777);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
