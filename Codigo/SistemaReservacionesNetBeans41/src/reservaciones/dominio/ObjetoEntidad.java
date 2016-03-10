package reservaciones.dominio;

import java.util.*;

public abstract class ObjetoEntidad {

  protected String name = "";
 
  public ObjetoEntidad() {
  }
  public ObjetoEntidad(String str) {
    name = str;
  }
  /*
  public String leerNombre(int i) 
  public int leerIndice(String str)*/
  public abstract int numeroDatos();
  public abstract String leerValor(String nombre, int i);
  public abstract String leerValor(String nombre);
  public String getName(){ return name; }
  /*
  public String leerValor(int i) 
  public void escribirValor(int i,String str) 
  public boolean copiarValor(String nom1, String nom2) 
  public void printAll() 
  public String serializarSQL() 
  public String serializarSQLinsert()
  public void actualizarAtributos()
  */
}
