package reservaciones.servicios.pagos;

import reservaciones.principal.*;
import reservaciones.servicios.reservas.*;
import reservaciones.interfaceUsuario.*;

public class ManejadorPagos extends Manejador {
  private Pantalla pantallaPagarRegTarjeta;
  private Pantalla pantallaReembolsarRegTarjeta;
  private Pantalla pantallaRecordReservaVuelos;
  public ManejadorPagos(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
    mrs = (ManejadorReservas) m; // referencia al manejador reservas
  }
  // Contrato 1
  public void manejarEvento(String str) {
    if (str.equals("Pagar"))
      reservar();
    else if (str.equals("Reembolsar"))
      reservar();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Pagar
  public void pagar() {
    pantallaPagarRegTarjeta = crearPantalla("PantallaPagarRegTarjeta");
    desplegarPantalla(pantallaPagarRegTarjeta);
  }
  // Contrato 3: Reembolsar
  public void reembolsar() {
    pantallaReembolsarRegTarjeta = crearPantalla("PantallaReembolsarRegTarjeta");
    desplegarPantalla(pantallaReembolsarRegTarjeta);
  }
  // responsabilidades privadas
  private void reservar() {
    if (mrs != null)
      mrs.reservar();
  }
}



