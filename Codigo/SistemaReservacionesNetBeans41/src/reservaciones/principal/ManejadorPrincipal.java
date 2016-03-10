package reservaciones.principal;

import reservaciones.registro.usuario.*;
import reservaciones.servicios.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.pantallas.*;

public class ManejadorPrincipal extends Manejador {
        private Pantalla pantallaPrincipal;

public ManejadorPrincipal(InterfaceUsuario iu, boolean fg) {
    super(iu);
    app_flag = fg;	// true = App, false = Servlet
    db_flag = true; // true = BD, false = Archivos;

     ms = new ManejadorServicio(this,interfaceUsuario);
     mru = new ManejadorRegistroUsuario(this,interfaceUsuario);
     ms.setManejadorRegistroUsuario(mru);

     desplegarPantallaPrincipal();
}
        // Contrato 1: Manejar Evento
	public void manejarEvento(String str) {
          if (str.equals("Registrarse por Primera Vez"))
            manejarEventoRegistrar();
          else if (str.equals("OK")) {
            manejarEventoValidar();
          }
          else
            manejarEventosAdicionales(str);
        }
        // Responsabilidades Privadas
	private void desplegarPantallaPrincipal() {
  		pantallaPrincipal = crearPantalla("PantallaPrincipal");
		desplegarPantalla(pantallaPrincipal);
	}
	private void manejarEventoRegistrar() {
            if (mru != null)
              mru.crearRegistroUsuario();
            else
              System.out.println("No se ha inicializado el ManejadorRegistroUsuario");
    	}
	private void manejarEventoValidar() {
            String log = interfaceUsuario.leerTexto(pantalla,"login");
            String pass = interfaceUsuario.leerTexto(pantalla,"password");
            if (mru != null) {
              if (mru.validarRegistroUsuario(log,pass) == true)
                manejarEventoOfrecerServicio();
              else
                desplegarPantalla(pantalla);
            }
            else
              System.out.println("No se ha inicializado el ManejadorRegistroUsuario");
        }
}
