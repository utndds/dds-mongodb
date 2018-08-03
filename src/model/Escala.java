package model;

import java.time.Duration;
import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Escala {
  
  private Punto lugar;
  private Date momento;

  public Escala(Punto lugar, Date momento) {
    this.lugar = lugar;
    this.momento = momento;
  }

  public boolean en(Punto punto) {
    return lugar.equals(punto);
  }

  public Date getMomento() {
    return momento;
  }

  public Duration duracionHasta(Escala otraEscala) {
    return Duration.between(//
        getMomento().toInstant(), //
        otraEscala.getMomento().toInstant());
  }

  public Punto getLugar() {
    return lugar;
  }
}
