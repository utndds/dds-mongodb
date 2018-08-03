package model;

import java.time.Duration;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public class Recorrido {
  
  private Deque<Escala> escalas = new LinkedList<>();

  public void hacerEscala(Punto punto) {
    escalas.add(new Escala(punto, new Date()));
  }

  public boolean pasoPor(Punto punto) {
    return escalas.stream().anyMatch(e -> e.en(punto));
  }

  public Duration duracion() {
    return escalas.getFirst().duracionHasta(escalas.getLast());
  }

  public Deque<Escala> getEscalas() {
    return escalas;
  }
}
