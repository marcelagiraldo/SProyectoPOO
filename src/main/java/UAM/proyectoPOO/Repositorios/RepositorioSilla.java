package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Silla;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioSilla extends MongoRepository<Silla,String> {
    @Query("{'funcion.$id': ObjectId(?0)}")
    List<Silla> getSillasEnFuncion(String idFuncion);
}
