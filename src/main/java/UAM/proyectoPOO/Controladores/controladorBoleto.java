package UAM.proyectoPOO.Controladores;

import UAM.proyectoPOO.Modelos.*;
import UAM.proyectoPOO.Repositorios.RepositorioBoleto;
import UAM.proyectoPOO.Repositorios.RepositorioFuncion;
import UAM.proyectoPOO.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/boletos")
public class controladorBoleto {
    @Autowired
    private RepositorioBoleto miRepositorioBoleto;
    @Autowired
    private RepositorioFuncion miRepositorioFuncion;
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Boleto create(@RequestBody Boleto infoBoleto){
        return this.miRepositorioBoleto.save(infoBoleto);
    }
    @GetMapping("")
    public List<Boleto> index(){
        return this.miRepositorioBoleto.findAll();
    }
    @GetMapping("{id}")
    public Boleto show(@PathVariable String id){
        Boleto boletoActual =this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        return boletoActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Boleto boletoActual =this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        this.miRepositorioBoleto.delete(boletoActual);
    }
    @PutMapping("{id}")
    public Boleto update(@PathVariable String id,@RequestBody  Boleto infoBoleto){
        Boleto boletoActual=this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        boletoActual.setTipo(infoBoleto.getTipo());
        boletoActual.setValor(infoBoleto.getValor());
        return this.miRepositorioBoleto.save(boletoActual);
    }
    @PutMapping("{id_boleto}/funicon/{id_funcion}/usuario/{id_usuario}")
    public Boleto update2(@PathVariable String id_boleto, @PathVariable String id_funcion,@PathVariable String id_usuario){
        Boleto boletoActual = this.miRepositorioBoleto.findById(id_boleto).orElseThrow(RuntimeException::new);
        Funcion funcionctual = this.miRepositorioFuncion.findById(id_funcion).orElseThrow(RuntimeException::new);
        Usuario usuarioActual = this.miRepositorioUsuario.findById(id_usuario).orElseThrow(RuntimeException::new);
        boletoActual.setFuncion(funcionctual);
        boletoActual.setUsuario(usuarioActual);
        return this.miRepositorioBoleto.save(boletoActual);
    }
}
