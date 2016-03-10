package reservaciones.interfaceUsuario;

import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.util.*;
import java.util.*;

public class Pantalla {
  protected InterfaceUsuario interfaceUsuario;
  protected Manejador manejador;

  protected String classname;
  protected String classpath;

  public Pantalla() {
    classpath = Utilerias.getClassPath(this);
    classname = Utilerias.getClassName(this);
  }
  protected Pantalla(InterfaceUsuario ui,Manejador m) {
    this();
    interfaceUsuario = ui;
    manejador = m;
  }
  public void inicializarInterfaceUsuario(){}
  // crear elementos pantalla
  public void borrarPantalla() {}
  public void refrescarPantalla() {}
  public void crearPantalla() { }
  // Contrato 1: Desplegar Pantalla
  public void leerElementos(Datos datos) {}
  public void escribirElementos(Datos datos){}
  public void escribirElementos(DatosMultiples datos){}
  public String leerTexto(String name0) {return null;}
  public void escribirNombre(String str) { classname = str; }
  public String leerNombre() {     return classname; }
  public Manejador getManejador() { return manejador; }
  public void setInterfaceUsuario(InterfaceUsuario iu) { interfaceUsuario = iu; }
  public void setManejador(Manejador m) { manejador = m; }
}
