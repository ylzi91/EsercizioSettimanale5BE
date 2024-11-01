package YuriLenzi.EsercizioSettimanale5BE.controllers;

import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.BadRequestException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewViaggioDTO;
import YuriLenzi.EsercizioSettimanale5BE.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {
    @Autowired
    ViaggioService viaggioService;

    @GetMapping
    List<Viaggio> getAllViaggi(){
        return viaggioService.findAll();
    }

    @GetMapping("/{idViaggio}")
    public Viaggio findById(@PathVariable Long idViaggio){
        return viaggioService.findByid(idViaggio);
    }

    @PostMapping
    public Viaggio saveViaggio(@RequestBody @Validated NewViaggioDTO body, BindingResult validationResult){
        if(validationResult.hasErrors()){
            String message = validationResult.getAllErrors().
                    stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).
                    collect(Collectors.joining(". "));
            throw new BadRequestException(message);
        }
        return viaggioService.saveViaggio(body);
    }

}
