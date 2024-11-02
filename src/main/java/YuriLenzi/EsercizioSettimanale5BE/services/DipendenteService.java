package YuriLenzi.EsercizioSettimanale5BE.services;

import YuriLenzi.EsercizioSettimanale5BE.entities.Dipendente;
import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.NotFoundException;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.SameUsernameorEmailException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewDipendenteDTO;
import YuriLenzi.EsercizioSettimanale5BE.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    public Dipendente findByUsername(String username){
        Dipendente found = null;
        found = dipendenteRepository.findById(username).orElseThrow(() -> new NotFoundException(username));
        return found;
    }

    public Dipendente saveDipendente(NewDipendenteDTO body){
        if(dipendenteRepository.findById(body.username()).isPresent())
            throw new SameUsernameorEmailException(body.username());
        else if(dipendenteRepository.existsByemail(body.email()))
            throw new SameUsernameorEmailException(body.email());
        else{
            Dipendente nuovoDipendente = new Dipendente(body.username(), body.nome(), body.cognome(), body.email());
            dipendenteRepository.save(nuovoDipendente);
            return nuovoDipendente;
        }
    }

    public void deleteDipendente(String username){
        Dipendente found = findByUsername(username);
        dipendenteRepository.delete(found);
    }

}
