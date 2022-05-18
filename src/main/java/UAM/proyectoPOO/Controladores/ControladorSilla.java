package UAM.proyectoPOO.Controladores;

import UAM.proyectoPOO.Modelos.Silla;
import UAM.proyectoPOO.Repositorios.RepositorioSilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sillas")
public class ControladorSilla {
    @Autowired
    private RepositorioSilla miRepositorioSilla;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Silla create(@RequestBody Silla infoSilla){
        return this.miRepositorioSilla.save(infoSilla);
    }
    @GetMapping("")
    public List<Silla> index(){
        return this.miRepositorioSilla.findAll();
    }
    @GetMapping("{id}")
    public Silla show(@PathVariable String id){
        Silla sillaActual =this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        return sillaActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Silla sillaActual =this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        this.miRepositorioSilla.delete(sillaActual);
    }
    @PutMapping("{id}")
    public Silla update(@PathVariable String id, @RequestBody  Silla infoSilla) {
        Silla sillaActual = this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        sillaActual.setLetra(infoSilla.getLetra());
        sillaActual.setNumero(infoSilla.getNumero());
        return miRepositorioSilla.save(sillaActual);
    }
}