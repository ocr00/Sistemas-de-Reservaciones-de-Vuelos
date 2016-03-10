package reservaciones.principal;

import reservaciones.interfaceUsuario.*;
import reservaciones.dominio.*;
import reservaciones.servicios.reservas.*;
import reservaciones.servicios.principal.*;
import reservaciones.registro.usuario.*;
import reservaciones.pantallas.*;
import reservaciones.util.*;
import java.util.*;

public abstract class Manejador {

    protected InterfaceUsuario interfaceUsuario;
    protected Pantalla pantalla;
    protected ManejadorReservas mrs;
    protected ManejadorServicio ms;
    protected ManejadorRegistroUsuario mru;
    protected Manejador mPadre;
    protected String classpath;

    static protected boolean db_flag; // true - usando BD, false - usando archivos
    static protected boolean app_flag; // true - usando aplicación normal, false - usando cliente-servidor

    public Manejador() {
      classpath = "reservaciones.pantallas"; // Utilerias.getClassPath(this);
    }
/**
 * Insert the method's description here.
 * Creation date: (10/24/2002 11:25:30 AM)
 * @param iu reservaciones.interfaceUsuario.InterfaceUsuario
 */
public Manejador(InterfaceUsuario iu) {
    this();
    interfaceUsuario = iu;
}
public Manejador(Manejador m,InterfaceUsuario ui) {
    this(ui);
    mPadre = m;
    if (mPadre != null)
         ms = mPadre.getManejadorServicio();
}
protected Pantalla crearPantalla(String name) {
    System.out.println("Creando: "+classpath+"."+name);
    return interfaceUsuario.crearPantalla(classpath,name);
}
protected void desplegarPantalla(Pantalla p) {
    if (p != null) {
          pantalla = p;
          p.setManejador(this);
          interfaceUsuario.setManejador(this); // p.getManejador()
          interfaceUsuario.desplegarPantalla(p);
    }
    else
          System.out.print("Pantalla Nula");
}
	protected void escribirElementos(Pantalla p,Datos datos) {
 		interfaceUsuario.escribirElementos(p,datos);
	}
        protected void escribirElementos(Pantalla p,DatosMultiples datos) {
 		interfaceUsuario.escribirElementos(p,datos);
	}
        public ManejadorRegistroUsuario getManejadorRegistroUsuario(){
                return mru;
        }
        // Otras Responsabilidades Publicas
        public ManejadorServicio getManejadorServicio() {
                return ms;
        }
	public Pantalla getPantalla() {
		return pantalla;
	}
	protected void leerElementos(Pantalla p,Datos datos) {
 		interfaceUsuario.leerElementos(p,datos);
	}
        // Contrato 1: Manejar Evento
        public abstract void manejarEvento(String str);
        protected void manejarEventoOfrecerServicio() {
            if (ms != null)
                ms.ofrecerServicio();
            else
                System.out.println("No se ha inicializado el ManejadorServicios");
        }
        protected void manejarEventosAdicionales(String str) {
                if (str.equals("Servicios"))
                    manejarEventoOfrecerServicio();
                else if (str.equals("Salir"))
                    manejarEventoSalir();
                else
                    System.out.println("Error en pantalla: "+this+", Evento: "+str);
        }
        protected void manejarEventoSalir() {
            if (app_flag == true)
				System.exit(0);
            else
            	interfaceUsuario.inicializar();
        }
	protected void print(Vector lista) {
		int n = lista.size();
		for (int i = 0; i < n; i++) {
			Datos datos = (Datos) lista.elementAt(i);
                        datos.printAll();
		}
	}
        public void setManejadorRegistroUsuario(ManejadorRegistroUsuario m){
                mru = m;
        }
        public void setManejadorServicio(ManejadorServicio m) {
                ms = m;
        }
	public void setPantalla(Pantalla p) {
		pantalla = p;
	}
}
