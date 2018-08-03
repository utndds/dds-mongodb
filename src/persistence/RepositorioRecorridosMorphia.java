package persistence;

import model.Recorrido;

import org.mongodb.morphia.Datastore;

public class RepositorioRecorridosMorphia implements RepositorioRecorridos {

  private Datastore datastore;

  public RepositorioRecorridosMorphia(Datastore datastore) {
    this.datastore = datastore;
  }

  public void guardar(Recorrido recorrido) {
    datastore.save(recorrido);
  }
  

}
