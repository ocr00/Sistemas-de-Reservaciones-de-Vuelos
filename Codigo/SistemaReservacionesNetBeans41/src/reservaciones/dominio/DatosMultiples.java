package reservaciones.dominio;

import java.util.*;

public class DatosMultiples extends ObjetoEntidad {

  protected int numDatos;
  protected Vector<Datos> listaDatos;

  public DatosMultiples() {
    listaDatos = new Vector<Datos>();
  }
  public DatosMultiples(String str) {
    super(str);
    listaDatos = new Vector<Datos>();
  }
  public Datos getDatos(int i){
      return listaDatos.elementAt(i);
  }
  public void agregarDatos(Datos d) {
    listaDatos.addElement(d);
    numDatos++;
  }
  public int numeroDatos() {
    return listaDatos.size();
  }
  public String leerValor(String nombre,int i) {
      Datos d = listaDatos.elementAt(i);
      String str = null;
      if (d != null)
          str = d.leerValor(nombre);

      return str;
  }
  public String leerValor(String nombre) {
      return leerValor(nombre,0);
  }
  public boolean convertToTable(Object[][] data, String[] names){
      return true;
  }
  /*
  private void borrarTodos() {
     for (int i = 0; i < listaAtributos.size(); i++) {
          atributo = (Atributo) listaAtributos.elementAt(i);
          if (atributo != null)
            atributo.escribirValor("");
      }
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
   */
}
