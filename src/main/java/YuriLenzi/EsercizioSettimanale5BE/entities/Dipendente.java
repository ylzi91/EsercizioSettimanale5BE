package YuriLenzi.EsercizioSettimanale5BE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dipendenti")
@Setter
@Getter
@NoArgsConstructor
public class Dipendente {
    @Id
    private String username;
    private String nome, cognome, email;
    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Prenotazione> prenotazioneList;

    public Dipendente(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
}
