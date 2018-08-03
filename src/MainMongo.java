
import persistence.RepositorioRecorridos;
import persistence.RepositorioRecorridosMongo;
import model.Recorrido;
import model.Punto;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MainMongo {
  public static void main(String[] args) {
    Recorrido recorrido = new Recorrido();
    recorrido.hacerEscala(new Punto(10, 10));
    recorrido.hacerEscala(new Punto(11, 14));
    recorrido.hacerEscala(new Punto(13, 16));
    recorrido.hacerEscala(new Punto(14, 24));

    Recorrido otroRecorrido = new Recorrido();
    otroRecorrido.hacerEscala(new Punto(12, 10));
    otroRecorrido.hacerEscala(new Punto(14, 14));

    try (MongoClient client = new MongoClient()) {
      MongoDatabase database = client.getDatabase("recorridos");
      
      RepositorioRecorridos repositorio = new RepositorioRecorridosMongo(database);
      repositorio.guardar(recorrido);
      repositorio.guardar(otroRecorrido);
    }
  }
}
