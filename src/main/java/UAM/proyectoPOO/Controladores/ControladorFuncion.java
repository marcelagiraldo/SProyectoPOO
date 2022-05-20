package UAM.proyectoPOO.Controladores;

import UAM.proyectoPOO.Modelos.Funcion;
import UAM.proyectoPOO.Modelos.Pelicula;
import UAM.proyectoPOO.Modelos.Sala;
import UAM.proyectoPOO.Repositorios.RepositorioFuncion;
import UAM.proyectoPOO.Repositorios.RepositorioPelicula;
import UAM.proyectoPOO.Repositorios.RepositorioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/funciones")
public class ControladorFuncion {
    @Autowired
    private RepositorioFuncion miRepositorioFuncion;
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;
    @Autowired
    private RepositorioSala miRepositorioSala;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pelicula/{id_pelicula}/sala/{id_sala}")
    public Funcion create(@RequestBody Funcion infoFuncion,@PathVariable String id_pelicula,@PathVariable String id_sala){
        Pelicula peliculaActual = this.miRepositorioPelicula.findById(id_pelicula).orElseThrow(RuntimeException::new);
        Sala salaActual = this.miRepositorioSala.findById(id_sala).orElseThrow(RuntimeException::new);
        infoFuncion.setPelicula(peliculaActual);
        infoFuncion.setSala(salaActual);

        return this.miRepositorioFuncion.save(infoFuncion);
    }
    @GetMapping("")
    public List<Funcion> index(){
        return this.miRepositorioFuncion.findAll();
    }
    @GetMapping("{id}")
    public Funcion show(@PathVariable String id){
        Funcion funcionActual = this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        return funcionActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Funcion funcionActual =this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        this.miRepositorioFuncion.delete(funcionActual);
    }
    @PutMapping("{id}/pelicula/{id_pelicula}/sala({id_sala}")
    public Funcion update(@PathVariable String id, @RequestBody  Funcion infoFuncion,@PathVariable String id_pelicula,@PathVariable String id_sala) {
        Funcion funcionActual = this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        Pelicula laPelicula = this.miRepositorioPelicula.findById(id_pelicula).get();
        Sala laSala = this.miRepositorioSala.findById(id_sala).get();
        funcionActual.setHora(infoFuncion.getHora());
        funcionActual.setDia(infoFuncion.getDia());
        funcionActual.setMes(infoFuncion.getMes());
        funcionActual.setAio(infoFuncion.getAio());
        funcionActual.setPelicula(laPelicula);
        funcionActual.setSala(laSala);
        return miRepositorioFuncion.save(funcionActual);
    }
}
