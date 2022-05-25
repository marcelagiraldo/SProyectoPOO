package UAM.proyectoPOO.Repositorios;

import UAM.proyectoPOO.Modelos.Boleto;
import UAM.proyectoPOO.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioBoleto extends MongoRepository<Boleto,String> {
    @Query("{'_id':?0}")
    public Boleto getBoletoPorId(String _id);
}
