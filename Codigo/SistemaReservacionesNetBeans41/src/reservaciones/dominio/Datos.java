package reservaciones.dominio;

import java.util.*;
import reservaciones.util.*;

public class Datos extends ObjetoEntidad {

  protected String name;
  protected int numAtributosBD;
  protected Atributo atributo;
  protected Vector<Atributo> listaAtributos;

  public Datos() {
    name = Utilerias.getClassName(this);
    listaAtributos = new Vector<Atributo>();
  }
  public String getName() { return name; }
  public int numeroDatos() {
    return 1;
  }
  protected void agregarAtributo(String nombre, String valor, boolean fg) {
    atributo = new Atributo(nombre,valor);
    listaAtributos.addElement(atributo);
    if (fg == true)
      numAtributosBD++;
  }
  public int numeroAtributos() {
    return listaAtributos.size();
  }
  public int numeroAtributosBD() {
    return numAtributosBD;
  }
  private void borrarTodos() {
     for (int i = 0; i < listaAtributos.size(); i++) {
          atributo = (Atributo) listaAtributos.elementAt(i);
          if (atributo != null)
            atributo.escribirValor("");
      }
  }
   public Atributo getAtributo(int i) {
    String str = null;
    atributo = (Atributo) listaAtributos.elementAt(i);
    return atributo;
  }
  public String leerNombre(int i) {
    String str = null;
    atributo = (Atributo) listaAtributos.elementAt(i);
    if (atributo != null)
        str = atributo.leerNombre();
    return str;
  }
  public int leerIndice(String str) {
    String nombre;
    for (int i = 0; i < listaAtributos.size(); i++){
          atributo = (Atributo) listaAtributos.elementAt(i);
          if (atributo != null && (nombre = atributo.leerNombre()) != null
                && nombre.equals(str) == true)
                  return i;
    }
    return -1;
  }
  public String leerValor(String nombre, int i) {
      return leerValor(nombre);
  }
  public String leerValor(String nombre) {
      String str = null;
      int i = leerIndice(nombre);
      if (i != -1)
            str = leerValor(i);
      return str;
  }
  public String leerValor(int i) {
      String str = null;
      atributo = (Atributo) listaAtributos.elementAt(i);
      if (atributo != null)
            str = atributo.leerValor();
      return str;
  }
  public void escribirValor(int i,String str) {
      atributo = (Atributo) listaAtributos.elementAt(i);
      if (atributo != null)
            atributo.escribirValor(str);
  }
  public void escribirValor(String name,String str) {
     String nombre = "";
     for (int i = 0; i < listaAtributos.size(); i++){
          atributo = (Atributo) listaAtributos.elementAt(i);
          if (atributo != null && (nombre = atributo.leerNombre()) != null
                && nombre.equals(name) == true)
                    atributo.escribirValor(str);
     }
  }
  public boolean copiarValor(String nom1, String nom2) {
    boolean fg = false;
    int i1 = leerIndice(nom1);
    int i2 = leerIndice(nom2);
    String str;
    if (i1 != -1 && i2 != -1) {
        Atributo atributo1 = (Atributo) listaAtributos.elementAt(i1);
        Atributo atributo2 = (Atributo) listaAtributos.elementAt(i2);
        if (atributo1 != null && atributo2 != null) {
            str = atributo1.leerValor();
            atributo2.escribirValor(str);
        }
        fg = true;
    }
    return fg;
  }
  public void printAll() {
     for (int i = 0; i < listaAtributos.size(); i++)
        if (atributo != null)
            atributo.print();
  }
  public String serializarSQL() {
    String serializa0 = "";
//  String serializa1 = "";
    for (int i = 0; i < numAtributosBD; i++) {
      if (i > 0)   {
        serializa0 = serializa0 + ", ";
//      serializa1 = serializa1 + ", ";
      }
      serializa0 = serializa0 + leerNombre(i) + " = " +
        "'" + leerValor(i) + "'";
    }
//  return "(" + serializa0 + ") VALUES (" + serializa1 + ")";
    return serializa0;
  }
  public String serializarSQLinsert() {
         String serializa0 = "";
         String serializa1 = "";
         for (int i = 0; i < numAtributosBD; i++) {
                if (i > 0)   {
                  serializa0 = serializa0 + ", ";
                  serializa1 = serializa1 + ", ";
                }
                serializa0 = serializa0 + leerNombre(i);
                serializa1 = serializa1 + "'" + leerValor(i) + "'";
         }
         return "(" + serializa0 + ") VALUES (" + serializa1 + ")";
  }
  public void actualizarAtributos() { }
}
