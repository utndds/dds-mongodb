import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import persistence.RepositorioRecorridos;
import persistence.RepositorioRecorridosMorphia;

import com.mongodb.MongoClient;
import model.Recorrido;
import model.Punto;

public class MainMorphia {
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
      Morphia morphia = new Morphia();
      morphia.mapPackage("model");

      Datastore datastore = morphia.createDatastore(client, "recorridos2");

      RepositorioRecorridos repositorio = new RepositorioRecorridosMorphia(datastore);
      repositorio.guardar(recorrido);
      repositorio.guardar(otroRecorrido);
    }
  }
}
