package reservaciones.registro.tarjeta;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.registro.usuario.*;
import reservaciones.registro.interfaceBD.*;
import java.util.*;

public class ManejadorRegistroTarjeta extends Manejador {

  private Pantalla pantallaCrearRegTarjeta;
  private Pantalla pantallaObtenerRegTarjeta;
  private String idRegistro;
  private RegistroTarjeta registroTarjeta;
  private InterfaceRegistro interfaceRegistro;

  public ManejadorRegistroTarjeta(Manejador m,InterfaceUsuario ui) {
          super(m,ui);
      registroTarjeta = new RegistroTarjeta();
      interfaceRegistro = ((ManejadorRegistroUsuario) m).getInterfaceRegistro();
      if (interfaceRegistro == null)  {
          if (db_flag == true)
              interfaceRegistro = new InterfaceBaseDatosRegistro();
          else
              interfaceRegistro = new InterfaceArchivoRegistro();
      }
  }
  // Contrato 1
  public void manejarEvento(String str) {
      if (str.equals("Registrar"))
          manejarEventoRegistrar();
      else if (str.equals("Actualizar"))
          manejarEventoActualizar();
      else if (str.equals("Eliminar"))
          manejarEventoEliminar();
      else
          manejarEventosAdicionales(str);
    }
  // Contrato 2
  public void registrarTarjeta(String log) {
      idRegistro = log;
      if (registroTarjeta == null)
         registroTarjeta = new RegistroTarjeta();
      boolean fg = obtenerRegistroTarjeta(log);
      if (fg == false)
         crearRegistroTarjeta();
      else
         administrarRegistroTarjeta();
  }
  // Responsabilidades Privadas
  private boolean obtenerRegistroTarjeta(String log) {
      return interfaceRegistro.obtenerRegistro(registroTarjeta,log);
  }
  private void crearRegistroTarjeta() {
      pantallaCrearRegTarjeta = crearPantalla("PantallaCrearRegTarjeta");
      desplegarPantalla(pantallaCrearRegTarjeta);
  }
  private void administrarRegistroTarjeta() {
      pantallaObtenerRegTarjeta = crearPantalla("PantallaObtenerRegTarjeta");
      escribirElementos(pantallaObtenerRegTarjeta,registroTarjeta);
      desplegarPantalla(pantallaObtenerRegTarjeta);
  }
  private void manejarEventoRegistrar() {
       if (registroTarjeta == null)
         registroTarjeta = new RegistroTarjeta();
      registroTarjeta.escribirValor(0,idRegistro);
      leerElementos(pantalla,registroTarjeta);
      interfaceRegistro.crearRegistro(registroTarjeta);
      administrarRegistroTarjeta();
  }
  private void manejarEventoActualizar() {
      if (registroTarjeta == null)
         registroTarjeta = new RegistroTarjeta();
      leerElementos(pantalla,registroTarjeta);
      interfaceRegistro.actualizarRegistro(registroTarjeta);
  }
  private void manejarEventoEliminar() {
      if (registroTarjeta == null)
	System.out.println("Registro Invalido");
      else {
            interfaceRegistro.eliminarRegistro(registroTarjeta);
            crearRegistroTarjeta();
      }
  }
}

