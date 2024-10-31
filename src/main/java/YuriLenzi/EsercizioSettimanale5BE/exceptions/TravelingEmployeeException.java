package YuriLenzi.EsercizioSettimanale5BE.exceptions;

public class TravelingEmployeeException extends RuntimeException {
    public TravelingEmployeeException() {
        super("Il dipendente è già in viaggio");
    }
}
