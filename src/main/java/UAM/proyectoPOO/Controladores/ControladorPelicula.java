package UAM.proyectoPOO.Controladores;

import UAM.proyectoPOO.Modelos.Pelicula;
import UAM.proyectoPOO.Repositorios.RepositorioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/peliculas")
public class ControladorPelicula {
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pelicula create(@RequestBody Pelicula infoPelicula){
        return this.miRepositorioPelicula.save(infoPelicula);
    }
    @GetMapping("")
    public List<Pelicula> index(){
        return this.miRepositorioPelicula.findAll();
    }
    @GetMapping("{id}")
    public Pelicula show(@PathVariable String id){
        Pelicula peliculaActual = this.miRepositorioPelicula.findById(id).orElseThrow(RuntimeException::new);
        return peliculaActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Pelicula peliculaActual =this.miRepositorioPelicula.findById(id).orElseThrow(RuntimeException::new);
        this.miRepositorioPelicula.delete(peliculaActual);
    }
    @PutMapping("{id}")
    public Pelicula update(@PathVariable String id, @RequestBody  Pelicula infoPelicula) {
        Pelicula peliculaActual = this.miRepositorioPelicula.findById(id).orElseThrow(RuntimeException::new);
        peliculaActual.setNombre(infoPelicula.getNombre());
        peliculaActual.setTipo(infoPelicula.getTipo());
        peliculaActual.setAio(infoPelicula.getAio());
        return miRepositorioPelicula.save(peliculaActual);
    }
}
