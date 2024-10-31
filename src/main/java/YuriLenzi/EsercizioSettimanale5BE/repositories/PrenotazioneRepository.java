package YuriLenzi.EsercizioSettimanale5BE.repositories;

import YuriLenzi.EsercizioSettimanale5BE.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
