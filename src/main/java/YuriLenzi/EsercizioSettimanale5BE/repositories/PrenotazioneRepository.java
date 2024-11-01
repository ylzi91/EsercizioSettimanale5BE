package YuriLenzi.EsercizioSettimanale5BE.repositories;

import YuriLenzi.EsercizioSettimanale5BE.entities.Dipendente;
import YuriLenzi.EsercizioSettimanale5BE.entities.Prenotazione;
import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByDipendenteAndViaggio(Dipendente dipendente, Viaggio viaggio);
    List<Prenotazione> findByDipendente(Dipendente dipendente);
}
