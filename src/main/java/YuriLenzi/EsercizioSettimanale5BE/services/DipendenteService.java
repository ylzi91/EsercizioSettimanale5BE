package YuriLenzi.EsercizioSettimanale5BE.services;

import YuriLenzi.EsercizioSettimanale5BE.entities.Dipendente;
import YuriLenzi.EsercizioSettimanale5BE.entities.Viaggio;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.BadRequestException;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.NotFoundException;
import YuriLenzi.EsercizioSettimanale5BE.exceptions.SameUsernameorEmailException;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewDipendenteDTO;
import YuriLenzi.EsercizioSettimanale5BE.payloadsDTO.NewImgDTO;
import YuriLenzi.EsercizioSettimanale5BE.repositories.DipendenteRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    DipendenteRepository dipendenteRepository;

    @Autowired
    Cloudinary cloudinaryUploader;

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

    public NewImgDTO uploadAvatar(MultipartFile file, String username) {
        Dipendente found = findByUsername(username);
        String url = null;
        try {
            url = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        } catch (IOException e) {
            throw new BadRequestException("Errore nell'upload dell'immagine");
        }
        found.setUrlImg(url);
        dipendenteRepository.save(found);
        return new NewImgDTO("Ecco l'url dell'immagine", url);
    }

}
