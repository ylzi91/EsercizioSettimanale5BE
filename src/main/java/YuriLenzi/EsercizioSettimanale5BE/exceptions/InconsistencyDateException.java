package YuriLenzi.EsercizioSettimanale5BE.exceptions;

import java.time.LocalDate;

public class InconsistencyDateException extends RuntimeException {
    public InconsistencyDateException() {
        super(
                "La data di prenotazione non può essere successiva a quella di viaggio"
        );
    }
}
