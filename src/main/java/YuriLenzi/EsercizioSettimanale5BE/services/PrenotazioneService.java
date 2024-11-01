package YuriLenzi.EsercizioSettimanale5BE.services;

import YuriLenzi.EsercizioSettimanale5BE.controllers.PrenotazioneController;
import YuriLenzi.EsercizioSettimanale5BE.entities.Dipendente;
import YuriLenzi.EsercizioSettimanale5BE.entities.Prenotazione;
import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.NotFoundException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewPrenotazioneDTO;
import YuriLenzi.EsercizioSettimanale5BE.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    DipendenteService dipendenteService;
    @Autowired
    ViaggioService viaggioService;

    public List<Prenotazione> findAll(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(Long idPrenotazione){
        return prenotazioneRepository.findById(idPrenotazione).orElseThrow(() -> new NotFoundException(idPrenotazione));
    }

    public Prenotazione savePrenotazione(NewPrenotazioneDTO body, String username, Long idViaggio){
        Dipendente foundDip = dipendenteService.findByUsername(username);
        Viaggio foundViaggio = viaggioService.findByid(idViaggio);
        Prenotazione newPrenotazione = new Prenotazione(LocalDate.parse(body.dataRichiesta()), body.noteDipendente(), foundDip, foundViaggio);
        prenotazioneRepository.save(newPrenotazione);
        return newPrenotazione;

    }
}
