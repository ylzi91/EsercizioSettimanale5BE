package YuriLenzi.EsercizioSettimanale5BE.controllers;


import YuriLenzi.EsercizioSettimanale5BE.entities.Prenotazione;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.BadRequestException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewPrenotazioneDTO;
import YuriLenzi.EsercizioSettimanale5BE.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService prenotazioneService;
    @GetMapping
    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneService.findAll();
    }

    @GetMapping("/{idPrenotazione}")
    public Prenotazione findById(@PathVariable Long idPrenotazione){
        return prenotazioneService.findById(idPrenotazione);
    }

    @PostMapping("/{username}/{idViaggio}")
    public Prenotazione savePrenotazione(@RequestBody @Validated NewPrenotazioneDTO body,
                                         @PathVariable String username,
                                         @PathVariable Long idViaggio,
                                         BindingResult validationResult)
    {
        if (validationResult.hasErrors()){
            String message = validationResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(". "));
            throw new BadRequestException(message);
        }
        return prenotazioneService.savePrenotazione(body, username, idViaggio);

    }

    @GetMapping("username/{username}")
    public List<Prenotazione> filterbyDip(@PathVariable String username){
        return prenotazioneService.findByDip(username);
    }
}
