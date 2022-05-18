package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPelicula extends MongoRepository<Pelicula,String> {
}
