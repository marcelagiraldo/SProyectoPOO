package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Boleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioBoleto extends MongoRepository<Boleto,String> {
}
