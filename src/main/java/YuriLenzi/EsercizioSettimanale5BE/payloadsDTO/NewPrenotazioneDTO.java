package YuriLenzi.EsercizioSettimanale5BE.payloadsDTO;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewPrenotazioneDTO(
        @NotEmpty(message = "La data non può essere vuota")
        String dataRichiesta,
        String noteDipendente
      ) {
}
