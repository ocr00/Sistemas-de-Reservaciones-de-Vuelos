package reservaciones.servicios.consultas.estado;

import reservaciones.principal.*;
import reservaciones.interfaceUsuario.*;
import reservaciones.servicios.consultas.*;

public class ManejadorConsultaEstado extends Manejador {
  private Pantalla pantallaConsultaEstado;
  private Pantalla pantallaResultadoEstado;
  public ManejadorConsultaEstado(Manejador m,InterfaceUsuario ui) {
    super(m,ui);
  }
  // Contrato 1: Manejar Evento
  public void manejarEvento(String str) {
    if (str.equals("Consultar"))
      consultarEstado();
    else if (str.equals("Nueva Consulta"))
       consultar();
    else
      manejarEventosAdicionales(str);
  }
  // Contrato 2: Consultar
  public void consultar() {
    pantallaConsultaEstado = crearPantalla("PantallaConsultaEstado");
    desplegarPantalla(pantallaConsultaEstado);
  }
  // Responsabildiades Privadas
  private void consultarEstado() {
    pantallaResultadoEstado = crearPantalla("PantallaResultadoEstado");
    desplegarPantalla(pantallaResultadoEstado);
  }
}

