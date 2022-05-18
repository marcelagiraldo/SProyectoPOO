package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Silla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSilla extends MongoRepository<Silla,String> {
}
