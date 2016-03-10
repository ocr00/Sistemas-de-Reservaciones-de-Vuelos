package reservaciones.dominio;

import java.util.*;

public class Atributo {

  private String nombre;
  private String valor;

  public Atributo(String str, String v) {
    nombre = str;
    valor = v;
  }
  public String leerNombre() {
    return nombre;
  }
  public String leerValor() {
    return valor;
  }
  public void escribirValor(String v) {
    valor = v;
  }
  public void print() {
    System.out.print(nombre+": ");
    System.out.println(valor);
  }
}