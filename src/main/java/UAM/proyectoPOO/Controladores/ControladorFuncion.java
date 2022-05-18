package UAM.proyectoPOO.Controladores;

import UAM.proyectoPOO.Modelos.Funcion;
import UAM.proyectoPOO.Repositorios.RepositorioFuncion;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Funcion create(@RequestBody Funcion infoFuncion){
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
    @PutMapping("{id}")
    public Funcion update(@PathVariable String id, @RequestBody  Funcion infoFuncion) {
        Funcion funcionActual = this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        funcionActual.setHora(infoFuncion.getHora());
        funcionActual.setDia(infoFuncion.getDia());
        funcionActual.setMes(infoFuncion.getMes());
        funcionActual.setAio(infoFuncion.getAio());
        return miRepositorioFuncion.save(funcionActual);
    }
}
