package YuriLenzi.EsercizioSettimanale5BE.payloadsDTO;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewPrenotazioneDTO(
        @NotEmpty(message = "La data non può essere vuota")
        LocalDate dataRichiesta,
        String noteDipendente,
        @NotEmpty(message = "L'username non può essere vuoto")
        String username,
        @NotEmpty(message = "L'id viaggio non può essere vuoto")
        Long idViaggio) {
}
