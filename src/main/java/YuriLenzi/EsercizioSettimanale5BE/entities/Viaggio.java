package YuriLenzi.EsercizioSettimanale5BE.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    private String destinazione;
    
}
