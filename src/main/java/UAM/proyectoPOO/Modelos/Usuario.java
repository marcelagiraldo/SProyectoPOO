package UAM.proyectoPOO.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Usuario {
    @Id
    String _id;
    String cedula;
    String nombre;
    String email;
    int aioNacimiento;

    public Usuario(String cedula, String nombre, String email, int aioNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.aioNacimiento = aioNacimiento;
    }

    public String get_id() {
        return _id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getAioNacimiento() {
        return aioNacimiento;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAioNacimiento(int aioNacimiento) {
        this.aioNacimiento = aioNacimiento;
    }
}
