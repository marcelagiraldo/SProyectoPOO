package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Funcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFuncion extends MongoRepository<Funcion,String> {
}
