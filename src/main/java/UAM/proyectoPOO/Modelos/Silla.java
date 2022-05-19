package UAM.proyectoPOO.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Silla {
    @Id
    String _id;
    String letra;
    int numero;
    @DBRef
    Sala sala;

    public Silla(String letra, int numero) {
        this.letra = letra;
        this.numero = numero;
    }

    public String get_id() {
        return _id;
    }

    public String getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
