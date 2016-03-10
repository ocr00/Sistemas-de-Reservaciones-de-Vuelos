package reservaciones.interfaceUsuarioFrame;

import java.awt.*;
import java.awt.event.*;
import reservaciones.principal.*;
import reservaciones.dominio.*;
import reservaciones.util.*;
import reservaciones.pantallas.*;
import reservaciones.interfaceUsuario.*;

public class InterfaceUsuarioFrame extends InterfaceUsuario {

  private ReservacionesFrame frame;

  public InterfaceUsuarioFrame() {
    frame = new ReservacionesFrame(this);
    manejador = new ManejadorPrincipal(this,true); // true - app
  }
  public Pantalla crearPantalla(String classpath,String classname) {
    pantalla = (Pantalla) Utilerias.instanciarClase(classpath + "." + classname);
    pantalla.setInterfaceUsuario(this);
    pantalla.inicializarInterfaceUsuario();
    return pantalla;
  }
  public void desplegarPantalla(Pantalla p) {
    if (p != null) {
        pantalla = p;
    	if (frame != null)
      		frame.desplegarPantalla(p);
  	}
  	else
        System.out.println("Pantalla Nula");
  }
/**
 * Insert the method's description here.
 * Creation date: (10/28/2002 12:42:31 PM)
 * @param datos reservaciones.dominio.Datos
 */
  public void escribirElementos(Pantalla p,Datos datos) {
	if (p != null)
            p.escribirElementos(datos);
  }
  public void escribirElementos(Pantalla p,DatosMultiples datos) {
	if (p != null)
            p.escribirElementos(datos);
  }
  public Pantalla getPantalla () { return pantalla; }
  public ReservacionesFrame getReservacionesFrame() { return frame; }
/**
 * Insert the method's description here.
 * Creation date: (10/28/2002 12:37:16 PM)
 * @param p reservaciones.interfaceUsuario.Pantalla
 * @param datos reservaciones.dominio.Datos
 */
public void leerElementos(Pantalla p, Datos datos) {
	if (p != null)
            p.leerElementos(datos);
}
  /**
 * Insert the method's description here.
 * Creation date: (10/24/2002 12:06:51 PM)
 * @param args java.lang.String[]
 */
  public static void main(String[] args) {
	System.out.println("Starting System...");
        InterfaceUsuarioFrame iu = new InterfaceUsuarioFrame();
  }
  public void setManejador (Manejador m) { manejador = m; }
  public void setPantalla (Pantalla p) { pantalla = p; }

  public String leerTexto(Pantalla p,String str) {
      return p.leerTexto(str);
  }
}
