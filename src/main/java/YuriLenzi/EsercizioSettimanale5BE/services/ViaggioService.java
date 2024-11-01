package YuriLenzi.EsercizioSettimanale5BE.services;

import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.NotFoundException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewViaggioDTO;
import YuriLenzi.EsercizioSettimanale5BE.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ViaggioService {

   @Autowired
   ViaggioRepository viaggioRepository;

   public List<Viaggio> findAll(){
       return viaggioRepository.findAll();
   }

   public Viaggio findByid(Long idViaggio){
       return viaggioRepository.findById(idViaggio).orElseThrow(() -> new NotFoundException(idViaggio));
   }

   public Viaggio saveViaggio(NewViaggioDTO body){
       Viaggio newViaggio = new Viaggio(body.destinazione(), LocalDate.parse(body.dataViaggio()));
       viaggioRepository.save(newViaggio);
       return newViaggio;
   }


}
