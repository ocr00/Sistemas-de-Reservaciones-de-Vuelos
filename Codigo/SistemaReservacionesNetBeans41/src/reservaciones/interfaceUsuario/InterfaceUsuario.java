package reservaciones.interfaceUsuario;

import java.awt.*;
import java.awt.event.*;

import reservaciones.principal.*;
import reservaciones.dominio.*;

public abstract class InterfaceUsuario {
    
  	protected Manejador manejador;
  	protected Pantalla pantalla;
/**
 * Insert the method's description here.
 * Creation date: (10/24/2002 11:34:20 AM)
 */
public InterfaceUsuario() {}
  public InterfaceUsuario(Manejador m) {
    manejador = m;
  }
/**
 * Insert the method's description here.
 * Creation date: (10/23/2002 6:25:57 PM)
 * @param claspath java.lang.String
 * @param classname java.lang.String
 */
public abstract Pantalla crearPantalla(String claspath, String classname);
  // Contrato 1: Desplegar Pantalla
  public abstract void desplegarPantalla(Pantalla p);
/**
 * Insert the method's description here.
 * Creation date: (12/11/2002 12:53:00 PM)
 */
public void enviarEvento(String evento) {
	System.out.println("InterfaceUsuario Evento: "+evento);
    if (manejador != null)
      manejador.manejarEvento(evento);
    else
      System.out.println("Manejador nulo");
}
/**
 * Insert the method's description here.
 * Creation date: (10/28/2002 12:33:51 PM)
 * @param p reservaciones.interfaceUsuario.Pantalla
 * @param datos reservaciones.dominio.Datos
 */
public abstract void escribirElementos(Pantalla p, Datos datos);
public abstract void escribirElementos(Pantalla p, DatosMultiples datos);
/**
 * Insert the method's description here.
 * Creation date: (10/23/2002 6:52:52 PM)
 */
public void inicializar() {}
/**
 * Insert the method's description here.
 * Creation date: (10/28/2002 12:34:06 PM)
 * @param p reservaciones.interfaceUsuario.Pantalla
 * @param datos reservaciones.dominio.Datos
 */
public abstract void leerElementos(Pantalla p, Datos datos);
  // Otros metodos
  // public void setPantalla (Pantalla p) { pantalla = p; }
  public void setManejador (Manejador m) { manejador = m; }

/**
 * Insert the method's description here.
 * Creation date: (10/28/2002 11:17:45 AM)
 * @return java.lang.String
 * @param name java.lang.String
 */
public abstract String leerTexto(Pantalla p, String name) ;
}
