package reservaciones.servicios.reservas;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.pagos.*;
import reservaciones.servicios.*;

public class ManejadorReservas extends Manejador {
  private Pantalla pantallaClaveReservas;
  private Pantalla pantallaCrearReservaVuelos;
  private Pantalla pantallaRecordReservaVuelos;
  private ManejadorPagos mp;

  public ManejadorReservas(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
  }
  // Contrato 1
  public void manejarEvento(String str) {
    if (str.equals("Crear"))
      crear();
    else if (str.equals("Obtener"))
      obtener();
    else if (str.equals("Reservar"))
      obtener();
    else if (str.equals("Agregar"))
      ;
    else if (str.equals("+"))
      ;
    else if (str.equals("-"))
      ;
    else if (str.equals("Eliminar"))
      eliminar();
    else if (str.equals("Actualizar"))
      actualizar();
    else if (str.equals("Nueva Reserva"))
      crear();
    else if (str.equals("Pagar"))
      pagar();
    else if (str.equals("Reembolsar"))
      reembolsar();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Reservar
  public void reservar() {
    pantallaClaveReservas = crearPantalla("PantallaClaveReservas");
    desplegarPantalla(pantallaClaveReservas);
  }
  // Responsabilidades Privadas
  private void crear() {
    pantallaCrearReservaVuelos = crearPantalla("PantallaCrearReservaVuelos");
    desplegarPantalla(pantallaCrearReservaVuelos);
  }
  private void obtener() {
    pantallaRecordReservaVuelos = crearPantalla("PantallaRecordReservaVuelos");
    desplegarPantalla(pantallaRecordReservaVuelos);
  }
  private void actualizar() {
  }
  private void eliminar() {
  }
  private void pagar() {
    if (mp == null)
       mp = new ManejadorPagos(this,interfaceUsuario);
    mp.pagar();
	}
  private void reembolsar() {
    if (mp == null)
       mp = new ManejadorPagos(this,interfaceUsuario);
    mp.reembolsar();
  }
}


