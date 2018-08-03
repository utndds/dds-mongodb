package persistence;

import org.bson.Document;

import utils.DocumentBuilder;
import model.Escala;
import model.Punto;
import model.Recorrido;

import com.mongodb.client.MongoDatabase;

public class RepositorioRecorridosMongo implements RepositorioRecorridos {

  private MongoDatabase db;

  public RepositorioRecorridosMongo(MongoDatabase db) {
    this.db = db;
  }

  public void guardar(Recorrido recorrido) {
    db.getCollection("recorridos").insertOne(recorridoToDocument(recorrido));
  }

  private Document recorridoToDocument(Recorrido recorrido) {
    return new DocumentBuilder(). //
        withList("escalas", recorrido.getEscalas(), this::escalaToDocument). //
        build();
  }

  private Document escalaToDocument(Escala e) {
    return new DocumentBuilder(). //
        with("momento", e.getMomento()). //
        with("lugar", e.getLugar(), this::puntoToDocument). //
        build();
  }

  private Document puntoToDocument(Punto l) {
    return new DocumentBuilder(). //
        with("latitud", l.getLatitud()). //
        with("longitud", l.getLongitud()). //
        build();
  }
}
