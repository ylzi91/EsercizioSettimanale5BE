package YuriLenzi.EsercizioSettimanale5BE.repositories;

import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
