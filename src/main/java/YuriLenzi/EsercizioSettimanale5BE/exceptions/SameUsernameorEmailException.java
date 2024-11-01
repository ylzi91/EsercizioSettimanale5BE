package YuriLenzi.EsercizioSettimanale5BE.exceptions;

public class SameUsernameorEmailException extends RuntimeException {
    public SameUsernameorEmailException(String usOrMail) {
        super(usOrMail + " già presente");
    }

}
