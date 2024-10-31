package YuriLenzi.EsercizioSettimanale5BE.entities;

import YuriLenzi.EsercizioSettimanale5BE.exceptions.InconsistencyDateException;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.TravelingEmployeeException;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dataRichiesta;
    private String noteDipendente;
    @ManyToOne
    Dipendente dipendente;
    @ManyToOne
    Viaggio viaggio;

    public Prenotazione(LocalDate dataRichiesta, String noteDipendente, Dipendente dipendente, Viaggio viaggio) {
        checkData(dataRichiesta);
        checkInViaggio(viaggio);
        this.dataRichiesta = dataRichiesta;
        this.noteDipendente = noteDipendente;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
    }

    private void checkData(LocalDate data){
       if(viaggio.getDataViaggio().isBefore(data))
           throw new InconsistencyDateException();
    }
    private void checkInViaggio(Viaggio viaggio){
        if(viaggio.getStatoViaggio() == Stato.IN_CORSO){
            throw new TravelingEmployeeException();
        }
    }
}
