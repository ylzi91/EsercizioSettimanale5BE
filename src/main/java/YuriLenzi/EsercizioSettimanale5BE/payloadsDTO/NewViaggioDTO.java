package YuriLenzi.EsercizioSettimanale5BE.payloadsDTO;

import YuriLenzi.EsercizioSettimanale5BE.entities.Stato;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewViaggioDTO(
        @NotEmpty(message = "La destinazione non può essere vuota")
        @Size(min = 4, max = 30, message = "Minimo 4 caratteri e massimo 30")
        String destinazione,
        @NotEmpty(message = "La data non può essere vuota")
        LocalDate dataViaggio
) {
}
