package YuriLenzi.EsercizioSettimanale5BE.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
