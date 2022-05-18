package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioUsuario extends MongoRepository<Usuario,String> {
}
