package YuriLenzi.EsercizioSettimanale5BE.repositories;

import YuriLenzi.EsercizioSettimanale5BE.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository <Dipendente, String> {
    boolean existsByusername(String username);
}
